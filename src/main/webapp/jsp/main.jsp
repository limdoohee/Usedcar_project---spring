<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>메인페이지</title>
	<!--FullPage�� CSS-->
	<link rel="stylesheet" type="text/css" href="./resources/css/vendor/jquery.fullPage.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css/main_fullpage.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css/common.css" />
	<!--�ʼ� JS-->
	<script src="./resources/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="./resources/js/vendor/jquery-ui.min.js"></script>
	<script src="./resources/js/jquery-3.3.1.js"></script>
	<!--FullPage JS-->
	<script src="./resources/js/vendor/jquery.fullPage.js"></script>
	<script src="./resources/js/fullpage_button.js"></script>
<script>
$(function(){
/* 	$(".page_name").hide();
	$(".page_button").hover(function(){
		$(this).find(".page_name").show();
	}, function(){
		$(this).find(".page_name").hide();
	}) */
})
</script>
</head>
<body oncontextmenu="return false" onselectstart="return false" ondragstart="return false">
<!-- Menu Button -->
<ul id="menu">
	<li data-menuanchor="firstPage" class="active"><a href="#1" class="page_button"><div class="page_name">차량 검색</div></a></li>
	<li data-menuanchor="secondPage"><a href="#2" class="page_button"><div class="page_name">견적 신청</div></a></li>
	<li data-menuanchor="3rdPage"><a href="#3" class="page_button"><div class="page_name">전시장 안내</div></a></li>
	<li data-menuanchor="4thpage"><a href="#4" class="page_button"><div class="page_name">월납입금 계산기</div></a></li>
	<li data-menuanchor="5thpage"><a href="#5" class="page_button"><div class="page_name">시승신청</div></a></li>
	<li data-menuanchor="lastPage"><a href="#6" class="page_button"><div class="page_name">허위매물 신고</div></a></li>
</ul>

<!--Content-->
<div id="fullpage"> 
	<!-- 1Page-->
	<div class="section " id="section1"><c:import url="/search" /></div>
 	<!-- 2Page-->
	<div class="section" id="section2"><c:import url = "/register.car"/></div>
	<!-- 3Page-->
	<div class="section" id="section3"><c:import url = "/store_show.str"/></div>
	<!-- 4Page-->
	<div class="section" id="section4"><c:import url="/cal_list_load.cal"/></div>
	<!-- 5Page-->
	<div class="section" id="section5"><c:import url = "/drive.drv"/></div>
	<!-- 6Page-->
	<div class="section" id="section6"><c:import url="/board_list.bo"/></div>
</div>

	<!-- Login -->
<ul id="login_menu">

	<li><a href="main"><div class="page_name">홈</div></a></li>
		<c:choose>
			<c:when test="${empty dealer_id}">
				<li>
					<a href="login.str"><div class="page_name">로그인</div></a>
				</li>
			</c:when>
			<c:when test="${!empty dealer_id }">
				<li><a href="admin_dealer_main"><div class="page_name">관리페이지</div></a></li>
				<li><a href="logout.str"><div class="page_name">로그아웃</div></a></li>
			</c:when>
		</c:choose>
</ul>
</body>
</html>