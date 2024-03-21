package lab1.Domain.Factory;

import lab1.Application.Interfaces.IAccountFactory;
import lab1.Domain.Entities.Account.DepositAccount;
import lab1.Domain.Common.Account;

public class DepositAccountFactory implements IAccountFactory {
    @Override
    public Account createAccount() {
        return new DepositAccount();
    }
}
