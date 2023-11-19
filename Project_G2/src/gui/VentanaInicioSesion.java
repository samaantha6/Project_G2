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
import domain.Usuario;
import domain.DominioValido;

public class VentanaInicioSesion extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	
	private JPanel pNorte, pNorteIzq, pNorteDer, pSur, pOeste, pEste, pCentro, pCentroDer, pCentroIzq, pCentroCen;
	private JButton btnReg, btnIS, btnOjoCon;
	private JTextField campoCorreo, campoContrasenia1;
	private JPasswordField campoContrasenia;
	private JLabel txtIS, txtOlvidoCsnia, txtCorreo, txtContrasenia, txtNull;
	
    private List<Usuario> usuarios = new ArrayList<>();
    
	private boolean esOjoAbierto = false;
	private boolean aIniciadoSesion;
	
    private String contrasenia;
    private String correoUsuario;
	
	private Logger logger = Logger.getLogger(VentanaInicioSesion.class.getName());
	
	public VentanaInicioSesion(List<Usuario> usuariosS) {
	
	usuarios = usuariosS;
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
	
	ImageIcon ojoAbierto = new ImageIcon(getClass().getResource("ojoAbierto.png"));
	ImageIcon ojoCerrado = new ImageIcon(getClass().getResource("ojoCerrado.png"));
	ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
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
	//añadir imagen
	
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
			SwingUtilities.invokeLater(() -> new VentanaModificarDatos(usuarios, aIniciadoSesion, null));
			dispose();
		}
	});
	
	btnIS.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			correoUsuario = campoCorreo.getText();
            if (esOjoAbierto) {
            	contrasenia = campoContrasenia1.getText();
            } else {
            	contrasenia = new String(campoContrasenia.getPassword());
            }

            boolean credencialesCorrectas = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getCorreo().equals(correoUsuario) && usuario.getContrasenia().equals(contrasenia)) {
                    credencialesCorrectas = true;
                    break;
                }
            }
            	
            if (verificarDominio(correoUsuario).equals("Empleado")) {
            	
            	if (credencialesCorrectas) {
                	JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
                	VentanaGestionEmpleados VGE = new VentanaGestionEmpleados(usuarios, correoUsuario);
    				dispose();
            	} else {
                	JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            	}
            } else if (verificarDominio(correoUsuario).equals("Cliente")) {
            	if (credencialesCorrectas) {
                	JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
    				VentanaInicio VI = new VentanaInicio(usuarios, correoUsuario);
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
			VentanaRegistro VR = new VentanaRegistro(usuarios, correoUsuario);
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
			esOjoAbierto = boolContrario(esOjoAbierto);
		}
	});
	
	add(pNorte,BorderLayout.NORTH);
	add(pSur,BorderLayout.SOUTH);
	add(pCentro,BorderLayout.CENTER);
	add(pEste,BorderLayout.EAST);
	add(pOeste,BorderLayout.WEST);
	
	
	setTitle("Inicio Sesión");
	setBounds(300, 200, 600, 300);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private boolean boolContrario(boolean buleano) {
		return !buleano;
	}
	
    public String verificarDominio(String correoUsuario) {
        this.correoUsuario = correoUsuario;
        for (Dominios dominio : Dominios.values()) {
            if (correoUsuario.endsWith("@hermes.es")) {
                return "Empleado";
            } else if (correoUsuario.endsWith(dominio.getDominio())) {
                return "Cliente";
            } 
        }
        return "Desconocido";
    }
	
}
