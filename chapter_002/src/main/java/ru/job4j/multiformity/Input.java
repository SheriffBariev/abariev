package ru.job4j.multiformity;

/**
 * StubInput.
 * @author Sheriff.
 * @since 24.11.2017.
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}
