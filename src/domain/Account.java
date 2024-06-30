package domain;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNo;
    private String name;
    private long balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = 0;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(long amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(DateUtil.getCurrentDate(), DateUtil.getCurrentTime(), "입금", amount, balance));
            System.out.println(amount + "원 입금하셨습니다.");
            System.out.println("현재 잔액은 " + balance + "원 입니다.");
        } else {
            System.out.println("잘못된 입금 금액입니다.");
        }
    }

    public void withdraw(long amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(DateUtil.getCurrentDate(), DateUtil.getCurrentTime(), "출금", amount, balance));
            System.out.println(amount + "원 인출하셨습니다.");
            System.out.println("현재 잔액은 " + balance + "원 입니다.");
        } else {
            throw new IllegalArgumentException("잘못된 출금 금액 또는 잔고 부족입니다.");
        }
    }


    @Override
    public String toString() {
        return "[계좌번호 :" + accountNo + ", 소유자 명 :" + name + ", 잔액 :" + balance + "]";
    }
}
