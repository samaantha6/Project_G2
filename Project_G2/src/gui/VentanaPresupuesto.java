package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import domain.Envio;
import domain.Pago;
import domain.Paquete;
import domain.Recogida;
import domain.Trayecto;
import domain.Usuario;

public class VentanaPresupuesto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pOeste, pEste, pBtnHacerEnvio, pBtnVolver, pPrecio;
	private JLabel txtPresupuesto, txtTipoEnvio, txtVacio;
	private JRadioButton estandar, superior, premium;
	private JButton btnHacerEnvio, btnVolver;
	private ButtonGroup tipoEnvio;
	private JLabel campoPrecio;
	
    private Map<Usuario, List<Envio>> usuariosPorEnvios = new HashMap<>();
    
    private Usuario usuario;
    
    private Envio DatosARellenar;
    
    private String tipoEnvioAGuardar;
	
	private Logger logger = Logger.getLogger(VentanaPresupuesto.class.getName());
	
	public VentanaPresupuesto(Map<Usuario, List<Envio>> usuariosPorEnviosS, Usuario usuarioO, VentanaInicio vInicio) {
		
		usuariosPorEnvios = usuariosPorEnviosS;
		usuario = usuarioO;
		
		tipoEnvio = new ButtonGroup();
		
		pNorte = new JPanel();
		pBtnHacerEnvio = new JPanel();
		pBtnVolver = new JPanel();
		pOeste = new JPanel(new GridLayout(4, 1));
		pEste = new JPanel(new GridLayout(4, 1));
		pPrecio = new JPanel();
		logger.info("JPanels creados");
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/Images/logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		logger.info("Imagen creada");
		
		txtPresupuesto = new JLabel("Presupuesto");
		txtTipoEnvio = new JLabel("Tipo Envio");
		txtVacio = new JLabel(" ");
		logger.info("JLabel creados");

		estandar = new JRadioButton("Estandar\n (En 8/12 dias)");
		superior = new JRadioButton("Superior\n (En 6/10 dias)");
		premium = new JRadioButton("Premium\n (En 2 dias)");
		logger.info("JRadioButton creados");
		
		btnHacerEnvio = new JButton("Hacer Envio");
		btnVolver = new JButton("Volver");
		logger.info("JButtons creados");
		
		
		campoPrecio = new JLabel("Seleccione el tipo de envío");
		logger.info("JTextFields creados");


		pNorte.add(txtPresupuesto);
		pNorte.add(labelImagenLogo);
		
		
		tipoEnvio.add(estandar);
		tipoEnvio.add(superior);
		tipoEnvio.add(premium);
		
		pOeste.add(txtTipoEnvio);
		pOeste.add(estandar);
		pOeste.add(superior);
		pOeste.add(premium);
		
		
		/** AÑADIMOS MARGENES AL PANEL POESTE*/
		pOeste.setBorder(new EmptyBorder(0, 70, 0, 70));
		
		
		pEste.add(txtVacio);
		pPrecio.add(campoPrecio);
		pEste.add(pPrecio);
		pBtnHacerEnvio.add(btnHacerEnvio);
		pEste.add(pBtnHacerEnvio);
		pBtnVolver.add(btnVolver);
		pEste.add(pBtnVolver);
		
		pEste.setBorder(new EmptyBorder(0, 70, 0, 70));
		
		add(pNorte, BorderLayout.NORTH); 
		add(pOeste, BorderLayout.WEST); 
		add(pEste, BorderLayout.EAST); 
		
/** EVENTOS */
		        
		estandar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipoEnvioAGuardar = "Estandar";
				try {
					
			    	double precioFinal = vInicio.getPrecio();
			    				    	
		            if (estandar.isSelected()) {
		                precioFinal += 2.99;
		            } else if (superior.isSelected()) {
		                precioFinal += 3.99;
		            } else if (premium.isSelected()) {
		                precioFinal += 7.99;
		            }	
		            
		            campoPrecio.setText(precioFinal + "€");
				} catch (NumberFormatException e2) {
					campoPrecio.setText("Error");
					
				}
			}
		});
		superior.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipoEnvioAGuardar = "Superior";
				try {
					
			    	double precioFinal = vInicio.getPrecio();
			    				    	
		            if (estandar.isSelected()) {
		                precioFinal += 2.99;
		            } else if (superior.isSelected()) {
		                precioFinal += 3.99;
		            } else if (premium.isSelected()) {
		                precioFinal += 7.99;
		            }	
		            
		            campoPrecio.setText(precioFinal + "€");
				} catch (NumberFormatException e2) {
					campoPrecio.setText("Error");
					
				}
			}
		});
		
		premium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipoEnvioAGuardar = "Premium";
				try {
					
			    	double precioFinal = vInicio.getPrecio();
			    				    	
		            if (estandar.isSelected()) {
		                precioFinal += 2.99;
		            } else if (superior.isSelected()) {
		                precioFinal += 3.99;
		            } else if (premium.isSelected()) {
		                precioFinal += 7.99;
		            }	
		            
		            campoPrecio.setText(precioFinal + "€");
				} catch (NumberFormatException e2) {
					campoPrecio.setText("Error");
					
				}
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> new VentanaInicio(usuariosPorEnvios, usuario));
				dispose();			
			}
		});
		
		btnHacerEnvio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Pago pago = new Pago();
				Paquete paquete = new Paquete(vInicio.getPeso(), vInicio.getLargo(), vInicio.getAncho(), vInicio.getAlto());
				Recogida recogida = new Recogida(tipoEnvioAGuardar);
				Trayecto trayecto = new Trayecto(vInicio.getDesde(), vInicio.getHasta());
				Envio envio = new Envio(trayecto, paquete, recogida, pago);
				DatosARellenar = envio;
				SwingUtilities.invokeLater(() -> new VentanaHacerEnvio(usuariosPorEnvios, usuario, DatosARellenar));
				dispose();			
			}
		});
		
	

        
		
	setTitle("Presupuesto");
	setBounds(300, 200, 600, 400);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
