package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaModificarDatos extends JFrame{
	
	private JLabel txtModDatos, txtCorreo, txtTelefono, txtNewCon, txtVerifCon, txtNom,
					txtApel, txtPregSeg, txtRes;
	private JTextField campoCorreo, campoTelefono, campoRes, campoNom, campoApel;
	private JPasswordField campoCon, campoVerifCon;
	private JButton btnElimCuen, btnModif, btnVolver, btnOjoCon, btnOjoConVen;
	private JPanel pNorte, pSur, pCentro, pVenificaCon, pContrasenia;
	private JComboBox<String> campoPregSeg;
	
	/**
	 * Meotodo samdksada
	 * @param
	 * @return zssadaz
	 */
	public VentanaModificarDatos() {
		
		pNorte = new JPanel(new GridLayout(1,2));
		pSur = new JPanel(new GridLayout(1,3));
		pCentro = new JPanel(new GridLayout(8,2));
		pContrasenia = new JPanel();
		pVenificaCon = new JPanel();

		
		txtNom = new JLabel("Nombre:");
		txtApel = new JLabel("Apellido:");
		txtModDatos = new JLabel("MODIFICAR DATOS:");
		txtCorreo = new JLabel("Correo:");
		txtNewCon = new JLabel("Nueva Contraseña:");
		txtPregSeg = new JLabel("Pregunta de seguridad:");
		txtRes = new JLabel("Respuesta:");
		txtTelefono = new JLabel("Telefono::");
		txtVerifCon = new JLabel("Verifica la contraseña:");
		
		ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("ojoCerrado.png"));
		ImageIcon ojoAbierto1 = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado1 = new ImageIcon(getClass().getResource("ojoCerrado.png"));
		
		campoNom = new JTextField();
		campoApel = new JTextField();
		campoCorreo = new JTextField();
		campoTelefono = new JTextField();
		campoRes = new JTextField();
		campoPregSeg = new JComboBox<>();

		campoCon = new JPasswordField();
		campoVerifCon = new JPasswordField();
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		
		btnModif = new JButton("MODIFICAR");
		btnElimCuen = new JButton("ELIMINAR CUENTA");
		btnVolver = new JButton("VOLVER");
		
		pNorte.add(txtModDatos);
		pNorte.add(labelImagenLogo);
		
		pCentro.add(txtCorreo);		
		pCentro.add(campoCorreo);		
		pCentro.add(txtTelefono);		
		pCentro.add(campoTelefono);		
		pCentro.add(txtNewCon);		
		pCentro.add(campoCon);		//ojo
		pCentro.add(txtVerifCon);		
		pCentro.add(campoVerifCon);	//ojo	
		pCentro.add(txtPregSeg);		
		pCentro.add(campoPregSeg);		
		pCentro.add(txtRes);	
		pCentro.add(campoRes);	
		pCentro.add(txtNom);	
		pCentro.add(campoNom);	
		pCentro.add(txtApel);
		pCentro.add(campoApel);
				
		pSur.add(btnElimCuen);
		pSur.add(btnModif);
		pSur.add(btnVolver);
		
		this.add(pNorte, BorderLayout.NORTH);
		this.add(pCentro, BorderLayout.CENTER);
		this.add(pSur, BorderLayout.SOUTH);
		
//EVENTOS
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion ventanaIS = new VentanaInicioSesion();
				dispose();			
			}
		});
		
		btnModif.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio ventanaInicio = new VentanaInicio();
                JOptionPane.showMessageDialog(null, "Cuenta modificada con exito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				dispose();			
			}
		});
		
		
	this.setTitle("Modificar Datos");
	this.setBounds(300, 200, 600, 400);
	this.setVisible(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
