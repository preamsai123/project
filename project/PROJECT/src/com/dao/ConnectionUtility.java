package com.dao;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionUtility{
	public static Connection getconnection() throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/urbanladder","root", "root");
}
}