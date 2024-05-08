package lab1.Domain.Entities.Account;

import lab1.Domain.Common.Account;
import lab1.Domain.Enums.AccountStatus;

public class DepositAccount extends Account {
    //Дебетовый счет – обычный счет с фиксированным процентом на остаток.
    // Деньги можно снимать в любой момент, в минус уходить нельзя. Комиссий нет.

    public DepositAccount(int cashAccount,
                          int accountId,
                          int bankId,
                          int clientId,
                          AccountStatus accountStatus) {
        super(cashAccount, accountId, bankId, clientId, accountStatus);
    }
    public void WithdrawMoneyFromAccount(int sum){
        System.out.println("Current cash: " + cashAccount);
        if (cashAccount - sum < 0 ){
            System.out.println("account score is less than 0");
            throw new IllegalArgumentException();
        }
        cashAccount -= sum;
        System.out.println("Success withdraw money from account");
        System.out.println("Current cash: " + cashAccount);
    }

}
