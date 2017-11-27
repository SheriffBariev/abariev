package ru.job4j.multiformity;

/**
 * Исключительные ситуации.
 */
public class ValidateInput extends ConsoleInput {
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
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
