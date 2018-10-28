package dictionary;


import java.util.Scanner;


public class DictionaryCommandline {

        private DictionaryManagement DM = new DictionaryManagement();

        public void showAllWords() {
            System.out.println("No     | English                            | Vietnamese");
            System.out.println("--------------------------------------------------------------------------");
            for (int i = 0; i < Dictionary.listWords.size(); ++i) {
                Word temp = Dictionary.listWords.get(i);
                System.out.printf("%-7d| %-35s| %-35s", i + 1, temp.getWord_target(), temp.getWord_explain());
                System.out.println();
            }
        }

        public void dictionaryBasic() {
            this.DM.insertFromCommandline();
            this.showAllWords();
        }

        public void dictionaryAdvanced() {
            this.DM.insertFromFile();
            String check;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an action: ");
            do {
                System.out.println("(1)Show all words      (2)Insert word         (3)Lookup              (4)Search word");
                System.out.println("(5)Modify word         (6)Delete word         (7)Export to file      (8)Exit");
                System.out.print("Insert action code: ");
                check = scanner.nextLine();
                if (check.equals("1")) {
                    showAllWords();
                } else if (check.equals("2")) {
                    this.DM.insertFromCommandline();
                } else if (check.equals("3")) {
                    this.DM.dictionaryLookup();
                } else if (check.equals("4")) {
                    dictionarySearcher();
                } else if (check.equals("5")) {
                    this.DM.dictionaryModify();
                } else if (check.equals("6")) {
                    this.DM.wordDelete();
                } else if (check.equals("7")) {
                  //  this.DM.dictionaryExportToFile();
                } else {
                    break;
                }
            }
            while (check.equals("1") || check.equals("2") || check.equals("3") || check.equals("4") || check.equals("5") || check.equals("6") || check.equals("7") || check.equals("8"));
//        this.showAllWords();
//        this.DM.dictionaryLookup();
        }

        public void dictionarySearcher() {
            String check;
            do {
                System.out.println("Nhap vao tu ban muon tim kiem: ");
                Scanner scanner = new Scanner(System.in);
                String temp = scanner.nextLine().toLowerCase();
                boolean flag = false;
                for (int i = 0; i < Dictionary.listWords.size(); ++i) {
                    if (Dictionary.listWords.get(i).getWord_target().length() >= temp.length())
                        if (Dictionary.listWords.get(i).getWord_target().substring(0, temp.length()).equals(temp)) {
                            System.out.println(Dictionary.listWords.get(i).getWord_target());
                            flag = true;
                        }
                }
                if (flag == false) {
                    System.out.println("Khong co tu nao bat dau bang \"" + temp + "\"!");
                }
                System.out.print("Do you want to search more? [Y/N] ");
                check = scanner.nextLine();
            } while (check.equals("Y") || check.equals("y"));
        }
    }

