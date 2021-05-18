package ru.mai.lab8;

import java.util.logging.Level;

/**
 * Класс "Участник"
 */
public class Participant {
    /**
     * Имя участника
     */
    private String name;

    /**
     * Кол-во баллов участника
     */
    private String score;

    /**
     * Объект для логирования
     */
    static private LoggerWrapper logger = new LoggerWrapper(ru.mai.lab8.Participant.class.getName());

    /**
     * Конструктор класса "Участник"
     * @param arr Массив состоящий из 2-ух элементов. 1-ый имя участника, 2-ой количество баллов участника
     */
    public Participant(String[] arr) {
        if (checkParticipant(arr)) {
            this.name = arr[0];
            this.score = arr[1];
            logger.log(Level.INFO, "Data is good! Participant filled.");
        } else {
            logger.log(Level.WARNING, "Invalid data!");
        }
    }

    /**
     * Получить имя участника
     * @return имя участника
     */
    public String getName() {
        return name;
    }

    /**
     * Получить кол-во баллов участника
     * @return кол-во баллов участника
     */
    public String getScore() {
        return score;
    }

    /**
     * Приводит объект класса "участник" к строке и выврдит его имя и кол-во баллов
     * @return имя и кол-во баллов участника
     */
    @Override
    public String toString() {
        return this.name + " " + this.score;
    }

    /**
     * Проверяет размер массива подстрок
     * @param arr массив подстрок
     * @return true если размер массива 2, false во всех остальных случаях
     */
    private boolean checkParticipant(String[] arr) {
        if (arr.length == 2) {
            return true;
        } else {
            return false;
        }
    }
}
