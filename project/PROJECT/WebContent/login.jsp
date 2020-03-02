
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
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
<body >
<div class="container-fluid">
		<nav class="navbar bg-warning">
			<img src="images/logo1.jpg" height="90px" width="180px" style="margin-left: 20px;" >
			<ul class="nav">
			<li class="nav-item "><a href="" class="btn btn-primary"
					data-target="#Login" data-toggle="modal"><i class='fas fa-unlock'></i>&nbsp;Login</a></li>&nbsp;
				<li class="nav-item "><a href="" class="btn btn-primary"
					data-target="#SignUp" data-toggle="modal"><i class='fas fa-portrait'></i>&nbsp;SignUp</a></li>&nbsp;
				
			</ul>
		</nav>
	</div>
	<br>
	<div class="modal" id="SignUp">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Enter your details</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<center>
						<form action="FurnitureServlet" method="post">
							<div class="form-group">
								<label>User Name</label><input type="text"
									placeholder="Enter Name" name="t1" class="form-control col-sm-4">
							</div>
							<div class="form-group">
								<label>User Email</label><input type="email" name="t2"
									placeholder="Enter email" class="form-control col-sm-4">
							</div>
							<div class="form-group">
								<label>User password</label><input type="password" name="t3"
									placeholder="password" class="form-control col-sm-4">
							</div>
							<!-- <div class="form-group">
								<label>Date of Birth</label><input type="date" name="t4"
									class="form-control col-sm-4">
							</div> -->
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<div class="form-group">
						<input type="submit" name="button" class="btn  btn-primary " value="register">
					</div>

					</form>
					</center>
				</div>

			</div>
		</div>
	</div>

	<div class="modal" id="Login">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Login</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<center>
						<form action="FurnitureServlet" method="post">

							<div class="form-group">
								<label>User Email</label><input type="email" name="t6"
									placeholder="Enter email" class="form-control col-sm-4">
							</div>
							<div class="form-group">
								<label>User password</label><input type="password" name="t7"
									placeholder="password" class="form-control col-sm-4">
							</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<div class="form-group">
						<input type="submit" name="button" class="btn  btn-primary "value="login"/>
					</div>

					</form>
					</center>
				</div>

			</div>
		</div>
	</div>
	
	<!-- Carousel-->
	<center>
	<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
    <li data-target="#demo" data-slide-to="4"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/p1.jpg" alt="Los Angeles" style=" width: 1500px;height: 600px">
    </div>
    <div class="carousel-item">
      <img src="images/p2.jpg" alt="Chicago" style=" width: 1500px;height: 600px">
    </div>
    <div class="carousel-item">
      <img src="images/p3.jpg" alt="New York" style=" width: 1500px;height: 600px">
    </div>
    <div class="carousel-item">
      <img src="images/p4.jpg" alt="New York" style=" width: 1500px;height: 600px">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-autocontrol-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
</center>
<center>
	<h1>OUR SERVICES</h1>
	</center>
<form action="FurnitureServlet" method="post">
<label style="margin-left: 655px;"><b>Select Category:</b></label><br>
<center>
<select name="f1"> 			 
			  <c:forEach items="${clist}" var="category">
			  <option >${category}</option>
			  </c:forEach>	  
			 </select>
			 &nbsp;&nbsp;&nbsp;&nbsp;
			 <input type="submit" name="button" value="Go" class="btn  btn-primary">
			 </center>
			 </form><br><br>
<!-- Table -->

<div class="container-fluid">
<table   class="table table-hover table-striped">
<center>
<tr>
   <th><h4>Image</h4></th>
   <th><h4>Name</h4></th>
   <th><h4>UnitPrice</h4></th>
</tr>
<c:forEach items="${plist}" var="obj">
<tr>
   <td><img src="images/${obj.image_url}" style=" width: 200px;height: 140px"></td>
   <td>${obj.name}</td>
   <td>${obj.price}</td>
</tr>
</c:forEach>
</center>
</table>
</div>
	
	
</body>
</html>