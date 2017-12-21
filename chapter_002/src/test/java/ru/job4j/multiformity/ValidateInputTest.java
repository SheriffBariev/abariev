package ru.job4j.multiformity;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Sheriff on 02.12.2017.
 */
public class ValidateInputTest {
    @Test
    public void whenUserEnterValueThenReturnNumberFormatException() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфур для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        Input input = new StubInput(new String[]{"10", "0"});
        List<Integer> list = new ArrayList<>();
        list.add(0);
        ValidateInput validate = new ValidateInput(input);
        validate.ask("", Collections.singletonList(list.get(0)));
        // проверяем результат вычисления
        assertThat(new String(out.toByteArray()), is("Please select key from menu.\r\n"));
        System.setOut(stdout);
    }
    @Test
    public void whenUserEnterValueThenReturnMenuOutException() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфур для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        Input input = new StubInput(new String[]{"a", "0"});
        List<Integer> list = new ArrayList<>();
        list.add(0);
        ValidateInput validate = new ValidateInput(input);
        validate.ask("", Collections.singletonList(list.get(0)));
        // проверяем результат вычисления
        assertThat(new String(out.toByteArray()), is("Please enter validate data again.\r\n"));
        System.setOut(stdout);
    }

}