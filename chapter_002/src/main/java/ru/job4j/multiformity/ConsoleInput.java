package ru.job4j.multiformity;

import java.util.Scanner;

/**
 * Ввод пользовательских данных.
 * @author Ayup Bariev.
 * @since 15.11.2017.
 */
public class ConsoleInput implements Input {
	Scanner scanner = new Scanner(System.in);
	/**
	 * Метод ask.
	 * @param question вопрос.
	 */
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}

	/**
	 * метод ask.
	 * @param question вопрос.
	 * @param range массив.
	 * @return вернуть ключ.
	 */
	public int ask(String question, int[] range) {
		int key = Integer.valueOf(this.ask(question));
		boolean exist = false;
		for (int value : range) {
			if (value == key) {
				exist = true;
				break;
			}
		}
		if (exist) {
			return key;
		} else {
			throw new MenuOutException("Out of menu range.");
		}
	}
}