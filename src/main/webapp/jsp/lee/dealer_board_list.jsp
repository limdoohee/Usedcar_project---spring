<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html>
<html>
<head>
<title>허위매물 게시글 관리</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_page.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">
					<!-- Login -->
					<ul id="login_menu">
						<li><a href="main"><div class="page_name">홈</div></a></li>
						<li><a href="admin_dealer_main"><div class="page_name">관리페이지</div></a></li>
						<li><a href="logout.str"><div class="page_name">로그아웃</div></a></li>
					</ul>
					<div id="dealer_info">
						<span>${dealer_name }님 관리페이지</span>
					</div>
					<div id="manage_list">
						<ul class="list_category">
							<h3>허위매물신고</h3>
							<div id="table_wrap">
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
										<c:set var="num" value="${listcount-(page-1)*10}"/>
										
										<!-- 게시판 리스트 출력 c:forEach-->
										<c:forEach var="b" items="${board}">
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
													<!-- 답글인 경우 -->
													<c:if test="${b.board_re_lev != 0}">
														<c:forEach begin="1" end="${b.board_re_lev}">
															&nbsp;&nbsp;&nbsp;&nbsp;
														</c:forEach>
														<img src="resources/images/reply.png">
													</c:if>
													<!-- 제목 -->
													<a href="board_detail.bo?num=${b.board_num}&page=${page}&state=dlr_cont">${b.board_subject}</a>
												</td>
												<td class="writer">${b.board_name}</td>
												<td class="date">
													<fmt:formatDate value="${b.board_date}" pattern="yyyy-MM-dd"/>
												</td>
												<td class="read">${b.board_readcount}</td>
											</tr>
										</c:forEach> <!-- 게시판 리스트 출력 c:forEach 끝-->
									</tbody>
								</table> <!-- board_t 끝 -->
							</div>
							<div id="paging_area">
								<c:if test="${page > 1}">
									<div><a href="board_list.deal?page=${page-1}">◀</a></div>
								</c:if>
								<c:forEach var="a" begin="${startpage}" end="${endpage}">
									<c:if test="${a == page}">
										<div class="paging_active">${a}</div>
									</c:if>
									<c:if test="${a != page}">
										<div class="paging_number"><a href="board_list.deal?page=${a}">${a}</a></div>
									</c:if>
								</c:forEach>
								<c:if test="${page < maxpage}">
									<div><a href="board_list.deal?page=${page+1}">▶</a></div>
								</c:if>
							</div> <!-- paging_area 끝 -->
						</ul>
					</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>
