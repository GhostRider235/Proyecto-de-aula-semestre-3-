
package control;

import java.util.List;
import java.util.Map;
import model.Empleado;
import model.Listados;
import model.Persona;

public class ProcesoEmpleados implements Registro<Empleado>{
    
    public Empleado Datos(int calificacion,int Tarifa,int AñosExperiencia,String MetodoPago,String NombreCompleto,String numeroCedula,int añoNacimiento,int mesNacimiento,int diaNacimiento,int numeroCelular,String contraseña,String correo,Map<String,String> comentarios,List<Integer> calificaciones){
        Empleado empleado = new Empleado(calificacion, Tarifa, AñosExperiencia, MetodoPago, NombreCompleto, numeroCedula, añoNacimiento, mesNacimiento, diaNacimiento, numeroCelular, contraseña, correo, comentarios, calificaciones);
        return empleado;
    }

    @Override
    public void registro(Empleado persona, Map<Persona, String> Acceso,List<Empleado> ListaEmpleados) {
        Listados añadirLista = new Listados();
        ListaEmpleados.add(persona);
        añadirLista.setListadoEmpleados(ListaEmpleados);
        Acceso.put(persona, persona.getContraseña());
        añadirLista.setUsuarios(Acceso);
    }

    @Override
    public float CalificacionFinal(List<Integer> calificaciones) {
        int CalifiacionFinal =0;
        for (Integer calificacion : calificaciones) {
            CalifiacionFinal+=calificacion;
        }
        return CalifiacionFinal/calificaciones.size();
    }

    

    
    
}
