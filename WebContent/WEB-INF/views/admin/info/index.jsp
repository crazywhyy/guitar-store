<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<h1>Quản lý Guitar</h1>
	<h1>${message}</h1>
<table border="1">
			<tr style="background-color: lightgray">
				<th>Mã</th>
				<th>Mã Guitar</th>
				<th>Tên Guitar</th>
				<th>Thương Hiệu</th>
				<th>Nơi Sản Xuất</th>
				<th>Giá Tiền</th>
				<th>Nội dung</th>
				<th>Hình ảnh</th>
	
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="s" items="${guitars}">
				<tr>
					<td>${s.id}</td>
					<td>${s.maGuitar}</td>
					<td>${s.tenGuitar}</td>
					<td>${s.thuongHieu}</td>
					<td>${s.noiSanXuat}</td>
					<td>${s.giaTien}</td>
					<td>${s.noiDung}</td>
					
				<td><img src="img/${s.hinhAnh}" width="80"></td>

					<td><a href="admin/Guitar/update/${s.id}.htm">Sửa</a></td>
					<td><a href="admin/Guitar/delete/${s.id}.htm" onclick="return confirm('Are you sure?')">Xóa</a></td>

				</tr>
			</c:forEach>
		</table>

		<form action="admin/Guitar/insert.htm" method="get">
			<h2>
				<button>Thêm mới</button>
			</h2>
		</form>

	
