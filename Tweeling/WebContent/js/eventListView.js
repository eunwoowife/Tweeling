var eventType;
var eventStatus;
var listCount;
var currentPage;
var pageLimit = 10;
var boardLimit = 10;
var maxPage;
var startPage;
var endPage;
var loginUserNo;

$(function () {
	startPage = 1;
	selectCelebEvent();
	loginUserNo = $("#loginUserNo").val();
});

function selectCelebEvent() {
	selectActiveCeleb();
}

function selectAndEvent() {
	selectActiveAnd();
}

function backToEventList() {
	selectList();
}

function selectActiveCeleb() {
	$("#activeCeleb").css("font-weight", "bold");
	$("#inactiveCeleb").css("font-weight", "normal");
	$("#gotchaCeleb").css("font-weight", "normal");
	eventType = 1;
	eventStatus = 1;
	currentPage = 1;
	selectList();
}

function selectInactiveCeleb() {
	$("#activeCeleb").css("font-weight", "normal");
	$("#inactiveCeleb").css("font-weight", "bold");
	$("#gotchaCeleb").css("font-weight", "normal");
	eventType = 1;
	eventStatus = 2;
	currentPage = 1;
	selectList();
}

function selectGotchaCeleb() {
	$("#activeCeleb").css("font-weight", "normal");
	$("#inactiveCeleb").css("font-weight", "normal");
	$("#gotchaCeleb").css("font-weight", "bold");
	eventType = 3;
	eventStatus = 3;
	currentPage = 1;
	selectList();
}

function selectActiveAnd() {
	$("#activeAnd").css("font-weight", "bold");
	$("#inactiveAnd").css("font-weight", "normal");
	$("#gotchaAnd").css("font-weight", "normal");
	eventType = 2;
	eventStatus = 1;
	currentPage = 1;
	selectList();
}

function selectInactiveAnd() {
	$("#activeAnd").css("font-weight", "normal");
	$("#inactiveAnd").css("font-weight", "bold");
	$("#gotchaAnd").css("font-weight", "normal");
	eventType = 2;
	eventStatus = 2;
	currentPage = 1;
	startPage = 1;
	selectList();
}

function selectGotchaAnd() {
	$("#activeAnd").css("font-weight", "normal");
	$("#inactiveAnd").css("font-weight", "normal");
	$("#gotchaAnd").css("font-weight", "bold");
	eventType = 4;
	eventStatus = 3;
	currentPage = 1;
	startPage = 1;
	selectList();
}

function toPreviousPage() {
	currentPage--;
	selectList();
}

function toNextPage() {
	currentPage++;
	selectList();
}

