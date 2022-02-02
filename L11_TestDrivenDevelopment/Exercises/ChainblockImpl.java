package M04_JavaOOP.L11_TestDrivenDevelopment.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        this.transactionMap = new HashMap<>();
    }

    public int getCount() {
        return this.transactionMap.size();
    }

    public void add(Transaction transaction) {
        if (!this.contains(transaction)) {
            this.transactionMap.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.transactionMap.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }

        Transaction transaction = this.transactionMap.get(id);
        transaction.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }

        this.transactionMap.remove(id);
    }

    public Transaction getById(int id) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }

        return this.transactionMap.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getStatus().equals(status)) {
                filteredTransactions.add(transaction);
            }
        }

        if (filteredTransactions.size() == 0) {
            throw new IllegalArgumentException();
        }

        return filteredTransactions
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .reversed())
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> transactionsWithStatus = new ArrayList<>();

        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getStatus().equals(status)) {
                transactionsWithStatus.add(transaction.toString());
            }
        }

        if (transactionsWithStatus.size() == 0) {
            throw new IllegalArgumentException();
        }

        return new ArrayList<>(transactionsWithStatus);
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> receiversWithStatus = new ArrayList<>();

        for (Transaction transaction : this.transactionMap.values()) {
            if (transaction.getStatus().equals(status)) {
                receiversWithStatus.add(transaction.getTo());
            }
        }

        if (receiversWithStatus.size() == 0) {
            throw new IllegalArgumentException();
        }

        return new ArrayList<>(receiversWithStatus);
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionMap.values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .sorted()
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactionsBySender = this.transactionMap
                .values()
                .stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .collect(Collectors.toList());

        if (transactionsBySender.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactionsBySender;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = this.transactionMap
                .values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount))
                .sorted(Comparator.comparing(Transaction::getId))
                .filter(transaction -> transaction.getTo().equals(receiver))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactions = this.transactionMap.values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .filter(transaction -> transaction.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            return new ArrayList<>();
        } else {
            return transactions;
        }
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = this.transactionMap
                .values()
                .stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .filter(transaction -> transaction.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = this.transactionMap
                .values()
                .stream()
                .filter(transaction -> transaction.getTo().equals(receiver))
                .filter(transaction -> transaction.getAmount() >= lo &&
                        transaction.getAmount() < hi)
                .sorted(Comparator.comparing(Transaction::getAmount)
                        .thenComparing(Comparator.comparing(Transaction::getId)))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterator<Transaction> iterator() {
       return this.transactionMap.values().iterator();
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.transactionMap
                .values()
                .stream()
                .filter(transaction -> transaction.getAmount() >= lo
                        && transaction.getAmount() <= hi)
                .collect(Collectors.toList());
    }
}