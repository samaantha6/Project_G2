package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.tools.PDFBox;


import domain.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

	public class VentanaFacturacion extends JFrame  {
		
		private static final long serialVersionUID = 1L;
		
		
		private JPanel pNorte, pNorteArriba, pOesteArriba, pEste, pOeste, pCentro;
	    private JButton btnatras, btnexportar;
	    private JTextField nRef, nPrecio, nDesc, nPagado, nEstado;
	    private JLabel txtPrecio, txtPagado, txtRef, txtDesc, txtFact, txtEstado, txtDetalles, txtExport;
	    private PDType1Font fuente;
	    
	    private List<Usuario> usuarios = new ArrayList<>();
	    
	    private Usuario usuario;
	    
		private Logger logger = Logger.getLogger(VentanaFacturacion.class.getName());

	    
	    public VentanaFacturacion(List<Usuario> usuariosS, Usuario usuarioO) {
	    	
	    	usuarios = usuariosS;
	    	usuario = usuarioO;
	    	
	    	pNorte = new JPanel();
			pNorteArriba = new JPanel(new GridLayout(1,2));
			pCentro = new JPanel(new GridLayout(14,14));
			pOesteArriba = new JPanel(new GridLayout(4, 1));
			pOeste = new JPanel(new GridLayout(3,2));
			pEste = new JPanel(new GridLayout(7,1));
			logger.info("Paneles creados");
			fuente = new PDType1Font(FontName.HELVETICA_BOLD);
	        
			ImageIcon logo = new ImageIcon(getClass().getResource("/Images/logoPngNegro.png"));
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
	        pOeste.setBorder(new EmptyBorder(20, 70, 0, 0));
	        pNorte.add(pNorteArriba, BorderLayout.WEST);
	        pEste.setBorder(new EmptyBorder(20, 70, 0, 70));
	        
	        add(pNorte, BorderLayout.NORTH);

	        add(pCentro, BorderLayout.CENTER);
	        add(pOeste, BorderLayout.WEST);
	        add(pEste, BorderLayout.EAST);
	        
	        

/*EVENTOS*/
	        
	        
			btnatras.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SwingUtilities.invokeLater(() -> new VentanaInicio(usuarios,usuario));
					dispose();	
						    
				}
			});
			
			btnexportar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					PDDocument a = new PDDocument();
			    	
			    	PDPage page = new PDPage();
			    	a.addPage(page);
			    	
			    	try {
			    		PDPageContentStream contentStream = new PDPageContentStream(a, page);
			    		
			    		
			    		contentStream.beginText();
			    		
			    		contentStream.setFont(fuente, 12);
			    	    //contentStream.newLineAtOffset(50, 700);
			    	    
		                String precio = nPrecio.getText();
		                String descripcion = nDesc.getText();
		                String estado = nEstado.getText();
		                String pagado = nPagado.getText();
		                String referencia = nRef.getText();
		                
		                
		                
		                /*ESCRIBE DE ARRIBA HACIA ABAJO*/
		                		
		                
			    	    contentStream.newLineAtOffset(50,620);
			    	    if (estado != null && !estado.isEmpty()) {
			    	    	contentStream.showText("Estado: " + estado);
			    	    } else {
			    	        contentStream.showText("Estado: No disponible");
			    	    }
			    	    
			    	    contentStream.newLine();
			    	    
			    	    
			    	    contentStream.newLineAtOffset(0,30);
			    	    if (pagado != null && !pagado.isEmpty()) {
			    	    	contentStream.showText("¿Pagado?: " + pagado);
			    	    } else {
			    	        contentStream.showText("Pagado: No disponible");
			    	    }
			    	    
			    	    contentStream.newLine();
			    	    
		                contentStream.newLineAtOffset(0,30);
			    	    if (precio != null && !precio.isEmpty()) {
			    	        contentStream.showText("Precio: " + precio);
			    	    } else {
			    	        contentStream.showText("Precio: No disponible");
			    	    }
			    	    
			    	    contentStream.newLine();
			    	    
			    	    contentStream.newLineAtOffset(0,30);
			    	    if (descripcion != null && !descripcion.isEmpty()) {
			    	    	contentStream.showText("Descripción: " + descripcion);
			    	    } else {
			    	        contentStream.showText("Descripción: No disponible");
			    	    }
			    	    
			    	    contentStream.newLine();
			    	    

			    	    contentStream.newLineAtOffset(0,40);
			    	    contentStream.showText("FACTURA ENVIO CON Nº REFERENCIA:   " + referencia);
			    	    contentStream.newLine();

			    	    
			    	    contentStream.endText();
			    	    contentStream.close();

			    	    a.save("factura.pdf");
			    	    a.close();
			    	    
			    	    JOptionPane.showMessageDialog(VentanaFacturacion.this, "Exportación exitosa a factura.pdf");
			    	    
			    	} catch (IOException ex) {
			    		
			    		
			    	    ex.printStackTrace();
			    	    JOptionPane.showMessageDialog(VentanaFacturacion.this, "Error al exportar a PDF");
					} 
					
				}
				
				
				
			});
			
			logger.info("Evento botón atras creado");
			
			
	        setTitle("Facturación");
	        setBounds(300, 200, 600, 400); // Ajustar el ancho del marco
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setVisible(true);
	        
	    }
	    
}
