package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserCellEditor;

import domain.Envio;
import domain.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VentanaGestionEmpleados extends JFrame {
    
	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pSur, pOeste, pEste, pCentro, pCentroDer, pCentroIzq, pCentroCen, pNReferencia, pBtnEliminarEnvio, pBtnVolver;
    private JButton btnatras, btnEliminarEnvio;
    private JLabel txtEnv, txtNReferencia, txtNull;
    private JTextField campoNReferencia;
	private DefaultTableModel modeloTabla;
	private JTable tablaEnvios;
	private JScrollPane Scroll;
	private JDateChooser calendario;
	
    private TableRowSorter<DefaultTableModel> Busqueda;
	
    private Map<Usuario, List<Envio>> usuariosPorEnvios = new HashMap<>();
    
	private WindowMaster windowMaster = new WindowMaster();
    
    Usuario usuario;

    public VentanaGestionEmpleados(Map<Usuario, List<Envio>> usuariosPorEnviosS, Usuario usuarioO) {
    	
    	usuariosPorEnvios = usuariosPorEnviosS;
		usuario = usuarioO;
    	
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
        
    	ImageIcon logo = new ImageIcon(getClass().getResource("/Images/logoPngNegro.png"));
    	JLabel labelImagenLogo = new JLabel(logo);
    	labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));

        txtEnv = new JLabel("Envíos realizados");
        txtNull = new JLabel("");
		txtNReferencia = new JLabel("¿Nº Referencia?");

        btnatras = new JButton("<--");
        btnEliminarEnvio = new JButton("ELIMINAR ENVIO");
        campoNReferencia = new JTextField(10);
                
		pBtnVolver.add(btnatras);
        pNorte.add(pBtnVolver);
        pNReferencia.add(txtNReferencia);
        pNReferencia.add(campoNReferencia);
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
        
        modeloTabla = new DefaultTableModel(null, nombreColumnas);

        tablaEnvios = new JTable(modeloTabla);
        
        int rowHeight = 30;  
        tablaEnvios.setRowHeight(rowHeight);
        
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
        
        Scroll = new JScrollPane(tablaEnvios);
        tablePanel.add(Scroll, BorderLayout.CENTER);

        pSur.add(tablePanel, BorderLayout.CENTER);
        
        JLabel labelAboveTable = new JLabel("     Envíos realizados");

        pSur.add(labelAboveTable, BorderLayout.NORTH); 

        Busqueda = new TableRowSorter<>(modeloTabla);
        tablaEnvios.setRowSorter(Busqueda);
        
/*EVENTOS*/
        
        windowMaster.cargarDatosEnTabla(usuariosPorEnviosS, tablaEnvios, usuario);
        
		btnatras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> new VentanaInicioSesion(usuariosPorEnvios));
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

		        } else {
		            JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
		        }		
			}
		});
		
        campoNReferencia.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarEnvios();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarEnvios();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarEnvios();
            }
        });
		
        setTitle("Gestión");
        setBounds(300, 18, 600, 400); // Ajustar el ancho del marco
        setMinimumSize(new Dimension(700, 650)); // Configurar el tamaño mínimo de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    

    private void filtrarEnvios() {
        String nReferenciaBusqueda = campoNReferencia.getText();

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter(nReferenciaBusqueda, 0);
        Busqueda.setRowFilter(rowFilter);
    }

    
}

