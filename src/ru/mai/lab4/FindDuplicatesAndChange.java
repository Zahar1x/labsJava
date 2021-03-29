package ru.mai.lab4;

import java.util.Scanner;

public class FindDuplicatesAndChange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        final String duplRegex = "\\b([^\\W\\d_]+)(\\s+\\1)+\\b";
        deleteDuplicates(str, duplRegex);

    }
    private static void deleteDuplicates(String str, final String duplRegex) {
        String strRes = str.replaceFirst(duplRegex, "$1");
        System.out.println(strRes);
    }
}
