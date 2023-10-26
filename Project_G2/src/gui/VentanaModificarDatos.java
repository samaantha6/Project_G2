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
	private JTextField campoCorreo, campoTelefono, campoRes, campoNom, campoApel, 
						campoContrasenia1, campoVenificaCon1;
	private JPasswordField campoCon, campoVerifCon;
	private JButton btnElimCuen, btnModif, btnVolver, btnOjoCon, btnOjoConVen;
	private JPanel pNorte, pSur, pCentro, pVenificaCon, pContrasenia, pNombre,
					pApellido, pRespuesta, pTelefono, pCorreo, 
					pPregSeg;
	private JComboBox<String> campoPregSeg;
	
	/**
	 * Meotodo samdksada
	 * @param
	 * @return zssadaz
	 */
	public VentanaModificarDatos() {
		
		pNorte = new JPanel(new GridLayout(1,2));
		pSur = new JPanel(new GridLayout(1,3));
		pCentro = new JPanel(new GridLayout(4,2));
		pContrasenia = new JPanel();
		pVenificaCon = new JPanel();
		pNombre = new JPanel();
		pApellido = new JPanel();
		pRespuesta = new JPanel();
		pTelefono = new JPanel();
		pCorreo = new JPanel();
		pPregSeg = new JPanel();
		
		txtNom = new JLabel("Nombre:");
		txtApel = new JLabel("Apellido:");
		txtModDatos = new JLabel("MODIFICAR DATOS:");
		txtCorreo = new JLabel("Correo:");
		txtNewCon = new JLabel("Nueva Contraseña:");
		txtPregSeg = new JLabel("Pregunta de seguridad:");
		txtRes = new JLabel("Respuesta:");
		txtTelefono = new JLabel("Telefono:");
		txtVerifCon = new JLabel("Repite contraseña:");
		
		ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("ojoCerrado.png"));
		ImageIcon ojoAbierto1 = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado1 = new ImageIcon(getClass().getResource("ojoCerrado.png"));
		
		campoNom = new JTextField(10);
		campoApel = new JTextField(10);
		campoCorreo = new JTextField(10);
		campoTelefono = new JTextField(10);
		campoRes = new JTextField(10);
		campoContrasenia1 = new JTextField(10);
		campoVenificaCon1 = new JTextField(10);
		campoPregSeg = new JComboBox<>();

		campoCon = new JPasswordField(10);
		campoVerifCon = new JPasswordField(10);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		
		btnModif = new JButton("MODIFICAR");
		btnElimCuen = new JButton("ELIMINAR CUENTA");
		btnVolver = new JButton("VOLVER");
		btnOjoCon = new JButton(ojoAbierto);
		btnOjoConVen = new JButton(ojoAbierto1);
		
		pNorte.add(txtModDatos);
		pNorte.add(labelImagenLogo);
		
		pCorreo.add(txtCorreo);		
		pCorreo.add(campoCorreo);
		pCentro.add(pCorreo);
		
		pTelefono.add(txtTelefono);		
		pTelefono.add(campoTelefono);
		pCentro.add(pTelefono);

		pContrasenia.add(txtNewCon);		
		pContrasenia.add(campoCon);
		pContrasenia.add(btnOjoCon);
		pCentro.add(pContrasenia);
		
		pApellido.add(txtApel);
		pApellido.add(campoApel);
		pCentro.add(pApellido);

		pPregSeg.add(txtPregSeg);		
		pPregSeg.add(campoPregSeg);
		pCentro.add(pPregSeg);

		pRespuesta.add(txtRes);	
		pRespuesta.add(campoRes);
		pCentro.add(pRespuesta);

		pNombre.add(txtNom);	
		pNombre.add(campoNom);
		pCentro.add(pNombre);

		pVenificaCon.add(txtVerifCon);		
		pVenificaCon.add(campoVerifCon);
		pVenificaCon.add(btnOjoConVen);
		pCentro.add(pVenificaCon);

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
		
		btnOjoCon.addActionListener(new ActionListener() {
			boolean esOjoAbierto = true;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (esOjoAbierto) {
					String contrasenia = new String(campoCon.getPassword());
					campoContrasenia1.setText(contrasenia);
					pContrasenia.remove(campoCon);
					pContrasenia.add(campoContrasenia1);
					pContrasenia.revalidate();
					pContrasenia.repaint();
					btnOjoCon.setIcon(ojoCerrado);
					pContrasenia.remove(btnOjoCon);
					pContrasenia.add(btnOjoCon);
				}
				else {
					String contrasenia = new String(campoContrasenia1.getText());
					campoCon.setText(contrasenia);
					pContrasenia.remove(campoContrasenia1);
					pContrasenia.add(campoCon);
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
					String contrasenia = new String(campoVerifCon.getPassword());
					campoVenificaCon1.setText(contrasenia);
					pVenificaCon.remove(campoVerifCon);
					pVenificaCon.add(campoVenificaCon1);
					pVenificaCon.revalidate();
					pVenificaCon.repaint();
					btnOjoConVen.setIcon(ojoCerrado1);
					pVenificaCon.remove(btnOjoConVen);
					pVenificaCon.add(btnOjoConVen);
				}
				else {
					String contrasenia = new String(campoVenificaCon1.getText());
					campoVerifCon.setText(contrasenia);
					pVenificaCon.remove(campoVenificaCon1);
					pVenificaCon.add(campoVerifCon);
					pVenificaCon.revalidate();
					pVenificaCon.repaint();
					btnOjoConVen.setIcon(ojoAbierto1);
					pVenificaCon.remove(btnOjoConVen);
					pVenificaCon.add(btnOjoConVen);
				}
				esOjoAbierto = !esOjoAbierto;
			}
		});
		
	this.setTitle("Modificar Datos");
	this.setBounds(300, 200, 600, 400);
	this.setVisible(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
