package ru.mai.lab2;

import java.util.Scanner;

public class KingsMove {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int xF = 0;
        int yF = 0;
        int xS = 0;
        int yS = 0;

        if (scanner.hasNextInt()) {
            // Ввод горизонтальной координаты для 1-ой клетки
            xF = scanner.nextInt();
        } else {
            System.exit(-1);
        }

        if (scanner.hasNextInt()) {
            // Ввод вертикальной координаты для 1-ой клетки
            yF = scanner.nextInt();
        } else {
            System.exit(-1);
        }

        if (scanner.hasNextInt()) {
            // Ввод горизонтальной координаты для 2-ой клетки
            xS = scanner.nextInt();
        } else {
            System.exit(-1);
        }

        if (scanner.hasNextInt()) {
            // Ввод вертикальной координаты для 2-ой клетки
            yS = scanner.nextInt();
        } else {
            System.exit(-1);
        }

        // Расчет возможности короля сходить на заданную вторую клетку
        if (xS < (xF - 1) || xS > (xF + 1) || yS < (yF - 1) || yS > (yF + 1)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
