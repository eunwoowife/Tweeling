<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html lang="ko">

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>EVENT</title>
		<link rel="stylesheet" href="css/eventListView.css">
	</head>

	<body>

		<header>
			<%@ include file="/views/common/menubar2.jsp" %>
		</header>

		<div class="container">

			<% if (loginUser !=null) { %>
				<input type="hidden" id="loginUserNo" name="loginUserNo" value="<%= loginUser.getUserNo() %>">
				<% } %>

					<section id="tabs">

						<div class="container">

							<br>

							<h1 class="section-title h1" align="center"><b>EVENT</b></h1>

							<br>

							<% if (loginUser !=null && loginUser.getAdminStatus().equals("Y")) { %>
								<div class="admin-button" align="right">
									<button class="btn btn-secondary" data-toggle="modal"
										data-target="#startANewEvent">신규 이벤트
										작성</button>
								</div>
								<% } %>

									<div class="row">

										<div class="col-xs-12">

											<nav>

												<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">

													<a class="nav-item nav-link active" id="celeb-event-tab"
														data-toggle="tab" href="#celeb-event" role="tab"
														aria-controls="celeb-event" aria-selected="true"
														onclick="selectCelebEvent();"><b>CELEB EVENT</b></a>

													<a class="nav-item nav-link" id="and-event-tab" data-toggle="tab"
														href="#and-event" role="tab" aria-controls="and-event"
														aria-selected="false" onclick="selectAndEvent();"><b>AND
															EVENT</b></a>

												</div>

											</nav>

											<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">

												<div class="tab-pane fade show active" id="celeb-event" role="tabpanel"
													aria-labelledby="celeb-event-tab">

													<div class="nav" role="tablist">

														<a href="#activeCelebEvent" id="activeCeleb"
															class="selectEvent nav-item nav-link" data-toggle="tab"
															role="tab" aria-controls="activeCelebEvent"
															aria-selected="true" onclick="selectActiveCeleb();">진행중
															이벤트</a>
														<a href="#inactiveCelebEvent" id="inactiveCeleb"
															class="selectEvent nav-item nav-link" data-toggle="tab"
															role="tab" aria-controls="inactiveCelebEvent"
															aria-selected="false" onclick="selectInactiveCeleb();">종료된
															이벤트</a>
														<a href="#gotchaCelebEvent" id="gotchaCeleb"
															class="selectEvent nav-item nav-link" data-toggle="tab"
															role="tab" aria-controls="gotchaCelebEvent"
															aria-selected="false" onclick="selectGotchaCeleb();">당첨자
															발표</a>

													</div>

													<br>

													<div class="tab-content">

														<div id="activeCelebEvent" class="tab-pane fade show active"
															role="tabpanel" aria-labelledby="activeCelebEvent">

															<table id="celebEvent" class="table table-hover"
																style="cursor: pointer;">

																<thead>
																</thead>

																<tbody>
																</tbody>

																<tfoot>
																</tfoot>

															</table>

															<% if (loginUser !=null &&
																loginUser.getAdminStatus().equals("Y")) { %>
																<div id="celeb-admin-menu1" align="center">
																</div>
																<% } %>

														</div>

														<div id="inactiveCelebEvent" class="tab-pane fade"
															role="tabpanel" aria-labelledby="inactiveCelebEvent">

															<table id="celebEvent" class="table table-hover"
																style="cursor: pointer;">

																<thead>
																</thead>

																<tbody>
																</tbody>

																<tfoot>
																</tfoot>

															</table>

															<% if (loginUser !=null &&
																loginUser.getAdminStatus().equals("Y")) { %>
																<div id="celeb-admin-menu2" align="center">
																</div>
																<% } %>

														</div>

														<div id="gotchaCelebEvent" class="tab-pane fade" role="tabpanel"
															aria-labelledby="gotchaCelebEvent">

															<table id="celebEvent" class="table table-hover"
																style="cursor: pointer;">

																<thead>
																</thead>

																<tbody>
																</tbody>

																<tfoot>
																</tfoot>

															</table>

															<% if (loginUser !=null &&
																loginUser.getAdminStatus().equals("Y")) { %>
																<div id="celeb-admin-menu3" align="center">
																</div>
																<% } %>

														</div>

													</div>

												</div>

												<div class="tab-pane fade" id="and-event" role="tabpanel"
													aria-labelledby="and-event-tab">

													<div class="nav" role="tablist">

														<a href="#activeAndEvent" id="activeAnd"
															class="selectEvent nav-item nav-link" data-toggle="tab"
															role="tab" aria-controls="activeAndEvent"
															aria-selected="true" onclick="selectActiveAnd();">진행중
															이벤트</a>
														<a href="#inactiveAndEvent" id="inactiveAnd"
															class="selectEvent nav-item nav-link" data-toggle="tab"
															role="tab" aria-controls="inactiveAndEvent"
															aria-selected="false" onclick="selectInactiveAnd();">종료된
															이벤트</a>
														<a href="#gotchaAndEvent" id="gotchaAnd"
															class="selectEvent nav-item nav-link" data-toggle="tab"
															role="tab" aria-controls="gotchaAndEvent"
															aria-selected="false" onclick="selectGotchaAnd();">당첨자
															발표</a>

													</div>

													<br>

													<div class="tab-content">

														<div id="activeAndEvent" class="tab-pane fade show active"
															role="tabpanel" aria-labelledby="activeAndEvent">

															<table id="andEvent" class="table table-hover"
																style="cursor: pointer;">

																<thead>
																</thead>

																<tbody>
																</tbody>

																<tfoot>
																</tfoot>

															</table>

															<% if (loginUser !=null &&
																loginUser.getAdminStatus().equals("Y")) { %>
																<div id="and-admin-menu1" align="center">
																</div>
																<% } %>

														</div>

														<div id="inactiveAndEvent" class="tab-pane fade" role="tabpanel"
															aria-labelledby="inactiveAndEvent">

															<table id="andEvent" class="table table-hover"
																style="cursor: pointer;">

																<thead>
																</thead>

																<tbody>
																</tbody>

																<tfoot>
																</tfoot>

															</table>

															<% if (loginUser !=null &&
																loginUser.getAdminStatus().equals("Y")) { %>
																<div id="and-admin-menu2" align="center">
																</div>
																<% } %>

														</div>

														<div id="gotchaAndEvent" class="tab-pane fade" role="tabpanel"
															aria-labelledby="gotchaAndEvent">

															<table id="andEvent" class="table table-hover"
																style="cursor: pointer;">

																<thead>
																</thead>

																<tbody>
																</tbody>

																<tfoot>
																</tfoot>

															</table>

															<% if (loginUser !=null &&
																loginUser.getAdminStatus().equals("Y")) { %>
																<div id="and-admin-menu3" align="center">
																</div>
																<% } %>

														</div>

													</div>

												</div>

											</div>

										</div>

									</div>

						</div>

						<div class="modal fade" id="startANewEvent" data-backdrop="static" data-keyboard="false"
							tabindex="-1" aria-labelledby="startANewEvent" aria-hidden="true">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="startANewEventLabel"><b>CREATE A NEW EVENT</b></h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<form action="eventInsert.event" method="post" id="event-enroll-form"
											enctype="multipart/form-data">
											<div class="form-group form-row">
												<div class="col-6">
													<label for="eventType">EVENT TYPE</label>
													<select class="form-control" name="eventType" required>
														<option value="1">CELEB EVENT</option>
														<option value="2">AND EVENT</option>
													</select>
												</div>
												<div class="col-6">
													<label for="eventTopic">EVENT TOPIC</label>
													<select id="chooseEventTopic" class="form-control" name="eventTopic"
														required>
														<option value="ARIANA GRANDE">CELEB: ARIANA GRANDE</option>
														<option value="DOJA CAT">CELEB: DOJA CAT</option>
														<option value="DUA LIPA">CELEB: DUA LIPA</option>
														<option value="JUSTIN BIEBER">CELEB: JUSTIN BIEBER</option>
														<option value="TAYLOR SWIFT">CELEB: TAYLOR SWIFT</option>
														<option value="WHY DON'T WE">CELEB: WHY DON'T WE</option>
														<option value="">AND EVENT: ETC</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label for="eventTitle">EVENT TITLE</label>
												<input type="text" class="form-control" name="eventTitle"
													placeholder="이벤트 제목을 입력하세요" requierd>
											</div>
											<div class="from-group form-row">
												<div class="col-6">
													<label for="eventStartDate">EVENT START DATE</label>
													<input type="date" class="form-control" name="eventStartDate"
														required>
												</div>
												<div class="col-6">
													<label for="eventEndDate">EVENT END DATE</label>
													<input type="date" class="form-control" name="eventEndDate"
														required>
												</div>
											</div>
											<br>
											<div class="form-group">
												<label for="eventContent">EVENT CONTENT</label>
												<textarea name="eventContent" class="form-control" rows="10"
													placeholder="이벤트 내용을 입력하세요" style="resize: none; white-space: pre;"
													required></textarea>
											</div>
											<div class="form-group">
												<label for="eventAttachment">ATTACHMENT</label>
												<input type="file" class="form-control" name="eventAttachment"
													id="eventAttachment">
											</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-primary">새 이벤트 작성</button>
										<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
									</div>
									</form>
								</div>
							</div>
						</div>

						<div class="modal fade" id="modifyThisEvent" data-backdrop="static" data-keyboard="false"
							tabindex="-1" aria-labelledby="modifyThisEvent" aria-hidden="true">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="modifyThisEventLabel"><b>MODITY THIS EVENT</b></h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<form action="eventModify.event" method="post" id="event-modify-form"
											enctype="multipart/form-data">
											<div class="form-group form-row">
												<div class="col-6">
													<label for="modifyEventType">EVENT TYPE</label>
													<select id="modifyEventType" class="form-control"
														name="modifyEventType" required>
														<option value="1">CELEB EVENT</option>
														<option value="2">AND EVENT</option>
													</select>
												</div>
												<div class="col-6">
													<label for="modifyEventTopic">EVENT TOPIC</label>
													<select id="modifyEventTopic" class="form-control"
														name="modifyEventTopic" required>
														<option value="ARIANA GRANDE">CELEB: ARIANA GRANDE</option>
														<option value="DOJA CAT">CELEB: DOJA CAT</option>
														<option value="DUA LIPA">CELEB: DUA LIPA</option>
														<option value="JUSTIN BIEBER">CELEB: JUSTIN BIEBER</option>
														<option value="TAYLOR SWIFT">CELEB: TAYLOR SWIFT</option>
														<option value="WHY DON'T WE">CELEB: WHY DON'T WE</option>
														<option value="">AND EVENT: ETC</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<input type="hidden" id="modifyEventNo" name="modifyEventNo" value="">
												<label for="modifyEventTitle">EVENT TITLE</label>
												<input type="text" class="form-control" id="modifyEventTitle"
													name="modifyEventTitle" placeholder="이벤트 제목을 입력하세요" requierd>
											</div>
											<div class="from-group form-row">
												<div class="col-6">
													<label for="modifyEventStartDate">EVENT START DATE</label>
													<input type="date" id="modifyEventStartDate" class="form-control"
														name="modifyEventStartDate" required>
												</div>
												<div class="col-6">
													<label for="modifyEventEndDate">EVENT END DATE</label>
													<input type="date" id="modifyEventEndDate" class="form-control"
														name="modifyEventEndDate" required>
												</div>
											</div>
											<br>
											<div class="form-group">
												<label for="modifyEventContent">EVENT CONTENT</label>
												<textarea name="modifyEventContent" id="modifyEventContent"
													class="form-control" rows="10" placeholder="이벤트 내용을 입력하세요"
													style="resize:none; white-space: pre;" required></textarea>
											</div>

									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-primary">이벤트 수정</button>
										<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
									</div>
									</form>
								</div>
							</div>
						</div>

						<div class="modal fade" id="eventApplyModal" role="dialog" data-backdrop="static"
							data-keyboard="false" tabindex="-1" aria-labelledby="eventApplyModal" aria-hidden="true">
							<div class="modal-dialog modal-lg" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="eventApplyModalLabel"><b>APPLY AN EVENT</b></h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<p>
											[약관]<br>
											1. 참가 방법 및 경품에 대한 정보는 본 약관의 일부를 구성합니다. Tweeling(이하 ‘회사’)이 주최하는 모든 이벤트에 대한
											참가는 본 약관에
											대한 수락으로 간주됩니다.<br>
											2. 각 이벤트는 회사가 운영하는 행사 부스, 온라인 페이지에서 진행하는 이벤트에 참여 완료해주신 고객들을 대상으로 합니다.<br>
											3. 각 이벤트는 회사가 규정한 이벤트 기간 동안 진행됩니다.<br>
											4. 법인의 경우 본 이벤트 참여가 불가능하며, 미성년자가 참여시에는 추후에 회사가 해당 참여를 취소할 수 있는 권리를
											보유합니다.<br>
											5. 이벤트 당첨을 위한 목적으로 부정한 방식으로 응모되었다고 판단되는 경우, 당첨에서 제외 또는 취소될 수 있습니다.<br>
											6. 본 약관을 위반하는 경우는 당첨에서 제외 또는 취소됩니다.<br>
											7. 각 이벤트별 고객 참여는 한 번으로 제한되며 의도적으로 한 개 이상의 계정을 만드는 경우 이벤트 참여가 취소될 수 있습니다.<br>
											8. 이벤트 참여를 위해 적용되는 온라인 플랫폼들의 규정을 준수해야 합니다.<br>
											9. 이벤트 참여 시 촬영한 사진/동영상 형식의 리뷰가 회사 웹사이트에 업로드될 수 있으며, 업로드 시 소속 기관, 이름, 직위를
											공개하는 데
											동의합니다.<br>
											10. 관련 데이터 보호법에 따라 참가자는 이벤트에 참가하는 동안 회사에 제출한 개인정보, 시청각 파일 등 고객의 데이터를 회사가 수집,
											사용, 저장,
											처리, 관리 및 공유하는 데 동의합니다.<br>
											11. 회사는 참가자의 불법적인 이벤트 참여로 인해 발생할 수 있는 모든 과오나 손해에 대해 전적으로 책임지지 않습니다. 이벤트 참가자는
											공정한 이벤트
											참가를 위해 이용약관을 읽고 이해했으며 단독 재량으로 이벤트에 참여했음에 동의합니다.<br>
											12. 회사는 이벤트 참여, 실시 및 취소에 대한 모든 권리를 갖게 되며, 회사 자체 재량으로 수정할 수 있습니다.<br>
										</p>
										<br>
										<p>
											이벤트 정보를 확인해주세요
										</p>
										<div id="applyEventTitle">
											<h4><b></b></h4>
										</div>
										<div id="applyEventStartDate">이벤트 접수 시작일: <b></b></div>
										<div id="applyEventEndDate">이벤트 접수 마감일: <b></b></div>
										<% if (loginUser !=null) { %>
											<input type="hidden" id="userNo" name="userNo"
												value="<%= loginUser.getUserNo() %>">
											<% } %>
									</div>
									<div class="modal-footer" align="center">
										<button class="btn btn-info" onclick="submitGotchaApply();">네, 모든 약관에 동의하며 이벤트에
											참여합니다</button>
										<button type="button" class="btn btn-secondary" data-dismiss="modal">아니오, 다음 기회에
											참여하겠습니다</button>
									</div>
								</div>
							</div>
						</div>

						<div class="modal fade" id="gotchaThisShitModal" data-backdrop="static" data-keyboard="false"
							tabindex="-1" aria-labelledby="GotchaThisShit" aria-hidden="true">
							<div class="modal-dialog modal-lg">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="GotchaThisShitLabel"><b>EVENT RESULTS</b></h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<form action="submitGotchaResult.event" method="post" id="gotcha-result-form"
											enctype="multipart/form-data">
											<input type="hidden" name="gotchaResultNo" id="gotchaResultNo">
											<div class="form-group form-row">
												<div class="col-6">
													<label for="gotchaResultType">EVENT TYPE</label>
													<select id="gotchaResultType" class="form-control"
														name="gotchaResultType" required>
														<option value="1">CELEB EVENT</option>
														<option value="2">AND EVENT</option>
													</select>
												</div>
												<div class="col-6">
													<label for="gotchaResultTopic">EVENT TOPIC</label>
													<select id="gotchaResultTopic" class="form-control"
														name="gotchaResultTopic" required>
														<option value="ARIANA GRANDE">CELEB: ARIANA GRANDE</option>
														<option value="DOJA CAT">CELEB: DOJA CAT</option>
														<option value="DUA LIPA">CELEB: DUA LIPA</option>
														<option value="JUSTIN BIEBER">CELEB: JUSTIN BIEBER</option>
														<option value="TAYLOR SWIFT">CELEB: TAYLOR SWIFT</option>
														<option value="WHY DON'T WE">CELEB: WHY DON'T WE</option>
														<option value="">AND EVENT: ETC</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label for="gotchaResultTitle">EVENT TITLE</label>
												<input type="text" class="form-control" name="gotchaResultTitle" id="gotchaResultTitle"  requierd>
											</div>
											<br>
											<div class="form-group">
												<label for="gotchaResultContent">EVENT CONTENT</label>
												<textarea name="gotchaResultContent" id="gotchaResultContent" class="form-control" rows="10" style="resize: none; white-space: pre;" required></textarea>
											</div>
											<div class="form-group">
												<label for="gotchaAttachment">ATTACHMENT</label>
												<input type="file" class="form-control" name="gotchaAttachment"
													id="gotchaAttachment">
											</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-primary">당첨자 발표 글 게시</button>
										<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
									</div>
									</form>
								</div>
							</div>
						</div>

					</section>

					<script src="js/eventListView.js"></script>

		</div>

		<footer>
			<%@ include file="/views/common/footer.jsp" %>
		</footer>