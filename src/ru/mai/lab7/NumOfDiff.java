package ru.mai.lab7;

import java.util.HashSet;
import java.util.Scanner;

public class NumOfDiff {
    static Scanner scan = new Scanner(System.in);
    static final int MAX_CAPACITY = 100000;

    public static void main(String[] args) {
        HashSet<Integer> setOne = new HashSet<>(MAX_CAPACITY);

        addNumsToSet(setOne);

    }

    public static void addNumsToSet(HashSet<Integer> set) {
        String str = scan.nextLine();
        String[] arr = str.split(" ");
        try {
            int counter = 0;
            for (String string : arr) {
                if (!set.contains(Integer.parseInt(string))) {
                    set.add(Integer.parseInt(string));
                    counter++;
                }
            }
            System.out.println(counter);
        } catch (Exception e) {
            System.out.println("ERROR");
            System.exit(-1);
        }
    }
}
