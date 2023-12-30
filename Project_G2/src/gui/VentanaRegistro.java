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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
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
	
	private JLabel txtNombre, txtApellido, txtCorreo, txtTelefono, txtContrasenia,
					txtPregSeg, txtVenificaCon, txtRespuesta, aceptarCond;
	
	private JButton btnReg, btnVolver, btnOjoCon, btnOjoConVen;
	
	private JComboBox<String> pregSeg;
	
	private JCheckBox condiciones;
	
	private JTextField campoReg, campoNombre, campoApellido, campoCorreo, 
						campoTelefono, campoRespuesta, campoContrasenia1, 
						campoVenificaCon1;
	private String textoTYC;

	private JPasswordField campoContrasenia, campoVenificaCon;
	
    public List<Usuario> usuarios = new ArrayList<>();
    
    private boolean esOjoAbierto = false;
    private boolean esOjoAbiertoVen = false;
	
	private  String contrasenia;
	private String contraseniaVen;
	
	private  JTextArea textTYC;
	private JScrollPane scrollTYC;
	
	private Logger logger = Logger.getLogger(VentanaRegistro.class.getName());
	
	private WindowMaster windowMaster = new WindowMaster();

	
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
		
		ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("/Images/ojoAbierto.png"));
		ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("/Images/ojoCerrado.png"));
		ImageIcon ojoAbierto1 = new ImageIcon(getClass().getResource("/Images/ojoAbierto.png"));
		ImageIcon ojoCerrado1 = new ImageIcon(getClass().getResource("/Images/ojoCerrado.png"));
		logger.info("Imagenes creadas");
		
		
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
		aceptarCond = new JLabel("<html><u>Aceptas terminos y condiciones de uso</u></html>");
		condiciones.setEnabled(false);
		logger.info("JCheckBox creado");
		
		pregSeg = new JComboBox<>();
		pregSeg.addItem("¿Cuál es el nombre de tu mascota?");
		pregSeg.addItem("¿Cuál es tu color favorito?");
		pregSeg.addItem("¿Cuál es tu película favorita?");
		logger.info("JComboBox creado");
		
		
		
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
				SwingUtilities.invokeLater(() -> new VentanaInicioSesion(usuarios));
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
                contrasenia = windowMaster.distinguirCampoContrasenia(campoContrasenia1, campoContrasenia, esOjoAbierto).getText();
                contraseniaVen = windowMaster.distinguirCampoContrasenia(campoVenificaCon1, campoVenificaCon, esOjoAbiertoVen).getText();
                String respuesta = campoRespuesta.getText();
                String preguntaSeguridad = pregSeg.getSelectedItem().toString();
                
                if (contrasenia.equals(contraseniaVen)) {
                	List<JTextField> camposVacios = windowMaster.camposVacios(windowMaster.distinguirCampoContrasenia(campoContrasenia1, campoContrasenia, esOjoAbierto), windowMaster.distinguirCampoContrasenia(campoVenificaCon1, campoVenificaCon, esOjoAbiertoVen));
                	Map<JTextField, Color> fondosOriginales = windowMaster.cambiarFondoCampos(camposVacios);
                	
                	boolean usuarioExistente = false;
                	for (Usuario usuario : usuarios) {
                    	if (usuario.getCorreo().equals(correo)) {
                        	usuarioExistente = true;
                        	break;
                    	}
                	}
                	
                	if (!windowMaster.verificarDominio(correo).equals("Empleado")) {
                		campoCorreo.setBackground(UIManager.getColor("TextField.background"));
                		if (windowMaster.verificarDominio(correo).equals("Cliente")) {
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
                    				Usuario nuevoUsuario = new Usuario(nombre, apellido, telefono, correo, respuesta, preguntaSeguridad, contrasenia);
                    				usuarios.add(nuevoUsuario);
                    				JOptionPane.showMessageDialog(null, "Registro exitoso.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    				VentanaInicio ventanaInicio = new VentanaInicio(usuarios, nuevoUsuario);
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
				
				 textTYC = new JTextArea(textoTYC);

			        scrollTYC = new JScrollPane(textTYC);
			        scrollTYC.setPreferredSize(new Dimension(400, 300));

			        int option = JOptionPane.showOptionDialog(
			                null,
			                scrollTYC,
			                "Términos y Condiciones",
			                JOptionPane.OK_CANCEL_OPTION,
			                JOptionPane.PLAIN_MESSAGE,
			                null,
			                new Object[]{"Aceptar", "Rechazar"},
			                "Aceptar"
			        );

			        if (option == JOptionPane.OK_OPTION) {
			            condiciones.setSelected(true);
			        } else {
			        	condiciones.setSelected(false);
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
		
		textoTYC = new String("Aceptación de Términos y Condiciones de uso:\r\n"
				+ "\r\n"
				+ "Al utilizar nuestro sistema, el usuario acepta estos términos y condiciones y se compromete a cumplir con ellos. Estos términos pueden ser modificados en cualquier momento, y el usuario se compromete a revisarlos regularmente para estar al tanto de cualquier cambio.\r\n"
				+ "\r\n"
				+ "Los usuarios pueden necesitar registrarse para utilizar ciertas funciones del sistema. La información proporcionada durante el registro debe ser precisa y completa.\r\n"
				+ "Los usuarios son responsables de mantener la confidencialidad de sus credenciales de inicio de sesión y notificar a Hermes de cualquier uso no autorizado de su cuenta.\r\n"
				+ "\r\n"
				+ "Los usuarios se comprometen a utilizar el sistema de manera adecuada y legal, sin infringir derechos de terceros.\r\n"
				+ "No se permite el uso del sistema para actividades ilegales o fraudulentas.\r\n"
				+ "\r\n"
				+ "Los usuarios son responsables de la exactitud de la información proporcionada al sistema, incluyendo datos de contacto y direcciones de envío.\r\n"
				+ "Los usuarios son responsables de asegurarse de que los paquetes y envíos cumplan con las restricciones y regulaciones aplicables.\r\n"
				+ "\r\n"
				+ "Los usuarios aceptan pagar las tarifas correspondientes a los servicios utilizados, según las tarifas publicadas por Hermes.\r\n"
				+ "Los pagos se pueden realizar a través de los métodos de pago aceptados por el sistema.\r\n"
				+ "\r\n"
				+ "Hermes se compromete a proteger la privacidad y los datos de los usuarios de acuerdo con las leyes aplicables.\r\n"
				+ "\r\n"
				+ "Hermes no se hará responsable de daños indirectos, consecuentes o incidentales.\r\n"
				+ "La responsabilidad de Hermes se limita a los términos establecidos en acuerdos específicos.\r\n"
				+ "\r\n"
				+ "Las políticas de cancelación y devolución se basan en las tarifas y políticas específicas de Hermes.\r\n"
				+ "Los usuarios deben revisar nuestras políticas de cancelación y devolución antes de utilizar el sistema.\r\n"
				+ "\r\n"
				+ "Hermes se reserva el derecho de suspender o cancelar la cuenta de cualquier usuario que incumpla estos términos y condiciones.\r\n"
				+ "\r\n"
				+ "Estos términos y condiciones se rigen por las leyes del país (en este caso España) y cualquier disputa se resolverá mediante arbitraje de conformidad con las reglas de Hermes o ante los tribunales competentes en España.\r\n"
				+ "\r\n"
				+ "Si tiene alguna pregunta o inquietud acerca de estos términos y condiciones, por favor contáctenos a través de support@hermes.es.\r\n"
				+ "\r\n"
				+ "Al utilizar el Sistema de Paquetería de Hermes, usted acepta y comprende estos términos y condiciones. Le recomendamos que imprima o descargue una copia de este documento para su referencia futura.");
	}
	
	
	
}

