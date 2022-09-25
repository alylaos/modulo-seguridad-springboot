package pe.isil.moduloseguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.transform.Result;
import java.sql.*;

@SpringBootApplication
public class ModuloSeguridadApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ModuloSeguridadApplication.class, args);
		//cargar driver
		Class.forName("com.mysql.jdbc.Driver");
		//crear conexion
		Connection conexion = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/alyenterprise","root","root");

		testStatement(conexion);
		testPreparedStatement(conexion);
		testPreparedStatementResult(conexion);
		//cerrar conexion
		conexion.close();
	}
	public static void testStatement(Connection connection) throws Exception{
		//crear statement
		Statement statement = connection.createStatement();
		//ejecutar sentencia
		int afectedRows =statement.executeUpdate("update USERS set name='Jose where id=1");
		System.out.println("Filas afectadas: "+afectedRows);

		ResultSet resultSet = statement.executeQuery("select * from USERS");
		while (resultSet.next()){
			System.out.println(resultSet.getString("name"));
		}
		System.out.println("Filas afectadas: "+afectedRows);
	}
	public static void testPreparedStatement(Connection connection) throws Exception {
		PreparedStatement preparedStatement = connection.prepareStatement("update USERS set name=? where id=?");
		preparedStatement.setString(1,"Aly");
		preparedStatement.setInt(2,3);
		int affectedRows = preparedStatement.executeUpdate();
		System.out.println("Filas afectadas: "+affectedRows);
	}
	public  static void testPreparedStatementResult(Connection connection) throws Exception{
		PreparedStatement pt = connection.prepareStatement("select * from USERS where username=?");
		pt.setString(1,"DNI75504162");
		ResultSet rs = pt.executeQuery();
		while (rs.next()){
			System.out.println(rs.getString("name")+" "+rs.getString("username"));
		}
	}
	public static void testCallableStatement(Connection connection) throws Exception{

		CallableStatement cs = connection.prepareCall("{call getAllUsers()}");
		ResultSet rs = cs.executeQuery();

		while(rs.next()){
			System.out.println(rs.getString("name") + " " +
					rs.getString("lastname") + " " +
					rs.getString("username") + " " +
					rs.getString("pass") + " " +
					rs.getString("enable")
			);
		}
	}

	public static void loginByUsernameAndPass(Connection connection,String username,String pass) throws Exception{

		CallableStatement cs = connection.prepareCall("{call login(?,?)}");
		cs.setString(1,username);
		cs.setString(2,pass);

		ResultSet rs = cs.executeQuery();

		while(rs.next()){
			System.out.println(rs.getString(1));
		}
	}

	public static void updatePassByUsername(Connection connection,String username,String pass) throws Exception{

		CallableStatement cs = connection.prepareCall("{call updatePassByUsername(?,?,?)}");
		cs.setString(1,username);
		cs.setString(2,pass);
		cs.registerOutParameter(3, Types.INTEGER);

		cs.execute();

		int affectedRows = cs.getInt(3);

		System.out.println("Filas afectadas :" +affectedRows);
	}

}
















