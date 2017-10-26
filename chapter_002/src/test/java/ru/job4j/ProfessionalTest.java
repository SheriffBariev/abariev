package ru.job4j;

import org.junit.Test;
import ru.job4j.extend.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Sheriff on 26.10.2017.
 */
public class ProfessionalTest {
    /**
     * Тест класса Доктор.
     */
    @Test
    public void whenBringNameDoctorAndPacientThenDoctorReturnMethod() {
        Doctor doctor = new Doctor();
        doctor.setName("Алекс");
        Pacient ailing = new Pacient();
        ailing.setName("Олега");
        String result = doctor.heal(ailing);
        String expected = "Доктор Алекс лечит Олега";
        assertThat(result, is(expected));
    }
    /**
     * Тест класса инженер.
     */
    @Test
    public void whenBringNameEngineerAndScienceThenEngineerReturnMethod() {
        Engineer engineer = new Engineer();
        engineer.setName("Алексей");
        Science science = new Science();
        science.setDesignation("биосферу");
        String result = engineer.invent(science);
        String expected = "Инженер Алексей внедрил в биосферу 30 предложений по производственным улучшениям.";
        assertThat(result, is(expected));
}
    /**
     * тест класса учителя.
     */
    @Test
    public void whenBringNameTeacherAndStudentThenTeacherReturnMethod() {
        Teacher teacher = new Teacher();
        teacher.setName("Марьям");
        Student student = new Student();
        teacher.setLesson("английский язык");
        student.setNameStudent("Ивану");
        String result = teacher.learn(student);
        String expected = "Учитель Марьям терпеливо и методично ищет «ключ» студенту Ивану. Марьям преподает английский язык.";
        assertThat(result, is(expected));
}
}
