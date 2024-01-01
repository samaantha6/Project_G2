package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import domain.Envio;
import domain.Usuario;

public class VentanaVerEnvios extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pCentro, pBtnVolver, pBtnEditar, pBtnEliminar;
	private JLabel txtMisEnvios, txtEnviosRealizados, txtRelleno;
	private JButton btnVolver, btnEditar, btnEliminar;
	private DefaultTableModel modeloTabla;
	private JTable tablaEnvios;
	private JScrollPane Scroll;
	
    private Map<Usuario, List<Envio>> usuariosPorEnvios = new HashMap<>();
    
    private Usuario usuario;
    
	private WindowMaster windowMaster = new WindowMaster();
	
	private Logger logger = Logger.getLogger(VentanaVerEnvios.class.getName());
	
	public VentanaVerEnvios(Map<Usuario, List<Envio>> usuariosPorEnviosS, Usuario usuarioO) {
		
		usuariosPorEnvios = usuariosPorEnviosS;
		usuario = usuarioO;
		
		pNorte = new JPanel(new GridLayout(1, 5));
		pCentro = new JPanel(new GridLayout(2, 1));
		pBtnVolver = new JPanel();
		pBtnEditar = new JPanel();
		pBtnEliminar = new JPanel();
		logger.info("JPanel creados");
		
		txtMisEnvios = new JLabel("Mis envíos");
		txtEnviosRealizados = new JLabel("Envios realizados");
		txtRelleno = new JLabel(" ");
		logger.info("JLabel creados");
		
		ImageIcon editar = new ImageIcon(getClass().getResource("/Images/editar.png"));
		ImageIcon eliminar = new ImageIcon(getClass().getResource("/Images/eliminar.png"));
		logger.info("Imagenes creadas");
		
		btnVolver = new JButton("<--");
		btnEditar = new JButton(editar);
		btnEliminar = new JButton(eliminar);
		logger.info("JButton creados");
		
		
		/**CREACION JTABLE*/
        String[] nombreColumnas = {"Nº referencia", "Fecha", "Precio", "Descripción", "Estado", "Fecha prevista"};
        modeloTabla = new DefaultTableModel(null, nombreColumnas);

        tablaEnvios = new JTable(modeloTabla);
        logger.info("Jtable creada");
        
        int rowHeight = 30;  
        tablaEnvios.setRowHeight(rowHeight);
        
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); 
        
        Scroll = new JScrollPane(tablaEnvios);
        logger.info("JScrollPane creado");
		
        tablePanel.add(Scroll, BorderLayout.CENTER);
        
		ImageIcon logo = new ImageIcon(getClass().getResource("/Images/logoPngNegro.png"));
		JLabel labelImagenLogo = new JLabel(logo);
		labelImagenLogo.setPreferredSize(new Dimension(logo.getIconWidth(), logo.getIconHeight()));
		

		pBtnVolver.add(btnVolver);
		pBtnEditar.add(btnEditar);
		pBtnEliminar.add(btnEliminar);
		pNorte.add(pBtnVolver);
		pNorte.add(txtMisEnvios);
		pNorte.add(pBtnEditar);
		pNorte.add(pBtnEliminar);
		pNorte.add(labelImagenLogo);
		
		pCentro.add(Scroll);
		
		pCentro.setBorder(new EmptyBorder(30, 20, 0, 20));

		add(pNorte, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		
/** EVENTOS */
		
		windowMaster.cargarDatosEnTabla(usuariosPorEnvios, tablaEnvios, usuario);
		
		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> new VentanaInicio(usuariosPorEnvios, usuario));
				dispose();			
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> new VentanaHacerEnvio(usuariosPorEnvios, usuario));
				dispose();			
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int fila = tablaEnvios.getSelectedRow();
		        if (fila != -1) {
		            String nReferenciaABorrar = (String) tablaEnvios.getValueAt(fila, 0);
		            for (Map.Entry<Usuario, List<Envio>> UsuarioYenvios : usuariosPorEnvios.entrySet()) {
		                Usuario usuario = UsuarioYenvios.getKey();
		                List<Envio> envios = UsuarioYenvios.getValue();
		                for (Envio envio : envios) {
		                	if (envio.getPaquete().getnReferencia() == nReferenciaABorrar) {
		                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		                        Date fechaEnvio;
		                        try {
		                            fechaEnvio = sdf.parse(envio.getRecogida().getFechaDeEnvio());
		                            long tiempoTranscurrido = System.currentTimeMillis() - fechaEnvio.getTime();
		                            System.out.println(tiempoTranscurrido);
		                            System.out.println(System.currentTimeMillis());
		                            System.out.println(fechaEnvio);
		                            long tiempoEstimado = (long) (0.3 * tiempoTranscurrido);
		                            System.out.println(tiempoEstimado);
		                            if (tiempoTranscurrido > tiempoEstimado) {
		                                JOptionPane.showMessageDialog(null, "No puedes eliminar este envío.\nHa pasado más del 30% del tiempo estimado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		                            }
		                            envios.remove(envio);
		                            break;
		                        } catch (ParseException ex) {
		                            ex.printStackTrace();
		                            break;

		                        }
		                	}
		                }
		            }
		            modeloTabla.removeRow(fila);
		            } else {
		            JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
		        }		
			}
		});
		
		
	setTitle("Ver envios");
	setBounds(300, 200, 600, 400);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
			
}
