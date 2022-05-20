package com.technology;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame {
    private JPanel layout;
    private JLabel descriptionString;
    private JButton clear;
    private JButton pay;
    private JTextField descriptionValue;
    private JTextField amountValue;
    private JLabel amountString;
    private JTextField coinValue;
    private JButton calculateCoinsButton;
    private JTextArea totalCoinTxt;

    Main main = new Main();
    long totalCoins = 0;

    public void getCoinVal(String coinamount){
        long newcoinamount = Long.parseLong(coinamount);
        long calCoin = totalCoins + newcoinamount;
        String coinVal = String.valueOf(calCoin);
        totalCoins = calCoin;
        totalCoinTxt.setText(coinVal);
    }
    public Transaction() {
        setContentPane(layout);
        setTitle("Payment Description");
        setSize(450,300);
        descriptionValue.setSize(100,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = descriptionValue.getText();
                String amount = amountValue.getText();
                String equivalentCoinAmount = coinValue.getText();
                main.addToBlockChain(description,amount);
                getCoinVal(equivalentCoinAmount);
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                descriptionValue.setText("");
                amountValue.setText("");
                coinValue.setText("");
                //totalCoinTxt.setText(coinVal);
            }
        });
        calculateCoinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long amount = Long.parseLong(amountValue.getText());
                Long equivalentAmount = amount / 500;
                System.out.println(equivalentAmount);
                coinValue.setText(equivalentAmount.toString());
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
