package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SetOnHashTableTest {

    @Test
    public void whenOutOfSizeArrayShouldIncreaseSize() {
        SetOnHashTable<Integer> hashSet = new SetOnHashTable<>(3);
        for (int i = 0; i < 5; i++) {
            hashSet.add(i);
        }
        assertThat(hashSet.contains(4), is(true));
    }

    @Test
    public void whenRemoveObjectThenReturnBoolean() {
        SetOnHashTable<Integer> hashSet = new SetOnHashTable<>(3);
        for (int i = 0; i < 5; i++) {
            hashSet.add(i);
        }
        assertThat(hashSet.remove(3), is(true));
        assertThat(hashSet.contains(3), is(false));
    }
    @Test
    public void whenAddElementWithEqualsHashFuncShouldFalse() {
        SetOnHashTable<String> hashSet = new SetOnHashTable(3);
        hashSet.add("Ayup");
        hashSet.add("Rain");
        hashSet.add("Kappa");
        assertThat(hashSet.add("Kappa"), is(false));
    }
}