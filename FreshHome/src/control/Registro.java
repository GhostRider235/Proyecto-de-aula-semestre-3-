
package control;

import java.util.List;
import java.util.Map;
import model.Persona;

public interface Registro<T> {
    
    public void registro(T persona,Map<Persona,String> Acceso, List<T> Lista) ;
    
    public float CalificacionFinal(List<Integer> calificaciones);
}
