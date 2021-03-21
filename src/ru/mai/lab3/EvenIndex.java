package ru.mai.lab3;

import java.util.Scanner;

public class EvenIndex {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int arrSize = 0;

        if (scan.hasNextInt()) {
            arrSize = scan.nextInt();
        } else {
            System.exit(-1);
        }

        int[] arr = new int[arrSize];

       for(int i = 0; i < arrSize; i++) {
            arr[i] = scan.nextInt();
            if (i % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
       }

    }
}
