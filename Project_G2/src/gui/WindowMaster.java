package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

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
	
    public boolean esNumero(JTextField textFieldNumero, String tipo) {
    	String numero = textFieldNumero.getText();
        try {
        	if (tipo == "Telefono" && numero.length() == 9) {
        		Integer.parseInt(numero);
        		textFieldNumero.setBackground(UIManager.getColor("TextField.background"));
        		return true;
        	} else if (tipo == "DNI" && numero.length() == 9) {
                String numeros = numero.substring(0, 8);
                char letra = numero.charAt(8);

                int numerosInt = Integer.parseInt(numeros);
                char letraCalculada = calcularLetraDNI(numerosInt);

                if (letra == letraCalculada) {
            		textFieldNumero.setBackground(UIManager.getColor("TextField.background"));
                    return true;
                } else {
                    textFieldNumero.setBackground(Color.RED);
                    JOptionPane.showMessageDialog(null, "Tines que ingresar un DNI existente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
        	} else if (tipo == "DNI" && numero.length() != 9) {
                textFieldNumero.setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "Tines que ingresar un DNI existente.", "Error", JOptionPane.ERROR_MESSAGE);
        	} else if (tipo == "Telefono" && numero.length() != 9) {
        		textFieldNumero.setBackground(Color.RED);
				JOptionPane.showMessageDialog(null, "Tienes que ingresar un telefono valido.", "Error", JOptionPane.ERROR_MESSAGE);
        	} else {
        		Integer.parseInt(numero);
        		return true;
        	}
        } catch (NumberFormatException e) {
            return false;
        }
		return false;
    }
    
    
    /*Comprobar campos vacios*/
    public static List<JTextField> camposVacios(JTextField... textFields) {
        List<JTextField> camposVacios = new ArrayList<>();

        for (JTextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                camposVacios.add(textField);
            }
        }

        return camposVacios;
    }
    
    
    
    /*Cambiar el fondo de los campos vacíos a rojo*/
    public HashMap<JTextField, Color> cambiarFondoCampos(List<JTextField> campos) {
        
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
    public JTextField distinguirCampoContrasenia(JTextField contraseniaTextField, JPasswordField contraseniaPasswordField, boolean distincion) {
    	if (distincion) {
        	return contraseniaTextField;
        } else {
        	return contraseniaPasswordField;
        }
    }
    
    private static char calcularLetraDNI(int parteNumerica) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indiceLetra = parteNumerica % 23;
        return letras.charAt(indiceLetra);
    }
    
}
