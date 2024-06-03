package control;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Empleado;

public class ManejoArchivosEmpleado implements ManejoArchivos<Empleado>, Serializable {

    @Override
    public void SobreEscribirListas(String NombreUbicacion, List<Empleado> Lista) {
        File archivo = new File(NombreUbicacion);
        try (ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(archivo))) {
            escribir.writeObject(Lista);
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
        try (ObjectInputStream leer = new ObjectInputStream(new FileInputStream(archivo))) {
            while (true) {
                try {
                    ListaEmpleados = (List<Empleado>) leer.readObject();
                    leer.close();
                } catch (EOFException e) {
                    e.printStackTrace(System.out);
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
        return ListaEmpleados;
    }

    @Override
    public boolean VerificarArchivo(String NombreUbicacion) {
        File archivo = new File(NombreUbicacion);
        return archivo.exists();

    }

}
