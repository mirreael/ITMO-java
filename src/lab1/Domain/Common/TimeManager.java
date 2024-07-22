package lab1.Domain.Common;

import lab1.Domain.Entities.Account.CreditAccount;
import lab1.Domain.Entities.Bank;

import java.util.Objects;

public class TimeManager {
    private int days;
    private Bank bank;
    private Account account;
    private int commission;
    private int percent;

    public TimeManager(int days, Bank bank, Account account){
        this.days = days;
        this.bank = bank;
        this.account = account;
    }

    public void CalculateCreditCommission(){
        if (!Objects.equals(account.getAccountType(), "credit")){
            throw new IllegalArgumentException("Account is not credit");
        }
        int month = 0;
        for (int day = 1; day < days; day ++){
            if (day % 30 == 0){
                month +=1;
                System.out.println(STR."\{month} month has passed.");
                bank.CalculateCashWithCreditCommission((CreditAccount) account);
                commission = bank.getCreditCommission();
            }
        }
    }

    public void CalculatePercent(){
        int month = 0;
        for (int day = 1; day < days; day ++){
            if (day % 30 == 0){
                month +=1;
                System.out.println(STR."\{month} month has passed.");
                bank.CalculatePercent(account);
            }
        }
    }
}
