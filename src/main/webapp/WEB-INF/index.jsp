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
	font-size: 30px;
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
	display: flex;
	float: left;
	border: 1px solid #000;
	background-color: #dbdbdb;
	text-align: center;
	padding: 50px;
	width: 200px;
	margin:auto;
	display: block;
	margin-right: 20px;
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
	margin-top: 90px;
	color: #ba4d0d;
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
	width: 400px;
	float: right;
}
.col-lg-7 {
	padding-left: 70px;
}
#p {
	padding-top: 20px;
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
				<h2>Nettikirpputori</h2>
				<p id="p">Verkkosivu toimii myyjän näkökulmasta.</p>
				<p>Nettikirpputorilla myyjä voi tarkastella myynnissä olevia tuotteitaan ja muokata niiden tietoja (esim. lisätiedot tai hinta).
				Vaatteille on oma sarake, jossa yksityiskohtaisemmat tuotetiedot.</p>
				<p>Myyjä pystyy myös poistamaan tuotteita myynnistä ja lisätä uusia tuotteita virtuaaliseen kirppispöytäänsä.</p>
				<button id="btn6"><a href="/omat-tuotteet" >Omat tuotteet</a></button>
			</div>
			<br>
		</div>
		<div class="col-lg-5 nopadding">
			<img src="https://i.pinimg.com/564x/b9/07/1a/b9071a6926c4b387fcd5534adc8cfb8f.jpg">
		</div>
	</div>
</body>
</html>