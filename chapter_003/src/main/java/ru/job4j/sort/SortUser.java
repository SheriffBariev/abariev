package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Sort Users.
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> treeSet = new TreeSet<>();
        treeSet.addAll(list);
        return treeSet;
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new User.SortNameLength());
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new User.SortByAllFields());
        return list;

    }
}
