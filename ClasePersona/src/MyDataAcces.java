import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDataAcces {
	 private String _usuario="root";
	 private String _pwd= "adminadmin";
	 private static String _bd="empresa";
	 static String _url = "jdbc:mysql://localhost/"+_bd;
	 private Connection conn = null;
	  
	 public MyDataAcces() {
	   
		  try{
		   Class.forName("com.mysql.jdbc.Connection");
		   conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
		   if(conn != null)
		   {
		    System.out.println("Conexi-n a base de datos "+_url+" . . . Ok");
		   }
		  }
		  catch(SQLException ex)
		  {
		   System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url);
		  }
		  catch(ClassNotFoundException ex)
		  {
		   System.out.println(ex);
		  } 
	 }
}