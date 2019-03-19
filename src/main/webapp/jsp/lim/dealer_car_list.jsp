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
		
		var result = confirm('판매완료 처리하시겠습니까');
		if (result == true){
			alert('판매완료 처리되었습니다.');
		}
		else{
			alert('처리가 취소되었습니다.');
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
						<span>${dealer_name }님 관리페이지</span>
					</div>
					<div id="manage_list">
						<ul class="list_category">
							<h3>차량 관리</h3>
							<div id="table_wrap">
								<table>
									<thead>
									<tr>	
										<th>번호</th>
										<th>차량번호</th>
										<th>클래스</th>
										<th>모델 </th>
										<th>연식</th>
										<th>가격</th>
										<th></th>
									</tr>
									</thead>
									<tbody>
										<!-- 화면 출력 번호  변수 정의 -->		
										<c:set var="num" value="${listcount-(page-1)*7}"/> 				
										<c:forEach var="list" items="${list }">
											<tr>
												<td><c:out value="${num}"/><c:set var="num" value="${num-1}"/>	</td>
												<td>${list.car_no }</td>
												<td>${list.car_class }</td>
												<td>${list.car_model }</td>
												<td>${list.car_old }</td>
												<td>${list.car_price }</td>
												<td>
													<a href="dealer_car_detail.dlr?car_no=${list.car_no}&page=${page}"><button>상세보기</button></a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- 목록 -->
							<div id="paging_area">
								<c:forEach var="a" begin="${startpage}" end="${endpage}">
									<c:if test="${a == page }">
										<div class="paging_active">${a}</div>
									</c:if>
									<c:if test="${a != page }">
										<div class="paging_number"><a href="dealer_car_manage.dlr?page=${a}">${a}</a></div>
									</c:if>
								</c:forEach>
							</div>
						</ul>
					</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>
