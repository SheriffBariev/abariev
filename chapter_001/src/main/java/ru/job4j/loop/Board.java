package ru.job4j.loop;

/**
 * Board.
 * @author Ayup Bariev.
 * @since 28.09.2017.
 */
public class Board {
    /**
     * Paint.
     * @param width ширина.
     * @param height высота.
     * @return builder.
     */
    public String paint(int width, int height) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    builder.append("x");
                } else if (i % 2 != 0 && j % 2 != 0) {
                    builder.append("x");
                } else {
                    builder.append(" ");
                }

            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
