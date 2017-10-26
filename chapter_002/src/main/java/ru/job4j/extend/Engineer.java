package ru.job4j.extend;

/**
 * Дочерний класс Инженер.
 */
public class Engineer extends Professional {
    /**
     *Приватная строка.
     */
    private String speciality;

    /**
     * Метод внедрение.
     * @param science Наука
     * @return строка.
     */
    public String invent(Science science) {
        return "Инженер " + getName() + " внедрил в " + science.getDesignation() + " 30 предложений по производственным улучшениям.";
    }
}
