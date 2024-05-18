package exceptions;

import java.util.List;
import model.Cliente;
import model.Empleado;

public class Validaciones {

    public boolean ValidarContraseña(String Contraseña, String ConfirmacionContraseña) throws ContraseñasDiferentes {
        return Contraseña.equals(ConfirmacionContraseña);
    }

    public boolean ValidarCedula(String cedula) throws CedulaNoValida {
        return cedula.length() < 10 && cedula.length() > 8;
    }

    public boolean ValidarCorreoEmpleados(String Correo, List<Empleado> listaEmpleados) throws CorreoUsado {
        boolean indicador = false;
        for (Empleado emp : listaEmpleados) {
            indicador = !emp.getCorreo().equals(Correo);
        }
        return indicador;
    }
    public boolean ValidarCorreoClientes(String Correo, List<Cliente> listaClientes) throws CorreoUsado{
        boolean indicador = false;
        for (Cliente cli : listaClientes) {
            indicador = !cli.getCorreo().equals(Correo);
        }
        return indicador;
    }
}
