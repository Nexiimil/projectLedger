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
  void markAsPaid() throws SQLException {
    Transaction toAdd = new Transaction("Nexiimil", "Maria", "£", 10, "You owe me a couple " +
            "fireballs", false, LocalDateTime.now(), null);
    TransactionController.addTransaction(toAdd);
    TransactionController.markAsPaid(3);
  }

  @Test
  void deleteTransaction() throws SQLException {
    TransactionController.deleteTransaction(2);
  }

  @Test
  void compactTransactions() {

  }
}
