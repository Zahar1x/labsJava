package ru.mai.lab2;

import java.util.Scanner;

public class Checkers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        if (scan.hasNextInt()) {

            int xF = scan.nextInt();
            int yF = scan.nextInt();
            int xS = scan.nextInt();
            int yS = scan.nextInt();

            int difF;
            int difS;

            boolean flag = false;

            difF = Math.abs(xF - yF);
            difS = Math.abs(xS - yS);

            if (yS <= yF) {
                System.out.println("NO");
            } else {
                if (difF == difS) {
                    System.out.println("YES");
                    flag = true;
                } else {
                    while (xF > 1) {
                        yF++;
                        xS--;
                        if (xF == xS && yF == yS) {
                            System.out.println("YES");
                            flag = true;
                        }
                    }
                    if (!flag) {
                        System.out.println("NO");
                    }
                }
            }

        } else {
            System.out.println("Error");
            System.exit(-1);
        }
    }

}
