import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransactionTest {

    @Test
    void addTransaction() throws SQLException {
        Transaction toAdd = new Transaction("Nexiimil", "Maria", "£", 10, "You owe me a couple " +
                "fireballs", false, LocalDateTime.now(), null);
        TransactionController.addTransaction(toAdd);
    }

    @Test
    void markAsPaid() {
    }
}
