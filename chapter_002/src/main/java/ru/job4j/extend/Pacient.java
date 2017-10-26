package ru.job4j.extend;

/**
 * Класс заболевший.
 */
public class Pacient {
    /**
     * приватная строка.
     */
    private String name;

    /**
     * геттер.
     * @return имя.
     */
    public String getName() {
        return name;
    }

    /**
     * сеттер.
     * @param name имя.
     */
    public void setName(String name) {
        this.name = name;
    }
}
