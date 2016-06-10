package Model;

/**
 * Created by Leonardo on 09/06/2016.
 */
        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.logging.Level;
        import java.util.logging.Logger;

public class Services {


    public Usuario getUser(int userid) {
        Usuario user = null;
        Connection con = null;

        try {

            String query = "select * from estudiante where id = ?";
            con = DBcontext.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);

            prepareStatement.setInt(1, userid);

            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                user = new Usuario();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAdministrator(rs.getBoolean("admin"));
                user.setAutor(rs.getBoolean("autor"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return user;
    }

    public Usuario getUser(String userid) {
        Usuario user = null;
        Connection con = null;

        try {

            String query = "select * from estudiante where id = ?";
            con = DBcontext.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);

            prepareStatement.setInt(1, userid);

            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                user = new Usuario();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAdministrator(rs.getBoolean("admin"));
                user.setAutor(rs.getBoolean("autor"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return user;
    }

    public boolean crearUsuario(Usuario user){
        boolean ok = false;

        Connection con = null;
        try {

            String query = "insert into estudiante(username, password, admin, autor) values(?,?,?,?)";
            con = DBcontext.getInstancia().getConexion();

            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar paso los parametros.
            prepareStatement.setString(1, user.getUsername());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setBoolean(3, user.isAdministrator());
            prepareStatement.setBoolean(4, user.isAutor());

            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }

    public Usuario authUser (String username, String password ){
        Usuario user = getUser(username);
        if (user.getPassword().equalsIgnoreCase(password) && user.getUsername().equalsIgnoreCase(username)){
            return user;
        }
        return null;
    }
/*
    public boolean actualizarUsuario(Usuario est){
        boolean ok =false;

        Connection con = null;
        try {

            String query = "update estudiante set nombre=?, apellido=?, carrera=?, telefono=? where matricula = ?";
            con = DBcontext.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, est.getNombre());
            prepareStatement.setString(2, est.getApellido());
            prepareStatement.setString(4, est.getTelefono());
            prepareStatement.setString(3, est.getCarrera());
            //Indica el where...
            prepareStatement.setInt(5, est.getMatricula());
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }

    public boolean borrarEstudiante(int matricula){
        boolean ok =false;

        Connection con = null;
        try {

            String query = "delete from estudiante where matricula = ?";
            con = DBcontext.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);

            //Indica el where...
            prepareStatement.setInt(1, matricula);
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return ok;
    }
*/

    public List<Articulo> articulosList() { 
        List<Articulo> lista = new ArrayList<>();
        Connection con = null;
        try {

            String query = "select * from estudiante";
            con = DBcontext.getInstancia().getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            while(rs.next()){
                Articulo art = new Articulo();
                art.setId(rs.getInt("id"));
                art.setTitulo(rs.getString("titulo"));
                art.setCuerpo(rs.getString("cuerpo"));
                art.setUsuario(getUser(rs.getInt("autor")));
                art.setFecha(rs.getDate("fecha"));
                lista.add(art);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }


}  

