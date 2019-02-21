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
				<h3 class="content-header-title mb-0">Đánh giá từ trưởng phòng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quantridanhgia/home/"/>">Quản trị
									đánh giá</a></li>
							<li class="breadcrumb-item active">Đánh giá từ trưởng phòng</li>
						</ol>
					</div>
				</div>
			</div>
			<c:if test="${empty danhGia}">
				<div class="content-body">
					<!-- Basic form layout section start -->
					<section id="basic-form-layouts">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content collpase show">
										<div class="card-body" style="margin: 1em">
											<h2>Chưa có đánh giá nào từ trưởng phòng</h2>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</c:if>
			<c:if test="${not empty danhGia}">
				<div class="content-body">
					<!-- Basic form layout section start -->
					<section id="basic-form-layouts">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-content collpase show">
										<div class="card-body" style="margin: 1em">
											<form:form cssClass="form form-horizontal form-bordered">
												<div class="form-body">
													<h4 class="form-section">
														<i class="ft-user"></i>Đánh giá từ trưởng phòng
													</h4>
													<div class="form-group row">
														<label class="col-md-3 label-control">Kỷ luật công
															việc</label>
														<div class="col-md-9">
															<div class="row">
																<form:label path="kyLuatCongViec"></form:label>
															</div>
														</div>
													</div>
													<div class="form-group row">
														<label class="col-md-3 label-control">Tinh thần
															làm việc</label>
														<div class="col-md-9">
															<form:label path="tinhThanLamViec"></form:label>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Khối lượng
															công việc đạt được</label>
														<div class="col-md-9">
															<form:label path="khoiLuongCongViec"></form:label>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Kết quả công
															việc đạt được</label>
														<div class="col-md-9">
															<form:label path="ketQuaCongViec"></form:label>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Kỹ năng tích
															lũy</label>
														<div class="col-md-9">
															<form:label path="kyNangTichLuy"></form:label>
														</div>
													</div>

													<div class="form-group row">
														<label class="col-md-3 label-control">Định hướng</label>
														<div class="col-md-9">
															<form:label path="nhanXet"></form:label>
														</div>
													</div>

													<div class="form-group last">
														<label class="col-md-3 label-control">Đánh giá
															tổng thể</label>
														<div class="col-md-9">
															<form:label path="xepLoai"></form:label>
														</div>
													</div>
												</div>
											</form:form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</c:if>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>