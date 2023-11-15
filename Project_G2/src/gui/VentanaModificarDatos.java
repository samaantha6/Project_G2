package gui;

import java.awt.BorderLayout;
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
import java.util.List;
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
	
    private List<Usuario> usuarios = new ArrayList<>();
    
    private boolean aIniciadoSesion;
    
    private Usuario usuario;
    
    private String correoUsuario;
    
    private boolean esOjoAbierto = false;
    private boolean esOjoAbiertoVen = false;
	
	private  String contrasenia;
	private String contraseniaVen;
	
	private Thread hilo;
	private boolean hiloEjecutando;
	
	private Logger logger = Logger.getLogger(VentanaModificarDatos.class.getName());
	
	public VentanaModificarDatos(List<Usuario> usuariosS, boolean aIniciadoSesionN, String correoUsuarioO) {
		
	    usuarios = usuariosS;
	    aIniciadoSesion = aIniciadoSesionN;
	    correoUsuario = correoUsuarioO;
		
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
		
		txtNom = new JLabel("Nombre:");
		txtApel = new JLabel("Apellido:");
		txtModDatos = new JLabel("MODIFICAR DATOS:");
		txtCorreo = new JLabel("Correo:");
		txtNewCon = new JLabel("Nueva Contraseña:");
		txtPregSeg = new JLabel("Pregunta de seguridad:");
		txtRes = new JLabel("Respuesta:");
		txtTelefono = new JLabel("Telefono:");
		txtVerifCon = new JLabel("Repite contraseña:");
		logger.info("JLabel creados");
		
		ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("ojoCerrado.png"));
		ImageIcon ojoAbierto1 = new ImageIcon(getClass().getResource("ojoAbierto.png"));
		ImageIcon ojoCerrado1 = new ImageIcon(getClass().getResource("ojoCerrado.png"));
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
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
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
		
/** EVENTOS */
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				hilo = new Thread() {
				private Usuario usuario;
				private String RevisionCorreo;

				public void run() {
					while(hiloEjecutando) {
						RevisionCorreo = campoCorreo.getText();
				        for (Usuario usuario : usuarios) {
				            if (usuario.getCorreo().equals(RevisionCorreo)) {
				            	this.usuario = usuario;
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

	        for (Usuario usuario : usuarios) {
	            if (usuario.getCorreo().equals(correoUsuario)) {
	            	this.usuario = usuario;
	                break;
	            }
	        }
		
			campoNom.setText(usuario.getNombre());
			campoApel.setText(usuario.getApellido());
			campoCorreo.setText(usuario.getCorreo());
			campoPregSeg.setText(usuario.getPreguntaSeg());
			campoTelefono.setText(usuario.getTelefono());
		} else {
			JOptionPane.showMessageDialog(null, "Como no has iniciado sesión tienes que escribir tu correo para poder ubicar tu usuario.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	    }
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (aIniciadoSesion) {
					VentanaInicio ventanaInicio = new VentanaInicio(usuarios, correoUsuario);
					hiloEjecutando = false;

					dispose();
				
				} else {
					VentanaInicioSesion ventanaIS = new VentanaInicioSesion(usuarios);
					hiloEjecutando = false;
					dispose();
				}
			}
		});
		
		btnModif.addActionListener(new ActionListener() {
			private Usuario usuario;

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombre = campoNom.getText();
                String apellido = campoApel.getText();
                correoUsuario = campoCorreo.getText();
                String telefono = campoTelefono.getText();
                if (esOjoAbierto) {
                	contrasenia = campoContrasenia1.getText();
                } else {
                	contrasenia = new String(campoCon.getPassword());
                }
                if (esOjoAbiertoVen) {
                	contraseniaVen = campoVenificaCon1.getText();
                } else {
                	contraseniaVen = new String(campoVerifCon.getPassword());
                }
                String respuesta = campoRes.getText();
                
    	        for (Usuario usuario : usuarios) {
    	            if (usuario.getCorreo().equals(correoUsuario)) {
    	            	this.usuario = usuario;
    	                break;
    	            }
    	        }
                
    	        System.out.println(usuario);
    	        if (usuario != null) {
    	        	if (usuario.getRespuesta().equals(respuesta)) {
    	        		if (contrasenia.equals(contraseniaVen)) {
    	        			usuario.setApellido(apellido);
    	        			usuario.setContrasenia(contrasenia);
    	        			if (usuario != null) {
    	        				usuario.setCorreo(correoUsuario);
    	        			}
    	        			usuario.setTelefono(telefono);
    	        			usuario.setNombre(nombre);
    	        			System.out.println(correoUsuario);
        	            	System.out.println(usuario);
    	        			VentanaInicio ventanaInicio = new VentanaInicio(usuarios, correoUsuario);
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
