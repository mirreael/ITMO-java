package lab1.Domain.Common;

public abstract class Account {
    private Integer cashAccount;

    public Integer getCashAccount() {
        return cashAccount;
    }

    public int WithdrawMoneyFromAccount(int cashAccount, int sum){
        return cashAccount-sum;
    }
    public void PutMoneyIntoAccount(){}
    public void TransferMoneyToAccount(){}
}
