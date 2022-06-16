import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionController {
  private static final ExecutorSingleton exec = ExecutorSingleton.getInstance();
  private static final ConnectionSingleton conn = ConnectionSingleton.getInstance();

  public static void addTransaction(Transaction toAdd) throws SQLException {
    PreparedStatement ps = conn.getConnection().prepareStatement("INSERT INTO Transactions "
            + "(subjectname, targetName, currency, value, ref, paid, datefiled, datepaid) "
            + "VALUES (?,?,?,?,?,?,?,?)");
    ps.setString(1, toAdd.getSubjectName());
    ps.setString(2, toAdd.getTargetName());
    ps.setString(3, toAdd.getCurrency());
    ps.setDouble(4, toAdd.getValue());
    ps.setString(5, toAdd.getRef());
    ps.setBoolean(6, toAdd.isPaid());
    ps.setObject(7, toAdd.getDateFiled());
    ps.setObject(8, toAdd.getDatePaid());
    exec.withoutResults(ps);
  }

  public static void markAsPaid(int transactionID) throws SQLException {
    PreparedStatement ps = conn.getConnection().prepareStatement("UPDATE Transactions "
            + "SET paid = true WHERE id = ?)");
    ps.setInt(1, transactionID);

    exec.withoutResults(ps);
  }
}
