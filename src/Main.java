import domain.Account;
import domain.Bank;
import domain.Transaction;
import exception.InputUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    private static Bank bank = new Bank();
    private static final int EXIT = 0;

    public static void main(String[] args) {
        Map<Integer, Consumer<StringBuilder>> menuActions = new HashMap<>();
        menuActions.put(1, Main::createAccount);
        menuActions.put(2, Main::getAccountInfo);
        menuActions.put(3, Main::getAccountsByOwner);
        menuActions.put(4, Main::getAllAccounts);
        menuActions.put(5, Main::getTotalAccounts);
        menuActions.put(6, Main::deposit);
        menuActions.put(7, Main::withdraw);
        menuActions.put(8, Main::getBalance);
        menuActions.put(9, Main::getTransactionHistory);

        while (true) {
            printMenu();
            int work = (int) InputUtil.getLongInput("");
            if (work == EXIT) {
                System.out.println("시스템을 종료합니다.");
                break;
            }
            Consumer<StringBuilder> action = menuActions.get(work);
            if (action != null) {
                StringBuilder sb = new StringBuilder();
                try {
                    action.accept(sb);
                } catch (Exception e) {
                    sb.append("오류가 발생했습니다: ").append(e.getMessage());
                }
                System.out.println(sb.toString());
            } else {
                System.out.println("잘못된 번호를 입력하였습니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== 은행 관리 시스템 =====");
        System.out.println("1. 계좌 생성");
        System.out.println("2. 계좌 정보 조회");
        System.out.println("3. 소유자별 계좌 목록 조회");
        System.out.println("4. 전체 계좌 목록 조회");
        System.out.println("5. 총 계좌 수 확인");
        System.out.println("6. 입금");
        System.out.println("7. 출금");
        System.out.println("8. 잔액 조회");
        System.out.println("9. 거래 내역 조회");
        System.out.println("0. 시스템 종료");
        System.out.print("원하는 업무를 선택해 주세요: ");
    }

    private static void createAccount(StringBuilder sb) {
        try {
            String accountNo = InputUtil.getStringInput("생성할 계좌 번호를 입력하세요: ");
            String name = InputUtil.getStringInput("고객 명을 입력하세요: ");
            bank.addAccount(accountNo, name);
            sb.append("계좌를 생성했습니다.");
        } catch (IllegalArgumentException e) {
            sb.append("계좌 생성 중 오류가 발생했습니다: ").append(e.getMessage());
        }
    }

    private static void getAccountInfo(StringBuilder sb) {
        String accountNum = InputUtil.getStringInput("조회할 계좌 번호를 입력하세요: ");
        Account account = bank.getAccount(accountNum);
        if (account != null) {
            sb.append("== 해당 계좌번호의 계좌정보 ==\n");
            sb.append(account.toString());
        } else {
            sb.append("해당 계좌를 찾을 수 없습니다.");
        }
    }

    private static void getAccountsByOwner(StringBuilder sb) {
        String userName = InputUtil.getStringInput("고객명을 입력하세요: ");
        List<Account> accounts = bank.findAccountsByName(userName);
        sb.append("== 해당 소유자명의 계좌 목록 ==\n");
        if (accounts.isEmpty()) {
            sb.append("해당 소유자의 계좌가 없습니다.");
        } else {
            for (Account account : accounts) {
                sb.append(account.toString()).append("\n");
            }
        }
    }

    private static void getAllAccounts(StringBuilder sb) {
        List<Account> accounts = bank.getAccounts();
        sb.append("= 전체 계좌 목록 =\n");
        for (Account account : accounts) {
            sb.append(account.toString()).append("\n");
        }
    }

    private static void getTotalAccounts(StringBuilder sb) {
        sb.append("총 계좌 수는 ").append(bank.getAccounts().size()).append("입니다.");
    }

    private static void deposit(StringBuilder sb) {
        String accountNum = InputUtil.getStringInput("입금할 계좌 번호를 입력하세요: ");
        Account account = bank.getAccount(accountNum);
        if (account != null) {
            long depositAmount = InputUtil.getLongInput("입금할 금액을 입력해 주세요: ");
            try {
                account.deposit(depositAmount);
                sb.append(depositAmount).append("원이 입금되었습니다. 현재 잔액은 ").append(account.getBalance()).append("원 입니다.");
            } catch (IllegalArgumentException e) {
                sb.append("입금 중 오류가 발생했습니다: ").append(e.getMessage());
            }
        } else {
            sb.append("해당 계좌를 찾을 수 없습니다.");
        }
    }

    private static void withdraw(StringBuilder sb) {
        String accountNum = InputUtil.getStringInput("출금할 계좌 번호를 입력하세요: ");
        Account account = bank.getAccount(accountNum);
        if (account != null) {
            long withdrawAmount = InputUtil.getLongInput("출금할 금액을 입력해 주세요: ");
            try {
                account.withdraw(withdrawAmount);
                sb.append(withdrawAmount).append("원이 출금되었습니다. 현재 잔액은 ").append(account.getBalance()).append("원 입니다.");
            } catch (IllegalArgumentException e) {
                sb.append("출금 중 오류가 발생했습니다: ").append(e.getMessage());
            }
        } else {
            sb.append("해당 계좌를 찾을 수 없습니다.");
        }
    }

    private static void getBalance(StringBuilder sb) {
        String accountNum = InputUtil.getStringInput("잔액 조회할 계좌 번호를 입력하세요: ");
        Account account = bank.getAccount(accountNum);
        if (account != null) {
            sb.append("현재 잔액은 ").append(account.getBalance()).append("원 입니다.");
        } else {
            sb.append("해당 계좌를 찾을 수 없습니다.");
        }
    }

    private static void getTransactionHistory(StringBuilder sb) {
        String accountNum = InputUtil.getStringInput("거래내역 조회할 계좌 번호를 입력하세요: ");
        Account account = bank.getAccount(accountNum);
        if (account != null) {
            List<Transaction> transactions = account.getTransactions();
            sb.append("== 거래 내역 ==\n");
            for (Transaction t : transactions) {
                sb.append(t.toString()).append("\n");
            }
        } else {
            sb.append("해당 계좌를 찾을 수 없습니다.");
        }
    }
}
