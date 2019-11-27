package com.sanya;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

class FileConstructor {

    private static LinkedList<Syllabus> sameYearSyl = new LinkedList<>();

    static File createFile() throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя файла:");
        File output = new File(String.format("%s.bin", in.nextLine()));
        output.createNewFile();
        System.out.println(String.format("\"Файл с названием %s существует\" %b", output.getName(), output.exists()));
        return output;
    }

    static void fileOutput(File output) throws IOException {
        Scanner in = new Scanner(System.in);

        DataOutputStream out = new DataOutputStream(new FileOutputStream(output));

        System.out.println("Введите виды деятельности учебных планов через ';'");
        String[] works = in.nextLine().split(";");

        for (String work : works) {
            System.out.println("Введите информацию о виде деятельности " + work + " в следующем виде:\nШифр направления\nНазвание направления" +
                    "\nШифр профиля\nНазвание профиля\nГод начала действия УП");
            int nNumber = in.nextInt();
            in.nextLine();
            String nName = in.nextLine();
            int pNumber = in.nextInt();
            in.nextLine();
            String pName = in.nextLine();
            String year = in.nextLine();

            Syllabus syl = new Syllabus(nNumber, nName, work, pNumber, pName, year);

            out.writeInt(syl.getnNumber());
            out.writeUTF(syl.getnName());
            out.writeUTF(syl.getWork());
            out.writeInt(syl.getpNumber());
            out.writeUTF(syl.getpName());
            out.writeUTF(syl.getYear());
            out.flush();
        }
        out.close();
    }

    static void fileInput(File input) throws IOException {
        DataInputStream inp = new DataInputStream(new FileInputStream(input));
        LinkedList<Syllabus> syls = new LinkedList<>();

        while (true) {
            try {
                Syllabus S = new Syllabus(inp.readInt(), inp.readUTF(), inp.readUTF(), inp.readInt(), inp.readUTF(), inp.readUTF());
                syls.add(S);
            } catch (EOFException e) {
                inp.close();
                break;
            }
        }
        for (Syllabus s1 : syls){
            for(Syllabus s2 : syls){
                if(s1.equalsByYear(s2)){
                    sameYearSyl.add(s1);
                    break;
                }
            }
        }
    }

    static File makeNewSylFile(File source) throws IOException {
        File destination = new File(source.getName().replace(".bin", "")+"_Sorted.bin");
        destination.createNewFile();
        RandomAccessFile rStream = new RandomAccessFile(source, "r");
        RandomAccessFile wStream = new RandomAccessFile(destination, "rw");

        int nNumber;
        String nName;
        String work;
        int pNumber;
        String pName;
        String year;

        while (true) {
            try {

                nNumber = rStream.readInt();
                nName = rStream.readUTF();
                work = rStream.readUTF();
                pNumber = rStream.readInt();
                pName = rStream.readUTF();
                year = rStream.readUTF();
                for (Syllabus original : sameYearSyl) {
                    if (original.getnNumber() == nNumber && original.getnName().equals(nName) &&
                            original.getWork().equals(work) && original.getpNumber() == pNumber &&
                            original.getpName().equals(pName) && original.getYear().equals(year)) {
                        wStream.writeInt(nNumber);
                        wStream.writeUTF(String.format("%-20s", nName));
                        wStream.writeUTF(String.format("%-20s", work));
                        wStream.writeInt(pNumber);
                        wStream.writeUTF(String.format("%-20s", pName));
                        wStream.writeUTF(String.format("%-20s", year));
                    }
                }
            } catch (EOFException e) {
                rStream.close();
                wStream.close();
                break;
            }
        }
        return destination;
    }

    static String findByNum(File source, int n1, int n2) throws IOException {
        RandomAccessFile rStream = new RandomAccessFile(source, "r");

        while (true) {
            try {
                int nNumber = rStream.readInt();
                String nName = rStream.readUTF();
                String work = rStream.readUTF();
                int pNumber = rStream.readInt();
                String pName = rStream.readUTF();
                String year = rStream.readUTF();
                if (nNumber == n1 && pNumber == n2) {
                    return work;
                }
            } catch (EOFException e) {
                rStream.close();
                break;
            }
        }
        return "not found";
    }

    static void changeProfileName(File subject) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер учебного плана, который необходимо изменить:");
        int n = in.nextInt();
        int m = 1;

        if (n < 0) {
            throw new IOException("A number can't be less than zero!");
        }
        else {
            RandomAccessFile rwStream = new RandomAccessFile(subject, "rw");
            while (true) {
                try {
                    rwStream.readInt();
                    rwStream.readUTF();
                    rwStream.readUTF();
                    rwStream.readInt();
                    if(m==n){
                        rwStream.writeUTF("changed by user");
                    }
                    else {
                        rwStream.readUTF();
                    }
                    rwStream.readUTF();
                    m+=1;
                } catch (EOFException e) {
                    rwStream.close();
                    break;
                }
            }
        }
    }
}
