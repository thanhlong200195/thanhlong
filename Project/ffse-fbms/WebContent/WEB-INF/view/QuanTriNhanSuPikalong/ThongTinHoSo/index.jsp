<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>

div.stroke a button,
div.stroke a button:after,
div.stroke a button:before {
  transition: all .5s;
}
div.stroke a button:hover {
  color: #555;
}

div.stroke a button{
  position: relative;
}
div.stroke a button:after
{
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
  width: 0%;
  content: '.';
  color: transparent;
  background: #aaa;
  height: 1px;
}
div.stroke a button:hover:after {
  width: 100%;
}
</style>

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<h3 class="content-header-title mb-0">Danh Sách Nhân Viên</h3> <!-- title -->
		<br>
		<div class= "stroke"><a href="addform"><button class="btn btn-light" style="background-color: #F5F7FA">
										<i class="ft-user-plus"></i>
									</button></a></div><br> <!-- add button -->	
		<div class="table-responsive">
			<table class="table mb-0">
				<thead>
					<tr>
						<th>STT</th>
						<th>Mã Nhân Viên</th>
						<th>Họ Tên</th>
						<th>Giới Tính</th>
						<th>Ngày Sinh</th>
						<th>Ảnh Đại Diện</th>
						<th>Chức Năng</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${nhanVienList}" var="x" varStatus="stt">
						<tr>
							<td>${stt.index + 1}</td>
							<td>${x.maNv}</td>
							<td>${x.hoTenNv}</td>
							<td>${x.gioiTinh}</td>
							<td>${x.ngaySinh}</td>
							<td><img src="<c:url value="/uploads/${x.avatar}" />"
						width="60" height="80"></td>
							<td>
								<div class="stroke">
									<a href="delete/${x.maNv}"><button style="background-color: #F5F7FA" class="btn btn-light" onclick="if (!confirm('Bạn có muốn xóa sinh viên này không?')) return false">
										<i class="fa fa-trash"></i>
										</button></a> <!-- delete button -->
									<a href="editform/${x.maNv}"><button style="background-color: #F5F7FA" class="btn btn-light">
										<i class="fa fa-pencil"></i>
										</button></a><!-- edit button -->	
									<a href="view/${x.maNv}"><button style="background-color: #F5F7FA" class="btn btn-light">
										<i class="fa fa-eye"></i>
										</button></a>
								</div> 
							</td> 		
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</div>





<jsp:include page="/WEB-INF/view/templates/footer.jsp" />