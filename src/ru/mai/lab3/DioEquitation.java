package ru.mai.lab3;

import java.util.Scanner;

public class DioEquitation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int range = 1000;

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int counter = 0;

        if (scan.hasNextInt()) {
            a = scan.nextInt();
        } else {
            System.exit(-1);
        }

        if (scan.hasNextInt()) {
            b = scan.nextInt();
        } else {
            System.exit(-1);
        }

        if (scan.hasNextInt()) {
            c = scan.nextInt();
        } else {
            System.exit(-1);
        }

        if (scan.hasNextInt()) {
            d = scan.nextInt();
        } else {
            System.exit(-1);
        }

        for (int i = 1; i <= range; i++) {
            if (checkForSolution(i, a, b, c, d) == 1) {
                counter++;
            }
        }

        System.out.println(counter);
    }

    public static int checkForSolution(int x, int a, int b, int c, int d) {
        if ((Math.pow(x, 3) * a + Math.pow(x, 2) * b + c * x + d) == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
