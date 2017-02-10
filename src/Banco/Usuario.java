package Banco;
 /**
 * @author semamu
 */
public abstract class Usuario {
    
    public String NIF;
    public String Password;

    public Usuario(String NIF, String Password) {
        this.NIF = NIF;
        this.Password = Password;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "NIF=" + NIF + ", Password=" + Password + '}';
    }
      
}
