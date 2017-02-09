package AdmBanco;

import java.util.*;
import java.util.Scanner;

/**
 * Clase Cliente
 * Contiene la información de los clientes
 * 
 */
public class Cliente extends Usuario {
    /**
     * Nombre del cliente
     */
    private String Nombre;
    /**
     * Apellidos del cliente
     */
    private String Apellidos;
    /**
     * Edad del cliente
     */
    private int Edad;
    /**
     * Teléfono del cliente
     */
    private int Telefono;
    /**
     * Lista de todas las cuentas
     */
    static ArrayList<Cuenta> cuentas = new ArrayList<>();
    /**
     * Lista de las entidades financieras
     */
    static ArrayList<EntidadFinanciera> entidades = new ArrayList<>();
    /**
     * Creación del constructor
     * @param NIF NIF del cliente
     * @param Nombre Nombre del cliente
     * @param Apellidos Apellidos del cliente
     * @param Edad Edad del cliente
     * @param Telefono Teléfono del cliente
     */
    public Cliente(String Nombre, String Apellidos, int Edad, int Telefono, String NIF, String Password) {
        super(NIF, Password);
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Edad = Edad;
        this.Telefono = Telefono;
    }
    
      /**
       * Método que devuelve el Nombre del cliente
       * @return Nombre del cliente
       */
    public String getNombre() {
        return Nombre;
    }
      /**
       * Método que devuelve los Apellidos del cliente
       * @return Apellidos del cliente
       */
    public String getApellidos() {
        return Apellidos;
    }
     /**
       * Método que devuelve la edad del cliente
       * @return Edad del cliente
       */
    public int getEdad() {
        return Edad;
    }
   /**
       * Método que devuelve el teléfono del cliente
       * @return teléfono del cliente
       */
    public int getTelefono() {
        return Telefono;
    }
     
    /**
       * Método que modifica el valor del atributo Nombre del cliente
       * @param Nombre Nombre del cliente
       */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    /**
       * Método que modifica el valor del atributo Apellidos del cliente
       * @param Apellidos Apellidos del cliente
       */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
    /**
       * Método que modifica el valor del atributo Edad del cliente
       * @param Edad Edad del cliente
       */
    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    /**
       * Método que modifica el valor del atributo Telefono del cliente
       * @param Telefono Teléfono del cliente
       */
    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    /**
       * Método que crea un objeto de Cuenta Corriente
       * @param uncliente cliente quien crea la cuenta
       * 
       */
    
    public static void CrearCuenta(Cliente uncliente){
        
          boolean EstadoCuenta = true;     
          Scanner entrada = new Scanner(System.in);
          int NumeroCuenta = (int) (Math.random()*900000000+100000000);
          System.out.println("Numero de cuenta generado es : "+ NumeroCuenta+" Guárdelo para futuras operaciones");
        
           System.out.println("Codigo de su Oficina? (4 dígitos)");
                int CodigoOficina = entrada.nextInt();
                while ( Integer.toString(CodigoOficina).length()!=4){
                      System.out.println("Tiene que tener 4 dígitos ...Codigo de su Oficina"); 
                      CodigoOficina = entrada.nextInt();}
          
          Cuenta cuenta1 = new Cuenta(NumeroCuenta,EstadoCuenta,entidades.get(0).CodigoEntidad ,CodigoOficina,uncliente.NIF);        
          
          String DigitoControl = Cuenta.DigitoControl(String.valueOf(CodigoOficina),String.valueOf(entidades.get(0).CodigoEntidad),String.valueOf(NumeroCuenta));
          cuenta1.setIBAN("ES"+entidades.get(0).CodigoEntidad+CodigoOficina+DigitoControl+NumeroCuenta);
          
          Cliente.cuentas.add(cuenta1);
          
          System.out.println("CUENTA CREADA");
          
          System.out.println(cuenta1);
    }
    
   /** Método que muestra la información completa de un objeto
 * @return NIF del cliente, Nombre del cliente, Apellidos del cliente, Edad del cliente, Teléfono del cliente, Contraseña de acceso
 */
    @Override
    public String toString() {
        return "Cliente{" + "NIF=" + NIF + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Edad=" + Edad + ", Telefono=" + Telefono + '}';
    }
    
    /**
     * Metodo CompareTo, compara dos clientes mediante su NIF
     * @param arg0
     * @return 
     */
    public int compareTo(Object arg0) {
        Cliente cliente= (Cliente) arg0;
        return (!this.NIF.equals(cliente.NIF) ) ? -1: (this.NIF.equals(cliente.NIF) ) ? 1:0 ;
    }
      
}
