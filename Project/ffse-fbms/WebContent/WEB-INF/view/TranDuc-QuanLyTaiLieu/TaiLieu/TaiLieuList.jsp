<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/templates/header.jsp" />
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<!-- Path -->
			<div class="content-header row">
				<div class="content-header-left col-md-9 col-xs-12 mb-2">
					<h3 class="content-header-title mb-0">Danh Sách Tài Liệu</h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a
									href='<c:url value="/home" />'>Home</a></li>
								<li class="breadcrumb-item active">Danh Sách Tài Liệu</li>
							</ol>
						</div>
					</div>
				</div>
				<div class="content-header-right col-md-3 col-xs-12">
					<div role="group" aria-label="Button group with nested dropdown"
						class="btn-group float-md-right" id="add-new">
						<a class="btn btn-primary"
							href='<c:url value = "/TranDuc-QuanLyTaiLieu/TaiLieu/add" />'>Thêm
							Mới<span data-i18n="" class="ft-plus-square"></span>
						</a>
					</div>
				</div>
			</div>
			<!-- End Path -->
			<div class="content-body">
				<c:if test="${messageSuccess ne null}">
					<div class="alert alert-success alert-dismissable" role="alert">
						<button type="button" class="close" data-dismiss="alert">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						${messageSuccess}
					</div>
				</c:if>
				<c:if test="${messageError ne null}">
					<div class="alert alert-danger alert-dismissable" role="alert">
						<button type="button" class="close" data-dismiss="alert">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						${messageError}
					</div>
				</c:if>
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Danh Sách Tài Liệu</h4>
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
										<table id="datatable"
											class="table table-striped table-bordered dataex-res-constructor">
											<thead>
												<tr>
													<th>ID</th>
													<th>Mã Tài Liệu</th>
													<th>Tên Danh Mục</th>
													<th>Icon</th>
													<th>Tên Tài Liệu</th>
													<th>Mã Phòng Ban</th>
													<th>Mô Tả</th>
													<th>Link</th>
													<th>Trạng Thái</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:if test="${not empty listTaiLieu}">
													<c:forEach var="item" items="${listTaiLieu}" begin="0"
														varStatus="counter">
														<tr>
															<td>${item.idTL}</td>
															<td>${item.maTL}</td>
															<td>${item.danhMuc.maDM}</td>
															<td><image src="<c:url value="${icon.linkIcon}"/> "
																	alt="icon"></image></td>
															<td>${item.tenTL}</td>
															<td>${item.phongBan.maPhongBan}</td>
															<td>${item.motaTL}</td>
															<td>${item.link}</td>
															<td>${item.trangThai.maTT}</td>
															<td class="tbl_actions">
																<div class="row">
																	<a
																		href="<c:url value="/TranDuc-QuanLyTaiLieu/TaiLieu/view/${item.idTL}" />"
																		title="Xem"> <i class="fa fa-eye"
																		aria-hidden="true"> </i></a> <a
																		href="<c:url value="/TranDuc-QuanLyTaiLieu/TaiLieu/sua/${item.idTL}" />"
																		title="Sửa"> <i class="fa fa-pencil-square-o blue"
																		aria-hidden="true"> </i></a> <a
																		href="<c:url value="/TranDuc-QuanLyTaiLieu/TaiLieu/xoa/${item.idTL}" />"
																		title="Xóa"
																		onclick="return confirm('Bạn có chắc muốn xóa ?')">
																		<i class="fa fa-trash red" aria-hidden="true"> </i>
																	</a>
																</div>
															</td>
														</tr>
													</c:forEach>
												</c:if>
											</tbody>
										</table>
										<center>
											<nav aria-label="Page navigation example">
											<ul class="pagination">
												<li class="page-item"><a class="page-link"
													href="?page=1">First Page</a></li>
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
												<li class="page-item"><a class="page-link"
													href="?page=${lastPage}">Last Page</a></li>
											</ul>
											</nav>
										</center>
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
</body>
</html>