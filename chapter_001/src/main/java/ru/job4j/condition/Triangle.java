package ru.job4j.condition;

/**
 * Triangle.
 * @author Ayup Bariev
 * @since 24.09.2017
 */
public class Triangle {
    /**
     * Внутрений объект a класса Triangle.
     */
    private Point a;

    /**
     * Внутрений объект b класса Triangle.
     */
    private Point b;

    /**
     * Внутрений объект c класса Triangle.
     */
    private Point c;

    /**
     * Метод Triangle.
     * @param a объект класса Point.
     * @param b объект класса Point.
     * @param c объект класса Point.
     */

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисляет расстояние между точками left и right.
     * @param left point.
     * @param right point.
     * @return distance.
     */
    public double distance(Point left, Point right) {
        return Math.sqrt(Math.pow(right.getX() - left.getX(), 2) + Math.pow(right.getY() - left.getY(), 2));
    }
    /**
     * Метод вычисления периметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Периметр.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислить прощадь треугольканива.
     *
     * Формула.
     *
     * √ p *(p - ab) * (p - ac) * (p - bc)
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть прощадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return exist.
     */
    private boolean exist(double ab, double ac, double bc) {
        return ab + ac > bc && ac + bc > ab && ab + bc > ac ? true : false;
    }
}

