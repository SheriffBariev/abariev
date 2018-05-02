package ru.job4j.market;

import java.util.*;

/**
 * Биржевой стакан.
 * @author Ayup Bariev.
 * @since 26.04.2018.
 */

public class Glass {
    /**
     * Issuer(эмитент).
     */
    private String book;

    public String getBook() {
        return book;
    }

    public Glass(String book) {
        this.book = book;
    }

    /**
     * Purchase order sheet(на покупку).
     */
    private ArrayList<Item> bidItem = new ArrayList();
    /**
     * List for sale of applications(на продажу).
     */
    private ArrayList<Item> askItem = new ArrayList();

    /**
     * Check action and type.
     * @param item item.
     */
    public void checkItem(Item item) {
        if (item.getType().equals(Type.add)) {
            if (item.getAction().equals(Action.bid)) {
                checkArrayMatchAdd(item, bidItem);
            } else {
                checkArrayMatchAdd(item, askItem);
            }
        } else {
            if (item.getAction().equals(Action.bid)) {
                checkArrayMatchDell(item, bidItem);
            } else {
                checkArrayMatchDell(item, askItem);
            }
        }
    }

    private void checkArrayMatchAdd(Item item, ArrayList<Item> list) {
        if (list.isEmpty()) {
            list.add(item);
        } else {
            for (Item i : list) {
                if (i.getBook().equals(item.getBook()) && i.getPrice() == item.getPrice()) {
                        i.volume += item.getVolume();
                        item = i;
                        break;
                }
            }
        }
        if (!list.contains(item)) {
            list.add(item);
        }
        sellItem();
    }
    private void checkArrayMatchDell(Item item, ArrayList<Item> list) {
        if (list.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Нет заявок в системе");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getBook().equals(item.getBook()) && list.get(i).getPrice() == item.getPrice()) {
                    if (list.get(i).getVolume() >= item.getVolume()) {
                        list.get(i).volume -= item.getVolume();
                        item = list.get(i);
                        break;
                    }
                }
            }
        }
        if (item.getVolume() == 0) {
            list.remove(item);
        }
    }

    /**
     * selling item.
     */

    private void sellItem() {
        for (int i = 0; i < bidItem.size(); i++) {
            for (int j = 0; j < askItem.size(); j++) {
                if (bidItem.get(i).getBook().equals(askItem.get(j).getBook()) && bidItem.get(i).getPrice() >= (askItem.get(j).getPrice())) {
                    int number = bidItem.get(i).volume - askItem.get(j).volume;
                    if (number > 0) {
                        bidItem.get(i).volume -= askItem.get(j).volume;
                        askItem.remove(j);
                        break;
                    } else if (number < 0) {
                        askItem.get(j).volume -= bidItem.get(i).volume;
                        bidItem.remove(i);
                        break;
                    } else if (number == 0) {
                        bidItem.remove(i);
                        askItem.remove(j);
                        break;
                    }
                }
            }
        }
    }

    /**
     * print glass.
     * @param list list.
     * @return map.
     */
    private NavigableMap<Double, Integer> print(ArrayList<Item> list) {
        NavigableMap<Double, Integer> result = new TreeMap<>();
        for (Item item : list) {
            if (result.containsKey(item.getPrice())) {
                result.replace(item.getPrice(), result.get(item.getPrice() + item.getVolume()));
            } else {
                if (item.getBook().equals(this.book)) {
                    result.put(item.getPrice(), item.getVolume());
                }
            }
        }
        return result.descendingMap();
    }


    public String toString() {
        StringJoiner string = new StringJoiner(System.lineSeparator(), System.lineSeparator(), System.lineSeparator());
        for (Map.Entry<Double, Integer> item : print(askItem).entrySet()) {
            string.add(String.format("%s\t\t\t%s", item.getValue(), item.getKey()));
        }
        for (Map.Entry<Double, Integer> item : print(bidItem).entrySet()) {
            string.add(String.format("\t\t\t%s\t\t%s", item.getKey(), item.getValue()));
        }
        return string.toString();
    }
}
