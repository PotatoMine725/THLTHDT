package nganhang;

import java.time.LocalDateTime;

public class Transaction {
    private String accountNumber;
    private String type; // e.g., "deposit", "withdrawal"
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}