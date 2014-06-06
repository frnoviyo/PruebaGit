import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {
	public static void main(String[] args) {
		//Creamos una instancia de la clase MyDataAcces
		MyDataAcces conexion = new MyDataAcces();
		ResultSet resultado;
		  String nombre, apellido;
		  //Insertamos datos en la base de datos
		  //conexion.setQuery("INSERT INTO persona VALUES ('2', 'Joaquin', 'Novillo', '1', 'Sabiango')");
		  //recuperamos la informacion de la base de datos
		  resultado = conexion.getQuery("select * from persona");
		   
		  try {
			   while(resultado.next()){
				//Obtenemos el nombre de la persona por medio del metodo getString()
			    nombre = resultado.getString("nombre");
			    apellido = resultado.getString("apellido");
			    //Imprimimos en consola el nombre y apellidode la persona
			    System.out.println("nombre: "+nombre +" "+apellido);
			   }
		  } catch (SQLException e) {
			   e.printStackTrace();
		  } 
	}
}
