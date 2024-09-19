package control;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Listados;

public class ManejoArchivosClientes implements ManejoArchivos<Cliente>, Serializable {

    @Override
    public void SobreEscribirListas(String NombreUbicacion, List<Cliente> Lista) {
        File archivo = new File(NombreUbicacion);
        try (
            FileOutputStream os = new FileOutputStream(archivo);
            ObjectOutputStream escribir = new ObjectOutputStream(os);
                ) {
            
            escribir.writeObject(Lista);

            System.out.println("Lista modificada.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public List<Cliente> LeerListasArchivo(String NombreUbicacion) {
        File archivo = new File(NombreUbicacion);
        List<Cliente> ListaClientes = new ArrayList<>();
        try {
            FileInputStream os = new FileInputStream(archivo);
            ObjectInputStream leer = new ObjectInputStream(os);
            ListaClientes = (List<Cliente>) leer.readObject();

        } catch (EOFException e) {
            e.printStackTrace(System.out);
            System.out.println("El archivo no tiene nada.");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        return ListaClientes;
    }

    @Override
    public boolean VerificarArchivo(String NombreUbicacion) {
        File archivo = new File(NombreUbicacion);
        return archivo.exists();
    }

    
    
}
