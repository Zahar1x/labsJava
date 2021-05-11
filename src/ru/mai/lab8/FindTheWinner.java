package ru.mai.lab8;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;

/**
 * Класс позволяет найти человека с максимальным кол-вом баллов
 */
public class FindTheWinner {
    static LoggerWrapper logger;

    static {
        try(FileInputStream ins = new FileInputStream("config.log")){
            LogManager.getLogManager().readConfiguration(ins);
            logger = new LoggerWrapper(ru.mai.lab8.Participant.class.getName());
        } catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    /**
     * Метод считывает данные из файла и отправляет их на обработку
     * @param args
     */
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"),"Cp1251"));
             Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(br);
            HashSet<Participant> list = new HashSet<>();

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] strArr = str.split("\", ?\"");
                Participant participant = new Participant(strArr);
                list.add(participant);
            }
            findWinner(list, out);
        } catch (UnsupportedEncodingException e) {
           logger.log(Level.WARNING, "Exception unsupported encoding");
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "Exception File not found");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Exception input output");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception");
        }
    }

    /**
     * Метод находит человека с максимальным кол-вом баллов
     * @param scores список людей и их баллов
     * @param out объект, который записывает найденные данные в файл с определенной кодировкой
     * @throws IOException
     */
    public static void findWinner(HashSet<Participant> scores, Writer out) throws IOException {
        double score = 0.0;
        double max = 0.0;
        Participant participantWithMaxScore = null;
        int counterEqualScores = 0;
        logger.log(Level.INFO, "Method findWinner started");
        for (Participant part : scores) {
            try {
                String[] scoreOfPart = part.getScore().split(" ");
                score = Double.parseDouble(scoreOfPart[0].replace(',', '.'));
                if (score >= max) {
                    max = score;
                    participantWithMaxScore = part;
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Can't parse string to double");
            }
        }
        for (Participant part : scores) {
            if (part.getScore() == participantWithMaxScore.getScore()) {
                counterEqualScores++;
            }
        }
        if (counterEqualScores > 1) {
            out.write("Победителей не найдено");
            logger.log(Level.INFO, "No winner found");
        } else {
            out.write("\"Победитель-" + participantWithMaxScore.getName()
                    .replace("\"", "")
                    + " "
                    + participantWithMaxScore.getScore());
            logger.log(Level.INFO, "Winner found! You can check it in output.txt.");
        }
    }
}
