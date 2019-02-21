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
				<h3 class="content-header-title mb-0">Danh sách đánh giá</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quantridanhgia/home/"/>">Quản trị
									đánh giá</a></li>
							<li class="breadcrumb-item active">Danh sách đánh giá</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="card">
				<div class="card-content">
					<div class="card-body" style="margin: 1em">
						<form:form cssClass="form"
							action="/ffse-fbms/quantridanhgia/phongnhansu/danhsachdanhgia/search">
							<div class="form-body">
								<h4 class="form-section">
									<i class="fa fa-plus"></i>Tìm kiếm đánh giá
								</h4>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="projectinput1">Kỳ đánh giá</label>
											<form:select path="kyDanhGia" cssClass="form-control">
												<form:option value="">Chọn kỳ đánh giá</form:option>
												<c:forEach items="${listKyDanhGia }" var="x">
													<form:option value="${x.maKy }" label="${x.tenKy}"></form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="projectinput2">Phòng ban</label>
											<form:select path="phongBan" cssClass="form-control">
												<form:option value="">Chọn phòng ban</form:option>
												<c:forEach items="${listPhongBan }" var="x">
													<form:option value="${x.maPhongBan }"
														label="${x.tenPhongBan}"></form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" style="padding-top: 1.9rem">
											<button class="btn btn-primary" type="submit">Tìm
												kiếm</button>
										</div>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${empty listDanhgia}">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Chưa có bản đánh giá nào</h4>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${not empty listDanhgia}">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách đánh giá nhân viên</h4>
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
											<th scope="col">Trang Thái</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listDanhgia}" var="x" varStatus="stt">
											<tr>
												<th scope="row">${stt.index+1}</th>
												<td>${x.nhanVien }</td>
												<td>${x.danhGiaTongThe }</td>
												<td>${x.trangThai }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination firstLast1-links">
									<c:if test="${pageDanhGia > 1 }">
										<li class="page-item first"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/1" />"
											class="page-link">First</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${pageDanhGia-1 }" />"
											class="page-link">Prev</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${pageDanhGia-1 }" />"
											class="page-link">${pageDanhGia-1 }</a></li>
									</c:if>
									<li class="page-item active"><a href="#" class="page-link">${pageDanhGia}</a></li>
									<c:if test="${pageDanhGia < total }">
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${pageDanhGia+1 }" />"
											class="page-link">${pageDanhGia+1 }</a></li>
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${pageDanhGia+1 }" />"
											class="page-link">Next</a></li>
										<li class="page-item last"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${total}" />"
											class="page-link">Last</a></li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>
<jsp:include page="/WEB-INF/view/QuanTriDanhGia/templates/footer.jsp"></jsp:include>