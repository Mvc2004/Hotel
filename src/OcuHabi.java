import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class OcuHabi {

    public void registrarOcupacion(int numeroHabitacion) {
        String query = "UPDATE Habitaciones SET estado = 'Ocupada' WHERE numero = ?";

        try (Connection connection = ConectarBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, numeroHabitacion);
            stmt.executeUpdate();

            System.out.println("Habitación ocupada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

