package lab1.Domain.Common;

import java.util.Stack;

public class TransactionHistory {
    public Stack<Memento> History;
    public TransactionHistory(){
        History = new Stack<Memento>();
    }
}
