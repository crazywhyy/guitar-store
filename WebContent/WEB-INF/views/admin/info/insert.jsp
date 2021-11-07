<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>



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
</style>
<div class="container">


	<form:form modelAttribute="guitar" method="post"
		action="admin/Guitar/${insert}.htm">

		<div class="row">
			<div class="col-25">
				<label>Mã</label>
			</div>

			<div class="col-75">
				<form:input path="id" />
			</div> 


		</div>

		<div class="row">
			<div class="col-25">
				<label>Mã Guitar</label>
			</div>

			<div class="col-75">
				<form:input path="maGuitar"/>
			</div> 


		</div>

		<div class="row">
			<div class="col-25">
				<label for="fname">Tên Guitar</label>
				<form:errors path="tenGuitar" style="font-style: italic; color: red"></form:errors>
			</div>

			<div class="col-75">
				<form:input path="tenGuitar" />
				
			</div>


		</div>

		<div class="row">
			<div class="col-25">
				<label for="lname">Thương Hiệu</label>
				
			</div>

			<div class="col-75">
				<form:input path="thuongHieu" />
				<form:errors path="thuongHieu" style="font-style: italic; color: red"></form:errors>
			</div>

		</div>

		<div class="row">
			<div class="col-25">
				<label for="lname">Nơi Sản Xuất</label>
			</div>

			<div class="col-75">
				<form:input path="noiSanXuat" />
				<form:errors path="noiSanXuat" style="font-style: italic; color: red"></form:errors>
				
			</div>

		</div>


		<div class="row">
			<div class="col-25">
				<label for="lname">Giá Tiền</label>
			</div>

			<div class="col-75">
				<form:input path="giaTien" />
				<form:errors path="giaTien" style="font-style: italic; color: red"></form:errors>
			</div>


			<!-- 	<input type="datetime-local" name="datetime_local"> -->

		</div>

		<div class="row">
			<div class="col-25">
				<label for="subject">Nội dung</label>
			</div>

			<div class="col-75">
				<form:textarea path="noiDung" style="height: 200px" />
				<form:errors path="noiDung" style="font-style: italic; color: red"></form:errors>
			</div>

		</div>


		<div class="row">
			<div class="col-25">
				<label for="lname">Hình ảnh</label>
			</div>

			<div class="col-75">
				<form:input path="hinhAnh" />
				<form:errors path="hinhAnh" style="font-style: italic; color: red"></form:errors>
			</div>

		</div>


		<div class="row">
			<c:choose>
				<c:when test="${insert == 'insert'}">
					<input type="submit" value="Thêm mới">
				</c:when>
				<c:otherwise>
					<input type="submit" value="Cập nhật">
				</c:otherwise>
			</c:choose>
		</div>

	</form:form>

	<a href="admin/Guitar/insert.htm">Nhập lại</a>
	<a href="admin/Guitar/index.htm">Thoát</a>
	
	<h3>${message}</h3>

</div>

