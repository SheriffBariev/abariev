package ru.job4j.departament;


import java.util.*;

/**
 * Sort.
 */
public class Sort {
    /**
     * Add missing items.
     * @param treeSet Set.
     * @return new treeSet.
     */
    public TreeSet<String> sorted(TreeSet<String> treeSet) {
        TreeSet<String> result = new TreeSet<>();
        for (Iterator<String> iterator = treeSet.iterator(); iterator.hasNext();) {
            String itNext = iterator.next();
            String[] split = itNext.split("/");
            String item = "";
            for (int i = 0; i != split.length - 1; i++) {
                item += split[i];
                result.add(item);
                item += "/";

            }
            result.add(itNext);
        }
        return result;
    }
}
