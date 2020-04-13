package gestores;

import java.sql.*;

/**
 *
 * @author Profesor
 */
public class GestorDataBase {
    private String db; 				//base de datos a la que me conecto
    private String login; 			//usuario que realiza la conexi�n
    private String password; 		//seguridad a nivel m�ximo
    private String servidorMysql; 	//Servido donde se encuentra la base de datos
    private Connection conexion;

    public GestorDataBase(String db, String login, String password, String servidorMysql) {
        this.db = db;
        this.login = login;
        this.password = password;
        this.servidorMysql = servidorMysql;
        this.conexion = null;
    }
    
    public boolean abrirConexion() {
        try {
            //Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Crear la conexi�n
			conexion = DriverManager.getConnection(servidorMysql + db + "?serverTimezone=UTC", login, password);        
        	
            return true;
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Has puesto la librer�a??");
        } catch (SQLException ex) {
            System.out.println("Usuario, o base de datos, o pass incorrectos");
        }
        return false;
    }
    
    public void cerrarConexion() {
        try {
            if (conexion != null) {
                conexion.close();
            } 
        } catch (SQLException ex) {
            System.out.println("problema al cerrar la conexi�n. "
                    + "Comprueba la integridad de los datos");
        }
    }
    
    public int ejecutaUpdate(String sentencia) {
        //devuelve el n�mero de registros que ha insertado/actualizado
        System.out.println("Ejecutamos: " + sentencia);
        int n = 0;
        Statement st = null;
        try {
            st = conexion.createStatement();
            n = st.executeUpdate(sentencia);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return n;
    }

}
