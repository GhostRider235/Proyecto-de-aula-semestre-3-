package vista;

import control.ManejoAccesos;
import control.ManejoArchivosClientes;
import control.ManejoArchivosEmpleado;
import display.PantallaInicioSesion;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        ManejoArchivosEmpleado empleados = new ManejoArchivosEmpleado();
        ManejoArchivosClientes clientes = new ManejoArchivosClientes();
        ManejoAccesos accesos = new ManejoAccesos();
        PantallaInicioSesion view = new PantallaInicioSesion();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        if (!empleados.VerificarArchivo("Almacen de datos/ListaEmpleados.txt")) {
            empleados.CrearArchivo("Almacen de datos/ListaEmpleados.txt");
        } 

        if (!clientes.VerificarArchivo("Almacen de datos/ListaClientes.txt")) {
            clientes.CrearArchivo("Almacen de datos/ListaClientes.txt");
        } 
        if (accesos.VerificarAccesos("Almacen de datos/ListaAccesos.txt")) {
            accesos.CrearAcceso("Almacen de datos/ListaAccesos.txt");
        }
        

    }

}