function selectList() {
	$.ajax({
		url: "eventListCount.event",
		data: {
			eventType,
			eventStatus
		},
		success: function (result) {
			listCount = result;
			maxPage = Math.ceil(listCount / boardLimit);
			startPage = Math.floor((currentPage - 1) / pageLimit) * pageLimit + 1;
			endPage = startPage + pageLimit - 1;
			if (endPage > maxPage) {
				endPage = maxPage;
			}
			$.ajax({
				url: "eventList.event",
				data: {
					eventType,
					eventStatus,
					listCount,
					currentPage,
					pageLimit,
					boardLimit,
					maxPage,
					startPage,
					endPage
				},
				success: function (list) {
					var thead = "";
					var tbody = "";
					var tfoot = "";
					var adminMenu = "";
					var pagingBar = "";
					if (eventType == 1 || eventType == 3) {
						thead += "<tr><th width='100px'>번호</th><th width='300px'>주제</th><th width='1100px'>제목</th><th width='200px'>게시일</th></tr>";
						tfoot += "<tr><td colspan='4'><div align='center' class='paging-area'><br><ul class='pagination justify-content-center' style='cursor: pointer;'></ul></div></td></tr>"
						if (list.length == 0) {
							tbody += "<tr><td colspan='4' align='center'><small>검색 결과가 없습니다</small></td></tr>";
						} else {
							for (var i = 0; i < list.length; i++) {
								tbody += "<tr><td class='seeEvent'>" + list[i].eventNo + "</td><td class='seeEvent'>"
									+ list[i].eventTopic + "</td><td class='seeEvent'>"
									+ list[i].eventTitle + "</td><td class='seeEvent'>"
									+ list[i].createDate + "</td></tr>"
							}
						}
						if (currentPage != startPage) {
							pagingBar += "<li class='page-item'><a class='page-link previousPage' href='#' aria-label='Previous' onclick='toPreviousPage();'><span aria-hidden='true'>&laquo;</span><span class='sr-only'>Previous</span></a></li>";
						}
						for (var i = startPage; i <= endPage; i++) {
							pagingBar += "<li class='page-item'><a class='page-link goToPagei' href='#'>" + i + "</a></li>";
						}
						if (list.length != 0 && currentPage != endPage) {
							pagingBar += "<li class='page-item'><a class='page-link nextPage' href='#' aria-label='Next' onclick='toNextPage();'><span aria-hidden='true'>&raquo;</span><span class='sr-only'>Next</span></a></li>";
						}
						$("#celebEvent>thead").html(thead);
						$("#celebEvent>tbody").html(tbody);
						$("#celebEvent>tfoot").html(tfoot);
						$("#celeb-admin-menu1").html(adminMenu);
						$("#celeb-admin-menu2").html(adminMenu);
						$("#celeb-admin-menu3").html(adminMenu);
						$(".seeEvent").click(function () {
							eventNo = $(this).parent().children().eq(0).text();
							selectDetailedList(eventNo);
						});
						$("#celebEvent>tfoot>tr>td>div>ul").html(pagingBar);
						$(".goToPagei").click(function () {
							currentPage = $(this).text();
							selectList();
						});
					}
					if (eventType == 2 || eventType == 4) {
						thead += "<tr><th width='100px'>번호</th><th width='1400px'>제목</th><th width='200px'>게시일</th></tr>";
						tfoot += "<tr><td colspan='3'><div align='center' class='paging-area'><br><ul class='pagination justify-content-center' style='cursor: pointer;'></ul></div></td></tr>"
						if (list.length == 0) {
							tbody += "<tr><td colspan='4' align='center'><small>검색 결과가 없습니다</small></td></tr>";
						} else {
							for (var i = 0; i < list.length; i++) {
								tbody += "<tr><td class='seeEvent'>" + list[i].eventNo + "</td><td class='seeEvent'>"
									+ list[i].eventTitle + "</td><td class='seeEvent'>"
									+ list[i].createDate + "</td></tr>"
							}
						}
						if (currentPage != startPage) {
							pagingBar += "<li class='page-item'><a class='page-link' href='#' aria-label='Previous' onclick='toPreviousPage();'><span aria-hidden='true'>&laquo;</span><span class='sr-only'>Previous</span></a></li>";
						}
						for (var i = startPage; i <= maxPage; i++) {
							pagingBar += "<li class='page-item'><a class='page-link goToPagei' href='#'>" + i + "</a></li>";
						}
						if (list.length != 0 && currentPage != endPage) {
							pagingBar += "<li class='page-item'><a class='page-link' href='#' aria-label='Next' onclick='toNextPage();'><span aria-hidden='true'>&raquo;</span><span class='sr-only'>Next</span></a></li>";
						}
						$("#andEvent>thead").html(thead);
						$("#andEvent>tbody").html(tbody);
						$("#andEvent>tfoot").html(tfoot);
						$("#and-admin-menu1").html(adminMenu);
						$("#and-admin-menu2").html(adminMenu);
						$("#and-admin-menu3").html(adminMenu);
						$(".seeEvent").click(function () {
							eventNo = $(this).parent().children().eq(0).text();
							selectDetailedList(eventNo);
						});
						$("#andEvent>tfoot>tr>td>div>ul").html(pagingBar);
						$(".goToPagei").click(function () {
							currentPage = $(this).text();
							selectList();
						});
					}
				},
				error: function () {
					console.log("통신 실패");
				}
			});
		},
		error: function () {
			console.log("통신 실패");
		}
	});
}

