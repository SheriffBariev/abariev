package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sheriff on 08.03.2018.
 */
public class EffectiveJavaHashcode {
    public int areaCode;
    public int exchange;
    public int extension;

    public EffectiveJavaHashcode(int areaCode, int exchange, int extension) {
        this.areaCode = areaCode;
        this.exchange = exchange;
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EffectiveJavaHashcode that = (EffectiveJavaHashcode) o;

        if (areaCode != that.areaCode) {
            return false;
        }
        if (exchange != that.exchange) {
            return false;
        }
        return extension == that.extension;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + areaCode;
        result = 37 * result + exchange;
        result = 37 * result + extension;
        return result;
    }


}
