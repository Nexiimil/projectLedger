import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TransactionTest {

    @Test
    void addTransaction() throws SQLException {
        Transaction toAdd = new Transaction(1, 2, "£", 10, "You owe me a couple fireballs");
        TransactionController.addTransaction(toAdd);
    }
}
