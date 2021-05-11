package ru.mai.lab2;

import java.util.Scanner;

public class EvklidsAlgorithm {
    public static void main(String[] args) {

        //Объявление сканера
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            System.out.println(gcd(scanner.nextInt(), scanner.nextInt()));
        } else {
            System.out.println("Error");
        }
    }

    //Рекурсивный алгоритм Евклида
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
