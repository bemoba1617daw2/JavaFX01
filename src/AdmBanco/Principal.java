package AdmBanco;


import java.util.*;
import java.util.Scanner;
import java.lang.Object;

/**
 * Clase Principal
 * Contiene el main, el registro/autentificación de los usuarios y métodos 
 * para interaccionar con las demás clases
 * @author Laura Bujalance Aaron Salvador David Ramirez
 */
public class Principal {
    /**
    * Atributo estático que se utiliza para salir o entrar 
    * dentro del bucle del menú de opciones 
    */
    public static boolean salida = true;
    
    /** 
    * Método main donde se desarolla el programa 
    * @param args
    */
    public static void main (String[] args){

          EntidadFinanciera Bancolacaixa = new EntidadFinanciera ("lacaixa", "españa",2100);
          Cliente.entidades.add(Bancolacaixa);
          Cliente usuari2 = new Cliente("Bernat","Montoro",20,111111111,"12345678x","123");
          Cliente usuari3 = new Cliente("Laura","Bujalance",28,222222222,"87654321x","456");
          Cliente usuari4 = new Cliente("Sergio","Martinez",19,333333333,"12312312x","789");
          Empleado empleado1 = new Empleado("1234","manolo","45645645x","456");
          Cuenta.clientes.add(usuari2);
          Cuenta.clientes.add(usuari3);
          Cuenta.clientes.add(usuari4);
          Cuenta c1 =  new Cuenta(123456789,true, 2100,1313,"12345678x" );
          Cuenta c2 = new Cuenta( 987654321, true, 2100, 1313,"87654321x" );
          Cuenta c3 = new Cuenta( 123123123, true, 2100, 1313, "12312312x");
          Cliente.cuentas.add(c1);
          c1.setIBAN("ES"+2100+1313+43+123456789);
          Cliente.cuentas.add(c2);
          c2.setIBAN("ES"+2100+1313+34+987654321);
          Cliente.cuentas.add(c3);
          c3.setIBAN("ES"+2100+1313+57+123123123);
          
       do{
          Principal.salida =true;
          Scanner entrada = new Scanner(System.in);
          System.out.println("\t\t--------Bienvenido al servicio de la caixa-------\n "
                  + "\nSi no está registrado introduzca la palabra Registro, en caso contrario presione enter."
                  + "\nEscriba Exit para salir.");
          //Prueba de compareTO(Comparator) de cliente
          System.out.println("Comparator" + usuari2.compareTo(usuari3));
          //
          //Prueba de compareTO(Comparable) de cuenta
          System.out.println("Comparable" + c1.compareTo(c3));
          //
          String usuario = entrada.nextLine();
          if(usuario.equalsIgnoreCase("Exit")) System.exit(0); //salida del programa
          if(usuario.equalsIgnoreCase("Registro")){//inicio del registro nuevo usuario
                System.out.println("Bienvenido al servicio de Banca, hace falta introducir unos datos para comenzar, sigue las instrucciones:");
                System.out.println("Introduce tu NIF (ej: 12345678X) (9 caracters):");
                String nif = entrada.nextLine();
                  while (nif.length()!=9){ //comprovación longitud 9
                      System.out.println("Tiene que tener 9 caracters ...Introduce el NIF: (ej: 12345678X)"); 
                      nif = entrada.nextLine();}
                System.out.println("Nombre?");
                String nom = entrada.nextLine();
                System.out.println("Apellidos?");
                String apellidos = entrada.nextLine();
                System.out.println("Edad?");
                String edadsc = entrada.nextLine();
                     while(!isInteger(edadsc)) {//comprovación edad es integer
                        System.out.println("Tiene que ser un número... Dime tu Edad?");
                        edadsc = entrada.nextLine();  }
                int edad = Integer.parseInt(edadsc);
                System.out.println("Introduzca una contraseña para su cuenta: ");
                String pass = entrada.nextLine();
                System.out.println("telefono? (9 dígitos)");
                int telefon = entrada.nextInt();
                    while ( Integer.toString(telefon).length()!=9){//comprovación longitud 9
                         System.out.println("Tiene que tener 9 dígitos ...Introduce el telefono"); 
                         telefon = entrada.nextInt();}
                String captura = entrada.nextLine();//captura teclado scanner para evitar error

                if (edad<18){ //comprovación si usuario es menor sale del programa
                    System.out.println("Lo siento pero eres menor de edad no puedes utilizar este servicio");
                    System.exit(0);
                    }           
                //INICIO USUARIO CREADO    
                Cliente usuari1 = new Cliente(nom,apellidos,edad,telefon,pass,nif);
                Cuenta.clientes.add(usuari1);
            }
           
              //Identificacion de los usuarios
              System.out.println("-------Identificación-------\n"
                                 + "Introduzca su NIF para iniciar sesión: ");
              String nif2 = entrada.nextLine();
              System.out.println("Pass: ");
              String pass2 = entrada.nextLine();
                            if(nif2.equalsIgnoreCase("AdminAdmin")) Admin();// indentificación usuario Admin menu de admin      
            //usuario existe?
             boolean noexiste = true;//comprovación de identificación erronea
                 for(int z=0;z<Cuenta.clientes.size();z++) {
                        if(Cuenta.clientes.get(z).getNIF().equals(nif2) && Cuenta.clientes.get(z).Password.equals(pass2)){//si el nif y contraseña ok, puede pasar
                        System.out.println(Cuenta.clientes.get(z));//muestra tostring de ese usuario
                        noexiste=false;
                             do {  
                                 System.out.println("\n\n\t\t-------Bienvenido al Menu "+Cuenta.clientes.get(z).getNombre()+
                                            " -------\nIntroduce el numero de la opción: ");
                                               
                                Scanner selector = new Scanner(System.in);
                                System.out.println("0. Salir");
                                System.out.println("1. Crear nueva Cuenta Corriente");
                                System.out.println("2. Crear nueva Cuenta Ahorro");
                                System.out.println("3. Retirar de una cuenta existente");
                                System.out.println("4. Ingresar dinero");
                                System.out.println("5. Ver cuentas tuyas");
                                System.out.println("6. Ver tus Operaciones Realizadas");
                                System.out.println("7. Transferencia");
                                int Opcion = selector.nextInt();
                                //función para realizar operaciones habituales
                                seleccionar(Opcion,Cuenta.clientes.get(z),Cuenta.clientes.get(z).getNIF());
                                }while (Principal.salida);
                            }
                  }
               if(noexiste){ // si la identificación ha fallado 
                  System.out.println("Identidificación Fallida");}
             
                 
          }while(true);
    }
    
    
    /** 
    * Metodo estatico que ejecuta una funcion dependiendo de la opción que se ha seleccionado
    * @param opcion la opción seleccionada
    * @param n entrada del arraylist del cliente que este en este momento en el programa
    * @param nif el nif del usuario que este en este momento
    */
    public static void seleccionar(int opcion, Cliente n,String nif){
        boolean noexistecuenta =true; 
        boolean cuentaahorro=false;
        switch (opcion){
            case 0: Principal.salida =false;
            break;
            case 1: System.out.println("CREAR");
                    Cliente.CrearCuenta(n);          
            break;
            case 3: 
                    System.out.println("------Servicio para RETIRAR dinero de una cuenta suya------");
                    Scanner entrada = new Scanner(System.in);
                    System.out.println("Numero de su cuenta de la que quiere retirar?");
                    int Numerocuenta = entrada.nextInt();
                    System.out.println("Cuanto dinero quieres sacar?");
                    float dinero = entrada.nextInt();
                    noexistecuenta=true;
                    
                    for(int z=0;z<Cliente.cuentas.size();z++) {
                        if((Cliente.cuentas.get(z).getNIF().equals(nif)) && (Cliente.cuentas.get(z).getNumerocuenta()==Numerocuenta)){
                            noexistecuenta =false;
                            Cliente.cuentas.get(z);//Realizamos método retirar en la cuenta
                            DetallesOperaciones detalles = new DetallesOperaciones(nif,Cliente.cuentas.get(z).getNumerocuenta(),dinero,Cliente.cuentas.get(z).VerSaldo(),"Retirar", Fecha.getFechaActual());
                            //añadimos los detalles de la operación en un array
                            DetallesOperaciones.detalles.add(detalles);
                            System.out.println("Actualizacion estado de la cuenta: "+Cliente.cuentas.get(z).getNumerocuenta());
                            System.out.println("Su saldo actual es de : "+Cliente.cuentas.get(z).getSaldo());
                            }           
                        }
                    if(noexistecuenta){ System.out.println("hay problemas con los datos introducidos");}
            break;
            case 4: 
                    System.out.println("------Servicio para INGRESAR dinero ------");
                    Scanner entrada3 = new Scanner(System.in);
                    System.out.println("Numero de tu cuenta?");
                    int Numerocuenta3 = entrada3.nextInt();
                    System.out.println("Cuanto dinero vas a ingresar?");
                    float dinero3 = entrada3.nextInt();
                    noexistecuenta=true;
                    for(int z=0;z<Cliente.cuentas.size();z++) {
                        if(Cliente.cuentas.get(z).getNIF().equals(nif) && Cliente.cuentas.get(z).getNumerocuenta()==Numerocuenta3){
                            noexistecuenta =false;
                            Cliente.cuentas.get(z).Ingresar(dinero3);
                            DetallesOperaciones detalles = new DetallesOperaciones(nif,Cliente.cuentas.get(z).getNumerocuenta(),dinero3,Cliente.cuentas.get(z).VerSaldo(),"Ingresar", Fecha.getFechaActual());
                            DetallesOperaciones.detalles.add(detalles);
                            System.out.println("Actualizacion estado de la cuenta: "+Cliente.cuentas.get(z).getNumerocuenta());
                            System.out.println("Su saldo actual es de : "+Cliente.cuentas.get(z).getSaldo());             
                            }
                        }
                    if(noexistecuenta){ System.out.println("hay problemas con los datos introducidos");}
            break;        
            case 5:
                   System.out.println("----Ver tus cuentas---- "); 
                    for(int z=0;z<Cliente.cuentas.size();z++) {
                        if(Cliente.cuentas.get(z).getNIF().equals(nif)){
                        System.out.println(Cliente.cuentas.get(z));
                        }
                    }       
            break;
                
            case 6:
                    Scanner entrada4 = new Scanner(System.in);
                    System.out.println("Numero de su cuenta?");
                    int DetalleNumC = entrada4.nextInt();
                    System.out.println("----Ver tus Operaciones Realizadas---- ");
                    Collections.sort(DetallesOperaciones.detalles,Collections.reverseOrder());
                    noexistecuenta=true;
                    for(int x=0;x<DetallesOperaciones.detalles.size();x++) {
                         if((DetallesOperaciones.detalles.get(x).getNIF().equals(nif)) && DetallesOperaciones.detalles.get(x).getNumerocuenta()==DetalleNumC){
                             System.out.println(DetallesOperaciones.detalles.get(x));
                             noexistecuenta =false;  
                         }
                    }
                    if(noexistecuenta){ System.out.println("hay problemas con los datos introducidos");}
            break;
            
            case 7:
                    Scanner entrada5 = new Scanner(System.in);
                    System.out.println("De cual de tus cuenta quieres retirar Dinero?");
                    int NumCuenta = entrada5.nextInt();
                    System.out.println("A que cuenta quieres transferir el dinero?");
                    int NumCuenta2 = entrada5.nextInt();
                    System.out.println("Cuanto dinero quieres transferir?");
                    float tdinero = entrada5.nextFloat();
                    noexistecuenta=true;
                    boolean noexistecuenta2=false;

                     for(int i=0;i<Cliente.cuentas.size();i++) {
                         if(Cliente.cuentas.get(i).getNumerocuenta()==NumCuenta2){
                             Cliente.cuentas.get(i).Saldo+=tdinero;
                             DetallesOperaciones detalles2 = new DetallesOperaciones(Cliente.cuentas.get(i).getNIF(),Cliente.cuentas.get(i).getNumerocuenta(),tdinero,Cliente.cuentas.get(i).VerSaldo(),"Transferencia cuenta destino", Fecha.getFechaActual());
                             DetallesOperaciones.detalles.add(detalles2);
                             noexistecuenta2=true;
                         }                 
                    }
                   if(noexistecuenta2){
                    for(int z=0;z<Cliente.cuentas.size();z++) {
                         if((Cliente.cuentas.get(z).getNIF().equals(nif)) && Cliente.cuentas.get(z).getNumerocuenta()==NumCuenta){
                             Cliente.cuentas.get(z).Saldo-=tdinero;
                             DetallesOperaciones detalles = new DetallesOperaciones(nif,Cliente.cuentas.get(z).getNumerocuenta(),tdinero,Cliente.cuentas.get(z).VerSaldo(),"Tranferencia cuenta origen", Fecha.getFechaActual());
                             DetallesOperaciones.detalles.add(detalles);
                             noexistecuenta =false;  
                         }
                    }
                   }
                    if(noexistecuenta){ System.out.println("hay problemas con los datos introducidos");
                    }else{
                    
                        
                    }
            break;
        }                   
    }

