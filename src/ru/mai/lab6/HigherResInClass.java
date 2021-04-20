package ru.mai.lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class HigherResInClass {
    static Scanner scan = new Scanner(System.in);
    static final int THREE = 3;
    static final int NINE_CLASS = 9;
    static final int TEN_CLASS = 10;
    static final int ELEVEN_CLASS = 11;
    static int higherOfNine = 0;
    static int higherOfTen = 0;
    static int higherOfEleven = 0;

    public static void main(String[] args) {
        int[] higherRes = new int[THREE];
        while (scan.hasNext()) {
            countClass(higherRes);
        }
        for (int num : higherRes) {
            System.out.print(num + " ");
        }
    }
    public static void scanner(ArrayList list) {
        String str = scan.nextLine();
        String[] subStr = str.split(" ");

        for (int i = 0; i < subStr.length; i++) {
            list.add(subStr[i]);
        }
    }

    public static void countClass(int[] higherRes) {
        ArrayList<String> list = new ArrayList<>();

        scanner(list);

        if (Integer.parseInt(list.get(2)) == NINE_CLASS) {
            if (higherOfNine < Integer.parseInt(list.get(THREE))) {
                higherOfNine = Integer.parseInt(list.get(THREE));
                higherRes[0] = higherOfNine;
            }

        } else if (Integer.parseInt(list.get(2)) == TEN_CLASS) {
            if (higherOfTen < Integer.parseInt(list.get(THREE))) {
                higherOfTen = Integer.parseInt(list.get(THREE));
                higherRes[1] = higherOfTen;
            }
        } else if (Integer.parseInt(list.get(2)) == ELEVEN_CLASS) {
            if (higherOfEleven < Integer.parseInt(list.get(THREE))) {
                higherOfEleven = Integer.parseInt(list.get(THREE));
                higherRes[2] = higherOfEleven;
            }
        }
    }
}
