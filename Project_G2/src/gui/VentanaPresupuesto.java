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
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import domain.Usuario;

public class VentanaPresupuesto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pOeste, pEste, pBtnHcerEnvio, pBtnVolver;
	private JLabel txtPresupuesto, txtTipoEnvio, txtVacio;
	private JRadioButton estandar, superior, premium;
	private JButton btnHacerEnvio, btnVolver;
	private ButtonGroup tipoEnvio;
	
    private List<Usuario> usuarios = new ArrayList<>();
    
    private String correoUsuario;
	
	private Logger logger = Logger.getLogger(VentanaPresupuesto.class.getName());
	
	public VentanaPresupuesto(List<Usuario> usuariosS, String correoUsuarioO) {
		
		correoUsuario = correoUsuarioO;
		
		tipoEnvio = new ButtonGroup();
		
		pNorte = new JPanel();
		pBtnHcerEnvio = new JPanel();
		pBtnVolver = new JPanel();
		pOeste = new JPanel(new GridLayout(4, 1));
		pEste = new JPanel(new GridLayout(3, 1));
		logger.info("JPanels creados");
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		logger.info("Imagen creada");
		
		txtPresupuesto = new JLabel("Presupuesto");
		txtTipoEnvio = new JLabel("Tipo Envio");
		txtVacio = new JLabel(" ");
		logger.info("JLabel creados");

		estandar = new JRadioButton("Estandar\n (En 8/12 dias)");
		superior = new JRadioButton("Superior\n (En 6/10 dias");
		premium = new JRadioButton("Premium\n (En 2 dias");
		logger.info("JRadioButton creados");
		
		btnHacerEnvio = new JButton("Hacer Envio");
		btnVolver = new JButton("Volver");
		logger.info("JButtons creados");

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
		pOeste.setBorder(new EmptyBorder(0, 30, 0, 30));
		
		pEste.add(txtVacio);
		pBtnHcerEnvio.add(btnHacerEnvio);
		pEste.add(pBtnHcerEnvio);
		pBtnVolver.add(btnVolver);
		pEste.add(pBtnVolver);
		
		add(pNorte, BorderLayout.NORTH); 
		add(pOeste, BorderLayout.WEST); 
		add(pEste, BorderLayout.EAST); 

/** EVENTOS */
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio ventanaInicio = new VentanaInicio(usuarios, correoUsuario);
				dispose();			
			}
		});
		
		btnHacerEnvio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaHacerEnvio ventanaHacerEnvio = new VentanaHacerEnvio(usuarios, correoUsuario);
				dispose();			
			}
		});

		
	setTitle("Presupuesto");
	setBounds(300, 200, 600, 400);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