    /** 
    * Metodo estático que comprueba que el parámetro introducido es un entero
    * @param s el parametro entrado
    * @return isValidInteger devuelve un boolenado dependiendo si es o no un entero
    */
    public static boolean isInteger(String s) {
      boolean isValidInteger = false;
      try{
         Integer.parseInt(s);
         // es integer
         isValidInteger = true;}
      catch (NumberFormatException ex){
         // no es integer
      }return isValidInteger;  
    }
    
    /** 
    * Metodo estático que abre un terminal especial para el administrador,
    * puede ver todas las cuentas, todos los usuarios y las operaciones
    */
    public static void Admin(){
        boolean salir = true;
        do{
    Scanner entradadmin = new Scanner(System.in);
        System.out.println("-----Menu Admin----\n"
                + "1- Muestra todos los clientes\n"
                + "2- Muestra todas las cuentas\n"
                + "3- Registro de operaciones por fecha\n"
                + "4- Registro de operaciones por importe\n"
                + "0- Salir");
        int opcio = entradadmin.nextInt();
        switch(opcio){
            case 0: salir=false;
                break; 
            case 1:
                for(int z=0;z<Cuenta.clientes.size();z++) {
                        System.out.println(Cuenta.clientes.get(z));
                        }
                
                break;
            case 2:
                for(int z=0;z<Cliente.cuentas.size();z++) {
                        System.out.println(Cliente.cuentas.get(z));
                        }
                
                break;
            case 3: // registro de operaciones por fecha
                    for(int z=0;z<DetallesOperaciones.detalles.size();z++) {
                             System.out.println(DetallesOperaciones.detalles.get(z));}
                break;
            case 4:
                // registro de operaciones por saldo
                Collections.sort(DetallesOperaciones.detalles,Collections.reverseOrder());
                    for(int z=0;z<DetallesOperaciones.detalles.size();z++) {
                             System.out.println(DetallesOperaciones.detalles.get(z));}
                break; 
            }
    
        }while(salir);
    
    }

    private static int generadorIBAN(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
