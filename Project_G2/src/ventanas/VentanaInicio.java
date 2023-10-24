package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaInicio extends JFrame{
	
	private JPanel pNorte, pNorteIzq, pNorteDer, pSur, pEste, pEsteArriba, pEsteCentro, pEsteAbajo, pOeste, pOesteArriba, pOesteCentro, pOesteAbajo, pCentro;
	private JButton btnVerEnvio, btnFac, btnHacerEnvio, btnCargar, btnCerrarSesion;
	private JTextField campoAlto, campoAncho, campoLargo, campoPeso, campoDesde, campoHasta;
	private JLabel txtBienvedida, txtCrearPre, txtDesde, txtHasta, txtAlto, txtAncho, txtLargo, txtPeso, txtSeparador;

	
	public VentanaInicio() {
		
		pNorte = new JPanel();
		pNorteIzq = new JPanel();
		pNorteDer = new JPanel();
		pCentro = new JPanel(new GridLayout(3,4));
		pSur = new JPanel();
		pEste = new JPanel(new GridLayout(3,1));
		pEsteArriba = new JPanel();
		pEsteCentro = new JPanel(new GridLayout(2,2));
		pEsteAbajo = new JPanel(new GridLayout(2,4));
		pOeste = new JPanel(new GridLayout(3,1));
		pOesteArriba = new JPanel();
		pOesteCentro = new JPanel();
		pOesteAbajo = new JPanel();
		
		txtBienvedida = new JLabel("Bienvenid@!");
		txtCrearPre = new JLabel("Crear Presupuesto:");
		txtDesde = new JLabel("desde");
		txtHasta = new JLabel("hasta");
		txtAlto = new JLabel("Alto");
		txtAncho = new JLabel("Ancho");
		txtLargo = new JLabel("Largo");
		txtPeso = new JLabel("Peso");
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		
		btnVerEnvio = new JButton("VER ENVÍOS");
		btnFac = new JButton("FACTURACION");
		btnHacerEnvio = new JButton("HACER ENVÍO");
		btnCargar = new JButton("CARGAR");
		btnCerrarSesion = new JButton("CERRAR SESIÓN");
		
		campoAlto = new JTextField();
		campoAncho = new JTextField();
		campoLargo = new JTextField();
		campoPeso = new JTextField();
		campoDesde = new JTextField();
		campoHasta = new JTextField();
		
		pNorteIzq.add(btnCerrarSesion);
		pNorteDer.add(txtBienvedida);
		
		pNorte.add(labelImagenLogo);
		pNorte.add(pNorteDer, BorderLayout.EAST);
		pNorte.add(pNorteIzq, BorderLayout.WEST);
		
		pOesteArriba.add(btnVerEnvio);
		//pOesteArriba.add(labelImagenLogo);
		pOesteCentro.add(btnFac);
		//pOesteCentro.add(labelImagenLogo);
		pOesteAbajo.add(btnHacerEnvio);
		//pOesteAbajo.add(labelImagenLogo);
		
		pOeste.add(pOesteArriba, BorderLayout.NORTH);
		pOeste.add(pOesteCentro, BorderLayout.CENTER);
		pOeste.add(pOesteAbajo, BorderLayout.SOUTH);
		
		pEsteArriba.add(txtCrearPre);

		pEsteCentro.add(txtDesde);
		pEsteCentro.add(campoDesde);
		pEsteCentro.add(txtHasta);
		pEsteCentro.add(campoHasta);
		
		pEsteAbajo.add(txtAlto);
		pEsteAbajo.add(campoAlto);
		pEsteAbajo.add(txtAncho);
		pEsteAbajo.add(campoAncho);
		pEsteAbajo.add(txtLargo);
		pEsteAbajo.add(campoLargo);
		pEsteAbajo.add(txtPeso);
		pEsteAbajo.add(campoPeso);
		
		pEste.add(pEsteArriba, BorderLayout.NORTH);
		pEste.add(pEsteCentro, BorderLayout.CENTER);
		pEste.add(pEsteAbajo, BorderLayout.SOUTH);
		
		pCentro.add(pEste,BorderLayout.EAST);
		
		pSur.add(btnCargar);
		
		add(pCentro, BorderLayout.CENTER);
		add(pNorte, BorderLayout.NORTH);
		add(pOeste, BorderLayout.WEST);
		add(pSur, BorderLayout.SOUTH);

		
		setTitle("Pantalla inicio");
		setBounds(300, 200, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		
		VentanaInicioSesion ventanaIS = new VentanaInicioSesion();
		//VentanaRegistro ventanaReg = new VentanaRegistro();
		//VentanaModificarDatos ventanaMD = new VentanaModificarDatos();
		//VentanaFacturacion ventanaFac = new VentanaFacturacion();
		//VentanaInicio a = new VentanaInicio();
		//VentanaHacerEnvio b = new VentanaHacerEnvio();
		//VentanaGestionEmpleados ventanaGesEmp = new VentanaGestionEmpleados();
		
	}

}
