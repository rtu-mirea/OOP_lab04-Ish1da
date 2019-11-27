package com.sanya;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class TextFile {
    private String filePath = "C:\\Users\\shiha\\Desktop\\Java\\OOP_lab04-coalaboooy-master\\T4\\Raw data file.bin";

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

    //Заполняет новый объект класса Test данными из файла
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
        System.out.println(nNumber);
        System.out.println(nName);
        System.out.println(work);
        System.out.println(pNumber);
        System.out.println(pName);
        System.out.println(year);
        return new Syllabus(nNumber, nName, work, pNumber, pName, year);
    }
}
