import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CamDescu {

    public void cambiarDescuentoClientesHabituales(BigDecimal nuevoDescuento) {
        String query = "UPDATE Descuentos SET descuento = ? WHERE tipo_cliente = 'Habitual'";

        try (Connection connection = ConectarBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setBigDecimal(1, nuevoDescuento);
            stmt.executeUpdate();

            System.out.println("Descuento actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

