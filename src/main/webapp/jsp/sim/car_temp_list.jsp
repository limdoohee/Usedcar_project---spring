<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<script src="./resources/js/jquery-3.3.1.js"></script>
<link href="./resources/css/common.css" rel="stylesheet" type="text/css">
<link href="./resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>견적신청 목록 보기</title>
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
								<table border=1>
									<thead>
									<tr>
										<th>번호</th>
										<th>클래스</th>
										<th>모델</th>
										<th>연식</th>
										<th>주행거리</th>	
										<th>차량번호</th>
										<th>전화번호</th>
										<th></th>
									</tr>
									</thead>
									<!-- 화면 출력 번호  변수 정의 -->		
									<c:set var="num" value="${listcount-(page-1)*7}"/>
								<c:forEach var="list" items="${car_temp_list}">
									<tr>
										<td><c:out value="${num}"/><c:set var="num" value="${num-1}"/>	</td>
										<td>${list.temp_class}</td>
										<td>${list.temp_model}</td>
										<td>${list.temp_year}</td>
										<td>${list.temp_distance}km</td>
										<td style="display:none">${list.temp_accident}</td>
										<td>${list.temp_car_no}</td>
										<td style="display:none">${list.temp_name}</td>
										<td style="display:none">${list.temp_location}</td>
										<td>${list.temp_phone}</td>
										<td>
											<a href="car_insert.car?temp_car_no=${list.temp_car_no}"><button>추가입력</button></a>
										</td>
							<%-- 	
										<td style="display:none">
										${confirm.dealer_id}
										</td>
										 --%>
									</tr>
								</c:forEach>
							</table>
						</div>
						<!-- 목록 -->
						<div id="paging_area">
							<c:forEach var="a" begin="${startpage}" end="${endpage}">
								<c:if test="${a == page }">
									<div class="paging_active">${a}</div>
								</c:if>
								<c:if test="${a != page }">
									<div class="paging_number"><a href="">${a}</a></div>
								</c:if>
							</c:forEach>
						</div>
					</ul>
				</div>
			</div>
		</div>
	</div>
 </div>
</body>
</html>