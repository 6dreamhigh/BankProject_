package domain;

public class Transaction {
    private String transactionDate;
    private String transactionTime;
    private String kind; // 거래 종류 (입금 또는 출금)
    private long amount; // 거래 금액
    private long balance; // 거래 후 잔고

    public Transaction(String transactionDate, String transactionTime, String kind, long amount, long balance) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.kind = kind;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "[거래금액:" + amount + ", 잔액:" + balance + "원 /" + transactionDate + transactionTime + "]";
    }
}
