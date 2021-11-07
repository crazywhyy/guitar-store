<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<link href="https://fonts.googleapis.com/css?family=Alatsi|Calistoga|Dancing+Script|Noto+Sans|Tomorrow&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Alatsi|Calistoga|Dancing+Script|Kaushan+Script|Noto+Sans|Pacifico|Tomorrow&display=swap" rel="stylesheet">
<style>
.moreInfo {
	width:400px;
	margin: auto;
	text-align: center;
}
.moreInfo img {
	width: 250px;
	height: 250px;
}
p {
	font-family: 'Dancing Script', cursive;
	font-size: 22px;
	font-weight: bold;
}
h1 {	
	font-family: 'Kaushan Script', cursive;
}
</style>

<h1 style="color: black;text-align:center">THÔNG TIN ĐÀN GUITAR</h1>

<div class="moreInfo">
	<img src="img/${moreInfo.hinhAnh}">
	<p style="color: black;">Mã Guitar: ${moreInfo.id}</p>
	<p style="color: black;">Giá Tiền: ${moreInfo.giaTien} vnd</p>
	<p style="color: red;"  >Tên Guitar: ${moreInfo.tenGuitar}</p>
	<p style="color: black;">Nội Dung: ${moreInfo.noiDung}</p>
	<p style="color: black;">Thương Hiệu: ${moreInfo.thuongHieu}</p>
	<button><a href="Guitar/addToCart/${moreInfo.id}.htm" style="color: red"> Add to cart </a></button>
	<p></p>


</div>
