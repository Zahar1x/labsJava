package ru.mai.lab2;

import java.util.Scanner;

public class MKADtask {
    public static void main(String[] args) {

        //Переменная для храния протяженности МКАДа
        final int lengthMkad = 109;

        //Объявление сканера
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {

            //Ввод скорости
            int speed = scanner.nextInt();

            //Ввод времени в пути
            int time = scanner.nextInt();

            if (speed > 0) {
                int range = speed * time;
                int laps = range / lengthMkad;
                range = range - laps * lengthMkad;
                System.out.println(range);
            } else {
                int range = speed * time;
                int laps = range / lengthMkad;
                range = lengthMkad + (range - laps * lengthMkad);
                System.out.println(range);
            }

        } else {
            System.out.println("Error");
        }
    }
}
