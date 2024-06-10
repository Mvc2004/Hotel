import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión del Hotel El Descanso");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Tipo de Habitación");
        userLabel.setBounds(10, 20, 160, 25);
        panel.add(userLabel);

        String[] tipos = {"sencilla", "doble", "matrimonial", "suite sencilla", "suite presidencial"};
        JComboBox<String> tipoCombo = new JComboBox<>(tipos);
        tipoCombo.setBounds(180, 20, 160, 25);
        panel.add(tipoCombo);

        JButton consultarButton = new JButton("Consultar Habitaciones Disponibles");
        consultarButton.setBounds(10, 60, 330, 25);
        panel.add(consultarButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 100, 760, 450);
        panel.add(resultArea);

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) tipoCombo.getSelectedItem();
                HabitaciconDispo habitacionService = new HabitaciconDispo();
                habitacionService.listarHabitacionesDisponibles(tipo);
            }
        });
    }
}
