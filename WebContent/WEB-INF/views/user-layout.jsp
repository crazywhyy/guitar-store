<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>WEB</title>
<base href="${pageContext.servletContext.contextPath }/" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="js/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="js/bootstrap/bootstrap-theme.min.css">
<link rel="stylesheet" href="js/aos/aos.css">
<!-- <link rel="stylesheet" href="css/reset.css">  -->
<!-- <link rel="stylesheet" href="css/style.css">  -->
</head>
<style>
f-space p, a{
	color: black;
}
.logo img{
	width:23%;
}
.nav-bar ul li {
  display: inline-block; 
  margin-left: 15px;
 }
 .logo {
	width: 200px;
}
 .f-space {
  display: flex;
  justify-content: space-between;
  align-items: center; 
} 
.header {
	height: 50px;
	background-color: #3AAAD8;
}


.container-bg {
	width: 1100px;
	margin: auto;
	height: 50px;
}
a:hover {
	text-decoration: none;
}
.nav-bar ul li a {
      font-family: "Shadows Into Light", cursive !important; 
      font-size: 15px;
      line-height: 0.5em;
      text-transform: uppercase;
      letter-spacing: 0.0909em; 
      border-bottom: solid 1px #ffffff;
      cursor: pointer;
      font-family: "Montserrat", sans-serif; 
      border-color: transparent; 
}
footer .footer {
  background-color: #3AAAD8;
  text-align: center;
  padding: 20px 0px; 
}
footer .footer .title {
    color: white; 
    font-size: 20px;
}
.logo-footer img {
	width: 10%;
}
</style>
<body>
	<header>
	<div class="header-nav-bg">
		<div class="header">
			<div class="contact-header container-bg f-space">
				<div class="left">
					<!-- <a href=""> GUITAR FOR YOUR LIFE </a> -->
					<div class="logo">
					<img src="img/1.png" alt="">
				</div>
				</div>
				<div class="right">
					<!-- <a href="addToCart.html"> CART: <span id="cart-nav">
						0</span> GUITARS - 0.00 vnd
					</a> -->
					<div class="nav-bar">
					<ul>
						<li><a href="Guitar/index.htm">Giới Thiệu</a></li>
						<li><a href="#">Sản Phẩm</a></li>
						<li><a href="#">Tin Tức</a></li>
						<li><a href="#">Quảng Cáo</a></li>
						<li><a href="#">Liên Hệ</a></li>
						<li><a href="Guitar/addToCart/3.htm"> Giỏ Hàng</a><li>
					</ul>
					</div>
				</div>
			</div>
		</div>
	<br> 
		<div>
			<marquee width="100%" direction="left" height="16px" >
    		<p style="color:MediumSeaGreen;">Chuyên bán các loại đàn guitar, phụ kiện chính hãng các loại Địa chỉ: 97 Man Thiện, phường Tăng Nhơn Phú, quận 9</p>
		</marquee>
	<br>
		</div>
		<div>
		<img src="img/slide.jpg" alt="" style="width:100%">
		</div>
	</div>
	
	</header>
	<main>
	
	<jsp:include page="${param.view}" />
	
	</main> 
	<footer>
	<div class="footer">
		<div class="logo-footer">
			<img src="img/1.png" alt="">
		</div>
		<div class="title">
			<h3>GUITAR - SẮC MÀU CUỘC SỐNG</h3>
		</div>
	</div>
	</footer>
	<!-- <script src="js/bootstrap/bootstrap.min.js"></script> -->
	<script src="js/aos/aos.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
	<script>
		AOS.init();
	</script>
</body>

</html>