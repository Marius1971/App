<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

.rosu {
	color: red;
}

.verde {
	color: green;
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
				<h3>Upload</h3>
			</div>
		</div>
		<%--========================================== MENU =============================================================--%>
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
							class="glyphicon glyphicon-shopping-cart"></span> Coș</a></li>
				</ul>
			</div>
		</div>
		</nav>
		<%--================================================ Container =================================================--%>
		<div class="container">
			<div class="col-sm-9">

				<form action="upload" method="post">
					<div class="form-group">
						<label>Marca:</label><input type="text" name="marca">
					</div>
					<div class="form-group">
						<label>Model: </label><input type="text" name="model">
					</div>
					<div class="form-group">
						<label>Gen: </label><input type="text" name="gen">
					</div>
					<div class="form-group">
						<label>Calibru: </label><input type="text" name="calibru">
					</div>
					<div class="form-group">
						<label>Material: </label><input type="text" name="material">
					</div>
					<div class="form-group">
						<label>Curea: </label><input type="text" name="curea">
					</div>
					<div class="form-group">
						<label>Mecanism: </label><input type="text" name="mecanism">
					</div>
					<div class="form-group">
						<label>Geam: </label><input type="text" name="geam">
					</div>
					<div class="form-group">
						<label>Pret: </label><input type="text" name="pret">
					</div>
					<div class="form-group">
						<label>Stoc: </label><input type="text" name="stoc">
					</div>
					<div class="form-group">
						<label>Detalii: </label><input type="text" name="detalii">
					</div>
					<input type="submit" value="Salveaza" class="btn btn-info" />
				</form>


				<%
					if (request.getAttribute("mesaj_ok") != null) {
				%>
				<p class="verde">
					<%=(String) request.getAttribute("mesaj_ok")%>
				</p>
				<%
					} else if (request.getAttribute("mesaj_not_ok") != null) {
				%>
				<p class="rosu">
					<%=(String) request.getAttribute("mesaj_not_ok")%>
				</p>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<br>
	<br>

	<%--============================================ FOOTER ======================================================--%>
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