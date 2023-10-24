package ventanas;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
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
					txtEmbalado, txtLargo, txtAncho, txtAlto, txtPeso, txtKg, txtValor, txtEur, tctInfo,
					txtFEnvio, txtRecog, txtCasoRecog, txtEntrega,
					txtQueEnvia, txtDescrip, txtTarj, txtFTarj, txtCVV, txtDni,
					txtEnDesde, txtEnHasta, txtInfo, txtPago, txtEnvios;
	
	private JTextField	campoNom, campoDir, campoTel, campoCorreo, campoNomA, campoDirA, campoTelA, campoCorreoA, 
						campoFenvio,
						campoLargo, campoAncho, campoAlto, campoValor, campoPeso,
						campoDescrip, campoTarj, campoFTarj, campoCVV, campoDni,
						campoEnDesde, campoEnHasta, campoPago;
	
	private JButton btnVolver;
	
	private JCheckBox checkTerminos, checkFactura;
	
	private JComboBox<String> comboEmbalaje,
								comboRecog;
	
	private JRadioButton radFragil, 
							radPtoRecog, radUsoDir,radEstandar, radSuper, radPremium,
							radTarj, radContrareembolso, radFacRemit, radFacDestinat;
	
	private JPanel pNorte, pNorte2, pNorte3,
					pCentro, 
					pDonde, ptxtDesde, ptxtA, pCamposDesde, pCamposA, pA, pDesde, pBtn,
					pQue, pAltLarAnc, pPeso, pEmbalaje, pValor, pBtn2, pNQue, pSQue, pCQue,
					pComo, pFEnvio, pRecog, pEntrega, pRecYEnt, pEntrega2, pRecog2,
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
	
		
		ptxtDesde = new JPanel();
		ptxtA = new JPanel();
		pCamposDesde = new JPanel(new GridLayout(4,2));
		pCamposA = new JPanel(new GridLayout(4,2));
		pA = new JPanel();
		pDesde = new JPanel();

		
		ptxtDesde.add(txtDesde, BorderLayout.NORTH);
		
		pCamposDesde.add(txtNom);
		pCamposDesde.add(campoNom);
		pCamposDesde.add(txtDir);
		pCamposDesde.add(campoDir);
		pCamposDesde.add(txtCorreo);
		pCamposDesde.add(campoCorreo);
		pCamposDesde.add(txtTel);
		pCamposDesde.add(campoTel);
		
		ptxtA.add(txtA, BorderLayout.NORTH);
		
		pCamposA.add(txtNomA);
		pCamposA.add(campoNomA);
		pCamposA.add(txtDirA);
		pCamposA.add(campoDirA);
		pCamposA.add(txtCorreoA);
		pCamposA.add(campoCorreoA);
		pCamposA.add(txtTelA);
		pCamposA.add(campoTelA);
		
		
		pDesde.add(ptxtDesde, BorderLayout.NORTH);
		pDesde.add(pCamposDesde, BorderLayout.SOUTH);
		pA.add(ptxtA, BorderLayout.NORTH);
		pA.add(pCamposA, BorderLayout.SOUTH);
		
		pDonde.add(pDesde);
		pDonde.add(pA);
		
		add(pDonde);
		
		//TAB QUE
		
		txtEmbalado = new JLabel("Embalaje:");
		txtLargo = new JLabel("Largo:");
		txtAncho = new JLabel("Alto:");
		txtAlto = new JLabel("Ancho:");
		txtPeso = new JLabel("Peso:");
		txtKg = new JLabel("kg");
		txtValor = new JLabel("Valor del paquete:");
		txtEur = new JLabel("EUR");
		txtInfo = new JLabel("El nº de referencia se asigna automáticamente.");
		
		campoLargo = new JTextField(10);
		campoAncho = new JTextField(10);
		campoAlto = new JTextField(10);
		campoValor = new JTextField(10);
		campoPeso = new JTextField(10);
		
		radFragil = new JRadioButton("¿Frágil?");
		
		comboEmbalaje = new JComboBox<String>();
		
		pEmbalaje = new JPanel(new GridLayout(1,2));
		pAltLarAnc = new JPanel();
		pPeso = new JPanel();
		pValor = new JPanel();
		pNQue = new JPanel();
		pSQue = new JPanel();
		pCQue = new JPanel();
		
		pEmbalaje.add(txtEmbalado);
		pEmbalaje.add(comboEmbalaje);
		
		pAltLarAnc.add(txtLargo);
		pAltLarAnc.add(campoLargo);
		pAltLarAnc.add(txtAlto);
		pAltLarAnc.add(campoAlto);
		pAltLarAnc.add(txtAncho);
		pAltLarAnc.add(campoAncho);
		
		pValor.add(txtValor);
		pValor.add(campoValor);
		pValor.add(txtEur);
		
		pPeso.add(txtPeso);
		pPeso.add(campoPeso);
		pPeso.add(txtKg);
		
		
		pNQue.add(pEmbalaje);
		pNQue.add(pPeso);
		pCQue.add(pValor);
		pCQue.add(radFragil);
		pQue.add(pNQue);
		pQue.add(pAltLarAnc);
		pQue.add(pCQue);
		pQue.add(txtInfo);
		
		add(pQue);
			
		
		//TAB COMO
		
		
		txtFEnvio = new JLabel("Fecha de envío:");
		txtRecog = new JLabel("Recogida:");
		txtCasoRecog = new JLabel("(En caso de ir a recoger el \n paquete a domicilio.)");
		txtEntrega = new JLabel("¿Cuando se entrega?");
		
		campoFenvio = new JTextField(10);
		
		radPtoRecog = new JRadioButton("Punto de recogida");
		radUsoDir = new JRadioButton("Usar mi direccion");
		radEstandar = new JRadioButton("Estandar");
		radSuper = new JRadioButton("Superior");
		radPremium = new JRadioButton("Premium");
		
		comboRecog = new JComboBox<String>();
		
		pFEnvio = new JPanel();
		pRecog = new JPanel();
		pEntrega = new JPanel();
		pRecYEnt = new JPanel();
		pEntrega2 = new JPanel(new GridLayout(3,1));
		pRecog2 = new JPanel(new GridLayout(3,1));
		
		pFEnvio.add(txtFEnvio);
		pFEnvio.add(campoFenvio);
		pFEnvio.add(txtCasoRecog);
		
		pRecog2.add(radPtoRecog);
		pRecog2.add(comboRecog);
		pRecog2.add(radUsoDir);
		

		pEntrega2.add(radEstandar);
		pEntrega2.add(radSuper);
		pEntrega2.add(radPremium);

		pEntrega.add(txtEntrega);
		pEntrega.add(pEntrega2);
		
		pRecog.add(txtRecog);
		pRecog.add(pRecog2);
		
		pRecYEnt.add(pRecog);
		pRecYEnt.add(pEntrega);
		
		pComo.add(pFEnvio);
		pComo.add(pRecYEnt);

		add(pComo);
		
		
		//TAB PAGO
		
		
		
		//TAB REVISION
		
		tabEnvios.addTab("DONDE", pDonde);
		tabEnvios.addTab("QUE", pQue);
		tabEnvios.addTab("COMO", pComo);
		tabEnvios.addTab("PAGO", pPago);
		tabEnvios.addTab("REVISIÓN", pRev);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		
		pNorte2.add(btnVolver);
		pNorte2.add(txtCrearEnvio);
		pNorte3.add(labelImagenLogo);
		pNorte.add(pNorte2);
		pNorte.add(pNorte3);
		add(pNorte, BorderLayout.NORTH);
		add(tabEnvios, BorderLayout.CENTER);
		
		
	
		
		setTitle("Hacer envío");
		setBounds(300, 200, 800, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
