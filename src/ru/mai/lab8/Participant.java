package ru.mai.lab8;

/**
 * Это класс "участник"
 */
public class Participant {

    /**
     * Это поле хранит имя участника
     */
    private String name;

    /**
     * Это поле хранит кол-во баллов участника
     */
    private String score;

    /**
     * Этот метод является конструктором класса "Участник"
     * @param arr Массив состоящий из 2-ух элементов. 1-ый имя участника, 2-ой количество баллов участника
     */
    public Participant(String[] arr) {
        this.name = arr[0];
        this.score = arr[1];
    }

    /**
     * Этот метод позволяет получить имя участника
     * @return имя участника
     */
    public String getName() {
        return name;
    }

    /**
     * этот метод позволяет получить кол-во баллов участника
     * @return кол-во баллов участника
     */
    public String getScore() {
        return score;
    }

    /**
     * Этот метод приводит объект класса "участник" к строке и выврдит его имя и кол-во баллов
     * @return имя и кол-во баллов участника
     */
    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}
