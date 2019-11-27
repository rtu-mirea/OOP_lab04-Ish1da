package com.sanya;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class FileObjectHandler {
    private String filePath = "C:\\Users\\shiha\\Desktop\\Java\\OOP_lab04-coalaboooy-master\\T4\\Serialized object.bin";
    private String fileCollectionPath = "C:\\Users\\shiha\\Desktop\\Java\\OOP_lab04-coalaboooy-master\\T4\\Serialized collection.bin";
    private ArrayList<Syllabus> sylsList = new ArrayList<>();

    FileObjectHandler (String filePath) {
        try {
            if (!new File(filePath).createNewFile())
                System.out.println("Файл уже существует!");
            else
                this.filePath = filePath;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    void outputTest() throws IOException {
        //Создание и заполнение объекта класса Test
        Syllabus output = new Syllabus();
        output.setnNumber();
        output.setnName();
        output.setWork();
        output.setpNumber();
        output.setpName();
        output.setYear();

        //Запись в файл
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
        out.writeInt(output.getnNumber());
        out.writeUTF(output.getnName());
        out.writeUTF(output.getWork());
        out.writeInt(output.getpNumber());
        out.writeUTF(output.getpName());
        out.writeUTF(output.getYear());

        //Закрытие потока
        out.close();
    }

    void inputTest () throws IOException {
        //Создание потока для считывания
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));

        //Считывание из файла в новый объект класса Test
        int nNumber = in.readInt();
        String nName = in.readUTF();
        String work = in.readUTF();
        int pNumber = in.readInt();
        String pName = in.readUTF();
        String year = in.readUTF();
        Syllabus input = new Syllabus(nNumber, nName, work, pNumber, pName, year);

        //Проверка
        System.out.println("Info about test: "+input.getpNumber()+" "+input.getpName()+" "+input.getWork()
                +" "+input.getpNumber()+" "+input.getpName()+" "+input.getYear());
        in.close();
    }

    void addToCollection() {
        Scanner in = new Scanner(System.in);
        System.out.println("How many tests you want to add? (Positive integer number)");
        int num = in.nextInt();
        assert num > 0;

        //Создание объектов и добавление их в коллекцию
        for (int i = 0; i < num; i++) {
            Syllabus S = new Syllabus();
            S.setnNumber();
            S.setnName();
            S.setWork();
            S.setpNumber();
            S.setpName();
            S.setYear();
            sylsList.add(S);
        }
    }

    void outputCollection() throws IOException {
        //Создание потока для записи
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileCollectionPath));

        //Запись в файл
        for (Syllabus S : sylsList) {
            out.writeInt(S.getnNumber());
            out.writeUTF(S.getnName());
            out.writeUTF(S.getWork());
            out.writeInt(S.getpNumber());
            out.writeUTF(S.getpName());
            out.writeUTF(S.getYear());
        }

        //Закрытие потока
        out.close();
    }

    void inputCollection() throws IOException {
        //Созданеи потока для чтения
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileCollectionPath));
        int pts;

        //Чтение и добавление в коллекцию
        sylsList.clear();
        while(true) {
            try {
                int nNumber = in.readInt();
                String nName = in.readUTF();
                String work = in.readUTF();
                int pNumber = in.readInt();
                String pName = in.readUTF();
                String year = in.readUTF();
                sylsList.add(new Syllabus(nNumber, nName, work, pNumber, pName, year));
            } catch (EOFException e) {
                in.close();
                break;
            }
        }
    }

    void printCollection() {
        for (Syllabus S : sylsList) {
            System.out.println(S.getpNumber()+" "+S.getpName()+" "+S.getWork()
                    +" "+S.getpNumber()+" "+S.getpName()+" "+S.getYear());
        }
    }

    FileObjectHandler getObject() {
        return this;
    }

    ArrayList<Syllabus> getCollection() {
        return sylsList;
    }
}
