package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("To see if a word is a Java keyword, enter below:");
        String javaKey = myScanner.nextLine().toLowerCase();

        if (javaKey.equals("abstract") ||
                javaKey.equals("assert") ||
                javaKey.equals("boolean") ||
                javaKey.equals("break") ||
                javaKey.equals("byte") ||
                javaKey.equals("case") ||
                javaKey.equals("do") ||
                javaKey.equals("double") ||
                javaKey.equals("if") ||
                javaKey.equals("implements") ||
                javaKey.equals("instanceof") ||
                javaKey.equals("int") ||
                javaKey.equals("boolean") ||
                javaKey.equals("break") ||
                javaKey.equals("byte") ||
                javaKey.equals("assert") ||
                javaKey.equals("finally") ||
                javaKey.equals("char") ||
                javaKey.equals("final") ||
                javaKey.equals("float") ||
                javaKey.equals("extends") ||
                javaKey.equals("long") ||
                javaKey.equals("catch") ||
                javaKey.equals("interface") ||
                javaKey.equals("const") ||
                javaKey.equals("native") ||
                javaKey.equals("protected") ||
                javaKey.equals("private") ||
                javaKey.equals("static") ||
                javaKey.equals("strictfp") ||
                javaKey.equals("super") ||
                javaKey.equals("while") ||
                javaKey.equals("for") ||
                javaKey.equals("try") ||
                javaKey.equals("transient") ||
                javaKey.equals("abstract") ||
                javaKey.equals("synchronized") ||
                javaKey.equals("switch") ||
                javaKey.equals("native") ||
                javaKey.equals("enum") ||
                javaKey.equals("catch")
        ) {
            System.out.println(javaKey + " is a java keyword");
        } else {
            System.out.println(javaKey + " is not a java keyword");
        }
    }
}