package ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionEmpleados extends JFrame {
    private JPanel pNorte, pSur, pOeste, pEste, pCentro, pCentroDer, pCentroIzq, pCentroCen;
    private JButton btnatras, btneliminar;
    private JTextField nRef;
    private JLabel txtEnv, txtRef, txtNull, imagenLabel;
    private JTable table;

    public VentanaGestionEmpleados() {
    	
        pNorte = new JPanel(new GridLayout(1, 2));
        pCentro = new JPanel(new GridLayout(6, 7)); 
        pSur = new JPanel(new BorderLayout());
        pCentroDer = new JPanel();
        pCentroIzq = new JPanel();
        pCentroCen = new JPanel();
        pOeste = new JPanel(new GridLayout(5,5));
        pEste = new JPanel();
        
    	ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
    	JLabel labelImagenLogo = new JLabel(logo);
    	labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));

        txtEnv = new JLabel("Envíos realizados");
        txtNull = new JLabel("");
        txtRef = new JLabel("Nº Referencia");

        btnatras = new JButton("<--");
        btneliminar = new JButton("Eliminar Envío");
        nRef = new JTextField(10);
        

        pOeste.add(btnatras);
        
        //pCentroCen.add(txtEnv);
        pCentroDer.add(txtRef);
        pCentroDer.add(nRef);
        pCentroIzq.add(btneliminar);
        pCentro.add(pCentroDer, BorderLayout.NORTH);
        pCentro.add(pCentroIzq, BorderLayout.CENTER);
        pCentro.add(pCentroCen, BorderLayout.SOUTH);
        

        add(pNorte, BorderLayout.NORTH);
        add(pSur, BorderLayout.SOUTH);
        add(pCentro, BorderLayout.CENTER);
        add(pEste, BorderLayout.EAST);
        add(pOeste, BorderLayout.WEST);

        // Crear la tabla con el modelo de datos
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Nº Referencia");
        model.addColumn("Fecha");
        model.addColumn("Precio");
        model.addColumn("Descripción");
        model.addColumn("Estado");
        model.addColumn("Fecha Prevista");

        
        model.addRow(new Object[]{"", "", ""});
        model.addRow(new Object[]{"", "", ""});
        model.addRow(new Object[]{"", "", ""});
        model.addRow(new Object[]{"", "", ""});
        model.addRow(new Object[]{"", "", ""});
        model.addRow(new Object[]{"", "", ""});
        model.addRow(new Object[]{"", "", ""});

        
        table = new JTable(model);

        // Ajustar el alto de las filas
        int rowHeight = 30;  
        table.setRowHeight(rowHeight);
        
        // Establecer márgenes
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
        
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

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
        
        setTitle("Gestión");
        setBounds(300, 18, 600, 400); // Ajustar el ancho del marco
        setMinimumSize(new Dimension(700, 650)); // Configurar el tamaño mínimo de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
            VentanaGestionEmpleados ventanaGesEmp = new VentanaGestionEmpleados();
        };
    
}
