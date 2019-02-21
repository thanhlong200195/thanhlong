<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<!-- ///////////////////////////////////////////////////////// -->


<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Phân công nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/nhiemvu/list-nhiemvu/{$idProjects}" />'>Phân
									công nhiệm vụ</a></li>

						</ol>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<!-- End Path -->

		<div class="content-body">
			<div class="x_panel">
				<div class="x_title">
					<a class="btn btn-outline-success round btn-min-width mr-1 mb-1"
						href="<c:url value="/mvpquanliduan/nhiemvu/show-form-add/${idProjects}" />">
						<h5class="ft-plus-circle">Thêm phân công nhiệm vụ
						</h5>
					</a>
				</div>
				<div class="x_content">

					<table class="table table-striped" style="text-align: center">
						<thead>
							<tr>

								<th style="text-align: center">Mã Dự Án</th>
								<th style="text-align: center">Tên Dự Án</th>
								<th style="text-align: center">Mã Nhân Viên</th>
								<th style="text-align: center">Tên Nhân Viên</th>

								<th style="text-align: center">Vai trò</th>
								<th style="text-align: center">Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="nhiemVu" items="${listNhiemVu}" varStatus="count">
								<tr>


									<td style="text-align: left">${nhiemVu.projects.idProject}</td>
									<td style="text-align: left">${nhiemVu.projects.nameProject}</td>
									<td style="text-align: left">${nhiemVu.hoSoNhanVien.maNv}</td>
									<td style="text-align: left">${nhiemVu.hoSoNhanVien.hoTenNv}</td>
									<td style="text-align: left">${nhiemVu.roles.nameRoles}</td>

									<td><a
										style="width: 50px; high: 50px; border-color: #00E5EE; border-radius: 100%;"
										class="btn btn-outline-info "
										href="<c:url value="/mvpquanliduan/nhiemvu/show-form-edit/${nhiemVu.id }" />"
										title=""><i class="ft-edit"></i></a>
										<button
											style="width: 50px; high: 50px; border-color: #FF6A6A; border-radius: 100%;"
											data-href="<c:url value="/mvpquanliduan/nhiemvu/delete/${nhiemVu.id  }" />"
											class="btn btn-outline-danger" data-toggle="modal"
											data-target="#xoa_pr">
											<i class="ft-delete"></i>
										</button>
								</tr>

							</c:forEach>
						</tbody>
					</table>
					<c:if test="${success != null }">
						${success}
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
<!--                 Css for confirm delete -->
<div class="modal fade" id="xoa_pr" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Xác nhận</h4>
			</div>
			<div class="modal-body">
				<p>Bạn muốn xóa Framework này???</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
				<a class="btn btn-primary del_pr">Xóa</a>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<script type="text/javascript">
	$('#xoa_pr').on('show.bs.modal', function(e) {
		// var test = $(e.relatedTarget).data('href'); console.log(test);
		$(this).find('.del_pr').attr('href', $(e.relatedTarget).data('href'));
	});
</script>

<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
