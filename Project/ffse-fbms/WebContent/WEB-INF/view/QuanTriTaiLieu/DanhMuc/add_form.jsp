<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Danh Mục</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
	<div class="container" style="max-width:50%">
	<h1 style="text-align: center;" >Thêm danh mục</h1>
			<form:form action="create" method="POST" enctype="multipart/form-data" modelAttribute="category">
			<div class="form-group">
				<label>Mã danh mục:</label>
				<form:input class= "form-control" type="text" path="ma_danh_muc"/>
			</div>
			<div class="form-group">
				<label>Tên danh mục</label>
				<form:input path="ten_danh_muc" cssClass="form-control"></form:input>
			</div>
			<div class="form-group">
				<label>Avatar</label> <input id="upload" type="file"
					class="form-control-file" name="file">
			</div>
			<div class="form-group">
				<img id="image" style="width: 100px; height:100px" alt="image" src='#'>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
</body>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#image').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	$("#upload").change(function() {
		readURL(this);
	});
</script>
</html>