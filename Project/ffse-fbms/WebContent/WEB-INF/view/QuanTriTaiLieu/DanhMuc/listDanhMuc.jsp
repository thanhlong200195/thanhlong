<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách category</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
	<div class="container" style="max-width:50%">
		<div style="text-align: center;">
			<h1>Danh sách danh mục</h1>
		</div>
		<div>
			<h3>
				<a href="add">Thêm mới</a>
			</h3>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Mã danh mục</th>
					<th scope="col">Tên danh mục</th>
					<th scope="col">Ảnh</th>
					<th scope="col">Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${category}">
					<tr>
						<th scope="row">${sv.ma_danh_muc}</th>
						<td>${sv.ten_danh_muc }</td>
						<td><img style="width: 100px; height: 100px;" src='<c:url value = "/resources/upload/${sv.image }" ></c:url>' alt="image"></td>
					<td><a href="edit/${sv.id }"><button
							class="btn btn-success">Edit</button></a> <a
					href="delete/${sv.id }"><button class="btn btn-danger"
					onclick="return confirm('Bạn có muốn xóa sinh viên này?');">Delete</button></a></td>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<script>
		function canhbao() {
			return confirm("Bạn Có Chắc Muốn Xóa Không?");
		}
	</script>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
</body>
</html>