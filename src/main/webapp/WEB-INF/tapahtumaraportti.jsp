<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8" />

<title>Nettikirpputori</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
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
	padding-top: 40px;
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
#btn3 {
	padding: 5px;
	border: 1px solid #000;
	background-color: #dbdbdb;
	margin-right: 5px;
}
a {
	color: #000;
	text-decoration: none;
}
a:hover {
	color: #000;
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="banner">
		<span class="button"><a href="/" ><h1>Nettikirpputori</h1><i class="fa fa-angellist"></i></a></span>
	</div>
	<div class="container">
		<h2>Tapahtumaraportti</h2>
		<br>
		<p><c:out value="${viesti}" /><p>
		<br>
		<span class="button" id="btn3"><a href="/omat-tuotteet" >Omat tuotteet</a></span>
	</div>
</body>
</html>