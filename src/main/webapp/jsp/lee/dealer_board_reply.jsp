<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<head>
<title>허위매물신고</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<!-- <link href="resources/css/board.css" rel="stylesheet" type="text/css"> -->
<link href="resources/css/board_write.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_board.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript" src="resources/js/board_reply.js"></script>

<script src="http://code.jquery.com/jquery-latest.js"></script>

<style>
#board_cont label {
	float: left;
}
.board_t tbody div {
	text-align: center;
}
.board_t label{
	text-lign: left;
	width:100%;
}
.board_t {
	width:100%;
	text-align:center;
	font-weight: 300;
	border-spacing: 0;
	margin-top: 0;
}
#change_content {
	height: 300px;
}
</style>
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
							<div id="board_cont">
							
								<div class="board_header">
									<h4>답변 작성</h4>
								</div>
								
								<div>
								<form action="board_write_ok.bo?state=reply" onsubmit="return check()" method="post" enctype="multipart/form-data">
									<input type="hidden" name="board_num" value="${board.board_num}">
									<input type="hidden" name="board_re_ref" value="${board.board_re_ref}">
									<input type="hidden" name="board_re_lev" value="${board.board_re_lev}">
									<input type="hidden" name="board_re_seq" value="${board.board_re_seq}">
									<input type="hidden" name="car_no" id="car_no" value="${car.car_no}">
									<input type="hidden" name="dealer_id" value="${id}">
									<table class="board_t">
										<tbody id="board_write">
											<tr>
												<td colspan="2">
													<div class="label float">제목</div>
													<div class="float">답변드립니다.
														<input id="subject" type="hidden" name="board_subject" class="input-2" value="답변드립니다." readonly>
													</div>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<div><textarea name="board_content" id="change_content" style="width:100%; height:300px; background-color: white;"></textarea></div>
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
														<input type='file' id='upfile' name='uploadfile'>
														<span id="filevalue"></span>&nbsp;
												 		<span id="close"><img src="resources/images/cancel.png"></span>
													</div>
												</td>
											</tr>
										</tbody>
									</table> <!-- board_t 끝 -->
									
									<div id="board_btn_area" style="margin-top:50px;">
										<input type="submit" value="등록하기">
										<input type="reset" value="뒤로가기" onclick="history.back();">
									</div>
								</form>
								</div>
							</div> <!-- board_cont 끝 -->

						</ul>
					</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>