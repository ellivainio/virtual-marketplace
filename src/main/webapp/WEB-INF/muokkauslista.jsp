<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	width: 100%;
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
h4 {
	font-size: 15px;
	padding-top: 20px;
	color: #ba4d0d;
}
a {
	color: #000;
	text-decoration: none;
}
.taulukko {
	padding-top: 0px;
	padding-bottom: 0px;
}
td  {
	padding-right: 10px;
}
#nimi {
	width: 140px;
}
#koko {
	width: 80px;
}
#merkki {
	width: 70px;
}
#kuvaus {
	width: 290px;
}
#hinta {
	width: 80px;
}
#btn2 {
	padding: 5px;
	border-right: 2px solid #000;
	border-bottom: 2px solid #000;
	border-left: 2px solid #767676;
	border-top: 2px solid #767676;
	background-color: #efefef;
	margin-right: 7px;
	float: right;
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
		<div class="row">
			<div class="col-lg-8">
				<h2>Muokkaa tuotteita</h2>
				<p style="display: inline">Voit muokata omia myynnissä</p>
				<span class="button" id="btn2"><a href="/poisto-lista" >Poista tuotteita</a></span>
				<span class="button" id="btn2"><a href="/lisataan" >Lisää tuote</a></span>
				<span class="button" id="btn2"><a href="/omat-tuotteet" >Omat tuotteet</a></span>
				<p>olevia tuotteitasi tässä.</p>
				<div class="taulukko">
					<table>
						<tr>
							<td><h3>Vaatteet</h3></td>
							<td id="td"><h4>Koko</h4></td>
							<td id="td"><h4>Merkki</h4></td>
							<td id="td"><h4>Kuvaus</h4></td>
							<td id="td"><h4>Hinta</h4></td>
						</tr>
						<c:forEach items="${vaatelista}" var="vaate">
							<tr>
								<td id="nimi"><b><c:out value="${vaate.nimi}" /></b></td>
								<td id="koko"><c:out value="${vaate.koko}" /></td>
								<td id="merkki"><c:out value="${vaate.merkki}" /></td>
								<td id="kuvaus"><c:out value="${vaate.kuvaus}" /></td>
								<td id="hinta"><b><c:out value="${vaate.hinta} e" /></b></td>
								<td><button><a id="muokkaa" href="/muokkaa-vaatetta?vaateid=<c:out value='${vaate.id}'/>">Muokkaa</a></button></td>
							<tr>
						</c:forEach>
					</table>
					<table>
						<tr>
							<h3>Muut tuotteet</h3>
						</tr>
						<c:forEach items="${tuotelista}" var="tuote">
							<tr>
								<td id="nimi"><b><c:out value="${tuote.nimi}" /></b></td>
								<td id="koko"></td>
								<td id="merkki"></td>
								<td id="kuvaus"><c:out value="${tuote.kuvaus}" /></td>
								<td id="hinta"><b><c:out value="${tuote.hinta} e" /></b></td>
								<td><button><a id="muokkaa" href="/muokkaa-tuotetta?tuoteid=<c:out value='${tuote.id}'/>">Muokkaa</a></button></td>
							<tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="col-lg-4">
				<img src="https://i.pinimg.com/564x/30/1a/b3/301ab300245dcc3153d0c9d1b7185f3c.jpg">
			</div>
		</div>
	</div>
</body>
</html>