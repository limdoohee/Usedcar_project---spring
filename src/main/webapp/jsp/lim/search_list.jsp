<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>차량 검색 리스트</title>
<link href="./resources/css/common.css" rel="stylesheet" type="text/css">
<link href="./resources/css/search_list.css" rel="stylesheet" type="text/css">
<script src="./resources/js/vendor/jquery-1.12.4.min.js"></script>
<script src="./resources/js/vendor/jquery-ui.min.js"></script>
<script src="./resources/js/jquery-3.3.1.js"></script>
<script src="./resources/js/search.js"></script>
</head>
<body oncontextmenu="return false" onselectstart="return false" ondragstart="return false">
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">
				<div id="list_wrap">
				<p>검색 결과 : ${listsize }</p>
				<c:forEach var="list" items="${list }">
					<!-- 이벤트가 없을 때 -->
					<c:if test="${ empty list }">
						이벤트가 없습니다.
					</c:if>
					<c:if test="${ !empty list }">
						<div class="search_list">
						<a href="SearchCarDetail.list?car_no=${ list.car_no }">
						
						<div class="car_image"> <img src="./resources/upload/car/${list.car_image}"></div>
						<div class="cardetail_info">
							<div class="grade">${list.grade }</div>
							<div class="price">${list.car_price }</div>
							<hr>
							<div class="option">클래스 <span>${list.car_class}</span></div>
							<div class="option">모델 <span>${list.car_model}</span></div>
							<hr>
							<div class="option">엔진 <span>${list.car_engine}</span></div>
							<div class="option">사고여부 <span>${list.car_accident}</span></div>
							<div class="option">연식 <span>${list.car_old}</span></div>
							<div class="option">주행거리<span>${list.car_distance} km</span></div>
							<div class="option">주행조건 <span>${list.car_condition}</span></div>
							<div class="option">교체시기 <span>${list.car_change}</span></div>
							<div class="option">결함 <span>${list.car_fault}</span></div>
							<div class="option">연료 <span>${list.car_fuel}</span></div>
							<div class="option">옵션 <span>${list.car_option}</span></div>
							
							<input type="hidden" name="car_no" value="${list.car_no }">
							<input type="hidden" name="dealer_id" value="${list.dealer_id }">
							
						</div> <!-- cardetail_info -->
						</a>
						</div><!-- search_list -->
					</c:if>
				</c:forEach>
				<div id="view_more"><button id="load">VIEW MORE</button></div>
				</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>