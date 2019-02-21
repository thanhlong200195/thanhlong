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
				<div class="card-header">
					<h4 class="card-title">Danh sách nhân viên đánh giá</h4>
				</div>
				<div class="card-content">
					<div class="card-body" style="margin: 1em">
						<div class="table-responsive">
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th scope="col">#</th>
										<th scope="col">Bản đánh giá</th>
										<th scope="col">Xếp loại</th>
										<th scope="col">Hành động</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listDanhGia }" var="x" varStatus="stt">
										<tr>
											<th scope="row">${stt.index+1 }</th>
											<td>Nhân viên ${stt.index+1 }</td>
											<td>${x.xepLoai }</td>
											<td><a class="btn btn-info"
												href="<c:url value="/quantridanhgia/nhanvien/nhanviendanhgia/view/${x.id}" />">Xem</a></td>
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
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>