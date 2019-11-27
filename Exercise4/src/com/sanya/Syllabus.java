package com.sanya;

import java.util.Scanner;

public class Syllabus {
    private int nNumber;
    private String nName;
    private String work;
    private int pNumber;
    private String pName;
    private String year;
    private Scanner in = new Scanner(System.in);

    Syllabus () {}

    public Syllabus(int nNumber, String nName, String work, int pNumber, String pName, String year) {
        this.nNumber = nNumber;
        this.nName = nName;
        this.work = work;
        this.pNumber = pNumber;
        this.pName = pName;
        this.year = year;
    }

    public boolean equalsByYear(Syllabus syl) {
        return this.work.equals(syl.getWork());
    }

    public void setnNumber() {
        System.out.println("Введите шифр направления:");
        this.nNumber = in.nextInt();
    }

    public void setnName() {
        System.out.println("Введите название направления:");
        this.nName = in.next();
    }

    public void setWork() {
        System.out.println("Введите вид учебной деятельности:");
        this.work = in.next();
    }

    public void setpNumber() {
        System.out.println("Введите шифр профиля:");
        this.pNumber = in.nextInt();
    }

    public void setpName() {
        System.out.println("Введите название профиля:");
        this.pName = in.next();
    }

    public void setYear() {
        System.out.println("Введите год начала действия УП:");
        this.year = in.next();
    }

    public int getnNumber() {
        return nNumber;
    }

    public String getnName() {
        return nName;
    }

    public String getWork() {
        return work;
    }

    public int getpNumber() {
        return pNumber;
    }

    public String getpName() {
        return pName;
    }

    public String getYear() {
        return year;
    }

    public Syllabus getObject() {
        return this;
    }
}
