<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<h3 class="content-header-title mb-0">Thêm nhân viên</h3> <!-- title -->
	
                    <form:form class="form" method="POST" action="insert" modelAttribute="formHosopkl" enctype="multipart/form-data">
                      <div class="form-body">
                        <h4 class="form-section"><i class="ft-user"></i>Thông tin cơ bản</h4>
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput1">Mã nhân viên</label>
                              <form:input path="maNv" type="number" id="projectinput1" class="form-control" placeholder="Mã nhân viên"
                              name="maNhanVienInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2">Họ tên</label>
                              <form:input path="hoTenNv" type="text" id="projectinput2" class="form-control" placeholder="Họ tên"
                              name="hoTenInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2">Email</label>
                              <form:input path="email" type="text" id="projectinput2" class="form-control" placeholder="Email"
                              name="emailInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput2">Tình trạng hôn nhân</label>
                              <form:select path="tinhTrangHonNhan" type="text" id="projectinput2" class="form-control"
                              name="tinhTrangHonNhanRadio">
                              		<option value="none" selected="selected" >Chọn tình trạng hôn nhân</option>
                              		<option value="0" >Chưa kết hôn</option>
                              		<option value="1" >Đã kết hôn</option>
                              </form:select>
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput3">Giới tính</label>
                              <form:select path="gioiTinh" type="text" id="projectinput3" class="form-control" placeholder="Giới tính" name="gioiTinhRadio">
                              		<option value="none" selected="selected" >Chọn giới tính</option>
                              		<option value="Nam" >Nam</option>
                              		<option value="Nữ" >Nữ</option>
                              </form:select>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Ngày sinh</label>
                              <form:input path="ngaySinh" type="date" id="projectinput4" class="form-control" placeholder="Ngày sinh" name="ngaySinhInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Số điện thoại</label>
                              <form:input path="sDT" type="number" id="projectinput4" class="form-control" placeholder="Số điện thoại" name="soDienThoaiInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Số CMND</label>
                              <form:input path="cMND" type="number" id="projectinput4" class="form-control" placeholder="Số CMND" name="soCMNDInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Nơi cấp</label>
                              <form:input path="noiCap" type="text" id="projectinput4" class="form-control" placeholder="Nơi cấp" name="noiCapInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Ngày cấp</label>
                              <form:input path="ngayCap" type="date" id="projectinput4" class="form-control" placeholder="Ngày cấp" name="ngayCapInput" />
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Quốc tịch</label>
                              <form:select path="quocTich" type="text" id="projectinput4" class="form-control" name="quocTichSelect">
                              		<option value="none" selected="selected" >Chọn quốc tịch</option>
                              	 <c:forEach items="${listQuocTich}" var="x">
                              		<option value="${x.tenNuoc}" >${x.tenNuoc}</option>
                              	 </c:forEach>
                              </form:select>
                            </div>
                          </div>
                          <div class="col-md-6">
                            <div class="form-group">
                              <label for="projectinput4">Dân tộc</label>
                              <form:input path="danToc" type="text" id="projectinput4" class="form-control" placeholder="Dân tộc" name="danTocInput" />
                            </div>
                          </div>
                          
                          <div class="col-md-12">
                            <div class="form-group">
                              <label for="projectinput4">Nơi ở hiện nay</label>
                              <form:textarea path="noiOHienNay" type="text" id="projectinput4" class="form-control" placeholder="Nơi ở hiện nay" name="noiOHienNayInput" />
                            </div>
                          </div>
                        </div>
                        <h4 class="form-section"><i class="fa fa-paperclip"></i>Thông tin quê quán</h4>
                        <div class="form-group">
                          <label for="thanhPhoId">Thành Phố</label>
                          <form:select path="thanhPho.maTinhThanh" type="text" id="thanhPhoId" class="form-control"
                          				name="thanhPhoSelect" onchange="clickComboboxThanhPho()">
                          		<option value="noThanhPho" selected="selected" >Chọn thành phố</option>
    								<c:forEach items="${listThanhPho}" var="x">
                              			<option value="${x.maTinhThanh}" >${x.tenTinhThanh}</option>
                              		</c:forEach>						
                          </form:select>
                        </div>
                        <div class="form-group">
                          <label for="quanHuyenId">Quận huyện</label>
                          <form:select path="quanHuyen.maQuanHuyen" id="quanHuyenId"  name="quanHuyen" type="text" class="form-control" disabled="true"
                          			onchange="clickComboboxQuan()" >
                          		 <option value="noQuanHuyen" selected="selected" >Chọn quận huyện</option>
                          </form:select>
                     
                          
                        </div>
                        <div class="form-group">
                          <label for="phuongXaId">Phường xã</label>
                          <form:select path="phuongXa.maPhuong" type="text" id="phuongXaId" class="form-control"
                          name="phuongXaSelect" disabled="true">
                          		<option value="noPhuongXa" selected="selected">Chọn phường xã</option>
                          	
                          </form:select>
                        </div>
                        
                      </div>
                      
                      <h4 class="form-section"><i class="fa fa-paperclip"></i>Phòng Ban</h4>
                        <div class="form-group">
                          <label for="companyName">Phòng ban</label>
                          <form:select path="maPhongBan.maPhongBan" type="text" id="companyName" class="form-control"
                          name="phongBanSelect">
                          		<option value="none" selected >Chọn Phòng ban</option>
                          	  <c:forEach items="${listPhongBan}" var="x">
                              	<option value="${x.maPhongBan}" >${x.tenPhongBan}</option>
                              </c:forEach>
                          </form:select>
                        </div>
                        <div class="form-group">
                          <label for="companyName">Chức danh</label>
                          <form:select path="maChucDanh.maChucDanh" type="text" id="companyName" class="form-control" placeholder="Company Name"
                          name="chucDanhSelect">
                          		<option value="none" selected="selected" >Chọn chức danh</option>
                          	  <c:forEach items="${listChucDanh}" var="x">
                              	<option value="${x.maChucDanh}" >${x.tenChucDanh}</option>
                              </c:forEach>
                          </form:select>
                        </div>
                        
                        <div class="form-group">
                          <label>Hình Ảnh:</label> <input id="imgUrl" class="form-control"
						type="file" name="file" /> <br> <img id="img" src="#"
						alt="your image" width="100" height="150" />
                        </div>
                        <div class="form-actions">
                        
                        <button type="submit" class="btn btn-primary">
                          <i class="fa fa-check-square-o"></i> Lưu
                        </button>
                      </div>
                    </form:form>
                    <div ><p id="result"></p></div>
                    <button type="button" class="btn btn-warning mr-1" onclick="bam()">
                          <i class="ft-x"></i> Hủy
                        </button>
                        
                        
                        <!-- ajax select ThanhPho -->
                     <script type="text/javascript">
                     window.onload = function () { 
                    	 
                    	 console.log("aaa");
                     }
                     function clickComboboxThanhPho(){
                    	 var maThanhPho = $("#thanhPhoId").val();
                    	 if(maThanhPho == 'noThanhPho'){  // nếu người dùng chưa chọn thành phố
                    		
                    		 $('#quanHuyenId option').remove();
                    		 
                    		 $('#quanHuyenId').prop('disabled', true); /*disable combobox quận huyện */
                    		 
                    		 $('#phuongXaId option[value=noPhuongXa]').attr('selected', 'selected')
                    		 $('#phuongXaId').prop('disabled', true);
                    		 
                    	 } else{                // nếu người dùng đã chọn thành phố
                    		
                    		 $('#quanHuyenId').prop('disabled', false); /*enable combobox quận huyện */
                    		 $('#quanHuyenId option').remove(); /* xóa những option quận huyện cũ */
                    		 
                    		 $('#phuongXaId option[value=noPhuongXa]').attr('selected', 'selected') // nếu người ta select lại thành phố thì combobox phường phải chọn lại từ đầu
                    		 $('#phuongXaId').prop('disabled', true);
                    	 }
                    	 
                         $.ajax({
                        	 url: "/ffse-fbms/quantrinhansu/hosonhanvien/selectquan/" + maThanhPho, 
                        	 dataType: "json",
                        	 success: function(data){
                        		/* alert("Hello! I am an alert box!"); */
                        		$('#quanHuyenId').append($('<option>', {
                             		    value: 'noQuanHuyen',
                             		    text: 'Chọn Quận Huyện'
                             		}));
                        		
                        		for (var i = 0; i < data.length; i++) {
                        			$('#quanHuyenId').append($('<option>', {
                             		    value: data[i].maQuanHuyen,
                             		    text: data[i].tenQuanHuyen
                             		}));
								}
                        	
                         }});
                     };
                     </script>
                     
                     <script type="text/javascript">
                     
                     
                     
                     <!-- ajax select QuanHuyen -->
                     function clickComboboxQuan(){
                    	 var maQuanHuyen = $("#quanHuyenId").val();
                    	 if(maQuanHuyen == 'noQuanHuyen'){  /* nếu người dùng chưa chọn thành phố */
                    		 $('#phuongXaId option').remove();
                    		 $('#phuongXaId').prop('disabled', true); /*disable combobox quận huyện */
                    		 
                    	 } else{                /* nếu người dùng đã chọn thành phố*/
                    		
                    		 $('#phuongXaId').prop('disabled', false); // enable combobox quận huyện 
                    		 $('#phuongXaId option').remove(); // xóa những option quận huyện cũ
                    	 }
                    	 
                         $.ajax({
                        	 url: "/ffse-fbms/quantrinhansu/hosonhanvien/selectphuong/" + maQuanHuyen, 
                        	 dataType: "json",
                        	 success: function(data){
                        		/* alert("Hello! I am an alert box!"); */
                        		
                        		$('#phuongXaId').append($('<option>', {
                             		    value: 'noPhuongXa',	
                             		    text: 'Chọn phường xã'
                             		}));
                        		
                        		for (var i = 0; i < data.length; i++) {
                        			$('#phuongXaId').append($('<option>', {
                             		    value: data[i].maPhuong,
                             		    text: data[i].tenPhuong
                             		}));
								}
                        	
                         }});
                     };
                     </script> 
                     
                     <!-- preview image -->  
                     <script type="text/javascript">
						function readURL(input) {
						if (input.files && input.files[0]) {
						var reader = new FileReader();
						reader.onload = function(e) {
						$('#img').attr('src', e.target.result);
						}
						reader.readAsDataURL(input.files[0]);
						}
						}
						$("#imgUrl").change(function() {
						readURL(this);
						});
					</script>
    		</div>
                      
		
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />