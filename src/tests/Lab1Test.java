package tests;

import lab1.Application.AccountBuilder.AccountBuilder;
import lab1.Domain.Common.Account;
import lab1.Domain.Common.TimeManager;
import lab1.Domain.Entities.Bank;
import lab1.Domain.Enums.AccountStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Lab1Test {

    @Test
    @DisplayName("Withdraw more than on the debit account")
    void WithdrawMoreThanOnDebitAccount() {
        AccountBuilder accountBuilder = new AccountBuilder();
        accountBuilder.setName("name")
                .setAccountType("debit")
                .setCashAccount(100)
                .setAddress("1st street")
                .setPassportNumber("101010");
        Account account = accountBuilder.build();
        assertThrows(IllegalArgumentException.class, () -> {
            account.WithdrawMoneyFromAccount(101);
        });
    }

    @Test
    @DisplayName("Withdraw more than on the deposit account")
    void WithdrawMoreThanOnDepositAccount(){
        AccountBuilder accountBuilder = new AccountBuilder();
        accountBuilder.setName("name")
                .setAccountType("deposit")
                .setCashAccount(100)
                .setAddress("1st street")
                .setPassportNumber("101010");
        Account account = accountBuilder.build();
        assertThrows(IllegalArgumentException.class, () -> {
            account.WithdrawMoneyFromAccount(101);
        });
    }

    @Test
    @DisplayName("Withdraw more than on the credit account")
    void WithdrawMoreThanOnCreditAccount(){
        AccountBuilder accountBuilder = new AccountBuilder();
        accountBuilder.setName("name")
                .setAccountType("credit")
                .setCashAccount(100)
                .setAddress("1st street")
                .setPassportNumber("101010")
                .setCashLimit(-100);
        Account account = accountBuilder.build();
        assertThrows(IllegalArgumentException.class, () -> {
            account.WithdrawMoneyFromAccount(201);
        });
    }

    @Test
    @DisplayName("Calculate Credit Account With Commission With Time Manager")
    void CalculateCreditAccountWithCommissionWithTimeManager(){
        AccountBuilder accountBuilder = new AccountBuilder();
        Bank bank = new Bank("Sber", 1);
        accountBuilder.setName("name")
                .setAccountType("credit")
                .setCashAccount(-100)
                .setAddress("1st street")
                .setPassportNumber("101010")
                .setCashLimit(-1000);
        Account account = accountBuilder.build();
        TimeManager timeManager = new TimeManager(100, bank, account);
        timeManager.CalculateCreditCommission();
        assertEquals(-133, account.GetCashAccount());
    }

    @Test
    @DisplayName("Calculate Debit Account With Percent With Time Manager")
    void CalculateDebitAccountWIthPercentWithTimeManager(){
        AccountBuilder accountBuilder = new AccountBuilder();
        Bank bank = new Bank("Sber", 1);
        accountBuilder.setName("name")
                .setAccountType("debit")
                .setCashAccount(100)
                .setAddress("1st street")
                .setPassportNumber("101010");
        Account account = accountBuilder.build();
        TimeManager timeManager = new TimeManager(100, bank, account);
        timeManager.CalculatePercent();
        assertEquals(115, account.GetCashAccount());
    }

    @Test
    @DisplayName("Restore state with withdraw money")
    void RestoreStateWithWithdrawMoney(){
        AccountBuilder accountBuilder = new AccountBuilder();
        accountBuilder.setName("name")
                .setAccountType("debit")
                .setCashAccount(100)
                .setAddress("1st street")
                .setPassportNumber("101010");
        Account account = accountBuilder.build();
        account.WithdrawMoneyFromAccount(50);
        account.WithdrawMoneyFromAccount(10);
        account.RestoreState();
        account.RestoreState();
        assertEquals(100, account.GetCashAccount());
    }

    @Test
    @DisplayName("Restore state with transfer money")
    void RestoreStateWithTransferMoney(){
        AccountBuilder accountBuilder = new AccountBuilder();
        accountBuilder.setName("name")
                .setAccountType("debit")
                .setCashAccount(100)
                .setAddress("1st street")
                .setPassportNumber("101010");
        Account account = accountBuilder.build();
        AccountBuilder accountBuilder1 = new AccountBuilder();
        accountBuilder1.setName("name2")
                .setAccountType("debit")
                .setCashAccount(1000)
                .setAddress("2 street")
                .setPassportNumber("555555");
        Account account1 = accountBuilder1.build();
        account.TransferMoneyToAccount(account1, 100);
        account1.RestoreState();
        assertEquals(1000, account1.GetCashAccount());
    }

    @Test
    @DisplayName("Check questionable account status after create")
    void CheckAccountStatusAfterCreate(){
        AccountBuilder accountBuilder = new AccountBuilder();
        accountBuilder.setName("name")
                .setAccountType("debit")
                .setCashAccount(100);
        Account account = accountBuilder.build();
        assertEquals(AccountStatus.QuestionableAccount, account.getStatus());
    }

    @Test
    @DisplayName("Check reliable account status after create")
    void CheckAccountStatusAfterCreateReliable(){
        AccountBuilder accountBuilder = new AccountBuilder();
        accountBuilder.setName("name")
                .setAccountType("debit")
                .setCashAccount(100)
                .setAddress("address")
                .setPassportNumber("000000");
        Account account = accountBuilder.build();
        assertEquals(AccountStatus.ReliableAccount, account.getStatus());
    }
}