package com.technology;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class BlockData {
    private String hash;
    private String previousHash;
    private Data data;
    private long timeStamp;
    private int uniqueNonce;

    public BlockData(Data data, long timeStamp){
        this.data = data;
        this.timeStamp = timeStamp;
        this.hash = hashBlock();
        this.previousHash = "#####";
        mineBlock();

    }


    public BlockData(Data data, String previousHash, long timeStamp){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.hash = hashBlock();
        mineBlock();
    }

    public String mineBlock() {
        int prefix = 4;
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        while (!hash.substring(0, prefix).equals(prefixString)) {
            uniqueNonce++;
            hash = hashBlock();
        }
        return hash;
    }

    public String hashBlock() {
        String hashData = previousHash
                + Long.toString(timeStamp)
                + Integer.toString(uniqueNonce)
                + data;
        MessageDigest digest = null;
        byte[] bytes = null;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(hashData.getBytes(UTF_8));
        } catch (NoSuchAlgorithmException ex) {
           ex.printStackTrace();
        }

        StringBuffer hashedValue = new StringBuffer();
        for (byte i : bytes) {
            hashedValue.append(String.format("%02x", i));
        }
        return hashedValue.toString();
    }




    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getUniqueNonce() {
        return uniqueNonce;
    }

    public void setUniqueNonce(int uniqueNonce) {
        this.uniqueNonce = uniqueNonce;
    }
}
