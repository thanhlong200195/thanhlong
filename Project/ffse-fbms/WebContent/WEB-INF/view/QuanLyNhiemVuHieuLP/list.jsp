<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>

.tbl_actions a {
	color: #333;
	font-size: 13px;
	display: inline-block;
	padding: 2px 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #FFF;
}

.tbl_actions a i {
	margin-right: 3px;
}

.green {
	color: #5cb85c;
}

.blue {
	color: #337ab7;
}

.red {
	color: #d9534f;
}

#datatable tr td:last-child {
	letter-spacing: 15px;
	min-width: 100px;
	text-align: center !important;
}

#datatable>thead>tr>th:last-child[class*="sort"]::after {
	content: ""
}

#datatable>thead>tr>th:last-child[class*="sort"]::before {
	content: ""
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0" >Danh sách nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active" >Danh sách nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/HieuLP/create"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span> Thêm
						mới</a>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">

			<!-- Show message -->
			<c:if test="${messageSuccess ne null}">
				<div class="alert alert-success alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSuccess}
				</div>
			</c:if>
		
			<!-- End Show message -->
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<h4 class="content-header-title mb-0" style="margin-left: 400px">Danh sách nhiệm vụ</h4>
							<a class="heading-elements-toggle"><i
								class="fa fa-ellipsis-v font-medium-3"></i></a>
							<div class="heading-elements">
								<ul class="list-inline mb-0">
									<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
									<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
									<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
									<li><a data-action="close"><i class="ft-x"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
						  	<form:form method="GET" action="">
						  	<div class="form-group col-sm-10">
								<div class="form-group col-sm-4">
								 	<label >Dự án</label>
								 	 <select class="custom-select block round" name= "maDuan"
										id="maDuan">
										<option value="0" label="Tất cả" />
										<c:forEach items="${duan}" var="ld">
											<option value="${ld.maDuan}" label="${ld.tenDuan}" />
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-sm-4">
								 	<label>Phân công cho</label>
								 	 <select class="custom-select block round" name= "maNhanVien"
										id="maNhanVien">
										<option value="0" label="Tất cả" />
										<c:forEach items="${nhanVienHLP}" var="ld">
											<option value="${ld.maNhanVien}" label="${ld.hoDem} ${ld.ten}" />
										</c:forEach>
									</select>
								</div>
								<div class="form-group col-sm-4">
								 	<label>Trạng thái</label>
								 	 <select class="custom-select block round" name="IDtrangthai"
										id="IDtrangthai">
										<option value="0" label="Tất cả" />
										<c:forEach items="${trangthai}" var="ld">
											<option  value="${ld.IDtrangthai}" label="${ld.loaiTrangthai}" />
										</c:forEach>
									</select>
								</div>
							</div>
								<script type="text/javascript">
									maDuan = <%= request.getParameter("maDuan") %>;
									if (maDuan != 0 && maDuan != null) {
										$("#maDuan").val(maDuan);
									}
									maNhanVien = <%= request.getParameter("maNhanVien") %>;
									if (maNhanVien != 0 && maNhanVien != null) {
										$("#maNhanVien").val(maNhanVien);
									}
									IDtrangthai = <%= request.getParameter("IDtrangthai") %>;
									if (IDtrangthai != 0 && IDtrangthai != null) {
										$("#IDtrangthai").val(IDtrangthai);
									}
								</script>
							<div class="form-group col-sm-2">
							  
						<button class="btn btn-success" style="margin-top: 25px"><i class="ft-search"></i> Áp dụng</button>
							</div>
							</form:form>
									<table id="datatable" class="table ">
										<thead class="thead-dark">
											<tr style="background-color: #2A2E30; border-color: black; color: #F5F7FA;">
												<th scope="col">STT</th>
												<th scope="col">Tên dự án</th>
												<th scope="col">Tên công việc</th>
												<th scope="col">Loại công việc</th>
												<th scope="col">Trạng thái</th>
												<th scope="col">Người được phân công</th>
												<th scope="col">Tùy chọn</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${list}" var="nv" varStatus="stt">
												<tr>
											        <td>${(currentPage-1)*10 + stt.count}</td>	
											        <td>${nv.duAn.tenDuan}</td>		
											        <td>${nv.tenCongviec} </td>						
											        <td>${nv.idLoaiCongviec.loaiCongviec}</td>
											        <td>${nv.idLoaiTrangthai.loaiTrangthai}</td>
											        <td>${nv.nhanVien.hoDem} ${nv.nhanVien.ten}</td>
													<td style="letter-spacing: 10px">
														<a href="/ffse-fbms/HieuLP/view/${nv.ID}"><i class='fa fa-eye'></i></a> 
														<a href="/ffse-fbms/HieuLP/edit/${nv.ID}"><i class='fa fa-pencil'></i></a>
														<a href="/ffse-fbms/HieuLP/delete/${nv.ID}"><i class='fa fa-trash' onclick="return confirm('Bạn có muốn xóa sinh viên này?');"></i></a>
													</td>
												</tr>
										</c:forEach>
										</tbody>
										
									</table>
									<c:set scope="request" var="total" value="${total}" />
									<%
										String query = "&maDuan=" + request.getParameter("maDuan") + "&maNhanVien="
												+ request.getParameter("maNhanVien") + "&IDtrangthai=" + request.getParameter("IDtrangthai");
										
										if (request.getParameter("maDuan") == null) {
											query = "";
										}
									%>
									<nav aria-label="Page navigation example">
								<ul class="pagination" style="margin-left: 450px">
								<li class="page-item"><a class="page-link" href="?page=1<%=query%>">First
										Page</a></li>
								<c:if test="${currentPage > 2}">
									<li class="page-item"><a class="page-link"
										href="?page=${currentPage-2}<%=query%>">${currentPage-2}</a></li>
								</c:if>
								<c:if test="${currentPage > 1}">
									<li class="page-item"><a class="page-link"
										href="?page=${currentPage-1}<%=query%>">${currentPage-1}</a></li>
								</c:if>
								<li class="page-item active"><a class="page-link"
									href="?page=${currentPage}<%=query%>">${currentPage}</a></li>
								<c:if test="${currentPage < total}">
									<li class="page-item"><a class="page-link"
										href="?page=${currentPage+1}<%=query%>">${currentPage+1}</a></li>
								</c:if>
								<c:if test="${currentPage < total - 1}">
									<li class="page-item"><a class="page-link"
										href="?page=${currentPage+2}<%=query%>">${currentPage+2}</a></li>
								</c:if>
								<li class="page-item"><a class="page-link"
									href="?page=${total}<%=query%>">Last Page</a></li>
							</ul>
						</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
window.setTimeout(function() {
	$(".alert").fadeTo(500, 0).slideUp(500, function() {
		$(this).remove();
	});	
}, 2500);
</script>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
