package dictionary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.GroupLayout;
import java.awt.Container;import java.awt.event.ComponentAdapter;
import java.util.Scanner;

import static dictionary.Dictionary.*;



public class DicGUI extends JFrame {

    private DictionaryManagement DM = new DictionaryManagement();

    private JPanel GuiForm;
    private JButton quitButtonButton;
    private JButton insertButton;
    private JButton modifyButton;
    private JButton DeleteWord;
    private JButton exportButton;
    private JButton searchButton;
    private JTextPane textPane1;
    private JTextArea textArea1;

    public DicGUI() {

        //DM.insertFromFile();
        //DM.dictionaryLookup();
        //DM.wordDelete();

        add(GuiForm);
        setTitle("Double P Dict");
        setSize(600, 300);
        setLocationRelativeTo(null); // hien thi cua so len vi tri giua man hinh
        setDefaultCloseOperation(EXIT_ON_CLOSE); // tat = nut X tren thanh tieu de


        quitButtonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        DeleteWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { // chay chuong trinh trong 1 luong do EventQueue quan li
            @Override
            public void run() {
                DicGUI dic = new DicGUI();
                dic.setVisible(true);
            }
        });
    }
}


