package control;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Listados;
import model.Persona;

public class ProcesosClientes implements Registro<Cliente>,Serializable {
    
    private static final long serialVersionUID = 1L;

    public Cliente Datos(String Direccion, int codigoPostal, String NombreCompleto, String numeroCedula, int añoNacimiento, int mesNacimiento, int diaNacimiento, String numeroCelular, String contraseña,String Correo, String ConfirmacionContraseña) {
        Cliente cliente = new Cliente();      
        JOptionPane aviso = new JOptionPane();
        cliente.setNumeroCelular(numeroCelular);
        cliente.setNombreCompleto(NombreCompleto);
        cliente.setCodigo_Postal(codigoPostal);
        cliente.setDireccion(Direccion);
        cliente.setCorreo(Correo);
        try {
            cliente.setAñoNacimiento(añoNacimiento);
            cliente.setMesNacimiento(mesNacimiento);
            cliente.setDiaNacimiento(diaNacimiento);
        } catch (DateTimeException e) {
            aviso.showMessageDialog(null, "Por favor ingrese una fecha correcta.");
        }
        if (contraseña.equals(ConfirmacionContraseña)) {
            cliente.setContraseña(contraseña);
        } else {
            aviso.showMessageDialog(null, "Las contraseñas ingresadas no coinciden.");
        }
        return cliente;
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
