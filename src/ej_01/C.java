package ej_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class C {

	public static void main(String[] args) {

		// conexiones
		Connection conexion1 = null;
		Connection conexion2 = null;
		Connection conexion3 = null;

		// usuario y clave
		String user = "root";
		String password = "admin";
		try {

			
			// una sola cadena de conexi�n, en un s�lo par�metro se concatena el
			// usuario y el password
			String url1 = "jdbc:mysql://localhost:3306/practicas" + " user= " + user + " pasword= " + password;
			conexion1 = DriverManager.getConnection(url1);
			if (conexion1 != null) {
				System.out.println("Conexi�n 1: Conexi�n a mibase satisfacoria");
			}
			

			// se env�a la cadena y los datos de usuario y password por separado
			Properties datos = new Properties();
			datos.put("user", user);
			datos.put("password", password);
			String url2 = "jdbc:mysql://localhost:3306/practicas";
			conexion2 = DriverManager.getConnection(url2, datos);
			if (conexion2 != null) {
				System.out.println("Conexi�n 2: Conexi�n a mibase satisfacoria");
			}

			// se env�a la cadena, el usuario y el password por separado
			String url3 = "jdbc:mysql://localhost:3306/practicas";
			conexion3 = DriverManager.getConnection(url3, user, password);
			if (conexion3 != null) {
				System.out.println("Conexi�n 3: Conexi�n a mibase satisfacoria");
			}
		} catch (SQLException e) {
			System.out.println(
					"Error en la conexi�n, verifique, su usuario y password o el nombre de la base a la que intenta conectarse");
			e.printStackTrace();
		}
	}
}