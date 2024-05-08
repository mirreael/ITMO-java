package lab1.Application.Interfaces;
import lab1.Domain.Common.Account;
import lab1.Domain.Entities.Bank;

public interface ICentralBank {
    void CreateNewBank(Bank bank);
    void CancelTransaction(Bank bank, int transactionID);
    void TransferMoneyToAnotherBank(Account SendersAccount, Bank PayeesBank, Account PayeesAccount, int cash);
}