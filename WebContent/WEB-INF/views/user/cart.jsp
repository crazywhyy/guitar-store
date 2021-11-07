<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>




<style>
/* Style inputs, select elements and textareas */
input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	resize: vertical;
}

/* Style the label to display next to the inputs */
label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

/* Style the submit button */
input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
	margin-left: 10px;
}

/* Style the container */
.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

/* Floating column for labels: 25% width */
.col-25 {
	float: left;
	width: 25%;
	margin-top: 6px;
}

/* Floating column for inputs: 75% width */
.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}
	input[type=submit] {
		margin-top: 10px;
	}
}

a {
	color: black;
}

.content {
	width: 80%;
	margin: 200px 200px;
}
</style>



<div class="content">

	<h3>Thanh Toán</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Lựa chọn</th>
			<th>Mã</th>
			<th>Tên Guitar</th>
			<th>Hình Ảnh</th>
			<th>Giá tiền</th>
			<th>Số lượng </th>
			<th>Tổng tiền</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart }">
			<%-- <c:set var="total"
				value="${total + item.product.price * item.quantity }"></c:set> --%>
			<tr>
				<td align="center"><a
					href="${pageContext.request.contextPath }/Guitar/remove/${item.product.id }.htm"
					onclick="return confirm('Bạn có muốn xóa đơn hàng này không?')">Xoá</a></td>
				<td>${item.product.id }</td>
				<td>${item.product.tenGuitar }</td>
				<td><img src="img/${item.product.hinhAnh}" width="50"></td>
				<td>${item.product.giaTien }</td>
				<td>${item.quantity }</td>
				<td>${item.product.giaTien * item.quantity }</td>
			</tr>
		</c:forEach>
<%-- 		<tr>
			<td colspan="6" align="right">Sum</td>
			<td>${total }</td>
		</tr> --%>
	</table>


	<div class="container">


	<form:form modelAttribute="donhang" method="post"
		action="Guitar/thanhtoan.htm">


		<div class="row">
			<div class="col-25">
				<label>Mã đơn hàng</label>
			</div>

			<div class="col-75">
				<form:input path="id" />
			</div>


		</div>

		<div class="row">
			<div class="col-25">
				<label for="fname">Họ tên</label>
				<form:errors path="hoTen" style="font-style: italic; color: red"></form:errors>
			</div>

			<div class="col-75">
				<form:input path="hoTen" />
			</div>


		</div>

		<div class="row">
			<div class="col-25">
				<label for="lname">Địa chỉ</label>
			</div>

			<div class="col-75">
				<form:input path="diaChi" />
			</div>

		</div>

		<div class="row">
			<div class="col-25">
				<label for="lname">Nội Dung</label>
			</div>

			<div class="col-75">
				<form:input path="noiDung" />
			</div>

		</div>


		<div class="row">
			<div class="col-25">
				<label for="lname">Số điện thoại</label>
			</div>

			<div class="col-75">
				<form:input path="soDT" />
			</div>


			<!-- 	<input type="datetime-local" name="datetime_local"> -->

		</div>

		<div class="row">
			<button>Thanh Toán</button>
		</div>

	</form:form>

	<h1>${message}</h1>

</div>

</div>


	<button> <a href="${pageContext.request.contextPath }/Guitar/index.htm">Tiếp tục mua hàng</a> </button>
