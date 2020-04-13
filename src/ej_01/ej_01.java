package ej_01;
import gestores.GestorDataBase;

public class ej_01 {

   public static void main(String[] args) {
	   
        //Creamos un objeto con los datos de nuestra conexión
        gestores.GestorDataBase miConn = new GestorDataBase(
                "practicas"
                , "root"
                , "admin" 
                , "jdbc:mysql://localhost/");
        
        //nos conectamos
        if (miConn.abrirConexion()) {
            System.out.println("CONECTADOS !!!!!    ");
//	            String sentencia = "CREATE TABLE alumnos ("
//	                    + "id       INT AUTO_INCREMENT, "
//	                    + "PRIMARY KEY(id),"
//	                    + "nombre   VARCHAR(20),"
//	                    + "telefono VARCHAR(20)"
//	                    + ");";
            
            //EJECUTAMOS ESTA SENTENCIA
            int id = 5;
            String nombre = "Marta";
            String apellido = "Torres";
            String ciudad = "Lerida";
            
            String sentencia = "INSERT "
                    + "INTO alumno "
                    + "VALUES (" + id + ", '" + nombre  + "', '" + apellido +"', '" + ciudad  + "');";
            
            miConn.ejecutaUpdate(sentencia);
            miConn.cerrarConexion();
            
        } else {
            System.out.println("Lo siento mucho :(");
        }
    }
}
