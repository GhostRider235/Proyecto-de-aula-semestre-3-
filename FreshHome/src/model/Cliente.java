package model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class Cliente extends Persona implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String Direccion;
    private int codigoPostal;
    private int Calificacion;

    public Cliente(String Direccion, int codigoPostal, int Calificacion, String NombreCompleto, String numeroCedula, int añoNacimiento, int mesNacimiento, int diaNacimiento, String numeroCelular, String contraseña, String correo, Map<String, String> comentarios, List<Integer> calificaciones) {
        super(NombreCompleto, numeroCedula, añoNacimiento, mesNacimiento, diaNacimiento, numeroCelular, contraseña, correo, comentarios, calificaciones);
        this.Direccion = Direccion;
        this.codigoPostal = codigoPostal;
        this.Calificacion = Calificacion;
    }

    

    
    public Cliente() {
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getCodigo_Postal() {
        return codigoPostal;
    }

    public void setCodigo_Postal(int codigo_Postal) {
        this.codigoPostal = codigo_Postal;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int Calificacion) {
        this.Calificacion = Calificacion;
    }

    
}