function selectDetailedList(eventNo) {
	$.ajax({
		url: "viewDetailedEvent.event",
		data: {
			eventNo
		},
		success: function (ev) {
			$.ajax({
				url: "viewEventAttachment.event",
				data: {
					eventNo
				},
				success: function (ea) {
					var sd = new Date(ev.eventStartDate);
					var ed = new Date(ev.eventEndDate);
					var cd = new Date();
					var ssd = (sd - cd);
					var eed = (ed - cd);
					var gotchaYn = ev.gotchaYn;
					var thead = "";
					var tbody = "";
					var tfoot = "<tr><td colspan='2' align='center'><a href='#' style='color:#000;' onclick='backToEventList();'>목록으로</a></td></tr>";
					var adminMenu = "";
					var adminMenu2 = "";
					var adminMenu3 = "";
					if (ev.eventType == 1 || ev.eventType == 2) {
						thead += "<tr><th width='1300px'>" + ev.eventTitle + "</th><th width='400px'>업로드일: " + ev.createDate + "</th></tr><tr><th colspan='2'>이벤트 접수 기간: " + ev.eventStartDate + " ~ " + ev.eventEndDate + "</th></tr>";
					} else {
						thead += "<tr><th width='1300px'>" + ev.eventTitle + "</th><th width='400px'>업로드일: " + ev.createDate + "</th></tr>"
					}
					adminMenu += "<button class='btn btn-secondary' data-toggle='modal' data-target='#modifyThisEvent' onclick='modifyThisEvent();'>글 수정</button>&nbsp;<button class='btn btn-danger' onclick='deleteThisShit();'>글 삭제</button>";
					if (gotchaYn == "N") {
						adminMenu2 = "<button class='btn btn-secondary' data-toggle='modal' data-target='#gotchaThisEvent' onclick='gotchaThisShit();'>이벤트 추첨</button>&nbsp;<button class='btn btn-danger' onclick='deleteThisShit();'>글 삭제</button>";
					} else {
						adminMenu2 = "<button class='btn btn-secondary disabled'>이미 추첨이 완료된 이벤트입니다</button>&nbsp;<button class='btn btn-danger' onclick='deleteThisShit();'>글 삭제</button>";
					}
					adminMenu3 += "<button class='btn btn-danger' onclick='deleteThisShit();'>글 삭제</button>";
					if (ssd > 0) {
						if (ea.eventFilePath != null) {
							tbody += "<tr><td colspan='2' style='white-space:pre;'>" + ev.eventContent + "</td></tr><tr><td colspan='2'><small>첨부파일: <a href='" + ea.eventFilePath + ea.eventChangeName + "' target='_blank'>" + ea.eventChangeName + "</a></small></td><tr><tr><td colspan='2' align='center'><button class='btn btn-info btn-lg disabled'>이벤트 지원 기간이 아닙니다</button></td></tr>";
						} else {
							tbody += "<tr><td colspan='2' style='white-space:pre;'>" + ev.eventContent + "</td></tr><tr><td colspan='2'><small>첨부파일이 없습니다</small></td><tr><tr><td colspan='2' align='center'><button class='btn btn-info btn-lg disabled'>이벤트 지원 기간이 아닙니다</button></td></tr>";
						}
					} else if (ssd <= 0 && eed > 0) {
						if (ea.eventFilePath != null) {
							tbody += "<tr><td colspan='2' style='white-space:pre;'>" + ev.eventContent + "</td></tr><tr><td colspan='2'><small>첨부파일: <a href='" + ea.eventFilePath + ea.eventChangeName + "' target='_blank'>" + ea.eventChangeName + "</a></small></td><tr><tr><td colspan='2' align='center'><button class='btn btn-info btn-lg' onclick='clickGotchaApply();'>이벤트 참여하기</button></td></tr>";
						} else {
							tbody += "<tr><td colspan='2' style='white-space:pre;'>" + ev.eventContent + "</td></tr><tr><td colspan='2'><small>첨부파일이 없습니다</small></td><tr><tr><td colspan='2' align='center'><button class='btn btn-info btn-lg' onclick='clickGotchaApply();'>이벤트 참여하기</button></td></tr>";
						}
					} else {
						if (ea.eventFilePath != null) {
							tbody += "<tr><td colspan='2' style='white-space:pre;'>" + ev.eventContent + "</td></tr><tr><td colspan='2'><small>첨부파일: <a href='" + ea.eventFilePath + ea.eventChangeName + "' target='_blank'>" + ea.eventChangeName + "</a></small></td><tr><tr><td colspan='2' align='center'><button class='btn btn-info btn-lg disabled'>이미 종료된 이벤트입니다</button></td></tr>";
						} else {
							tbody += "<tr><td colspan='2' style='white-space:pre;'>" + ev.eventContent + "</td></tr><tr><td colspan='2'><small>첨부파일이 없습니다</small></td><tr><tr><td colspan='2' align='center'><button class='btn btn-info btn-lg disabled'>이미 종료된 이벤트입니다</button></td></tr>";
						}
					}
					if (eventType == 1 || eventType == 3) {
						$("#celebEvent>thead").html(thead);
						$("#celebEvent>tbody").html(tbody);
						$("#celebEvent>tfoot").html(tfoot);
						$("#celeb-admin-menu1").html(adminMenu);
						$("#celeb-admin-menu2").html(adminMenu2);
						$("#celeb-admin-menu3").html(adminMenu3);
					}
					if (eventType == 2 || eventType == 4) {
						$("#andEvent>thead").html(thead);
						$("#andEvent>tbody").html(tbody);
						$("#andEvent>tfoot").html(tfoot);
						$("#and-admin-menu1").html(adminMenu);
						$("#and-admin-menu2").html(adminMenu2);
						$("#and-admin-menu3").html(adminMenu3);
					}
				}, error: function () {
					console.log("통신 실패");
				}
			});
		},
		error: function () {
			console.log("통신 실패");
		}
	});
}

