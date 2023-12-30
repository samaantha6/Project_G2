package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.Pago;
import domain.Paquete;
import domain.Recogida;
import domain.Trayecto;


public class BaseDatosConfig {
	
	/**
	 * Método que realiza la conexión con la base de datos
	 * @param nombreBD : Nombre de la base de datos a la que nos vamos a conectar
	 * @return Devuelve la conexión a la base de datos
	 */
	
	public static Connection initBD(String nombreBD) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+ nombreBD);
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeBD(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*Al ejecutar una sentencia sql tenemos 2 opciones:
	  - Modificar la base de datos: CREATE TABLE, UPDATE, DELETE, INSERT, DROP, MODIFY
	  				st.executeUpdate(sql);
	  				
	  - No modifica la base de datos, sólo accede al contenido: SELECT
	                ResultSet rs = st.executeQuery(sql);
	  */
	
	/*Cuando se captura una excepción podemos hacer 2 cosas:
	 * 
	 * - Darle tratamiento a esa excepción en el catch
	 * - Propagar la excepción -> Si un método propaga una excepción,lo tiene que indicar en la cabecer
	 * 
	 * */
	
	
	
	public static void crearTablas(Connection con) {
		String sql = "CREATE TABLE IF NOT EXISTS Usuario (nombre String, apellido String, telefono String, correo String, respuesta String, preguntaSeg String, contrasenia String)";
		String sql2 = "CREATE TABLE IF NOT EXISTS Pago (descripcion String, numeroTarjeta String, fechaCaducudad String, CVV String, remitenteDestinatario String, factura String, Dni String)";
		String sql3 = "CREATE TABLE IF NOT EXISTS Paquete (nReferencia String, embalaje String, peso String, largo String, ancho String, alto String, valor String, fragil String)";
		String sql4 = "CREATE TABLE IF NOT EXISTS Recogida (fechaRecogida String, lugarDeRecogida String, tipoDeEnvio String)";
		String sql5 = "CREATE TABLE IF NOT EXISTS Trayecto (nombreOrigen String, direccionOrigen String, telefonoOrigen String, nombreDestino String, direccionDestino String, telefonoDestino String)";
		String sql6 = "CREATE TABLE IF NOT EXISTS Envio (direccionOrigen String, direccionDestinoString, nReferencia String, fechaRecogida String, Dni String)";

		
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
			st.executeUpdate(sql4);
			st.executeUpdate(sql5);
			st.executeUpdate(sql6);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
			
}