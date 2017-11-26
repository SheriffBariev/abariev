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
    * Константа меню для добавления новой заявки.
    */
    private static final String ADD = "0";
	/**
	* Константа меню для вывода всего списка.
	*/
	private static final String FINDALL = "1";
	/**
	* Константа меню для редактирования заявок.
	*/
	private static final String UPDATE = "2";
	/**
	* Константа меню для удаления заявок.
	*/
	private static final String DELETE = "3";
	/**
	* Константа меню для поиска заявки по id.
	*/
	private static final String FINDBYID = "4";
	/**
	* Константа меню для поиска заявки по имени.
	*/
	private static final String FINDBYNAME  = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
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
			int key = Integer.parseInt(input.ask("Select: "));
			menuTracker.select(key);
		} while (!("y").equals(this.input.ask("Exit? (y): ")));
    }
        /*boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Select the menu item : ");
            if (ADD.equals(answer)) {
               //добавление заявки вынесено в отдельный метод.
               this.createItem();
			   
           } else if (FINDALL.equals(answer)) {
			 this.findAllItem();
			 
		   } else if (UPDATE.equals(answer)) {
			 this.editItem();
			 
		   } else if (DELETE.equals(answer)) {
			 this.deleteItem();
			 
           } else if (FINDBYID.equals(answer)) {
			 this.findByIdItem();
			 
           } else if (FINDBYNAME.equals(answer)) {
			 this.findByName();
			 
           } else if (EXIT.equals(answer)) {
             exit = true;
           }
        }
    }*/

		/**
		 * Метод реализует добавленяи новый заявки в хранилище.
		 */
    /*private void createItem() {
        System.out.println("------------ Add a new application --------------");
        String name = this.input.ask("Enter the name of the application : ");
        String desc = this.input.ask("Enter the description of the application : ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New application with getId : " + item.getId() + "-----------");
    }*/

		/**
		 * Метод выводит весь список заявок.
		 */
	/*private void findAllItem() {
		System.out.println("------------ All applications --------------");
		System.out.println(this.tracker.findAll());
	}*/

		/**
		 * Метод редактирует заявку.
		 */
	/*private void editItem() {
		System.out.println("------------ Edit application --------------");
		String id = this.input.ask("Enter the ID of the application : ");
		String name = this.input.ask("Enter the name of the application : ");
		String desc = this.input.ask("Enter the description of the application : ");
		Item item = new Item(name, desc);
		item.setId(id);
		this.tracker.update(item);
		System.out.println("------------ Editing successfully --------------");
	}*/

		/**
		 * Метод удаляет заявку.
		 */
	/*private void deleteItem() {
		System.out.println("------------ Delete application --------------");
		String id = this.input.ask("Enter the name of the application : ");
		this.tracker.delete(this.tracker.findById(id));
		System.out.println("------------ Removed --------------");
	}*/

		/**
		 * Метод находит заявку по id.
		 */
	/*private void findByIdItem() {
		System.out.println("------------ Delete application --------------");
		String id = this.input.ask("Enter the id of the application : ");
		System.out.println("------------ Application found by ID is :" + this.tracker.findById(id));
	}*/

		/**
		 * Метод находит заявку по имени.
		 */
	/*private void findByName() {
		System.out.println("------------ Delete application --------------");
		String name = this.input.ask("Enter the name of the application : ");
		System.out.println("------------ Application found by name is :" + this.tracker.findByName(name));
	}*/

		/**
		 * Меню.
		 */
    /*private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
		System.out.println("1. Show all items");
		System.out.println("2. Edit item");
		System.out.println("3. Delete item");
		System.out.println("4. Find item by Id");
		System.out.println("5. Find items by name");
		System.out.println("6. Exit Program");
    }*/

		/**
		 * Запускт программы.
		 * @param args
		 */
		public static void main(String[]args) {
			new StartUI(new ConsoleInput(), new Tracker()).init();
		}
	}

