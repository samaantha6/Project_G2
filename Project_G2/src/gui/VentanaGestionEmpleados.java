package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class VentanaGestionEmpleados extends JFrame {
    
	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pSur, pOeste, pEste, pCentro, pCentroDer, pCentroIzq, pCentroCen, pNReferencia, pBtnEliminarEnvio, pBtnVolver;
    private JButton btnatras, btnEliminarEnvio;
	private JComboBox<String> nReferencia;
    private JLabel txtEnv, txtNReferencia, txtNull;
	private DefaultTableModel modeloTabla;
	private JTable tablaEnvios;
	private JScrollPane Scroll;
	
	private Logger logger = Logger.getLogger(VentanaGestionEmpleados.class.getName());


    public VentanaGestionEmpleados() {
    	
		pNorte = new JPanel(new GridLayout(1, 4));
        pCentro = new JPanel(new GridLayout(6, 7)); 
        pSur = new JPanel(new BorderLayout());
        pCentroDer = new JPanel();
        pCentroIzq = new JPanel();
        pCentroCen = new JPanel();
        pOeste = new JPanel(new GridLayout(5,5));
        pEste = new JPanel();
        pNReferencia = new JPanel();
        pBtnEliminarEnvio = new JPanel();
        pBtnVolver = new JPanel();
        
    	ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
    	JLabel labelImagenLogo = new JLabel(logo);
    	labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));

        txtEnv = new JLabel("Envíos realizados");
        txtNull = new JLabel("");
		txtNReferencia = new JLabel("¿Nº Referencia?");

        btnatras = new JButton("<--");
        btnEliminarEnvio = new JButton("ELIMINAR ENVIO");
		nReferencia = new JComboBox<String>();
                
		pBtnVolver.add(btnatras);
        pNorte.add(pBtnVolver);
        pNReferencia.add(txtNReferencia);
        pNReferencia.add(nReferencia);
        pNorte.add(pNReferencia);
        pNorte.add(btnEliminarEnvio);
        pBtnEliminarEnvio.add(btnEliminarEnvio);
        pNorte.add(pBtnEliminarEnvio);   
        pNorte.add(labelImagenLogo);   

        add(pNorte, BorderLayout.NORTH);
        add(pSur, BorderLayout.SOUTH);
        add(pCentro, BorderLayout.CENTER);
        add(pEste, BorderLayout.EAST);
        add(pOeste, BorderLayout.WEST);
        
        String[] nombreColumnas = {"Nº referencia", "Fecha", "Precio", "Descripción", "Estado", "Fecha prevista"};
        //son ejemplos para probar que todo funciona, no estaran en el proyecto final
        Object[][] data = {
                {"001", "2023-10-28", "$100", "Producto 1", "Activo", "2023-10-30"},
                {"002", "2023-10-29", "$150", "Producto 2", "Inactivo", "2023-11-05"},
                {"003", "2023-11-01", "$75", "Producto 3", "Activo", "2023-11-03"},
                {"004", "2023-11-04", "$200", "Producto 4", "Inactivo", "2023-11-10"},
                {"005", "2023-11-12", "$120", "Producto 5", "Activo", "2023-11-15"}
            };
        
        modeloTabla = new DefaultTableModel(data, nombreColumnas);
        tablaEnvios = new JTable(modeloTabla);
        Scroll = new JScrollPane(tablaEnvios);

        
        // Ajustar el alto de las filas
        int rowHeight = 30;  
        tablaEnvios.setRowHeight(rowHeight);
        
        // Establecer márgenes
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
        
        tablePanel.add(Scroll, BorderLayout.CENTER);

        pSur.add(tablePanel, BorderLayout.CENTER);
        
        // Agregar una etiqueta encima de la tabla
        JLabel labelAboveTable = new JLabel("     Envíos realizados");
        pSur.add(labelAboveTable, BorderLayout.NORTH); 

//EVENTOS
		btnatras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion ventanaIS = new VentanaInicioSesion();
				dispose();			
			}
		});
		
		btnEliminarEnvio.addActionListener(new ActionListener() {
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
        
        setTitle("Gestión");
        setBounds(300, 18, 600, 400); // Ajustar el ancho del marco
        setMinimumSize(new Dimension(700, 650)); // Configurar el tamaño mínimo de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
	public void agregarFila(Object[] nuevaFila) {
		modeloTabla.addRow(nuevaFila);
    }

    public static void main(String[] args) {
            VentanaGestionEmpleados ventanaGesEmp = new VentanaGestionEmpleados();
        };
    
}
