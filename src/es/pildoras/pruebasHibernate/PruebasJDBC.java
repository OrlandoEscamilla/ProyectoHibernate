package es.pildoras.pruebasHibernate;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebasJDBC {

	public static void main(String[] args) {
		
	
	

		String conexionUrl="jdbc:sqlserver://localhost:1433;database=pruebasHibernate;trustServerCertificate=true";
		
		String usuario = "sa";
		String contra = "Hnqaalmsr2022@";
		
		try {
					
			Connection con = DriverManager.getConnection(conexionUrl, usuario, contra);
			System.out.println("Conexion exitosa");
			
		}
		catch(SQLException ex){
			System.out.println(ex.toString());
		
		}

	}

}
