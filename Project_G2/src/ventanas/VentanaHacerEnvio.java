package ventanas;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class VentanaHacerEnvio extends JFrame {
	
	
	private JTabbedPane tabEnvios;
	private JLabel a;
	
	
	public VentanaHacerEnvio() {
	
		tabEnvios = new JTabbedPane();
		a = new JLabel("hola");
		
		tabEnvios.addTab("Pestaña 1", a);
		
		add(tab1);
		
		setTitle("Hacer envío");
		setBounds(300, 200, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
