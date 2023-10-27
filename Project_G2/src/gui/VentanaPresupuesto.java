package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPresupuesto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel pNorte, pOeste, pEste, pBtnHcerEnvio, pBtnVolver;
	private JLabel txtPresupuesto, txtTipoEnvio;
	private JCheckBox estandar, superior, premium;
	private JButton btnHacerEnvio, btnVolver;
	
	public VentanaPresupuesto() {
		
		pNorte = new JPanel();
		pBtnHcerEnvio = new JPanel();
		pBtnVolver = new JPanel();
		pOeste = new JPanel(new GridLayout(4, 1));
		pEste = new JPanel(new GridLayout(2, 1));
		
		txtPresupuesto = new JLabel("Presupuesto");
		txtTipoEnvio = new JLabel("Tipo Envio");

		estandar = new JCheckBox("Estandar\n (En 8/12 dias)");
		superior = new JCheckBox("Superior\n (En 6/10 dias");
		premium = new JCheckBox("Premium\n (En 2 dias");
		
		btnHacerEnvio = new JButton("Hacer Envio");
		btnVolver = new JButton("Volver");

		pNorte.add(txtPresupuesto);
		
		pOeste.add(txtTipoEnvio);
		pOeste.add(estandar);
		pOeste.add(superior);
		pOeste.add(premium);
		
		pBtnHcerEnvio.add(btnHacerEnvio);
		pEste.add(pBtnHcerEnvio);
		pBtnVolver.add(btnVolver);
		pEste.add(pBtnVolver);
		
		add(pNorte, BorderLayout.NORTH); 
		add(pOeste, BorderLayout.WEST); 
		add(pEste, BorderLayout.EAST); 
		
	setTitle("Presupuesto");
	setBounds(300, 200, 600, 400);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
