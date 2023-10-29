package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaVerEnvios extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pCentro, pBtnVolver, pBtnEditar, pBtnEliminar;
	private JLabel txtMisEnvios, txtEnviosRealizados, txtRelleno;
	private JButton btnVolver, btnEditar, btnEliminar;
	private DefaultTableModel modeloTabla;
	private JTable tablaEnvios;
	private JScrollPane Scroll;
	
	public VentanaVerEnvios() {
		
		pNorte = new JPanel(new GridLayout(1, 5));
		pCentro = new JPanel(new GridLayout(2, 1));
		pBtnVolver = new JPanel();
		pBtnEditar = new JPanel();
		pBtnEliminar = new JPanel();
		
		txtMisEnvios = new JLabel("Mis envíos");
		txtEnviosRealizados = new JLabel("Envios realizados");
		txtRelleno = new JLabel(" ");
		
		ImageIcon editar = new ImageIcon(getClass().getResource("editar.png"));
		ImageIcon eliminar = new ImageIcon(getClass().getResource("eliminar.png"));
		
		btnVolver = new JButton("<--");
		btnEditar = new JButton(editar);
		btnEliminar = new JButton(eliminar);
		
        String[] nombreColumnas = {"Nº referencia", "Fecha", "Precio", "Descripción", "Estado", "Fecha prevista"};
        //son ejemplos
        Object[][] data = {
                {"001", "2023-10-28", "$100", "Producto 1", "Activo", "2023-10-30"},
                {"002", "2023-10-29", "$150", "Producto 2", "Inactivo", "2023-11-05"},
                {"003", "2023-11-01", "$75", "Producto 3", "Activo", "2023-11-03"},
                {"004", "2023-11-04", "$200", "Producto 4", "Inactivo", "2023-11-10"},
                {"005", "2023-11-12", "$120", "Producto 5", "Activo", "2023-11-15"}
            };
        modeloTabla = new DefaultTableModel(data, nombreColumnas);

        tablaEnvios = new JTable(modeloTabla);
        
        int rowHeight = 30;  
        tablaEnvios.setRowHeight(rowHeight);
        
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
        
        Scroll = new JScrollPane(tablaEnvios);
		
        tablePanel.add(Scroll, BorderLayout.CENTER);
        
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		

		pBtnVolver.add(btnVolver);
		pBtnEditar.add(btnEditar);
		pBtnEliminar.add(btnEliminar);
		pNorte.add(pBtnVolver);
		pNorte.add(txtMisEnvios);
		pNorte.add(pBtnEditar);
		pNorte.add(pBtnEliminar);
		pNorte.add(labelImagenLogo);
		
		pCentro.add(Scroll);
		

		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		
//EVENTOS
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio ventanaInicio = new VentanaInicio();
				dispose();			
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaHacerEnvio ventanaHacerEnvio = new VentanaHacerEnvio();
				dispose();			
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaEnvios.getSelectedRow();
		        if (filaSeleccionada != -1) {
		            // Obtener el valor de "N referencia" de la fila seleccionada
		            String nReferenciaABorrar = (String) tablaEnvios.getValueAt(filaSeleccionada, 0);

		            //  la fila del modelo de tabla
		            modeloTabla.removeRow(filaSeleccionada);

		            // Aquí puedes realizar cualquier otra lógica relacionada con la eliminación, por ejemplo, en tu base de datos.
		            System.out.println("Eliminando fila con Nº referencia: " + nReferenciaABorrar);
		        } else {
		            JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
		        }		
			}
		});
		
	setTitle("Ver envios");
	setBounds(300, 200, 600, 400);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
			public void agregarFila(Object[] nuevaFila) {
				modeloTabla.addRow(nuevaFila);
		    }
			
}
