package ru.job4j.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Sheriff on 02.01.2018.
 */
public class BankTest {
    @Test
    public void whenAddUserThenGetTrue() {
        Bank bank = new Bank();
        User user = new User("Аюп", "4013 334322");
        bank.addUser(user);
        Map<User, List<Account>> map = bank.mapUserReturn();
        boolean result = map.containsKey(user);
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteUserThenGetFalse() {
        Bank bank = new Bank();
        User user = new User("Аюп", "4013 234433");
        bank.addUser(user);
        bank.deleteUser(user);
        Map<User, List<Account>> map = bank.mapUserReturn();
        boolean result = map.containsKey(user);
        assertThat(result, is(false));
    }

    @Test
    public void whenDeleteAccountFromUserThenGetNegativeValue() {
        Bank bank = new Bank();
        User user = new User("Аюп", "4013 234433");
        bank.addUser(user);
        Account accountFirst = new Account(10000.00);
        Account accountSecond = new Account(20000);
        Account accountThird = new Account(100000.00);
        bank.addAccountToUser(user, accountFirst);
        bank.addAccountToUser(user, accountSecond);
        bank.addAccountToUser(user, accountThird);
        bank.deleteAccountFromUser(user, accountSecond);
        Map<User, List<Account>> map = bank.mapUserReturn();
        List<Account> list = map.get(user);
        int result = list.indexOf(accountSecond);
        assertThat(result, is(-1));
    }

    @Test
    public void whenGetUserAccountsThenShowListAccountUser() {
        Bank bank = new Bank();
        User user = new User("Аюп", "4013 234433");
        bank.addUser(user);
        Account accountFirst = new Account(10000.00);
        Account accountSecond = new Account(20000);
        Account accountThird = new Account(100000.00);
        bank.addAccountToUser(user, accountFirst);
        bank.addAccountToUser(user, accountSecond);
        bank.addAccountToUser(user, accountThird);
        List<Account> list = new ArrayList<>();
        list.add(accountFirst);
        list.add(accountSecond);
        list.add(accountThird);
        List<Account> result = bank.getUserAccounts(user);
        assertThat(result, is(list));
    }


    @Test
    public void whenTransferMoneyThenReturnPositiveNumber() {
        Bank bank = new Bank();
        User firstUser = new User("Аюп", "4013 334553");
        bank.addUser(firstUser);
        User secondUser = new User("Иван", "1112 334343");
        bank.addUser(secondUser);
        Account accountFirst = new Account(1000);
        bank.addAccountToUser(firstUser, accountFirst);
        Account accountSecond = new Account(500);
        bank.addAccountToUser(secondUser, accountSecond);
        bank.transferMoney(firstUser, accountFirst, secondUser, accountSecond, 500);
        double resultFirst = accountFirst.getValue();
        double resultSecond = accountSecond.getValue();
        assertThat(resultFirst, is(500.0));
        assertThat(resultSecond, is(1000.0));
    }
}