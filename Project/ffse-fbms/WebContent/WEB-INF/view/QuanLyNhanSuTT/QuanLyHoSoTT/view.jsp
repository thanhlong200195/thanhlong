
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thông Tin Nhân Viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/ho_so/" />'>Danh sách
									nhân viên</a></li>
							<li class="breadcrumb-item active">xem thông tin nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
			<c:if test="${empty add}">
				<style>
i.fa {
	width: 20px;
}
</style>
				<div class="content-header-right col-md-3 col-xs-12">
					<div role="group" aria-label="Button group with nested dropdown"
						class="dropdown nav-item float-md-right">
						<div role="group" class="btn-group">
							<button id="btnGroupDrop1" type="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"
								class="btn btn-outline-primary dropdown-toggle">
								<i class="ft-settings icon-left"></i>
								<spring:message code="label.thongTinKhac" />
							</button>
							<div aria-labelledby="btnGroupDrop1"
								class="dropdown-menu dropdown-menu-right">
								<a href="<c:url value = "#"/>" class="dropdown-item"><i
									class="fa fa-id-card-o"></i> <spring:message
										code="label.thongTinHoSo" /></a> <a
									href="<c:url value = "/quanlynhansutt/bang_cap/viewOneBangCap/${maNhanVien}"/>"
									class="dropdown-item"><i class="fa fa-graduation-cap"></i>
									<spring:message code="label.thongTinBangCap" /></a> <a
									href="<c:url value = "/quanlynhansutt/gia_dinh/viewOneGiaDinh/${maNhanVien}"/>" class="dropdown-item"><i
									class="fa fa-users"></i> <spring:message
										code="label.thongTinGiaDinh" /></a> <a
									href="<c:url value = "/quanlynhansutt/kinh_Nghiem/viewOneKinhNghiem/${maNhanVien}"/>" class="dropdown-item"><i
									class="fa fa-file-code-o"></i> <spring:message
										code="label.thongTinKinhNghiem" /></a> <a
									href="<c:url value = "/quanlynhansutt/hop_dong/viewOneHopDong/${maNhanVien}"/>"
									class="dropdown-item"><i class="fa fa-handshake-o"></i> <spring:message
										code="label.thongTinHopDong" /></a>
								<div class="dropdown-divider"></div>
								<a href="<c:url value = "/quanlynhansutt/ho_so/viewOne/${maNhanVien}"/>"
									class="dropdown-item text-xs-center"><spring:message
										code="label.xemTatCa" /></a>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="horz-layout-basic">Thông Tin
										Của nhân viên</h4>
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
									<div class="card-block">
										<div class="card-body collapse in">
											<div class="card-block">
												<form:form method="POST" action="update"
													modelAttribute="formHoso" enctype="multipart/form-data">
													<div class="form-body">
														<div class="row">
															<div class="col-md-8">
																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>mã nhân viên</label>
																		<form:input class="form-control" path="maNhanVien"
																			placeholder="mã nhân viên" readonly="true" />
																	</div>
																	<div class="form-group col-sm-6">
																		<label>tên nhân viên</label>
																		<form:input class="form-control" path="tenNhanVien"
																			placeholder="tên nhân viên" readonly="true" />
																	</div>

																</div>

																<div class="row">
																	<div class="form-group col-sm-6">
																		<div class="form-group">
																			<label>giới tính</label>
																			<form:input class="form-control" path="gioiTinh"
																				placeholder="tên nhân viên" readonly="true" />
																			<c:if test="${hsnv.gioiTinh == 1}">
																				<spring:message code="label.nam" />
																			</c:if>
																			<c:if test="${hsnv.gioiTinh == 2}">
																				<spring:message code="label.nu" />
																			</c:if>
																		</div>
																	</div>
																	<div class="form-group col-sm-6">
																		<label for="projectinput2">Tình trạng hôn nhân</label>
																		<form:input class="form-control"
																			path="tinhTrangHonNhan.tinhTrangHonNhan"
																			readonly="true" />
																	</div>
																</div>

																<div class="row">
																	<div class="form-group col-sm-6">
																		<div class="form-group">
																			<label for="projectinput4">Số CMND</label>
																			<form:input path="soCmnd" type="text"
																				id="projectinput4" class="form-control"
																				placeholder="Số CMND" readonly="true" />
																		</div>
																	</div>
																	<div class="form-group col-sm-6">
																		<label for="projectinput4">Nơi cấp</label>
																		<form:input path="noiCap" type="text"
																			id="projectinput4" class="form-control"
																			placeholder="Nơi cấp" readonly="true" />
																	</div>
																</div>

																<div class="row">
																	<div class="form-group col-sm-6">
																		<label for="projectinput4">Ngày cấp</label>
																		<fieldset class="form-group position-relative">
																			<form:input placeholder="Ngày cấp" type="date"
																				class="form-control" path="ngayCap" readonly="true" />

																		</fieldset>
																	</div>
																	<div class="form-group col-sm-6">
																		<div class="form-group">
																			<label for="projectinput4">Dân tộc</label>

																		</div>
																	</div>
																</div>

																<div class="row">
																	<div class="form-group col-sm-6">

																		<label for="projectinput4">Quốc tịch</label>
																		<form:select path="quocTich" type="text"
																			id="projectinput4" class="form-control"
																			readonly="true">

																		</form:select>
																	</div>
																	<div class="form-group col-sm-6">
																		<label>năm sinh</label>
																		<form:input class="form-control" path="namSinh"
																			placeholder="năm sinh" readonly="true" />

																	</div>
																</div>


																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>số điện thoại</label>
																		<form:input class="form-control" path="soDienThoai"
																			placeholder="số điện thoại" readonly="true" />
																	</div>
																	<div class="form-group col-sm-6">
																		<label>Email</label>
																		<form:input class="form-control" path="email"
																			placeholder="Email" readonly="true" />
																	</div>
																</div>
																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>tỉnh, thành phố</label>

																	</div>
																	<div class="form-group col-sm-6">
																		<label>quận, huyện</label>

																	</div>
																</div>
																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>xã, phường</label>

																	</div>
																	<div class="form-group col-sm-6">
																		<label>địa chỉ</label>
																		<form:input class="form-control" path="diaChi"
																			placeholder="địa chỉ" readonly="true" />
																	</div>
																</div>




																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>phòng ban</label>

																	</div>
																	<div class="form-group col-sm-6">
																		<label>chức danh</label>


																	</div>
																</div>
																<div class="row">
																	<div class="form-group col-sm-6">
																		<label for="location1">Trạng Thái</label>

																	</div>
																	<div class="form-group col-sm-6">
																		<label>Hình Ảnh:</label> <img id="img" src="#"
																			alt="your image" width="100" height="150" />
																	</div>
																</div>

															</div>
														</div>
													</div>
													<div class="form-actions center">
														<input class="btn btn-success" type="submit" value="back" />
													</div>
												</form:form>

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />