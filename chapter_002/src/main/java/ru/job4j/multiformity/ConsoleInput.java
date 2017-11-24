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
}