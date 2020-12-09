<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<link href="styles/demo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Lis‰‰ Tuote</title>
<style type="text/css">
body {
	width: 100%
}
.banner {
	background-color: #d4910d;
	padding: 10px;
	padding-top: 25px;
	padding-left: 65px;
	height: 110px;
}
.container {
	width: 100%
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
	float: left;
	border-radius: 0;
	border-right: 2px solid #000;
	border-bottom: 2px solid #000;
	border-left: 2px solid #767676;
	border-top: 2px solid #767676;
	background-color: #efefef;
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
img {

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
				<img src="https://i.pinimg.com/564x/7e/49/6a/7e496aa72494dc9048db6671efa53d39.jpg">
			</div>
			<div class="col-lg-6 nopadding lomake">
				<h2>Uusi vaate</h2>
				<p>T‰ss‰ voit lis‰t‰ uuden vaatteen myyntiin.</p>
				<form action="/lisaa-vaate" method="post">
			
					<p><label>Nimi:</label></p>
					<p><input type="text" value="" name="nimi"size="50" /></p>
					<p><label>Kuvaus:</label></p>
					<p><input type="text" value="" name="kuvaus" size="50" /></p>
					<p><label>Hinta:</label></p>
					<p><input type="number" step=".01" value="" name="hinta" size="50" /></p>
					<p><label>Koko:</label></p>
					<p><input type="text" value="" name="koko" size="50" /></p>
					<p><label>Merkki:</label></p>
					<p><input type="text" value="" name="merkki" size="50" /></p>
					
					<div class="btn-group">
						<input type="submit" name="save" class="btn btn-save" value="Tallenna" />
						<button class="btn"><a href="/lisataan" >Peruuta</a></button>
					</div>
					<br><br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>