package ru.job4j.collection;

import java.util.*;

import static java.lang.String.format;

/**
 * Тестирование производительности коллекций.
 */
public class SpeedLoading {
    /**
     * Добавление элементов.
     * @param collection коллекция.
     * @param amount кол-во элементов.
     * @return время в миллисекундах.
     */
    public long add(Collection<String> collection, int amount) {
        long begin = System.currentTimeMillis();
        for (int index = 0; index < amount; index++) {
            collection.add(randomName());
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    /**
     * Удаление элементов из массива.
     * @param collection коллекция.
     * @param amount кол-во удаляемых.
     * @return миллисекунды.
     */
    public long delete(Collection<String> collection, int amount) {
        long begin = System.currentTimeMillis();
        for (int index = 0; index < amount; index++) {
            Iterator it = collection.iterator();
            it.next();
            it.remove();
        }
        long end = System.currentTimeMillis();
        return end - begin;
    }

    /**
     * Генератор случайной фразы.
     * @return слово из 5 букв.
     */
        public static String randomName() {
        String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String result = "";
        char[] validArray = valid.toCharArray();
        for (int i = 0; i < 5; i++) {
            result += validArray[new Random().nextInt(validArray.length)];
        }
        return result;
    }

    /**
     * Точка входа.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        Collection<String> arrayList = new ArrayList<>();
        Collection<String> linkedList = new LinkedList<>();
        Collection<String> treeSet = new TreeSet<>();
        SpeedLoading speedTest = new SpeedLoading();
        System.out.println(format("Время на добавление элементов в ArrayList : %s", speedTest.add(arrayList, 10000)));
        System.out.println(format("Время на добавление элементов в LinkedList : %s", speedTest.add(linkedList, 10000)));
        System.out.println(format("Время на добавление элементов в TreeSet : %s", speedTest.add(treeSet, 10000)));
        System.out.println(format("Время на удаление из ArrayList : %s", speedTest.delete(arrayList, 5000)));
        System.out.println(format("Время на удаление из LinkedList : %s", speedTest.delete(linkedList, 5000)));
        System.out.println(format("Время на удаление из TreeSet : %s", speedTest.delete(treeSet, 5000)));

    }
}
