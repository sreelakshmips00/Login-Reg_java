package Forms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }

        try {
            String url = "jdbc:mysql://localhost:3308/userlogin?zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = ""; 
            
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established successfully.");

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
