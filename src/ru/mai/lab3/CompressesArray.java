package ru.mai.lab3;

import java.util.Scanner;

public class CompressesArray {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int arrSize = 0;

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

        int indexOfZero;

        for (int i = 0; i < arrSize; i++) {
            if (arr[i] == 0) {
                indexOfZero = i;
                while (arr[i] == 0 && i < arrSize - 1) {
                    i++;
                }
                int tmp = arr[i];
                arr[i] = arr[indexOfZero];
                arr[indexOfZero] = tmp;
                i = indexOfZero;
            }
        }
        for (int i = 0; i < arrSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
