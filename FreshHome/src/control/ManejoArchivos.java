package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Empleado;
import model.Persona;

public class ManejoArchivos {

    static Persona Convertir(String linea) {
        Persona objeto = new Persona();
        if (linea.length()<9) {
            System.out.println("La linea que se esta leyendo no tiene los suficeintes caracteres para ser leida como un objeto");
        }
        
        return objeto;
    }

    public static void CrearArchivo(String NombreORuta) {
        File Archivo = new File(NombreORuta);

        try {
            Archivo.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println("Archivo creado");
    }

    public static void SobreEscribirListas(String NombreORuta, List<Empleado> lista) {
        File Archivo = new File(NombreORuta);

        try {
            PrintWriter sobreEscrbir = new PrintWriter(Archivo);
            for (Empleado empleado : lista) {
                sobreEscrbir.println(empleado);
            }
            
            sobreEscrbir.close();
        } catch (FileNotFoundException e) {
        }
    }

    public static List<Persona> LeerListas(String NombreORuta) {
        File Archivo = new File(NombreORuta);
        List<Persona> listaRetornar = new ArrayList<>();

        try {
            BufferedReader LeerArchivo = new BufferedReader(new FileReader(Archivo));
            while (LeerArchivo.readLine() != null) {
                String linea;
                while ((linea = LeerArchivo.readLine())!=null) {                    
                    listaRetornar.add(Convertir(linea));
                }
                
                
            }
            LeerArchivo.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        return listaRetornar;
    }
}
