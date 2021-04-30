package ru.mai.lab7;

import java.util.HashSet;
import java.util.Scanner;

public class Change {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int beginWayOne = 0;
        int endWayOne = 0;
        int beginWayTwo = 0;
        int endWayTwo = 0;

        beginWayOne = scan();
        endWayOne = scan();
        beginWayTwo = scan();
        endWayTwo = scan();

        try {
            HashSet<Integer> busStopsOne;
            HashSet<Integer> busStopsTwo;
            busStopsOne = equalStops(beginWayOne, endWayOne);
            busStopsTwo = equalStops(beginWayTwo, endWayTwo);

            busStopsOne.retainAll(busStopsTwo);
            System.out.println(busStopsOne.size());
        } catch (Exception e) {
            System.out.println("Error");
            System.exit(0);
        }

    }

    public static int scan() {
        int variable = 0;
        if (scanner.hasNextInt()) {
            variable = scanner.nextInt();
        } else {
            System.out.println("Error");
            System.exit(0);
        }
        return variable;
    }

    public static HashSet<Integer> equalStops(int start, int end) {
        HashSet<Integer> stops = new HashSet<>();
        if (end > start) {
            for (int i = start; i <= end; i++) {
                stops.add(i);
            }
        } else {
            for (int i = start; i >= end; i--) {
                stops.add(i);
            }
        }
        return stops;
    }


}
