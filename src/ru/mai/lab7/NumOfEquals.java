package ru.mai.lab7;

import java.util.HashSet;
import java.util.Scanner;

public class NumOfEquals {
    static Scanner scan = new Scanner(System.in);
    static final int MAX_CAPACITY = 100000;

    public static void main(String[] args) {
        HashSet<Integer> setOne = new HashSet<>(MAX_CAPACITY);
        HashSet<Integer> setTwo = new HashSet<>(MAX_CAPACITY);

        addNumsToSet(setOne);
        addNumsToSet(setTwo);

        setOne.retainAll(setTwo);
        for (int i : setOne) {
            System.out.print(i + " ");
        }
    }

    public static void addNumsToSet(HashSet<Integer> set) {
        String str = scan.nextLine();
        String[] arr = str.split(" ");
        try {
            for (String string : arr) {
                set.add(Integer.parseInt(string));
            }
        } catch (Exception e) {
            System.out.println("ERROR");
            System.exit(-1);
        }
    }
}
