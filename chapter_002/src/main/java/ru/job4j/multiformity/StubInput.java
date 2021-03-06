package ru.job4j.multiformity;

import java.util.List;

/**
 * StubInput.
 * @author Sheriff.
 * @since 24.11.2017.
 */
public class StubInput implements Input {
    /**
     * Приватная строка ответы.
     */
    private String[] answers;
    /**
     * Приватная переменная индексы.
     */
    private int position = 0;

    /**
     * Метод StubInput.
     * @param answers ответы.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Метод ask.
     * @param question вопрос.
     * @return строка.
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * переопределение метода.
     * @param question вопрос.
     * @param range массив.
     * @return число.
     */
    public int ask(String question, List<Integer> range) {
        return Integer.valueOf(this.ask(question));
    }
}
