package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;


public class UserDao {
	
		public static boolean CheckEmailexitsorNot(String email) throws ClassNotFoundException, SQLException {
			Connection c =ConnectionUtility.getconnection();
			
			PreparedStatement ps = c.prepareStatement("select * from user where email=?");
			ps.setString(1,email);
			ResultSet rs =ps.executeQuery();
			if(rs.next())
				return true;
			
			return false;
			
		}
		public static boolean AddCustomer(User u) throws ClassNotFoundException, SQLException {
			Connection con = ConnectionUtility.getconnection();
				
				PreparedStatement ps = con.prepareStatement("insert into user(name,email,password)values(?,?,aes_encrypt(?,'k1'))");
				ps.setString(1, u.getName());
				ps.setString(2,u.getEmail());
				ps.setString(3, u.getPassword());
				
				
				int val = ps.executeUpdate();
				if (val > 0) {
					return true;
				} else

					return false;

			}
		public static String Uservalidation(String email) throws ClassNotFoundException, SQLException {
			Connection c =ConnectionUtility.getconnection();
				
				PreparedStatement ps = c.prepareStatement("select aes_decrypt(password,'k1') from user where email=?" );
				ps.setString(1,email);
				
				ResultSet rs =ps.executeQuery();
				rs.next();
					return rs.getString(1);
				
				
				
			}
		public static String UserName(String email) throws ClassNotFoundException, SQLException {
			Connection c =ConnectionUtility.getconnection();
				
				PreparedStatement ps = c.prepareStatement("select name from user where email =?");
				ps.setString(1,email);
				
				ResultSet rs =ps.executeQuery();
				rs.next();
				
					return rs.getString(1);
				
								
			}
		public static int UserID(String email) throws ClassNotFoundException, SQLException {
			Connection c =ConnectionUtility.getconnection();
				
				PreparedStatement ps = c.prepareStatement("select id from user where email =?");
				ps.setString(1,email);
				
				ResultSet rs =ps.executeQuery();
				rs.next();
				
					return rs.getInt(1);
				
								
			}
		
}
