<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/admin_board_list_ajax.js"></script>
<script type="text/javascript">
$(function() {
	$('#subject').val('${type}');
});
</script>
<table id="board_t" class="board_t">
	<thead>
		<tr>
			<th class="num">게시글 번호</th>
			<th class="subject">
				<select name="subject" id="subject">
					<option value="all">분류</option>
					<option value="q">질문</option>
					<option value="a">답변</option>
				</select>
			</th>
			<th class="car">신고차량</th>
			<th class="title">제목</th>
			<th class="writer">작성자</th>
			<th class="date">등록일</th>
			<th></th>
		</tr>
	</thead>
	<tbody id="board_list">
		<!-- 화면 출력 번호 변수 정의 -->
	<c:set var="num" value="${listcount-(page-1)*10}"/>
	
	<!-- 게시판 리스트 출력 c:forEach-->
	<c:forEach var="b" items="${board}">
		<tr>
			<td class="num">
				${b.board_num}
			</td>
			<td class="subject">
				<c:if test="${b.board_re_lev == 0}">
					[질문]
				</c:if>
				<c:if test="${b.board_re_lev != 0}">
					[답변]
				</c:if>
			</td>
			<td class="car">${b.car_no}</td>
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
				${b.board_subject}
			</td>
			<td class="writer">${b.board_name}</td>
			<td class="date">
				<fmt:formatDate value="${b.board_date}" pattern="yyyy-MM-dd"/>
			</td>
			<td>
				<a href="board_detail.bo?num=${b.board_num}&page=${page}&state=admin_cont"><button>상세보기</button></a>
			</td>
		</tr>
	</c:forEach> <!-- 게시판 리스트 출력 c:forEach 끝-->
	</tbody>
</table>
<div id="paging_area">
	<c:if test="${page > 1}">
		<div><a href="admin_board.bo?page=${page-1}">◀</a></div>
	</c:if>
	<c:forEach var="a" begin="${startpage}" end="${endpage}">
		<c:if test="${a == page}">
			<div class="paging_active">${a}</div>
		</c:if>
		<c:if test="${a != page}">
			<div class="paging_number"><a href="admin_board.bo?page=${a}">${a}</a></div>
		</c:if>
	</c:forEach>
	<c:if test="${page < maxpage}">
		<div><a href="admin_board.bo?page=${page+1}">▶</a></div>
	</c:if>
</div> <!-- paging_area 끝 -->