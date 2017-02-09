package AdmBanco;

import java.util.*;

/*
 * @author semamu
 */
public class Empleado extends Usuario{
    
    private String CodiEmpleado;
    private String Username;
    
    public Empleado(String CodiEmpleado, String Username, String NIF, String Password) {
        super(NIF, Password);
        this.CodiEmpleado = CodiEmpleado;
        this.Username = Username;
    }

    public String getCodiEmpleado() {
        return CodiEmpleado;
    }

    public void setCodiEmpleado(String CodiEmpleado) {
        this.CodiEmpleado = CodiEmpleado;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    @Override
    public String toString() {
        return "Empleado{" + "CodiEmpleado=" + CodiEmpleado + ", Username=" + Username + '}';
    }
       
}
