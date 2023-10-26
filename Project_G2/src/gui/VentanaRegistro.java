package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaRegistro extends JFrame{
	
	
	private JPanel pNorte, pSur, pOeste, pEste, pCentro, pContrasenia, pNombre, pApellido, pCorreo, pTelefono, pPregSeg, pVenificaCon, pRespuesta;
	private JLabel txtReg, txtNombre, txtApellido, txtCorreo, txtTelefono, txtContrasenia, txtPregSeg, txtVenificaCon, txtRespuesta;
	private JButton btnReg, btnVolver, btnOjoCon, btnOjoConVen;
	private JComboBox<String> pregSeg;
	private JCheckBox Condiciones;
	private JTextField campoReg, campoNombre, campoApellido, campoCorreo, 
						campoTelefono, campoRespuesta, campoContrasenia1, 
						campoVenificaCon1;
	private JPasswordField campoContrasenia, campoVenificaCon;
	

	
	
	public VentanaRegistro() {
		
		pNorte = new JPanel(new BorderLayout());
		pCentro = new JPanel(new GridLayout(4,2));
		pSur = new JPanel();
		pOeste = new JPanel();
		pEste = new JPanel();
		pContrasenia = new JPanel();
		pNombre = new JPanel();
		pApellido = new JPanel();
		pCorreo = new JPanel();
		pTelefono = new JPanel();
		pPregSeg = new JPanel();
		pVenificaCon = new JPanel();
		pRespuesta = new JPanel();
		
		ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("ojoCerrado.png"));
		ImageIcon ojoAbierto1 = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado1 = new ImageIcon(getClass().getResource("ojoCerrado.png"));
		
		
		txtReg = new JLabel("REGISTRATE:");
		txtNombre = new JLabel("Nombre:");
		txtApellido = new JLabel("Apellido:");
		txtCorreo = new JLabel("Correo:");
		txtTelefono = new JLabel("Telefono:");
		txtContrasenia = new JLabel("Contraseña:");
		txtPregSeg = new JLabel("Pregunta de Seguridad:");
		txtVenificaCon = new JLabel("Repite contraseña:");
		txtRespuesta = new JLabel("Respuesta:");
		

		btnReg = new JButton("REGISTRARSE");
		btnVolver = new JButton("VOLVER");
		btnOjoCon = new JButton(ojoAbierto);
		btnOjoConVen = new JButton(ojoAbierto1);
		
		campoContrasenia = new JPasswordField(10);
		campoVenificaCon = new JPasswordField(10);
		
		campoReg = new JTextField(10);
		campoVenificaCon1 = new JTextField(10);
		campoContrasenia1 = new JTextField(10);
		campoNombre = new JTextField(10);
		campoApellido = new JTextField(10);
		campoCorreo = new JTextField(10);
		campoTelefono = new JTextField(10);
		campoRespuesta = new JTextField(10);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));

		Condiciones = new JCheckBox("Acepto condiciones y términos de seguridad");
		
		pregSeg = new JComboBox<>();
		
		pNorte.add(txtReg, BorderLayout.NORTH);
		
		
		pNombre.add(txtNombre);
		pNombre.add(campoNombre);
		pCentro.add(pNombre);
		
		pCorreo.add(txtCorreo);
		pCorreo.add(campoCorreo);
		pCentro.add(pCorreo);
		
		pContrasenia.add(txtContrasenia);
		pContrasenia.add(campoContrasenia);
		pContrasenia.add(btnOjoCon);
		pCentro.add(pContrasenia);
		
		pPregSeg.add(txtPregSeg);
		pPregSeg.add(pregSeg);
		pCentro.add(pPregSeg);

		pApellido.add(txtApellido);
		pApellido.add(campoApellido);
		pCentro.add(pApellido);

		pTelefono.add(txtTelefono);
		pTelefono.add(campoTelefono);
		pCentro.add(pTelefono);

		pVenificaCon.add(txtVenificaCon);
		pVenificaCon.add(campoVenificaCon);
		pVenificaCon.add(btnOjoConVen);
		pCentro.add(pVenificaCon);
		
		pRespuesta.add(txtRespuesta);
		pRespuesta.add(campoRespuesta);
		pCentro.add(pRespuesta);

		pSur.add(Condiciones);
		
		
		pSur.add(btnReg);
		pSur.add(btnVolver);	
		
		
		
		pNorte.add(pCentro);
		pNorte.add(labelImagenLogo);
		
		this.add(pNorte,BorderLayout.NORTH);
		this.add(pSur,BorderLayout.SOUTH);
		this.add(pCentro,BorderLayout.CENTER);
		this.add(pEste,BorderLayout.EAST);
		this.add(pOeste,BorderLayout.WEST);
		
//EVENTOS
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion ventanaIS = new VentanaInicioSesion();
				dispose();			
			}
		});
		
		btnReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio ventanaInicio = new VentanaInicio();
				dispose();			
			}
		});
		
		btnOjoCon.addActionListener(new ActionListener() {
			boolean esOjoAbierto = true;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (esOjoAbierto) {
					String contrasenia = new String(campoContrasenia.getPassword());
					campoContrasenia1.setText(contrasenia);
					pContrasenia.remove(campoContrasenia);
					pContrasenia.add(campoContrasenia1);
					pContrasenia.revalidate();
					pContrasenia.repaint();
					btnOjoCon.setIcon(ojoCerrado);
					pContrasenia.remove(btnOjoCon);
					pContrasenia.add(btnOjoCon);
				}
				else {
					String contrasenia = new String(campoContrasenia1.getText());
					campoContrasenia.setText(contrasenia);
					pContrasenia.remove(campoContrasenia1);
					pContrasenia.add(campoContrasenia);
					pContrasenia.revalidate();
					pContrasenia.repaint();
					btnOjoCon.setIcon(ojoAbierto);
					pContrasenia.remove(btnOjoCon);
					pContrasenia.add(btnOjoCon);
				}
				esOjoAbierto = !esOjoAbierto;
			}
		});
		
		btnOjoConVen.addActionListener(new ActionListener() {
			boolean esOjoAbierto = true;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (esOjoAbierto) {
					String contrasenia = new String(campoVenificaCon.getPassword());
					campoVenificaCon1.setText(contrasenia);
					pVenificaCon.remove(campoVenificaCon);
					pVenificaCon.add(campoVenificaCon1);
					pVenificaCon.revalidate();
					pVenificaCon.repaint();
					btnOjoConVen.setIcon(ojoCerrado1);
					pVenificaCon.remove(btnOjoConVen);
					pVenificaCon.add(btnOjoConVen);
				}
				else {
					String contrasenia = new String(campoVenificaCon1.getText());
					campoVenificaCon.setText(contrasenia);
					pVenificaCon.remove(campoVenificaCon1);
					pVenificaCon.add(campoVenificaCon);
					pVenificaCon.revalidate();
					pVenificaCon.repaint();
					btnOjoConVen.setIcon(ojoAbierto1);
					pVenificaCon.remove(btnOjoConVen);
					pVenificaCon.add(btnOjoConVen);
				}
				esOjoAbierto = !esOjoAbierto;
			}
		});
		
		this.setTitle("Registro");
		this.setBounds(300, 200, 600, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
}

