package domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(String accountNo, String name) throws IllegalArgumentException {
        if (getAccount(accountNo) != null) {
            throw new IllegalArgumentException("이미 존재하는 계좌 번호입니다.");
        }
        accounts.add(new Account(accountNo, name));
    }

    public Account getAccount(String accountNo) {
        for (Account account : accounts) {
            if (account.getAccountNo().equals(accountNo)) {
                return account;
            }
        }
        return null;
    }

    public List<Account> findAccountsByName(String name) {
        List<Account> foundAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getName().equals(name)) {
                foundAccounts.add(account);
            }
        }
        return foundAccounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
