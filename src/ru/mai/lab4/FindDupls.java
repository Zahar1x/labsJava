package ru.mai.lab4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDupls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        final String duplRegex = "\\b([^\\W\\d_]+)(\\s+\\1)+\\b";

        deleteDuplicates(str, duplRegex);

    }
    private static void deleteDuplicates(String str, final String duplRegex) {
        Pattern pattern = Pattern.compile(duplRegex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(str.substring(matcher.start(), matcher.end(1)));
        }
    }
}
