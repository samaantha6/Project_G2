package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaVerEnvios extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pNorteArriba, pNorteAbajo, pNReferencia, pBtnEliminarEnvio, pBtnVolver, pCentro, ptxtEnviosRealizados,  pSur;
	private JLabel txtNReferencia, txtEnviosRealizados, txtRelleno;
	private JButton btnVolver, btnEliminarEnvio;
	private JComboBox<String> nReferencia;
	private DefaultTableModel modeloTabla;
	private JTable tablaEnvios;
	private JScrollPane Scroll;
	
	public VentanaVerEnvios() {
		
		pNorte = new JPanel(new GridLayout(1, 4));
		pCentro = new JPanel(new GridLayout(2, 1));
		pSur = new JPanel(new GridLayout(14, 1));
		pNReferencia = new JPanel();
		pBtnEliminarEnvio = new JPanel();
		pBtnVolver = new JPanel();
		ptxtEnviosRealizados = new JPanel();
		
		txtNReferencia = new JLabel("¿Nº Referencia?");
		txtEnviosRealizados = new JLabel("Envios realizados");
		txtRelleno = new JLabel(" ");
		
		btnVolver = new JButton("<--");
		btnEliminarEnvio = new JButton("ELIMINAR ENVIO");
		
		nReferencia = new JComboBox<String>();
		
        String[] nombreColumnas = {"Nº referencia", "Fecha", "Precio", "Descripción", "Estado", "Fecha prevista"};
        modeloTabla = new DefaultTableModel(nombreColumnas, 0);

        tablaEnvios = new JTable(modeloTabla);
        
        int rowHeight = 30;  
        tablaEnvios.setRowHeight(rowHeight);
        
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
        
        Scroll = new JScrollPane(tablaEnvios);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		
		pBtnVolver.add(btnVolver);
		pNReferencia.add(txtNReferencia);
		pNReferencia.add(nReferencia);
		pNorte.add(pBtnVolver);
		pNorte.add(pNReferencia);
		pBtnEliminarEnvio.add(btnEliminarEnvio);
		pNorte.add(pBtnEliminarEnvio);
		pNorte.add(labelImagenLogo);
		
		ptxtEnviosRealizados.add(txtEnviosRealizados);
		pCentro.add(ptxtEnviosRealizados);
		pCentro.add(Scroll);
		
		pSur.add(txtRelleno);

		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
	setTitle("Ver envios");
	setBounds(300, 200, 600, 400);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
			public void agregarFila(Object[] nuevaFila) {
				modeloTabla.addRow(nuevaFila);
		    }
			
}
