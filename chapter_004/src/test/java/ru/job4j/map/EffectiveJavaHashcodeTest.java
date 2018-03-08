package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Sheriff on 08.03.2018.
 */
public class EffectiveJavaHashcodeTest {
    @Test
    public void whenPutKeyShouldReturnValue() {
        Map map = new HashMap();
        map.put(new EffectiveJavaHashcode(8, 952, 2333500), "Ayup");
        System.out.println(new EffectiveJavaHashcode(8, 952, 2333500).hashCode());
        assertThat(map.get(new EffectiveJavaHashcode(8, 952, 2333500)), is("Ayup"));
    }
}