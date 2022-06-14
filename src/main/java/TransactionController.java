import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionController {
    private static final ExecutorSingleton exec = ExecutorSingleton.getInstance();
    private static final ConnectionSingleton conn = ConnectionSingleton.getInstance();

    public static void addTransaction(Transaction toAdd) throws SQLException {
        PreparedStatement ps = conn.getConnection().prepareStatement("INSERT INTO Transactions VALUES (?,?,?,?,?)");
        ps.setInt(1, toAdd.getSubjectUID());
        ps.setInt(2, toAdd.getTargetUID());
        ps.setString(3, toAdd.getCurrency());
        ps.setDouble(4, toAdd.getValue());
        ps.setString(5, toAdd.getRef());
        exec.with(ps);
    }
}
