package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.Dominios;

public class WindowMaster {

    private HashMap<JTextField, Color> fondosOriginales = new HashMap<>();
	
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
    
    public static List<JTextField> camposVacios(JTextField... textFields) {
        List<JTextField> camposVacios = new ArrayList<>();

        for (JTextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                camposVacios.add(textField);
            }
        }

        return camposVacios;
    }
    
    public HashMap<JTextField, Color> cambiarFondoCampos(List<JTextField> campos) {
        // Cambiar el fondo de los campos vacíos a rojo
        for (JTextField campo : campos) {
        	fondosOriginales.put(campo, campo.getBackground());
            campo.setBackground(Color.RED);
        }
        return fondosOriginales;
    }
    
    public void restaurarFondo (HashMap<JTextField, Color> camposConColor) {
    	for (JTextField campo : fondosOriginales.keySet()) {
            if (!campo.getText().isEmpty()) {
                campo.setBackground(fondosOriginales.get(campo));
            }
        }
    }
    //new String(contraseniaPasswordField.getPassword()
    public JTextField distinguirCampoContrasenia(JTextField contraseniaTextField, JPasswordField contraseniaPasswordField, boolean distincion) {
    	if (distincion) {
        	return contraseniaTextField;
        } else {
        	return contraseniaPasswordField;
        }
    }
    
}
