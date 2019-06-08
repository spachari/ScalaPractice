package com.general.data.structures.and.algorithms.ch5recursion;

import java.io.File;

public class FileSize {
    public void printFileSize(File fileName) {
        if (fileName.isDirectory()) {
            String[] fileList = fileName.list();
            for (String f : fileList) {
                File newFile = new File(fileName, f);
                printFileSize(newFile);
            }
        }
        else {
            System.out.println(fileName + " " + fileName.length());
        }
    }

    int totalSize;

    public long getTotalFileSize(File fileName) {
        if (fileName.isDirectory()) {
            totalSize += fileName.length();
            String[] childFileList = fileName.list();
            for (String f : childFileList) {
                File file = new File(fileName, f);
                getTotalFileSize(file);
            }
        } else {
            System.out.println(fileName + " " + fileName.length() + " " + totalSize);
            totalSize += fileName.length();
        }
        return totalSize;
    }
}


class FileSizeTest {
    public static void main(String[] args) {

        String fileName = "/Users/spachari/IdeaProjects/untitled3/src/main/scala/com/general/data/structures/and/algorithms/";
        FileSize fileSize = new FileSize();
        fileSize.printFileSize(new File(fileName));

        System.out.println("Print total file size .... ");
        System.out.println(fileSize.getTotalFileSize(new File(fileName)));

    }
}