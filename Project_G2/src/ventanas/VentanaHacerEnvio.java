package ventanas;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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
					txtEmbalado, txtLargo, txtAncho, txtAlto, txtPeso, txtKg, txtValor, txtEur, txtInfo,
					txtFEnvio, txtRecog, txtCasoRecog, txtEntrega,
					txtQueEnvia, txtDescrip, txtTarj, txtFTarj, txtCVV, txtDni,
					txtEnDesde, txtEnHasta, txtInfo2, txtPago, txtEnvios, txtRevPeso, txtRevLargo, txtRevAncho, txtRevAlto, txtRevKg;
	
	private JTextField	campoNom, campoDir, campoTel, campoCorreo, campoNomA, campoDirA, campoTelA, campoCorreoA, 
						campoFenvio,
						campoLargo, campoAncho, campoAlto, campoValor, campoPeso,
						campoDescrip, campoTarj, campoFTarj, campoCVV, campoDni,
						campoEnDesde, campoEnHasta, campoPago, campoRevLargo, campoRevAncho, campoRevAlto, campoRevPeso, campoEnvios;
	
	private JButton btnVolver;
	
	private JCheckBox checkTerminos, checkFactura;
	
	private JComboBox<String> comboEmbalaje,
								comboRecog;
	
	private JRadioButton radFragil, 
							radPtoRecog, radUsoDir,radEstandar, radSuper, radPremium,
							radTarj, radContrareembolso, radFacRemit, radFacDestinat;
	
	private JPanel pNorte, pNorte2, pNorte3,
					pCentro, 
					pDonde, ptxtDesde, ptxtA, pCamposDesde, pCamposA, pA, pDesde,
					pQue, pAltLarAnc, pPeso, pEmbalaje, pValor, pNQue, pCQue,
					pComo, pFEnvio, pRecog, pEntrega, pRecYEnt, pEntrega2, pRecog2,
					pPago, pEnvio, pTarj, pContra, pRmtYDest, pTarj1, pTarj2, pFactura1, pFactura2,
					pRev, pRevEnvio, pInfo, pAltPesLrAn, pEnYPg;
	
	private ButtonGroup tipoEnvioGrupo, recogidaGrupo, pagoGrupo, facturaGrupo;
	
	
	
	
	
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
		
		tipoEnvioGrupo = new ButtonGroup();
		recogidaGrupo = new ButtonGroup();
		
		pFEnvio = new JPanel();
		pRecog = new JPanel();
		pEntrega = new JPanel();
		pRecYEnt = new JPanel();
		pEntrega2 = new JPanel(new GridLayout(3,1));
		pRecog2 = new JPanel(new GridLayout(3,1));
		
		recogidaGrupo.add(radPtoRecog);
		recogidaGrupo.add(radUsoDir);
		
		tipoEnvioGrupo.add(radEstandar);
		tipoEnvioGrupo.add(radPremium);
		tipoEnvioGrupo.add(radSuper);
		
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
		
		
		txtQueEnvia = new JLabel("¿Que estás enviando?");
		txtDescrip = new JLabel("(Descripción breve)");
		txtTarj = new JLabel("Nº tarjeta:");
		txtFTarj = new JLabel("Fecha de caducidad:");
		txtCVV = new JLabel("CVV:");
		txtDni = new JLabel("DNI:");
		
		campoDescrip = new JTextField(30);
		campoTarj = new JTextField(10);
		campoFTarj = new JTextField(5);
		campoCVV = new JTextField(5);
		campoDni = new JTextField(10);
		
		checkFactura = new JCheckBox("¿Factura?");
		
		radTarj = new JRadioButton("Tarjeta");
		radContrareembolso = new JRadioButton("Contrareembolso");
		radFacRemit = new JRadioButton("Remitente");
		radFacDestinat = new JRadioButton("Destinatario");
		
		pagoGrupo = new ButtonGroup();
		facturaGrupo = new ButtonGroup();
		
		pRmtYDest = new JPanel(new GridLayout(2,1));
		pContra = new JPanel();
		pTarj = new JPanel();
		pEnvio = new JPanel();
		pTarj1 = new JPanel();
		pTarj2 = new JPanel();
		pFactura1 = new JPanel();
		pFactura2 = new JPanel();

		pagoGrupo.add(radTarj);
		pagoGrupo.add(radContrareembolso);
		
		facturaGrupo.add(radFacRemit);
		facturaGrupo.add(radFacDestinat);
		
		pTarj1.add(txtTarj);
		pTarj1.add(campoTarj);
		
		pTarj2.add(txtFTarj);
		pTarj2.add(campoFTarj);
		pTarj2.add(txtCVV);
		pTarj2.add(campoCVV);
		
		pTarj.add(radTarj);
		pTarj.add(pTarj1);
		pTarj.add(pTarj2);
		
		pRmtYDest.add(radFacRemit);
		pRmtYDest.add(radFacDestinat);
		
		pFactura1.add(checkFactura);
		pFactura1.add(pRmtYDest);
		
		pFactura2.add(txtDni);
		pFactura2.add(campoDni);
		
		pContra.add(radContrareembolso);
		pContra.add(pFactura1);
		pContra.add(pFactura2);
		 
		pEnvio.add(txtQueEnvia);
		pEnvio.add(campoDescrip);
		pEnvio.add(txtDescrip);
		 
		pPago.add(pEnvio);
		pPago.add(pTarj);
		pPago.add(pContra);
		 
		add(pPago);
		 
		 
		//TAB REVISION
		 
		 
		txtEnDesde = new JLabel("Enviar desde:");
		txtEnHasta = new JLabel("Hasta:");
		txtInfo2 = new JLabel("Info:");
		txtPago = new JLabel("Pago:");
		txtEnvios = new JLabel("Tipo Envios:");
		txtRevPeso = new JLabel("Peso:");
		txtRevLargo = new JLabel("Largo:");
		txtRevAncho = new JLabel("Ancho:");
		txtRevAlto = new JLabel("Alto:");
		txtRevKg = new JLabel("kg");
		 
		campoEnDesde = new JTextField(10);
		campoEnHasta = new JTextField(10);
		campoPago = new JTextField(8);
		campoRevLargo = new JTextField(5);
		campoRevAncho = new JTextField(5);
		campoRevAlto = new JTextField(5);
		campoRevPeso = new JTextField(5);
		campoEnvios = new JTextField(10);
	 
		checkTerminos = new JCheckBox("<html><u>Aceptas terminos y condiciones de uso</u></html>");
		
		
		pRevEnvio = new JPanel(new GridLayout(2,4));
		pInfo = new JPanel();
		pAltPesLrAn = new JPanel(new GridLayout(4,2));
		pEnYPg = new JPanel(new GridLayout(2,2));
		 
		 
		 pRevEnvio.add(txtEnDesde);
		 pRevEnvio.add(campoEnDesde);
		 pRevEnvio.add(txtEnHasta);
		 pRevEnvio.add(campoEnHasta);
		 
		 pAltPesLrAn.add(txtRevPeso);
		 pAltPesLrAn.add(campoRevPeso);
		 pAltPesLrAn.add(txtRevAlto);
		 pAltPesLrAn.add(campoRevAlto);
		 pAltPesLrAn.add(txtRevAncho);
		 pAltPesLrAn.add(campoRevAncho);
		 pAltPesLrAn.add(txtRevLargo);
		 pAltPesLrAn.add(campoRevLargo);

		 pEnYPg.add(txtEnvios);
		 pEnYPg.add(campoEnvios);
		 pEnYPg.add(txtPago);
		 pEnYPg.add(campoPago);
		 
		 pRev.add(pRevEnvio);
		 pRev.add(pEnYPg);
		 pRev.add(pAltPesLrAn);
		 pRev.add(checkTerminos);
		 
		 add(pRev);
		 
		 	 
		
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
		
//EVENTOS
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio VI = new VentanaInicio();
				dispose();			
			}
		});
		
		setTitle("Hacer envío");
		setBounds(300, 200, 800, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
