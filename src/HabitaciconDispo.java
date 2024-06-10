import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HabitaciconDispo {

    public void listarHabitacionesDisponibles(String tipo) {
        String query = "SELECT * FROM Habitaciones WHERE tipo = ? AND estado = 'Disponible'";

        try (Connection connection = ConectarBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Numero: " + rs.getInt("numero") + 
                                   ", Tipo: " + rs.getString("tipo") + ", Precio: " + rs.getBigDecimal("precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
