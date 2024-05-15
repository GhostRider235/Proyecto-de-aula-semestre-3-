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

public class ManejoArchivosEmpleado implements ManejoArchivos<Empleado> {

    static Empleado Convertir(String linea) {
        Empleado emp = new Empleado();

        return emp;
    }

    @Override
    public void SobreEscribirListas(String NombreUbicacion, List<Empleado> Lista) {
        File archivo = new File(NombreUbicacion);

        try {
            PrintWriter escribir = new PrintWriter(archivo);
            for (Empleado cliente : Lista) {
                escribir.println(cliente);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
        System.out.println("Lista modificada.");

    }

    @Override
    public List<Empleado> LeerListasArchivo(String NombreUbicacion) {

        File archivo = new File(NombreUbicacion);
        List<Empleado> ListaEmpleados = new ArrayList<>();
        try {
            BufferedReader leerLista = new BufferedReader(new FileReader(archivo));
            while (leerLista.readLine() != null) {
                String Linea = leerLista.readLine();
                ListaEmpleados.add(Convertir(Linea));

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
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
