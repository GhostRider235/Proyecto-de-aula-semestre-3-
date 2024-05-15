package control;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ManejoArchivos<T> {

    default void CrearArchivo(String NombreUbicacion) {
        File archivo = new File(NombreUbicacion);
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println("Archivo creado.");

    }

    public void SobreEscribirListas(String NombreUbicacion, List<T> Lista);

    public List<T> LeerListasArchivo(String NombreUbicacion);

    public boolean VerificarArchivo(String NombreUbicacion);

}
