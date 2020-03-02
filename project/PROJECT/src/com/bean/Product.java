package com.bean;

public class Product {
private int id;
private String name;
private int price;
private String image_url;
private String category;
public Product(int id, String name, int price, String image_url, String category) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.image_url = image_url;
	this.category = category;
}
public Product(String name, int price, String image_url, String category) {
	super();
	this.name = name;
	this.price = price;
	this.image_url = image_url;
	this.category = category;
}
public Product() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getImage_url() {
	return image_url;
}
public void setImage_url(String image_url) {
	this.image_url = image_url;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image_url=" + image_url + ", category="
				+ category + "]";
	}


}
