package ru.job4j.map;

/**
 * Житель веселого поселка.
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;

        if (name != user.name) {
            return false;
        }
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    /**
     * Override method hashcode.
     * @return code.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        return result;
    }
}
