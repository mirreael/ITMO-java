package lab1.Domain.Entities.Account;

import lab1.Domain.Common.Account;
import lab1.Domain.Enums.AccountStatus;

public class DepositAccount extends Account {

    public DepositAccount(int cashAccount,
                          String name,
                          int bankId,
                          AccountStatus accountStatus,
                          String address,
                          String passportNumber) {
        super(cashAccount, name, bankId, accountStatus, address, passportNumber);
        accountType = "deposit";
    }
    @Override
    public void WithdrawMoneyFromAccount(int sum){
        System.out.println(STR."Current cash: \{cashAccount}");
        if (cashAccount - sum < 0 ){
            System.out.println("account score is less than 0");
            throw new IllegalArgumentException();
        }
        cashAccount -= sum;
        System.out.println("Success withdraw money from account");
        System.out.println(STR."Current cash: \{cashAccount}");
    }

}
