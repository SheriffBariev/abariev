package ru.job4j.multiformity;

/**
 * Исключение.
 * выводит сообщение об ошибке. super обращается к родительскому методу.
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
