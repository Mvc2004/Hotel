import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Reserva {

    public void reservarHabitacion(int numeroHabitacion, String identificacionCliente, String fechaEntrada, int diasOcupacion) {
        String insertQuery = "INSERT INTO Reservas (cliente_id, habitacion_id, fecha_entrada, dias_ocupacion) " +
                             "VALUES ((SELECT id FROM Clientes WHERE identificacion = ?), " +
                                     "(SELECT id FROM Habitaciones WHERE numero = ?), ?, ?)";
        String updateQuery = "UPDATE Habitaciones SET estado = 'Reservada' WHERE numero = ?";

        try (Connection connection = ConectarBD.getConnection();
             PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
             PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {

            insertStmt.setString(1, identificacionCliente);
            insertStmt.setInt(2, numeroHabitacion);
            insertStmt.setString(3, fechaEntrada);
            insertStmt.setInt(4, diasOcupacion);
            insertStmt.executeUpdate();

            updateStmt.setInt(1, numeroHabitacion);
            updateStmt.executeUpdate();

            System.out.println("Habitación reservada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

