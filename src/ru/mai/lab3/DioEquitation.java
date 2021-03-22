package ru.mai.lab3;

import java.util.Scanner;

public class DioEquitation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int arrSize = 0;

        final int range = 1000;

        int counter = 0;

        if (scan.hasNextInt()) {
            arrSize = scan.nextInt();
        } else {
            System.exit(-1);
        }

        int[] arr = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            if (scan.hasNextInt()) {
                arr[i] = scan.nextInt();
            } else {
                System.exit(-1);
            }
        }

        for (int i = 1; i <= range; i++) {
            if (checkForSolution(i, arr) == 1) {
                counter++;
            }
        }

        System.out.println(counter);
    }

    public static int checkForSolution(int x, int[] arr) {
        final int three = 3;
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[three];

        if ((Math.pow(x, three) * a + Math.pow(x, 2) * b + c * x + d) == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
