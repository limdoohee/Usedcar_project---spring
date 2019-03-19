<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<title>허위매물신고 - 글쓰기</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/board.css" rel="stylesheet" type="text/css">

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
</style>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">

				<div id="board_cont">
				
					<div class="board_header">
						<h2>허위 매물 신고</h2>
						<h4>답글 작성</h4>
					</div>
					
					<form action="board_write_ok.bo?state=reply" onsubmit="return check()" method="post" enctype="multipart/form-data">
						<input type="hidden" name="board_num" value="${board.board_num}">
						<input type="hidden" name="board_re_ref" value="${board.board_re_ref}">
						<input type="hidden" name="board_re_lev" value="${board.board_re_lev}">
						<input type="hidden" name="board_re_seq" value="${board.board_re_seq}">
						<input type="hidden" name="car_no" value="${car.car_no}">
						<input type="hidden" name="dealer_id" value="${id}">
						<table class="board_t">
							<tbody id="board_write">
								<tr>
									<td>
										<label>
											<span class="label">제목</span>
											<div><input type="text" name="board_subject" class="input-2" required></div>
									</label>
									</td>
								</tr>
								<tr>
									<td>
										<label>
											<span class="label">내용</span>
											<div><textarea name="board_content" rows="" cols=""></textarea></div>
									</label>
									</td>
								</tr>
								<tr>
									<td>
										<label>
											<span class="label">파일첨부</span>
											<div><input type="file" name="uploadfile"></div>
									</label>
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