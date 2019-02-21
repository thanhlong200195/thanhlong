<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<div class="content-body">
			<div class="main-content">

				<form:form method="POST" modelAttribute="donxinphep003">
					<div class="row">
						<div class="form-group col-sm-6">
							<div>
								<label>Mã đơn</label>
								<form:input class="form-control round" path="id" readonly="true" />
							</div>

							<div>
								<label> Mã nhân viên</label>
								<form:select path="ngayNghi.maNhanVien"
									class="custom-select block round" id="customSelect">
									<c:forEach items="${hoso}" var="ld">
										<form:option value="${ld.maNhanVien}" label="${ld.maNhanVien}" />
									</c:forEach>
								</form:select>
							</div>
							<div>
								<label>Ngày bắt đầu</label>
								<fieldset class="form-group position-relative">
									<form:input type="date" class="form-control round" id="from"
									onchange="myFunction()"  path="ngayBatDau"  />
									<div class="form-control-position">
										<i class="fa fa-calendar-o"></i>
									</div>
								</fieldset>
								<script>
													var today = new Date();
													var dd = today.getDate();
													var mm = today.getMonth() + 1; // January is 0!
													var yyyy = today
															.getFullYear();
													if (dd < 10) {
														dd = '0' + dd
													}
													if (mm < 10) {
														mm = '0' + mm
													}
													today = yyyy + '-' + mm
															+ '-' + dd;
													document.getElementById(
															"from")
															.setAttribute(
																	"min",
																	today);
													document
															.getElementById('from').value = today;
													function myFunction() {
														var today = new Date(
																document
																		.getElementById("from").value);
														var dd = today
																.getDate();
														var mm = today
																.getMonth() + 1; // January is 0!
														var yyyy = today
																.getFullYear();
														if (dd < 10) {
															dd = '0' + dd
														}
														if (mm < 10) {
															mm = '0' + mm
														}
														today = yyyy + '-' + mm
																+ '-' + dd;
														document
																.getElementById(
																		"to")
																.setAttribute(
																		"min",
																		today);
														document
																.getElementById('to').value = new Date(
																document
																		.getElementById("from").value)
																.toISOString()
																.substring(0,
																		10);
														var iWeeks, iDateDiff, iAdjust = 0;
														var dDate1 = new Date(
																document
																		.getElementById("from").value);
														var dDate2 = new Date(
																document
																		.getElementById("to").value);
														if (dDate2 < dDate1)
															return -1; // error code if dates transposed
														var iWeekday1 = dDate1
																.getDay(); // day of week
														var iWeekday2 = dDate2
																.getDay();
														iWeekday1 = (iWeekday1 == 0) ? 7
																: iWeekday1; // change Sunday from 0 to 7
														iWeekday2 = (iWeekday2 == 0) ? 7
																: iWeekday2;
														if ((iWeekday1 > 5)
																&& (iWeekday2 > 5))
															iAdjust = 1; // adjustment if both days on weekend
														iWeekday1 = (iWeekday1 > 5) ? 5
																: iWeekday1; // only count weekdays
														iWeekday2 = (iWeekday2 > 5) ? 5
																: iWeekday2;
														// calculate differnece in weeks (1000mS * 60sec * 60min * 24hrs * 7 days = 604800000)
														iWeeks = Math
																.floor((dDate2
																		.getTime() - dDate1
																		.getTime()) / 604800000)
														if (iWeekday1 <= iWeekday2) {
															iDateDiff = (iWeeks * 5)
																	+ (iWeekday2 - iWeekday1)
																	+ 1
														} else {
															iDateDiff = ((iWeeks + 1) * 5)
																	- (iWeekday1 - iWeekday2)
																	+ 1
														}
														iDateDiff -= iAdjust
														document
																.getElementById("total").value = iDateDiff;
													}
												</script>
							</div>
							<div>
								<label>Ghi chú</label>
								<form:input class="form-control round"  placeholder="ghiChu" path="ghiChu" />
							
							</div>
						</div>

						<div class="form-group col-sm-6">
							<div>
								<label>Ly do</label>
								<form:select path="lyDo.id" class="custom-select block round"
									id="customSelect">
									<c:forEach items="${lyDo}" var="ld">
										<form:option value="${ld.id}" label="${ld.lyDo}" />
									</c:forEach>
								</form:select>
							</div>
							<div>
								<label>Số ngày nghỉ</label>
								<form:input type="text" class="form-control round" id="total"  readonly="true" path="soNgayNghi" />
							</div>
							
							<div>
								<label>Ngày kết thúc</label>
								<fieldset class="form-group position-relative">
									<form:input type="date" class="form-control round" id="to"
									onchange="count()"  path="ngayKetThuc"  />
									<div class="form-control-position">
										<i class="fa fa-calendar-o"></i>
									</div>
								</fieldset>
								<script>
													var today = new Date();
													var dd = today.getDate();
													var mm = today.getMonth() + 1; // January is 0!
													var yyyy = today
															.getFullYear();
													if (dd < 10) {
														dd = '0' + dd
													}
													if (mm < 10) {
														mm = '0' + mm
													}
													today = yyyy + '-' + mm
															+ '-' + dd;
													document.getElementById(
															"to").setAttribute(
															"min", today);
													function count() {
														var iWeeks, iDateDiff, iAdjust = 0;
														var dDate1 = new Date(
																document
																		.getElementById("from").value);
														var dDate2 = new Date(
																document
																		.getElementById("to").value);
														if (dDate2 < dDate1)
															return -1; // error code if dates transposed
														var iWeekday1 = dDate1
																.getDay(); // day of week
														var iWeekday2 = dDate2
																.getDay();
														iWeekday1 = (iWeekday1 == 0) ? 7
																: iWeekday1; // change Sunday from 0 to 7
														iWeekday2 = (iWeekday2 == 0) ? 7
																: iWeekday2;
														if ((iWeekday1 > 5)
																&& (iWeekday2 > 5))
															iAdjust = 1; // adjustment if both days on weekend
														iWeekday1 = (iWeekday1 > 5) ? 5
																: iWeekday1; // only count weekdays
														iWeekday2 = (iWeekday2 > 5) ? 5
																: iWeekday2;
														// calculate differnece in weeks (1000mS * 60sec * 60min * 24hrs * 7 days = 604800000)
														iWeeks = Math
																.floor((dDate2
																		.getTime() - dDate1
																		.getTime()) / 604800000)
														if (iWeekday1 <= iWeekday2) {
															iDateDiff = (iWeeks * 5)
																	+ (iWeekday2 - iWeekday1)
																	+ 1
														} else {
															iDateDiff = ((iWeeks + 1) * 5)
																	- (iWeekday1 - iWeekday2)
																	+ 1
														}
														iDateDiff -= iAdjust
														document
																.getElementById("total").value = iDateDiff;
													}
												</script>	
							     </div>
							
							<div>
								<label>Ghi chú trưởng phòng</label>
								<form:input class="form-control round" path="ghiChuTruongPhong" readonly="true" />
							</div>
						</div>
						<div><br></div>
						
						<div class="col-md-2">
							<button type="submit" class="btn btn-success"
							formaction="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/donxinphep003/nhap">Lưu nháp</button>
					    </div>
						<div class="col-md-4">
						<div class="col-md-2">
							<button type="submit" class="btn btn-success"
							formaction="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/donxinphep003/choduyet">Gửi</button>
						</div>
						</div>
					</div>
			</div>

			</form:form>
		</div>
	</div>
</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />