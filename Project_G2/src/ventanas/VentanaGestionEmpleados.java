package ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class VentanaGestionEmpleados {


	    public static void main(String[] args) {
	    	
	        
	        // Crear un marco (JFrame) para la aplicación
	        JFrame frame = new JFrame("Ejemplo de Tabla en Java");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 300);

	        // Crear un modelo de tabla (DefaultTableModel)
	        DefaultTableModel model = new DefaultTableModel();

	        // Agregar columnas a la tabla
	        model.addColumn("Nº REF");
	        model.addColumn("FECHA");
	        model.addColumn("PRECIO");
	        model.addColumn("DESCRIPCIÓN");
	        model.addColumn("ESTADO");
	        model.addColumn("FECHA PREVISTA");



	        // Agregar filas de datos a la tabla
	        model.addRow(new Object[]{"", "", ""});
	        model.addRow(new Object[]{"", "", ""});
	        model.addRow(new Object[]{"", "", ""});
	        model.addRow(new Object[]{"", "", ""});
        


	        // Crear la tabla con el modelo de datos

	        JTable table = new JTable(model);

	        JPanel buttonPanel = new JPanel();
	        JButton volverButton = new JButton("<--");
	        JButton eliminarButton = new JButton("Eliminar Envío");
	        JLabel txtenvio = new JLabel("Gestión de Envíos");

	        buttonPanel.add(volverButton);
	        buttonPanel.add(eliminarButton);	       

	        // Establecer el diseño del marco como BorderLayout
	        frame.setLayout(new BorderLayout());

	        // Agregar la tabla al centro del marco
	        frame.add(new JScrollPane(table), BorderLayout.CENTER);

	        // Agregar el panel de botones en la esquina superior izquierda
	        frame.add(buttonPanel, BorderLayout.NORTH);

	        frame.add(txtenvio, BorderLayout.SOUTH);
	        // Hacer visible el marco
	        frame.setVisible(true);
	    }
	}





	

