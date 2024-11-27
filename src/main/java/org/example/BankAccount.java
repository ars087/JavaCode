package org.example;

public class BankAccount {

    private String accountId ;
    private Long accountBalance;

    public synchronized void deposit(Long deposit) {
        accountBalance += deposit;
    }

    public synchronized void withdraw(Long withdraw) {
        if (accountBalance.compareTo(withdraw ) < 0) {
            throw new RuntimeException("Не достаточно средств");
        } else {
            accountBalance -= withdraw;
            System.out.println("Снятие наличных : Счет " + getBalance());
        }
    }

    public Long getBalance() {
        return accountBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }
}
