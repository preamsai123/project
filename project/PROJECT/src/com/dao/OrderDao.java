package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrderDao {
	public static boolean Generatebill(int custId,int ta,Timestamp t) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getconnection();
			
			PreparedStatement ps = con.prepareStatement("insert into orders(user_id,total_amount,order_date)values(?,?,?)");
			ps.setInt(1, custId);
			ps.setInt(2,ta);
			ps.setTimestamp(3,t);
			
			
			int val = ps.executeUpdate();
			if (val > 0) {
				return true;
			} else

				return false;

		}
	public static int GetOrderIDwithUserIdandTimestamp(int custId,Timestamp t) throws ClassNotFoundException, SQLException {
		Connection c =ConnectionUtility.getconnection();
			
			PreparedStatement ps = c.prepareStatement("select id from orders where user_id =? and order_date =?");
			ps.setInt(1,custId);
			ps.setTimestamp(2, t);
			
			ResultSet rs =ps.executeQuery();
			rs.next();
				return rs.getInt(1);
			
							
		}
}
