package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sheriff on 02.01.2018.
 */
public class Bank {
    Map<User, List<Account>> map = new HashMap<User, List<Account>>();

    /**
     * add user to database.
     * @param user user.
     */
    public void addUser(User user) {
        if (user != null) {
            List<Account> listAccount = new ArrayList<>();
            map.put(user, listAccount);
        }

    }

    /**
     * delete user from database.
     * @param user user.
     */

    public void deleteUser(User user) {
        if (map.get(user) != null) {
            map.remove(user);
        }
    }

    /**
     * Add account user.
     * @param user user.
     * @param account account.
     */

    public void addAccountToUser(User user, Account account) {
        if (user != null && account != null && map.get(user) != null) {
            List<Account> list = map.get(user);
            list.add(account);
        }
    }

    /**
     * delete account from Bank.
     * @param user user.
     * @param account account.
     */

    public void deleteAccountFromUser(User user, Account account) {
        if (user != null && account != null && map.get(user) != null) {
            map.get(user).remove(account);
        }
    }

    /**
     * Get user accounts.
     * @param user user.
     * @return list.
     */

    public List<Account> getUserAccounts(User user) {
        List<Account> listAccountOfUser = new ArrayList<>();
        if (user != null) {
            listAccountOfUser = map.get(user);
        }
        return listAccountOfUser;
    }

    /**
     * Transfer money
     * @param srcUser source user.
     * @param srcAccount source account.
     * @param dstUser destanation user.
     * @param dstAccount destanation user.
     * @param amount cash.
     * @return boolean.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        List<Account> listSrc;
        List<Account> listDst;
        Account accountFirstUser;
        Account accountSecondUser;
        if (map.containsKey(srcUser) && map.containsKey(dstUser)) {
            listSrc = map.get(srcUser);
            listDst = map.get(dstUser);
            int indexSrc = -1;
            int indexDst = -1;
            if (listDst != null && listSrc != null) {
                indexSrc = listSrc.indexOf(srcAccount);
                indexDst = listDst.indexOf(dstAccount);
            }
            if (indexSrc >= 0 && indexDst >= 0) {
                accountFirstUser = listSrc.get(indexSrc);
                accountSecondUser = listDst.get(indexDst);
                if (srcAccount.getValue() >= amount) {
                    accountFirstUser.setValue(accountFirstUser.getValue() - amount);
                    accountSecondUser.setValue(accountFirstUser.getValue() + amount);
                    result = true;
                }
            }
        }
    return result;
    }

    public Map<User, List<Account>> mapUserReturn() {
        return map;
    }
}
