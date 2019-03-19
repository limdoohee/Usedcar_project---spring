<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<title>실구매계산기</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/car_list.css" rel="stylesheet" type="text/css">

<!-- <script src="http://code.jquery.com/jquery-latest.js"></script> -->
<!-- <link rel="stylesheet" href="resources/css/dist/jquery.digitScroller.css">
<script src="resources/js/dist/jquery.digitScroller.js"></script> -->
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js"></script> -->
<script src="resources/js/car_list.js"></script>
<script src="resources/js/car_list_ajax.js"></script>
<script src="resources/js/car_calculator.js"></script>
<style type="text/css">
#result5 {
	color: black;
	font-size: 15pt;
	border-bottom: 3px solid #FF3555;
}
#search_type1, #search_type2 {
	background-color: white;
	font-size: 9pt;
}
#search_type1 a:link {
	color: gray;
}
#search_type1 a:hover {
	color: black;
	border-bottom: 2px solid #FF3555;
}
.search1_select {
	color: black;
	border-bottom: 2px solid #FF3555;
}
</style>
</head>
<c:forEach var="clist" items="${carlist}">
	<!-- <div id="car_list" style="background-color: #F7F7F7;"> -->
		<div class="car" onclick="select(this)">
		<input type="hidden" class="carPK" value="${item.car_no}">
			<div class="c_img"><img src="resources/upload/car/${item.car_image}"></div>
			<div class="c_cont">
			<div class="c_model"><strong>${clist.car_model}</strong> │ ${clist.car_class}</div>
			<div class="c_price">￦${clist.car_price}</div>
			<div class="hr"><hr></div>
			<div class="c_fuel">${clist.car_fuel}</div>
			<div class="c_year">${clist.car_old}</div>
			<div class="c_dist">${clist.car_distance} km</div>
			<div class="c_falut">${clist.car_fault}</div>
			</div>
		</div>
	<!-- </div> -->
</c:forEach>
</body>
</html>