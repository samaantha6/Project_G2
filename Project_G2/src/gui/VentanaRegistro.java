package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

import domain.Dominios;
import domain.Usuario;

public class VentanaRegistro extends JFrame{
	

	private static final long serialVersionUID = 1L;
	
	
	private JPanel pNorte, pSur, pOeste, pEste, pCentro, pContrasenia, pNombre, pApellido, 
					pCorreo, pTelefono, pPregSeg, pVenificaCon, pRespuesta;
	
	private JLabel txtReg, txtNombre, txtApellido, txtCorreo, txtTelefono, txtContrasenia,
					txtPregSeg, txtVenificaCon, txtRespuesta;
	
	private JButton btnReg, btnVolver, btnOjoCon, btnOjoConVen;
	
	private JComboBox<String> pregSeg;
	
	private JCheckBox condiciones;
	
	private JTextField campoReg, campoNombre, campoApellido, campoCorreo, 
						campoTelefono, campoRespuesta, campoContrasenia1, 
						campoVenificaCon1;
	
	private JPasswordField campoContrasenia, campoVenificaCon;
	
    public List<Usuario> usuarios = new ArrayList<>();
    
    private boolean esOjoAbierto = false;
    private boolean esOjoAbiertoVen = false;
	
	private  String contrasenia;
	private String contraseniaVen;
	
	private String correoUsuario;
	
	private Logger logger = Logger.getLogger(VentanaRegistro.class.getName());
	
	private WindowMaster windowMaster = new WindowMaster();

	
	public VentanaRegistro(List<Usuario> usuariosS, String correoUsuarioO) {
		
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
		
		ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("/Images/ojoAbierto.png"));
		ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("/Images/ojoCerrado.png"));
		ImageIcon ojoAbierto1 = new ImageIcon(getClass().getResource("/Images/ojoAbierto.png"));
		ImageIcon ojoCerrado1 = new ImageIcon(getClass().getResource("/Images/ojoCerrado.png"));
		logger.info("Imagenes creadas");
		
		txtReg = new JLabel("REGISTRATE:");
		txtNombre = new JLabel("  Nombre:");
		txtApellido = new JLabel("   Apellido:");
		txtCorreo = new JLabel("    Correo:");
		txtTelefono = new JLabel("   Telefono:");
		txtContrasenia = new JLabel("           Contraseña:");
		txtPregSeg = new JLabel("Pregunta de Seguridad:");
		txtVenificaCon = new JLabel(" Repite contraseña:");
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
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/Images/logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		logger.info("Imagen creada");
		
		condiciones = new JCheckBox();
		JLabel aceptarCond = new JLabel("Acepto condiciones y términos de seguridad");
		aceptarCond.setOpaque(true);
		condiciones.setEnabled(false);
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
		
		pApellido.add(txtApellido);
		pApellido.add(campoApellido);
		pCentro.add(pApellido);
		
		pCorreo.add(txtCorreo);
		pCorreo.add(campoCorreo);
		pCentro.add(pCorreo);
		
		pTelefono.add(txtTelefono);
		pTelefono.add(campoTelefono);
		pCentro.add(pTelefono);
	
		pContrasenia.add(txtContrasenia);
		pContrasenia.add(campoContrasenia);
		pContrasenia.add(btnOjoCon);
		pCentro.add(pContrasenia);
		
		pVenificaCon.add(txtVenificaCon);
		pVenificaCon.add(campoVenificaCon);
		pVenificaCon.add(btnOjoConVen);
		pCentro.add(pVenificaCon);
		
		pPregSeg.add(txtPregSeg);
		pPregSeg.add(pregSeg);
		pCentro.add(pPregSeg);
		
		pRespuesta.add(txtRespuesta);
		pRespuesta.add(campoRespuesta);
		pCentro.add(pRespuesta);


		pSur.add(condiciones);
		pSur.add(aceptarCond);
		
		pSur.add(btnReg);
		pSur.add(btnVolver);	
		
		
		
		pNorte.add(pCentro);
		pNorte.add(labelImagenLogo);
		
		add(pNorte,BorderLayout.NORTH);
		add(pSur,BorderLayout.SOUTH);
		add(pCentro,BorderLayout.CENTER);
		add(pEste,BorderLayout.EAST);
		add(pOeste,BorderLayout.WEST);
				
