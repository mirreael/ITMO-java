package lab1.Domain.Entities.Account;

import lab1.Domain.Common.Account;
import lab1.Domain.Enums.AccountStatus;

public class CreditAccount extends Account {
    private final int cashLimit;
    public CreditAccount(int cashAccount,
                  String name,
                  int bankId,
                  int cashLimit,
                  AccountStatus accountStatus,
                  String address,
                  String passportNumber){
        super(cashAccount, name, bankId, accountStatus, address, passportNumber);
        this.cashLimit = cashLimit;
        accountType = "credit";
    }

    @Override
    public void WithdrawMoneyFromAccount(int sum){
        CheckAccountStatus();
        System.out.println(STR." -> Current cash: \{cashAccount}");
        if (cashAccount - sum < cashLimit){
            System.out.println(STR."account score is less than \{cashLimit}");
            throw new IllegalArgumentException();
        }
        cashAccount -= sum;
        System.out.println("Success withdraw money from account");
        System.out.println(STR."Current cash: \{cashAccount}");
    }

    public void AccrueCommission(int commission){
        System.out.println(STR." -> Current cash: \{cashAccount}");
        cashAccount -= commission;
        System.out.println("Success accrue commission to account");
        System.out.println(STR."Current cash: \{cashAccount}");
    }
}