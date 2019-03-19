<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="./resources/js/search.js"></script>
<script src="./resources/js/select.js"></script>
<link href="./resources/css/search.css" rel="stylesheet" type="text/css">
</head>
<body onload="searchload()">
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">
				<h2 id="car_search_title">차량 검색</h2>
				<h3 id="car_search_title_expl">원하는 조건이 있다면 클래스 선택 후 조건검색 / 전체차량을 보고싶다면 전체검색을 선택해주세요</h3>
				<form method="post"  action="search.list" id="research_wrap" name="condition_research_wrap" > 
					<ul class="SearchList1">
						<li class="search" id="car_class">
							<select id="select_car_class" name="car_class">
								<option value="hide">클래스 선택</option>
								<!-- car_class -->
							</select>
						</li>
						<li class="search" id="car_model">
							<select id="select_car_model" name="car_model">
								<option value="hide">모델 선택</option>
								<!-- car_model -->
							</select>
						</li>
						<li class="search car_engine">
							<select class="option_layer engine" name="car_engine">
								<option value="hide">엔진</option>
								<option value="이상없음">이상없음</option>
								<option value="점검필요">점검필요</option>
							</select>
						</li>
						<li class="search car_accident">
							<select class="option_layer accident" name="car_accident">
								<option value="hide">사고여부</option>
								<option>무사고</option>
								<option>유사고</option>
							</select>
						</li>
						<li class="search car_old">
							<select class="option_layer old" name="car_old">
								<option value="hide">연식</option>
								<option>출고 - 3년</option>
								<option>3년 - 5년</option>
								<option>6년 - </option>
							</select>
						</li>
						<li class="search car_distance">
							<select class="option_layer distance" name="car_distance">
								<option value="hide">주행거리</option>
								<option>0 - 30,000</option>
								<option>30,000 - 50,000</option>
								<option>50,000 - 80,000</option>
								<option>100,000 -</option>
							</select>
						</li>
					</ul>
					<ul class="SearchList2">
						<li class="search car_condition">
							<select class="option_layer condition" name="car_condition">
								<option value="hide">주행조건</option>
								<option>도로</option>
								<option>시내</option>
								<option>산악</option>
							</select>
						</li>
						<li class="search car_change">
							<select class="option_layer change" name="car_change">
								<option value="hide">소모품 교체</option>
								<option>교체 완료</option>
								<option>교체 미완료</option>
							</select>
						</li>
						<li class="search car_fault">
							<select class="option_layer fault" name="car_fault">
								<option value="hide">결함 여부</option>
								<option>결함 없음</option>
								<option>결함 있음</option>
							</select>
						</li>
						<li class="search car_fuel">
							<select class="option_layer fuel" name="car_fuel">
								<option value="hide">연료</option>
								<option>휘발유</option>
								<option>경유</option>
								<option>하이브리드</option>
							</select>
						</li>
						<li class="search car_color">
							<select class="option_layer color" name="car_color">
								<option value="hide">색상</option>
								<option>인기 색상</option>
								<option>이외</option>
							</select>
						</li>
						<li class="search car_option">
							<select class="option_layer option" name="car_option">
								<option value="hide">옵션</option>
								<option>있음</option>
								<option>없음</option>
							</select>
						</li>
					</ul>
					<div id="btn_area">
						<input type="submit" class="search_list" value="조 건 검 색">
						<input type="button" class="search_All_list" value="전 체 목 록" onclick="location='search.alllist'">
					</div>
				</form>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>