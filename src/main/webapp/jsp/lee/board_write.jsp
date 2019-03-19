<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<title>허위매물신고</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/board.css" rel="stylesheet" type="text/css">
<link href="resources/css/board_write.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript" src="resources/js/board_write.js"></script>

<!-- <script src="http://code.jquery.com/jquery-latest.js"></script> -->
<script type="text/javascript">
$(function() {
	$('#close').hide();
})
</script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">

				<div id="board_cont">
				
					<div class="board_header">
						<h2>허위 매물 신고</h2>
						<h4>게시글 작성</h4>
					</div>
					<div>
						─ 신고할 차량을 검색하고 글을 작성해주세요.<button id="findcar_btn" onclick="car_check()">차량 선택</button>
					</div>
					<form id="form1" action="board_write_ok.bo?state=write" onsubmit="return check()" method="post" enctype="multipart/form-data">
					<div id="car_choice">
						<img src="#" id="car_image" style="width:150px;"> 
						<div id="car_con">
							<ul>
								<li><div class="label">차량 번호</div><input type="text" id="car_no" name="car_no" readonly></li>
								<li><div class="label">클래스</div><input type="text" id="car_class" name="car_class" readonly></li>
								<li><div class="label">모델</div><input type="text" id="car_model" name="car_model" readonly></li>
								<li><input type="button" id="car_detail_btn" value="차량 상세보기" onclick="detail_car()"></li>
							</ul>
						</div>
					</div>
					<table class="board_t">
						<tbody id="board_write">
							<tr>
								<td>
									<div class="label float">작성자</div>
									<div class="float"><input type="text" id="board_name" name="board_name" class="input-1" required></div>
								</td>
								<td>
									<div class="label float">비밀번호</div>
									<div class="float"><input type="text" id="board_pass" name="board_pass" class="input-1" required></div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div class="label float">제목</div>
									<div class="float"><input id="subject" type="text" name="board_subject" class="input-2" value="허위매물 신고합니다." readonly></div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div><textarea name="board_content" id="change_content" style="width:100%; height:420px;"></textarea></div>
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
										<span id="filevalue">${board.board_original}</span>&nbsp;
								 		<span id="close"><img src="resources/images/cancel.png"></span>
									</div>
								</td>
							</tr>
						</tbody>
					</table> <!-- board_t 끝 -->
					
					<div id="btn_box">
						<input type="submit" value="등록하기">
						<input type="reset" value="뒤로가기" onclick="history.back();">
					</div>
					</form>
				</div> <!-- board_cont 끝 -->

			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>