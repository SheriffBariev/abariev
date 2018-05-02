package ru.job4j.market;

public class Item implements Comparable<Item> {

    private int id;
    private String book;
    private Type type;
    private Action action;
    private double price;
    int volume;

    public Item(String book, Type type, Action action, double price, int volume) {
        this.id = hashCode();
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (price != item.price) {
            return false;
        }
        if (volume != item.volume) {
            return false;
        }
        if (book != null ? !book.equals(item.book) : item.book != null) {
            return false;
        }
        if (type != null ? !type.equals(item.type) : item.type != null) {
            return false;
        }
        return action != null ? action.equals(item.action) : item.action == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + volume;
        return result;
    }


    public void setType(Type type) {
        this.type = type;
    }


    public int getId() {

        return id;
    }

    public String getBook() {
        return book;
    }

    public Type getType() {
        return type;
    }

    public Action getAction() {
        return action;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(o.price, this.price);
    }
}