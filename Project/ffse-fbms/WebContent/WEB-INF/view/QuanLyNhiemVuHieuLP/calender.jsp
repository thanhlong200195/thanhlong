<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/HieuLP/create"/>" class="btn btn-primary"><span
						class="fa fa-plus"></span> Thêm mới</a>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
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
						<div class="card-body">
							<div id="fc-json" class="fc fc-unthemed fc-ltr">
								<div class="fc-toolbar">
									<div class="fc-left">
										<div class="fc-button-group">
											<button type="button"
												class="fc-prev-button fc-button fc-state-default fc-corner-left">
												<span class="fc-icon fc-icon-left-single-arrow"></span>
											</button>
											<button type="button"
												class="fc-next-button fc-button fc-state-default fc-corner-right">
												<span class="fc-icon fc-icon-right-single-arrow"></span>
											</button>
										</div>
										<button type="button"
											class="fc-today-button fc-button fc-state-default fc-corner-left fc-corner-right fc-state-disabled"
											disabled="">today</button>
									</div>
									<div class="fc-right">
										<div class="fc-button-group">
											<button type="button"
												class="fc-month-button fc-button fc-state-default fc-corner-left fc-state-active">month</button>
											<button type="button"
												class="fc-agendaWeek-button fc-button fc-state-default">week</button>
											<button type="button"
												class="fc-agendaDay-button fc-button fc-state-default fc-corner-right">day</button>
										</div>
									</div>
									<div class="fc-center">
										<h2>October 2018</h2>
									</div>
									<div class="fc-clear"></div>
								</div>
								<div class="fc-view-container" style="">
									<div class="fc-view fc-month-view fc-basic-view" style="">
										<table>
											<thead class="fc-head">
												<tr>
													<td class="fc-head-container fc-widget-header"><div
															class="fc-row fc-widget-header">
															<table>
																<thead>
																	<tr>
																		<th class="fc-day-header fc-widget-header fc-sun">Sun</th>
																		<th class="fc-day-header fc-widget-header fc-mon">Mon</th>
																		<th class="fc-day-header fc-widget-header fc-tue">Tue</th>
																		<th class="fc-day-header fc-widget-header fc-wed">Wed</th>
																		<th class="fc-day-header fc-widget-header fc-thu">Thu</th>
																		<th class="fc-day-header fc-widget-header fc-fri">Fri</th>
																		<th class="fc-day-header fc-widget-header fc-sat">Sat</th>
																	</tr>
																</thead>
															</table>
														</div></td>
												</tr>
											</thead>
											<tbody class="fc-body">
												<tr>
													<td class="fc-widget-content"><div
															class="fc-scroller fc-day-grid-container"
															style="overflow: hidden; height: 710px;">
															<div class="fc-day-grid fc-unselectable">
																<div class="fc-row fc-week fc-widget-content fc-rigid"
																	style="height: 118px;">
																	<div class="fc-bg">
																		<table>
																			<tbody>
																				<tr>
																					<td
																						class="fc-day fc-widget-content fc-sun fc-other-month fc-past"
																						data-date="2018-09-30"></td>
																					<td
																						class="fc-day fc-widget-content fc-mon fc-today fc-state-highlight"
																						data-date="2018-10-01"></td>
																					<td
																						class="fc-day fc-widget-content fc-tue fc-future"
																						data-date="2018-10-02"></td>
																					<td
																						class="fc-day fc-widget-content fc-wed fc-future"
																						data-date="2018-10-03"></td>
																					<td
																						class="fc-day fc-widget-content fc-thu fc-future"
																						data-date="2018-10-04"></td>
																					<td
																						class="fc-day fc-widget-content fc-fri fc-future"
																						data-date="2018-10-05"></td>
																					<td
																						class="fc-day fc-widget-content fc-sat fc-future"
																						data-date="2018-10-06"></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																	<div class="fc-content-skeleton">
																		<table>
																			<thead>
																				<tr>
																					<td
																						class="fc-day-number fc-sun fc-other-month fc-past"
																						data-date="2018-09-30">30</td>
																					<td
																						class="fc-day-number fc-mon fc-today fc-state-highlight"
																						data-date="2018-10-01">1</td>
																					<td class="fc-day-number fc-tue fc-future"
																						data-date="2018-10-02">2</td>
																					<td class="fc-day-number fc-wed fc-future"
																						data-date="2018-10-03">3</td>
																					<td class="fc-day-number fc-thu fc-future"
																						data-date="2018-10-04">4</td>
																					<td class="fc-day-number fc-fri fc-future"
																						data-date="2018-10-05">5</td>
																					<td class="fc-day-number fc-sat fc-future"
																						data-date="2018-10-06">6</td>
																				</tr>
																			</thead>
																			<tbody>
																				<tr>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																</div>
																<div class="fc-row fc-week fc-widget-content fc-rigid"
																	style="height: 118px;">
																	<div class="fc-bg">
																		<table>
																			<tbody>
																				<tr>
																					<td
																						class="fc-day fc-widget-content fc-sun fc-future"
																						data-date="2018-10-07"></td>
																					<td
																						class="fc-day fc-widget-content fc-mon fc-future"
																						data-date="2018-10-08"></td>
																					<td
																						class="fc-day fc-widget-content fc-tue fc-future"
																						data-date="2018-10-09"></td>
																					<td
																						class="fc-day fc-widget-content fc-wed fc-future"
																						data-date="2018-10-10"></td>
																					<td
																						class="fc-day fc-widget-content fc-thu fc-future"
																						data-date="2018-10-11"></td>
																					<td
																						class="fc-day fc-widget-content fc-fri fc-future"
																						data-date="2018-10-12"></td>
																					<td
																						class="fc-day fc-widget-content fc-sat fc-future"
																						data-date="2018-10-13"></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																	<div class="fc-content-skeleton">
																		<table>
																			<thead>
																				<tr>
																					<td class="fc-day-number fc-sun fc-future"
																						data-date="2018-10-07">7</td>
																					<td class="fc-day-number fc-mon fc-future"
																						data-date="2018-10-08">8</td>
																					<td class="fc-day-number fc-tue fc-future"
																						data-date="2018-10-09">9</td>
																					<td class="fc-day-number fc-wed fc-future"
																						data-date="2018-10-10">10</td>
																					<td class="fc-day-number fc-thu fc-future"
																						data-date="2018-10-11">11</td>
																					<td class="fc-day-number fc-fri fc-future"
																						data-date="2018-10-12">12</td>
																					<td class="fc-day-number fc-sat fc-future"
																						data-date="2018-10-13">13</td>
																				</tr>
																			</thead>
																			<tbody>
																				<tr>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																</div>
																<div class="fc-row fc-week fc-widget-content fc-rigid"
																	style="height: 118px;">
																	<div class="fc-bg">
																		<table>
																			<tbody>
																				<tr>
																					<td
																						class="fc-day fc-widget-content fc-sun fc-future"
																						data-date="2018-10-14"></td>
																					<td
																						class="fc-day fc-widget-content fc-mon fc-future"
																						data-date="2018-10-15"></td>
																					<td
																						class="fc-day fc-widget-content fc-tue fc-future"
																						data-date="2018-10-16"></td>
																					<td
																						class="fc-day fc-widget-content fc-wed fc-future"
																						data-date="2018-10-17"></td>
																					<td
																						class="fc-day fc-widget-content fc-thu fc-future"
																						data-date="2018-10-18"></td>
																					<td
																						class="fc-day fc-widget-content fc-fri fc-future"
																						data-date="2018-10-19"></td>
																					<td
																						class="fc-day fc-widget-content fc-sat fc-future"
																						data-date="2018-10-20"></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																	<div class="fc-content-skeleton">
																		<table>
																			<thead>
																				<tr>
																					<td class="fc-day-number fc-sun fc-future"
																						data-date="2018-10-14">14</td>
																					<td class="fc-day-number fc-mon fc-future"
																						data-date="2018-10-15">15</td>
																					<td class="fc-day-number fc-tue fc-future"
																						data-date="2018-10-16">16</td>
																					<td class="fc-day-number fc-wed fc-future"
																						data-date="2018-10-17">17</td>
																					<td class="fc-day-number fc-thu fc-future"
																						data-date="2018-10-18">18</td>
																					<td class="fc-day-number fc-fri fc-future"
																						data-date="2018-10-19">19</td>
																					<td class="fc-day-number fc-sat fc-future"
																						data-date="2018-10-20">20</td>
																				</tr>
																			</thead>
																			<tbody>
																				<tr>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																</div>
																<div class="fc-row fc-week fc-widget-content fc-rigid"
																	style="height: 118px;">
																	<div class="fc-bg">
																		<table>
																			<tbody>
																				<tr>
																					<td
																						class="fc-day fc-widget-content fc-sun fc-future"
																						data-date="2018-10-21"></td>
																					<td
																						class="fc-day fc-widget-content fc-mon fc-future"
																						data-date="2018-10-22"></td>
																					<td
																						class="fc-day fc-widget-content fc-tue fc-future"
																						data-date="2018-10-23"></td>
																					<td
																						class="fc-day fc-widget-content fc-wed fc-future"
																						data-date="2018-10-24"></td>
																					<td
																						class="fc-day fc-widget-content fc-thu fc-future"
																						data-date="2018-10-25"></td>
																					<td
																						class="fc-day fc-widget-content fc-fri fc-future"
																						data-date="2018-10-26"></td>
																					<td
																						class="fc-day fc-widget-content fc-sat fc-future"
																						data-date="2018-10-27"></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																	<div class="fc-content-skeleton">
																		<table>
																			<thead>
																				<tr>
																					<td class="fc-day-number fc-sun fc-future"
																						data-date="2018-10-21">21</td>
																					<td class="fc-day-number fc-mon fc-future"
																						data-date="2018-10-22">22</td>
																					<td class="fc-day-number fc-tue fc-future"
																						data-date="2018-10-23">23</td>
																					<td class="fc-day-number fc-wed fc-future"
																						data-date="2018-10-24">24</td>
																					<td class="fc-day-number fc-thu fc-future"
																						data-date="2018-10-25">25</td>
																					<td class="fc-day-number fc-fri fc-future"
																						data-date="2018-10-26">26</td>
																					<td class="fc-day-number fc-sat fc-future"
																						data-date="2018-10-27">27</td>
																				</tr>
																			</thead>
																			<tbody>
																				<tr>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																</div>
																<div class="fc-row fc-week fc-widget-content fc-rigid"
																	style="height: 118px;">
																	<div class="fc-bg">
																		<table>
																			<tbody>
																				<tr>
																					<td
																						class="fc-day fc-widget-content fc-sun fc-future"
																						data-date="2018-10-28"></td>
																					<td
																						class="fc-day fc-widget-content fc-mon fc-future"
																						data-date="2018-10-29"></td>
																					<td
																						class="fc-day fc-widget-content fc-tue fc-future"
																						data-date="2018-10-30"></td>
																					<td
																						class="fc-day fc-widget-content fc-wed fc-future"
																						data-date="2018-10-31"></td>
																					<td
																						class="fc-day fc-widget-content fc-thu fc-other-month fc-future"
																						data-date="2018-11-01"></td>
																					<td
																						class="fc-day fc-widget-content fc-fri fc-other-month fc-future"
																						data-date="2018-11-02"></td>
																					<td
																						class="fc-day fc-widget-content fc-sat fc-other-month fc-future"
																						data-date="2018-11-03"></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																	<div class="fc-content-skeleton">
																		<table>
																			<thead>
																				<tr>
																					<td class="fc-day-number fc-sun fc-future"
																						data-date="2018-10-28">28</td>
																					<td class="fc-day-number fc-mon fc-future"
																						data-date="2018-10-29">29</td>
																					<td class="fc-day-number fc-tue fc-future"
																						data-date="2018-10-30">30</td>
																					<td class="fc-day-number fc-wed fc-future"
																						data-date="2018-10-31">31</td>
																					<td
																						class="fc-day-number fc-thu fc-other-month fc-future"
																						data-date="2018-11-01">1</td>
																					<td
																						class="fc-day-number fc-fri fc-other-month fc-future"
																						data-date="2018-11-02">2</td>
																					<td
																						class="fc-day-number fc-sat fc-other-month fc-future"
																						data-date="2018-11-03">3</td>
																				</tr>
																			</thead>
																			<tbody>
																				<tr>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																</div>
																<div class="fc-row fc-week fc-widget-content fc-rigid"
																	style="height: 120px;">
																	<div class="fc-bg">
																		<table>
																			<tbody>
																				<tr>
																					<td
																						class="fc-day fc-widget-content fc-sun fc-other-month fc-future"
																						data-date="2018-11-04"></td>
																					<td
																						class="fc-day fc-widget-content fc-mon fc-other-month fc-future"
																						data-date="2018-11-05"></td>
																					<td
																						class="fc-day fc-widget-content fc-tue fc-other-month fc-future"
																						data-date="2018-11-06"></td>
																					<td
																						class="fc-day fc-widget-content fc-wed fc-other-month fc-future"
																						data-date="2018-11-07"></td>
																					<td
																						class="fc-day fc-widget-content fc-thu fc-other-month fc-future"
																						data-date="2018-11-08"></td>
																					<td
																						class="fc-day fc-widget-content fc-fri fc-other-month fc-future"
																						data-date="2018-11-09"></td>
																					<td
																						class="fc-day fc-widget-content fc-sat fc-other-month fc-future"
																						data-date="2018-11-10"></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																	<div class="fc-content-skeleton">
																		<table>
																			<thead>
																				<tr>
																					<td
																						class="fc-day-number fc-sun fc-other-month fc-future"
																						data-date="2018-11-04">4</td>
																					<td
																						class="fc-day-number fc-mon fc-other-month fc-future"
																						data-date="2018-11-05">5</td>
																					<td
																						class="fc-day-number fc-tue fc-other-month fc-future"
																						data-date="2018-11-06">6</td>
																					<td
																						class="fc-day-number fc-wed fc-other-month fc-future"
																						data-date="2018-11-07">7</td>
																					<td
																						class="fc-day-number fc-thu fc-other-month fc-future"
																						data-date="2018-11-08">8</td>
																					<td
																						class="fc-day-number fc-fri fc-other-month fc-future"
																						data-date="2018-11-09">9</td>
																					<td
																						class="fc-day-number fc-sat fc-other-month fc-future"
																						data-date="2018-11-10">10</td>
																				</tr>
																			</thead>
																			<tbody>
																				<tr>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																					<td></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																</div>
															</div>
														</div></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />