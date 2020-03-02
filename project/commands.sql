drop database urbanladder;
create database urbanladder;
use urbanladder;
create table product(id int primary key auto_increment,name varchar(30),price int,image_url varchar(30),category varchar(30))auto_increment=1001;


create table user(id int primary key auto_increment,name varchar(30),email varchar(20),password varchar(80))auto_increment=5001;


create table orders(id int primary key auto_increment,user_id int,total_amount int,order_date timestamp,foreign key(user_id) references user(id))auto_increment=3001;

create table order_details(id int primary key auto_increment,order_id int,product_id int,quantity int,foreign key(order_id) references orders(id),foreign key(product_id) references product(id)) auto_increment=6001;

insert into product(name,price,image_url,category) values('mordern',62354,'bed1.jpg','beds');
insert into product(name,price,image_url,category) values('etnic',85246,'bed2.jpg','beds');
insert into product(name,price,image_url,category) values('simple',28654,'bed3.jpg','beds');
insert into product(name,price,image_url,category) values('kids',52252,'bed4.jpg','beds');
insert into product(name,price,image_url,category) values('large',78562,'bed5.jpg','beds');

insert into product(name,price,image_url,category) values('recliner',80298,'sofa1.jpg','sofa');
insert into product(name,price,image_url,category) values('leather sofa',50000,'sofa2.jpg','sofa');
insert into product(name,price,image_url,category) values('fur soafa',30000,'sofa3.jpg','sofa');
insert into product(name,price,image_url,category) values('single sofa',90729,'sofa4.jpg','sofa');
insert into product(name,price,image_url,category) values('still sofa',25621,'sofa5.jpg','sofa');

insert into product(name,price,image_url,category) values('royal',158246,'dinning1.jpg','dinning table');
insert into product(name,price,image_url,category) values('ethnic',24563,'dinning2.jpg','dinning table');
insert into product(name,price,image_url,category) values('mordern',74569,'dinning3.jpg','dinning table');
insert into product(name,price,image_url,category) values('wooden',23569,'dinning4.jpg','dinning table');
insert into product(name,price,image_url,category) values('glass',79456,'dinning5.jpg','dinning table');

insert into product(name,price,image_url,category) values('low table',172569,'office1.jpg','office furniture');
insert into product(name,price,image_url,category) values('wooden',29563,'office2.jpg','office furniture');
insert into product(name,price,image_url,category) values('mordern',79569,'office3.jpg','office furniture');
insert into product(name,price,image_url,category) values('glass',29569,'office4.jpg','office furniture');
insert into product(name,price,image_url,category) values('partisions',80456,'office5.jpg','office furniture');

