package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame{
	
	
	protected JPanel pNorte, pSur, pOeste, pEste, pCentro;
	protected JButton btnReg, btnIS;
	protected JTextField campoCorreo;
	protected JPasswordField campoContrasenia;
	protected JLabel txtIS, txtOlvidoCsnia, txtCorreo, txtContrasenia, txtNull;
	
	
	public VentanaInicioSesion() {
	
	 
	pNorte = new JPanel(new GridLayout(1,2));
	pCentro = new JPanel(new GridLayout(3,3));
	pSur = new JPanel();
	
	
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
	pCentro.add(txtNull);	//aqui iria el ojo
	pCentro.add(txtNull);
	pCentro.add(txtOlvidoCsnia);
	pCentro.add(txtNull);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	this.add(pNorte,BorderLayout.NORTH);
	this.add(pSur,BorderLayout.SOUTH);
	this.add(pCentro,BorderLayout.CENTER);
	
	
	this.setTitle("Inicio Sesión");
	this.setBounds(300, 200, 600, 400);
	this.setVisible(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
