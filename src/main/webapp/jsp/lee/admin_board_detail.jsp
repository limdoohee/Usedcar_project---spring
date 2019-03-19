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

<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>
#board_cont label {
	float: left;
}
.board_t {
	text-align: left;
}
.board_t label{
	text-lign: left;
	width:100%;
}
.temp {
	width:50%;
}
#car_choice {
	float:left;
}
#car_image, #car_con {
	float:left;
}
#car_con div {
	width:100px;
	float: left;
	margin-left: 50px;
}
</style>
<script>
	$(function() {
		$('#del_btn').click(function() {
			var pass="admin";
			var num = $('#num').val();
			var page = $('#page').val();
			var state = "admin_delete";
			
			var result = confirm("게시글을 삭제하시겠습니까?");
			if(result) {
				window.location.href="board_delete_ok.bo?pwd="+pass+"&num="+num+"&page="+page+"&state="+state;
			}
		});
	});
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
					<span>관리자 페이지</span>
				</div>
				<div id="manage_list">
					<ul class="list_category">
						<div>
						<input type="hidden" id="num" value="${board.board_num}">
						<input type="hidden" id="page" value="${page}">
								<table class="board_t">
									<tr>
										<th colspan="4">${board.board_subject}</th>
									</tr>
									<tr>
										<td class="writer">${board.board_name}</td>
										<td class="date"><fmt:formatDate value="${board.board_date}" pattern="yyyy-MM-dd"/></td>
										<td class="read">${board.board_readcount}</td>
										<td class="temp"></td>
									</tr>
									<tr>
										<td class="car" colspan="4">
											<div id="car_choice">
												<img src="resources/upload/car/${car.car_image}" id="car_image" style="width:120px;"> 
												<ul id="car_con">
													<li><div>차량번호</div>${car.car_no}</li>
													<li><div>클래스</div>${car.car_class}</li>
													<li><div>모델</div>${car.car_model}</li>
												</ul>
											</div>
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<c:if test="${board.board_file ne null}">
												<img src="resources/upload${board.board_file}" style="width:50%"><br><br>
											</c:if>
											${board.board_content}
										</td>
									</tr>
								</table>
							</div>
							<!-- 버튼 -->
							<div id="board_btn_area">
								<a href="#"><button id="del_btn">삭제</button></a>
							</div>
						</ul>
					</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>