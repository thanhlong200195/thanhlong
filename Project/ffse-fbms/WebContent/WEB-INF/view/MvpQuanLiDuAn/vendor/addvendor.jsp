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
				<h3 class="content-header-title mb-0">Thêm mới nhà cung cấp</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/vendor/list-vendor" />'>Danh
									sách nhà cung cấp</a></li>
							<li class="breadcrumb-item active">Thêm mới nhà cung cấp</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<hr>
		<!-- End Path -->

		<div class="justify-content-md-center" style="width: 95%">
		 			
                     <form:form method="post" action="addnew" style="width: 95%;margin-left: 5%">
                       <h4 class="form-section"><i class="ft-clipboard"></i> Nhà cung cấp</h4>
                        <div class="row">
                          <div class="form-group col-md-6 mb-2">
                            <label for="projectinput6">Mã Nhà cung cấp</label><br>
                            <p Class="error" >${messageName}</p>
                            <form:errors path="idVendor" cssClass="error" />
                           <form:input class="form-control round" path="idVendor" placeholder="Mã nhà cung cấp" />
                          </div>
                          <div class="form-group col-md-6 mb-2">
                            <label for="projectinput7">Nhà cung cấp</label><br>
                            <p Class="error" >	</p>
                            <form:errors path="nameVendor" cssClass="error" />
                            <form:input class="form-control round" path="nameVendor" placeholder="Nhà cung cấp" />
                          </div>
                        </div>
                        <div class="row">
                          <div class="form-group col-md-6 mb-2">
                            <label for="projectinput6">Điện thoại</label><br>
                              <form:errors path="phone" cssClass="error" />
                           <form:input class="form-control round" path="phone" placeholder="Điện thoại" />
                          </div>
                          <div class="form-group col-md-6 mb-2">
                            <label for="projectinput7">Email</label><br>
                             <form:errors path="email" cssClass="error" />
                            <form:input class="form-control round" path="email" placeholder="Email" />
                          </div>
                        </div>
                        <div class="row">
                          <div class="form-group col-12 mb-2">
                            <label>Địa chỉ</label><br>
                              <form:errors path="address" cssClass="error" />
                            <form:input class="form-control round" path="address" placeholder="Địa chỉ" />
                          </div>
                        </div>
                        <div class="col-sm-12 text-center">
                        
							<button type="submit" class="btn btn-outline-primary btn-lg mr-1 mb-1 btn-block round"><i class="fa fa-check-circle"></i> Lưu thông tin</button>
						</div>
                       
                      </div>
                      </form:form>
				</div>

			</div>

<!-- ////////////////////////////////////////////////////////////////////////////-->			

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
