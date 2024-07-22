package lab1.Domain.Entities.Account;

import lab1.Domain.Common.Account;
import lab1.Domain.Enums.AccountStatus;

public class DepositAccount extends Account {

    public DepositAccount(int cashAccount,
                          String name,
                          AccountStatus accountStatus,
                          String address,
                          String passportNumber) {
        super(cashAccount, name, accountStatus, address, passportNumber);
        accountType = "deposit";
    }

}
