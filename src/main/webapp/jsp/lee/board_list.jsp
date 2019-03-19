<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<title>허위매물신고</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/board.css" rel="stylesheet" type="text/css">
<link href="resources/css/board_list.css" rel="stylesheet" type="text/css">

<!-- <script src="http://code.jquery.com/jquery-latest.js"></script> -->
<script src="resources/js/board_list.js"></script>
<script src="resources/js/board_list_ajax.js"></script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">
			<input type="hidden" value="1" id="board_page_vlaue">
				<div id="board_cont">
					<div class="board_header">
						<h2>허위 매물 신고</h2>
						<h4>허위 매물 신고 게시판 입니다.</h4>
					</div>
					<div>
						<div id="board_search">
							<select id="search_option" name="search_option">
								<option value="">-선택-</option>
								<option value="board_name">작성자</option>
								<option value="board_subject">제목</option>
								<option value="board_content">내용</option>
							</select>
							<input type="text" id="search_keyword" name="search_keyword">
							<input type="button" id="search_btn" value="검색">
							<button onclick="location='./board_write.bo';">글쓰기</button>
						</div> <!-- board_search 끝 -->
					</div>
					
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
							<c:set var="num" value="${listcount-(page-1)*6}"/>
							
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
										<input type="hidden" class="boardPK" value="${b.board_num}">
										<a href="board_detail.bo?num=${b.board_num}&page=${page}&state=cont" class="board_detail">${b.board_subject}</a>
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
					
					<div id="board_page">
						<ul>
						<c:if test="${page > 1}">
							<li><a href="javascript:void(0)" class="board_page_before"><img src="resources/images/page-back.png"></a><li>
						</c:if>
						<c:forEach var="a" begin="${startpage}" end="${endpage}">
							<c:if test="${a == page}">
								<li>${a}<li>
							</c:if>
							<c:if test="${a != page}">
								<li><a href="javascript:void(0)" class="board_page_on">${a}</a><li>
							</c:if>
						</c:forEach>
						<c:if test="${page < maxpage}">
							<li><a href="javascript:void(0)" class="board_page_after"><img src="resources/images/page-front.png"></a><li>
						</c:if>
						</ul>
					</div> <!-- board_page 끝 -->
				</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>