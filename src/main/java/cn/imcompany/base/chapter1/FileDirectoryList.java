package cn.imcompany.base.chapter1;

import java.io.File;

public class FileDirectoryList {

    public static void main(String[] args) {

//        printFile("/Users/tomyli/work/dz");
//        printFileWithLambda("/Users/tomyli/work/dz");
        printFileWithLambdaRefer("/Users/tomyli/work/dz");
    }

    private static void printFile(String fileName) {

        File file = new File(fileName);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File file1 : files) {
                        if (!file1.isDirectory()) {
                            continue;
                        }
                        String absolutePath = file1.getAbsolutePath();
                        System.out.println(absolutePath);
                        printFile(absolutePath);
                    }
                }
            }
        }
    }

    private static void printFileWithLambda(String fileName) {

        File file = new File(fileName);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles(subFile -> subFile.isDirectory());
                for (File file1 : files) {
                    String absolutePath = file1.getAbsolutePath();
                    System.out.println(absolutePath);
                    printFileWithLambda(absolutePath);
                }
            }
        }
    }

    private static void printFileWithLambdaRefer(String fileName) {

        File file = new File(fileName);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles(File::isDirectory);
                for (File file1 : files) {
                    String absolutePath = file1.getAbsolutePath();
                    System.out.println(absolutePath);
                    printFileWithLambda(absolutePath);
                }
            }
        }
    }
}
