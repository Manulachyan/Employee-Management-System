package emlpoyeemanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");  // For MySQL 8.0 and later
        
        // Establish connection to MySQL database
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagement", "root", "@#$manudl123");
    }
}

