﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<h3 class="content-header-title mb-0">Sửa Hợp Đồng</h3>
		<div class="row breadcrumbs-top">
			<div class="breadcrumb-wrapper col-xs-12">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/" />'>Danh
							Sách Nhân Viên</a></li>
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/view/${maNv }" />'>Thông
							Tin Nhân Viên</a></li>
					<li class="breadcrumb-item"><a
						href='<c:url value="/QuanTriNhanSu/quanlihopdong/viewOneHopDong/${maNv}" />'>Hợp
							Đồng Nhân Viên</a></li>
					<li class="breadcrumb-item active">Sửa Hợp Đồng</li>
				</ol>
			</div>
		</div>
		<form:form class="form" method="POST" modelAttribute="hopDongPikalong"
			action="/ffse-fbms/QuanTriNhanSu/quanlihopdong/edithd">
			<div class="form-body">
				<div class="form-section"></div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Mã Nhân Viên</label> <input class="form-control"
								value="${hsnv.maNv}" disabled type="text" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Trạng Thái</label>
							<div class="form-control disabled">${hsnv.isActive}</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Phòng ban</label>
							<div class="form-control well">${hsnv.maPhongBan}</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Chức danh</label>
							<div class="form-control well">${hsnv.maChucDanh}</div>
						</div>
					</div>
				</div>
				<h4 class="form-section">
					<i class="ft-user"></i> Thông Tin Hợp Đồng
				</h4>
				<div class="row">
					<div class="col-md-12">
						<label>Mã hợp đồng</label>
						<form:input path="maHopDong" type="text" class="form-control" readonly="true"/>
					</div>
					<form:hidden path="hoSoNhanVienPikalong.maNv" value="${hsnv.maNv}" />
					<div class="col-md-6">
						<div class="form-group">
							<label>Tên hợp đồng</label>
							<form:select path="loaiHopDongPikalong.maLoaiHopDong" id="tenHd"
								name="tenHdSelect" class="form-control">
								<option value="none" selected="true" disabled="true">
									<--Chọn--></option>
								<form:option value="1">Hợp đồng thử việc</form:option>
								<option value="2">Hợp đồng ngắn hạn</option>
								<option value="3">Hợp đồng chính thức</option>

							</form:select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Trạng thái</label>
							<form:select path="trangThai" class="form-control">
								<form:option value="0" selected="true" disabled="true"> <--Chọn--> </form:option>
								<form:option value="1">Hết hợp đồng</form:option>
								<form:option value="2">Còn hợp đồng</form:option>
							</form:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label>Lương tháng 13</label>
							<form:select path="luongThang13" class="form-control">
								<form:option value="" selected="true" disabled="true"> <--Chọn--> </form:option>
								<form:option value="1">Có</form:option>
								<form:option value="2">Không</form:option>
							</form:select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Số ngày nghỉ trong năm</label>
							<form:input path="soNgayNghiTrongNam" type="text"
								id="soNgayNghiTrongNam" class="form-control" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Ngày ký hợp đồng</label>
							<form:input path="ngayKiKet" type="date" id="ngayKyKet"
								class="form-control" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label>Ngày kết thúc hợp đồng</label>
							<form:input path="ngayKetThuc" type="date" id="ngayKetThuc"
								class="form-control" />
						</div>
					</div>
				</div>
			</div>
			<div class="form-actions center">
				<button type="submit" class="btn btn-info btn-min-width mr-1 mb-1">
					<i class="fa fa-check"></i> Lưu
				</button>

			</div>
		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
