package ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaModificarDatos extends JFrame{
	
	private JLabel txtModDatos, txtCorreo, txtTelefono, txtNewCon, txtVerifCon, txtNom, txtApel, txtPregSeg, txtRes;
	private JTextField campoCorreo, campoTelefono, campoPregSeg, campoRes, campoNom, campoApel;
	private JPasswordField campoCon, campoVerifCon;
	private JButton btnElimCuen, btnModif, btnVolver;
	private JPanel pNorte, pSur, pCentro;
	
	
	public VentanaModificarDatos() {
		
		pNorte = new JPanel();
		pSur = new JPanel();
		pCentro = new JPanel();
		
		txtNom = new JLabel("Nombre:");
		txtApel = new JLabel("Apellido:");
		txtModDatos = new JLabel("MODIFICAR DATOS:");
		txtCorreo = new JLabel("Correo:");
		txtNewCon = new JLabel("Nueva Contraseña:");
		txtPregSeg = new JLabel("Pregunta de seguridad:");
		txtRes = new JLabel("Respuesta:");
		txtTelefono = new JLabel("Telefono::");
		txtVerifCon = new JLabel("Verifica la contraseña:");
		
		campoNom = new JTextField();
		campoApel = new JTextField();
		campoCorreo = new JTextField();
		campoPregSeg = new JTextField();
		campoTelefono = new JTextField();
		
		campoCon = new JPasswordField();
		campoVerifCon = new JPasswordField();
		
		btnModif = new JButton("MODIFICAR");
		btnElimCuen = new JButton("ELIMINAR CUENTA");
		btnVolver = new JButton("VOLVER");
		
		
		
		
		
	
	this.setTitle("Modificar Datos");
	this.setBounds(300, 200, 600, 400);
	this.setVisible(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
