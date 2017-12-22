package ru.job4j.sort;

import java.util.Comparator;

/**
 * Users.
 */
public class User implements Comparable<User> {

    private String name;
    private Integer age;

    /**
     * kit.
     * @param name name
     * @param age age
     */

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * age comparison.
     * @param o object.
     * @return value.
     */

    @Override
    public int compareTo(User o) {
        return age.compareTo(o.age);
    }

    /**
     * sort name length
     */

    static class SortNameLength implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            int result = o1.name.compareTo(o2.name);
            return result != 0 ? result : Integer.compare(o1.age, o2.age);
        }
    }

    /**
     * sort by all fields
     */
    static class SortByAllFields implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            boolean result = o1.name.equals(o2.name);
            return result ? o1.age.compareTo(o2.age) : o1.name.compareTo(o2.name);
        }
    }

    /**
     * redefinition equals.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;

        if (age != user.age) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }
    /**
     * hashcode.
     * @return code.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;

    }
}
