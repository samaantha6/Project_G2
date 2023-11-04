package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	
	private JPanel pNorte, pNorteIzq, pNorteDer, pSur, pOeste, pEste, pCentro, pCentroDer, pCentroIzq, pCentroCen;
	private JButton btnReg, btnIS;
	private JTextField campoCorreo;
	private JPasswordField campoContrasenia;
	private JLabel txtIS, txtOlvidoCsnia, txtCorreo, txtContrasenia, txtNull, imagenLabel;
	
	private Logger logger = Logger.getLogger(VentanaInicioSesion.class.getName());
	
	
	public VentanaInicioSesion() {
	
	 
	pNorte = new JPanel(new GridLayout(1,2));
	pNorteIzq = new JPanel();
	pNorteDer = new JPanel();
	pCentro = new JPanel(new GridLayout(3,1));
	pSur = new JPanel();
	pCentroDer = new JPanel();
	pCentroIzq = new JPanel();
	pCentroCen = new JPanel();
	pOeste = new JPanel();
	pEste = new JPanel();
	logger.info("JPanel creados");

	imagenLabel = new JLabel();
	txtIS = new JLabel("INICIA SESIÓN:");
	txtOlvidoCsnia = new JLabel("<html><u>¿Has olvidado tu contraseña?</u></html>");
	txtOlvidoCsnia.setForeground(Color.BLUE);
	txtCorreo = new JLabel("correo:          ");
	txtContrasenia = new JLabel("contraseña:  ");
	txtNull = new JLabel("");
	logger.info("JLabel creados");
	

	ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
	JLabel labelImagenLogo = new JLabel(logo);
	labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
	logger.info("Imagenes creadas");
	
	btnIS = new JButton("INICIAR SESIÓN");
	btnReg = new JButton("REGISTRARSE");
	logger.info("JButtons creados");
	 
	campoContrasenia = new JPasswordField(20);
	campoCorreo = new JTextField(20);
	logger.info("JPasword creado");
	
	pNorteIzq.add(txtIS);
	pNorteDer.add(labelImagenLogo);
	
	pNorte.add(pNorteIzq,BorderLayout.EAST);
	pNorte.add(pNorteDer,BorderLayout.WEST);
	//añadir imagen
	
	pCentroDer.add(txtCorreo);
	pCentroDer.add(campoCorreo);
	//pCentro.add(txtNull);
	pCentroIzq.add(txtContrasenia);
	pCentroIzq.add(campoContrasenia);
	//pCentro.add(txtNull);
	pCentroCen.add(txtOlvidoCsnia);
	pCentroCen.add(txtNull);
	
	pCentro.add(pCentroDer, BorderLayout.NORTH);
	pCentro.add(pCentroIzq, BorderLayout.CENTER);
	pCentro.add(pCentroCen, BorderLayout.SOUTH);
	pSur.add(btnReg);
	pSur.add(btnIS);	
	
	pOeste.add(txtNull);
	
	pEste.add(txtNull);
	
	
	
	//EVENTOS
	txtOlvidoCsnia.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			VentanaModificarDatos VMD = new VentanaModificarDatos();
			dispose();
		}
	});
	
	btnIS.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaInicio VI = new VentanaInicio();
			dispose();			
		}
	});
	
	btnReg.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaRegistro VR = new VentanaRegistro();
			dispose();			
		}
	});
	
	
	add(pNorte,BorderLayout.NORTH);
	add(pSur,BorderLayout.SOUTH);
	add(pCentro,BorderLayout.CENTER);
	add(pEste,BorderLayout.EAST);
	add(pOeste,BorderLayout.WEST);
	//pCentro.add(pCentroDer);
	
	/**Cargamos la configuración del logger*/

	
	setTitle("Inicio Sesión");
	setBounds(300, 200, 600, 300);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
