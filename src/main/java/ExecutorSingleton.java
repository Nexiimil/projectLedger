import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ExecutorSingleton {
    private static ExecutorSingleton exec = null;

    public ExecutorSingleton() {
    }

    public static ExecutorSingleton getInstance() {
        if (exec == null){
            exec = new ExecutorSingleton();
        }
        return exec;
    }

    public ResultSet with(PreparedStatement ps) throws SQLException {
        try{
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
    }

}
