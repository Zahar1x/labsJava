package ru.mai.lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class HigherResSchools {
    static Scanner scan = new Scanner(System.in);
    static final int CAPACITY = 100;
    static final int THREE = 3;

    public static void main(String[] args) {
        boolean isAllGood = true;
        ArrayList<Integer> schools = new ArrayList<>(CAPACITY);
        ArrayList<Integer> scores = new ArrayList<>(CAPACITY);
        for (int i = 0; i < CAPACITY; i++) {
            schools.add(0);
            scores.add(0);
        }

        while (scan.hasNextLine() && isAllGood) {
            if (scan.hasNext()) {
                countSchools(schools, scores);
            } else {
                isAllGood = false;
            }
        }
        if (isAllGood) {
            sortAndPrintResults(schools, scores, isAllGood);
        }
    }

    public static void scanner(ArrayList<String> list) {
        String str = scan.nextLine();
        String[] subStr = str.split(" ");
        Collections.addAll(list, subStr);
    }

    public static void countSchools(ArrayList<Integer> schools, ArrayList<Integer> scores) {
        ArrayList<String> list = new ArrayList<>();
        scanner(list);

        int counter;
        counter = schools.get(Integer.parseInt(list.get(2)));
        counter++;
        schools.set(Integer.parseInt(list.get(2)), counter);
        int score;
        score = scores.get(Integer.parseInt(list.get(2)));
        score += Integer.parseInt(list.get(THREE));
        scores.set(Integer.parseInt(list.get(2)), score);
    }

    public static void sortAndPrintResults(ArrayList<Integer> schools, ArrayList<Integer> scores, boolean isAllGood) {
        if (isAllGood) {

            int maxStudent = schools.get(0);
            for (int i = 1; i < schools.size(); i++) {
                if (schools.get(i) > maxStudent) {
                    maxStudent = schools.get(i);
                }
            }
            ArrayList<Integer> maxElements = new ArrayList<Integer>();
            for (int i = 0; i < schools.size(); i++) {
                if (schools.get(i) == maxStudent) {
                    maxElements.add(i + 1);
                }
            }

            Collections.sort(maxElements, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    Integer j1 = scores.get(o1 - 1);
                    Integer j2 = scores.get(o2 - 1);
                    return j1.compareTo(j2);
                }
            }
            );

            for (int i = 0; i < maxElements.size(); i++) {
                System.out.print(maxElements.get(i));
                System.out.print(" ");
            }
        }
        else {
            System.out.println("ERROR!");
        }
    }
    
}
