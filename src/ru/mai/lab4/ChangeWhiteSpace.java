package ru.mai.lab4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ChangeWhiteSpace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        final String whiteSpaceRegex = "\\s+";

        Pattern pattern = Pattern.compile(whiteSpaceRegex);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            System.out.println(str.replaceAll(whiteSpaceRegex, "*"));
        }
    }

}
