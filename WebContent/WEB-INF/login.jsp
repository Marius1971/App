<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}
/* Remove the jumbotron's default bottom margin */
.jumbotron {
	margin-bottom: 0;
	background-color: #507165;
	color: aqua;
	font-family: monospace;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #DFF0D8;
	padding: 25px;
}
</style>

<title>CRoNOS</title>
</head>

<body>
	<div class="container">
		<div class="jumbotron">
			<div class="container text-center">
				<h1>CRoNOS</h1>
				<h2>Magazin de ceasuri</h2>
			</div>
		</div>
	<%--================================================ MENU ====================================================--%>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="home">Home</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>
								Cont</a></li>
						<li><a href="cos"><span
								class="glyphicon glyphicon-shopping-cart"></span>Coș</a></li>
					</ul>
				</div>
			</div>
		</nav>
	<%--================================================ Container =================================================--%>
		<form class="form-inline centru" action="login" method="post">
			<div class="form-group">
				<label class="sr-only" for="exampleInputEmail3">Email
					address</label> <input type="email" name="email" class="form-control"
					id="email" placeholder="Email">
			</div>
			<div class="form-group">
				<label class="sr-only" for="exampleInputPassword3">Password</label>
				<input type="password" name="parola" class="form-control"
					id="parola" placeholder="Password">
			</div>
			<button type="submit" class="btn btn-default">Sign in</button>
		</form>

		<span class="label label-danger">${mesaj}</span> <br> <br>

	<%--=========================================== FOOTER ======================================================--%>
		<div class="col-sm-12">
			<footer class="container-fluid text-center">
				<p>CRoNOS Copyright</p>
				<form class="form-inline">
					Contact: <input type="email" class="form-control" size="50"
						placeholder="Email Address">
					<button type="button" class="btn btn-danger">Sign Up</button>
				</form>
		</div>
		<body>

		</body>
</html>