package control;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import model.Persona;

public class ManejoAccesos {

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

    public void EscribirDiccionario(String NombreORuta, Map<Persona, String> Accesos) {
        File archivo = new File(NombreORuta);
        try (
            FileOutputStream os = new FileOutputStream(archivo);
            ObjectOutputStream escribir = new ObjectOutputStream(os);
                ) {
            
            escribir.writeObject(Accesos);
            escribir.close();
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println("Archivo escrito.");
    }

    public Map<Persona, String> LeerDiccionario(String NombreORuta) {
        HashMap<Persona, String> listaAccesos = new HashMap<>();
        File archivo = new File(NombreORuta);
        try (
                InputStream os = new FileInputStream(archivo); 
                ObjectInputStream leer = new ObjectInputStream(os);
            ) {
            listaAccesos = (HashMap<Persona, String>) leer.readObject();

        } catch (EOFException ex) {
            ex.printStackTrace(System.out);
            System.out.println("El archivo no tiene nada.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
            
        }
        return listaAccesos;
    }
}
