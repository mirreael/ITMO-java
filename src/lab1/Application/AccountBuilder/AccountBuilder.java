package lab1.Application.AccountBuilder;

import lab1.Domain.Common.Account;
import lab1.Domain.Entities.Account.CreditAccount;
import lab1.Domain.Entities.Account.DebitAccount;
import lab1.Domain.Entities.Account.DepositAccount;
import lab1.Domain.Enums.AccountStatus;

public class AccountBuilder {
    private int cashLimit;
    private int cashAccount;
    private String name;
    private String accountType;
    private AccountStatus accountStatus;
    private String address;
    private String passportNumber;

    public AccountBuilder setCashAccount(int cashAccount) {
        this.cashAccount = cashAccount;
        return this;
    }

    public AccountBuilder setName(String name) {
        this.name = name;
        return this;
    }


    public AccountBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public AccountBuilder setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
        return this;
    }

    public AccountBuilder setCashLimit(int cashLimit) {
        this.cashLimit = cashLimit;
        return this;
    }

    public AccountBuilder setAccountType(String accountType){
        this.accountType = accountType;
        return this;
    }

    public Account build() {
        Account account;
        validateAccountName();
        setAccountStatus();
        return switch (accountType) {
            case "debit" -> {
                account = new DebitAccount(cashAccount, name, accountStatus, address, passportNumber);
                yield account;
            }
            case "deposit" -> {
                account = new DepositAccount(cashAccount, name, accountStatus, address, passportNumber);
                yield account;
            }
            case "credit" -> {
                account = new CreditAccount(cashAccount, name, cashLimit, accountStatus, address, passportNumber);
                yield account;
            }
            default -> throw new IllegalArgumentException("Account is incorrect");
        };

    }

    private void setAccountStatus(){
        if (address == null || passportNumber == null){
            accountStatus = AccountStatus.QuestionableAccount;
        }
        else {
            accountStatus = AccountStatus.ReliableAccount;
        }
    }

    private void validateAccountName(){
        if (name == null){
            throw new IllegalArgumentException("Name is null");
        }
    }

}
