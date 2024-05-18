package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Empleado;

public class ManejoArchivosEmpleado implements ManejoArchivos<Empleado> {


    @Override
    public void SobreEscribirListas(String NombreUbicacion, List<Empleado> Lista) {
        File archivo = new File(NombreUbicacion);
        try {
            OutputStream os = new FileOutputStream(archivo);
            ObjectOutputStream escribir = new ObjectOutputStream(os);
            for (Empleado e : Lista) {
                escribir.writeObject(os);
            }
            escribir.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);

        }

        System.out.println("Lista modificada.");

    }

    @Override
    public List<Empleado> LeerListasArchivo(String NombreUbicacion) {

        File archivo = new File(NombreUbicacion);
        List<Empleado> ListaEmpleados = new ArrayList<>();
        try {
            InputStream os = new FileInputStream(archivo);
            ObjectInputStream leer = new ObjectInputStream(os);
            while (true) {
                ListaEmpleados.add((Empleado) leer.readObject());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        return ListaEmpleados;

    }

    @Override
    public boolean VerificarArchivo(String NombreUbicacion) {
        File archivo = new File(NombreUbicacion);
        return archivo.exists();

    }

}
