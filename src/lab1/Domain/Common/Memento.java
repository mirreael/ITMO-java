package lab1.Domain.Common;

import lab1.Domain.Enums.AccountStatus;

public class Memento {
    private int cashAccount;
    private String name;
    private int bankId;
    private AccountStatus status;
    private String accountType;
    private String address;
    private String passportNumber;

    public Memento(int cashAccount, String name, int bankId, AccountStatus status, String accountType, String address, String passportNumber) {
        this.cashAccount = cashAccount;
        this.name = name;
        this.bankId = bankId;
        this.status = status;
        this.accountType = accountType;
        this.address = address;
        this.passportNumber = passportNumber;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public int getBankId() {
        return bankId;
    }

    public int getCashAccount() {
        return cashAccount;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAddress() {
        return address;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

}
