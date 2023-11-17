package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import domain.Usuario;
import gui.VentanaInicioSesion;

public class Main {
	public static void main(String[] args) {
		
	    List<Usuario> usuarios = new ArrayList<>();
	    usuarios.add(new Usuario("b", "b", "b", "@gmail.com", "b", "b", "b"));
	    usuarios.add(new Usuario("c", "c", "c", "@hotmail.com", "c", "c", "c"));
	    usuarios.add(new Usuario("a", "a", "a", "@hermes.es", "a", "a", "a"));
			
		/**Cargamos la configuración del logger*/
		try {
			FileInputStream fis = new FileInputStream("conf/logger.properties");
			LogManager.getLogManager().readConfiguration(fis);		
			
			//Logger prueba = Logger.getLogger("prueba");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			
		} catch (SecurityException e1) {
			e1.printStackTrace();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		SwingUtilities.invokeLater(() -> new VentanaInicioSesion(usuarios));

	}
}
