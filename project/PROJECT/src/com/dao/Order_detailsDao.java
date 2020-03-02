package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Order_detailsDao {
	public static boolean AddOrderDetails(int orderid,int pid, int quantity) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getconnection();
			
			PreparedStatement ps = con.prepareStatement("insert into order_details(order_id,product_id,quantity)values(?,?,?)");
			ps.setInt(1, orderid);
			ps.setInt(2,pid);
			ps.setInt(3,quantity);				
			int val = ps.executeUpdate();
			if (val > 0) {
				return true;
			} else

				return false;

		}
}
