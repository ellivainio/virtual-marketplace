<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/8e75f75547.js" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Nettikirpputori</title>
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
.fas {
	font-size: 40px;
	text-align: center;
	color: #fff;
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
#btn5 {
	border-right: 2px solid #000;
	border-bottom: 2px solid #000;
	border-left: 2px solid #767676;
	border-top: 2px solid #767676;
	background-color: #efefef;
	display: flex;
	float: left;
	text-align: center;
	padding: 80px;
	width: 260px;
	margin:auto;
	display: block;
	margin-top: 20px;
}
a {
	color: #000;
	text-decoration: none;
}
a:hover {
	color: #000;
	text-decoration: none;
}
#vai {
	float: left;
	font-size: 20px; 
	margin-top: 110px;
	color: #ba4d0d;
	padding-right: 20px;
	padding-left: 20px;
}

#btn6 {
	padding: 5px;
	border-right: 2px solid #000;
	border-bottom: 2px solid #000;
	border-left: 2px solid #767676;
	border-top: 2px solid #767676;
	background-color: #efefef;
	margin-top: 20px;
	float: none;
}
.nopadding {
   padding: 0 !important;
   margin: 0 !important;
}
img {
	width: 500px;
	float: right;
}
.col-lg-7 {
	padding-left: 70px;
}
</style>
</head>
<body>
			<div class="banner">
				<span class="button"><a href="/" ><h1>Nettikirpputori</h1><i class="fa fa-angellist"></i></a></span>
			</div>
			<div class="row nopadding">
		<div class="col-lg-7">
			<div class="container">
				<h2>Lisätäänkö</h2>
		
				<span class="button"><a href="/lisaa-vaate" id="btn5"><i class="fas fa-tshirt"><p style="color:#6e6e6e; font-size: 20px;">Vaate</p></i>
				</a></span><p id="vai">vai</p>
				<span style="margin-left: 20px;" class="button"><a href="/lisaa-tuote" id="btn5"><i class="fas fa-bicycle"><p style="color:#6e6e6e; font-size: 20px;">Muu tuote</p></i></a></span>
		
			</div>
			<div style="clear:both;"></div>
			<div class="container">
				<button id="btn6"><a href="/omat-tuotteet" >Peruuta</a></button>
			</div>
			<br>
		</div>
		<div class="col-lg-5 nopadding">
			<img src="https://i.pinimg.com/564x/fb/2d/18/fb2d182da7e42d4468c91383b63c69a2.jpg">
		</div>
	</div>
</body>
</html>