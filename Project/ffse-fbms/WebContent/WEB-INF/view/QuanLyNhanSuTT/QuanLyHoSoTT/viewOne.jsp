<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Roboto", sans-serif
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">xem thông tin nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Trang chủ</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/ho_so/" />'>Danh sách
									nhân viên</a></li>
							<li class="breadcrumb-item active">xem thông tin nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<!-- Page Container -->
		<div class="w3-content w3-margin-top" style="max-width: 1200px;">

			<!-- The Grid -->
			<div class="w3-row-padding">

				<!-- Left Column -->
				<div class="w3-third">

					<div class="w3-white w3-text-grey w3-card-4">

						<div class="profile-container">
							<div style="text-align: center;">
								<img class="profile"
									src="<c:url value="/uploads/${hoSoNhanVienTT.anhDaiDien}" />"
									width="150" height="180" alt="" />
							</div>
							<h1 class="name" style="text-align: center;">${hoSoNhanVienTT.tenNhanVien}</h1>
							<h3 class="tagline" style="text-align: center;">Full Stack
								Developer</h3>
						</div>
						<div class="w3-container">
							<p>
								<i
									class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal"></i>${hoSoNhanVienTT.chucDanh.tenChucDanh}</p>
							<p>
								<i
									class="fa fa-home fa-fw w3-margin-right w3-large w3-text-teal"></i>${hoSoNhanVienTT.diaChi},
								${hoSoNhanVienTT.xaPhuong.tenXa},
								${hoSoNhanVienTT.quanHuyen.tenQuanHuyen},
								${hoSoNhanVienTT.thanhPho.tenThanhPho}
							</p>
							<p>
								<i
									class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i>${hoSoNhanVienTT.email}</p>
							<p>
								<i
									class="fa fa-phone fa-fw w3-margin-right w3-large w3-text-teal"></i>${hoSoNhanVienTT.soDienThoai}</p>
							<hr>

							<p class="w3-large">
								<b><i
									class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Skills</b>
							</p>
							<p>Adobe Photoshop</p>
							<div class="w3-light-grey w3-round-xlarge w3-small">
								<div class="w3-container w3-center w3-round-xlarge w3-teal"
									style="width: 90%">90%</div>
							</div>
							<p>Photography</p>
							<div class="w3-light-grey w3-round-xlarge w3-small">
								<div class="w3-container w3-center w3-round-xlarge w3-teal"
									style="width: 80%">
									<div class="w3-center w3-text-white">80%</div>
								</div>
							</div>
							<p>Java</p>
							<div class="w3-light-grey w3-round-xlarge w3-small">
								<div class="w3-container w3-center w3-round-xlarge w3-teal"
									style="width: 75%">75%</div>
							</div>
							<p>PHP</p>
							<div class="w3-light-grey w3-round-xlarge w3-small">
								<div class="w3-container w3-center w3-round-xlarge w3-teal"
									style="width: 50%">50%</div>
							</div>
							<br>

							<p class="w3-large w3-text-theme">
								<b><i class="fa fa-globe fa-fw w3-margin-right w3-text-teal"></i>Languages</b>
							</p>
							<p>English</p>
							<div class="w3-light-grey w3-round-xlarge">
								<div class="w3-round-xlarge w3-teal"
									style="height: 24px; width: 100%"></div>
							</div>
							<p>Spanish</p>
							<div class="w3-light-grey w3-round-xlarge">
								<div class="w3-round-xlarge w3-teal"
									style="height: 24px; width: 55%"></div>
							</div>
							<p>German</p>
							<div class="w3-light-grey w3-round-xlarge">
								<div class="w3-round-xlarge w3-teal"
									style="height: 24px; width: 25%"></div>
							</div>
							<br>
						</div>
					</div>
					<br>

					<!-- End Left Column -->
				</div>

				<!-- Right Column -->
				<div class="w3-twothird">
					<div class="w3-container w3-card w3-white w3-margin-bottom">
						<section class="section projects-section">
							<h2 class="section-title">
								<span class="icon-holder"><i
									class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i></span>Thông
								Tin Bằng Cấp
							</h2>
							<c:forEach items="${thongTinBangCap}" var="x" varStatus="stt">
								<div class="table-responsive">
									<table class="table mb-0">
										<tr>
											<td><h6>
													<i
														class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Tên
													Bằng Cấp:
												</h6></td>
											<td style="text-align: right">${x.tenBangCap}</td>
										</tr>
										<tr>
											<td><h6>
													<i
														class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Loại
													Bằng Cấp:
												</h6></td>
											<td style="text-align: right">${x.loaiBangCap}</td>
										</tr>
										<tr>
											<td><h6>
													<i
														class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Đơn
													Vị Cấp:
												</h6></td>
											<td style="text-align: right">${x.donViCap}</td>
										</tr>
										<tr>
											<td><h6>
													<i
														class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Nơi
													Cấp:
												</h6></td>
											<td style="text-align: right">${x.noiCap}</td>
										</tr>
										<tr>
											<td><h6>
													<i
														class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Ngày
													Cấp:
												</h6></td>
											<td style="text-align: right">${x.ngayCap}</td>
										</tr>


									</table>
								</div>
							</c:forEach>
						</section>
						<!--//section-->
					</div>
					<div class="w3-container w3-card w3-white">
						<h2 class="w3-text-grey w3-padding-16">
							<i
								class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Education
						</h2>
						<div class="w3-container">
							<h5 class="w3-opacity">
								<b>W3Schools.com</b>
							</h5>
							<h6 class="w3-text-teal">
								<i class="fa fa-calendar fa-fw w3-margin-right"></i>Forever
							</h6>
							<p>Web Development! All I need to know in one place</p>
							<hr>
						</div>
						<div class="w3-container">
							<h5 class="w3-opacity">
								<b>London Business School</b>
							</h5>
							<h6 class="w3-text-teal">
								<i class="fa fa-calendar fa-fw w3-margin-right"></i>2013 - 2015
							</h6>
							<p>Master Degree</p>
							<hr>
						</div>
						<div class="w3-container">
							<h5 class="w3-opacity">
								<b>School of Coding</b>
							</h5>
							<h6 class="w3-text-teal">
								<i class="fa fa-calendar fa-fw w3-margin-right"></i>2010 - 2013
							</h6>
							<p>Bachelor Degree</p>
							<br>
						</div>
					</div>

					<!-- End Right Column -->
				</div>

				<!-- End Grid -->
			</div>

			<!-- End Page Container -->
		</div>
		<%-- <div
		<c:if test="${empty hoSoNhanVienTT.thongTinBangCaps}"> style="display: none;"</c:if>
		class="panel panel-default ">
		<div class="panel-heading form-section">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" href="#collapse3"><i
					class="ft-user"></i> <spring:message code="label.thongTinBangCap" /></a>
			</h4>
		</div>
		<div id="collapse3" class="panel-collapse collapse in">
			<div class="thong-tin-bang-cap">
				<div class="repeater-list">
					<c:forEach items="${hoSoNhanVienTT.thongTinBangCaps }"
						var="thongTinBangCapTT" varStatus="stt">
						<div class="row form-section">
							<div class="col-md-6">
								<p>
									<strong><spring:message code="label.tenBangCap" />: </strong>${thongTinBangCapTT.tenBangCap}</p>
								<p>
									<strong><spring:message code="label.noiCapBang" />: </strong>${thongTinBangCapTT.donViCap}</p>
							</div>
							<div class="col-md-6">
								<p>
									<strong><spring:message code="label.loaiBangCap" />:
									</strong>${thongTinBangCapTT.loaiBangCap }</p>
								<p>
									<strong><spring:message code="label.ngayCap" />: </strong>${thongTinBangCapTT.ngayCap}</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div> --%>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />


