package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.Usuario;

public class VentanaRegistro extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	
	private JPanel pNorte, pSur, pOeste, pEste, pCentro, pContrasenia, pNombre, pApellido, 
					pCorreo, pTelefono, pPregSeg, pVenificaCon, pRespuesta;
	
	private JLabel txtReg, txtNombre, txtApellido, txtCorreo, txtTelefono, txtContrasenia,
					txtPregSeg, txtVenificaCon, txtRespuesta;
	
	private JButton btnReg, btnVolver, btnOjoCon, btnOjoConVen;
	
	private JComboBox<String> pregSeg;
	
	private JCheckBox Condiciones;
	
	private JTextField campoReg, campoNombre, campoApellido, campoCorreo, 
						campoTelefono, campoRespuesta, campoContrasenia1, 
						campoVenificaCon1;
	
	private JPasswordField campoContrasenia, campoVenificaCon;
	
    public List<Usuario> usuarios = new ArrayList<>();
    
	boolean esOjoAbierto = false;
	boolean esOjoAbiertoVen = false;
	
    String contrasenia;
	
	private Logger logger = Logger.getLogger(VentanaRegistro.class.getName());
	
	public VentanaRegistro(List<Usuario> usuariosS) {
		
		usuarios = usuariosS;
		
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
		logger.info("JPanel creados");
		
		ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("ojoCerrado.png"));
		ImageIcon ojoAbierto1 = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado1 = new ImageIcon(getClass().getResource("ojoCerrado.png"));
		logger.info("Imagenes creadas");
		
		txtReg = new JLabel("REGISTRATE:");
		txtNombre = new JLabel("Nombre:");
		txtApellido = new JLabel("Apellido:");
		txtCorreo = new JLabel("Correo:");
		txtTelefono = new JLabel("Telefono:");
		txtContrasenia = new JLabel("Contraseña:");
		txtPregSeg = new JLabel("Pregunta de Seguridad:");
		txtVenificaCon = new JLabel("Repite contraseña:");
		txtRespuesta = new JLabel("Respuesta:");
		logger.info("JLabel creados");
		

		btnReg = new JButton("REGISTRARSE");
		btnVolver = new JButton("VOLVER");
		btnOjoCon = new JButton(ojoAbierto);
		btnOjoConVen = new JButton(ojoAbierto1);
		logger.info("JButtons creados");
		
		campoContrasenia = new JPasswordField(10);
		campoVenificaCon = new JPasswordField(10);
		logger.info("JPaswordFields creados");
		
		campoReg = new JTextField(10);
		campoVenificaCon1 = new JTextField(10);
		campoContrasenia1 = new JTextField(10);
		campoNombre = new JTextField(10);
		campoApellido = new JTextField(10);
		campoCorreo = new JTextField(10);
		campoTelefono = new JTextField(10);
		campoRespuesta = new JTextField(10);
		logger.info("JTextFields creados");
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		logger.info("Imagen creada");
		
		Condiciones = new JCheckBox("Acepto condiciones y términos de seguridad");
		logger.info("JCheckBox creado");
		
		pregSeg = new JComboBox<>();
		pregSeg.addItem("¿Cuál es el nombre de tu mascota?");
		pregSeg.addItem("¿Cuál es tu color favorito?");
		pregSeg.addItem("¿Cuál es tu película favorita?");
		logger.info("JComboBox creado");
		
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
		
		add(pNorte,BorderLayout.NORTH);
		add(pSur,BorderLayout.SOUTH);
		add(pCentro,BorderLayout.CENTER);
		add(pEste,BorderLayout.EAST);
		add(pOeste,BorderLayout.WEST);
		
//EVENTOS
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion ventanaIS = new VentanaInicioSesion(null);
				dispose();			
			}
		});
		
		btnReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = campoNombre.getText();
                String apellido = campoApellido.getText();
                String correo = campoCorreo.getText();
                String telefono = campoTelefono.getText();
                if (esOjoAbierto) {
                	contrasenia = campoContrasenia1.getText();
                } else {
                	contrasenia = new String(campoContrasenia.getPassword());
                }
            	System.out.println(contrasenia);
                String respuesta = campoRespuesta.getText();
                String preguntaSeguridad = pregSeg.getSelectedItem().toString();
                boolean usuarioExistente = false;
                for (Usuario usuario : usuarios) {
                    if (usuario.getCorreo().equals(correo)) {
                        usuarioExistente = true;
                        break;
                    }
                }

                if (usuarioExistente) {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
					Usuario nuevoUsuario = new Usuario(nombre, apellido, telefono, correo, respuesta, preguntaSeguridad, contrasenia);
                    usuarios.add(nuevoUsuario);
                    JOptionPane.showMessageDialog(null, "Registro exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
    				VentanaInicio ventanaInicio = new VentanaInicio(usuarios);
    				dispose();
                }
				
			}
		});
		
		btnOjoCon.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!esOjoAbierto) {
					contrasenia = new String(campoContrasenia.getPassword());
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
					contrasenia = new String(campoContrasenia1.getText());
					campoContrasenia.setText(contrasenia);
					pContrasenia.remove(campoContrasenia1);
					pContrasenia.add(campoContrasenia);
					pContrasenia.revalidate();
					pContrasenia.repaint();
					btnOjoCon.setIcon(ojoAbierto);
					pContrasenia.remove(btnOjoCon);
					pContrasenia.add(btnOjoCon);
				}
				esOjoAbierto = boolContrario(esOjoAbierto);
			}
		});
		
		btnOjoConVen.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!esOjoAbiertoVen) {
					contrasenia = new String(campoVenificaCon.getPassword());
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
					contrasenia = new String(campoVenificaCon1.getText());
					campoVenificaCon.setText(contrasenia);
					pVenificaCon.remove(campoVenificaCon1);
					pVenificaCon.add(campoVenificaCon);
					pVenificaCon.revalidate();
					pVenificaCon.repaint();
					btnOjoConVen.setIcon(ojoAbierto1);
					pVenificaCon.remove(btnOjoConVen);
					pVenificaCon.add(btnOjoConVen);
				}
				esOjoAbiertoVen = boolContrario(esOjoAbiertoVen);
			}
		});
		
		this.setTitle("Registro");
		this.setBounds(300, 200, 700, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private boolean boolContrario(boolean buleano) {
		return !buleano;
	}
	
}

