package ru.job4j.adoration;

/**
 * Created by Sheriff on 19.12.2017.
 */
public class User {
    private Integer id;
    private String name;
    private String city;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * set.
     * @param id id.
     * @return void.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * set.
     * @param name name.
     * @return void.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set.
     * @param city city.
     * @return void.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * get.
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * get.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get.
     * @return city
     */
    public String getCity() {
        return city;
    }
}
