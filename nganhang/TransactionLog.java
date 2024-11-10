package nganhang;

import java.util.ArrayList;
import java.util.List;

public class TransactionLog {
    private List<Transaction> transactions;

    public TransactionLog() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printLog() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
