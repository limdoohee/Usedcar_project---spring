<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_car_detail.css" rel="stylesheet" type="text/css">
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
						<span>${dealer_name }님 관리페이지</span>
					</div>
					<div id="manage_list">
						<ul class="list_category">
							<h3>차량 관리</h3>
							<div id="car_edit_delete_area">
								<a href="dealer_car_delete.dlr?car_no=${list.car_no}&page=${page}" onclick = "return check()"><button>삭제</button></a>
							</div>
							<table>
								<tr>
									<td rowspan="5">차량사진</td>
									<td rowspan="5"><img src="./resources/upload/car/${list.car_image}"></td>
									<td>차량번호</td>
									<td>${list.car_no }</td>
								</tr>
								<tr>
									<td>클래스</td>
									<td>${list.car_class }</td>
								</tr>
								<tr>
									<td>모델</td>
									<td>${list.car_model }</td>
								</tr>
								<tr>
									<td>점수</td>
									<td>${list.car_score }</td>
								</tr>
								<tr>
									<td>가격</td>
									<td>${list.car_price}</td>
								</tr>
								<tr>
									<td>엔진</td>
									<td>${list.car_engine}</td>
									<td>사고여부</td>
									<td>${list.car_accident}</td>
								</tr>
									<td>연식</td>
									<td>${list.car_old}</td>
									<td>주행거리</td>
									<td>${list.car_distance}</td>
								<tr>
									<td>주행조건</td>
									<td>${list.car_condition}</td>
									<td>소모품 교체</td>
									<td>${list.car_change}</td>
								</tr>
								<tr>
									<td>결함 여부</td>
									<td>${list.car_fault}</td>
									<td>연료</td>
									<td>${list.car_fuel}</td>
								</tr>
								<tr>
									<td>색상</td>
									<td>${list.car_color}</td>
									<td>옵션</td>
									<td>${list.car_option}</td>
								</tr>
							</table>
						</ul>
					</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>
