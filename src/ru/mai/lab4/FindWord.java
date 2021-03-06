package ru.mai.lab4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        final String wordRegex = "[Вв]рем(я|ени|енем)";

        findDuplicates(str, wordRegex);

    }
    private static void findDuplicates(String str, final String wordRegex) {
        Pattern p = Pattern.compile(wordRegex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(str.substring(m.start(), m.end()));
        }
    }
}
