package dictionary;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.lang.String;

public class DictionaryManagement {
    public void insertFromCommandline() {
        Scanner scanWord = new Scanner(System.in);
        String eng, vn;
        String check;
        boolean flag = false;
        do {
            flag = false;
            System.out.print("Insert English word: ");
            eng = scanWord.nextLine().toLowerCase();
            for (int i = 0; i < Dictionary.listWords.size(); ++i) {
                Word temp = Dictionary.listWords.get(i);
                if (temp.getWord_target().equals(eng)) flag = true;
            }
            if (flag == true) {
                System.out.println("Tu ban muon nhap da co trong tu dien!");
            } else {
                System.out.print("Insert meaning of " + eng + " in Vietnamese: ");
                vn = scanWord.nextLine().toLowerCase();
                Word newWord = new Word(eng, vn);
                Dictionary.listWords.add(newWord);
            }
            System.out.print("Do you want to insert more? [Y/N] ");
            check = scanWord.nextLine();
        } while (check.equals("Y") || check.equals("y"));
    }

    public static void insertFromFile() {
        try {
            File input = new File("src\\dictionary\\dictionaries.txt");
            FileReader inp = new FileReader(input);
            BufferedReader reader = new BufferedReader(inp);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] getWord = line.split("\t");
                String eng = getWord[0].toLowerCase();
                String vn = getWord[1].toLowerCase();
                Word word = new Word(eng, vn);
                Dictionary.listWords.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Something happened.");
        }
//        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
//        dictionaryCommandline.showAllWords();
    }

    public void dictionaryLookup() {
        String check;
        do {
            System.out.println("Nhap vao mot tu: ");
            Scanner scanner = new Scanner(System.in);
            String temp = scanner.nextLine().toLowerCase();
            boolean flag = false;
            for (int i = 0; i < Dictionary.listWords.size(); ++i) {
                if (Dictionary.listWords.get(i).getWord_explain().equals(temp)) {
                    System.out.println("Nghia tieng Anh cua \"" + temp + "\" la \"" + Dictionary.listWords.get(i).getWord_target() + "\".");
                    flag = true;
                } else if (Dictionary.listWords.get(i).getWord_target().equals(temp)) {
                    System.out.println("Nghia tieng Viet cua \"" + temp + "\" la \"" + Dictionary.listWords.get(i).getWord_explain() + "\".");
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Tu ban can tim kiem khong co trong tu dien.");
            }
            System.out.print("Do you want to search more? [Y/N] ");
            check = scanner.nextLine();
        } while (check.equals("Y") || check.equals("y"));
    }

    public void dictionaryModify() {
        String check;
        do {
            String check2;
            System.out.println("Nhap vao tu ban muon sua: ");
            Scanner scanner = new Scanner(System.in);
            String temp = scanner.nextLine().toLowerCase();
            boolean flag = false;
            for (int i = 0; i < Dictionary.listWords.size(); ++i) {
                if (Dictionary.listWords.get(i).getWord_target().equals(temp)) {
                    System.out.println("Nghia tieng Viet cua \"" + temp + "\" hien tai la \"" + Dictionary.listWords.get(i).getWord_explain() + "\".");
                    System.out.println("Ban muon sua nghia cua \"" + temp + "\" thanh: ");
                    String newExplain = scanner.nextLine();
                    Dictionary.listWords.get(i).setWord_explain(newExplain);
                    System.out.println("Done!");
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Tu ban can sua khong co trong tu dien. Ban co muon them tu moi khong? [Y/N]");
                check2 = scanner.nextLine();
                if (check2.equals("Y") || check2.equals("y")) {
                    insertFromCommandline();
                }
            }
            System.out.print("Do you want to modify more? [Y/N] ");
            check = scanner.nextLine();
        } while (check.equals("Y") || check.equals("y"));
    }

    public void wordDelete() {
        String check;
        do {
            String check2;
            System.out.println("Nhap vao tu ban muon xoa: ");
            Scanner scanner = new Scanner(System.in);
            String temp = scanner.nextLine().toLowerCase();
            boolean flag = false;
            for (int i = 0; i < Dictionary.listWords.size(); ++i) {
                if (Dictionary.listWords.get(i).getWord_target().equals(temp)) {
                    Dictionary.listWords.remove(i);
                    System.out.println("Xoa thanh cong!");
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("Tu ban muon xoa khong co trong tu dien.");
            }
            System.out.print("Do you want to delete another word? [Y/N] ");
            check = scanner.nextLine();
        } while (check.equals("Y") || check.equals("y"));
    }


    public void dictionaryExportToFile() throws IOException {
        BufferedWriter outputWriteer = null;
        outputWriteer = new BufferedWriter(new FileWriter("dictionaryExport.txt"));
        try {
            for (int i = 0; i < Dictionary.listWords.size(); i++) {
                Word tmp = Dictionary.listWords.get(i);

                outputWriteer.write(tmp.getWord_target() + "\t" + tmp.getWord_explain());
                outputWriteer.newLine();
            }
            outputWriteer.flush();
            outputWriteer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
