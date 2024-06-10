import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrecioHabi {

    public void consultarPrecio(String tipo) {
        String query = "SELECT precio FROM Habitaciones WHERE tipo = ? LIMIT 1";

        try (Connection connection = ConectarBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Precio: " + rs.getBigDecimal("precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
