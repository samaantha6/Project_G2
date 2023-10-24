package ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class VentanaFacturacion extends JFrame {
		
		private JPanel pNorte, pSurArriba, pSurCentro, pOesteArriba, pEsteAbajo, pOeste, pCentro;
	    private JButton btnatras, btnexportar;
	    private JTextField nRef, nPrecio, nDesc, nEstado;
	    private JLabel txtPrecio, txtRef, txtNull, textDesc, txtFact, txtEstado,txtExport, imagenLabel;
	    
	    public VentanaFacturacion() {
	    	
	    	pNorte = new JPanel(new GridLayout(1,3));
			pCentro = new JPanel(new GridLayout(14,14));
			pSurArriba = new JPanel(new GridLayout(20,14));
			pSurCentro = new JPanel(new GridLayout(19,20));
			pOesteArriba = new JPanel(new GridLayout(-30,2));
			pEsteAbajo = new JPanel(new GridLayout(2,4));
			pOeste = new JPanel(new GridLayout(13,13));
	        
	    	imagenLabel = new JLabel();

	        txtPrecio = new JLabel("Precio");
	        txtNull = new JLabel("");
	        txtRef = new JLabel("    ¿Envío?");
	        textDesc = new JLabel("Descripción");
	        txtEstado = new JLabel("Estado");
	        txtExport = new JLabel("Exportar en pdf");
	        txtFact = new JLabel("  FACTURACIÓN");
	     

	        btnatras = new JButton("<--");
	        btnexportar = new JButton("Exportar");
	        
	        nRef = new JTextField(10);
	        
	    	pNorte.add(imagenLabel); //Imagen
	    	
	    	pCentro.add(txtFact);
	        pOeste.add(btnatras);
	        pOesteArriba.add(txtRef);
	        
	        //pCentroCen.add(txtEnv);
	        pSurArriba.add(txtRef);
	        pSurCentro.add(nRef);
	        pEsteAbajo.add(btnexportar);
	        
	        pOeste.add(pOesteArriba, BorderLayout.NORTH);

	        
	        add(pNorte, BorderLayout.NORTH);
	        add(pSurArriba, BorderLayout.SOUTH);
	        add(pSurCentro, BorderLayout.CENTER);

	        add(pCentro, BorderLayout.CENTER);
	        add(pOeste, BorderLayout.WEST);
	        add(pEsteAbajo, BorderLayout.EAST);
	        
	        setTitle("Facturación");
	        setBounds(300, 18, 600, 400); // Ajustar el ancho del marco
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setVisible(true);
	        
	    }
	        public static void main(String[] args) {
	    		
	    		VentanaFacturacion ventana = new VentanaFacturacion();
	    		
	    	}
}
