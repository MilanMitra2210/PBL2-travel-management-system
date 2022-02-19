package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

	Connection con;
	Statement stmt;
	
	public Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/tms", "root", "2210");
			stmt = con.createStatement();
			
			
		}catch(Exception e) {
			
		}
	}
}
