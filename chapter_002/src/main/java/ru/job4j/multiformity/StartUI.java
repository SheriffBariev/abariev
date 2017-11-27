package ru.job4j.multiformity;
/**
*@author Ayup Bariev.
*@since 11.11.2017.
*/
import ru.job4j.encapsulation.*;
import ru.job4j.start.MenuTracker;

import java.awt.*;

public class StartUI {
	/**
     * Получение данных от пользователя.
     */
    private Input input;

    /**
     * Хранилище заявок.
     */
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
    	Tracker tracker = new Tracker();
    	MenuTracker menuTracker = new MenuTracker(this.input, tracker);
		menuTracker.fillActions();
		do {
			menuTracker.show();
			menuTracker.select(input.ask("select:", menuTracker.getActions()));
		} while (!("y").equals(this.input.ask("Exit? (y): ")));
    }


		/**
		 * Запускт программы.
		 * @param args
		 */
		public static void main(String[]args) {
			Input input = new ValidateInput();
			new StartUI(input).init();
		}
	}

