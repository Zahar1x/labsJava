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

        for(int i = 0; i < arrSize; i++) {
            if (scan.hasNextInt()){
                arr[i] = scan.nextInt();
            } else {
                System.exit(-1);
            }
        }

        for(int i = 0; i < arrSize; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + " ");
                i++;
            }
        }
    }
}
