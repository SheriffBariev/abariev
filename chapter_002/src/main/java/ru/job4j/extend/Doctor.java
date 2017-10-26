package ru.job4j.extend;

/**
 * Дочерний класс Доктор.
 */
public class Doctor extends Professional {
    /**
     * Медот лечить.
     * @param pacient Пациент.
     * @return строка.
     */
    public String heal(Pacient pacient) {
        return "Доктор " + getName() + " лечит " + pacient.getName();
    }
}