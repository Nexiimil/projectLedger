import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                String password = "testing";
                String user = "ledgerAPIController";
                String url = "jdbc:postgresql://localhost/projectLedger";
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to Project Ledger");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return conn;
        }else {
            return conn;
        }
    }
}
