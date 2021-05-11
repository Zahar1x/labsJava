package ru.mai.lab2;

import java.util.Scanner;

public class SequenceReversal {
    public static void main(String[] args) {

        //Объявление сканера
        Scanner scanner = new Scanner(System.in);

        //Вызов рекурсивного метода
        recursion(scanner);
    }
    public static void recursion(Scanner scan) {
        if (!scan.hasNextInt()) {
            System.out.println("Error");
           System.exit(-1);
        }
        int num = scan.nextInt();
        if (num != 0) {
            recursion(scan);
        }
        System.out.println(num);
    }
}
