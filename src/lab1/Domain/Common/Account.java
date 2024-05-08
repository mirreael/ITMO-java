package lab1.Domain.Common;

import lab1.Domain.Enums.AccountStatus;

public abstract class Account {
    protected int cashAccount;
    protected String name;
    protected int bankId;
    protected AccountStatus status;
    protected String accountType;
    private String address;
    private String passportNumber;

    public Account(int cashAccount,
                   String name,
                   int bankId,
                   AccountStatus accountStatus,
                   String address,
                   String passportNumber){
        this.cashAccount = cashAccount;
        this.name = name;
        this.bankId = bankId;
        this.status = accountStatus;
        this.address = address;
        this.passportNumber = passportNumber;
    }

    public int GetCashAccount(){
        return cashAccount;
    }

    public String getAccountType(){return accountType;}
    public void PutMoneyIntoAccount(int sum){
        System.out.println(STR." -> Current cash: \{cashAccount}");
        try {
            cashAccount += sum;
            System.out.println(STR."Successful put money into account: +\{sum}");
            System.out.println(STR."Current cash: \{cashAccount}");
        } catch (IllegalArgumentException e){
            System.out.println(e);
            System.out.println("Error with put money into account");
        }
    }
    public void TransferMoneyToAccount(){}
    public void WithdrawMoneyFromAccount(int sum){
    }
}
