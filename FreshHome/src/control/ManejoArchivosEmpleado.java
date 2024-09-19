package control;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Empleado;

public class ManejoArchivosEmpleado implements ManejoArchivos<Empleado> {

    @Override
    public void SobreEscribirListas(String NombreUbicacion, List<Empleado> Lista) {
        File archivo = new File(NombreUbicacion);
        try (
                FileOutputStream os = new FileOutputStream(archivo); ObjectOutputStream escribir = new ObjectOutputStream(os);) {

            escribir.writeObject(Lista);
            System.out.println("Lista modificada.");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public List<Empleado> LeerListasArchivo(String NombreUbicacion) {
        File archivo = new File(NombreUbicacion);
        List<Empleado> ListaEmpleados = new ArrayList<>();

        try (
                FileInputStream os = new FileInputStream(archivo); 
                ObjectInputStream leer = new ObjectInputStream(os);
            ) {
            ListaEmpleados = (List<Empleado>) leer.readObject();
        } catch (EOFException e) {
            e.printStackTrace(System.out);
            System.out.println("El archivo no tiene nada.");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
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
