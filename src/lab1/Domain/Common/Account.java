package lab1.Domain.Common;

import lab1.Domain.Enums.AccountStatus;

public abstract class Account {
    protected int cashAccount;
    private int accountId;
    private int bankId;
    private int clientId;
    private AccountStatus status;

    public Account(int cashAccount,
                   int accountId,
                   int bankId,
                   int clientId,
                   AccountStatus accountStatus){
        this.cashAccount = cashAccount;
        this.accountId = accountId;
        this.bankId = bankId;
        this.clientId = clientId;
        this.status = accountStatus;
    }

    public int GetCashAccount(){
        return cashAccount;
    }
    public int getAccountId(){
        return accountId;
    }

    public int getBankId() {
        return bankId;
    }

    public int getClientId() {
        return clientId;
    }

    public AccountStatus getStatus() {
        return status;
    }
    public void PutMoneyIntoAccount(int sum){
        System.out.println(" -> Current cash: " + cashAccount);
        try {
            cashAccount += sum;
            System.out.println("Successful put money into account: +" + sum);
            System.out.println("Current cash: " + cashAccount);
        } catch (IllegalArgumentException e){
            System.out.println(e);
            System.out.println("Error with put money into account");
        }
    }
    public void TransferMoneyToAccount(){}
    public void WithdrawMoneyFromAccount(int sum){
    }
}
