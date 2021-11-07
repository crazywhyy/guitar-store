<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>	
<link href="https://fonts.googleapis.com/css?family=Alatsi|Calistoga|Noto+Sans|Tomorrow&display=swap" rel="stylesheet">
<style>
a {
	font-family: 'Tomorrow', sans-serif;
	font-size: 15px;
	font-weight: bold;
}
a:hover {
	color: #1b28c1d4;
}
</style>
<c:forEach var="s" items="${guitar}">

	<div>
			<img src="img/${s.hinhAnh}" alt="" style="width: 200px;height: 200px">
			<a href="Guitar/addToCart/${s.id}.htm" > Add to Cart </a>
			<a href="Guitar/moreInfo/${s.id}.htm">More infor</a>	

</div>


</c:forEach>