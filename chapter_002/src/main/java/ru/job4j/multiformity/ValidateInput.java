package ru.job4j.multiformity;

import ru.job4j.start.MenuTracker;

/**
 * Исключительные ситуации.
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }
    public String ask(String question) {
        return this.input.ask(question);
    }
    /**
     * Метод проверки ошибки.
     * @param question вопрос.
     * @param range массив.
     * @return переменная value.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
                if (value > 6) {
                    throw new MenuOutException("");
                }
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
