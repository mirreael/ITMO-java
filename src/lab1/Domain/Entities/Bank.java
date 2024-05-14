package lab1.Domain.Entities;

import lab1.Domain.Common.Account;
import lab1.Domain.Entities.Account.CreditAccount;

public class Bank {
    private final String bankName;
    private final int bankId;
    private int debitPercent = 5;
    private int depositPercent = 10;
    private int creditCommission = 10;

    public Bank(String bankName, int bankId) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    public int getCreditCommission() {
        return creditCommission;
    }

    public void setCreditCommission(int creditCommission) {
        this.creditCommission = creditCommission;
    }

    public int getDebitPercent() {
        return debitPercent;
    }

    public void setDebitPercent(int debitPercent) {
        this.debitPercent = debitPercent;
        System.out.println(STR."Debit percent is: \{debitPercent}");
    }

    public void setDepositPercent(int depositPercent) {
        this.depositPercent = depositPercent;
    }

    public int getDepositPercent() {
        return depositPercent;
    }

    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }

    private void setDepositPercent(Account account) {
        if (account.GetCashAccount() <= 50000){
            depositPercent = 3;
        } else if (account.GetCashAccount() <= 100000) {
            depositPercent = 4;
        } else {
            depositPercent = 5;
        }
    }
    public void CalculatePercent(Account account){
        System.out.println(STR."Calculate percent for \{account.getAccountType()} account");
        switch (account.getAccountType()){
            case "debit":
                CalculateCashAccountWithDebitPercent(account);
                break;
            case "deposit":
                CalculateCashAccountWithDepositPercent(account);
                break;
            case "credit":
                throw new IllegalArgumentException("Credit account hasn't cash percent");
        }
    }

    private void CalculateCashAccountWithDebitPercent(Account debitAccount) {
        try {
            int currentCash = debitAccount.GetCashAccount();
            int percentCash = (int)(((double)debitPercent / 100.0) * currentCash);
            debitAccount.PutMoneyIntoAccount(percentCash);
        } catch (IllegalArgumentException e) {
            System.out.println("Debit percent is incorrect");
            throw new IllegalArgumentException("incorrect percent");
        }
    }

    private void CalculateCashAccountWithDepositPercent(Account depositAccount){
        setDepositPercent(depositAccount);
        try {
            int currentCash = depositAccount.GetCashAccount();
            int percentCash = (int)(((double)depositPercent / 100.0) * currentCash);
            depositAccount.PutMoneyIntoAccount(percentCash);
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit percent is incorrect");
            throw new IllegalArgumentException("incorrect percent");
        }
    }

    public void CalculateCashWithCreditCommission(CreditAccount creditAccount){
        if (creditAccount.GetCashAccount() < 0){
            try {
                int commission = (int)((double)creditCommission / 100 * Math.abs(creditAccount.GetCashAccount()));
                creditAccount.AccrueCommission(commission);
            } catch (IllegalArgumentException e) {
                System.out.println("Commission is incorrect");
                throw new IllegalArgumentException("incorrect commission");
            }
        }
    }
}