package lab1.Domain.Common;
import lab1.Domain.Enums.AccountStatus;

public abstract class Account {
    private final TransactionHistory transactionHistory = new TransactionHistory();
    private Memento memento;
    protected int cashAccount;
    protected String name;
    protected int bankId;
    protected AccountStatus status;
    protected String accountType;
    private String address;
    private String passportNumber;

    public Account(int cashAccount,
                   String name,
                   int bankId,
                   AccountStatus accountStatus,
                   String address,
                   String passportNumber){
        this.cashAccount = cashAccount;
        this.name = name;
        this.bankId = bankId;
        this.status = accountStatus;
        this.address = address;
        this.passportNumber = passportNumber;
    }

    public int GetCashAccount(){
        return cashAccount;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getAccountType(){return accountType;}

    public void WithdrawMoneyFromAccount(int sum){
        CheckAccountStatus();
        memento = SaveState();
        transactionHistory.History.push(memento);
        System.out.println(STR." -> Current cash: \{cashAccount}");
        if (cashAccount - sum < 0){
            System.out.println(STR."account score is less than \{cashAccount}");
            RestoreState();
            throw new IllegalArgumentException();
        }
        cashAccount -= sum;
        System.out.println("Success withdraw money from account");
        System.out.println(STR."Current cash: \{cashAccount}");
    }

    public void PutMoneyIntoAccount(int sum){
        System.out.println(STR." -> Current cash: \{cashAccount}");
        try {
            cashAccount += sum;
            System.out.println(STR."Successful put money into account: +\{sum}");
            System.out.println(STR."Current cash: \{cashAccount}");
        } catch (IllegalArgumentException e){
            System.out.println(e);
            System.out.println("Error with put money into account");
        }
    }

    public void TransferMoneyToAccount(Account toAccount, int sum){
        Memento mementoFrom = SaveState();
        Memento mementoTo = toAccount.SaveState();
        try {
            this.WithdrawMoneyFromAccount(sum);
            toAccount.PutMoneyIntoAccount(sum);
            System.out.println(STR."Successful transfer money: \{this.getName()} -> \{toAccount.getName()}");
        } catch (IllegalArgumentException e){
            System.out.println("Exception with transfer money");
            RestoreState();
            toAccount.RestoreState();
        }
    }

    protected void CheckAccountStatus(){
        if (status == AccountStatus.QuestionableAccount){
            System.out.println("Questionable account; You can't withdraw money");
            throw new IllegalArgumentException();
        }
    }

    public Memento SaveState(){
        System.out.println("Save current state");
        return new Memento(cashAccount, name, bankId, status, accountType, address, passportNumber);
    }

    public void RestoreState(){
        System.out.println("\nRestore state");
        memento = transactionHistory.History.pop();
        this.cashAccount = memento.getCashAccount();
        System.out.println(STR."Current cash: \{cashAccount}");
    }
}
