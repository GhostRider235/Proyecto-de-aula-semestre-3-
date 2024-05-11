package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Persona {

    private String NombreCompleto;
    private String numeroCedula;
    private int añoNacimiento;
    private int mesNacimiento;
    private int diaNacimiento;
    private int numeroCelular;
    private String contraseña;
    private String correo;
    private LocalDate edad;
    public Map<String,String> comentarios;
    public List<Integer> calificaciones;
    private LocalDate FechaNacimiento;
    static LocalDate FechaAhora = LocalDate.now();

    public Persona(String NombreCompleto, String numeroCedula, int añoNacimiento, int mesNacimiento, int diaNacimiento, int numeroCelular, String contraseña, String correo, Map<String, String> comentarios, List<Integer> calificaciones) {
        this.NombreCompleto = NombreCompleto;
        this.numeroCedula = numeroCedula;
        this.añoNacimiento = añoNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.diaNacimiento = diaNacimiento;
        this.numeroCelular = numeroCelular;
        this.contraseña = contraseña;
        this.correo = correo;
        this.comentarios = comentarios;
        this.calificaciones = calificaciones;
    }

    

    
    public Persona() {
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public int getMesNacimiento() {
        return mesNacimiento;
    }

    public void setMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    public void setDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public Map<String, String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Map<String, String> comentarios) {
        this.comentarios = comentarios;
    }

    public LocalDate getEdad() {
        edad = FechaAhora.minusYears(FechaNacimiento.getYear());
        return edad;
    }
    

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getNumero_Cedula() {
        return numeroCedula;
    }

    public void setNumero_Cedula(String numero_Cedula) {
        this.numeroCedula = numero_Cedula;
    }

    public int getAño_Nacimiento() {
        return añoNacimiento;
    }

    public void setAño_Nacimiento(int año_Nacimiento) {
        this.añoNacimiento = año_Nacimiento;
    }

    public int getMes_Nacimiento() {
        return mesNacimiento;
    }

    public void setMes_Nacimiento(int mes_Nacimiento) {
        this.mesNacimiento = mes_Nacimiento;
    }

    public int getDia_Nacimiento() {
        return diaNacimiento;
    }

    public void setDia_Nacimiento(int dia_Nacimiento) {
        this.diaNacimiento = dia_Nacimiento;
    }

    public LocalDate getFechaNacimiento() {
        FechaNacimiento = LocalDate.of(añoNacimiento, mesNacimiento, diaNacimiento);
        return FechaNacimiento;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    

    public List<Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }


    public static LocalDate getFechaAhora() {
        return FechaAhora;
    }

    

}
