package ventanas;


import java.awt.BorderLayout;
import java.awt.GridLayout;

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
					txtDesde, txtA, txtNom, txtDir, txtTel, txtCorreo, 
					txtEmbalado, txtLargo, txtAncho, txtAlto, txtPeso, txtKg, txtValor, txtEur,
					txtFEnvio, txtRecog, txtCasoRecog, txtEntrega,
					txtQueEnvia, txtDescrip, txtTarj, txtFTarj, txtCVV, txtDni,
					txtEnDesde, txtEnHasta, txtInfo, txtPago, txtEnvios;
	
	private JTextField	campoNom, campoDir, campoTel, campoCorreo, 
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
					pDonde, pDesde, pA, pCamposDesde, pCamposA,
					pQue, 
					pComo, 
					pPago, 
					pRev;
	
	
	
	
	
	public VentanaHacerEnvio() {
	
		tabEnvios = new JTabbedPane();
		
		txtCrearEnvio = new JLabel("CREAR ENVÍO:");
		
		btnVolver = new JButton("<-");
		
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
		
		campoNom = new JTextField(20);
		campoDir = new JTextField(20);
		campoTel = new JTextField(20);
		campoCorreo = new JTextField(20);
		
		btnAnt = new JButton("<-");
		btnSig = new JButton("->");
		
		pDesde = new JPanel();
		pA = new JPanel();
		pCamposDesde = new JPanel();
		pCamposA = new JPanel();
		
		pCamposDesde.add(txtDesde);
		
		pCamposDesde.add(txtNom);
		pCamposDesde.add(campoNom);
		pCamposDesde.add(txtDir);
		pCamposDesde.add(campoDir);
		pCamposDesde.add(txtCorreo);
		pCamposDesde.add(campoCorreo);
		pCamposDesde.add(txtTel);
		pCamposDesde.add(campoTel);
		
		pCamposA.add(txtA);
		
		pCamposA.add(txtNom);
		pCamposA.add(campoNom);
		pCamposA.add(txtDir);
		pCamposA.add(campoDir);
		pCamposA.add(txtCorreo);
		pCamposA.add(campoCorreo);
		pCamposA.add(txtTel);
		pCamposA.add(campoTel);
		
		
		//pCentro.add(pCamposDesde, BorderLayout.WEST);
		//pCentro.add(pCamposA, BorderLayout.EAST);
		//add(pCentro);

		
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
//		pNorte3.add(LOGO);
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
