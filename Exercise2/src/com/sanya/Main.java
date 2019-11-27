package com.sanya;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            File newFile = FileConstructor.createFile();
            FileConstructor.fileOutput(newFile);
            FileConstructor.fileInput(newFile);
            File nextFile = FileConstructor.makeNewSylFile(newFile);
            FileConstructor.changeProfileName(nextFile);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
