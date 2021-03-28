package ru.mai.lab4;

import java.util.Scanner;

public class DeleteSymb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        String strResult = "";

        if (str.matches(".+@.+")) {
            strResult = str.replace('@', ' ');
        }
        System.out.println(strResult);
    }

}
