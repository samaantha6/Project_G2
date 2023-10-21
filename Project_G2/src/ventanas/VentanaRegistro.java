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
	
	private JPanel pNorte, pSur, pOeste, pEste, pCentroIzq, pCentroDer, pCentro;
	private JLabel txtReg, txtNombre, txtApellido, txtCorreo, txtTelefono, txtContrasenia, txtPregSeg, txtVenificaCon, txtRespuesta;
	private JButton btnReg, btnVolver, btnOjo;
	private JComboBox<String> pregSeg;
	private JCheckBox Condiciones;
	private JTextField campoReg, campoNombre, campoApellido, campoCorreo, campoTelefono, campoRespuesta;
	private JPasswordField campoContrasenia, campoVenificaCon;
	
	public VentanaRegistro() {
		
		pNorte = new JPanel(new GridLayout(1,2));
		pCentroIzq = new JPanel(new GridLayout(4,2));
		pCentroDer = new JPanel(new GridLayout(4,2));
		pCentro = new JPanel();
		pSur = new JPanel();
		pOeste = new JPanel();
		pEste = new JPanel();
		
		txtReg = new JLabel("REGISTRATE!!!!!!!!!");
		txtNombre = new JLabel("Nombre");
		txtApellido = new JLabel("Apellido");
		txtCorreo = new JLabel("Correo");
		txtTelefono = new JLabel("Telefono");
		txtContrasenia = new JLabel("Contrasenia");
		txtPregSeg = new JLabel("PregSeg");
		txtVenificaCon = new JLabel("VenificaCon");
		txtRespuesta = new JLabel("Respuesta");
		

		btnReg = new JButton("REGISTRARSE");
		btnVolver = new JButton("volever");
		btnOjo = new JButton("Ojo"); // aqui tenemos que ponder una imagen 
		
		campoContrasenia = new JPasswordField();
		campoVenificaCon = new JPasswordField();
		
		campoReg = new JTextField();
		campoNombre = new JTextField();
		campoApellido = new JTextField();
		campoCorreo = new JTextField();
		campoTelefono = new JTextField();
		campoRespuesta = new JTextField();

		Condiciones = new JCheckBox("Acepto condiciones");
		
		pregSeg = new JComboBox<>();
		
		pNorte.add(txtReg);
		//añadir imagen
		pCentroIzq.add(txtNombre);
		pCentroIzq.add(campoNombre);
		pCentroIzq.add(txtCorreo);
		pCentroIzq.add(campoCorreo);
		pCentroIzq.add(campoContrasenia);
		pCentroIzq.add(txtContrasenia);	//aqui iria el ojo
		pCentroIzq.add(campoContrasenia);
		pCentroIzq.add(txtPregSeg);
		pCentroIzq.add(pregSeg);

		pCentroDer.add(txtApellido);
		pCentroDer.add(campoApellido);
		pCentroDer.add(txtTelefono);
		pCentroDer.add(campoTelefono);
		pCentroDer.add(txtVenificaCon);
		pCentroDer.add(campoVenificaCon);
		pCentroDer.add(txtRespuesta);
		pCentroDer.add(campoRespuesta);

		pSur.add(Condiciones);
		
		pSur.add(btnReg);
		pSur.add(btnVolver);	
		
		this.add(pNorte,BorderLayout.NORTH);
		this.add(pSur,BorderLayout.SOUTH);
		this.add(pCentro,BorderLayout.CENTER);
		this.add(pEste,BorderLayout.EAST);
		this.add(pOeste,BorderLayout.WEST);
		pCentro.add(pCentroIzq);
		pCentro.add(pCentroDer);
		
		this.setTitle("Registro");
		this.setBounds(300, 200, 600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
