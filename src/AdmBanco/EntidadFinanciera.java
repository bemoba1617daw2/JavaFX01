package AdmBanco;


import java.util.*;

/**
 * Clase Entidad Financiera
 * Contiene la información de la entidad financiera
 * @author Laura Bujalance Aaron Salvador David Ramirez
 */
public class EntidadFinanciera {
    /**
     * Nombre entidad financiera
     */
    public String Nombre;
   /**
    * Pais entidad financiera
    */
    public String Pais;
    /**
     * Codigo entidad financiera
     */
    public int CodigoEntidad;

    /**
     * Creación del constructor
     * @param Nombre nombre de la entidad financiera
     * @param Pais país entidad financiera
     * @param CodigoEntidad código de la entidad financiera
     */

    public EntidadFinanciera(String Nombre, String Pais, int CodigoEntidad) {
        this.Nombre = Nombre;
        this.Pais = Pais;
        this.CodigoEntidad = CodigoEntidad;
    }

      /**
       * Método que devuelve el nombre de la entidad financiera
       * @return Nombre 
       */
    
    public String getNombre() {
        return Nombre;
    }
    /**
     * Método que devuelve el pais de la entidad financiera
     * @return Pais
     */
    public String getPais() {
        return Pais;
    }
    /**
     * Método que devuelve el código de la entidad financiera
     * @return CodigoEntidad
     */
    public int getCodigoEntidad() {
        return CodigoEntidad;
    }
    /**
     * Método que modifica el valor del atributo Nombre de la entidad financiera
     * @param Nombre nombre entidad financiera
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    /**
     * Método que modifica el valor del atributo Pais de la entidad financiera
     * @param Pais pais entidad financiera
     */
    public void setPais(String Pais) {
        this.Pais = Pais;
    }
/**
 * Método que modifica el valor del atributo CodigoEntidad de la entidad financiera
 * @param CodigoEntidad codigo entidad financiera
 */
    public void setCodigoEntidad(int CodigoEntidad) {
        this.CodigoEntidad = CodigoEntidad;
    }
/**
 * Método que muestra la información completa de un objeto
 * @return Nombre, Pais, CodigoEntidad
 */
    @Override
    public String toString() {
        return "EntidadFinanciera{" + "Nombre=" + Nombre + ", Pais=" + Pais + ", CodigoEntidad=" + CodigoEntidad + '}';
    }
    
    
    
    
}