function modifyThisEvent() {
	$.ajax({
		url: "viewDetailedEvent.event",
		data: {
			eventNo
		},
		success: function (ev) {
			$("#modifyEventNo").val(ev.eventNo);
			$("#modifyEventType").val(ev.eventType);
			$("#modifyEventTopic").val(ev.eventTopic);
			$("#modifyEventTitle").val(ev.eventTitle);
			$("#modifyEventContent").val(ev.eventContent);
			var sd = new Date(ev.eventStartDate);
			var ed = new Date(ev.eventEndDate);
			var startDateOffset = sd.getTimezoneOffset() * 60000;
			var endDateOffset = ed.getTimezoneOffset() * 60000;
			document.getElementById("modifyEventStartDate").value = new Date(sd - startDateOffset).toISOString().substring(0, 10);
			document.getElementById("modifyEventEndDate").value = new Date(ed - endDateOffset).toISOString().substring(0, 10);
		},
		error: function () {
			console.log("통신 실패");
		}
	});
}

function deleteThisShit() {
	if (window.confirm("정말 삭제하시겠습니까?")) {
		$.ajax({
			url: "deleteThisShit.event",
			data: {
				eventNo
			},
			success: function () {
				window.alert("이벤트가 삭제되었습니다.");
				location.reload();
			},
			error: function () {
				console.log("통신 실패");
			}
		});
	} else {
		window.alert("삭제를 취소합니다.");
	}
}

function clickGotchaApply() {
	if (loginUserNo == null) {
		window.alert("로그인 후 이용한 서비스입니다.");
		location.reload();
	} else {
		$.ajax({
			url: "checkGotchaStatus.event",
			data: {
				eventNo,
				loginUserNo
			},
			success: function (eapp) {
				if (eapp.applyStatus == "Y") {
					if (window.confirm("이미 지원하신 이벤트입니다. 이벤트 지원을 취소하시겠습니까?")) {
						$.ajax({
							url: "deleteGotchaStatus.event",
							data: {
								eventNo,
								loginUserNo
							},
							success: function () {
								window.alert("이벤트 지원이 취소되었습니다.");
								location.reload();
							},
							error: function () {
								console.log("통신 실패");
							}
						});
					}
				} else {
					$("#eventApplyModal").modal();
					var eventTitle = "";
					var eventStartDate = "";
					var eventEndDate = "";
					$.ajax({
						url: "viewDetailedEvent.event",
						data: {
							eventNo
						},
						success: function (ev) {
							eventTitle += ev.eventTitle;
							eventStartDate += ev.eventStartDate;
							eventEndDate += ev.eventEndDate;
							$("#applyEventTitle>h4>b").html(eventTitle);
							$("#applyEventStartDate>b").html(eventStartDate);
							$("#applyEventEndDate>b").html(eventEndDate);
						},
						error: function () {
							console.log("통신 실패");
						}
					});
				}
			},
			error: function () {
				console.log("통신 실패");
			}
		});
	}
}

function submitGotchaApply() {
	var userNo = $("#userNo").val();
	$.ajax({
		url: "gotchaApply.event",
		data: {
			eventNo,
			userNo
		},
		success: function () {
			window.alert("이벤트 지원이 완료되었습니다");
			location.reload();
		},
		error: function () {
			console.log("통신 실패");
		}
	});
}

function gotchaThisShit() {
	$("#gotchaThisShitModal").modal();
	$.ajax({
		url: "viewDetailedEvent.event",
		data: {
			eventNo
		},
		success: function (ev) {
			console.log(ev);
			var gotchaResultTitle = ev.eventTitle + " 당첨자 발표";
			$("#gotchaResultNo").val(ev.eventNo);
			$("#gotchaResultType").val(ev.eventType);
			$("#gotchaResultTopic").val(ev.eventTopic);
			$("#gotchaResultTitle").val(gotchaResultTitle);
			$.ajax({
				url: "showGotchaResult.event",
				data: {
					eventNo
				},
				success: function (gotcha) {
					console.log(gotcha);
					var gotchaResultContent ="안녕하세요 Tweeling입니다.\r\n\r\n" + ev.eventTitle + " 이벤트에 지원해주신 모든 분께 감사드립니다.\r\n\r\n당첨자 목록은 아래와 같습니다.\r\n\r\n";
					for (var i = 0; i < gotcha.length; i++) {
						gotchaResultContent += "아이디: " + gotcha[i].gotchaUserNo + " 닉네임: " + gotcha[i].gotchaUserNickname + " 전화번호 뒷 4자리: " + gotcha[i].gotchaUserPhone + "\r\n";
					}
					gotchaResultContent += "\r\n감사합니다.\r\n\r\nTweeling 배상"
					$("#gotchaResultContent").val(gotchaResultContent);
				},
				error: function () {
					console.log("통신 실패");
				}
			});
		},
		error: function () {
			console.log("통신 실패");
		}
	});
}