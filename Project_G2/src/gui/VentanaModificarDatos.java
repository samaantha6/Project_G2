package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import domain.Envio;
import domain.Usuario;

public class VentanaModificarDatos extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel txtModDatos, txtCorreo, txtTelefono, txtNewCon, txtVerifCon, txtNom,
					txtApel, txtPregSeg, txtRes;
	
	private JTextField campoCorreo, campoTelefono, campoRes, campoNom, campoApel, 
						campoContrasenia1, campoVenificaCon1, campoPregSeg;
	
	private JPasswordField campoCon, campoVerifCon;
	
	private JButton btnElimCuen, btnModif, btnVolver, btnOjoCon, btnOjoConVen;
	
	private JPanel pNorte, pSur, pCentro, pVenificaCon, pContrasenia, pNombre,
					pApellido, pRespuesta, pTelefono, pCorreo, 
					pPregSeg;
	
    private Map<Usuario, List<Envio>> usuariosPorEnvios = new HashMap<>();
    
    private boolean aIniciadoSesion;
    
    private HashMap<JTextField, Color> fondosOriginales;
    
    private Usuario usuario;
        
    private boolean esOjoAbierto = false;
    private boolean esOjoAbiertoVen = false;
	
	private  String contrasenia;
	private String contraseniaVen;
	
	private Thread hilo;
	private boolean hiloEjecutando;
	
	private WindowMaster windowMaster = new WindowMaster();
	
	private Logger logger = Logger.getLogger(VentanaModificarDatos.class.getName());
	
	public VentanaModificarDatos(Map<Usuario, List<Envio>> usuariosPorEnviosS, boolean aIniciadoSesionN, Usuario usuarioO) {
		
		usuariosPorEnvios = usuariosPorEnviosS;
	    aIniciadoSesion = aIniciadoSesionN;
	    usuario = usuarioO;
		
		pNorte = new JPanel(new GridLayout(1,2));
		pSur = new JPanel();
		pCentro = new JPanel(new GridLayout(4,2));
		pContrasenia = new JPanel();
		pVenificaCon = new JPanel();
		pNombre = new JPanel();
		pApellido = new JPanel();
		pRespuesta = new JPanel();
		pTelefono = new JPanel();
		pCorreo = new JPanel();
		pPregSeg = new JPanel();
		logger.info("JPanel creados");
		
		txtNom = new JLabel("    Nombre:");
		txtApel = new JLabel("     Apellido:");
		txtModDatos = new JLabel("MODIFICAR DATOS:");
		txtCorreo = new JLabel("      Correo:");
		txtNewCon = new JLabel("Nueva Contraseña:");
		txtPregSeg = new JLabel("Pregunta de seguridad:");
		txtRes = new JLabel("Respuesta:");
		txtTelefono = new JLabel("    Telefono:");
		txtVerifCon = new JLabel("  Repite contraseña:");
		logger.info("JLabel creados");
		
		ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("/Images/ojoAbierto.png"));
		ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("/Images/ojoCerrado.png"));
		ImageIcon ojoAbierto1 = new ImageIcon(getClass().getResource("/Images/ojoAbierto.png"));
		ImageIcon ojoCerrado1 = new ImageIcon(getClass().getResource("/Images/ojoCerrado.png"));
		logger.info("Imagenes creadoa");
		
		campoNom = new JTextField(10);
		campoApel = new JTextField(10);
		campoCorreo = new JTextField(10);
		campoTelefono = new JTextField(10);
		campoRes = new JTextField(10);
		campoContrasenia1 = new JTextField(10);
		campoVenificaCon1 = new JTextField(10);
		campoPregSeg = new JTextField(10);
		campoPregSeg.setEditable(false);;
		logger.info("JTextFields creados");
		
		campoCon = new JPasswordField(10);
		campoVerifCon = new JPasswordField(10);
		logger.info("JPaswordFields creados");
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/Images/logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		
		
		btnModif = new JButton("MODIFICAR");
		btnElimCuen = new JButton("ELIMINAR CUENTA");
		btnVolver = new JButton("VOLVER");
		btnOjoCon = new JButton(ojoAbierto);
		btnOjoConVen = new JButton(ojoAbierto1);
		logger.info("JButtons creados");
		
		pNorte.add(txtModDatos);
		pNorte.add(labelImagenLogo);
		
		
		pNombre.add(txtNom);	
		pNombre.add(campoNom);
		pCentro.add(pNombre);
		
		pApellido.add(txtApel);
		pApellido.add(campoApel);
		pCentro.add(pApellido);
		
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
		
		pVenificaCon.add(txtVerifCon);		
		pVenificaCon.add(campoVerifCon);
		pVenificaCon.add(btnOjoConVen);
		pCentro.add(pVenificaCon);

		pPregSeg.add(txtPregSeg);		
		pPregSeg.add(campoPregSeg);
		pCentro.add(pPregSeg);

		pRespuesta.add(txtRes);	
		pRespuesta.add(campoRes);
		pCentro.add(pRespuesta);

		pSur.add(btnElimCuen);
		pSur.add(btnModif);
		pSur.add(btnVolver);
		
		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
/* EVENTOS */
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				hilo = new Thread() {
				private String RevisionCorreo;

				public void run() {
					while(hiloEjecutando) {
						RevisionCorreo = campoCorreo.getText();
			    	    for (Map.Entry<Usuario, List<Envio>> UsuarioYenvios : usuariosPorEnvios.entrySet()) {
			                Usuario usuarioO = UsuarioYenvios.getKey();
			                if (usuarioO.getCorreo().equals(RevisionCorreo)) {
				            	usuario = usuarioO;
				                break;
			                }
			            }

				        if (usuario != null) {
						campoPregSeg.setText(usuario.getPreguntaSeg());
				        }
					}
				}
				};
				hiloEjecutando = true;
				hilo.start();
			}
		});
		if (aIniciadoSesion) {
			hiloEjecutando = false;
	        
		System.out.println(usuario);
			campoNom.setText(usuario.getNombre());
			campoApel.setText(usuario.getApellido());
			campoCorreo.setText(usuario.getCorreo());
			campoPregSeg.setText(usuario.getPreguntaSeg());
			campoTelefono.setText(usuario.getTelefono());
		} else {
			
			
			JOptionPane.showMessageDialog(null, "Al no haber iniciado sesión debe escribir su correo para asi ubicar su correo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	    }
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (aIniciadoSesion) {
					SwingUtilities.invokeLater(() -> new VentanaInicio(usuariosPorEnvios, usuario));
					hiloEjecutando = false;

					dispose();
				
				} else {
					SwingUtilities.invokeLater(() -> new VentanaInicioSesion(usuariosPorEnvios));
					hiloEjecutando = false;
					dispose();
				}
			}
		});
		
		btnElimCuen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = campoNom.getText();
                String apellido = campoApel.getText();
                String correo = campoCorreo.getText();
                String telefono = campoTelefono.getText();
                contrasenia = windowMaster.distinguirCampoContrasenia(campoContrasenia1, campoCon, esOjoAbierto).getText();
                contraseniaVen = windowMaster.distinguirCampoContrasenia(campoVenificaCon1, campoVerifCon, esOjoAbierto).getText();
                String respuesta = campoRes.getText();
                List<JTextField> camposVacios = windowMaster.camposVacios(campoNom, campoApel, campoCorreo, campoTelefono, windowMaster.distinguirCampoContrasenia(campoContrasenia1, campoCon, esOjoAbierto), windowMaster.distinguirCampoContrasenia(campoVenificaCon1, campoVerifCon, esOjoAbierto), campoRes);
            	windowMaster.restaurarFondo(fondosOriginales);
                if (usuario.getCorreo().equals(correo) && usuario.getRespuesta().equals(respuesta) && usuario.getContrasenia().equals(contrasenia) && contrasenia.equals(contraseniaVen) && camposVacios.isEmpty()) {
	                usuariosPorEnvios.remove(usuario);
	        		JOptionPane.showMessageDialog(null, "Cuenta eliminada con exito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
					SwingUtilities.invokeLater(() -> new VentanaInicioSesion(usuariosPorEnvios));
	        		dispose();
                } else {
	                fondosOriginales = windowMaster.cambiarFondoCampos(camposVacios);
	        		JOptionPane.showMessageDialog(null, "No se a podido eliminar la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
			}
		});
		
		btnModif.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombre = campoNom.getText();
                String apellido = campoApel.getText();
                String correo = campoCorreo.getText();
                String telefono = campoTelefono.getText();
                contrasenia = windowMaster.distinguirCampoContrasenia(campoContrasenia1, campoCon, esOjoAbierto).getText();
                contraseniaVen = windowMaster.distinguirCampoContrasenia(campoVenificaCon1, campoVerifCon, esOjoAbierto).getText();
                String respuesta = campoRes.getText();
    	        if (usuario != null) {
    	        	if (usuario.getRespuesta().equals(respuesta)) {
    	        		if (contrasenia.equals(contraseniaVen)) {
    	        			usuario.setApellido(apellido);
    	        			usuario.setContrasenia(contrasenia);
    	        			usuario.setCorreo(correo);
    	        			usuario.setTelefono(telefono);
    	        			usuario.setNombre(nombre);
    	        			SwingUtilities.invokeLater(() -> new VentanaInicio(usuariosPorEnvios, usuario));
    						hiloEjecutando = false;
    	        			JOptionPane.showMessageDialog(null, "Cuenta modificada con exito.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    	        			dispose();
    	        		} else {
    	        			JOptionPane.showMessageDialog(null, "La contraseña no coincide.", "Error", JOptionPane.ERROR_MESSAGE);
    	        		}
    	        	} else {
                	JOptionPane.showMessageDialog(null, "La respuesta no es correcta.", "Error", JOptionPane.ERROR_MESSAGE);
    	        	}
    	        } else {
    	        	JOptionPane.showMessageDialog(null, "No existe ningun usuario con ese correo.", "Error", JOptionPane.ERROR_MESSAGE);
    	        }
			}
		});
		
		btnOjoCon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!esOjoAbierto) {
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
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!esOjoAbierto) {
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
