package org.example;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentBank {

    private final ConcurrentHashMap<String, BankAccount> concurrentBank;

    public ConcurrentBank() {

        concurrentBank = new ConcurrentHashMap<>();
    }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, Long amount) {

        BankAccount firstObject =
            fromAccount.getAccountId().compareTo(toAccount.getAccountId()) < 0 ? fromAccount : toAccount;
        BankAccount secondObject =
            fromAccount.getAccountId().compareTo(toAccount.getAccountId()) < 0 ? toAccount : fromAccount;


        synchronized (firstObject) {
            synchronized (secondObject) {
                if (fromAccount.getBalance() >= amount) {
                    fromAccount.setAccountBalance(fromAccount.getBalance()-amount);
                    toAccount.setAccountBalance(toAccount.getBalance()+amount);
                    System.out.println("перевод выполнен на сумму :"+amount );
                } else {
                    throw new RuntimeException(" Не достаточно средств для перевода");
                }
            }
        }
    }

    public BankAccount createAccount(Long deposit) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountBalance(deposit);
        bankAccount.setAccountId(generateAccount());


        concurrentBank.put(bankAccount.getAccountId(), bankAccount);
        return bankAccount;
    }

    public String generateAccount() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("40800000000000000");

        Random random = new Random();
        for (int i = 0; i < 3; i++) {

            stringBuilder.append(random.nextInt(9));
        }

        return stringBuilder.toString();
    }

    public Long getTotalBalance() {
        return concurrentBank.values().stream().mapToLong(BankAccount::getBalance).sum();

    }
}
