package ru.mai.lab3;

import java.util.Scanner;

public class Qeen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int arrSize = 8;

        int[] xCoord = new int[arrSize];
        int[] yCoord = new int[arrSize];

        boolean correct = false;

        for (int i = 0; i < arrSize; i++) {
            if (scan.hasNextInt()) {
                xCoord[i] = scan.nextInt();
                yCoord[i] = scan.nextInt();
            } else {
                System.exit(-1);
            }
        }
        for (int i = 0; i < arrSize; i++) {
            for (int j = i + 1; j < arrSize; j++) {
                if (xCoord[i] == xCoord[j] || yCoord[i] == yCoord[j]
                        || Math.abs(xCoord[i] - xCoord[j]) == Math.abs(yCoord[i] - yCoord[j])) {
                correct = true;
                }
            }
        }
        if (correct) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
