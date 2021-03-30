package ru.mai.lab4;

import java.util.Scanner;

public class CheckWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int counter = 0;

        int goodWords = 0;
        final String wordRegex = "^S.*i.*$";

        while (scan.hasNextLine() && counter <= 10) {
            String str = scan.nextLine();
            if (str.matches(wordRegex)&&str.length() == 6) {
                System.out.println(str);
                goodWords++;
            }
            counter++;
        }
        System.out.println(goodWords);

    }
}
