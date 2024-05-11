package control;

import java.util.List;
import java.util.Map;
import model.Cliente;
import model.Listados;
import model.Persona;

public class ProcesosClientes implements Registro<Cliente> {

    public Cliente Datos(String Direccion, int codigoPostal, int Calificacion, String NombreCompleto, String numeroCedula, int añoNacimiento, int mesNacimiento, int diaNacimiento, int numeroCelular, String contraseña, Map<String, String> comentarios, List<Integer> calificaciones,String Correo) {
        Cliente clienteIngreso = new Cliente(Direccion, codigoPostal, Calificacion, NombreCompleto, numeroCedula, añoNacimiento, mesNacimiento, diaNacimiento, numeroCelular, contraseña, Correo, comentarios, calificaciones);
        return clienteIngreso;
    }

    @Override
    public void registro(Cliente persona, Map<Persona, String> Acceso, List<Cliente> ListaClientes) {
        Listados añadirLista = new Listados();
        ListaClientes.add(persona);
        añadirLista.setLitadoClientes(ListaClientes);
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
