package ru.job4j.pseudo;

/**
 * @author Abariev
 */
public class Square implements Shape {
        @Override
        public String pic() {
            StringBuilder pic = new StringBuilder();
            pic.append("++++");
            pic.append("+  +");
            pic.append("+  +");
            pic.append("++++");
            return pic.toString();
        }
}

