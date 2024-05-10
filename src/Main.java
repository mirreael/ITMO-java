import lab1.Application.AccountBuilder.AccountBuilder;
import lab1.Domain.Common.Account;
import lab1.Domain.Entities.Bank;

void main() {
    Bank bank = new Bank("Sber", 1);
    AccountBuilder accountBuilder = new AccountBuilder();
    accountBuilder.setCashAccount(2000)
            .setBankId(1)
            .setName("name")
            .setAccountType("debit")
            .setPassportNumber("1")
            .setAddress("aye street");
    Account accountFrom = accountBuilder.build();


}
