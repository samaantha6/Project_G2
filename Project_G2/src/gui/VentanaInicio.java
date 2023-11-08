package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.Usuario;

public class VentanaInicio extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pNorteIzq, pNorteDer, pSur, pEste, pEsteArriba, pEsteCentro, pEsteCentroArriba, 
					pEsteCentroAbajo, pEsteAbajoArriba, pEsteAbajoAbajo, pEsteAbajo, pOeste, pOesteArriba, 
					pOesteCentro, pOesteAbajo, pCentro, pbtnCrear;
	private JButton btnVerEnvio, btnFac, btnHacerEnvio, btnCrear, btnCerrarSesion, btnModificar;
	private JTextField campoAlto, campoAncho, campoLargo, campoPeso, campoDesde, campoHasta;
	private JLabel txtBienvedida, txtCrearPre, txtDesde, txtHasta, txtAlto, txtAncho, txtLargo, txtPeso, txtSeparador;
	
    private List<Usuario> usuarios = new ArrayList<>();
    
    private boolean aIniciadoSesion;
    
    String correoUsuario;

	private Logger logger = Logger.getLogger(VentanaInicio.class.getName());
	
	public VentanaInicio(List<Usuario> usuariosS, String correoUsuarioO) {
		
		usuarios = usuariosS;
		correoUsuario = correoUsuarioO;
		aIniciadoSesion = true;

		pNorte = new JPanel();
		pNorteIzq = new JPanel();
		pNorteDer = new JPanel();
		pCentro = new JPanel(new GridLayout(3,4));
		pSur = new JPanel();
		pEste = new JPanel(new GridLayout(4,1));
		pEsteArriba = new JPanel();
		pEsteCentro = new JPanel(new GridLayout(2,1));
		pEsteCentroArriba = new JPanel();
		pEsteCentroAbajo = new JPanel();
		pEsteAbajo = new JPanel(new GridLayout(2,4));
		pEsteAbajoArriba = new JPanel();
		pEsteAbajoAbajo = new JPanel();
		pOeste = new JPanel(new GridLayout(3,1));
		pOesteArriba = new JPanel();
		pOesteCentro = new JPanel();
		pOesteAbajo = new JPanel();
		pbtnCrear = new JPanel();
		logger.info("JPanel creados");
		
		txtBienvedida = new JLabel("Bienvenid@!");
		txtCrearPre = new JLabel("Crear Presupuesto:");
		txtDesde = new JLabel("desde");
		txtHasta = new JLabel("hasta");
		txtAlto = new JLabel("Alto");
		txtAncho = new JLabel("Ancho");
		txtLargo = new JLabel("Largo");
		txtPeso = new JLabel("Peso");
		logger.info("JLabel creados");
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		
		ImageIcon verEnvios = new ImageIcon(getClass().getResource("verEnvios.png"));
		JLabel labelImagenVerEnvio = new JLabel(verEnvios);
		labelImagenVerEnvio.setPreferredSize(new Dimension(verEnvios.getIconWidth(), verEnvios.getIconHeight()));
		
		ImageIcon Facturacion = new ImageIcon(getClass().getResource("Facturacion.png"));
		JLabel labelImagenFacturacion = new JLabel(Facturacion);
		labelImagenFacturacion.setPreferredSize(new Dimension(Facturacion.getIconWidth(), Facturacion.getIconHeight()));
		
		ImageIcon hacerEnvio = new ImageIcon(getClass().getResource("hacerEnvio.png"));
		JLabel labelImagenhacerEnvio = new JLabel(hacerEnvio);
		labelImagenhacerEnvio.setPreferredSize(new Dimension(hacerEnvio.getIconWidth(), hacerEnvio.getIconHeight()));
		logger.info("Imagenes creadas");
		
		btnVerEnvio = new JButton("VER ENVÍOS");
		btnFac = new JButton("FACTURACION");
		btnHacerEnvio = new JButton("HACER ENVÍO");
		btnCrear = new JButton("CREAR");
		btnCerrarSesion = new JButton("CERRAR SESIÓN");
		btnModificar = new JButton("MODIFICAR DATOS");
		logger.info("JButtons creados");
		
		campoAlto = new JTextField(10);
		campoAncho = new JTextField(10);
		campoLargo = new JTextField(10);
		campoPeso = new JTextField(10);
		campoDesde = new JTextField(20);
		campoHasta = new JTextField(20);
		logger.info("JTextFields creados");
		
		pNorteIzq.add(btnCerrarSesion);
		pNorteIzq.add(btnModificar);
		pNorteDer.add(txtBienvedida);
		
		pNorte.add(labelImagenLogo);
		pNorte.add(pNorteDer, BorderLayout.EAST);
		pNorte.add(pNorteIzq, BorderLayout.WEST);
		
		pOesteArriba.add(btnVerEnvio);
		pOesteArriba.add(labelImagenVerEnvio);
		pOesteCentro.add(labelImagenFacturacion);
		pOesteCentro.add(btnFac);
		pOesteAbajo.add(btnHacerEnvio);
		pOesteAbajo.add(labelImagenhacerEnvio);
		
		pOeste.add(pOesteArriba, BorderLayout.NORTH);
		pOeste.add(pOesteCentro, BorderLayout.CENTER);
		pOeste.add(pOesteAbajo, BorderLayout.SOUTH);
		pOeste.setBorder(new EmptyBorder(0, 30, 0, 30));
		pEsteArriba.add(txtCrearPre);

		
		pEsteCentroArriba.add(txtDesde);
		pEsteCentroArriba.add(campoDesde);
		pEsteCentro.add(pEsteCentroArriba);
		
		pEsteCentroAbajo.add(txtHasta);
		pEsteCentroAbajo.add(campoHasta);
		pEsteCentro.add(pEsteCentroAbajo);
		
		
		pEsteAbajoArriba.add(txtAlto);
		pEsteAbajoArriba.add(campoAlto);
		pEsteAbajoArriba.add(txtAncho);
		pEsteAbajoArriba.add(campoAncho);
		pEsteAbajo.add(pEsteAbajoArriba);
		
		pEsteAbajoAbajo.add(txtLargo);
		pEsteAbajoAbajo.add(campoLargo);
		pEsteAbajoAbajo.add(txtPeso);
		pEsteAbajoAbajo.add(campoPeso);
		pEsteAbajo.add(pEsteAbajoAbajo);
		
		pEste.add(pEsteArriba, BorderLayout.NORTH);
		pEste.add(pEsteCentro, BorderLayout.CENTER);
		pEste.add(pEsteAbajo, BorderLayout.SOUTH);
		pEste.setBorder(new EmptyBorder(0, 20, 0, 20));
	
		
		pbtnCrear.add(btnCrear);
		
		pEste.add(pbtnCrear);
		
		add(pCentro, BorderLayout.CENTER);
		add(pNorte, BorderLayout.NORTH);
		add(pOeste, BorderLayout.WEST);
		add(pEste, BorderLayout.EAST);
		add(pSur, BorderLayout.SOUTH);
		
		
		
/** EVENTOS */
		
		
		btnCerrarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion ventanaIS = new VentanaInicioSesion(usuarios);
				dispose();			
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaModificarDatos ventanaMD = new VentanaModificarDatos(usuarios, aIniciadoSesion, correoUsuario);
				dispose();			
			}
		});
		
		btnFac.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaFacturacion ventanaFac = new VentanaFacturacion(usuarios, correoUsuario);
				dispose();			
			}
		});
		
		btnHacerEnvio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaHacerEnvio ventanaHacerEnvio = new VentanaHacerEnvio(usuarios, correoUsuario);
				dispose();			
			}
		});
		
		btnVerEnvio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaVerEnvios ventanaVerEnvios = new VentanaVerEnvios(usuarios, correoUsuario);
				dispose();			
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPresupuesto ventanaPresupuesto = new VentanaPresupuesto(usuarios, correoUsuario);
				dispose();			
			}
		});
		
		
		setTitle("Pantalla inicio");
		setBounds(300, 200, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
