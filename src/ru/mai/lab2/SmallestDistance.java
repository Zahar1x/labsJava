package ru.mai.lab2;

import java.util.Scanner;

public class SmallestDistance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int bigNum = 20000;
        int num1 = 1;
        int num2 = 0;
        int num3 = 0;
        int dist = 0;
        int maxDist1 = 0;
        int maxDist2 = 0;
        int result = bigNum;

        if (scanner.hasNextInt()) {

            while (num1 != 0) {
                dist++;
                num3 = num2;
                num2 = num1;
                num1 = scanner.nextInt();
                if (dist > 2) {
                    if (num2 > num1 && num2 > num3 && num1 != 0) {
                        maxDist2 = maxDist1;
                        maxDist1 = dist;
                        if ((maxDist1 > 0) && (maxDist2 > 0)) {
                            if (maxDist1 - maxDist2 < result) {
                                result = maxDist1 - maxDist2;
                            }
                        }
                    }
                }
            }
            if (result == bigNum) {
                result = 0;
            }
            System.out.println(result);

        } else {
            System.out.println("Error");
            System.exit(-1);
        }
    }

}
