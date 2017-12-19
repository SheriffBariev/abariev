package ru.job4j.adoration;

import java.util.HashMap;
import java.util.List;

/**
 * Конвертер.
 */
public class UserConvert {
    /**
     * Конвертирует.
     * @param list
     * @return
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        int key = 0;
        for (User user : list) {
            hashMap.put(key, user);
            key++;
        }
    return hashMap;
    }
}
