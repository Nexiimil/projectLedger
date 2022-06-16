import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

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

  public static void deleteTransaction(int transactionID) throws SQLException{
    PreparedStatement ps = conn.getConnection().prepareStatement("DELETE FROM Transactions "
            + "WHERE id = ?");
    ps.setInt(1, transactionID);

    exec.withoutResults(ps);
  }


  public static void markAsPaid(int transactionID) throws SQLException {
    PreparedStatement ps = conn.getConnection().prepareStatement("UPDATE Transactions "
            + "SET paid = true WHERE id = ?");
    ps.setInt(1, transactionID);

    exec.withoutResults(ps);
  }

  public static void compactTransactions() throws SQLException {
    //find all unique subject-target pairs
    PreparedStatement ps = conn.getConnection().prepareStatement("SELECT DISTINCT subjectname, "
            + "targetname FROM transactions WHERE datefiled >= ?");
    ps.setObject(1, LocalDateTime.now().minusMonths(1));

    ResultSet rs = exec.withResults(ps);
    Set<Pair> pairs = null;
    while (rs.next()) {
      Pair pair = new Pair(rs.getString(1), rs.getString(2));
      if (!pairs.contains(pair)) {
        pairs.add(pair);
      }
    }
    //for each pair: pull all transactions, total values, and add transaction of that total
    if (pairs != null) {
      for (Pair subjectTarget : pairs) {
        String subject = subjectTarget.getFirstElement();
        String target = subjectTarget.getSecondElement();
        ps = conn.getConnection().prepareStatement("SELECT SUM(value) AS Total " +
                "FROM transactions WHERE (subjectname = ? AND targetname = ?)");
        ps.setString(1, subject);
        ps.setString(2, target);
        int subjectTotal = exec.withResults(ps).getInt(1);
        ps = conn.getConnection().prepareStatement("SELECT SUM(value) AS Total " +
                "FROM transactions WHERE (subjectname = ? AND targetname = ?)");
        ps.setString(1, target);
        ps.setString(2, subject);
        int targetTotal = exec.withResults(ps).getInt(1);
        subjectTotal -= targetTotal;
        if(subjectTotal == 0){

        }else if (subjectTotal < 0){
          Transaction toAdd = new Transaction(target, subject, "£", subjectTotal*-1, "Total past " +
                  "for transactions over a month old", false, LocalDateTime.now(), null);
        }else{
          Transaction toAdd = new Transaction(subject, target, "£", subjectTotal*-1, "Total past " +
                  "for transactions over a month old", false, LocalDateTime.now(), null);
        }
      }
    }
  }
}
