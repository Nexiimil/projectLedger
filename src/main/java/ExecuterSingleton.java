import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ExecuterSingleton {
    private PreparedStatement ps;
    private final Connection conn = ConnectionSingleton.getConnection();

}
