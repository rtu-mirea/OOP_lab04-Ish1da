package com.sanya;

public class Syllabus {
    private int nNumber;
    private String nName;
    private String work;
    private int pNumber;
    private String pName;
    private String year;

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

    public void setnNumber(int nNumber) {
        this.nNumber = nNumber;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setpNumber(int pNumber) {
        this.pNumber = pNumber;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setYear(String year) {
        this.year = year;
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
}
