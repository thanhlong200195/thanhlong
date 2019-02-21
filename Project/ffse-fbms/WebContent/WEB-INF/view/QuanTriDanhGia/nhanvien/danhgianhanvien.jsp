<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/QuanTriDanhGia/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Đánh giá nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quantridanhgia/home/"/>">Quản trị
									đánh giá</a></li>
							<li class="breadcrumb-item active">Đánh giá nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${empty listDanhGiaNhanVien}">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-content">
							<div class="card-body" style="margin: 1em">
								<h2>Chưa có phân công đánh giá nào</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${not empty listDanhGiaNhanVien}">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách nhân viên cần đánh giá</h4>
					</div>
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Nhân viên</th>
											<th scope="col">Xếp loại</th>
											<th scope="col">Hoạt động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listDanhGiaNhanVien }" var="x"
											varStatus="stt">
											<tr>
												<th scope="row">${stt.index + 1 }</th>
												<td>${x.nhanVien }</td>
												<td>${x.xepLoai }</td>
												<td><c:if test="${x.xepLoai !=0 }">
														<a class="btn btn-info"
															href="<c:url value = "/quantridanhgia/nhanvien/danhgianhanvien/view/${x.id }" />">Xem</a>
													</c:if> <c:if test="${x.xepLoai == 0 }">
														<a class="btn btn-info"
															href="<c:url value = "/quantridanhgia/nhanvien/danhgianhanvien/add/${x.nhanVien }/${x.id }" />">Tạo</a>
													</c:if></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>