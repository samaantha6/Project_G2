package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import db.BaseDatosConfig;
import domain.Envio;
import domain.Pago;
import domain.Paquete;
import domain.Recogida;
import domain.Trayecto;
import domain.Usuario;
import gui.VentanaInicioSesion;

public class Principal {
	public static void main(String[] args) {
		
	    List<Usuario> usuarios = new ArrayList<>();
	    Map<Usuario, List<Envio>> usuariosPorEnvios = new HashMap<>();
	    
		Connection con = BaseDatosConfig.initBD("hermes.db");
		BaseDatosConfig.crearTablas(con);


	    BaseDatosConfig.insertarUsuario(con, new Usuario("a", "a", "a", "@hermes.es", "a", "a", "a"));
	    BaseDatosConfig.insertarUsuario(con, new Usuario("b", "b", "b", "@gmail.com", "b", "b", "b"));
	    BaseDatosConfig.insertarUsuario(con, new Usuario("c", "c", "c", "@hotmail.com", "c", "c", "c"));
	    BaseDatosConfig.insertarUsuario(con, new Usuario("", "", "", "", "", "", ""));
	    
    	Pago pago = new Pago("a", "a", "a", "a", "a");
    	Paquete paquete = new Paquete("b", "b", "b", "b", "b", "b", "b", "b");
    	Recogida recogida = new Recogida("c", "c", "c");
    	Trayecto trayecto = new Trayecto("d", "d", "d", "d", "d", "d", "d", "d");
        Envio envio = new Envio(trayecto, paquete, recogida, pago);
        
        BaseDatosConfig.closeBD(con);
        
	    for (Usuario usuario : usuarios) {
	    	usuariosPorEnvios.put(usuario, new ArrayList<>());
        }

		
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
		

		
		SwingUtilities.invokeLater(() -> new VentanaInicioSesion(usuariosPorEnvios));
	}
}
