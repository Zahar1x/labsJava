package ru.mai.lab8;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Этот класс позволяет найти человека с максимальным кол-вом баллов
 */
public class FindTheWinner {

    /**
     * Этот метод считывает данные из файла и отправляет их на обработку
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"),"Cp1251"));
             Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(br);
            HashSet<Participant> list = new HashSet<>();

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] strArr = str.split("\",\"");
                if (strArr.length == 2) {
                    Participant participant = new Participant(strArr);
                    list.add(participant);
                } else {
                    System.out.println("Invalid data!");
                }
            }
            findWinner(list, out);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Этот метод находит человека с максимальным кол-вом баллов
     * @param scores список людей и их баллов
     * @param out объект, который записывает найденные данные в файл с определенной кодировкой
     * @throws IOException
     */
    public static void findWinner(HashSet<Participant> scores, Writer out) throws IOException {
        double score = 0.0;
        double max = 0.0;
        Participant participantWithMaxScore = null;
        int counterEqualScores = 0;
        for (Participant part : scores) {
            try {
                String[] scoreOfPart = part.getScore().split(" ");
                score = Double.parseDouble(scoreOfPart[0].replace(',', '.'));
                if (score >= max) {
                    max = score;
                    participantWithMaxScore = part;
                }
            } catch (Exception e) {
                System.out.println("Can't parse string to double");
                System.exit(-2);
            }
        }
        for (Participant part : scores) {
            if (part.getScore() == participantWithMaxScore.getScore()) {
                counterEqualScores++;
            }
        }
        if (counterEqualScores > 1) {
            out.write("Победителей не найдено");
        }
        else {
            out.write("\"Победитель-" + participantWithMaxScore.getName()
                    .replace("\"", "")
                    + " "
                    + participantWithMaxScore.getScore());
        }
    }
}
