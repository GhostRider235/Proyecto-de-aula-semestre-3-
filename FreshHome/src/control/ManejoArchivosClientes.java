package control;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ManejoArchivosClientes implements ManejoArchivos<Cliente>, Serializable {

    @Override
    public void SobreEscribirListas(String NombreUbicacion, List<Cliente> Lista) {
        File archivo = new File(NombreUbicacion);
        try (ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(archivo))) {
            escribir.writeObject(Lista);
            escribir.close();
            System.out.println("Lista modificada.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public List<Cliente> LeerListasArchivo(String NombreUbicacion) {
        File archivo = new File(NombreUbicacion);
        List<Cliente> ListaClientes = new ArrayList<>();
        try (ObjectInputStream leer = new ObjectInputStream(new FileInputStream(archivo))) {
            while (true) {
                try {
                    ListaClientes = (List<Cliente>) leer.readObject();
                    leer.close();
                } catch (EOFException  e) {
                    e.printStackTrace(System.out);
                    break;
                }
            }
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
