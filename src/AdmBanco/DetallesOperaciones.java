package AdmBanco;


import java.util.*;
/**
 * Clase DetallesOperaciones
 * Contiene la información de los detalles de la operacion
 * @author Laura Bujalance Aaron Salvador David Ramirez
 */
public class DetallesOperaciones implements Comparable<DetallesOperaciones>{
    /**
     * NIF del cliente
     */
    private String NIF;
    /**
     * Número cuenta del cliente
     */
    private int Numerocuenta;
    /**
     * Importe de la operación
     */
    private double Importe;
    /**
     * Saldo de la cuenta
     */
    private double Saldo;
    /**
     * Tipo de operacion
     */
    private String Operacion;
    /**
     * Fecha de la operación
     */
    private String Fecha;
    
    /**
     * Lista de los detalles de operaciones
     */
    static ArrayList<DetallesOperaciones> detalles = new ArrayList<>();

    /**
     * Creación del constructor
     * @param NIF nif del cliente
     * @param Numerocuenta número de cuenta del cliente
     * @param Importe importe de la operación
     * @param Saldo saldo de la cuenta
     * @param Operacion tipo de operación
     * @param Fecha fecha de la operación
     */
    public DetallesOperaciones(String NIF, int Numerocuenta, double Importe, double Saldo, String Operacion, String Fecha) {
        this.NIF = NIF;
        this.Numerocuenta = Numerocuenta;
        this.Importe = Importe;
        this.Saldo = Saldo;
        this.Operacion = Operacion;
        this.Fecha = Fecha;
    }

    
    /**
     * Método que devuelve el NIF
     * @return NIF
     */
    public String getNIF() {
        return NIF;
    }
    /**
     *Método que modifica el valor del atributo NIF
     * @param NIF NIF del cliente
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }
    /**
     * Método que devuelve el Saldo 
     * @return Saldo
     */
    public double getSaldo() {
        return Saldo;
    }
    /**
     * Método que modifica el valor del atributo Saldo
     * @param Saldo Saldo de la cuenta
     */
    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    /**
     * Método que devuelve el tipo de operación
     * @return tipo de operacion
     */
    public String getOperacion() {
        return Operacion;
    }
    /**
     * Método que modifica el valor del atributo Operación
     * @param Operacion tipo de operación
     */
    public void setOperacion(String Operacion) {
        this.Operacion = Operacion;
    }
    /**
     * Método que devuelve la fecha de la operación
     * @return Fecha
     */
    public String getFecha() {
        return Fecha;
    }
    /**
     * Método que modifica el valor del atributo Fecha
     * @param Fecha fecha de la operación
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    /**
     * Método que devuelve el número de cuenta del cliente
     * @return Numerocuenta
     */
    public int getNumerocuenta() {
        return Numerocuenta;
    }
    /**
     * Método que modifica el valor del atributo Numerocuenta
     * @param Numerocuenta numero cuenta cliente
     */
    public void setNumerocuenta(int Numerocuenta) {
        this.Numerocuenta = Numerocuenta;
    }
    /**
     * Método que devuelve el importe de la operación
     * @return Importe
     */
    public double getImporte() {
        return Importe;
    }
    /**
     * Método que modifica el valor del atributo Importe
     * @param Importe importe de la operación
     */
    public void setImporte(double Importe) {
        this.Importe = Importe;
    }
    
     
    /**
     * Método que muestra la información completa de un objeto
     * @return NIF, Numerocuenta, Importe, Saldo, Operacion, Fecha
     */
    @Override
    public String toString() {
        return "DetallesOperaciones{" + "NIF=" + NIF + ", Numerocuenta=" + Numerocuenta + ", Importe=" + Importe + ", Saldo=" + Saldo + ", Operacion=" + Operacion + ", Fecha=" + Fecha + '}';
    }

    /**
     * Metódo que compara los importes de dos objetos
     * @param operacion objeto
     * @return comparacion entre los dos importes 
     */

    @Override
    public int compareTo(DetallesOperaciones operacion) {
        
        DetallesOperaciones temp = (DetallesOperaciones) operacion;  
        
        return Double.valueOf(this.Importe).compareTo(Double.valueOf(temp.Importe));
      
    }

}
