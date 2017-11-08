package ru.job4j.encapsulation;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.is;

public class TrackerTest {
	/**
	* Тест добавление заявок в Tracker и метода findAll.
	*/
	@Test
	public void whenAddNewItemThenTrackerHasSameItem() {
	Tracker tracker = new Tracker();
	Item item = new Item("test1", "testDescription", 123L);
	tracker.add(item);
	assertThat(tracker.findAll()[0], is(item));
	}
	/**
	* Тест редактирования заявок и метода findById.
	*/
	@Test
	public void whenUpdateNameThenReturnNewName() {
    Tracker tracker = new Tracker();
   	Item previous = new Item("test1", "testDescription", 123L);
   	tracker.add(previous);
    Item next  = new Item("test2", "testDescription2", 1234L);
    next.setId(previous.getId());
   	tracker.update(next);
    	assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
	}
	/**
	* Тест удаления заявок.
	*/
	@Test
	public void whenDeleteItemThenReturnArrayWithIndexEquallyNull() {
    Tracker tracker = new Tracker();
   	Item previous = new Item();
   	tracker.add(previous);
	tracker.delete(previous);
    assertThat(tracker.findById(previous.getId()), is(nullValue()));
	}
	/**
	* Тест метода получение списка по имени.
	*/
	@Test
	public void whenSetKeyThenReturnArrayItem() {
	Tracker tracker = new Tracker();
	Item item = new Item("Yupi", "Gum", 10000L);
	tracker.add(item);
	String key = "Yupi";
	assertThat(tracker.findByName(key)[0], is(item));
	}
}

