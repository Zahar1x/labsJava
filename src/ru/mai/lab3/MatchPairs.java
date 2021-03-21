package ru.mai.lab3;

import java.util.Scanner;

public class MatchPairs {
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
        }

        int counter = 0;

        for(int i = 0; i < arrSize; i++) {
            for(int j = i + 1; j < arrSize; j++){
                if (arr[i] == arr[j]) {
                    counter += 1;
                }
            }
        }
        System.out.println(counter);
    }

}
