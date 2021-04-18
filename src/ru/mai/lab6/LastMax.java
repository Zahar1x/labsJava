package ru.mai.lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class LastMax {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        while (scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        findMax(list);
    }

    public static void findMax(ArrayList<Integer> list) {
        int max = 0;
        int index = 0;

        max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= max) {
                max = list.get(i);
                index = i;
            }
        }

        System.out.print(max + " " + index);
    }
}
