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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Usuario;

public class VentanaPresupuesto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pOeste, pEste, pBtnHcerEnvio, pBtnVolver;
	private JLabel txtPresupuesto, txtTipoEnvio, txtVacio;
	private JCheckBox estandar, superior, premium;
	private JButton btnHacerEnvio, btnVolver;
	
    private List<Usuario> usuarios = new ArrayList<>();
	
	private Logger logger = Logger.getLogger(VentanaPresupuesto.class.getName());
	
	public VentanaPresupuesto() {
		
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

		estandar = new JCheckBox("Estandar\n (En 8/12 dias)");
		superior = new JCheckBox("Superior\n (En 6/10 dias");
		premium = new JCheckBox("Premium\n (En 2 dias");
		logger.info("JCheckBox creados");
		
		btnHacerEnvio = new JButton("Hacer Envio");
		btnVolver = new JButton("Volver");
		logger.info("JButtons creados");

		pNorte.add(txtPresupuesto);
		pNorte.add(labelImagenLogo);
		
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
//EVENTOS
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio ventanaInicio = new VentanaInicio(usuarios);
				dispose();			
			}
		});
		
		btnHacerEnvio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaHacerEnvio ventanaHacerEnvio = new VentanaHacerEnvio();
				dispose();			
			}
		});

		
	setTitle("Presupuesto");
	setBounds(300, 200, 600, 400);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
