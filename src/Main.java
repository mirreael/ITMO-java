import lab1.Domain.Common.Account;
import lab1.Domain.Factory.CreditAccountFactory;
import lab1.Application.Interfaces.IAccountFactory;

void main(){
    IAccountFactory factory = new CreditAccountFactory();
    Account account = factory.createAccount();
}