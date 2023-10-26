package gui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPresupuesto extends JFrame{
	
	private JPanel pNorte;
	private JLabel txtPresupuesto, txtTipoEnvio;
	private JCheckBox estandar, superior, premium;
	private JButton btnHacerEnvio, btnVolver;
	
	public VentanaPresupuesto() {
		
		pNorte = new JPanel();
		
		txtPresupuesto = new JLabel("Presupuesto");
		txtTipoEnvio = new JLabel("Tipo Envio");

		estandar =new JCheckBox("Estandar\n(En 8/12 dias)");
		superior =new JCheckBox("Superior\n(En 6/10 dias");
		premium =new JCheckBox("Premium\\n(En 2 dias");

		
		
	setTitle("Presupuesto");
	setBounds(300, 200, 600, 400);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
