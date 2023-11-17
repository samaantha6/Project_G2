package domain;

public class DominioValido {

    private String correoUsuario;


    public String verificarDominio(String correoUsuario) {
        this.correoUsuario = correoUsuario;
        for (Dominios dominio : Dominios.values()) {
            if (correoUsuario.endsWith("@hermes.es")) {
                return "Empleado";
            } else if (correoUsuario.endsWith(dominio.getDominio())) {
                return "Cliente";
            } 
        }
        return "Desconocido";
    }
}
