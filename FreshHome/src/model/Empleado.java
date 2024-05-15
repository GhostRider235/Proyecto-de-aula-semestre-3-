package model;

import java.util.List;
import java.util.Map;

public class Empleado extends Persona {

    private int calificacion;
    private List<String> Habilidades;
    private int Tarifa;
    private String AñosExperiencia;
    private String MetodoPago;

    public Empleado() {
    }

    public Empleado(int calificacion, List<String> Habilidades, int Tarifa, String AñosExperiencia, String MetodoPago, String NombreCompleto, String numeroCedula, int añoNacimiento, int mesNacimiento, int diaNacimiento, int numeroCelular, String contraseña, String correo, Map<String, String> comentarios, List<Integer> calificaciones) {
        super(NombreCompleto, numeroCedula, añoNacimiento, mesNacimiento, diaNacimiento, numeroCelular, contraseña, correo, comentarios, calificaciones);
        this.calificacion = calificacion;
        this.Habilidades = Habilidades;
        this.Tarifa = Tarifa;
        this.AñosExperiencia = AñosExperiencia;
        this.MetodoPago = MetodoPago;
    }

    public String getAñosExperiencia() {
        return AñosExperiencia;
    }

    public void setAñosExperiencia(String AñosExperiencia) {
        this.AñosExperiencia = AñosExperiencia;
    }

    public String getMetodoPago() {
        return MetodoPago;
    }

    public void setMetodoPago(String MetodoPago) {
        this.MetodoPago = MetodoPago;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public List<String> getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(List<String> Habilidades) {
        this.Habilidades = Habilidades;
    }

    public int getTarifa() {
        return Tarifa;
    }

    public void setTarifa(int Tarifa) {
        this.Tarifa = Tarifa;
    }

}
