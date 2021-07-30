package conexionOracle;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {

	public static void main(String[] args) {
		try {
			// datos de la conexión
			String host = "localhost";
			int port = 1521;
			String db = "BASECURSO";
			String user = "C##santiago";
			String password = "password";

			// Crear conexión
			String url = String.format("jdbc:oracle:thin:@%s:%d/%s", host, port, db);

			java.sql.Connection myConnection = DriverManager.getConnection(url, user, password);

			// Crear objeto statement
			Statement myStatement = myConnection.createStatement();

			// Ejecutar SQl
			ResultSet myResultset = myStatement.executeQuery("SELECT * FROM mensajes");

			// Recorrer resultset
			while (myResultset.next()) {
				System.out.println(myResultset.getString("mensaje"));
			}

		} catch (Exception e) {
			System.out.println("Excepción" + e);

		}
	}
}