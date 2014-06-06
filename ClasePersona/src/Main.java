import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {
	public static void main(String[] args) {
		//Creamos una instancia de la clase MyDataAcces
		MyDataAcces conexion = new MyDataAcces();
		ResultSet resultado;
		  String nombre, apellido;
		  //INSERT INTO `empresa`.`persona` (`idPersona`, `nombre`, `apellido`, `edad`, `direccion`) VALUES (NULL, 'Freddy', 'Novillo', '30', 'Azuay y Bernardo Valdiviezo');
		  resultado = conexion.getQuery("select * from persona");
		   
		  try {
			   while(resultado.next()){
			    nombre = resultado.getString("nombre");
			    apellido = resultado.getString("apellido");
			    System.out.println("nombre: "+nombre +" "+apellido);
			   }
		  } catch (SQLException e) {
			   e.printStackTrace();
		  } 
	}
}
