package com.technology;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {

    List<BlockData> blockChain = new ArrayList<BlockData>();
    public List<BlockData> addToBlockChain(String description, String amount){


        Data data = new Data(description,amount);
        if(blockChain.size() == 0){
            BlockData blockData = new BlockData(data,new Date().getTime());
            blockChain.add(blockData);
        }else{
            String previousHash = blockChain.get(blockChain.size()-1).getHash();
            BlockData newBlockData = new BlockData(data,previousHash,new Date().getTime());
            blockChain.add(newBlockData);
        }

        printOutChain();
        return blockChain;
    }

    public void printOutChain(){
        for(int i = 0; i < blockChain.size(); i++){
            System.out.println("=========== HASH VALUE ==============");
            System.out.println(blockChain.get(i).getHash());
            System.out.println("=========================");
            System.out.println("========== PREVIOUS HASH VALUE ===============");
            System.out.println(blockChain.get(i).getPreviousHash());
            System.out.println("=========================");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Main();
               Transaction transaction = new Transaction();
                Ledger ledger = new Ledger();




            }
        });

}


}
