import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CalVentas {

    public void calcularVentasMensuales(int mes) {
        String query = "SELECT SUM(H.precio * R.dias_ocupacion * (1 - COALESCE(D.descuento, 0) / 100)) AS ventas_totales " +
                       "FROM Reservas R " +
                       "JOIN Habitaciones H ON R.habitacion_id = H.id " +
                       "LEFT JOIN Clientes C ON R.cliente_id = C.id " +
                       "LEFT JOIN Descuentos D ON C.tipo = D.tipo_cliente " +
                       "WHERE MONTH(R.fecha_entrada) = ?";

        try (Connection connection = ConectarBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, mes);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                BigDecimal ventasTotales = rs.getBigDecimal("ventas_totales");
                System.out.println("Ventas Totales para el mes " + mes + ": " + ventasTotales);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

