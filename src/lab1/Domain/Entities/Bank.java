package lab1.Domain.Entities;

import lab1.Domain.Common.Account;
import lab1.Domain.Entities.Account.CreditAccount;
import lab1.Domain.Entities.Account.DepositAccount;

public class Bank {
    private final String bankName;
    private final int bankId;
    private int debitPercent;
    private int depositPercent;
    private int creditCommission;

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
        System.out.println("Debit percent is: "+debitPercent);
    }

    public int getDepositPercent() {
        return depositPercent;
    }

    private void setDepositPercent(int depositPercent) {
        this.depositPercent = depositPercent;
    }

    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void CalculateCashAccountWithDebitPercent(Account debitAccount) {
        try {
            int currentCash = debitAccount.GetCashAccount();
            int percentCash = (int)(((double)debitPercent / 100.0) * currentCash);
            debitAccount.PutMoneyIntoAccount(percentCash);
        } catch (IllegalArgumentException e) {
            System.out.println("Debit percent is incorrect");
            throw new IllegalArgumentException("incorrect percent");
        }
    }

    private void CalculateDepositPercent(int currentCash) {
        if (currentCash <= 50000){
            setDepositPercent(3);
        } else if (currentCash <= 100000) {
            setDepositPercent(4);
        } else {
            setDepositPercent(5);
        }
    }

    public void CalculateCashAccountWithDepositPercent(DepositAccount depositAccount){
        CalculateDepositPercent(depositAccount.GetCashAccount());
        try {
            int currentCash = depositAccount.GetCashAccount();
            int percentCash = depositPercent / 100 * currentCash;
            depositAccount.PutMoneyIntoAccount(percentCash);
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit percent is incorrect");
            throw new IllegalArgumentException("incorrect percent");
        }
    }

    public void CalculateCashWithCreditCommission(CreditAccount creditAccount){
        if (creditAccount.GetCashAccount() < 0){
            creditAccount.WithdrawMoneyFromAccount(creditCommission / 100 * creditAccount.GetCashAccount());
        }
    }
}