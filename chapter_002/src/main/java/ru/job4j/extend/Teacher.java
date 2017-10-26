package ru.job4j.extend;

/**
 * Дочерний класс учитель.
 */
public class Teacher extends Professional {
    /**
     * приватная строка.
     */
    private String lesson;

    /**
     * геттер.
     * @return строка.
     */
    public String getLesson() {
        return lesson;
    }

    /**
     * сеттер.
     * @param lesson предмет.
     */
    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    /**
     * Метод обучение.
     * @param student студент.
     * @return строка.
     */

    public String learn(Student student) {
        return "Учитель " + getName() + " терпеливо и методично ищет «ключ» студенту "
                + student.getNameStudent() + ". " + getName() + " преподает " + this.lesson + ".";
    }
}
