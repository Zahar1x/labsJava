package ru.mai.lab7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class AmountOfWords {

    public static void main(String[] args) {
        try {
            FileInputStream inFile = new FileInputStream("input.txt");
            Scanner scanner = new Scanner(inFile);
            ArrayList<String> list = new ArrayList<>();

            while (scanner.hasNext()) {
                list.add(scanner.next());
            }
            System.out.println(list.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
