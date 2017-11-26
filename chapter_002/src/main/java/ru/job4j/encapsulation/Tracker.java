package ru.job4j.encapsulation;

import ru.job4j.encapsulation.*;
import java.util.*;
/**
 * Tracker.
 */
public class Tracker {
	
	/**
	 * Приватный массив items.
	 */
	private Item[] items = new Item[100];
	/**
	 * Приватная переменная position.
	 */
	private int position = 0;
	/**
	 * Случайное число.
	 */
	private static final Random RN = new Random();	
	/**
	 * Метод добавления объектов в массив.
	 * @param item объект.
	 * @return объект.
	 */
	public Item add(Item item) {
	item.setId(this.generateId());
	this.items[position++] = item;
	return item;		
	}
	/**
	 * Метод редактирование заявок.
	 * @param item объект.
	 */	
	public void update(Item item) {
	for (int index = 0; index != position; index++) {
		if (this.items[index].getId().equals(item.getId())) {
			items[index] = item;
			break;
			}
		}
	}
	/**
	 * Метод удаление заявок .
	 * @param item объект.
	 */	
	public void delete(Item item) {
	for (int index = 0; index != this.position; index++) {
		if (items[index] != null && items[index].getId().equals(item.getId())) {
			items[index] = null;
			break;
			}
		}	
	}
	/**
	 * Метод получение списка всех заявок.
	 * @return возврат массива.
	 */
	public Item[] findAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != this.position; index++) {
			if (this.items[index] != null) {
				result[index] = this.items[index];
			}
		}
		return result;
	}
	/**
	 * Метод получение списка по имени.
	 * @param key ключевое слово.
	 * @return возврат массива.
	 */
	public Item[] findByName(String key) {
	Item[] result = new Item[this.position];
	for (int index = 0; index != position; index++) {
		if (items[index] != null && this.items[index].getName().equals(key)) {
			result[index] = items[index];
			}
		}
	return result;	
}	
	/**
	 * Метод получение заявки по id.
	 * @param id заявки.
	 * @return возврат объекта.
	 */
	public Item findById(String id) {
	Item result = null;
	for (Item item : items) {
		if (item != null && item.getId().equals(id)) {
		result = item;
		break;	
		}
	}
	return result;
}	
	/**
	 * Метод генерацииId.
	 * @return возврат строки.
	 */
	String generateId() {
	return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}
}