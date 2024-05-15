package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ManejoArchivosClientes implements ManejoArchivos<Cliente> {

    static Cliente Convertir(String linea) {
        Cliente objeto = new Cliente();

        return objeto;
    }

    @Override
    public void SobreEscribirListas(String NombreUbicacion, List<Cliente> Lista) {
        File archivo = new File(NombreUbicacion);

        try {
            PrintWriter escribir = new PrintWriter(archivo);
            for (Cliente cliente : Lista) {
                escribir.println(cliente);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println("Lista modificada.");
    }

    @Override
    public List<Cliente> LeerListasArchivo(String NombreUbicacion) {
        File archivo = new File(NombreUbicacion);
        List<Cliente> ListaClientes = new ArrayList<>();
        try {
            BufferedReader leerLista = new BufferedReader(new FileReader(archivo));
            while (leerLista.readLine() != null) {
                String Linea = leerLista.readLine();
                ListaClientes.add(Convertir(Linea));

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
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
