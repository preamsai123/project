package com.bean;

import java.sql.Timestamp;

public class Order {
private int id;
private User uid;
private int total_amount;
private Timestamp order_date;
public Order(User uid, int total_amount, Timestamp order_date) {
	super();
	this.uid = uid;
	this.total_amount = total_amount;
	this.order_date = order_date;
}
public Order(int id, User uid, int total_amount, Timestamp order_date) {
	super();
	this.id = id;
	this.uid = uid;
	this.total_amount = total_amount;
	this.order_date = order_date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public User getUid() {
	return uid;
}
public void setUid(User uid) {
	this.uid = uid;
}
public int getTotal_amount() {
	return total_amount;
}
public void setTotal_amount(int total_amount) {
	this.total_amount = total_amount;
}
public Timestamp getOrder_date() {
	return order_date;
}
public void setOrder_date(Timestamp order_date) {
	this.order_date = order_date;
} 


}
