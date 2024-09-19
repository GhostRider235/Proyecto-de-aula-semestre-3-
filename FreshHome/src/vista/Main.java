package vista;

import control.*;
import display.PantallaInicioSesion;
import java.io.*;
import model.*;


public class Main implements Serializable {

    public static void main(String[] args) {
        
        //Objetos para manejar los archivos
        ManejoArchivosEmpleado empleados = new ManejoArchivosEmpleado();
        ManejoArchivosClientes clientes = new ManejoArchivosClientes();
        ManejoAccesos accesos = new ManejoAccesos();
        
        //Archivos
        File emp = new File("Almacen/ListaEmpleados.txt");
        File cli = new File("Almacen/ListaClientes.txt");
        File acc = new File("Almacen/ListaAccesos.txt");
        
        //Listas
        Listados l = new Listados();
        
        
        // Inicio 
        PantallaInicioSesion view = new PantallaInicioSesion();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        
        // Verificacion de archivos
        if (emp.exists()) {
            l.setListadoEmpleados(empleados.LeerListasArchivo("Almacen/ListaEmpleados.txt"));
        } else {
            empleados.CrearArchivo("Almacen/ListaEmpleados.txt");
        }
        
        if (cli.exists()) {
            l.setLitadoClientes(clientes.LeerListasArchivo("Almacen/ListaClientes.txt"));
        } else {
            clientes.CrearArchivo("Almacen/ListaClientes.txt");
        }
        
        if (acc.exists()) {
            l.setUsuarios(accesos.LeerDiccionario("Almacen/ListaAccesos.txt"));
        } else {
            accesos.CrearAcceso("Almacen/ListaAccesos.txt");
        }
        
        //Extra
        for (Persona x : l.getUsuarios().keySet()) {
            
            System.out.println("Correo : " + x.getCorreo());
            System.out.println("Contraseña : " + x.getContraseña());
            
        }
        
        
        
    }

}
