package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import domain.Envio;
import domain.Pago;
import domain.Paquete;
import domain.Recogida;
import domain.Trayecto;
import domain.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class VentanaHacerEnvio extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JTabbedPane tabEnvios;
	
	private JLabel txtCrearEnvio,  
					txtDesde, txtHasta, txtNom, txtDir, txtTel, txtCorreo, txtNomHasta, txtDirHasta, txtTelHasta, txtCorreoHasta,
					txtEmbalado, txtLargo, txtAncho, txtAlto, txtPeso, txtKg, txtValor, txtEur, txtInfo,
					txtFEnvio, txtRecog, txtCasoRecog, txtEntrega, aceptarCond,
					txtQueEnvia, txtDescrip, txtTarj, txtFTarj, txtCVV, txtDni,
					txtEnDesde, txtEnHasta, txtPago, txtEnvios, txtRevPeso, txtRevLargo, txtRevAncho, txtRevAlto, txtRevKg, txtInfo2;
	
	private JTextField	campoNom, campoDir, campoTel, campoCorreo, campoNomHasta, campoDirHasta, campoTelHasta, campoCorreoHasta, 
						campoFenvio,
						campoLargo, campoAncho, campoAlto, campoValor, campoPeso,
						campoDescrip, campoTarj, campoFTarj, campoCVV, campoDni,
						campoEnDesde, campoEnHasta, campoPago, campoRevLargo, campoRevAncho, campoRevAlto, campoRevPeso, campoEnvios;
	
	private JButton btnVolver, btnAnterior, btnSiguiente, btnFinalizar;
    
    private int indiceActual = 0;
	
	private JCheckBox checkTerminos, checkFactura, checkFragil;
	
	private  JTextArea textTYC;
	private JScrollPane scrollTYC;
	
	private JComboBox<String> comboEmbalaje,
								comboRecog;
	
	private JRadioButton 	radPtoRecog, radUsoDir,radEstandar, radSuper, radPremium,
							radTarj, radContrareembolso, radFacRemit, radFacDestinat;
	
	private JPanel pNorte, pNorte2, pNorte3,
					pCentro, pSur, pBtnAnterior, pBtnSiguiente, pBtnFinalizar, 
					pDonde, ptxtDesde, ptxtHasta, pCamposDesde, pCamposHasta, pHasta, pDesde,
					pQue, pAltLarAnc, pPeso, pEmbalaje, pValor, pNQue, pCQue,
					pComo, pFEnvio, pRecog, pEntrega, pRecYEnt, pEntrega2, pRecog2,
					pPago, pEnvio, pTarj, pFact, pTarjYContra, pFact2, pCamposTarjYCon, pDescrip, 
					pRev, pRevEnvio, pInfo, pAltPesLrAn, pEnYPg, pTYC;
	
	private ButtonGroup tipoEnvioGrupo, recogidaGrupo, pagoGrupo, facturaGrupo;
	
	private Pago pago;
	
	private double precioFinal;
	
    private List<Usuario> usuarios = new ArrayList<>();
    
    private Usuario usuario;
    
	private Thread hilo;
	private boolean hiloEjecutando;
	
	private DecimalFormat formato = new DecimalFormat("#.##");
    
	private WindowMaster windowMaster = new WindowMaster();
	
    private HashMap<JTextField, Color> fondosOriginales = new HashMap<>();

    private String lugarDeRecogida, tipoDeEnvio, remitenteDestinatario, factura, tarjetaContrareembolso, textoTYC;
    
	private double precioBase;
	private JLabel campoPrecio;
	
	private JDateChooser dateChooser;
    
	private Logger logger = Logger.getLogger(VentanaHacerEnvio.class.getName());
	
	public VentanaHacerEnvio(List<Usuario> usuariosS, Usuario usuarioO) {
		
		usuario = usuarioO;
		usuarios = usuariosS;
		
		tabEnvios = new JTabbedPane();
        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");
		
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

		pSur = new JPanel(new GridLayout(1,2));
		pBtnAnterior = new JPanel();
		pBtnSiguiente = new JPanel();

/** TAB DONDE */
		
		txtHasta = new JLabel("HASTA");
		txtDesde = new JLabel("DESDE");
		logger.info("JLabels de tab 'DONDE' creados");
		
		txtNom = new JLabel("Nombre:");
		txtDir = new JLabel("Dirección:");
		txtTel = new JLabel("Teléfono:");
		txtCorreo = new JLabel("Correo:");
		logger.info("JLabels 2 de tab 'DONDE' creados");
		
		txtNomHasta = new JLabel("Nombre:");
		txtDirHasta = new JLabel("Dirección:");
		txtTelHasta = new JLabel("Teléfono:");
		txtCorreoHasta = new JLabel("Correo:");
		logger.info("JLabels 3 de tab 'DONDE' creados");
		
		campoNom = new JTextField(20);
		campoDir = new JTextField(20);
		campoTel = new JTextField(20);
		campoCorreo = new JTextField(20);
		logger.info("JTextFields de tab 'DONDE' creados");
		
		campoNomHasta = new JTextField(20);
		campoDirHasta = new JTextField(20);
		campoTelHasta = new JTextField(20);
		campoCorreoHasta = new JTextField(20);
		logger.info("JTextFields 2 de tab 'DONDE' creados");
	
		
		ptxtDesde = new JPanel();
		ptxtHasta = new JPanel();
		pCamposDesde = new JPanel(new GridLayout(4,2));
		pCamposHasta = new JPanel(new GridLayout(4,2));
		pHasta = new JPanel();
		pDesde = new JPanel();
		logger.info("JPanels de tab 'DONDE' creados");

		
		ptxtDesde.add(txtDesde, BorderLayout.NORTH);
		
		pCamposDesde.add(txtNom);
		pCamposDesde.add(campoNom);
		pCamposDesde.add(txtDir);
		pCamposDesde.add(campoDir);
		pCamposDesde.add(txtCorreo);
		pCamposDesde.add(campoCorreo);
		pCamposDesde.add(txtTel);
		pCamposDesde.add(campoTel);
		
		ptxtHasta.add(txtHasta, BorderLayout.NORTH);
		
		pCamposHasta.add(txtNomHasta);
		pCamposHasta.add(campoNomHasta);
		pCamposHasta.add(txtDirHasta);
		pCamposHasta.add(campoDirHasta);
		pCamposHasta.add(txtCorreoHasta);
		pCamposHasta.add(campoCorreoHasta);
		pCamposHasta.add(txtTelHasta);
		pCamposHasta.add(campoTelHasta);
		
		
		pDesde.add(ptxtDesde, BorderLayout.NORTH);
		pDesde.add(pCamposDesde, BorderLayout.SOUTH);
		pHasta.add(ptxtHasta, BorderLayout.NORTH);
		pHasta.add(pCamposHasta, BorderLayout.SOUTH);
		
		pDonde.add(pDesde);
		pDonde.add(pHasta);
		
		add(pDonde);
		
		
/** TAB QUE */
		
		txtEmbalado = new JLabel("Embalaje: ");
		txtLargo = new JLabel("Largo: ");
		txtAncho = new JLabel("Alto: ");
		txtAlto = new JLabel("Ancho: ");
		txtPeso = new JLabel("Peso: ");
		txtKg = new JLabel("kg");
		txtValor = new JLabel("Valor del paquete: ");
		txtEur = new JLabel("EUR");
		txtInfo = new JLabel("El nº de referencia se asigna automáticamente.");
		logger.info("JLabels de tab 'QUE' creados");
		
		campoLargo = new JTextField(10);
		campoAncho = new JTextField(10);
		campoAlto = new JTextField(10);
		campoValor = new JTextField(10);
		campoPeso = new JTextField(10);
		
		
		logger.info("JTextFields de tab 'QUE' creados");
		
		checkFragil = new JCheckBox("¿Frágil?");
		logger.info("JCheckBox de tab 'QUE' creado");
		
		comboEmbalaje = new JComboBox<String>();
		comboEmbalaje.addItem("Necesita embalaje");
		comboEmbalaje.addItem("No necesita embalaje");
		logger.info("JComboBox de tab 'QUE' creado");
		
		pEmbalaje = new JPanel(new GridLayout(1,2));
		pAltLarAnc = new JPanel();
		pPeso = new JPanel();
		pValor = new JPanel();
		pNQue = new JPanel();
		pCQue = new JPanel();
		logger.info("JPanels de tab 'QUE' creados");
		
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
		pCQue.add(checkFragil);
		pQue.add(pNQue);
		pQue.add(pAltLarAnc);
		pQue.add(pCQue);
		pQue.add(txtInfo);
		
		add(pQue);

		
/** TAB COMO */		
		
		txtFEnvio = new JLabel("Fecha de recogida:");
		txtRecog = new JLabel("Recogida:");
		txtCasoRecog = new JLabel("(En caso de ir a recoger el \n paquete a domicilio.)");
		txtEntrega = new JLabel("¿Cuando se entrega?");
		logger.info("JLabels de tab 'COMO' creados");
		
		campoFenvio = new JTextField(10);
		campoFenvio.setEditable(false);
		logger.info("JTextFields de tab 'COMO' creado");
		
		radPtoRecog = new JRadioButton("Punto de recogida");
		radUsoDir = new JRadioButton("Usar mi direccion");
		
		radEstandar = new JRadioButton("Estandar\n (En 8/12 dias)");
		radSuper = new JRadioButton("Superior\n (En 6/10 dias)");
		radPremium = new JRadioButton("Premium\n (En 2 dias)");
		logger.info("JRadioButton de tab 'COMO' creados");
		
		comboRecog = new JComboBox<String>();
		comboRecog.setEnabled(false);
		logger.info("JComboBox de tab 'COMO' creados");
		
		tipoEnvioGrupo = new ButtonGroup();
		recogidaGrupo = new ButtonGroup();
		logger.info("JButtons de tab 'COMO' creados");
		
		pFEnvio = new JPanel();
		pRecog = new JPanel();
		pEntrega = new JPanel();
		pRecYEnt = new JPanel();
		pEntrega2 = new JPanel(new GridLayout(3,1));
		pRecog2 = new JPanel(new GridLayout(3,1));
		logger.info("JPanels de tab 'COMO' creados");
		
		campoPrecio = new JLabel();
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		recogidaGrupo.add(radPtoRecog);
		recogidaGrupo.add(radUsoDir);
		
		tipoEnvioGrupo.add(radEstandar);
		tipoEnvioGrupo.add(radPremium);
		tipoEnvioGrupo.add(radSuper);
		
		pFEnvio.add(txtFEnvio);
		pFEnvio.add(dateChooser);
		pFEnvio.add(txtCasoRecog);
		
		pRecog2.add(radPtoRecog);
		pRecog2.add(comboRecog);
		pRecog2.add(radUsoDir);
		

		pEntrega2.add(radEstandar);
		pEntrega2.add(radSuper);
		pEntrega2.add(radPremium);

		pEntrega.add(txtEntrega);
		pEntrega.add(pEntrega2);
		pEntrega.add(campoPrecio);
		
		
		pRecog.add(txtRecog);
		pRecog.add(pRecog2);
		
		pRecYEnt.add(pRecog);
		pRecYEnt.add(pEntrega);
		
		pComo.add(pFEnvio);
		pComo.add(pRecYEnt);

		add(pComo);
		
		
/** TAB PAGO */
		
		txtQueEnvia = new JLabel("¿Que estás enviando?");
		txtDescrip = new JLabel("(Descripción breve)");
		txtTarj = new JLabel("Nº tarjeta:");
		txtFTarj = new JLabel("Fecha de caducidad:");
		txtCVV = new JLabel("CVV:");
		txtDni = new JLabel("DNI:");
		logger.info("JLabels de tab 'PAGO' creados");
		
		campoDescrip = new JTextField(30);
		campoTarj = new JTextField(10);
		campoFTarj = new JTextField(5);
		campoCVV = new JTextField(5);
		campoDni = new JTextField(10);
		logger.info("JTextFields de tab 'PAGO' creados");
		
		checkFactura = new JCheckBox("¿Factura?");
		logger.info("JCheckBox de tab 'PAGO' creados");
		
		radTarj = new JRadioButton("Tarjeta");
		radContrareembolso = new JRadioButton("Contrareembolso");
		radFacRemit = new JRadioButton("Remitente");
		radFacDestinat = new JRadioButton("Destinatario");
		logger.info("JRadioButton de tab 'PAGO' creados");
		
		pagoGrupo = new ButtonGroup();
		facturaGrupo = new ButtonGroup();
		logger.info("ButtonGroup de tab 'PAGO' creados");
		
		pTarjYContra = new JPanel(new GridLayout(2,1));
		pFact = new JPanel();
		pTarj = new JPanel();
		pEnvio = new JPanel();
		pFact2 = new JPanel(new GridLayout(2,1));
		pCamposTarjYCon = new JPanel(new GridLayout(2,1));
		pDescrip = new JPanel();
		logger.info("JPanels de tab 'PAGO' creados");

		pFact2.add(radFacRemit);
		pFact2.add(radFacDestinat);
		
		pFact.add(checkFactura);
		pFact.add(pFact2);
		pFact.add(txtDni);
		pFact.add(campoDni);
		
		pTarj.add(txtTarj);
		pTarj.add(campoTarj);
		pTarj.add(txtFTarj);
		pTarj.add(campoFTarj);
		pTarj.add(txtCVV);
		pTarj.add(campoCVV);
		
		pTarjYContra.add(radTarj);
		pTarjYContra.add(radContrareembolso);

		pCamposTarjYCon.add(pTarj);
		pCamposTarjYCon.add(pFact);
		
		pEnvio.add(pTarjYContra);
		pEnvio.add(pCamposTarjYCon);
		
		pDescrip.add(txtQueEnvia);
		pDescrip.add(campoDescrip);
		pDescrip.add(txtDescrip);
		
		
		pPago.add(pDescrip);
		pPago.add(pEnvio);
		
		pagoGrupo.add(radTarj);
		pagoGrupo.add(radContrareembolso);
		
		facturaGrupo.add(radFacRemit);
		facturaGrupo.add(radFacDestinat);
		
		add(pPago);
		 
		 
/** TAB REVISION */
		 
		btnFinalizar = new JButton("Finalizar");
		 
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
		logger.info("JLabels de tab 'REVISION' creados");
		 
		campoEnDesde = new JTextField(10);
		campoEnHasta = new JTextField(10);
		campoPago = new JTextField(8);
		campoRevLargo = new JTextField(5);
		campoRevAncho = new JTextField(5);
		campoRevAlto = new JTextField(5);
		campoRevPeso = new JTextField(5);
		campoEnvios = new JTextField(10);
		
		campoEnDesde.setEditable(false);
		campoEnHasta.setEditable(false);
		campoPago.setEditable(false);
		campoRevLargo.setEditable(false);
		campoRevAncho.setEditable(false);
		campoRevAlto.setEditable(false);
		campoRevPeso.setEditable(false);
		campoEnvios.setEditable(false);
		
		logger.info("JTextFields de tab 'REVISION' creados");
	 
		checkTerminos = new JCheckBox();
		aceptarCond = new JLabel("<html><u>Aceptas terminos y condiciones de uso</u></html>");
		checkTerminos.setEnabled(false);
		logger.info("JCheckBox de tab 'REVISION' creado");
		
		
		pRevEnvio = new JPanel(new GridLayout(2,4));
		pInfo = new JPanel();
		pAltPesLrAn = new JPanel(new GridLayout(4,2));
		pEnYPg = new JPanel(new GridLayout(2,2));
		pBtnFinalizar = new JPanel();
		pTYC = new JPanel();
		logger.info("JPanel de tab 'REVISION' creados");
		 
		 
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
		 
		 pTYC.add(checkTerminos);
		 pTYC.add(aceptarCond);
		 
		 pBtnFinalizar.add(btnFinalizar);
		 
		 pRev.add(pRevEnvio);
		 pRev.add(pEnYPg);
		 pRev.add(pAltPesLrAn);
		 pRev.add(pTYC);
		 pRev.add(pBtnFinalizar);
		 
		 add(pRev);
		
		tabEnvios.addTab("DONDE", pDonde);
		tabEnvios.addTab("QUE", pQue);
		tabEnvios.addTab("COMO", pComo);
		tabEnvios.addTab("PAGO", pPago);
		tabEnvios.addTab("REVISIÓN", pRev);
		tabEnvios.setEnabled(false);
		
		ImageIcon logo = new ImageIcon(getClass().getResource("/Images/logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		
		pNorte2.add(btnVolver);
		pNorte2.add(txtCrearEnvio);
		pNorte3.add(labelImagenLogo);
		pNorte.add(pNorte2);
		pNorte.add(pNorte3);
		pBtnAnterior.add(btnAnterior);
		pBtnSiguiente.add(btnSiguiente);
		pSur.add(pBtnAnterior);
		pSur.add(pBtnSiguiente);
		add(pNorte, BorderLayout.NORTH);
		add(tabEnvios, BorderLayout.CENTER);
		add(pSur, BorderLayout.SOUTH);
		
/** EVENTOS */
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				hilo = new Thread() {

				public void run() {
					while(hiloEjecutando) {
						
					}
				}
				};
				hiloEjecutando = true;
				hilo.start();
			}
		});
		
		btnFinalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreOrigen = campoNom.getText();
				String direccionOrigen = campoDir.getText();
				String correoOrigen = campoTel.getText();
				String telefonoOrigen = campoCorreo.getText();
				String nombreDestino = campoNomHasta.getText();
				String direccionDestino = campoDirHasta.getText();
				String correoDestino = campoTelHasta.getText();
				String telefonoDestino = campoCorreoHasta.getText();
				
				String nReferencia = generarNumeroReferencia();
				String embalaje = comboEmbalaje.getSelectedItem().toString();
				String peso = campoPeso.getText();
				String largo = campoLargo.getText();
				String ancho = campoAncho.getText();
				String alto = campoAlto.getText();
				String valor = campoValor.getText();
                boolean seleccionado = checkFragil.isSelected();
                String fragil = seleccionado ? "Si" : "No";
                
                String fechaDeRecogida = campoFenvio.getText();
                if (radPtoRecog.isSelected()) {
                    lugarDeRecogida = comboRecog.getSelectedItem().toString();
                } else if (radUsoDir.isSelected()) {
                    lugarDeRecogida = direccionOrigen;
                } else {
                    lugarDeRecogida = "";
                }
                if (radEstandar.isSelected()) {
                	tipoDeEnvio = "Estandar";
                } else if (radPremium.isSelected()) {
                	tipoDeEnvio = "Premium";
                } else if (radSuper.isSelected()) {
                	tipoDeEnvio = "Super";
                } else {
                	tipoDeEnvio = "";
                }
                
                String descripcion = campoDescrip.getText();
                String numeroTrajeta = campoTarj.getText();
                String fechaCaducidad = campoFTarj.getText();
                String CVV = campoCVV.getText();
                if (radFacRemit.isSelected()) {
                	remitenteDestinatario = "Remitente";
                } else if (radFacDestinat.isSelected()) {
                	remitenteDestinatario = "Destinatario";
                } else {
                	remitenteDestinatario = "";
                }
                if (checkFactura.isSelected()) {
                	factura = "Si";
                } else {
                	factura = "No";
                }
                String DNI = campoDni.getText();
                if (radTarj.isSelected()) {
                	tarjetaContrareembolso = "Tarjeta";
                } else if (radContrareembolso.isSelected()) {
                	tarjetaContrareembolso = "Contrareembolso";
                } else {
                	tarjetaContrareembolso = "";
                }
				
				List<JTextField> camposVacios =  windowMaster.camposVacios(campoNom, campoDir, campoTel, campoCorreo, campoNomHasta, campoDirHasta, campoTelHasta, campoCorreoHasta);
				if (camposVacios.isEmpty()) {
					windowMaster.restaurarFondo(fondosOriginales);
					Trayecto trayecto = new Trayecto(nombreOrigen, direccionOrigen, correoOrigen, telefonoOrigen, nombreDestino, direccionDestino, correoDestino, telefonoDestino);
					camposVacios =  windowMaster.camposVacios(campoPeso, campoLargo, campoAncho, campoAlto, campoValor);
					if (camposVacios.isEmpty()) {
						windowMaster.restaurarFondo(fondosOriginales);
						Paquete paquete = new Paquete(nReferencia, embalaje, peso, largo, ancho, alto, valor, fragil);
						camposVacios =  windowMaster.camposVacios(campoFenvio);
						if (camposVacios.isEmpty() && lugarDeRecogida != "" && tipoDeEnvio != "") {
							windowMaster.restaurarFondo(fondosOriginales);
							radPtoRecog.setOpaque(false);
							radUsoDir.setOpaque(false);
							radEstandar.setOpaque(false);
							radPremium.setOpaque(false);
							radSuper.setOpaque(false);
							Recogida recogida = new Recogida(fechaDeRecogida, lugarDeRecogida, tipoDeEnvio);
							camposVacios =  windowMaster.camposVacios(campoDescrip, campoTarj, campoFTarj, campoCVV, campoDni);
							boolean dniValido = windowMaster.esNumero(campoDni, "DNI");
							if (camposVacios.isEmpty() && remitenteDestinatario != "" && tarjetaContrareembolso != "" && dniValido) {
								windowMaster.restaurarFondo(fondosOriginales);
								radFacRemit.setOpaque(false);
								radFacDestinat.setOpaque(false);
								radTarj.setOpaque(false);
								radContrareembolso.setOpaque(false);
								if (radTarj.isSelected()) {
									pago = new Pago(descripcion, numeroTrajeta, fechaCaducidad, CVV, remitenteDestinatario, factura, DNI);
								} else {
									pago = new Pago(descripcion, remitenteDestinatario, factura, DNI);
								}								
								campoEnDesde.setText(direccionOrigen);
								campoEnHasta.setText(direccionDestino);
								campoPago.setText(formato.format(precioFinal));
								campoRevLargo.setText(largo);
								campoRevAncho.setText(ancho);
								campoRevAlto.setText(alto);
								campoRevPeso.setText(peso);
								campoEnvios.setText(tipoDeEnvio);
								if (checkTerminos.isSelected()) {
						        	int seguro = JOptionPane.showOptionDialog(
						        			null,
						        			"¿Estas seguro que has rellenado todos los apartados de forma correcta?", "Aviso", 
						        			JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Aceptar", "Rechazar"}, "Aceptar");
						        	if (seguro == JOptionPane.OK_OPTION) {
						        		Envio envio = new Envio(trayecto, paquete, recogida, pago);
										SwingUtilities.invokeLater(() -> new VentanaInicio(usuarios,usuario));
										dispose();
						        	}
								} else {
                    				JOptionPane.showMessageDialog(null, "Desbes acceptar los terminos y condiciones.", "Error", JOptionPane.ERROR_MESSAGE);
								}
							} else if (dniValido == true) {
								fondosOriginales = windowMaster.cambiarFondoCampos(camposVacios);
								if (remitenteDestinatario == "") {
									radFacRemit.setBackground(Color.RED);
									radFacDestinat.setBackground(Color.RED);
								} else {
									radFacRemit.setOpaque(false);
									radFacDestinat.setOpaque(false);
								}
								if (tarjetaContrareembolso == "") {
									radTarj.setBackground(Color.RED);
									radContrareembolso.setBackground(Color.RED);
								} else {
									radTarj.setOpaque(false);
									radContrareembolso.setOpaque(false);
								}
								JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos del apartado 'Pago'.", "Error", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							fondosOriginales = windowMaster.cambiarFondoCampos(camposVacios);
							if (lugarDeRecogida == "") {
								radPtoRecog.setBackground(Color.RED);
								radUsoDir.setBackground(Color.RED);
							} else {
								radPtoRecog.setOpaque(false);
								radUsoDir.setOpaque(false);
							}
							if (tipoDeEnvio == "") {
								radEstandar.setBackground(Color.RED);
								radPremium.setBackground(Color.RED);
								radSuper.setBackground(Color.RED);
							} else {
								radEstandar.setOpaque(false);
								radPremium.setOpaque(false);
								radSuper.setOpaque(false);
							}
							JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos del apartado 'Como'.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						fondosOriginales = windowMaster.cambiarFondoCampos(camposVacios);
						JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos del apartado 'Que'.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					fondosOriginales = windowMaster.cambiarFondoCampos(camposVacios);
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos del apartado 'Donde'.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}});
		
        aceptarCond.addMouseListener(new MouseAdapter() {
			
				@Override
				public void mouseClicked(MouseEvent e) {
				
					textTYC = new JTextArea(textoTYC);

			        	scrollTYC = new JScrollPane(textTYC);
			        	scrollTYC.setPreferredSize(new Dimension(400, 300));

			        	int option = JOptionPane.showOptionDialog(
			        			null,
			        			scrollTYC,
			        			"Términos y Condiciones",
			        			JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Aceptar", "Rechazar"}, "Aceptar");

			        	if (option == JOptionPane.OK_OPTION) {
			        		checkTerminos.setSelected(true);
			        	} else {
			        		checkTerminos.setSelected(false);
			        	}
				}
			});
		
		btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPestana(-1);
            }
        });

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPestana(1);
                
                int pestañaActual = tabEnvios.getSelectedIndex();
                
                if (pestañaActual == 2) {
                	String altoPrecio1 = campoAlto.getText();
            		String anchoPrecio1 = campoAncho.getText();
            		String largoPrecio1 = campoLargo.getText();
            		if (!altoPrecio1.isEmpty() && !anchoPrecio1.isEmpty() && !largoPrecio1.isEmpty()) {
            			try {
            				int altoPrecio = Integer.parseInt(altoPrecio1);
            				int anchoPrecio = Integer.parseInt(anchoPrecio1);
            				int largoPrecio = Integer.parseInt(largoPrecio1);
            				
            				precioBase = (PrecioBaseAlto(altoPrecio) + PrecioBaseAncho(anchoPrecio) + PrecioBaseLargo(largoPrecio))/2;

            				System.out.println(precioBase);
            			} catch (Exception e2) {
            				JOptionPane.showMessageDialog(null, "Introduzca un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            				cambiarPestana(-1);
            			}

            		} else {
            			JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            			cambiarPestana(-1);
            			
            		}
            		
				} else {
					
				}
                
                

        		/*para meter las direcciones en el JCombobox*/
        		String ruta = "resources//provincias_direcciones.txt";
        		try {
                    File provYDir = new File(ruta);
                    FileReader fr = new FileReader(provYDir);
                    BufferedReader br = new BufferedReader(fr);

                    String linea;
                    while ((linea = br.readLine()) != null) {

                    	Scanner sc = new Scanner(linea);
                        sc.useDelimiter(";");
                        
                        String provincia = sc.next();
                        String establecimiento = sc.next();
                        
                        

                        if (pestañaActual == 2) {
                        	
                        	if (campoDirHasta.getText().contains(provincia)) {
                        		comboRecog.addItem(establecimiento);
                        	} else {
                        		
                        	}
                        		
                        } else {
                        	comboRecog.removeAllItems();
                        }
                    }

                    br.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> new VentanaInicio(usuarios,usuario));
				dispose();			
			}
		});
		
		radPtoRecog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboRecog.setEnabled(true);
			}
		});
		
		
		radUsoDir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboRecog.setEnabled(false);
			}
		});
		
		radContrareembolso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				campoTarj.setText("");
				campoFTarj.setText("");
				campoCVV.setText("");
				campoTarj.setEditable(false);
				campoFTarj.setEditable(false);
				campoCVV.setEditable(false);
			}
		});
		
		radEstandar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					precioFinal = precioBase;
					precioFinal += 2.99;
		            campoPrecio.setText(precioFinal + "€");
		            
				} catch (NumberFormatException e2) {
					campoPrecio.setText("Error");
				}
			}
		});
		
		radSuper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					precioFinal = precioBase;			    			    				    	
					precioFinal += 3.99;
		            campoPrecio.setText(precioFinal + "€");
		            
				} catch (NumberFormatException e2) {
					campoPrecio.setText("Error");
				}
			}
		});
		
		radPremium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					precioFinal = precioBase;
					precioFinal += 7.99;
		            campoPrecio.setText(precioFinal + "€");
		            
				} catch (NumberFormatException e2) {
					campoPrecio.setText("Error");}
			}
		});
		
		dateChooser.getDateEditor().setEnabled(false);
		dateChooser.getDateEditor().addPropertyChangeListener(e -> {
            if ("date".equals(e.getPropertyName())) {
                Date date = dateChooser.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                if (date != null && date.before(new Date())) {
                    JOptionPane.showMessageDialog(null, "La fecha seleccionada es anterior a la actual", "Error", JOptionPane.ERROR_MESSAGE);
                    campoFenvio.setText(sdf.format(date));
                    
                } else {
                    campoFenvio.setText(sdf.format(date));
                }
            }
        });
		
		

		

		
		
		
		setTitle("Hacer envío");
		setBounds(300, 200, 800, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		textoTYC = new String("Aceptación de Términos y Condiciones de uso:\r\n"
				+ "\r\n"
				+ "Al utilizar nuestro sistema, el usuario acepta estos términos y condiciones y se compromete a cumplir con ellos. Estos términos pueden ser modificados en cualquier momento, y el usuario se compromete a revisarlos regularmente para estar al tanto de cualquier cambio.\r\n"
				+ "\r\n"
				+ "Los usuarios pueden necesitar registrarse para utilizar ciertas funciones del sistema. La información proporcionada durante el registro debe ser precisa y completa.\r\n"
				+ "Los usuarios son responsables de mantener la confidencialidad de sus credenciales de inicio de sesión y notificar a Hermes de cualquier uso no autorizado de su cuenta.\r\n"
				+ "\r\n"
				+ "Los usuarios se comprometen a utilizar el sistema de manera adecuada y legal, sin infringir derechos de terceros.\r\n"
				+ "No se permite el uso del sistema para actividades ilegales o fraudulentas.\r\n"
				+ "\r\n"
				+ "Los usuarios son responsables de la exactitud de la información proporcionada al sistema, incluyendo datos de contacto y direcciones de envío.\r\n"
				+ "Los usuarios son responsables de asegurarse de que los paquetes y envíos cumplan con las restricciones y regulaciones aplicables.\r\n"
				+ "\r\n"
				+ "Los usuarios aceptan pagar las tarifas correspondientes a los servicios utilizados, según las tarifas publicadas por Hermes.\r\n"
				+ "Los pagos se pueden realizar a través de los métodos de pago aceptados por el sistema.\r\n"
				+ "\r\n"
				+ "Hermes se compromete a proteger la privacidad y los datos de los usuarios de acuerdo con las leyes aplicables.\r\n"
				+ "\r\n"
				+ "Hermes no se hará responsable de daños indirectos, consecuentes o incidentales.\r\n"
				+ "La responsabilidad de Hermes se limita a los términos establecidos en acuerdos específicos.\r\n"
				+ "\r\n"
				+ "Las políticas de cancelación y devolución se basan en las tarifas y políticas específicas de Hermes.\r\n"
				+ "Los usuarios deben revisar nuestras políticas de cancelación y devolución antes de utilizar el sistema.\r\n"
				+ "\r\n"
				+ "Hermes se reserva el derecho de suspender o cancelar la cuenta de cualquier usuario que incumpla estos términos y condiciones.\r\n"
				+ "\r\n"
				+ "Estos términos y condiciones se rigen por las leyes del país (en este caso España) y cualquier disputa se resolverá mediante arbitraje de conformidad con las reglas de Hermes o ante los tribunales competentes en España.\r\n"
				+ "\r\n"
				+ "Si tiene alguna pregunta o inquietud acerca de estos términos y condiciones, por favor contáctenos a través de support@hermes.es.\r\n"
				+ "\r\n"
				+ "Al utilizar el Sistema de Paquetería de Hermes, usted acepta y comprende estos términos y condiciones. Le recomendamos que imprima o descargue una copia de este documento para su referencia futura.");
		
	}
	
    private void cambiarPestana(int incremento) {
        int nuevoIndice = indiceActual + incremento;
        if (nuevoIndice >= 0 && nuevoIndice < tabEnvios.getTabCount()) {
            tabEnvios.setSelectedIndex(nuevoIndice);
            indiceActual = nuevoIndice;
        }
        
    }
    
	private static List<String> numerosGenerados = new ArrayList<>();
    private static String generarNumeroReferencia() {
        Random random = new Random();
        int minimo = 100000000;
        int maximo = 999999999;
        int numeroReferencia = random.nextInt(maximo - minimo + 1) + minimo;
        String referenciaComoString = Integer.toString(numeroReferencia);
        if (!numerosGenerados.contains(referenciaComoString)) {
        	numerosGenerados.add(referenciaComoString);
        	return referenciaComoString;
        } else if (numerosGenerados.size() == 10) {
        	System.out.println("Se han generado el maximo de numeros");
        	return "";
        } else {
        	return generarNumeroReferencia();
        }
    }
    
	private static int PrecioBaseAlto(int medida) {
        if (medida <= 15) {
            return 2;
        } else if (medida <= 30) {
            return 4;
        } else {
            return 10;
        }
    }
	
	private static int PrecioBaseAncho(int medida) {
        if (medida <= 15) {
            return 3;
        } else if (medida <= 30) {
            return 5;
        } else {
            return 7;
        }
    }
	
	private static int PrecioBaseLargo(int medida) {
        if (medida <= 15) {
            return 2;
        } else if (medida <= 30) {
            return 3;
        } else {
            return 11;
        }
    }
	
	
		 
    
	
    
}
