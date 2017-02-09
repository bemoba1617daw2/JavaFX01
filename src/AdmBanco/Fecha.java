
package AdmBanco;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Clase Fecha
 * Contiene la información sobre la fecha de una operación
 * @author Laura Bujalance Aaron Salvador David Ramirez
 */
public class Fecha {
/**
 * Método que devuelve la fecha actual del sistema
 * @return fecha actual
 */
    public static String getFechaActual() {
        Date actual = new Date();
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formato.format(actual);
    }
    
}
