<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
				<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Update Vendor</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a
								href="/ffse-fbms/QuanTriTaiLieu/TaiLieu/">Danh tài liệu</a></li>
							<li class="breadcrumb-item active">Update tài liệu</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong>Update tài liệu</strong>

				</h1>
			</div>
		</div>
		<form:form method="POST" action="/ffse-fbms/QuanTriTaiLieu/TaiLieu/update"
			modelAttribute="document">


<%-- 			<div class="form-group col-sm-6">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

			</div> --%>
			<div class="form-group col-sm-6">
				<label>Tên tài liệu</label>
				<form:input class="form-control" path="ten_tai_lieu" placeholder="Tên tài liệu" />
				<form:errors path="ten_tai_lieu" cssStyle="color: red"></form:errors> 

			</div>
				 <form:hidden class="form-control" path="id" /> 
			<div class="form-group col-sm-6">
				<label>Mã danh mục</label>
				<form:select cssClass="form-control" path="ma_danh_muc">
										<option title="Mã danh mục"></option>
										<c:forEach var="sv" items="${listCategory}" begin="0"
											varStatus="counter">
											<form:option value="${sv.ma_danh_muc}" label="${sv.ma_danh_muc}"></form:option>
										</c:forEach>
									</form:select>
				<form:errors path="ma_danh_muc" cssStyle="color: red"></form:errors>

			</div>
			<div class="form-group col-sm-6">
				<label>File</label>
				<form:input class="form-control" path="file" placeholder="File" />
				<form:errors path="file" cssStyle="color: red"></form:errors> 

			</div>
			<div class="form-group col-sm-6">
				<label>Mã trạng thái</label>
				<form:select cssClass="form-control" path="ma_trang_thai">
										<option title="Mã trạng thái"></option>
										<c:forEach var="sv" items="${listStatus}" begin="0"
											varStatus="counter">
											<form:option value="${sv.ma_trang_thai}" label="${sv.ma_trang_thai}"></form:option>
										</c:forEach>
									</form:select>
			<form:errors path="ma_trang_thai" cssStyle="color: red"></form:errors>

			</div>
			<div class="form-group col-sm-6">
				<label>Mô tả</label>
				<form:input class="form-control" path="mo_ta" placeholder="Mô tả" />
				<form:errors path="mo_ta" cssStyle="color: red"></form:errors> 

			</div>
			<div class="form-group col-sm-6">
				<label>Ghi chú</label>
				<form:input class="form-control" path="ghi_chu" placeholder="Ghi chú" />
				<form:errors path="ghi_chu" cssStyle="color: red"></form:errors> 

			</div>
			<div class="form-group col-sm-6">
				<label>Mã phòng ban</label>
				<form:select cssClass="form-control" path="ma_phong_ban">
										<option title="Mã phòng ban"></option>
										<c:forEach var="sv" items="${listRoom}" begin="0"
											varStatus="counter">
											<form:option value="${sv.ma_phong_ban}" label="${sv.ma_phong_ban}"></form:option>
										</c:forEach>
									</form:select>
				<form:errors path="ma_phong_ban" cssStyle="color: red"></form:errors> 

			</div>
			<div class="col-sm-12 text-center">
				<button type="submit" class="btn btn-success">Sữa thông tin</button>
			</div>
		</form:form>
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
