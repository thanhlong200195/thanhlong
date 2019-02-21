<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Chỉnh sửa Trạng thái</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/status/list-status" />'>Danh
									sách Trạng thái</a></li>
							<li class="breadcrumb-item active">Chỉnh sửa Trạng thái</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST"
						action="/ffse-fbms/mvpquanliduan/status/update"
						modelAttribute="status">
						<div class="form-group col-sm-6">
							<form:hidden path="idStatus" />
							<form:hidden path="status" />
							<label>Tên Trạng thái</label><br>
							<form:errors path="nameStatus" cssClass="error" />
							<form:input path="nameStatus" class="form-control round"
								placeholder="Tên Trạng thái" />
						</div>
							<div class="form-group col-sm-6">
							
							<label>Màu trạng thái</label><br>
							<form:input path="color" type="color" id="color" value="${status.color }"/>
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-outline-success round btn-min-width mr-1 mb-1"><i class="fa fa-check-square-o"></i> Lưu </button>
						</div>	
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
