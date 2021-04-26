package ru.mai.lab7;

import java.util.Scanner;

public class TelephoneNumbers {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String newNum = "";
        String str = "";
        String existingNum = "";
        int counter = 0;
        while (scan.hasNextLine()) {
            str = scan.nextLine();
            if (counter == 0) {
                newNum = prepareNums(str);
            } else {
                existingNum = prepareNums(str);
                compareNums(newNum, existingNum);
            }
            counter++;
        }
    }

    public static void compareNums(String str, String existingNum) {
        if (str.equals(existingNum)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static String prepareNums(String str) {
        StringBuilder newString = new StringBuilder( str.replaceAll("-", "")
                .replaceAll("[)]", "")
                .replaceAll("[(]", ""));

        if (newString.length() < 8) {
            newString.insert(0, "495");
        } else {
            if (newString.toString().startsWith("+7")) {
                newString.delete(0, 2);
            } else if (newString.toString().startsWith("8")) {
                newString.deleteCharAt(0);
            }
        }
        return newString.toString();
    }
}
