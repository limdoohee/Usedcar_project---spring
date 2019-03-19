<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<script src = "./resources/js/jquery-3.3.1.js"></script>
<link href="resources/css/dealer_page.css" rel="stylesheet" type="text/css">
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
								<h3>딜러 관리</h3>
							<table>
								<thead>
									<tr>
										<th>번호</th>
										<th>아이디</th>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
										<th>이름</th>
										<th>번호</th>
										<th>이메일</th>
										<th>근무지</th>
										<th><input type = "hidden" value = "수정"><input type = "hidden" value = "삭제"></th>
									</tr>
								</thead>
								<tbody>
									<!-- 화면 출력 번호  변수 정의 -->		
									<c:set var="num" value="${listcount-(page-1)*7}"/> 		
									<c:forEach var = "a" items = "${dealerlist }">
										<tr>
											<td><c:out value="${num}"/><c:set var="num" value="${num-1}"/>	</td>
											<td>${a.dealer_id }</td>
											<td>${a.dealer_name }</td>
											<td>${a.dealer_phone }</td>
											<td>${a.dealer_email }</td>
											<td>${a.store_name }</td>
											<td>
												<a href = "admin_dealer_edit.dlr?id=${a.dealer_id}&page=${page}" class="btn cyan mini"><button>수정</button></a>
												<a href = "admin_dealer_del.dlr?id=${a.dealer_id}&page=${page}" class="btn red mini" onclick = "return check()"><button>삭제</button></a>
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
										<div class="paging_number"><a href="admin_dealer.dlr?page=${a}">${a}</a></div>
									</c:if>
								</c:forEach>
							</div>
							<a href = "admin_dealer_reg.dlr" id = "reg"><button class="button button1">등록</button></a>
						</ul>
					</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>
