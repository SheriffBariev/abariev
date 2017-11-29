package ru.job4j.multiformity;
/**
*@author Ayup Bariev.
*@since 11.11.2017.
*/
import ru.job4j.encapsulation.Tracker;
import ru.job4j.start.MenuTracker;

public class StartUI {

	private final Tracker tracker;
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
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
    	MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
		menuTracker.fillActions();
		do {
			menuTracker.show();
			menuTracker.select(this.input.ask("select:", menuTracker.getActions()));
		} while (!("y").equals(this.input.ask("Exit? (y): ")));
    }


		/**
		 * Запускт программы.
		 * @param args
		 */
		public static void main(String[]args) {
			new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
		}
	}

