package ru.mai.lab8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;

public class FindTheWinner {

    public static void main(String[] args) {
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
            Scanner scanner = new Scanner(reader);
            HashSet<Participant> list = new HashSet<>();

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] strArr = str.split("\",\"");
                Participant participant = new Participant(strArr);
                list.add(participant);
            }
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
