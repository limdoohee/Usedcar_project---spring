<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="./resources/css/common.css" rel="stylesheet" type="text/css">
<link href="./resources/css/search_detail.css" rel="stylesheet" type="text/css">
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
				<div class="detail_wrap">
					<div class="car_image"> <img src="./resources/upload/car/${list.car_image}"></div>
					<div class="cardetail_info">
						<div><span class="car_class">${list.car_class}</span><span class="car_model">${list.car_model}</span></div>
						<hr>
						<div class="option_area">
							<div class="option">엔진 <span>${list.car_engine}</span></div>
							<div class="option">사고여부 <span>${list.car_accident}</span></div>
							<div class="option">연식 <span>${list.car_old}</span></div>
							<div class="option">주행거리<span>${list.car_distance}</span></div>
							<div class="option">주행조건 <span>${list.car_condition}</span></div>
							<div class="option">교체시기 <span>${list.car_change}</span></div>
							<div class="option">결함 <span>${list.car_fault}</span></div>
							<div class="option">연료 <span>${list.car_fuel}</span></div>
							<div class="option">옵션 <span>${list.car_option}</span></div>
						</div>
						<hr>
						<div class="dealer_info">
							<div class="info_box">딜러 정보</div>
							<div class="dealer_descrition name">${dealer.dealer_name}</div>
							<span></span>
							<div class="dealer_descrition phone">${dealer.dealer_phone}</div>
							<span></span>
							<div class="dealer_descrition email">${dealer.dealer_email}</div>
						</div>
						<hr>
						<div class="detail_price">${list.car_price }</div>
					</div>
				</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>