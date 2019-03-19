<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<head>
<title>허위매물신고</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_board.css" rel="stylesheet" type="text/css">
<link href="resources/css/board_write.css" rel="stylesheet" type="text/css">

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript" src="resources/js/board_write.js"></script>
<script>
function car_check() {
	window.open('car_find.bo','허위매물 차량 검색','width=950,height=650,scrollbars=yes');
}
</script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">
					<!-- Login -->
					<ul id="login_menu">
						<li><a href="main"><div class="page_name">홈</div></a></li>
						<li><a href="#"><div class="page_name">관리페이지</div></a></li>
						<li><a href="logout.str"><div class="page_name">로그아웃</div></a></li>
					</ul>
					<div id="dealer_info">
						<span>${dealer_name }님 관리페이지</span>
					</div>
					<div id="manage_list">
						<ul class="list_category">
							<!-- <div>
								─ 차량 변경 시, 차량을 검색하세요.<button id="findcar_btn" onclick="car_check()">차량 선택</button>
							</div> -->
							<form action="board_write_ok.bo?state=dlr_modify" onsubmit="return check()" method="post" enctype="multipart/form-data">
								<%-- <div id="car_choice">
									<img src="resources/upload/no_image.jpg" id="car_image" style="width:150px;"> 
									<div id="car_con">
										<ul>
											<li><div class="label">차량 번호</div><input type="text" id="car_no" name="car_no"  value="${board.car_no}" readonly></li>
											<li><div class="label">클래스</div><input type="text" id="car_class" name="car_class" readonly></li>
											<li><div class="label">모델</div><input type="text" id="car_model" name="car_model" readonly></li>
											<li><input type="button" id="car_detail_btn" value="차량 상세보기" onclick="detail_car()"></li>
										</ul>
									</div>
								</div> --%>
								<input type="hidden" name="board_num" value="${board.board_num}">
								<input type="hidden" name="car_no" value="${board.car_no}" id="car_no">
								<table class="board_t">
									<tbody id="board_write">
										<tr>
											<td colspan="2">
												<div class="label float">작성자</div>
												<div class="float">
													${board.board_name}
													<input type="hidden" id="board_name" name="board_name" class="input-1" value="${board.board_name}" required>
													<input type="hidden" id="board_pass" name="board_pass" class="input-1" value="${board.board_pass}" required>
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<div class="label float">제목</div>
												<div class="float">
													${board.board_subject}
													<input id="subject" type="hidden" name="board_subject" class="input-2" value="${board.board_subject}" required>
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<div><textarea name="board_content" id="change_content" style="width:100%; height:420px;">${board.board_content}</textarea></div>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<div style="text-align: left; font-size: 10pt; margin-bottom: 10px;">
													<span id="file_text">- 파일은 이미지 파일 (jpg,jpeg,gif,png)만 첨부 가능합니다.</span>
												</div>
												<div class="label float">파일첨부</div>
												<div class="float">
													<label for="upfile"><img src="resources/images/file.png" alt="파일열기"></label> 
													<input type='file' id='upfile' name='uploadfile' style="display: none;">
													<span id="filevalue">${board.board_original}</span>&nbsp;
													
													<%-- 파일을 변경하면  type="file"에 값이 저장되지만 변경하지 않으면 값이 저장되지 않습니다. --%>
													<input type="hidden" name="board_original" value="${board.board_original}" id="DBoriginal">
											 		<span id="close"><img src="resources/images/cancel.png"></span><br>
												</div>
											</td>
										</tr>
									</tbody>
								</table> <!-- board_t 끝 -->
								
								<div id="btn_box">
									<input type="submit" value="수정하기">
									<input type="reset" value="뒤로가기" onclick="history.back();">
								</div>
								</form>
						</ul>
					</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>