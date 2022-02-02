package M04_JavaOOP.L11_TestDrivenDevelopment.Exercises;

public interface Transaction {
    int getId();
    TransactionStatus getStatus();
    void setStatus(TransactionStatus status);
    double getAmount();
    String getFrom();
    String toString();
    String getTo();
}