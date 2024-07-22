package lab1.Application.AccountBuilder;

import lab1.Domain.Common.Account;
import lab1.Domain.Entities.Bank;

import java.util.Scanner;

public class ConsoleInterface {
    private Scanner scanner;
    private Account account;
    private Bank bank;
    public ConsoleInterface(){
        this.scanner = new Scanner(System.in);
    }

    private void DisplayMenu(){
        System.out.println("1. Создать счет");
        System.out.println("2. Создать банк");
        System.out.println("3. Провести транзакцию");
        System.out.println("4. Выход");
    }

    public void UserInput(){
        int input;
        do {
            DisplayMenu();
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1:
                    CreateAccount();
                    break;
                case 2:
                    CreateBank();
                    break;
                case 3:
                    MakeTransaction();
                    break;
                case 4:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Некорректный ввод");
            }
        } while (input != 4);
    }

    private void MakeTransaction(){
        CreateAccount();
        SelectTransaction();
    }

    private void CreateBank(){
        System.out.println("Введите имя банка: ");
        String bankName = scanner.nextLine();
        bank = new Bank(bankName, 1);
        SelectBankPercentAndCommission();
    }

    private void CreateAccount(){
        if (account == null) {
            AccountBuilder accountBuilder = new AccountBuilder();
            String input = enterName();
            accountBuilder.setName(input);
            input = enterAddress();
            if (!input.isEmpty()) {
                accountBuilder.setAddress(input);
            }
            input = enterPassportNumber();
            if (!input.isEmpty()) {
                accountBuilder.setPassportNumber(input);
            }
            selectAccountType(accountBuilder);
            account = accountBuilder.build();
        }
    }

    private String enterName() {
        String input;
        do {
            System.out.println("Введите имя: ");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Имя не может быть пустым. Пожалуйста, введите имя.");
            }
        } while (input.isEmpty());
        return input;
    }

    private String enterAddress() {
        System.out.println("Введите адрес или \"enter\", чтобы продолжить: ");
        return scanner.nextLine();
    }

    private String enterPassportNumber() {
        System.out.println("Введите номер паспорта или \"enter\", чтобы продолжить: ");
        return scanner.nextLine();
    }

    private void selectAccountType(AccountBuilder accountBuilder) {
        AccountMenu();
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                accountBuilder.setAccountType("debit");
                break;
            case "2":
                accountBuilder.setAccountType("deposit");
                break;
            case "3":
                accountBuilder.setAccountType("credit");
                accountBuilder.setCashLimit(-1000);
                break;
            default:
                System.out.println("Некорректный ввод");
        }
    }


    private void AccountMenu(){
        System.out.println("Выберете тип счета: ");
        System.out.println("1. Дебетовый счет");
        System.out.println("2. Депозитный счет");
        System.out.println("3. Кредитный счет");
    }

    private void BankMenu(){
        System.out.println("1. Установить дебетовый процент");
        System.out.println("2. Установить депозитный процент");
        System.out.println("3. Установить комиссию");
        System.out.println("4. Использовать проценты по умолчанию");
    }

    private void TransactionMenu(){
        System.out.println("1. Положить деньги на счет");
        System.out.println("2. Снять деньги со счета");
        System.out.println("3. Перевести деньги на другой счет");
        System.out.println("3. Отменить транзакцию");
    }

    private void SelectTransaction(){
        TransactionMenu();
        String input = scanner.nextLine();
        switch (input){
            case "1":
                System.out.println("Введите сумму");
                account.PutMoneyIntoAccount(scanner.nextInt());
                break;
            case "2":
                System.out.println("Введите сумму");
                account.WithdrawMoneyFromAccount(scanner.nextInt());
                break;
            case "3":
                System.out.println("Введите сумму");
                System.out.println("Введите номер счета: ");
                account.WithdrawMoneyFromAccount(scanner.nextInt());
                break;
            case "4":
                account.RestoreState();
                break;
            default:
                System.out.println("Некорректный ввод");
        }
    }

    private void SelectBankPercentAndCommission(){
        BankMenu();
        String input = scanner.nextLine();
        switch (input){
            case "1":
                System.out.println("Введите дебетовый процент");
                bank.setDebitPercent(scanner.nextInt());
                break;
            case "2":
                System.out.println("Введите депозитный процент");
                bank.setDepositPercent(scanner.nextInt());
                break;
            case "3":
                System.out.println("Введите размер комиссии");
                bank.setCreditCommission(scanner.nextInt());
                break;
            case "4":
                break;
            default:
                System.out.println("Некорректный ввод");
        }
    }
}
