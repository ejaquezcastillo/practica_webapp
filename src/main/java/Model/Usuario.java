package Model;

/**
 * Created by Leonardo on 09/06/2016.
 */
public class Usuario {

    private String username;
    private String nombre;
    private String password;
    private boolean administrator;
    private boolean autor;

    public Usuario(String username, String nombre, String password, boolean autor, boolean administrator) {
        this.username = username;
        this.nombre = nombre;
        this.password = password;
        this.autor = autor;
        this.administrator = administrator;
    }

    public Usuario(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public boolean isAutor() {
        return autor;
    }

    public void setAutor(boolean autor) {
        this.autor = autor;
    }


}
