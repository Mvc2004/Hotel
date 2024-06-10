import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD {

    private static final String URL = "jdbc:postgresql://localhost:5432/PROYECTO_BD";
    private static final String USER = "postgres";
    private static final String PASSWORD = "87654321";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

