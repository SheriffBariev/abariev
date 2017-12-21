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
	private ArrayList<Item> items = new ArrayList<>();
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
	this.items.add(item);
	return item;		
	}
	/**
	 * Метод редактирование заявок.
	 * @param item объект.
	 */	
	public void update(Item item) {
	for (int index = 0; index != items.size(); index++) {
		if (this.items.get(index).getId().equals(item.getId())) {
			items.set(index, item);
			break;
			}
		}
	}
	/**
	 * Метод удаление заявок .
	 * @param item объект.
	 */	
	public void delete(Item item) {
		items.remove(item);
	}
	/**
	 * Метод получение списка всех заявок.
	 * @return возврат массива.
	 */
	public List<Item> findAll() {
		return this.items;
	}
	/**
	 * Метод получение списка по имени.
	 * @param key ключевое слово.
	 * @return возврат массива.
	 */
	public List<Item> findByName(String key) {
	List<Item> result = new ArrayList<>();
	for (Item item : items) {
		if (item.getName().equals(key)) {
			result.add(item);
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