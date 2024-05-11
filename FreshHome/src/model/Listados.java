package model;

import java.util.List;
import java.util.Map;

public class Listados {

    private Map<Persona, String> Usuarios;
    private List<Empleado> ListadoEmpleados;
    private List<Cliente> LitadoClientes;

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

}
