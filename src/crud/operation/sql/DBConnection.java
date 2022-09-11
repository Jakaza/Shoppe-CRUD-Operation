package crud.operation.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jakaza G Chauke
 */
public class DBConnection {
    
    private Connection connection;
    
    public DBConnection(String url, String username, String password) throws SQLException{
        connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }
    
}
