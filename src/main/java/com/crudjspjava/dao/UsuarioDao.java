package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UsuarioDao {
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:myql://localhost:3306/crud_jsp_java","root","");
		}catch(Exception e){
			System.out.println(e);
		}
		
		return con;
	}
	
}
