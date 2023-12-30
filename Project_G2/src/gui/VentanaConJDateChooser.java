package gui;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentanaConJDateChooser extends JFrame {
    public VentanaConJDateChooser() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Crear un JDateChooser
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy"); // Establecer el formato de fecha

        // Configurar un JTextField para mostrar la fecha seleccionada
        JTextField textField = new JTextField();
        textField.setEditable(false);
        dateChooser.getDateEditor().addPropertyChangeListener(e -> {
            if ("date".equals(e.getPropertyName())) {
                Date selectedDate = dateChooser.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                textField.setText(sdf.format(selectedDate));
            }
        });

        // Añadir el JDateChooser y el JTextField al panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(dateChooser, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.SOUTH);

        // Añadir el panel a la ventana
        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaConJDateChooser());
    }
}
