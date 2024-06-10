import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrecioReser {

    public void consultarPrecioTotal(String identificacionCliente, String tipoHabitacion, int noches) {
        String query = "SELECT (H.precio * ? * (1 - COALESCE(D.descuento, 0) / 100)) AS precio_total " +
                       "FROM Habitaciones H " +
                       "JOIN Clientes C ON C.identificacion = ? " +
                       "LEFT JOIN Descuentos D ON C.tipo = D.tipo_cliente " +
                       "WHERE H.tipo = ?";

        try (Connection connection = ConectarBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, noches);
            stmt.setString(2, identificacionCliente);
            stmt.setString(3, tipoHabitacion);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Precio Total: " + rs.getBigDecimal("precio_total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
