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
		<div  class="col-md-6"></div>
		<div class="col-md-6">
			<h3 class="content-header-title mb-0">bảng thống kế </h3>
		</div>
		</div>
			<div>
			<div><a  class="btn btn-outline-success round btn-min-width mr-1 mb-1" href="themmoi"><h4><spring:message code="label.themMoi"/></h4></a></div>
			<div class="container">
			    <div class="table-responsive">
						<table class="table mb-0">
							<thead>
				<tr>
					<th >STT</th>
					<th>Mã Nhân Viên</th>
					<th>số ngày  dã nghi</th>
					<th>số ngày còn lại</th>
					<th>chức năng</th>
				</tr>
				</thead>
				<tbody>
			<c:forEach var="nn" items="${ngaynghiphep}" varStatus="count"   >
                    <tr> 
                     <th scope="row">${count.count  }</th>
					<td>${nn.maNhanVien}</td>
					<td>${nn.soNgayNghi}</td>
					<td>${nn.ngayNghiConLai}</td>
					<td><a href="deleteDate/${nn.maNhanVien}" class="btn btn-outline-danger round  mr-1 mb-1"
									onclick="return confirm('Bạn có muốn xóa sinh viên này?');">xóa</a>
						<a href="updateDate/${nn.maNhanVien}" class="btn btn-outline-danger round  mr-1 mb-1">sửa</a>
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


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
