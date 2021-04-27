package ru.mai.lab8;

/**
 *
 */
public class Participant {
    /**
     *
     */
    private String name;

    /**
     *
     */
    private String score;

    /**
     *
     * @param nameOf
     * @param scores
     */
    public Participant(String[] arr) {
        this.name = arr[0];
        this.score = arr[1];
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}
