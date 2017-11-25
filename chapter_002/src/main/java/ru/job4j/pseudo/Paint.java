package ru.job4j.pseudo;

/**
 * Paint.
 */
public class Paint {
    /**
     * метод рисовать.
     * @param shape интерфейс
     */
    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }

    /**
     * psvm.
     * @param args массив арг.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
