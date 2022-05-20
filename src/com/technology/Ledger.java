package com.technology;

import javax.swing.*;

public class Ledger extends JFrame {

    private JPanel layout;
    private JTextArea textArea1;
    private JButton clearTransactionsButton;

    public Ledger(){
        setContentPane(layout);
        setTitle("Payment Ledger");
        setSize(450,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
