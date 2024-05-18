package control;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ManejoArchivosClientes implements ManejoArchivos<Cliente> {

    @Override
    public void SobreEscribirListas(String NombreUbicacion, List<Cliente> Lista) {
        File archivo = new File(NombreUbicacion);
        try {
            OutputStream os = new FileOutputStream(archivo);
            ObjectOutputStream escribir = new ObjectOutputStream(os);
            for (Cliente i : Lista) {
                escribir.writeObject(i);
            }
            os.close();
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
        try {
            InputStream os = new FileInputStream(archivo);
            try (ObjectInputStream leer = new ObjectInputStream(os)) {
                try {
                    while (true) {
                        ListaClientes.add((Cliente) leer.readObject());
                    }
                } catch (EOFException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
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
