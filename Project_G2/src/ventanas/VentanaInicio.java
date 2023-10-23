package ventanas;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaInicio extends JFrame{
	
	private JPanel pNorte, pSur, pEsteArriba, pEsteAbajo, pOeste, pCentro;
	private JButton btnVerEnvio, bntFac, btnHacerEnvio, btnCargar, btnCerrarSesion;
	private JTextField campoAlto, campoAncho, campoLargo, campoPeso;
	private JLabel txtBienvedida, txtCrearPre, txtDesde, txtHasta, txtAlto, txtAncho, txtLargo, txtPeso, txtSeparador;

	
	public VentanaInicio() {
		
		pNorte = new JPanel(new GridLayout(1,3));
		pCentro = new JPanel(new GridLayout(3,4));
		pSur = new JPanel();
		pEsteArriba = new JPanel(new GridLayout(3,2));
		pEsteAbajo = new JPanel(new GridLayout(2,4));
		pOeste = new JPanel(new GridLayout(3,2));
		
		txtBienvedida = new JLabel("Bienvenid@!");
		txtCrearPre = new JLabel("Crear Presupuesto:");
		txtDesde = new JLabel("desde");
		txtHasta = new JLabel("hasta");
		txtAlto = new JLabel("Alto");
		txtAncho = new JLabel("Ancho");
		txtLargo = new JLabel("Largo");
		txtPeso = new JLabel("Peso");
		txtSeparador = new JLabel("|\n|");
		
		
		btnVerEnvio = new JButton("VER ENVÍOS");
		bntFac = new JButton("FACTURACION");
		btnHacerEnvio = new JButton("HACER ENVÍO");
		btnCargar = new JButton("CARGAR");
		btnCerrarSesion = new JButton("CERRAR SESIÓN");
		
		campoAlto = new JTextField();
		campoAncho = new JTextField();
		campoLargo = new JTextField();
		campoPeso = new JTextField();
		
		
		pCentro.add(txtSeparador);
		pNorte.add(txtBienvedida);
		pNorte.add(btnCerrarSesion);
		
		add(pCentro, BorderLayout.CENTER);
		add(pNorte, BorderLayout.NORTH);

		
		setTitle("Pantalla inicio");
		setBounds(300, 200, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		
		//VentanaInicioSesion ventanaIS = new VentanaInicioSesion();
		//VentanaRegistro ventanaReg = new VentanaRegistro();
		//VentanaModificarDatos ventanaMD = new VentanaModificarDatos();
		
		VentanaInicio a = new VentanaInicio();
		
	}

}
