package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.tools.PDFBox;

import javax.swing.filechooser.FileNameExtensionFilter;

import domain.Envio;
import domain.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

	public class VentanaFacturacion extends JFrame  {
		
		private static final long serialVersionUID = 1L;
		
		
		private JPanel pNorte, pNorteArriba, pOesteArriba, pEste, pOeste, pCentro;
	    private JButton btnatras, btnexportar;
	    private JTextField nRef, nPrecio, nDesc, nPagado, nFecha;
	    private JLabel txtPrecio, txtPagado, txtRef, txtDesc, txtFact, txtFecha, txtDetalles, txtExport;
	    private PDType1Font fuente;
	    
	    private Map<Usuario, List<Envio>> usuariosPorEnvios = new HashMap<>();
	    
	    private Usuario usuario;
	    
	    private Envio envio;
	    
	    private JFileChooser guardar;
	    
	    private FileNameExtensionFilter filtro;
	    
		private Logger logger = Logger.getLogger(VentanaFacturacion.class.getName());

	    
	    public VentanaFacturacion(Map<Usuario, List<Envio>> usuariosPorEnviosS, Usuario usuarioO) {
	    	
	    	usuariosPorEnvios = usuariosPorEnviosS;
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
	        txtFecha = new JLabel("Fecha del envío:");
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
	        nFecha = new JTextField(10);
	        nPagado = new JTextField(10);
	        
	        nPrecio.setEditable(false);
	        nDesc.setEditable(false);
	        nFecha.setEditable(false);
	        nPagado.setEditable(false);
	        logger.info("JTextFields creados");
	        
	        guardar = new JFileChooser();
	        guardar.setDialogTitle("Guardar como");
	        
	        
	        filtro = new FileNameExtensionFilter("Archivos PDF (*.pdf)", "pdf");
	        guardar.setFileFilter(filtro);
	    	
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
	        estadoPanel.add(txtFecha);
	        estadoPanel.add(nFecha);
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
	        
	        nRef.getDocument().addDocumentListener(new DocumentListener() {
	            @Override
	            public void insertUpdate(DocumentEvent e) {
	            	String referencia = nRef.getText();
	                envio = buscarEnvioPorReferencia(referencia);
	                if (envio != null) {
	                	nPrecio.setText(envio.getPago().getPrecio());
	                	nDesc.setText(envio.getPago().getDescripcion());
	                	nFecha.setText(envio.getRecogida().getFechaDeEnvio());
	                	if (envio.getPago().getCVV() == null) {
	                		nPagado.setText("No");
	                	} else {
	                		nPagado.setText("Si");
	                	}
	                }
	                
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	            	String referencia = nRef.getText();
	            	envio = buscarEnvioPorReferencia(referencia);
	                if (envio != null) {
	                	System.out.println("seg");
	                }
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                // Este método se llama para cambios en atributos del documento,
	                // no es necesario para JTextField
	            }
	        });
	        
			btnatras.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SwingUtilities.invokeLater(() -> new VentanaInicio(usuariosPorEnviosS,usuario));
					dispose();	
						    
				}
			});
			
			btnexportar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					int guardarComo = guardar.showSaveDialog(VentanaFacturacion.this);
					
					
					
					if (guardarComo == JFileChooser.APPROVE_OPTION && envio != null) {
						PDDocument doc = new PDDocument();
				    	PDPage page = new PDPage();
				    	doc.addPage(page);
				    	
			            try  {
			            	PDPageContentStream contentStream = new PDPageContentStream(doc, page);
			                String fpath = guardar.getSelectedFile().getAbsolutePath();
			                
			                if (!fpath.toLowerCase().endsWith(".pdf")) {
			                    fpath += ".pdf";
			                }   
				                
				            /*ESCRIBE DE ARRIBA HACIA ABAJO*/
			                
			                contentStream.beginText();
			                contentStream.setFont(fuente, 14);
			                
			                contentStream.newLineAtOffset(50, 620);
			                
				    	    contentStream.newLineAtOffset(80,-120);
				    	    contentStream.showText(envio.getPago().getDescripcion());
				    	    contentStream.newLineAtOffset(220,0);
				    	    contentStream.showText(envio.getPago().getPrecio());
				    	    contentStream.newLine();
			                
				    	    contentStream.newLineAtOffset(-220,40);
				    	    contentStream.showText("DESCRIPCIÓN");
				    	    contentStream.newLineAtOffset(220,0);
				    	    contentStream.showText("PRECIO");
				    	    contentStream.newLine();
			                
			                contentStream.setFont(fuente, 12);
				    	    contentStream.newLineAtOffset(-300,40);
				    	    if (envio.getPago().getRemitenteDestinatario() == "Remitente") {
				    	    contentStream.showText(envio.getTrayecto().getDireccionOrigen());
				    	    } else {
					    	    contentStream.showText(envio.getTrayecto().getDireccionDestino());
				    	    }
				    	    contentStream.newLineAtOffset(140,0);
				    	    contentStream.showText(envio.getTrayecto().getDireccionDestino());
				    	    contentStream.newLineAtOffset(140,0);
			                contentStream.setFont(fuente, 14);
				    	    contentStream.showText("TIPO DE ENVÍO:");
			                contentStream.setFont(fuente, 12);
				    	    contentStream.newLineAtOffset(160,0);
				    	    contentStream.showText(envio.getRecogida().getTipoDeEnvio());
				    	    contentStream.newLine();
			                
				    	    contentStream.newLineAtOffset(-440,40);
				    	    if (envio.getPago().getRemitenteDestinatario() == "Remitente") {
				    	    contentStream.showText(envio.getTrayecto().getNombreOrigen());
				    	    } else {
					    	    contentStream.showText(envio.getTrayecto().getNombreDestino());
				    	    }
				    	    contentStream.newLineAtOffset(140,0);
				    	    contentStream.showText(envio.getTrayecto().getNombreDestino());
				    	    contentStream.newLineAtOffset(140,0);
			                contentStream.setFont(fuente, 14);
				    	    contentStream.showText("FECHA:");
			                contentStream.setFont(fuente, 12);
				    	    contentStream.newLineAtOffset(160,0);
				    	    contentStream.showText(envio.getRecogida().getFechaDeEnvio());
				    	    contentStream.newLine();
			                
				    	    contentStream.newLineAtOffset(-440,40);
				    	    contentStream.showText("FACTURAR A");
				    	    contentStream.newLineAtOffset(140,0);
				    	    contentStream.showText("ENVIAR A");
				    	    contentStream.newLineAtOffset(140,0);
				    	    contentStream.showText("Nº DE REFERENCIA:");
			                contentStream.setFont(fuente, 12);
				    	    contentStream.newLineAtOffset(160,0);
				    	    contentStream.showText(envio.getPaquete().getnReferencia());
				    	    contentStream.newLine();
			                
			                contentStream.setFont(fuente, 20);
			                
				    	    contentStream.newLineAtOffset(-440,40);
				    	    contentStream.showText("FACTURA:");
				    	    contentStream.endText();
			                
			                float escala = 0.5f;
			                InputStream imagen = getClass().getClassLoader().getResourceAsStream("Images/logoPngNegroPdf.png");
			                PDImageXObject logoImagen = PDImageXObject.createFromByteArray(doc, IOUtils.toByteArray(imagen), "logo");
			                contentStream.drawImage(logoImagen, 450, 700, logoImagen.getWidth() * escala, logoImagen.getHeight() * escala);
				    	   
				    	    contentStream.close();
				    	    
				    	    doc.save(fpath);
				    	    doc.close();
				    	    
				    	    JOptionPane.showMessageDialog(VentanaFacturacion.this, "Exportación correcta");
		                  
			        } catch (IOException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(VentanaFacturacion.this, "Error al exportar a PDF");
		                
		            }
			            
				  } else {
	                	JOptionPane.showMessageDialog(null, "Numero de referencia no existente.", "Error", JOptionPane.ERROR_MESSAGE);
				  }
				}
			});
			
			logger.info("Evento botón atras creado");
			
			
	        setTitle("Facturación");
	        setBounds(300, 200, 600, 400); // Ajustar el ancho del marco
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        setVisible(true);
	        
	    }
	    
	    private Envio buscarEnvioPorReferencia(String referencia) {
	        for (Map.Entry<Usuario, List<Envio>> entry : usuariosPorEnvios.entrySet()) {
	            List<Envio> envios = entry.getValue();
	            for (Envio envio : envios) {
	                if (envio.getPaquete().getnReferencia().equals(referencia)) {
	                    return envio;
	                }
	            }
	        }
	        return null;
	    }
	    
}