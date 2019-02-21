
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid" >
	<div class="content-wrapper">
		<div class="content-header-left col-md-9 col-xs-12 mb-2">
			<h3 class="content-header-title mb-0">Danh sách Vai Trò</h3>
			<div class="row breadcrumbs-top">
				<div class="breadcrumb-wrapper col-xs-12">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
						<li class="breadcrumb-item active">VAI TRÒ</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	<div class="content-body">

		<!-- Show message -->


		<!-- End Show message -->

		<div class="row">
			<div class="col-xs-12">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách</h4>
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

								<table class="table">
									<thead>
										<tr>
											<th>STT</th>
											<th>Tên Dự Án</th>
											<th>Tên Nhân Viên</th>
											<th>Vai trò</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:set var="maDuAn" value="${duan.maDuAn }" />
										<c:set var="tenDuAn" value="${duan.tenDuAn }" />
										<c:forEach var="nv" items="${nhiemvu }" varStatus="count">
											<tr>
												<th scope="row">${count.count }</th>
												<td>${tenDuAn }</td>
												<td><c:forEach var="nhanVien" items="${duan.nhiemVu }">
														<c:if test="${nhanVien.maNhanVien==nv.maNhanVien }">${nhanVien.hoDem } ${nhanVien.ten }</c:if>

													</c:forEach></td>
												<td><c:forEach var="nhanVien" items="${duan.nhiemVu}">
														<c:if test="${nhanVien.maNhanVien==nv.maNhanVien }">
															<c:forEach var="vaitro" items="${nhanVien.vaiTro}">
																<c:if test="${vaitro.mavt==nv.maVaiTro}">${vaitro.tenvt}</c:if>
															</c:forEach>
														</c:if>

													</c:forEach></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row"></div>
	</div>
	<div class="col-sm-4">

		<c:if test="${message !=null }">
						 ${message }
			</c:if>

	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
