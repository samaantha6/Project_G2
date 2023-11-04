package gui;

import javax.swing.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.tools.PDFBox;
import org.apache.pdfbox.tools.PrintPDF;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

	public class VentanaFacturacion extends JFrame {
		
		private static final long serialVersionUID = 1L;
		
		
		private JPanel pNorte, pNorteArriba, pOesteArriba, pEste, pOeste, pCentro;
	    private JButton btnatras, btnexportar;
	    private JTextField nRef, nPrecio, nDesc, nPagado, nEstado;
	    private JLabel txtPrecio, txtPagado, txtRef, txtDesc, txtFact, txtEstado, txtDetalles, txtExport;
	    
		private Logger logger = Logger.getLogger(VentanaFacturacion.class.getName());

	    
	    public VentanaFacturacion() {
	    	
//	    	PDDocument a = new PDDocument();
//	    	try {
//				a.save("ejemplo");
//				a.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	    	
	    	
	    	
	    	pNorte = new JPanel();
			pNorteArriba = new JPanel(new GridLayout(1,2));
			pCentro = new JPanel(new GridLayout(14,14));
			pOesteArriba = new JPanel(new GridLayout(4, 1));
			pOeste = new JPanel(new GridLayout(3,2));
			pEste = new JPanel(new GridLayout(7,1));
			logger.info("Paneles creados");
	        
			ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
			JLabel labelImagenLogo = new JLabel(logo);
			labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));

	        txtPrecio = new JLabel("Precio");
	        txtRef = new JLabel("¿Envío?    ");
	        txtDesc = new JLabel("Descripción");
	        txtEstado = new JLabel("Estado");
	        txtExport = new JLabel("Exportar en pdf");
	        txtFact = new JLabel("  FACTURACIÓN");
	        txtDetalles = new JLabel("Detalles" );
	        txtPagado = new JLabel("¿Pagado?");
	        logger.info("JLabels creados");
	        
	        btnatras = new JButton("<--");
	        btnexportar = new JButton("Exportar");
	        logger.info("JButtons creados");
	        
	        nRef = new JTextField(10);
	        nPrecio = new JTextField(10);
	        nDesc = new JTextField(10);
	        nEstado = new JTextField(10);
	        nPagado = new JTextField(10);
	        logger.info("JTextFields creados");
	    	
	    	pEste.add(txtDetalles);
	    	
	    	// Paneles  para alinear los componentes horizontalmente
	    	JPanel precioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
	        precioPanel.add(txtPrecio);
	        precioPanel.add(nPrecio);
	        pEste.add(precioPanel);
	    
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
	        
	        //Espacios en blanco para colocar los elementos de la izq. como qeuremos
	        pOesteArriba.add(txtRef); 
	        pOesteArriba.add(new JLabel(""));
	        pOesteArriba.add(nRef);
	        pOesteArriba.add(txtPagado);
	        pOesteArriba.add(new JLabel(""));
	        pOesteArriba.add(nPagado);
	        
	        JPanel panelEnvio = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        panelEnvio.add(txtRef);
	        panelEnvio.add(nRef);
	    	pOesteArriba.add(panelEnvio);
	    	
	    	JPanel panelPago = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        panelPago.add(txtPagado);
	        panelPago.add(nPagado);
	    	pOesteArriba.add(panelPago);

	        pNorteArriba.add(btnatras);
	    	pNorte.add(txtFact);
	    	pNorte.add(labelImagenLogo);
	        

	        pOeste.add(pOesteArriba, BorderLayout.CENTER);
	        pNorte.add(pNorteArriba, BorderLayout.WEST);
	        
	        add(pNorte, BorderLayout.NORTH);

	        add(pCentro, BorderLayout.CENTER);
	        add(pOeste, BorderLayout.WEST);
	        add(pEste, BorderLayout.EAST);
	        
	        //EVENTOS
			btnatras.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaInicio VI = new VentanaInicio();
					dispose();			
				}
			});
			logger.info("Evento botón atras creado");
			
			
	        setTitle("Facturación");
	        setBounds(350, 100, 600, 400); // Ajustar el ancho del marco
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setVisible(true);
	        
	    }
	    
}