/** EVENTOS */
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion ventanaIS = new VentanaInicioSesion(usuarios);
				dispose();			
			}
		});
		
		btnReg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = campoNombre.getText();
                String apellido = campoApellido.getText();
                correoUsuario = campoCorreo.getText();
                String telefono = campoTelefono.getText();
                if (esOjoAbierto) {
                	contrasenia = campoContrasenia1.getText();
                } else {
                	contrasenia = new String(campoContrasenia.getPassword());
                }
                if (esOjoAbiertoVen) {
                	contraseniaVen = campoVenificaCon1.getText();
                } else {
                	contraseniaVen = new String(campoVenificaCon.getPassword());
                }
                String respuesta = campoRespuesta.getText();
                String preguntaSeguridad = pregSeg.getSelectedItem().toString();
                if (contrasenia.equals(contraseniaVen) || !contrasenia.isEmpty() || !contraseniaVen.isEmpty()) {
                	campoContrasenia.setBackground(UIManager.getColor("TextField.background"));
                	campoContrasenia1.setBackground(UIManager.getColor("TextField.background"));
                	campoVenificaCon.setBackground(UIManager.getColor("TextField.background"));
                	campoVenificaCon1.setBackground(UIManager.getColor("TextField.background"));
                	
                	boolean usuarioExistente = false;
                	for (Usuario usuario : usuarios) {
                    	if (usuario.getCorreo().equals(correoUsuario)) {
                        	usuarioExistente = true;
                        	break;
                    	}
                	}
                	
                	if (!windowMaster.verificarDominio(correoUsuario).equals("Empleado")) {
                		campoCorreo.setBackground(UIManager.getColor("TextField.background"));
                		if (windowMaster.verificarDominio(correoUsuario).equals("Cliente")) {
                			campoCorreo.setBackground(UIManager.getColor("TextField.background"));
                			if (usuarioExistente) {
                            	campoContrasenia.setBackground(Color.RED);
                            	campoContrasenia1.setBackground(Color.RED);
                            	campoVenificaCon.setBackground(Color.RED);
                            	campoVenificaCon1.setBackground(Color.RED);
                    			campoCorreo.setBackground(Color.RED);
                    			campoApellido.setBackground(Color.RED);
                    			campoReg.setBackground(Color.RED);
                    			campoTelefono.setBackground(Color.RED);
                    			campoNombre.setBackground(Color.RED);
                    			campoRespuesta.setBackground(Color.RED);
                    			
                				JOptionPane.showMessageDialog(null, "El usuario no es valido.", "Error", JOptionPane.ERROR_MESSAGE);
                			} else {
                            	campoContrasenia.setBackground(UIManager.getColor("TextField.background"));
                            	campoContrasenia1.setBackground(UIManager.getColor("TextField.background"));
                            	campoVenificaCon.setBackground(UIManager.getColor("TextField.background"));
                            	campoVenificaCon1.setBackground(UIManager.getColor("TextField.background"));
                    			campoCorreo.setBackground(UIManager.getColor("TextField.background"));
                    			campoApellido.setBackground(UIManager.getColor("TextField.background"));
                    			campoReg.setBackground(UIManager.getColor("TextField.background"));
                    			campoTelefono.setBackground(UIManager.getColor("TextField.background"));
                    			campoNombre.setBackground(UIManager.getColor("TextField.background"));
                    			campoRespuesta.setBackground(UIManager.getColor("TextField.background"));
                    			
                    			if (condiciones.isSelected()) {
                    				aceptarCond.setBackground(UIManager.getColor("TextField.background"));
                    				Usuario nuevoUsuario = new Usuario(nombre, apellido, telefono, correoUsuario, respuesta, preguntaSeguridad, contrasenia);
                    				usuarios.add(nuevoUsuario);
                    				JOptionPane.showMessageDialog(null, "Registro exitoso.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    				VentanaInicio ventanaInicio = new VentanaInicio(usuarios, correoUsuario);
                    				dispose();
                    			} else {
                    				aceptarCond.setBackground(Color.RED);
                    				JOptionPane.showMessageDialog(null, "Desbes acceptar los terminos y condiciones.", "Error", JOptionPane.ERROR_MESSAGE);
                    			}
                			}
                		} else {
                			campoCorreo.setBackground(Color.RED);
            				JOptionPane.showMessageDialog(null, "El dominio del correo empleado no esta registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                		}
                	} else {
                		campoCorreo.setBackground(Color.RED);
                    	JOptionPane.showMessageDialog(null, "No te puedes registrar con un correo de empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                	}
                } else {
                	campoContrasenia.setBackground(Color.RED);
                	campoContrasenia1.setBackground(Color.RED);
                	campoVenificaCon.setBackground(Color.RED);
                	campoVenificaCon1.setBackground(Color.RED);
                	
                	JOptionPane.showMessageDialog(null, "La contraseña no coincide.", "Error", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
		
		
		
		aceptarCond.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion = JOptionPane.showConfirmDialog(null, "terminos y condiciones" , "¿Aceptas las condiciones?", JOptionPane.YES_NO_OPTION);
				if (seleccion == JOptionPane.OK_OPTION) {
					condiciones.setSelected(true);
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
				esOjoAbierto = !esOjoAbierto;
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
				esOjoAbiertoVen = !esOjoAbiertoVen;
			}
		});
		
		this.setTitle("Registro");
		this.setBounds(300, 200, 700, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
}

