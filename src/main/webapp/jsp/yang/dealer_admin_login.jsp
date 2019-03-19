<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
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
						<c:choose>
							<c:when test = "${dealer_id == 'admin'}">
								<span>관리자 페이지</span>
							</c:when>
							<c:otherwise>
								<span>${dealer_name }님 관리페이지</span>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="manage_list">
					<c:choose>
						<c:when test = "${dealer_id == 'admin'}">
							<ul class="list_category">
								<li><a href = "admin_store.str">전시장 관리</a></li>
								<li><a href = "admin_dealer.dlr">딜러 관리</a></li>
								<li><a href = "admin_board.bo">허위매물신고 관리</a></li>
							</ul>
						</c:when>
						<c:otherwise>
							<ul class="list_category">
								<li><a href = "dealer_car_manage.dlr">등록차량 관리</a></li>
								<li><a href = "car_temp_list?dealer_id=${dealer_id}">견적신청 관리</a></li>
								<li><a href = "dealer_drive_manage.drv">시승신청 관리</a></li>
								<li><a href = "board_list.deal">허위매물신고 관리</a></li>
							</ul>
						</c:otherwise>
					</c:choose>
					</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>
