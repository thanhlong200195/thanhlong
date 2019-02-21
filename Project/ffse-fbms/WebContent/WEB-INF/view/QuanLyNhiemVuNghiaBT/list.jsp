<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<h3 class="content-header-title mb-0">Danh sách nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/QuanLyNhiemVuNghiaBT/create"/>"
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
							<h4 class="card-title">Danh sách nhiệm vụ</h4>
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
												<th>STT</th>
												<th>Tên Công Việc</th>
												<th>Thuộc tính</th>
												<th>Bắt Đầu</th>
												<th>Kết Thúc</th>
												<th>phân công</th>
												<th>Trạng thái</th>
												<th>Hoạt động</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="cv" items="${listNhiemVu}" begin="0"
												varStatus="counter">
												<tr>
													<td>${(page)*2 + counter.count}</td>
													<td>${cv.tenCongViec}</td>
													<td>${cv.maCongViec.loaiCongViec}</td>
													<td>${cv.tgBatDau}</td>
													<td>${cv.tgKetThuc}</td>
													<td>${cv.phanCong.hoDem}${cv.phanCong.ten}</td>
													<td>${cv.maTrangThai.trangThai}</td>
													<td style="letter-spacing: 5px"><a
														href="/ffse-fbms/QuanLyNhiemVuNghiaBT/view/${cv.ID}"><i
															class='fa fa-eye'></i></a> <a
														href="/ffse-fbms/QuanLyNhiemVuNghiaBT/edit/${cv.ID}"><i
															class='fa fa-pencil'></i></a> <a
															href="/ffse-fbms/QuanLyNhiemVuNghiaBT/delete/${cv.ID}"><i
															class='fa fa-trash'
															onclick="return confirm('Bạn có muốn xóa sinh viên này?');"></i></a>
													</td>
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