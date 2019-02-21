<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.card-block input {
	border: 0;
	border-radius: 0;
}

.card-block .table td {
	padding-left: 0px;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Xem chi tiết nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVuMinhHQ/" />'>Danh sách
									nhiệm vụ</a></li>
							<li class="breadcrumb-item active">Thông tin công việc</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Thông tin công việc</h4>
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

							<label>Dự án</label> 
<%-- 								<input class="form-control" value="${list.duAn.tenDuAn}" readonly />  --%>
							<label>Tên công việc</label> 
								<input class="form-control" value="${list.tenCongViec}" readonly /> 
							<label>Loại công việc</label> 
<%-- 								<input class="form-control" value="${list.maCongViec.loaiCongViec}" readonly />  --%>
							<label>Mô tả</label>
								<textarea class="form-control" readonly>${list.moTa}</textarea>
							<label>Thời gian bắt đầu</label> 
								<input class="form-control" type="date" value="${list.tgBatDau}" readonly /> 
							<label>Thời gian kết thúc</label> 
								<input class="form-control" type="date" value="${list.tgKetThuc}" readonly /> 
							<label>phân công</label> 
								<input class="form-control" value="${list.phanCong.hoDem} ${list.phanCong.ten}" readonly /> 
							<label>Thời	gian dự kiến</label> 
								<input class="form-control" value="${list.tgDuKien}" readonly /> 
							<label>Trạng thái</label> 
								<input class="form-control" value="${list.maTrangThai.trangThai}" readonly />

					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
