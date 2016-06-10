package Model; /**
 * Created by Leonardo on 09/06/2016.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBcontext {




    /**
     * Created by vacax on 27/05/16.
     */
    

        private static DBcontext instancia;
        private String URL = "jdbc:h2:tcp://localhost/~/pruebaTep";

        /**
         *Implementando el patron Singlenton
         */
        private  DBcontext(){
            registrarDriver();
        }

        /**
         * Retornando la instancia.
         * @return
         */
        public static DBcontext getInstancia(){
            if(instancia==null){
                instancia = new DBcontext();
            }
            return instancia;
        }

        /**
         * Metodo para el registro de driver de conexión.
         */
        private void registrarDriver() {
            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public Connection getConexion() {
            Connection con = null;
            try {
                con = DriverManager.getConnection(URL, "sa", "");
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
        }

        public void testConexion() {
            try {
                getConexion().close();
                System.out.println("Conexión realizado con exito...");
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

