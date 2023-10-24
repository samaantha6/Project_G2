package ventanas;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class VentanaHacerEnvio extends JFrame {
	
	
	private JTabbedPane tabEnvios;
	
	private JLabel txtCrearEnvio,  
					txtDesde, txtA, txtNom, txtDir, txtTel, txtCorreo, txtNomA, txtDirA, txtTelA, txtCorreoA,
					txtEmbalado, txtLargo, txtAncho, txtAlto, txtPeso, txtKg, txtValor, txtEur,
					txtFEnvio, txtRecog, txtCasoRecog, txtEntrega,
					txtQueEnvia, txtDescrip, txtTarj, txtFTarj, txtCVV, txtDni,
					txtEnDesde, txtEnHasta, txtInfo, txtPago, txtEnvios;
	
	private JTextField	campoNom, campoDir, campoTel, campoCorreo, campoNomA, campoDirA, campoTelA, campoCorreoA, 
						campoLargo, campoAncho, campoAlto, campoValor,
						campoDescrip, campoTarj, campoFTarj, campoCVV, campoDni,
						campoEnDesde, campoEnHasta, campoPago;
	
	private JButton btnAnt, btnSig, btnVolver;
	
	private JCheckBox checkTerminos, checkFactura;
	
	private JRadioButton radFragil, 
							radPtoRecog, radUsoDir,radEstandar, radSuper, radPremium,
							radTarj, radContrareembolso, radFacRemit, radFacDestinat;
	
	private JPanel pNorte, pNorte2, pNorte3,
					pCentro, 
					pDonde, ptxtDesde, ptxtA, pCamposDesde, pCamposA, pA, pDesde,
					pQue, 
					pComo, 
					pPago, 
					pRev;
	
	
	
	
	
	public VentanaHacerEnvio() {
	
		tabEnvios = new JTabbedPane();
		
		txtCrearEnvio = new JLabel("CREAR ENVÍO:");
		
		btnVolver = new JButton("<-");
		
		pDonde = new JPanel();
		pQue = new JPanel();
		pComo = new JPanel();
		pPago = new JPanel();
		pRev = new JPanel();
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		
		pNorte = new JPanel(new GridLayout(1,2));
		pNorte2 = new JPanel();
		pNorte3 = new JPanel();


		//TAB DONDE
		
		txtA = new JLabel("A");
		txtDesde = new JLabel("DESDE");
			
		txtNom = new JLabel("Nombre:");
		txtDir = new JLabel("Dirección");
		txtTel = new JLabel("Teléfono:");
		txtCorreo = new JLabel("Correo:");
		
		txtNomA = new JLabel("Nombre:");
		txtDirA = new JLabel("Dirección");
		txtTelA = new JLabel("Teléfono:");
		txtCorreoA = new JLabel("Correo:");
		
		campoNom = new JTextField(20);
		campoDir = new JTextField(20);
		campoTel = new JTextField(20);
		campoCorreo = new JTextField(20);
		
		campoNomA = new JTextField(20);
		campoDirA = new JTextField(20);
		campoTelA = new JTextField(20);
		campoCorreoA = new JTextField(20);
		
		btnAnt = new JButton("<-");
		btnSig = new JButton("->");
		
		ptxtDesde = new JPanel();
		ptxtA = new JPanel();
		pCamposDesde = new JPanel(new GridLayout(4,2));
		pCamposA = new JPanel(new GridLayout(4,2));
		pA = new JPanel();
		pDesde = new JPanel();
		
		ptxtDesde.add(txtDesde);
		
		pCamposDesde.add(txtNom);
		pCamposDesde.add(campoNom);
		pCamposDesde.add(txtDir);
		pCamposDesde.add(campoDir);
		pCamposDesde.add(txtCorreo);
		pCamposDesde.add(campoCorreo);
		pCamposDesde.add(txtTel);
		pCamposDesde.add(campoTel);
		
		ptxtA.add(txtA);
		
		pCamposA.add(txtNomA);
		pCamposA.add(campoNomA);
		pCamposA.add(txtDirA);
		pCamposA.add(campoDirA);
		pCamposA.add(txtCorreoA);
		pCamposA.add(campoCorreoA);
		pCamposA.add(txtTelA);
		pCamposA.add(campoTelA);
		
		pDesde.add(ptxtDesde, BorderLayout.NORTH);
		pDesde.add(pCamposDesde, BorderLayout.CENTER);
		pA.add(ptxtA, BorderLayout.NORTH);
		pA.add(pCamposA, BorderLayout.CENTER);
		
		pDonde.add(pDesde, BorderLayout.WEST);
		pDonde.add(pA, BorderLayout.EAST);
		
		add(pDonde);
		
		//TAB QUE
		
		//TAB COMO
		
		//TAB PAGO
		
		//TAB REVISION
		
//		tabEnvios.addTab("DONDE", radio);
//		tabEnvios.addTab("QUE", );
//		tabEnvios.addTab("COMO", a);
//		tabEnvios.addTab("PAGO", a);
//		tabEnvios.addTab("REVISIÓN", a);
		
		
		pNorte2.add(btnVolver);
		pNorte2.add(txtCrearEnvio);
		pNorte3.add(labelImagenLogo);
		pNorte.add(pNorte2);
		pNorte.add(pNorte3);
		add(pNorte, BorderLayout.NORTH);
//		add(tabEnvios);
	
		
		setTitle("Hacer envío");
		setBounds(300, 200, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
