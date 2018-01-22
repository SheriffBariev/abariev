package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test for Store.
 */
public class StoreTest {
    @Test
    public void whenReplaceUserShouldChangeInUserStore() {
        Store userStore = new UserStore();

        Base user = new User("1");
        Base customer = new User("2");
        Base guest = new User("2");


        userStore.add(user);
        userStore.add(customer);
        boolean result = userStore.replace(guest.getId(), guest);
        assertThat(result, is(true));
    }

    @Test(expected = NumberFormatException.class)
    public void whenDeleteUserShouldReturnTrue() {
        AbstractStore userStore = new UserStore();

        Base worker = new User("Developer");
        Base user = new User("2");
        userStore.add(worker);
        userStore.add(user);
        assertThat(userStore.delete(user.getId()), is(true));
        userStore.findById(worker.getId());
    }


    @Test
    public void whenReplaceRoleShouldChangeInRoleStore() {
        Store roleStore = new RoleStore();

        Base developer = new Role("1");
        Base tester = new Role("2");
        Base client = new Role("2");


        roleStore.add(developer);
        roleStore.add(tester);
        boolean result = roleStore.replace(client.getId(), client);
        assertThat(result, is(true));
    }

    @Test(expected = NumberFormatException.class)
    public void whenDeleteRoleShouldReturnTrue() {
        AbstractStore roleStore = new RoleStore();

        Base developer = new Role("Developer");
        Base user = new Role("2");
        roleStore.add(developer);
        roleStore.add(user);
        assertThat(roleStore.delete(user.getId()), is(true));
        roleStore.findById(developer.getId());
    }
}
