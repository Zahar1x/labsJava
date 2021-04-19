package ru.mai.lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class CountSort {
    static Scanner scan = new Scanner(System.in);
    static final int MAX = 100;
    static final int MIN = 0;
    static final int CAPACITY = 210;

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(CAPACITY);

        while (scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        countSort(list);
    }

    public static void countSort(ArrayList<Integer> list) {
        int[] numCounts = new int[MAX + 1];
        for (int num : list) {
            numCounts[num]++;
        }

        int currentSortedIndex = 0;
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            for (int k = 0; k < count; k++) {
                list.set(currentSortedIndex, n);
                currentSortedIndex++;
            }
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
