package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import domain.Dominios;
import domain.Envio;
import domain.Usuario;

public class VentanaInicioSesion extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	
	private JPanel pNorte, pNorteIzq, pNorteDer, pSur, pOeste, pEste, pCentro, pCentroDer, pCentroIzq, pCentroCen;
	private JButton btnReg, btnIS, btnOjoCon;
	private JTextField campoCorreo, campoContrasenia1;
	private JPasswordField campoContrasenia;
	private JLabel txtIS, txtOlvidoCsnia, txtCorreo, txtContrasenia, txtNull;
	
    private Map<Usuario, List<Envio>> usuariosPorEnvios = new HashMap<>();
    
	private boolean esOjoAbierto = false;
	private boolean aIniciadoSesion;
	
    private String contrasenia;
	
	private Logger logger = Logger.getLogger(VentanaInicioSesion.class.getName());
	
	private WindowMaster windowMaster = new WindowMaster();
	
	public Usuario usuario; 
	
	public VentanaInicioSesion(Map<Usuario, List<Envio>> usuariosPorEnviosS) {
	
	usuariosPorEnvios = usuariosPorEnviosS;
	aIniciadoSesion = false;
		
	pNorte = new JPanel(new GridLayout(1,2));
	pNorteIzq = new JPanel();
	pNorteDer = new JPanel();
	pCentro = new JPanel(new GridLayout(3,1));
	pSur = new JPanel();
	pCentroDer = new JPanel();
	pCentroIzq = new JPanel();
	pCentroCen = new JPanel();
	pOeste = new JPanel();
	pEste = new JPanel();
	logger.info("JPanel creados");

	txtIS = new JLabel("INICIA SESIÓN:");
	txtOlvidoCsnia = new JLabel("<html><u>¿Has olvidado tu contraseña?</u></html>");
	txtOlvidoCsnia.setForeground(Color.BLUE);
	txtCorreo = new JLabel("correo:");
	txtContrasenia = new JLabel("       contraseña:");
	txtNull = new JLabel("");
	logger.info("JLabel creados");
	
	ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("/Images/ojoAbierto.png"));
	ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("/Images/ojoCerrado.png"));
	ImageIcon logo = new ImageIcon(getClass().getResource("/Images/logoPngNegro.png"));
	JLabel labelImagenLogo = new JLabel(logo);
	labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
	logger.info("Imagenes creadas");
	
	btnIS = new JButton("INICIAR SESIÓN");
	btnReg = new JButton("REGISTRARSE");
	btnOjoCon = new JButton(ojoAbierto);
	logger.info("JButtons creados");
	 
	campoContrasenia = new JPasswordField(20);
	campoContrasenia1 = new JTextField(20);
	campoCorreo = new JTextField(20);
	logger.info("JPasword creado");
	
	
	pNorteIzq.add(txtIS);
	pNorteDer.add(labelImagenLogo);
	
	pNorte.add(pNorteIzq,BorderLayout.EAST);
	pNorte.add(pNorteDer,BorderLayout.WEST);
	
	pCentroDer.add(txtCorreo);
	pCentroDer.add(campoCorreo);
	
	pCentroIzq.add(txtContrasenia);
	pCentroIzq.add(campoContrasenia);
	pCentroIzq.add(btnOjoCon);
	
	pCentroCen.add(txtOlvidoCsnia);
	pCentroCen.add(txtNull);
	
	pCentro.add(pCentroDer, BorderLayout.NORTH);
	pCentro.add(pCentroIzq, BorderLayout.CENTER);
	pCentro.add(pCentroCen, BorderLayout.SOUTH);
	pSur.add(btnReg);
	pSur.add(btnIS);	
	
	pOeste.add(txtNull);
	
	pEste.add(txtNull);
	
	
	
/** EVENTOS */
	txtOlvidoCsnia.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			SwingUtilities.invokeLater(() -> new VentanaModificarDatos(usuariosPorEnvios, aIniciadoSesion, null));
			dispose();
		}
	});
	
	btnIS.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String correo = campoCorreo.getText();
            if (esOjoAbierto) {
            	contrasenia = campoContrasenia1.getText();
            } else {
            	contrasenia = new String(campoContrasenia.getPassword());
            }

            boolean credencialesCorrectas = false;
    	    for (Map.Entry<Usuario, List<Envio>> UsuarioYenvios : usuariosPorEnvios.entrySet()) {
                Usuario usuarioO = UsuarioYenvios.getKey();
                if (usuarioO.getCorreo().equals(correo) && usuarioO.getContrasenia().equals(contrasenia)) {
                    credencialesCorrectas = true;
                    usuario = usuarioO;
                    break;
                }
            }
            	

    	    
            if (windowMaster.verificarDominio(correo).equals("Empleado")) {
            	
            	if (credencialesCorrectas) {
                	JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
                	SwingUtilities.invokeLater(() -> new VentanaGestionEmpleados(usuariosPorEnvios, usuario));
    				dispose();
            	} else {
                	JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            	}
            } else if (windowMaster.verificarDominio(correo).equals("Cliente")) {
            	if (credencialesCorrectas) {
                	JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
    				SwingUtilities.invokeLater(() -> new VentanaInicio(usuariosPorEnvios, usuario));		
    				dispose();
            	} else {
                	JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            	}
            } else {
            	JOptionPane.showMessageDialog(null, "Dominio no registrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
           

    	    
            }

	});
	
	btnReg.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(() -> new VentanaRegistro(usuariosPorEnvios));
			dispose();			
		}
	});
	
	btnOjoCon.addActionListener(new ActionListener() {			
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!esOjoAbierto) {
				contrasenia = new String(campoContrasenia.getPassword());
				campoContrasenia1.setText(contrasenia);
				pCentroIzq.remove(campoContrasenia);
				pCentroIzq.add(campoContrasenia1);
				pCentroIzq.revalidate();
				pCentroIzq.repaint();
				btnOjoCon.setIcon(ojoCerrado);
				pCentroIzq.remove(btnOjoCon);
				pCentroIzq.add(btnOjoCon);
			}
			else {
				contrasenia = new String(campoContrasenia1.getText());
				campoContrasenia.setText(contrasenia);
				pCentroIzq.remove(campoContrasenia1);
				pCentroIzq.add(campoContrasenia);
				pCentroIzq.revalidate();
				pCentroIzq.repaint();
				btnOjoCon.setIcon(ojoAbierto);
				pCentroIzq.remove(btnOjoCon);
				pCentroIzq.add(btnOjoCon);
			}
			esOjoAbierto = !esOjoAbierto;
		}
	});
	 

	
	
	add(pNorte,BorderLayout.NORTH);
	add(pSur,BorderLayout.SOUTH);
	add(pCentro,BorderLayout.CENTER);
	add(pEste,BorderLayout.EAST);
	add(pOeste,BorderLayout.WEST);
	
	
	setTitle("Inicio Sesión");
	setBounds(300, 200, 600, 325);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	
}
