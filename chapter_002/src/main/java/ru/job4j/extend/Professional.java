package ru.job4j.extend;

/**
 * Родительский класс профессия.
 */
public class Professional {
    /**
     * строка.
     */
    String patent;
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
