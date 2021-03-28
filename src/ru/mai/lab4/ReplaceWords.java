package ru.mai.lab4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder str = new StringBuilder(scan.nextLine());

        String strResult = "";

        Pattern p = Pattern.compile("(.)(\\s .)");
        Matcher m = p.matcher(str);

        String subStr = m.group();

    }
}
