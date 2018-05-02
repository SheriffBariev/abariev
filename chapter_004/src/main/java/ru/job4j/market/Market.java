package ru.job4j.market;

import java.util.HashMap;
import java.util.Map;

public class Market {

    Map<String, Glass> market = new HashMap<>();

    public boolean addItem(String book, Type type, Action action, double price, int volume) {
        if (market.containsKey(book)) {
            market.get(book).checkItem(new Item(book, type, action, price, volume));
        } else {
            market.put(book, new Glass(book));
            market.get(book).checkItem(new Item(book, type, action, price, volume));
        }
        return true;
    }
    public void print() {
        for (Glass item: market.values()) {
            System.out.println(item.getBook());
            System.out.println(String.format("%s\t\t%s\t%s", "Продажа", "Цена", "Покупка"));
            System.out.println(item);
        }
    }
}
