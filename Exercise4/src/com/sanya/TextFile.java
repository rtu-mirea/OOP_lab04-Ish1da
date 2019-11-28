package com.sanya;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class TextFile {
    private String filePath = "C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T4\\Raw data file.bin";

    //Конструктор
    TextFile (String filePath) {
        try {
            if (!new File(filePath).createNewFile())
                System.out.println("Файл уже существует!");
            else
                this.filePath = filePath;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    Syllabus setTestInfo() throws FileNotFoundException {
        Scanner fileIn = new Scanner(new FileReader(filePath));
        int nNumber = fileIn.nextInt();
        //fileIn.nextLine();
        String nName = fileIn.next();
        String work = fileIn.next();
        int pNumber = fileIn.nextInt();
        //fileIn.nextLine();
        String pName = fileIn.next();
        String year = fileIn.next();
        return new Syllabus(nNumber, nName, work, pNumber, pName, year);
    }
}
