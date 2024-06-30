# 은행 관리 시스템

본 프로젝트는 Java로 개발된 간단한 은행 관리 시스템입니다. 이 시스템은 계좌 생성, 조회, 입출금, 잔액 조회 등의 기능을 제공하며, 예외 처리를 통해 안정적인 운영을 보장합니다.

---

## 기능 분석

본 시스템의 주요 기능은 다음과 같습니다:

1. 계좌 생성
2. 계좌 정보 조회
3. 소유자별 계좌 목록 조회
4. 전체 계좌 목록 조회
5. 총 계좌 수 확인
6. 입금
7. 출금
8. 잔액 조회
9. 거래 내역 조회

---

## 다이어그램

```plaintext
  +-------------------------+
  |         Main            |
  +-------------------------+
  | - bank: Bank            |
  +-------------------------+
  | + main(String[] args)   |
  | + printMenu()           |
  | + createAccount(sb)     |
  | + getAccountInfo(sb)    |
  | + getAccountsByOwner(sb)|
  | + getAllAccounts(sb)    |
  | + getTotalAccounts(sb)  |
  | + deposit(sb)           |
  | + withdraw(sb)          |
  | + getBalance(sb)        |
  | + getTransactionHistory(sb) |
  +-------------------------+
           |
           |
           V
  +-------------------------+
  |         Bank            |
  +-------------------------+
  | - accounts: List<Account>|
  +-------------------------+
  | + addAccount(accountNo, name)|
  | + getAccount(accountNo)  |
  | + findAccountsByName(name)|
  | + getAccounts()          |
  +-------------------------+
           |
           |
           V
  +-------------------------+
  |        Account          |
  +-------------------------+
  | - accountNo: String     |
  | - name: String          |
  | - balance: long         |
  | - transactions: List<Transaction>|
  +-------------------------+
  | + Account(accountNo, name)|
  | + getAccountNo()         |
  | + getName()              |
  | + getBalance()           |
  | + getTransactions()      |
  | + deposit(amount)        |
  | + withdraw(amount)       |
  | + toString()             |
  +-------------------------+
           |
           |
           V
  +-------------------------+
  |      Transaction        |
  +-------------------------+
  | - transactionDate: String|
  | - transactionTime: String|
  | - kind: String          |
  | - amount: long          |
  | - balance: long         |
  +-------------------------+
  | + Transaction(transactionDate, transactionTime, kind, amount, balance)|
  | + toString()             |
  +-------------------------+
           |
           |
           V
  +-------------------------+
  |       DateUtil          |
  +-------------------------+
  | + getCurrentDate()      |
  | + getCurrentTime()      |
  +-------------------------+
           |
           |
           V
  +-------------------------+
  |       InputUtil         |
  +-------------------------+
  | + getLongInput(prompt)  |
  | + getStringInput(prompt)|
  +-------------------------+
