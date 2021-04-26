package ru.mai.lab7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Transfer {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> listOfStations = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listOfStations.add(i, 0);
        }
        while (scan.hasNextInt()) {
            scanAndSetStations(listOfStations);
        }
        int counter = 0;
        for (int num : listOfStations) {
            if (num == 2) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static void scanAndSetStations(ArrayList<Integer> list) {
        int station = scan.nextInt();
        if (list.get(station) == 0) {
            list.set(station, 1);
        } else if (list.get(station) == 1) {
            list.set(station, 2);
        }
    }
}
