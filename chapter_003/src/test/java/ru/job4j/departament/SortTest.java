package ru.job4j.departament;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test sort TreeSet.
 */
public class SortTest {
    /**
     * Sort.
     */
    @Test
    public void whenGiveListThenGetASortedList() {
        TreeSet<String> departament = new TreeSet<>(Arrays.asList(
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        ));
        Sort sort = new Sort();
        List<String> arrayList = new ArrayList<>(sort.sorted(departament));
        List<String> expectList = new ArrayList<>(Arrays.asList(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        ));
        assertThat(arrayList, is(expectList));
    }

    /**
     * SortDown.
     */
    @Test
    public void whenGiveListThenGetASortDownList() {
        TreeSet<String> departament = new TreeSet<>(Arrays.asList(
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        ));
        Sort sort = new Sort();
        SortDown sortDown = new SortDown();
        TreeSet<String> treeSet = new TreeSet<>(sortDown);
        treeSet.addAll(sort.sorted(departament));
        List<String> resultList = new ArrayList<>(sortDown.convertTreeSet(treeSet));
        List<String> expectList = new ArrayList<>(Arrays.asList(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"
        ));
        assertThat(resultList, is(expectList));
    }
}