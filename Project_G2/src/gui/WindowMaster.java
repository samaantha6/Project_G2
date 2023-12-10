package gui;

import domain.Dominios;

public class WindowMaster {

    public String verificarDominio(String correoUsuario) {
        for (Dominios dominio : Dominios.values()) {
            if (correoUsuario.endsWith("@hermes.es")) {
                return "Empleado";
            } else if (correoUsuario.endsWith(dominio.getDominio())) {
                return "Cliente";
            } 
        }
        return "Desconocido";
    }
	
    public boolean esNumero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
