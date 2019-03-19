<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<head>
<title>허위매물신고</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/board.css" rel="stylesheet" type="text/css">

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
			window.open('board_detail.bo?num=${board.board_num}&page=${page}&state=del','게시글 삭제','width=590,height=280,scrollbars=no');
		});
	});
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
						<h4>게시물 보기</h4>
					</div>
					
					<!-- 게시글 내용 -->
					<table class="board_t">
						<tr>
							<th colspan="4">${board.board_subject}</th>
						</tr>
						<tr>
							<td class="writer"><img src="resources/images/board_user.png" width="15px">${board.board_name}</td>
							<td class="date"><img src="resources/images/board_date.png" width="15px"><fmt:formatDate value="${board.board_date}" pattern="yyyy-MM-dd"/></td>
							<td class="read"><img src="resources/images/board_view.png" width="15px">${board.board_readcount}</td>
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
					<br>
					<div style="width:100%">
						<div id="btn_box">
							<input type="button" class="button" value="MODIFY" onclick="location='board_detail.bo?num=${board.board_num}&page=${page}&state=modify'">
							<input type="button" class="button" value="DELETE" id="del_btn">
							<input type="button" class="button" value="LIST" onclick="location='main#lastPage'">
						</div>
					</div>
			
			
					<!-- 게시글에 등록된 답변 게시글 list -->
					<table class="board_t">
						<thead>
							<tr>
								<th class="num">번호</th>
								<th class="subject">분류</th>
								<th class="title">제목</th>
								<th class="writer">작성자</th>
								<th class="date">등록일</th>
								<th class="read">조회수</th>
							</tr>
						</thead>
						<tbody id="board_list">
							<!-- 화면 출력 번호 변수 정의 -->
							<c:set var="num" value="${fn:length(relist)}" />
							<c:forEach var="b" items="${relist}">
								<tr>
									<td class="num">
										<c:out value="${num}" /><c:set var="num" value="${num-1}" />
									</td>
									<td class="subject">
										<c:if test="${b.board_re_lev == 0}">
											[질문]
										</c:if>
										<c:if test="${b.board_re_lev != 0}">
											[답변]
										</c:if>
									</td>
									<td class="title">
										<!-- 현재게시글인 경우 -->
										<c:if test="${b.board_num == board.board_num}">
											[현재글]
										</c:if>
										<!-- 답글인 경우 -->
										<c:if test="${b.board_re_lev != 0}">
											<c:forEach begin="1" end="${b.board_re_lev}">
												&nbsp;&nbsp;&nbsp;&nbsp;
											</c:forEach>
											<img src="resources/images/reply.png">
										</c:if>
										<!-- 제목 -->
										<a href="board_detail.bo?num=${b.board_num}&page=${page}&state=cont">${b.board_subject}</a>
									</td>
									<td class="writer">${b.board_name}</td>
									<td class="date">
										<fmt:formatDate value="${b.board_date}" pattern="yyyy-MM-dd"/>
									</td>
									<td class="read">${b.board_readcount}</td>
								</tr>
							</c:forEach> <!-- 게시판 리스트 출력 c:forEach 끝-->
						</tbody>
					</table>
					
				</div> <!-- board_cont 끝 -->
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>