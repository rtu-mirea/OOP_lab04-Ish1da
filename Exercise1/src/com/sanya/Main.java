package com.sanya;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Task1();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void Task1() throws IOException {


        File MyFile1 = new File("MyFile1.bin");
        MyFile1.createNewFile();
        if (MyFile1.exists())
            System.out.println("Файл " + MyFile1.getName() + " создан успешно");
        else
            System.out.println("Ошибка, файл не создан!");


        String sep = File.separator;
        String absolutePath = "C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T1\\src\\com\\sanya";
        File MyFile2 = new File(absolutePath, "MyFile2.bin");
        MyFile2.createNewFile();
        if (MyFile2.exists())
            System.out.println("Файл " + MyFile2.getName() + " создан успешно");
        else
            System.out.println("Ошибка, файл не создан!");


        File MyFile3 = new File("C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T1\\src\\com\\sanya", "MyFile3.bin");
        MyFile3.createNewFile();
        if (MyFile3.exists())
            System.out.println("Файл " + MyFile3.getName() + " создан успешно");
        else
            System.out.println("Ошибка, файл не создан!");


        File MyDir1 = new File(absolutePath, "TestDir");
        MyDir1.mkdir();
        if (MyDir1.exists() && MyDir1.isDirectory())
            System.out.println("Папка " + MyDir1.getName() + " создана успешно");
        else
            System.out.println("Ошибка, папка не создана!");

        System.out.println();
        Task2(MyFile1, MyFile2, MyFile3, MyDir1);
        Task3(MyFile1, MyFile2, MyFile3, MyDir1);
    }

    private static void Task2(File f1, File f2, File f3, File d1) {

        if (f3.isFile())
            System.out.println(f3.getName() + " - файл");

        if (d1.isDirectory())
            System.out.println(d1.getName() + " - папка");


        if (f1.exists())
            System.out.println("Файл " + f1.getName() + " находится в папке приожения");
        else
            System.out.println("Ошибка, файла в папке приложения нет!");


        System.out.println("Полный путь к файлу " + f3.getName() + ": " + f3.getAbsolutePath());


        System.out.println("Файл " + f2.getName() + " занимает " + f2.length() + " байтов\n");
    }

    private static void Task3(File f1, File f2, File f3, File d1) {
        String sep = File.separator;
        String absoluteAppPath = "C:\\Users\\IVC5-8\\Downloads\\Lab4\\OOP_lab04-ishida-master\\T1\\src\\com\\sanya";


        File MyDir2 = new File(absoluteAppPath, "MyDir2");
        MyDir2.mkdir();


        System.out.println("Список файлов в папке приложения " + Arrays.toString(MyDir2.getParentFile().list()));


        File[] files = MyDir2.getParentFile().listFiles();
        assert files != null;
        int dirCounter = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getAbsolutePath() + " - папка");
                dirCounter++;
            } else
                System.out.println(file.getAbsolutePath() + " - файл");
        }
        System.out.println("В папке приложения " + dirCounter + " папок");


        System.out.println("\nНажмите ENTER, чтобы удалить все созданные папки и файлы");
        Scanner wait = new Scanner(System.in);
        wait.nextLine();
        f1.delete();
        f2.delete();
        f3.delete();
        d1.delete();
        MyDir2.delete();
    }
}
