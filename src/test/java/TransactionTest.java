import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    void addTransaction() {
        Transaction toAdd = new Transaction(1, 2, "£", 10, "You owe me a couple fireballs");
        TransactionController.addTransaction(toAdd);
    }
}
