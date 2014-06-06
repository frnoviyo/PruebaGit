import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDataAcces {
	 //Variables que guardan los datos para la conexion a la base de datos
	 private String _usuario="root";
	 private String _pwd= "adminadmin";
	 private static String _bd="empresa";
	 static String _url = "jdbc:mysql://localhost/"+_bd;
	 //variable de tippo connection para realizar la nexion a la base de datos
	 private Connection conn = null;
	 
	 //Metodo que permite realizar la conexion a la base datos
	 public MyDataAcces() {
	   
		  try{
		   //Permite hace la inicialización y el registro del driver mysql
		   Class.forName("com.mysql.jdbc.Connection");
		   //DriverManager nos pemite realizar la conexion por emdio del metodo getConecction()
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
	 //Metoddo que nos permite recuperar informacion de la base de datos y nos retorna un valor
	 public ResultSet getQuery(String _query){
	  //variable que nos permite enviar consultas 
	  Statement state = null;
	  ResultSet resultado = null;
	  try{
	   state = (Statement) conn.createStatement();
	   //executeQuery() ejecuta la consulta y retorna un valor 
	   resultado = state.executeQuery(_query);
	  }
	  catch(SQLException e)
	  {
	   e.printStackTrace();
	   
	  }
	  return resultado;
	 }
	 
	 //Metodo que permite almacenar o modificar información en la base de datos 
	 public void setQuery(String _query){
	 
		  Statement state = null;
		   
		  try{  
		   state=(Statement) conn.createStatement();
		   //metodo execute() permite enviar consultas y hacer modificaciones en la base de datos 
		   state.execute(_query);
		 
         } catch (SQLException e){
            e.printStackTrace();
         }
	 }
}
