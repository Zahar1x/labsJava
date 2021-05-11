package ru.mai.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NumberOfWordAppearing {
    static Scanner in = null;
    static final String FILE_ERROR = "There is no such file!";
    static final int OFFSET = 1;
    static final int DEFAULT = 0;

    public static void main(String[] args) {
        HashMap<String, Integer> mapOfWords = new HashMap<>();
        ArrayList<Integer> numberOfWord = new ArrayList<>();

        try {
            in = new Scanner(new File("input.txt"));
            while (in.hasNext()) {
                String buffWord = in.next();
                if (mapOfWords.containsKey(buffWord)) {
                    mapOfWords.put(buffWord, mapOfWords.get(buffWord) + OFFSET);
                    numberOfWord.add(mapOfWords.get(buffWord));
                } else {
                    mapOfWords.put(buffWord, DEFAULT);
                    numberOfWord.add(DEFAULT);
                }
            }
            for (Integer iter : numberOfWord) {
                System.out.print(iter + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println(FILE_ERROR);
        }
    }
}
