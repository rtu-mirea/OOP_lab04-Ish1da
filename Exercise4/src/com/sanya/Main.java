package com.sanya;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(" ___ \n"+
                    "task 1:");
            TextFile first = new TextFile("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T4\\Raw data file.bin");
            Syllabus one = first.setTestInfo();
            System.out.println("Информация об учебном плане: "+one.getpNumber()+" "+one.getpName()+" "+one.getWork()
                    +" "+one.getpNumber()+" "+one.getpName()+" "+one.getYear());
            System.out.println(" ___ \n"+
                    "task 2:");
            FileObjectHandler second = new FileObjectHandler("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T4\\Serialized object.bin");
            second.outputSyl();
            second.inputSyl();
            System.out.println(" ___ \n"+
                    "task 3:");
            FileObjectHandler third = new FileObjectHandler("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T4\\Serialized collection.bin");
            third.addToCollection();
            System.out.println("Коллекция после добавления объектов:");
            third.printCollection();

            third.outputCollection();
            third.inputCollection();
            System.out.println("Коллекция после сериализации/десериализации:");
            third.printCollection();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
