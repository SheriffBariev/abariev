package ru.job4j.generic;

/**
 * @author Ayup Bariev.
 * @since 22.01.2018.
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
