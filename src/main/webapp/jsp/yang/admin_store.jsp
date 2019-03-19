<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link href="./resources/css/common.css" rel="stylesheet" type="text/css">
<link href="./resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<script src = "./resources/js/jquery-3.3.1.js"></script>
<script>
	
	function check(){
		
		var result = confirm('삭제하시겠습니까');
		if (result == true){
			alert('삭제되었습니다.');
		}
		else{
			alert('삭제가 취소되었습니다.');
			return false;
		}
		
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
						<li><a href="admin_dealer_main"><div class="page_name">관리페이지</div></a></li>
						<li><a href="logout.str"><div class="page_name">로그아웃</div></a></li>
					</ul>
					<div id="dealer_info">
						<span>관리자 페이지</span>
					</div>
					<div id="manage_list">
						<ul class="list_category">
							<h3>전시장 관리</h3>
							<table>
								<thead>
									<tr>
										<th>번호</th>
										<th>이름</th>
										<th id="store_address">주소</th>
										<th>전화번호</th>
										<th><input type = "hidden" value = "수정"><input type = "hidden" value = "삭제"></th>
									</tr>
								</thead>
								<tbody>
									<!-- 화면 출력 번호  변수 정의 -->		
									<c:set var="num" value="${listcount-(page-1)*7}"/>
									<c:forEach var = "s" items = "${storelist }">
										<tr>
											<td>${s.store_no }</td>
											<td>${s.store_name }</td>
											<td>${s.store_location }</td>
											<td>${s.store_tel }</td>
											<td>
												<a href = "admin_store_edit.str?num=${s.store_no }&page=${page}"><button>수정</button></a>
												<a href = "admin_store_del.str?num=${s.store_no }&page=${page}" onclick = "return check()"><button>삭제</button></a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- 목록 -->
							<div id="paging_area">
								<c:forEach var="a" begin="${startpage}" end="${endpage}">
									<c:if test="${a == page }">
										<div class="paging_active">${a}</div>
									</c:if>
									<c:if test="${a != page }">
										<div class="paging_number"><a href="admin_store.str?page=${a}">${a}</a></div>
									</c:if>
								</c:forEach>
							</div>
							<a href = "admin_store_reg.str" id = "reg"><button class="button button1">등록</button></a>
						</ul>
					</div>
						<%-- 페이징 처리 --%>
						<%-- <div id = "paging">			
							<ul id = "page_ul">
							<c:if test="${page <=1 }">
								<li>◀</li>
							</c:if>
							
							<c:if test="${page > 1 }">
								<li><a href="admin_store.str?page=${page-1}">◀</a></li>
							</c:if>			
				
							<c:forEach var="a" begin="${startpage}" end="${endpage}">
								<c:if test="${a == page }">
									<li>${a}</li>
								</c:if>
								<c:if test="${a != page }">
									<li><a href="admin_store.str?page=${a}">${a}</a></li>
								</c:if>
							</c:forEach>			
							
							<c:if test="${page >= maxpage }">
								<li>▶</li> 
							</c:if>
							<c:if test="${page < maxpage }">
								<li><a href="admin_store.str?page=${page+1}">▶ </a></li>
							</c:if>
							</ul>			
						</div> --%>
						<%-- 페이징 처리 끝 --%>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>
