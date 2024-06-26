package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import model.Persona;

public class ManejoAccesos implements Serializable{



    public boolean VerificarAccesos(String NombreORuta) {
        File archivos = new File(NombreORuta);
        return archivos.exists();
    }

    public void CrearAcceso(String NombreORuta) {
        File archivos = new File(NombreORuta);
        try {
            archivos.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println("Archivo creado.");
    }

    @SuppressWarnings("unchecked")
    public void EscribirDiccionario(String NombreORuta, Map<Persona, String> Accesos) {
        File archivos = new File(NombreORuta);
        try {
            OutputStream os = new FileOutputStream(archivos);
            try (ObjectOutputStream escribir = new ObjectOutputStream(os)) {
                escribir.writeObject(Accesos);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println("Archivo escrito.");
    }

    @SuppressWarnings("unchecked")
    public Map<Persona, String> LeerDiccionario(String NombreORuta) {
        HashMap<Persona, String> listaAccesos = null;
        File archivo = new File(NombreORuta);
        try {
            InputStream os = new FileInputStream(archivo);
            ObjectInputStream leer = new ObjectInputStream(os);
            listaAccesos = (HashMap<Persona, String>) leer.readObject();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        return listaAccesos;
    }
}
