package com.sanya;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("##################################################################################\n"+
                    "First task:");
            TextFile first = new TextFile("C:\\Users\\shiha\\Desktop\\Java\\OOP_lab04-coalaboooy-master\\T4\\Raw data file.bin");
            Syllabus one = first.setTestInfo();
            System.out.println("Info about test: "+one.getpNumber()+" "+one.getpName()+" "+one.getWork()
                    +" "+one.getpNumber()+" "+one.getpName()+" "+one.getYear());
            System.out.println("##################################################################################\n"+
                    "Second task:");
            FileObjectHandler second = new FileObjectHandler("C:\\Users\\shiha\\Desktop\\Java\\OOP_lab04-coalaboooy-master\\T4\\Serialized object.bin");
            second.outputTest();
            second.inputTest();
            System.out.println("##################################################################################\n"+
                    "Third task:");
            FileObjectHandler third = new FileObjectHandler("C:\\Users\\shiha\\Desktop\\Java\\OOP_lab04-coalaboooy-master\\T4\\Serialized collection.bin");
            third.addToCollection();
            System.out.println("Collection looks like this after addition of objects:");
            third.printCollection();
            third.outputCollection();
            third.inputCollection();
            System.out.println("Collection looks like this after write/read:");
            third.printCollection();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
