package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JCalendar;

import domain.Paquete;
import domain.Recogida;
import domain.Trayecto;
import domain.Usuario;

public class VentanaHacerEnvio extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JTabbedPane tabEnvios;
	
	private JLabel txtCrearEnvio,  
					txtDesde, txtHasta, txtNom, txtDir, txtTel, txtCorreo, txtNomHasta, txtDirHasta, txtTelHasta, txtCorreoHasta,
					txtEmbalado, txtLargo, txtAncho, txtAlto, txtPeso, txtKg, txtValor, txtEur, txtInfo,
					txtFEnvio, txtRecog, txtCasoRecog, txtEntrega,
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
					pRev, pRevEnvio, pInfo, pAltPesLrAn, pEnYPg;
	
	private ButtonGroup tipoEnvioGrupo, recogidaGrupo, pagoGrupo, facturaGrupo;
	
	
    private List<Usuario> usuarios = new ArrayList<>();
    
    private Usuario usuario;
    
	private WindowMaster windowMaster = new WindowMaster();
	
    private HashMap<JTextField, Color> fondosOriginales = new HashMap<>();

    private String lugarDeRecogida;
    private String tipoDeEnvio;
    
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
		txtDir = new JLabel("Dirección");
		txtTel = new JLabel("Teléfono:");
		txtCorreo = new JLabel("Correo:");
		logger.info("JLabels 2 de tab 'DONDE' creados");
		
		txtNomHasta = new JLabel("Nombre:");
		txtDirHasta = new JLabel("Dirección");
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
		logger.info("JTextFields de tab 'COMO' creado");
		
		radPtoRecog = new JRadioButton("Punto de recogida");
		radUsoDir = new JRadioButton("Usar mi direccion");
		radEstandar = new JRadioButton("Estandar");
		radSuper = new JRadioButton("Superior");
		radPremium = new JRadioButton("Premium");
		logger.info("JRadioButton de tab 'COMO' creados");
		
		comboRecog = new JComboBox<String>();
		comboRecog.addItem("ejemplo");
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
		logger.info("JTextFields de tab 'REVISION' creados");
	 
		checkTerminos = new JCheckBox("<html><u>Aceptas terminos y condiciones de uso</u></html>");
		logger.info("JCheckBox de tab 'REVISION' creado");
		
		
		pRevEnvio = new JPanel(new GridLayout(2,4));
		pInfo = new JPanel();
		pAltPesLrAn = new JPanel(new GridLayout(4,2));
		pEnYPg = new JPanel(new GridLayout(2,2));
		pBtnFinalizar = new JPanel();
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
		 
		 pBtnFinalizar.add(btnFinalizar);
		 
		 pRev.add(pRevEnvio);
		 pRev.add(pEnYPg);
		 pRev.add(pAltPesLrAn);
		 pRev.add(checkTerminos);
		 pRev.add(pBtnFinalizar);
		 
		 add(pRev);
		
		tabEnvios.addTab("DONDE", pDonde);
		tabEnvios.addTab("QUE", pQue);
		tabEnvios.addTab("COMO", pComo);
		tabEnvios.addTab("PAGO", pPago);
		tabEnvios.addTab("REVISIÓN", pRev);
		
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
							System.out.println(recogida.toString());
							camposVacios =  windowMaster.camposVacios(campoPeso, campoLargo, campoAncho, campoAlto, campoValor);
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
            }
        });
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio VI = new VentanaInicio(usuarios, usuario);
				dispose();			
			}
		});
		
		
		
		setTitle("Hacer envío");
		setBounds(300, 200, 800, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    
}
