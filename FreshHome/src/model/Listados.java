package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Listados {

    private Map<Persona, String> Usuarios = new HashMap<>();
    private List<Empleado> ListadoEmpleados = new ArrayList<>();
    private List<Cliente> LitadoClientes = new ArrayList<>();

    public Map<Persona, String> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(Map<Persona, String> Usuarios) {
        this.Usuarios = Usuarios;
    }

    public List<Empleado> getListadoEmpleados() {
        return ListadoEmpleados;
    }

    public void setListadoEmpleados(List<Empleado> ListadoEmpleados) {
        this.ListadoEmpleados = ListadoEmpleados;
    }

    public List<Cliente> getLitadoClientes() {
        return LitadoClientes;
    }

    public void setLitadoClientes(List<Cliente> LitadoClientes) {
        this.LitadoClientes = LitadoClientes;
    }
    
    public void AgregarEmpleado (Empleado NuevoEmpleado){
        ListadoEmpleados.add(NuevoEmpleado);
    }
    
    public void AgregarCliente (Cliente NuevoCliente){
        LitadoClientes.add(NuevoCliente);
    }
    public void AgregarEmpleadoAcceso (Empleado NuevoEmpleado){
        Usuarios.put(NuevoEmpleado, NuevoEmpleado.getContraseña());
    }
    
    public void AgregarClienteAcceso (Cliente NuevoCliente){
        Usuarios.put(NuevoCliente, NuevoCliente.getContraseña());
    }
}
