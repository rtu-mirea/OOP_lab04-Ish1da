package com.sanya;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        try {
            Task1();
            Task2();
            Task3();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    private static void Task1() throws IOException {

        FileReader in = new FileReader("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T3\\T1.txt");
        FileWriter out = new FileWriter("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T3\\T2.txt");


        int chrs = in.read();
        while (chrs != -1) {
            out.write(chrs);
            chrs = in.read();
        }


        in.close();
        out.close();
    }

    private static void Task2() throws IOException {

        BufferedReader inb = new BufferedReader
                (new FileReader("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T3\\A.txt"),128);
        BufferedWriter outb = new BufferedWriter
                (new FileWriter("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T3\\B.txt"),128);
        char[] buf = new char[128];


        for (int i = 0; i < 4; i++) {
            inb.read(buf);
            outb.write(buf);
            if (i != 3) outb.write("\n");
        }


        inb.close();
        outb.close();
    }

    private static void Task3() throws IOException {
        System.out.println("Стандартная кодировка системы - "+Charset.defaultCharset().name());


        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream
                ("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T3\\R.txt"),"Cp1251"));


        String line = in.readLine();
        System.out.println(line+"\nОшибка, символы в файле используют другую кодировку, повторим считывание с правильной кодировкой:");


        in.close();


        in = new BufferedReader(new InputStreamReader(new FileInputStream
                ("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T3\\R.txt"), StandardCharsets.UTF_8));


        line = in.readLine();
        System.out.println(line+"\nТеперь считанные символы выводятся правильно");


        in.close();

        System.out.println("В файле text.txt, созданном с помощью проводника используется кодировка UTF-8");
    }
}
