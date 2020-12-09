<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta charset="utf-8" />

<link href="styles/demo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Lis‰‰ vaate</title>
<style type="text/css">
body {

}
.banner {
	background-color: #d4910d;
	padding: 10px;
	padding-top: 25px;
	padding-left: 65px;
	height: 110px;
}
.container {
	
}
.fa {
	padding-top: 15px;
	padding-left: 10px;
	color: #fff;
	float: left;
	font-size: 35px;
}
h1 {
	padding-left: 20px;
	color: #fff;
	font-family: 'Dancing Script', cursive;
	font-size: 50px;
	float: left;
}
h2 {
	padding-top: 40px;
	font-family: 'Dancing Script', cursive;
	font-size: 35px;
	color: #ba4d0d;
}
h3 {
	font-family: 'Dancing Script', cursive;
	font-size: 25px;
	padding-top: 20px;
	color: #ba4d0d;
}
p {
	height: 15px;
}
label {
	padding: 0;
	margin: 0;
}
input {
	padding: 0;
	margin: 0;
	width: 400px;
}
.btn-group {
	margin-top: 20px;
	
}
.btn {
	width: 80px;
	padding: 3px;
	margin-right: 10px;
	border-right: 2px solid #000;
	border-bottom: 2px solid #000;
	border-left: 2px solid #767676;
	border-top: 2px solid #767676;
	background-color: #efefef;
	float: left;
	border-radius: 0;
}
.btn:hover {
	box-shadow: none;
}
a {
	color: #000;
}
a:hover {
	color: #000;
	text-decoration: none;
}
.nopadding {
   padding: 0 !important;
   margin: 0 !important;
}
.lomake {
	padding-left: 30px !important;
}
</style>
</head>

<body>
	<div class="banner">
		<span class="button"><a href="/" ><h1>Nettikirpputori</h1><i class="fa fa-angellist"></i></a></span>
	</div>
	<div class="container nopadding">
		<div class="row">
			<div class="col-lg-6 nopadding">
				<img src="https://i.pinimg.com/564x/a4/a7/cf/a4a7cf108feb5ee6d19ed468bc334a5c.jpg">
			</div>
			<div class="col-lg-6 nopadding lomake">
				<h2>Muokkaa vaatetta:</h2>
				<p>T‰ss‰ voit muokata vaatteen tietoja.</p>
					<form action= "/paivita-vaate?id=<c:out value='${vaate.id}'/>" method="post" enctype="application/x-www-form-urlencoded">
 
				 			<p><label>Nimi:</label></p>
							<p><input type="text" value="${vaate.nimi}" name="nimi" size="50" /></p>
							<p><label>Koko:</label></p>
							<p><input type="text" value="${vaate.koko}" name="merkki" size="50" /></p>
							<p><label>Merkki:</label></p>
							<p><input type="text" value="${vaate.merkki}" name="koko" size="50" /></p>
							<p><label>Kuvaus:</label></p>
							<p><input type="text" value="${vaate.kuvaus}" name="kuvaus" size="50" /></p>
							<p><label>Hinta:</label></p>
						<p><input type="number" step=".01" value="${vaate.hinta}" name="hinta" size="50" /></p>
			
			        
			        <div class="btn-group">
						<input type="submit" name="update" class="btn btn-save" value="Tallenna" />
						<button class="btn"><a href="/muokkaus-lista" >Peruuta</a></button>
					</div>
					<br>
					<br>
		        </form>
			</div>
		</div>
	</div>
</body>
</html>