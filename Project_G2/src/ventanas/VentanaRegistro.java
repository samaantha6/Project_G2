package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame{
	
	
	private JPanel pNorte, pSur, pOeste, pEste, pCentro;
	private JLabel txtReg, txtNombre, txtApellido, txtCorreo, txtTelefono, txtContrasenia, txtPregSeg, txtVenificaCon, txtRespuesta;
	private JButton btnReg, btnVolver;
	private JComboBox<String> pregSeg;
	private JCheckBox Condiciones;
	private JTextField campoReg, campoNombre, campoApellido, campoCorreo, campoTelefono, campoRespuesta;
	private JPasswordField campoContrasenia, campoVenificaCon;
	

	
	
	public VentanaRegistro() {
		
		pNorte = new JPanel(new GridLayout(1,2));
		pCentro = new JPanel(new GridLayout(8,2));
		pSur = new JPanel();
		pOeste = new JPanel();
		pEste = new JPanel();
		
		txtReg = new JLabel("REGISTRATE:");
		txtNombre = new JLabel("Nombre:");
		txtApellido = new JLabel("Apellido:");
		txtCorreo = new JLabel("Correo:");
		txtTelefono = new JLabel("Telefono:");
		txtContrasenia = new JLabel("Contrasenia:");
		txtPregSeg = new JLabel("Pregunta de Seguridad:");
		txtVenificaCon = new JLabel("Venifica la contraseña:");
		txtRespuesta = new JLabel("Respuesta:");
		

		btnReg = new JButton("REGISTRARSE");
		btnVolver = new JButton("VOLVER");
		
		campoContrasenia = new JPasswordField();
		campoVenificaCon = new JPasswordField();
		
		campoReg = new JTextField();
		campoNombre = new JTextField();
		campoApellido = new JTextField();
		campoCorreo = new JTextField();
		campoTelefono = new JTextField();
		campoRespuesta = new JTextField();

		Condiciones = new JCheckBox("Acepto condiciones y términos de seguridad");
		
		pregSeg = new JComboBox<>();
		
		pNorte.add(txtReg);
		
		
		//añadir imagen
		pCentro.add(txtNombre);
		pCentro.add(campoNombre);
		pCentro.add(txtCorreo);
		pCentro.add(campoCorreo);
		pCentro.add(campoContrasenia);
		pCentro.add(txtContrasenia);	//aqui iria el ojo
		pCentro.add(campoContrasenia);
		pCentro.add(txtPregSeg);
		pCentro.add(pregSeg);

		pCentro.add(txtApellido);
		pCentro.add(campoApellido);
		pCentro.add(txtTelefono);
		pCentro.add(campoTelefono);
		pCentro.add(txtVenificaCon);
		pCentro.add(campoVenificaCon);
		pCentro.add(txtRespuesta);
		pCentro.add(campoRespuesta);

		pSur.add(Condiciones);
		
		
		pSur.add(btnReg);
		pSur.add(btnVolver);	
		
		this.add(pNorte,BorderLayout.NORTH);
		this.add(pSur,BorderLayout.SOUTH);
		this.add(pCentro,BorderLayout.CENTER);
		this.add(pEste,BorderLayout.EAST);
		this.add(pOeste,BorderLayout.WEST);
		
		this.setTitle("Registro");
		this.setBounds(300, 200, 600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
}

