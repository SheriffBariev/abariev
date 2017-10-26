package ru.job4j.extend;

/**
 * Класс наука.
 */
public class Science {
    /**
     * приватная строка.
     */
    private String designation;

    /**
     * геттер.
     * @return название.
     */
    public String getDesignation() {
        return this.designation;
    }
    /**
     * сеттер.
     * @param designation название.
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
