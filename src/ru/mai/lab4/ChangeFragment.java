package ru.mai.lab4;

import java.util.Scanner;

public class ChangeFragment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = "";

        str = scan.nextLine();

        String strResult = "";

        System.out.println(str);

        if (str.matches(".+h.+")) {
        strResult = str.replace('h', 'H');
        System.out.println(strResult);
        }
    }
}
