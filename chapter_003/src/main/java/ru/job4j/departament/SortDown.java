package ru.job4j.departament;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * SortDown.
 */
public class SortDown implements Comparator<String> {
    /**
     * Override comparator with 2 array.
     * @param o1 object.
     * @param o2 object.
     * @return count.
     */
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        String[] leftSplit = o1.split("/");
        String[] rightSplit = o2.split("/");
        for (int i = 0; i < leftSplit.length && i < rightSplit.length && result == 0; i++) {
            result = rightSplit[i].compareTo(leftSplit[i]);
        }
        return result == 0 ? o1.length() - o2.length() : -1;
    }

    /**
     * Conevert TreeSet to ArrayList
     * @param treeSet Set.
     * @return ArrayList.
     */
    public ArrayList<String> convertTreeSet(TreeSet<String> treeSet) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String i : treeSet) {
            arrayList.add(i);
        }
        return arrayList;
    }
}
