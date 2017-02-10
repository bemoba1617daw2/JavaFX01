package Banco;

import Banco.Cliente;
import java.util.ArrayList;




public class Cuenta implements Comparable<Cuenta> {
    /**
     * Iban de la cuenta
     */
    private String IBAN;
    /**
     * Numero de la cuenta
     */
    private int Numerocuenta;
    /**
     * Saldo de la cuenta
     */
    double Saldo = 1000;
    /**
     * Estado de la cuenta activada/desactivada
     */
    private boolean EstadoCuenta;
    /**
     * NIF del cliente asociado a su cuenta
     */
    private String NIF;
    /**
     * Codigo de la entidad a la cual pertenece la cuenta
     */
    public int CodigoEntidad;
    /**
     * Codigo de la entidad que pertenece la cuenta
     */
    public int CodigoOficina;
    /**
     * Tipo de cuenta que es
     */
    public String tipo;
    /**
     * Lista de todos los clientes
     */
    static ArrayList <Cliente> clientes = new ArrayList<Cliente>();
    

    /**
     * Creación de constructor vacio
     * 
     */
    public Cuenta() {
    }
    /**
     * Creación del constructor
     * @param Numerocuenta Numero de la cuenta
     * @param EstadoCuenta Estado de la cuenta
     * @param CodigoEntidad Codigo de la entidad a la cual pertenece la cuenta
     * @param CodigoOficina Codigo de la entidad que pertenece la cuenta
     * @param NIF NIF del cliente asociado a su cuenta
     */
    public Cuenta(int Numerocuenta, boolean EstadoCuenta, int CodigoEntidad, int CodigoOficina,String NIF) {
        this.Numerocuenta = Numerocuenta;
        this.EstadoCuenta = EstadoCuenta;
        this.CodigoEntidad = CodigoEntidad;
        this.CodigoOficina = CodigoOficina;
        this.NIF = NIF;
    }
    
