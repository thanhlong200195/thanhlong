<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới công việc</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVuMinhHQ/" />'>Danh sách
									công việc</a></li>
							<li class="breadcrumb-item active">Thêm mới công việc</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<c:if test="${messageError ne null}">
				<div class="alert alert-danger alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageError}
				</div>
			</c:if>
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="CongViec"
						action="/ffse-fbms/QuanLyNhiemVuMinhHQ/create">
						<div class="form-group col-sm-6">
							<label>Dự án</label>
							<form:errors style="color:red" path="duAn.maDuAn" />
							<form:select class="custom-select block round" path="duAn.maDuAn">
								<c:forEach items="${DuAn}" var="lb">
									<form:option value="${lb.maDuAn}" label="${lb.tenDuAn}"></form:option>
								</c:forEach>
							</form:select>

						</div>
						<div class="form-group col-sm-6">
							<label>Tên công việc</label>
							<form:input class="form-control block round" path="tenCongViec" />
							<form:errors path="tenCongViec" cssStyle="color: red"></form:errors>
						</div>
						<div class="form-group col-sm-6">
							<label>Loại công việc</label>
							<form:select class="custom-select block round"
								path="maCongViec.maCongViec">
								<c:forEach items="${LoaiCongViec}" var="cv">
									<form:option value="${cv.maCongViec}"
										label="${cv.loaiCongViec}"></form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							<form:input class="form-control block round"
								path="maTrangThai.maTrangThai" value="1" readonly="true" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian bắt đầu</label>
							<form:input class="form-control block round" type="date"
								path="tgBatDau" />
							<form:errors cssStyle="color:red" path="tgBatDau" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian kết thúc</label>
							<form:input class="form-control block round" type="date"
								path="tgKetThuc" />
							<form:errors cssStyle="color:red" path="tgKetThuc" />
						</div>
						<div class="form-group col-sm-6">
							<label>phân công</label>
							<form:select class="custom-select block round"
								path="phanCong.maNhanVien">
								<c:forEach items="${NhanVien}" var="nv">
									<form:option value="${nv.maNhanVien}"
										label="${nv.hoDem} ${nv.ten}"></form:option>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian dự kiến</label>
							<form:input class="form-control block round" path="tgDuKien" />
							<form:errors cssStyle="color:red" path="tgDuKien" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mô tả</label>
							<form:textarea class="form-control block round" path="moTa" />
							<form:errors cssStyle="color:red" path="moTa" />
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success round">Lưu
								thông tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
