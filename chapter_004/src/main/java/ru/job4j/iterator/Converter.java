package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.1.4. Создать convert(Iterator<Iterator>).
 * @author Ayup Bariev.
 * @since 19.01.2018.
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> current = it.next();

            @Override
            public boolean hasNext() {
                while (current != null) {
                    if (this.current.hasNext()) {
                        return true;
                    } else {
                        this.current = it.hasNext() ? it.next() : null;
                    }
            }
                return false;
        }

        @Override
        public Integer next() {
            if (this.hasNext()) {
                return this.current.next();
            } else {
                throw new NoSuchElementException("Element not found");
            }
        }
    };
}
    }
