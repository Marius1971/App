<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRoNOS</title>
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
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<div class="container text-center">
				<h1>CRoNOS</h1>
				<h2>Magazin de ceasuri</h2>
			</div>
		</div>
<%--============================================== MENU ====================================================--%>
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
				<li><a href="upload">Upload</a></li>
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
<%--============================================== Container =======================================================--%>


		<div class="container-fluid">
			<div class="col-sm-9">

				<div class="panel-heading">DETALII</div>
				
				<div class="panel-body">
					<p>
						<b>MARCA: </b>${ceas.marca}</p>
					<p>
						<b>Model: </b>${ceas.model}</p>
					<p>
						<b>Gen: </b>${ceas.gen}</p>
					<p>
						<b>Calibru: </b>${ceas.calibru}</p>
					<p>
						<b>Material: </b>${ceas.material}</p>
					<p>
						<b>Curea: </b>${ceas.curea}</p>
					<p>
						<b>Tip mecanism: </b>${ceas.mecanism}</p>
					<p>
						<b>Geam: </b>${ceas.geam}</p>
					<p>
						<b>Detalii: </b>${ceas.detalii}</p>
						<img class="imagine" src="${ceas.img}" />
				</div>

				<div class="col-sm-3">
					<h3 class="alert alert-info">Cosul contine:</h3>
					<%--Setam o variabila pretTotal Puteam folosi si cod java intre scripleti.--%>
					<c:set var="pretTotal" value="${0}" />
					<c:forEach items="${sessionScope.cos}" var="articol">
						<p>${articol.marca}-${articol.pret}</p>

						<c:set var="pretTotal" value="${pretTotal + articol.pret}" />
					</c:forEach>

					<%--alert, alert-succes este clasa bootstrap --%>
					<p class="alert alert-success">
						Total de plata: <br> ${pretTotal} lei
					</p>
				</div>

			</div>
		</div>
	</div>
	<br>
	<br>
	<%--=============================================== FOOTER =================================================--%>
	<div class="col-sm-12">
		<footer class="container-fluid text-center">
			<p>CRoNOS Copyright</p>
			<form class="form-inline">
				Contact: <input type="email" class="form-control" size="50"
					placeholder="Email Address">
				<button type="button" class="btn btn-danger">Sign Up</button>
			</form>
	</div>
</body>
</html>