package M04_JavaOOP.L11_TestDrivenDevelopment.Exercises;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private List<Transaction> transactions;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        prepareTransactions();
    }

    @Test
    public void testContainsReturnTrue() {
        Transaction transaction = transactions.get(0);
        chainblock.add(transaction);
        assertTrue(this.chainblock.contains(transaction));
    }

    @Test
    public void testContainsReturnFalse() {
        Transaction transaction = transactions.get(0);
        assertFalse(this.chainblock.contains(transaction));
    }

    @Test
    public void testContainsIdShouldReturnFalse() {
        assertFalse(this.chainblock.contains(10));
    }

    @Test
    public void testContainsIdShouldReturnTrue() {
        Transaction transaction = this.transactions.get(0);
        this.chainblock.add(transaction);
        assertTrue(this.chainblock.contains(1));
    }

    @Test
    public void testShouldAddTransactionCorrectly() {
        this.chainblock.add(this.transactions.get(0));
        assertEquals(1, this.chainblock.getCount());

        this.chainblock.add(transactions.get(1));
        assertEquals(2, this.chainblock.getCount());
    }

    @Test
    public void testShouldFailTransactionAdding() {
        Transaction transaction = this.transactions.get(0);
        this.chainblock.add(transaction);
        this.chainblock.add(transaction);
        assertEquals(1, this.chainblock.getCount());
    }

    @Test
    public void testShouldGetTransactionsCount() {
        Transaction transaction = this.transactions.get(0);
        assertEquals(0, this.chainblock.getCount());

        this.chainblock.add(transaction);
        assertEquals(1, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldFailInvalidTransactionStatusChange() {
        this.chainblock.changeTransactionStatus(100, TransactionStatus.ABORTED);
    }

    @Test
    public void testShouldChangeTransactionStatusCorrectly() {
        Transaction transaction = this.transactions.get(0);
        this.chainblock.add(transaction);
        this.chainblock.changeTransactionStatus(1, TransactionStatus.UNAUTHORIZED);
        assertEquals(TransactionStatus.UNAUTHORIZED, this.chainblock.getById(1).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForWrongId() {
        this.chainblock.getById(100);
    }

    @Test
    public void testShouldGetTheTransactionById() {
        fillChainBlockWithTransactions();
        Transaction actualTransaction = this.chainblock.getById(1);
        assertEquals(1, actualTransaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowsExceptionForNoSuchTransactionWithTheGivenId() {
        fillChainBlockWithTransactions();
        this.chainblock.removeTransactionById(100);
    }

    @Test
    public void testShouldRemoveTransactionByIdSuccessfully() {
        fillChainBlockWithTransactions();
        this.chainblock.removeTransactionById(1);
        assertEquals(3, this.chainblock.getCount());
        assertFalse(this.chainblock.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldGetWrongTransactionStatus() {
        this.chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testShouldGetTransactionStatusSuccessfully() {
        this.transactions.sort(Comparator.comparing(Transaction::getAmount).reversed());
        fillChainBlockWithTransactions();

        List<Transaction> successfulTransactions = this.transactions
                .stream()
                .filter(transaction -> transaction.getStatus()
                        .equals(TransactionStatus.SUCCESSFUL))
                .collect(Collectors.toList());

        Iterable<Transaction> actualTransactions = this.chainblock
                .getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        List<Transaction> actualTransactionsList = new ArrayList<>();
        actualTransactions.forEach(actualTransactionsList::add);

        assertEquals(successfulTransactions, actualTransactionsList);
    }

    @Test
    public void testShouldGetAllTransactionsInTheGivenRange() {
        fillChainBlockWithTransactions();

        Iterable<Transaction> resultTransactions = this.chainblock.getAllInAmountRange(10, 12);

        for (Transaction transaction : resultTransactions) {
            assertTrue(transaction.getAmount() >= 10);
            assertTrue(transaction.getAmount() <= 12);
        }
    }

    @Test
    public void testGetAllInAmountWrongRange() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> resultTransaction = this.chainblock.getAllInAmountRange(1000, 2000);

        List<Transaction> resultList = new ArrayList<>();
        resultTransaction.forEach(resultList::add);

        assertTrue(resultList.isEmpty());
    }

    @Test
    public void testShouldGetAllSendersWithTransactionStatus() {
        fillChainBlockWithTransactions();
        List<Transaction> resultTransaction = new ArrayList<>();

        for (Transaction transaction : this.transactions) {
            if (transaction.getStatus().equals(TransactionStatus.SUCCESSFUL)) {
                resultTransaction.add(transaction);
            }
        }

        assertEquals(2, resultTransaction.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchTransactionStatus() {
        this.chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testShouldGetAllSendersWithTransactionStatusReceiver() {
        fillChainBlockWithTransactions();
        List<Transaction> resultTransaction = new ArrayList<>();

        for (Transaction transaction : this.transactions) {
            if (transaction.getStatus().equals(TransactionStatus.SUCCESSFUL)) {
                resultTransaction.add(transaction);
            }
        }

        assertEquals(2, resultTransaction.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchTransactionStatusReceiver() {
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testShouldReturnAllOrderedByAmountDescendingThenById() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "George", "Preslav", 10.00);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Preslava", "George", 12.00);

        this.chainblock.add(transaction1);
        this.chainblock.add(transaction2);

        Iterable<Transaction> actual = this.chainblock.getAllOrderedByAmountDescendingThenById();

        Transaction[] expected = new Transaction[2];
        expected[0] = transaction2;
        expected[1] = transaction1;

        int index = 0;
        for (Transaction transaction : actual) {
            assertEquals(expected[index++], transaction);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchSenderWithTHeGivenName() {
        this.chainblock.getBySenderOrderedByAmountDescending("Hachiko");
    }

    @Test
    public void testShouldReturnAllTransactionsFromTheSender() {
        fillChainBlockWithTransactions();

        Iterable<Transaction> actual = this.chainblock.getBySenderOrderedByAmountDescending("George");
        for (Transaction transaction : actual) {
            assertEquals("George", transaction.getFrom());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchReceiver() {
        this.chainblock.getByReceiverOrderedByAmountThenById("Frank");
    }

    @Test
    public void testShouldReturnAllTransactionsForTheReceiver() {
        fillChainBlockWithTransactions();

        Iterable<Transaction> actual = this.chainblock.getByReceiverOrderedByAmountThenById("Preslav");
        for (Transaction transaction : actual) {
            assertEquals("Preslav", transaction.getTo());
        }
    }

    @Test
    public void testShouldReturnTransactionStatusAndMaximumAmount() {
        fillChainBlockWithTransactions();

        Iterable<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 10.00);

        for (Transaction transaction : actual) {
            assertEquals(TransactionStatus.SUCCESSFUL, transaction.getStatus());
        }
    }

    @Test
    public void testShouldReturnArrayListForNoSuchItems() {
        this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 10.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchTransaction() {
        this.chainblock.getBySenderAndMinimumAmountDescending("George", 10.00);
    }

    @Test
    public void testShouldGetSenderAndMinimumAmountDescendingTransactions() {
        fillChainBlockWithTransactions();

        Iterable<Transaction> actual = this.chainblock
                .getBySenderAndMinimumAmountDescending("George", 10.0);

        for (Transaction transaction : actual) {
            assertEquals("George", transaction.getFrom());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNoSuchReceiverAndAmount() {
        this.chainblock.getByReceiverAndAmountRange("Gorilla", 10.00, 12.00);
    }

    @Test
    public void testShouldGetTransactionOfReceiverInTheRange() {
        fillChainBlockWithTransactions();

        Iterable<Transaction> actual = this.chainblock.getByReceiverAndAmountRange("Preslav", 10, 200);
        for (Transaction transaction : actual) {
            assertEquals("Preslav", transaction.getTo());
        }
    }

    public void prepareTransactions() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "George", "Preslav", 10.00);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "George", "Peno", 12.00);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.UNAUTHORIZED, "George", "Preslav", 100.00);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.FAILED, "Swinvan", "Faitan", 5.00);

        this.transactions.add(transaction1);
        this.transactions.add(transaction2);
        this.transactions.add(transaction3);
        this.transactions.add(transaction4);
    }

    public void fillChainBlockWithTransactions() {
        this.transactions.forEach(existingTransaction ->
                this.chainblock.add(existingTransaction));
    }
}