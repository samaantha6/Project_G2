package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame{
	
	
	private JPanel pNorte, pSur, pOeste, pEste, pCentro;
	private JButton btnReg, btnIS;
	private JTextField campoCorreo;
	private JPasswordField campoContrasenia;
	private JLabel txtIS, txtOlvidoCsnia, txtCorreo, txtContrasenia, txtNull;
	
	
	public VentanaInicioSesion() {
	
	 
	pNorte = new JPanel(new GridLayout(1,2));
	pCentro = new JPanel(new GridLayout(3,4));
	pSur = new JPanel();
	pOeste = new JPanel();
	pEste = new JPanel();

	
	txtIS = new JLabel("INICIA SESIÓN:");
	txtOlvidoCsnia = new JLabel("¿Has olvidado tu contraseña?");
	txtCorreo = new JLabel("correo:");
	txtContrasenia = new JLabel("contraseña:");
	txtNull = new JLabel("");
	
	btnIS = new JButton("INICIAR SESIÓN");
	btnReg = new JButton("REGISTRARSE");
	 
	
	campoContrasenia = new JPasswordField();
	campoCorreo = new JTextField();
	
	pNorte.add(txtIS);
	//añadir imagen
	
	pCentro.add(txtCorreo);
	pCentro.add(campoCorreo);
	pCentro.add(txtNull);
	pCentro.add(txtContrasenia);
	pCentro.add(campoContrasenia);
	pCentro.add(txtNull);
	pCentro.add(txtOlvidoCsnia);
	pCentro.add(txtNull);
	
	pSur.add(btnReg);
	pSur.add(btnIS);	
	
	pOeste.add(txtNull);
	
	pEste.add(txtNull);
	
	
	
	//EVENTOS
	txtOlvidoCsnia.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			VentanaRegistro VR = new VentanaRegistro();
			dispose();
		}
	});
	
	
	
	
	
	
	this.add(pNorte,BorderLayout.NORTH);
	this.add(pSur,BorderLayout.SOUTH);
	this.add(pCentro,BorderLayout.CENTER);
	this.add(pEste,BorderLayout.EAST);
	this.add(pOeste,BorderLayout.WEST);
	
	
	this.setTitle("Inicio Sesión");
	this.setBounds(300, 200, 600, 400);
	this.setVisible(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
