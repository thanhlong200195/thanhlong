<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
		<div>
		<div class="col-md-5"></div>
			<h3 >Danh sách đang chờ duyệt</h3>
		</div>
			<div>
			<div><a href="donxinphep003"><h4>Thêm đơn mới</h4></a></div>
			<div class="container">
			    <div class="table-responsive">
						<table class="table mb-0">
							<thead>
				<tr>
					<th >Mã đơn</th>
					<th >Mã nhân viên</th>
					<th >Ngày bắt đầu</th>
					<th >Ngày kết thúc</th>
					<th >Lý do</th>
					<th >Ghi chú</th>
					<th >Ghi chú của trưởng phòng</th>
					<th >Trạng thái</th>
					<th>Chức năng</th>
				</tr>
				</thead>
				<tbody>
			<c:forEach var="nv" items="${danhsachchoduyet003}">
					<tr>
					<td>${nv.id}</td>
					<td>${nv.ngayNghi.maNhanVien}</td>
					<td>${nv.ngayBatDau}</td>
					<td>${nv.ngayKetThuc}</td>
					<td>${nv.lyDo.lyDo}</td>
					<td>${nv.ghiChu}</td>
					<td>${nv.ghiChuTruongPhong}</td>
					<td>${nv.trangThai.trangThai}</td>
					<td><a  href="suadoncho/${nv.id }"><button class="btn btn-success">
									Sửa</button></a> 
					</td>
						</tr>
				</c:forEach>
				</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="?page=1">First
				Page</a></li>
		<c:if test="${currentPage > 2}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage-2}">${currentPage-2}</a></li>
			</c:if>
			<c:if test="${currentPage > 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage-1}">${currentPage-1}</a></li>
			</c:if>
			<li class="page-item active"><a class="page-link"
				href="?page=${currentPage}">${currentPage}</a></li>
			<c:if test="${currentPage < lastPage}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage+1}">${currentPage+1}</a></li>
			</c:if>
			<c:if test="${currentPage < lastPage - 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage+2}">${currentPage+2}</a></li>
			</c:if>
		<li class="page-item"><a class="page-link" href="?page=${lastPage }">Last Page</a></li>
	</ul>
	</nav>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>
<script>
		function canhbao() {
			return confirm("Bạn Có Chắc Muốn Xóa Không?");
		}
	</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />