package ru.job4j.generic;

/**
 * Abstract Store.
 * @author Ayup Bariev.
 * @since 23.01.2018.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    SimpleArray<T> simpleArray = new SimpleArray<>(10);
    public void add(T model) {
        simpleArray.add(model);
    }

    public boolean checkId(String id) {
        try {
            Integer.parseInt(id);
        } catch (Exception e) {
            throw new NumberFormatException("Input number");
        }
        return true;
    }

    public boolean replace(String id, T model) {
        if (checkId(id)) {
            Integer count = Integer.valueOf(id);
            simpleArray.set(count, model);
        }
        return true;
    }

    public boolean delete(String id) {
        if (checkId(id)) {
            Integer value = Integer.valueOf(id);
            simpleArray.delete(value);
        }
        return true;
    }

    public T findById(String id) {
        Integer value = null;
        if (checkId(id)) {
            value = Integer.valueOf(id);
        }
        return simpleArray.get(value);
    }
}
