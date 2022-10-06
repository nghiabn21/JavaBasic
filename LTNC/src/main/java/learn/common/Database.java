package learn.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database { 
	public static Connection Openconnection() throws ClassNotFoundException, SQLException { 
		Class.forName("com.mysql.cj.jdbc.Driver");  
        String connectionUrl = "jdbc:mysql://localhost:3306/dto" ; 
        String username = "root"; 
        String pasword = "anhnghia";
        Connection con = (Connection) DriverManager.getConnection(connectionUrl,username, pasword);  
        return con ;
        
        } 
	}

