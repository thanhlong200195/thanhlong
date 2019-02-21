<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm Dự Án</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a href="/ffse-fbms/qlda/DuAn/">Danh
									sách Dự Án</a></li>
							<li class="breadcrumb-item active">Thêm dự án</li>
						</ol>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<h1>
				<strong>THÊM DỰ ÁN</strong>
			</h1>
		</div>
	</div>
	<form:form method="POST" action="/ffse-fbms/qlda/DuAn/creat"
		modelAttribute="duAn">
		<div class="form-group col-sm-6">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <label>Mã dự án</label>
			<form:input class="form-control" path="maDuAn" placeholder="maDuAn" />
			<form:errors path="maDuAn" cssStyle="color: red"></form:errors>
		</div>

		<div class="form-group col-sm-6">
			<label>Tên dự án</label>
			<form:input class="form-control" path="tenDuAn"
				placeholder="Tên dự án" />
			<form:errors path="tenDuAn" cssStyle="color: red"></form:errors>
		</div>

		<div class="form-group col-sm-6">
			<label>Mô tả dự án</label>
			<form:textarea path="moTaDuAn" cssClass="form-control round"  style="height:calc(2.95rem - 2px);"/>
			<form:errors path="moTaDuAn" cssStyle="color: red"></form:errors>
		</div>
		
		<c:set var="khang" value="${duAn.khachHang.makh }"></c:set>
		<div class="form-group col-sm-6">
			<label>Tên Khách Hàng</label>
			<form:select path="khachHang" cssClass="form-control round"
				mutiple="mutiple">
				<option value=""></option>
				<c:forEach items="${khachhang}" var="kh">
					<option value="${kh.makh }"
						<c:if test="${kh.makh == khang }" >selected="selected"</c:if>>${kh.tenkh}</option>
				</c:forEach>
				<form:errors path="KhachHang" cssStyle="color: red"></form:errors>
			</form:select>
		</div>
		<div class="form-group col-sm-6">
			<label>Trạng thái</label>
			<form:select path="trangThai" cssClass="form-control round"
				mutiple="true">
				<c:forEach items="${TrangThai}" var="tt">
					<option value="${tt.maTrangThai }">${tt.tenTrangThai}</option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group col-sm-6">
			<label>Nghiệp vụ</label>
			<form:select path="Domain" cssClass="form-control round"
				mutiple="true">
				<c:forEach items="${Domain}" var="domain">
					<option value="${domain.maNghiepVu}">${domain.tenNghiepVu}</option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group col-sm-6">
			<label>Tên Database</label>

			<form:select path="database" cssClass="form-control round"
				mutiple="true">
				<c:forEach items="${database}" var="db">
					<option value="${db.maDatabase }">${db.tenDatabase }
					</option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group col-sm-6">
			<label>Tên Framework</label>

			<form:select path="Framework" cssClass="form-control round"
				mutiple="true">
				<c:forEach items="${Framework}" var="fw">
					<option value="${fw.ma_framework }">
						${fw.ten_framework}</option>
				</c:forEach>
			</form:select>
		</div>

		<div class="form-group col-sm-6">
			<label>Tên Technical</label>

			<form:select path="Technical" cssClass="form-control round"
				mutiple="true">
				<c:forEach items="${Technical}" var="tc">
					<option value="${tc.ma_cong_nghe }">
						${tc.ten_cong_nghe}</option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group col-sm-6">
			<label>Tên Vendor</label>

			<form:select path="Vendor" cssClass="form-control round"
				mutiple="true">
				<c:forEach items="${Vendor}" var="vd">
					<option value="${vd.mavd }">${vd.tenvd }</option>
				</c:forEach>
			</form:select>
		</div>
	<div class="form-group col-sm-6">
			<label>Ngôn ngữ</label>

			<form:select path="ngonNgu" cssClass="form-control round"
				mutiple="true">
				<c:forEach items="${NgonNgu}" var="vd">
					<option value="${vd.maNn }">${vd.tenNn }</option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group col-sm-6">
			<label>Start Date</label>
			<form:input path="startDate" cssClass="form-control round"
				type="date" />
			<form:errors path="startDate" cssStyle="color: red"></form:errors>
			<div class="help-block"></div>
		</div>
		<div class="form-group col-sm-6">
			<label>End Date</label>
			<form:input path="endDate" cssClass="form-control round" type="date" />
			<form:errors path="endDate" cssStyle="color: red"></form:errors>
			<div class="help-block"></div>
		</div>




		<div class="col-sm-12 text-center">
			<button type="submit" class="btn btn-success">Lưu thông tin</button>
		</div>
	</form:form>
	<div class="col-sm-4">
		<c:if test="${message !=null }">
						 ${message }
			</c:if>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
