import lab1.Domain.Common.Account;
import lab1.Domain.Entities.Account.DebitAccount;
import lab1.Domain.Entities.Bank;
import lab1.Domain.Enums.AccountStatus;

void main() {
    Bank bank = new Bank("Sber", 1);
    //100% мне нужен билдер. Без него не получается отслеживать Account Status
    Account account = new DebitAccount(100, 1, 1, 1, AccountStatus.ReliableAccount);
    bank.setDebitPercent(15);
    bank.CalculateCashAccountWithDebitPercent(account);
}
