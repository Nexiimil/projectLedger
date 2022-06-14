import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static ConnectionSingleton c = null;
    private static Connection conn = null;

    public ConnectionSingleton() {
    }

    public static ConnectionSingleton getInstance() {
        if (conn == null) {
            c = new ConnectionSingleton();
        }
        return c;
    }

    public Connection getConnection() {
        try {
            String password = "c0998bb1e8c2e7a47418fa8d3a4bf834db70c4a08e59046a5495b305f82943c6";
            String user = "mpjonjphehrunk";
            String url = "jdbc:postgresql://ec2-52-212-228-71.eu-west-1.compute.amazonaws.com";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Project Ledger");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
