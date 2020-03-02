package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.dao.ConnectionUtility;

public class Order_details {
		private int id;
		private Order oid;
		private Product pid;
		private int quantity;
		public Order_details(int id, Order oid, Product pid, int quantity) {
			super();
			this.id = id;
			this.oid = oid;
			this.pid = pid;
			this.quantity = quantity;
		}
		public Order_details() {
			super();
		}
		public Order_details(Order oid, Product pid, int quantity) {
			super();
			this.oid = oid;
			this.pid = pid;
			this.quantity = quantity;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Order getOid() {
			return oid;
		}
		public void setOid(Order oid) {
			this.oid = oid;
		}
		public Product getPid() {
			return pid;
		}
		public void setPid(Product pid) {
			this.pid = pid;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
}
