package ru.job4j.start;

/**
 * 1. Реализовать события на внутренних классах.
 * @author Ayub Bariev.
 * @since 26.11.2017.
 */
import ru.job4j.encapsulation.*;
import ru.job4j.multiformity.*;
public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
