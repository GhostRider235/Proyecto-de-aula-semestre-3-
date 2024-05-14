
package vista;

import control.ManejoArchivos;
import display.PantallaInicioSesion;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        ManejoArchivos archivo = new ManejoArchivos();
        
        PantallaInicioSesion view = new PantallaInicioSesion();
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        if (archivo.VerificarArchivo("archivos/ListaEmpleados.txt")) {
            archivo.LeerListas("archivos/ListaEmpleados.txt");
            
        }else{
            archivo.CrearArchivo("archivos/ListaEmpleados.txt");
        }
        if (archivo.VerificarArchivo("archivos/ListaClientes.txt")) {
            archivo.LeerListas("archivos/ListaClientes.txt");
            
        }else{
            archivo.CrearArchivo("archivos/ListaClientes.txt");
        }
        
    }
    
}
