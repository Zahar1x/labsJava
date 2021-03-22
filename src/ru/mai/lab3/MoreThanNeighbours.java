package ru.mai.lab3;

import java.util.Scanner;

public class MoreThanNeighbours {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int arrSize = 0;

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

        for (int i = 1; i < arrSize - 1; i++) {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                counter += 1;
            }
        }
        System.out.println(counter);


    }
}
