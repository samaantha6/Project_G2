package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class VentanaFacturacion extends JFrame {
		
		private JPanel pNorte, pNorteArriba, pSurCentro, pOesteArriba, pEste, pEsteAbajo, pOeste, pCentro;
	    private JButton btnatras, btnexportar;
	    private JTextField nRef, nPrecio, nDesc, nPagado, nEstado;
	    private JLabel txtPrecio, txtPagado, txtRef, txtNull, txtDesc, txtFact, txtEstado, txtDetalles, txtExport, imagenLabel;
	    
	    public VentanaFacturacion() {
	    	
	    	pNorte = new JPanel(new BorderLayout());
			pCentro = new JPanel(new GridLayout(14,14));
			pNorteArriba = new JPanel(new GridLayout(-80,10));
			pSurCentro = new JPanel(new GridLayout(19,20));
			pOesteArriba = new JPanel(new GridLayout(2,2));
			pEste = new JPanel(new GridLayout(8,1));
	        pEsteAbajo = new JPanel(new GridLayout(2, 1));
			pOeste = new JPanel(new GridLayout(3,2));
	        
	    	imagenLabel = new JLabel();

	        txtPrecio = new JLabel("Precio");
	        txtNull = new JLabel("");
	        txtRef = new JLabel("¿Envío?");
	        txtDesc = new JLabel("Descripción");
	        txtEstado = new JLabel("Estado");
	        txtExport = new JLabel("Exportar en pdf");
	        txtFact = new JLabel("  FACTURACIÓN");
	        txtDetalles = new JLabel("Detalles" );
	        txtPagado = new JLabel("¿Pagado?");

	        btnatras = new JButton("<--");
	        btnexportar = new JButton("Exportar");
	        
	        nRef = new JTextField(10);
	        nPrecio = new JTextField(10);
	        nDesc = new JTextField(10);
	        nEstado = new JTextField(10);
	        nPagado = new JTextField(10);


	    	pNorte.add(imagenLabel); //Imagen
	    	
	    	pEste.add(txtDetalles);
	    	JPanel precioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Panel para alinear los componentes horizontalmente
	        precioPanel.add(txtPrecio);
	        precioPanel.add(nPrecio);
	        pEste.add(precioPanel);
	    
	        JPanel refPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        refPanel.add(txtRef);
	        refPanel.add(nRef);
	        pEste.add(refPanel);

	        JPanel descPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        descPanel.add(txtDesc);
	        descPanel.add(nDesc);
	        pEste.add(descPanel);

	        JPanel estadoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        estadoPanel.add(txtEstado);
	        estadoPanel.add(nEstado);
	        pEste.add(estadoPanel);
	        
	        JPanel exPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        exPanel.add(txtExport);
	        exPanel.add(btnexportar);
	        pEste.add(exPanel);

	        
	        pNorteArriba.add(btnatras);
	    	pNorteArriba.add(txtFact);
	        
	    	pOesteArriba.add(txtRef);
	    	pOesteArriba.add(nRef);
	    	pOesteArriba.add(txtPagado);
	    	pOesteArriba.add(nPagado);

	    	
	        pOeste.add(pOesteArriba, BorderLayout.NORTH);
	        pEste.add(pEsteAbajo, BorderLayout.EAST);
	        
	        add(pNorte, BorderLayout.NORTH);
	        add(pNorteArriba, BorderLayout.NORTH);
	        add(pSurCentro, BorderLayout.CENTER);

	        add(pCentro, BorderLayout.CENTER);
	        add(pOeste, BorderLayout.WEST);
	        add(pEste, BorderLayout.EAST);
	        
	        setTitle("Facturación");
	        setBounds(300, 18, 600, 400); // Ajustar el ancho del marco
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setVisible(true);
	        
	    }
	        public static void main(String[] args) {
	    		
	    		VentanaFacturacion ventana = new VentanaFacturacion();
	    		
	    	}
}
