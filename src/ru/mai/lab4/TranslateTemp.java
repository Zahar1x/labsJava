package ru.mai.lab4;

import java.util.Scanner;

public class TranslateTemp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        if (str.matches(".+ \\d{1,}F")) {
            System.out.println(str);
        }

    }
}