    /**
    * Método que devuelve el NIF del cliente
    * @return NIF del cliente
    */
    public String getNIF() {
        return NIF;
    }
    /** 
    * Método que modifica el valor del atributo NIF del cliente
    * @param NIF NIF del cliente
    */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }
    /** 
    * Método que modifica el valor del atributo IBAN de la cuenta
    * @param IBAN de la cuenta
    */
    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
    /**
    * Método que devuelve el IBAN de la cuenta
    * @return IBAN del cliente
    */
    public String getIBAN() {
        return IBAN;
    }
    /**
    * Método que devuelve el Numero de la cuenta
    * @return Numerocuenta del cliente
    */
    public int getNumerocuenta() {
        return Numerocuenta;
    }
    /**
    * Método que devuelve el Saldo de la cuenta
    * @return Saldo que dispone la cuenta
    */
    public double getSaldo() {
        return Saldo;
    }
    /** 
    * Método que modifica el valor del atributo Saldo de la cuenta
    * @param Saldo de la cuenta
    */
    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    
    /** 
     * Método que permite ingresar dinero a tu cuenta
    * @param cantidad el dinero que se quiere ingresar
    */    
    public void Ingresar(double cantidad){
     if(cantidad <0){
         System.out.println("La cantidad para ingresar no puede ser negativa");
     }else{
     Saldo+=cantidad;
     }
    }
    /**
    * Método que devuelve el Saldo actual de una cuenta
    * @return Saldo Saldo actual de la cuenta
    */ 
    public double VerSaldo(){ 
        return Saldo;
    }
    /**
    * Método que calcula el digito de control de una cuenta
    * @param CodigoOficina codigo de la oficina que pertenece
    * @param CodigoEntidad codigo de la entidad que pertenece
    * @param Numerocuenta numero de la cuenta
    */ 
    public static String DigitoControl(String CodigoOficina, String CodigoEntidad, String Numerocuenta){
        int temp;
        String dg1, dg2;
        temp = 0;

       temp += Integer.parseInt(CodigoEntidad.substring(0, 1)) * 4;
        temp += Integer.parseInt(CodigoEntidad.substring(1, 2)) * 8;
        temp += Integer.parseInt(CodigoEntidad.substring(2, 3)) * 5;
        temp += Integer.parseInt(CodigoEntidad.substring(3, 4)) * 10;
        temp += Integer.parseInt(CodigoOficina.substring(0, 1)) * 9;
        temp += Integer.parseInt(CodigoOficina.substring(1, 2)) * 7;
        temp += Integer.parseInt(CodigoOficina.substring(2, 3)) * 3;
        temp += Integer.parseInt(CodigoOficina.substring(3, 4)) * 6;

        temp = 11 - temp % 11;
        if (temp == 10){
            dg1 = String.valueOf(1);
        } else if (temp == 11) {
            dg1 = String.valueOf(0);
        } else {
            dg1 = String.valueOf(temp);
        }
        temp = 0;


      temp += Integer.parseInt(Numerocuenta.substring(0, 1)) * 1;
        temp += Integer.parseInt(Numerocuenta.substring(1, 2)) * 2;
        temp += Integer.parseInt(Numerocuenta.substring(2, 3)) * 4;
        temp += Integer.parseInt(Numerocuenta.substring(3, 4)) * 8;
        temp += Integer.parseInt(Numerocuenta.substring(4, 5)) * 5;
        temp += Integer.parseInt(Numerocuenta.substring(5, 6)) * 10;
        temp += Integer.parseInt(Numerocuenta.substring(6, 7)) * 9;
        temp += Integer.parseInt(Numerocuenta.substring(7, 8)) * 7;
        temp += Integer.parseInt(Numerocuenta.substring(8, 9)) * 3;

        temp = 11 - temp % 11;
        if (temp == 10) {
            dg2 = String.valueOf(1);
        } else if (temp == 11) {
            dg2 = String.valueOf(0);
        } else {
            dg2 = String.valueOf(temp);
        }
        return String.valueOf(dg1) + String.valueOf(dg2);
    }

    /**
    * Método que muestra la información completa de un objeto
    * @return IBAN de la cuenta, Numerocuenta Numero de la Cuenta, Saldo el dinero de la cuenta, Saldo el dinero de la cuenta, NIF el NIF del cliente de la cuenta, CodigoEntidad el codigo de la entidad que pertenece la cuenta, 
    * CodigoOficina el codigo de la oficina de la cuenta, tipo el tipo de cuenta que es
    */
    @Override
    public String toString() {
        return "Cuenta{" + "IBAN=" + IBAN + ", Numerocuenta=" + Numerocuenta + ", Saldo=" + Saldo + ", EstadoCuenta=" + EstadoCuenta + ", NIF=" + NIF + ", CodigoEntidad=" + CodigoEntidad + ", CodigoOficina=" + CodigoOficina + ", tipo=" + tipo + '}';
    }
    
    public  String generadorIBAN(String nCuenta){
       			   
                 String[] cuenta_banco = nCuenta.split("\\s");
                           
                    int[] lacaixa = {8,4,5,7,9,6,2,4};
                    
                    int[] nBA = new int[8];
                    int[] nCC = new int[10];
                    String NumBA = "";
                    String NumCC = "";
                    int[] nBaPesos = {4,8,5,10,9,7,3,6};
                    int[] nCcPesos = {1,2,4,8,5,10,9,7,3,6};
                    int nSumaBA=0,nSumaCC=0;
                    ArrayList<Integer> szN = new ArrayList<>();      
                    int n,digito1,digito2,r,r2,Rresultado,Rresultado2;
                    
                    for(Integer p : lacaixa){
                    	szN.add(p);
                    }
                    
                    for(String p : cuenta_banco){
                        int x = Integer.parseInt(p);
                    	szN.add(x);
                    }
                int x=0;  	
            	for(n = 0; n < 8 ; n++){
            		nBA[x] = (szN.get(n));
                        x++;
            	}
            
                 x=0;
            	for(n = 8; n < 18 ; n++){
            		nCC[x] = (szN.get(n));
                    x++;
            	}
            	
            	for(n = 0; n < 8 ; n++){
            		nSumaBA += nBA[n]*nBaPesos[n];
            	}
            	for(n = 0; n < 10 ; n++){
            		nSumaCC += nCC[n]*nCcPesos[n];
            	}
            	//DIGITO BA
            	r=nSumaBA%11;
            	Rresultado=11-r;
            	if (Rresultado<10){
            		digito1=Rresultado;
            	}else{	
            	if (Rresultado==11){
            		digito1=0;
            	}else{
            		digito1=1;
            		}
            	}
            	//DIGITO CC
            	r2=nSumaCC%11;
            	Rresultado2=11-r2;
            	if (Rresultado2<10){
            		digito2=Rresultado2;
            	}else{
            	if (Rresultado2==11){
            		digito2=0;
            	}else{
            		digito2=1;
            		}
            	}
                    
            	for(n = 0; n < 8 ; n++){
            		nSumaBA += nBA[n]*nBaPesos[n];
            		String y = String.valueOf(nBA[n]);
                        NumBA = NumBA.concat(y);
            	}
           
                    for(n = 0; n < 10 ; n++){
                       
            		nSumaCC += nCC[n]*nCcPesos[n];
            		 String z = String.valueOf(nCC[n]);
                         NumCC = NumCC.concat(z);
                            
            	}
                    
                     String d1 = String.valueOf(digito1);
                     String d2 = String.valueOf(digito2);
                     String CuentaCorriente = "";
                     CuentaCorriente = CuentaCorriente.concat("ES21 "+NumBA + " " + d1 + d2 +" " + NumCC); 
                     
                     //System.out.println(CuentaCorriente);
                     return CuentaCorriente;
    }
    
       
    /**
     * Comparable, entre dos cuentas entre sus numeros de cuenta
     * @param cuenta
     * @return 
     */
    
    @Override
    public int compareTo(Cuenta cuenta) {  
        return (this.Saldo < cuenta.Saldo ) ? -1: (this.Saldo > cuenta.Saldo ) ? 1:0 ;  
    }


}
