<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<!-- <style type="text/css">
	
	.table,tr,th,td{
	border:3px solid black;
	
	
	}
	</style> -->
</head>
<body>
	<!-- nav bar  -->
	<div class="container-fluid">
		<nav class="navbar bg-warning">
			<img src="images/logo1.jpg" height="90px" width="180px"
				style="margin-left: 20px;">
			<ul class="nav">
				<!-- <li class="nav-item "><a href="" class="btn btn-primary"
					data-target="#Login" data-toggle="modal"><i class='fas fa-unlock'></i>&nbsp;Login</a></li>&nbsp; -->
				<li class="nav-item "><a href="" class="btn btn-primary"
					data-target="#username" data-toggle="modal">&nbsp;Welcome
						${uname}</a></li>&nbsp;
				<li class="nav-item "><a href="logout.jsp" class="btn btn-primary"><i class="fas fa-"></i><i
						class='fas fa-lock'></i>&nbsp;LogOut</a></li>&nbsp;

			</ul>
		</nav>
	</div>
	<br>
	<br>
	<!-- form -->
	</center>
	<form action="FurnitureServlet" method="post">
		<label style="margin-left: 655px;"><b>Select Category:</b></label><br>
		<center>
			<select name="f2">
				<c:forEach items="${clist}" var="category">
					<option>${category}</option>
				</c:forEach>
			</select> &nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="button"
				value="select" class="btn  btn-primary">
		</center>
	</form>
	<br>
	<br>
	<!-- Table -->
	<center>
		<form action="FurnitureServlet" method="post">
			<div class="container-fluid">
				<table class="table table-hover table-striped">
					<tr>
						<th><h4>Image</h4></th>
						<th><h4>Name</h4></th>
						<th><h4>UnitPrice</h4></th>
						<th><h4>Quantity</h4></th>
					</tr>
					<c:forEach items="${plist}" var="obj">
						<tr>
							<input type="hidden" value="${obj.id}" name="itemid">
							<td><img src="images/${obj.image_url}"
								style="width: 200px; height: 140px"></td>
							<td>${obj.name}</td>
							<td>${obj.price}</td>
							<td><input type="number" name="quantity" min="0" value="0"></td>
						</tr>
					</c:forEach>

				</table>
			</div>

			<input type="submit" name="button" value="cart"
				class="btn  btn-primary">
		</form>
		
	</center>
</body>
</html>