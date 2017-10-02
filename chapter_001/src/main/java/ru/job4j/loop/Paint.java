package ru.job4j.loop;

/**
 * class Paint.
 * @author Ayup Bariev.
 * @since 29.09.2017.
 */
public class Paint {
    /**
     * метод Piramid.
     * @param h целочисленная переменная.
     * @return возврат значения.
     */
    public String piramid(int h) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < (h - 1) + h; j++) {
                if (h - 1 == i || h - 1 == j || h - 1 == i + j || h - 1 == j - i) {
                    builder.append("^");
                } else {
                    builder.append(" ");
                }
            }
            if (i < h - 1) {
                builder.append("\r\n");
            }
        }
        return builder.toString();
    }
}
