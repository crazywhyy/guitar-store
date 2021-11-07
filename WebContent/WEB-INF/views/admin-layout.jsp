<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="${pageContext.servletContext.contextPath}/">

<title>Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--  Font Awesome      -->
<script src="https://kit.fontawesome.com/359fb45fa6.js"
	crossorigin="anonymous"></script>
<!--  Custom styling    -->
<link rel="stylesheet" type="text/css" href="css/admin.css"> 

<!--  Google Fonts      -->
<link
	href="https://fonts.googleapis.com/css?family=Candal|Lora&display=swap"
	rel="stylesheet">



<style>
header {
	background: #3AAAD8;
	height: 66px;
}
header ul li a:hover {
	background: #e24f93;
	transition: 0.5s;
}
header span {
text-align: center;
}
header .logo-text span {
	color: #921717;
}
</style>
</head>
<body>
	<header>
		<div class="logo">
			<h1 class="logo-text">
				<span>TA</span>Guitar
			</h1>
		</div>

		<i class="fa fa-bars menu-toggle"></i>

	<ul class="nav">
			<li><a href=""> <i class="fa fa-user"></i>Administator<i
					class="fa fa-chevron-down" style="font-size: 0.8em;"></i>
			</a>
				 <ul>
					<li><a href="">Dashboard</a></li>
					<li><a href="Guitar/index.htm" class="logout">Logout</a></li>
				</ul></li> 
		</ul> 

	</header>
	<div class="content">
		<h1>ADMIN</h1>	
		
		<jsp:include page="${param.view}" />

	</div>
	<!-- jQuery-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<!-- Custom Script-->
	<script type="text/javascript" src="js/admin.js"></script>
</body>
</html>