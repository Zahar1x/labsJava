package ru.mai.lab2;

import java.util.Scanner;

public class EquationSolution {
    public static void main(String[] args) {

        final int zero = 0;

        Scanner scan = new Scanner(System.in);

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        if (scan.hasNextInt()) {
            //Ввод параметра а для числителя
            a = scan.nextInt();
        } else {
            System.exit(-1);
        }

        if (scan.hasNextInt()) {
            //Ввод параметра b для числителя
            b = scan.nextInt();
        } else {
            System.exit(-1);
        }

        if (scan.hasNextInt()) {
            //Ввод параметра с для знаменателя
            c = scan.nextInt();
        } else {
            System.exit(-1);
        }

        if (scan.hasNextInt()) {
            //Ввод параметра d для знаменателя
            d = scan.nextInt();
        } else {
            System.exit(-1);
        }

        int x;

        if (a == zero && b == zero) {
            System.out.println("INF");
        } else if (a == zero || b * c == a * d) {
            System.out.println("NO");
        } else if (b % a == zero) {
            b = -b;
            x = b / a;
            System.out.println(x);
        } else {
            System.out.println("NO");
        }
    }

}
