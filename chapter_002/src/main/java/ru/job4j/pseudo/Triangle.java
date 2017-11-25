package ru.job4j.pseudo;

/**
 * Created by Sheriff on 25.11.2017.
 */
public class Triangle implements Shape {
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +  ");
        pic.append(" + + ");
        pic.append("+++++");
        return pic.toString();
    }
}
