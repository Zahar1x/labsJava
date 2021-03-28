package ru.mai.lab4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder str = new StringBuilder(scan.nextLine());

        StringBuilder strResult = new StringBuilder("");

        int indexOfWhiteSpace = str.lastIndexOf(" ");

        String subStr1 = str.substring(0, indexOfWhiteSpace);

        String subStr2 = str.substring(indexOfWhiteSpace + 1);

        strResult.append(subStr2).append(" ").append(subStr1);

        System.out.println(strResult);
    }
}
