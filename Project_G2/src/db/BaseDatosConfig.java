package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import domain.Envio;
import domain.Pago;
import domain.Paquete;
import domain.Recogida;
import domain.Trayecto;
import domain.Usuario;


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
		String sql2 = "CREATE TABLE IF NOT EXISTS Pago (descripcion String, numeroTarjeta String, fechaCaducudad String, CVV String, remitenteDestinatario String, factura String, Dni String, precio String)";
		String sql3 = "CREATE TABLE IF NOT EXISTS Paquete (nReferencia String, embalaje String, peso String, largo String, ancho String, alto String, valor String, fragil String)";
		String sql4 = "CREATE TABLE IF NOT EXISTS Recogida (fechaRecogida String, lugarDeRecogida String, tipoDeEnvio String)";
		String sql5 = "CREATE TABLE IF NOT EXISTS Trayecto (nombreOrigen String, direccionOrigen String, telefonoOrigen String, correoOrigen String, nombreDestino String, direccionDestino String, telefonoDestino String, correoDestino String)";
		String sql6 = "CREATE TABLE IF NOT EXISTS Envio (direccionOrigen String, direccionDestino String, nReferencia String, fechaRecogida String, Dni String, precio String)";

		
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
	
	public static Usuario buscarUsuario(Connection con, String correo) {
		
		String sql = String.format("SELECT * FROM Usuario WHERE correo ='%s'", correo);
		Usuario u = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) { 
				String nom = rs.getString("nombre");
				String ap = rs.getString("apellido");
				String tel = rs.getString("telefono");
				String corr = rs.getString("correo"); 
				String res = rs.getString("respuesta"); 
				String pregSeg = rs.getString("preguntaSeg"); 
				String contra = rs.getString("contrasenia"); 
				u = new Usuario(nom, ap, tel, corr, res, pregSeg, contra);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static Pago buscarPago(Connection con, String dni) {
		
		String sql = String.format("SELECT * FROM Pago WHERE Dni ='%s'", dni);
		Pago pag = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) { 
				String desc = rs.getString("descripcion");
				String nTarj = rs.getString("numeroTarjeta");
				String fCad = rs.getString("fechaCaducidad");
				String cvv = rs.getString("CVV"); 
				String remitD = rs.getString("remitenteDestinatario"); 
				String fact = rs.getString("factura"); 
				String dniRS = rs.getString("Dni"); 
				String prec = rs.getString("precio"); 
				pag = new Pago(desc, nTarj, fCad, cvv, remitD, fact, dniRS, prec);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pag;
	}
	
	public static Trayecto buscarTrayecto(Connection con, String nombreOrigen) {
		
		String sql = String.format("SELECT * FROM Trayecto WHERE nombreOrigen ='%s'", nombreOrigen);
		Trayecto t = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) { 
				String nOrg = rs.getString("nombreOrigen");
				String dOrg = rs.getString("direccionOrigen");
				String telOrg = rs.getString("telefonoOrigen");
				String cO = rs.getString("correoOrigen");
				String nD = rs.getString("nombreDestino"); 
				String dD = rs.getString("direccionDestino"); 
				String tD = rs.getString("telefonoDestino"); 
				String cD = rs.getString("correoDestino"); 
				t = new Trayecto(nOrg, dOrg, telOrg, cO, nD, dD, tD, cD);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public static Envio buscarEnvio(Connection con, Paquete paq) {
		
		String sql = String.format("SELECT * FROM Envio WHERE nRefe ='%s'", paq.getnReferencia());
		Envio e = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) { 
				String dO = rs.getString("direccionOrigen");
				String dD = rs.getString("direccionDestino");
				String nRefe = rs.getString("nReferencia");
				String fRec = rs.getString("fechaRecogida");
				String Dni = rs.getString("Dni"); 
				String precio = rs.getString("precio"); 
				e = new Envio(dO, dD, nRefe, fRec, Dni, precio);
			}
			rs.close();
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}
	
	public static Paquete buscarPaquete(Connection con, String nReferencia) {
		
		String sql = String.format("SELECT * FROM Paquete WHERE nReferencia ='%s'", nReferencia);
		Paquete pq = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) { 
				String nR = rs.getString("nReferencia");
				String em = rs.getString("embalaje");
				String lar = rs.getString("largo");
				String pes = rs.getString("peso");
				String anc = rs.getString("ancho");
				String alt = rs.getString("alto"); 
				String val = rs.getString("valor"); 
				String fra = rs.getString("fragil"); 
				pq = new Paquete(nR, em, lar, pes, anc, alt, val, fra);
			}
			rs.close();
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return pq;
	}
	
	public static Recogida buscarRecogida(Connection con, String fechaRecogida) {
		
		String sql = String.format("SELECT * FROM Recogida WHERE fechaRecogida ='%s'", fechaRecogida);
		Recogida r = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) { 
				String fRe = rs.getString("fechaRecogida");
				String lRe = rs.getString("lugarDeRecogida");
				String tEn = rs.getString("tipoDeEnvio");
				r = new Recogida(fRe, lRe, tEn);
			}
			rs.close();
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return r;
	}
	
	
	public static void insertarUsuario(Connection con, Usuario u) {
		if(buscarUsuario(con, u.getNombre())==null) {
			String sql = String.format("INSERT INTO Usuario VALUES('%s','%s','%s','%s','%s','%s','%s');", u.getNombre(),u.getApellido(), u.getTelefono(),u.getCorreo(), u.getRespuesta(), u.getPreguntaSeg(), u.getContrasenia());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void insertarPago(Connection con, Pago p) {
		if(buscarPago(con, p.getDni())==null) {
			String sql = String.format("INSERT INTO Pago VALUES('%s','%s','%s','%s','%s','%s','%s','%s');", p.getDescripcion(), p.getNumeroTrajeta(), p.getFechaCaducidad(), p.getCVV(), p.getRemitenteDestinatario(), p.getFactura(), p.getDni(), p.getPrecio());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void insertarTrayecto(Connection con, Trayecto t) {
		if(buscarPago(con, t.getCorreoOrigen())==null) {
			String sql = String.format("INSERT INTO Trayecto VALUES('%s','%s','%s','%s','%s','%s','%s','%s');", t.getNombreOrigen(), t.getDireccionOrigen(), t.getDireccionOrigen(), t.getTelefonoOrigen(), t.getCorreoOrigen(), t.getNombreDestino(), t.getDireccionDestino(),t.getTelefonoDestino(),  t.getCorreoDestino());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void insertarEnvio(Connection con, Envio e) {
		if(buscarEnvio(con, e.getPaquete())==null) {
			String sql = String.format("INSERT INTO Envio VALUES('%s','%s','%s','%s','%s','%s','%s');", e.getTrayecto().getDireccionOrigen(), e.getTrayecto().getDireccionDestino(), e.getPaquete().getnReferencia(),e.getRecogida().getFechaDeEnvio(), e.getPago().getDni(), e.getPago().getPrecio());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void insertarPaquete(Connection con, Paquete pq) {
		if(buscarPaquete(con, pq.getnReferencia())==null) {
			String sql = String.format("INSERT INTO Paquete VALUES('%s','%s','%s','%s','%s','%s','%s','%s');", pq.getnReferencia(), pq.getEmbalaje(), pq.getPeso(), pq.getLargo(), pq.getAncho(), pq.getAlto(), pq.getValor(), pq.getFragil());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	

	public static void insertarPecogida(Connection con, Recogida r) {
		if(buscarPaquete(con, r.getFechaDeEnvio())==null) {
			String sql = String.format("INSERT INTO Recogida VALUES('%s','%s','%s');", r.getFechaDeEnvio(), r.getLugarDeRecogida(), r.getTipoDeEnvio());
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
			
}