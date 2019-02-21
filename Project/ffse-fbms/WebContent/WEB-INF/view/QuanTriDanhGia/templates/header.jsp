<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="FastTrackSE Bunisess Management System.">
<meta name="keywords"
	content="human resource, document, project, working log, leave management">
<meta name="author" content="FFSE1703">
<title>FastTrackSE - The Business Management System</title>
<link rel="apple-touch-icon"
	href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/09/fasttrackselogo.png"/>">
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/favicon.png"/>">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet" />
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/feather/style.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/font-awesome/css/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/flag-icon-css/css/flag-icon.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/extensions/pace.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/tables/datatable/dataTables.bootstrap4.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/extensions/unslider.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/weather-icons/climacons.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/meteocons/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/charts/morris.css"/>">
<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap-extended.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/app.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/colors.css"/>">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/menu/menu-types/vertical-menu.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/menu/menu-types/vertical-overlay-menu.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/colors/palette-gradient.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/colors/palette-callout.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/forms/extended/form-extended.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/simple-line-icons/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/pages/timeline.css"/>">
<!-- END Page Level CSS-->
<style>
.invalid-feedback {
	color: #DC3545;
	padding-top: 10px;
}

.invalid-feedback::before {
	content: "•";
	padding-left: 10px;
	padding-right: 10px;
}
</style>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script>
	$(document).ready(
			function() {
				listClass = [ "phong_ban", "chuc_danh" ];
				url = window.location.href;
				selector = '.'
						+ url.substring(url.lastIndexOf("ffse-fbms") + 10);
				selector = selector.replace(/\//g, '').replace(/[0-9]/g, '');
				$(selector).addClass('active open');

				var i;
				for (i = 0; i < listClass.length; i++) {
					if (selector.includes(listClass[i])) {
						$("." + listClass[i]).addClass('open');
					}
				}
				console.log(selector);
				if (selector.includes('ho_so')
						&& !selector.includes('viewho_so')
						&& !selector.includes('qlnsnv')
						&& !selector.includes('ho_soedit')) {
					$(".pbho_so").addClass('open');
				}
				if (selector.includes('hop_dong')
						&& !selector.includes('viewhop_dong')
						&& !selector.includes('qlnsnv')
						&& !selector.includes('hop_dongedit')) {
					$(".pbhop_dong").addClass('open');
				}
			});
</script>

</head>

<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar">

	<nav
		class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-light bg-gradient-x-grey-blue">
		<div class="navbar-wrapper">
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li class="nav-item mobile-menu hidden-md-up float-xs-left"><a
						href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i
							class="ft-menu font-large-1"></i></a></li>
					<li class="nav-item"><a href="/ffse-fbms/home"
						class="navbar-brand"><img
							src="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/favicon.png"/>"
							alt="FastTrackSE logo" class="brand-logo" />
							<h2 class="brand-text">FBMS</h2></a></li>
					<li class="nav-item hidden-md-up float-xs-right"><a
						data-toggle="collapse" data-target="#navbar-mobile"
						class="nav-link open-navbar-container"><i
							class="fa fa-ellipsis-v"></i></a></li>
				</ul>
			</div>
			<div class="navbar-container content container-fluid">
				<div id="navbar-mobile" class="collapse navbar-toggleable-sm">
					<ul class="nav navbar-nav">
						<li class="nav-item hidden-sm-down"><a href="#"
							class="nav-link nav-menu-main menu-toggle hidden-xs"><i
								class="ft-menu"></i></a></li>
						<li class="nav-item hidden-sm-down"><a href="#"
							class="nav-link nav-link-expand"><i class="ficon ft-maximize"></i></a></li>
					</ul>
					<ul class="nav navbar-nav float-xs-right">
						<li class="dropdown dropdown-language nav-item"><a
							id="dropdown-flag" href="#" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"
							class="dropdown-toggle nav-link"><spring:message
									code="label.language" /><span class="selected-language"></span></a>
							<div aria-labelledby="dropdown-flag" class="dropdown-menu">
								<a href="?lang=en" class="dropdown-item"><i
									class="flag-icon flag-icon-gb"></i> English</a><a href="?lang=vi"
									class="dropdown-item"><i class="flag-icon flag-icon-vn"></i>
									Việt Nam</a>
							</div></li>
						<li class="dropdown dropdown-notification nav-item"><a
							href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i
								class="ficon ft-bell"></i><span
								class="tag tag-pill tag-default tag-danger tag-default tag-up">5</span></a>
							<ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
								<li class="dropdown-menu-header">
									<h6 class="dropdown-header m-0">
										<span class="grey darken-2">Notifications</span><span
											class="notification-tag tag tag-default tag-danger float-xs-right m-0">5
											New</span>
									</h6>
								</li>
								<li class="list-group scrollable-container"><a
									href="javascript:void(0)" class="list-group-item">
										<div class="media">
											<div class="media-left valign-middle">
												<i class="ft-plus-square icon-bg-circle bg-cyan"></i>
											</div>
											<div class="media-body">
												<h6 class="media-heading">You have new order!</h6>
												<p class="notification-text font-small-3 text-muted">Lorem
													ipsum dolor sit amet, consectetuer elit.</p>
												<small> <time datetime="2015-06-11T18:29:20+08:00"
														class="media-meta text-muted">30 minutes ago</time></small>
											</div>
										</div>
								</a><a href="javascript:void(0)" class="list-group-item">
										<div class="media">
											<div class="media-left valign-middle">
												<i
													class="ft-download-cloud icon-bg-circle bg-red bg-darken-1"></i>
											</div>
											<div class="media-body">
												<h6 class="media-heading red darken-1">99% Server load</h6>
												<p class="notification-text font-small-3 text-muted">Aliquam
													tincidunt mauris eu risus.</p>
												<small> <time datetime="2015-06-11T18:29:20+08:00"
														class="media-meta text-muted">Five hour ago</time></small>
											</div>
										</div>
								</a><a href="javascript:void(0)" class="list-group-item">
										<div class="media">
											<div class="media-left valign-middle">
												<i
													class="ft-alert-triangle icon-bg-circle bg-yellow bg-darken-3"></i>
											</div>
											<div class="media-body">
												<h6 class="media-heading yellow darken-3">Warning
													notifixation</h6>
												<p class="notification-text font-small-3 text-muted">Vestibulum
													auctor dapibus neque.</p>
												<small> <time datetime="2015-06-11T18:29:20+08:00"
														class="media-meta text-muted">Today</time></small>
											</div>
										</div>
								</a><a href="javascript:void(0)" class="list-group-item">
										<div class="media">
											<div class="media-left valign-middle">
												<i class="ft-check-circle icon-bg-circle bg-cyan"></i>
											</div>
											<div class="media-body">
												<h6 class="media-heading">Complete the task</h6>
												<small> <time datetime="2015-06-11T18:29:20+08:00"
														class="media-meta text-muted">Last week</time></small>
											</div>
										</div>
								</a><a href="javascript:void(0)" class="list-group-item">
										<div class="media">
											<div class="media-left valign-middle">
												<i class="ft-file icon-bg-circle bg-teal"></i>
											</div>
											<div class="media-body">
												<h6 class="media-heading">Generate monthly report</h6>
												<small> <time datetime="2015-06-11T18:29:20+08:00"
														class="media-meta text-muted">Last month</time></small>
											</div>
										</div>
								</a></li>
								<li class="dropdown-menu-footer"><a
									href="javascript:void(0)"
									class="dropdown-item text-muted text-xs-center">Read all
										notifications</a></li>
							</ul></li>
						<li class="dropdown dropdown-notification nav-item"><a
							href="#" data-toggle="dropdown" class="nav-link nav-link-label"><i
								class="ficon ft-mail"></i><span
								class="tag tag-pill tag-default tag-warning tag-default tag-up">3</span></a>
							<ul class="dropdown-menu dropdown-menu-media dropdown-menu-right">
								<li class="dropdown-menu-header">
									<h6 class="dropdown-header m-0">
										<span class="grey darken-2">Messages</span><span
											class="notification-tag tag tag-default tag-warning float-xs-right m-0">4
											New</span>
									</h6>
								</li>
								<li class="list-group scrollable-container"><a
									href="javascript:void(0)" class="list-group-item">
										<div class="media">
											<div class="media-left">
												<span class="avatar avatar-sm avatar-online rounded-circle"><img
													src="<c:url value="/resources/images/portrait/small/avatar-s-1.png"/>"
													alt="avatar"><i></i></span>
											</div>
											<div class="media-body">
												<h6 class="media-heading">Margaret Govan</h6>
												<p class="notification-text font-small-3 text-muted">I
													like your portfolio, let's start the project.</p>
												<small> <time datetime="2015-06-11T18:29:20+08:00"
														class="media-meta text-muted">Today</time></small>
											</div>
										</div>
								</a><a href="javascript:void(0)" class="list-group-item">
										<div class="media">
											<div class="media-left">
												<span class="avatar avatar-sm avatar-busy rounded-circle"><img
													src="<c:url value="/resources/images/portrait/small/avatar-s-2.png"/>"
													alt="avatar"><i></i></span>
											</div>
											<div class="media-body">
												<h6 class="media-heading">Bret Lezama</h6>
												<p class="notification-text font-small-3 text-muted">I
													have seen your work, there is</p>
												<small> <time datetime="2015-06-11T18:29:20+08:00"
														class="media-meta text-muted">Tuesday</time></small>
											</div>
										</div>
								</a><a href="javascript:void(0)" class="list-group-item">
										<div class="media">
											<div class="media-left">
												<span class="avatar avatar-sm avatar-online rounded-circle"><img
													src="<c:url value="/resources/images/portrait/small/avatar-s-3.png"/>"
													alt="avatar"><i></i></span>
											</div>
											<div class="media-body">
												<h6 class="media-heading">Carie Berra</h6>
												<p class="notification-text font-small-3 text-muted">Can
													we have call in this week ?</p>
												<small> <time datetime="2015-06-11T18:29:20+08:00"
														class="media-meta text-muted">Friday</time></small>
											</div>
										</div>
								</a><a href="javascript:void(0)" class="list-group-item">
										<div class="media">
											<div class="media-left">
												<span class="avatar avatar-sm avatar-away rounded-circle"><img
													src="<c:url value="/resources/images/portrait/small/avatar-s-6.png"/>"
													alt="avatar"><i></i></span>
											</div>
											<div class="media-body">
												<h6 class="media-heading">Eric Alsobrook</h6>
												<p class="notification-text font-small-3 text-muted">We
													have project party this saturday night.</p>
												<small> <time datetime="2015-06-11T18:29:20+08:00"
														class="media-meta text-muted">last month</time></small>
											</div>
										</div>
								</a></li>
								<li class="dropdown-menu-footer"><a
									href="javascript:void(0)"
									class="dropdown-item text-muted text-xs-center">Read all
										messages</a></li>
							</ul></li>
						<li class="dropdown dropdown-user nav-item"><a href="#"
							data-toggle="dropdown"
							class="dropdown-toggle nav-link dropdown-user-link"><span
								class="avatar avatar-online"><img
									src="<c:url value="/resources/images/portrait/small/avatar-s-1.png"/>"
									alt="avatar"><i></i></span><span class="user-name">${pageContext.request.userPrincipal.name}</span></a>
							<div class="dropdown-menu dropdown-menu-right">
								<a href="#" class="dropdown-item"><i class="ft-user"></i> <spring:message
										code="label.suaHoSo" /></a> <a href="#" class="dropdown-item"><i
									class="ft-mail"></i> <spring:message code="label.hopThu" /></a> <a
									href="#" class="dropdown-item"><i class="ft-check-square"></i>
									<spring:message code="label.nhiemVu" /></a> <a href="#"
									class="dropdown-item"><i class="ft-message-square"></i> <spring:message
										code="label.tinNhan" /></a>
								<div class="dropdown-divider"></div>
								<form class="dropdown-item"
									action="<c:url value="/j_spring_security_logout" />"
									method="post">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <a href="#"
										onclick="$(this).closest('form').submit()"><i
										class="ft-power"></i> <spring:message code="label.dangXuat" /></a>
								</form>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<!-- ////////////////////////////////////////////////////////////////////////////-->


	<div data-scroll-to-active="true"
		class="main-menu menu-fixed menu-light menu-accordion menu-shadow">
		<div class="main-menu-content">
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<!-- Quản trị hệ thống -->
				<li class=" navigation-header"><span><spring:message
							code="label.QuanTriHeThong" /></span><i data-toggle="tooltip"
					data-placement="right" data-original-title="Apps" class=" ft-minus"></i>
				</li>
				<li class=" nav-item QuanTriHeThongphong_ban"><a
					href="<c:url value = "/QuanTriHeThong/phong_ban/"/>"><i
						class="fa fa-building"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong_PhongBan" /></span></a></li>
				<li class=" nav-item QuanTriHeThongchuc_danh"><a
					href="<c:url value = "/QuanTriHeThong/chuc_danh/"/>"><i
						class="fa fa-id-card-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong_ChucDanh" /></span></a></li>
				<li class=" nav-item QuanTriHeThongtai-khoan"><a
					href="<c:url value = "/QuanTriHeThong/tai-khoan/"/>"><i
						class="fa fa-id-card-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong_TaiKhoan" /></span></a></li>
				<li class=" nav-item QuanTriHeThongphan-quyen"><a
					href="<c:url value = "/QuanTriHeThong/phan-quyen/"/>"><i
						class="fa fa-id-card-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong_PhanQuyen" /></span></a></li>

				<sec:authorize access="hasAnyRole('ROLE_PNSNV','ROLE_PNSTPP')">
					<!-- Quản Trị Nhân Sự -->
				</sec:authorize>
				<sec:authorize access="!hasRole('ROLE_NV') or hasRole('ROLE_PNS')">
					<!-- Quản trị dự án -->
				</sec:authorize>
			</ul>

			<!-- List page cho nhân viên -->
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<!-- Quản trị đánh giá -->
				<li class=" navigation-header"><span>Quản trị đánh giá</span><i
					data-toggle="tooltip" data-placement="right"
					data-original-title="Apps" class=" ft-minus"></i></li>
				<c:if test="${chucDanh eq 'NV' }">
					<li class=" nav-item"><a
						href="<c:url value = "/quantridanhgia/nhanvien/danhgiabanthan"/>"><i
							class="fa fa-user"></i><span data-i18n="" class="menu-title">Tự
								đánh giá</span></a></li>
					<li class=" nav-item"><a
						href="<c:url value = "/quantridanhgia/nhanvien/danhgianhanvien"/>"><i
							class="fa fa-users"></i><span data-i18n="" class="menu-title">Đánh
								giá nhân viên khác</span></a></li>
					<li class=" nav-item"><a
						href="<c:url value = "/quantridanhgia/nhanvien/danhgiacuatruongphong"/>"><i
							class="fa fa-user-secret"></i><span data-i18n=""
							class="menu-title">Đánh giá của trưởng phòng</span></a></li>
				</c:if>
				<c:if test="${chucDanh eq 'TP' }">
					<li class=" nav-item"><a
						href="<c:url value = "/quantridanhgia/truongphong/duyetdanhgia"/>"><i
							class="fa fa-users"></i><span data-i18n="" class="menu-title">Danh
								sách nhân viên</span></a></li>
				</c:if>
				<c:if test="${chucDanh eq 'PNS' }">
					<li class=" nav-item"><a
						href="<c:url value = "/quantridanhgia/truongphong/danhgianhanvien"/>"><i
							class="fa fa-users"></i><span data-i18n="" class="menu-title">Tạo kỳ đánh giá</span></a></li>
							<li class=" nav-item"><a
						href="<c:url value = "/quantridanhgia/truongphongdanhgia/home"/>"><i
							class="fa fa-users"></i><span data-i18n="" class="menu-title">Lập danh sách đánh giá</span></a></li>
							<li class=" nav-item"><a
						href="<c:url value = "/quantridanhgia/truongphongdanhgia/home"/>"><i
							class="fa fa-users"></i><span data-i18n="" class="menu-title">Danh sách đánh giá</span></a></li>
				</c:if>
			</ul>


		</div>
	</div>