import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpPrecioH {

    public void cambiarPrecioHabitacion(String tipo, BigDecimal nuevoPrecio) {
        String query = "UPDATE Habitaciones SET precio = ? WHERE tipo = ?";

        try (Connection connection = ConectarBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setBigDecimal(1, nuevoPrecio);
            stmt.setString(2, tipo);
            stmt.executeUpdate();

            System.out.println("Precio de la habitación actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

