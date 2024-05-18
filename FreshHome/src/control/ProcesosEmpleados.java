package control;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Empleado;
import model.Listados;
import model.Persona;

public class ProcesosEmpleados implements Registro<Empleado>,Serializable {
    private static final long serialVersionUID = 1L;

    public Empleado Datos(List<String> Habilidades, int Tarifa, String AñosExperiencia, String MetodoPago, String NombreCompleto, String numeroCedula, int añoNacimiento, int mesNacimiento, int diaNacimiento, String numeroCelular, String contraseña, String ConfimacionContraseña, String correo) {
        Empleado empleado = new Empleado();
        JOptionPane aviso = new JOptionPane();
        empleado.setAñosExperiencia(AñosExperiencia);
        empleado.setCorreo(correo);
        empleado.setNombreCompleto(NombreCompleto);
        empleado.setNumero_Cedula(numeroCedula);
        if (contraseña.equals(ConfimacionContraseña)) {
            empleado.setContraseña(contraseña);
        } else {
            aviso.showMessageDialog(null, "La contraseña ingresada no coincide.");
        }

        empleado.setTarifa(Tarifa);
        empleado.setMetodoPago(MetodoPago);
        try {
            empleado.setDia_Nacimiento(diaNacimiento);
            empleado.setMes_Nacimiento(mesNacimiento);
            empleado.setAño_Nacimiento(añoNacimiento);
        } catch (DateTimeException e) {
            aviso.showMessageDialog(null, "Por favor introduzca una fecha correcta.");
        }
        empleado.setHabilidades(Habilidades);

        return empleado;
    }

    @Override
    public void registro(Empleado persona, Map<Persona, String> Acceso, List<Empleado> ListaEmpleados) {
        Listados añadirLista = new Listados();
        ListaEmpleados.add(persona);
        añadirLista.setListadoEmpleados(ListaEmpleados);
        Acceso.put(persona, persona.getContraseña());
        añadirLista.setUsuarios(Acceso);
    }

    @Override
    public float CalificacionFinal(List<Integer> calificaciones) {
        int CalifiacionFinal = 0;
        for (Integer calificacion : calificaciones) {
            CalifiacionFinal += calificacion;
        }
        return CalifiacionFinal / calificaciones.size();
    }

}
