<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/board_car_find.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

function load_class() {
	$.ajax({
		type	: 'POST',
		url		: 'car_find_class.bo',
		cache	: false,
		data 	: null,
		success	: function (data) {
			$('#sel_class').empty();
			$('#sel_class').append("<option value=''>class 선택</option>");
			var output = '';
			$(data).each(function(index, item){
				output += "<option value='"+item.car_class+"'>"+item.car_class+"</option>";
			});
			$('#sel_class').append(output);
		}
	});
}

function load_model(class_val) {

	$.ajax({
		type	: 'POST',
		url		: 'car_find_model.bo',
		cache	: false,
		data 	: { "car_class" : class_val},
		success	: function (data) {
			$('#sel_model').empty();
			$('#sel_model').append("<option value=''>model 선택</option>");
			var output = '';
			$(data).each(function(index, item){
				output += "<option value='"+item.car_model+"'>"+item.car_model+"</option>";
			});
			$('#sel_model').append(output);
		}
	});
}

$(function() {

	load_class();
	
	$('#sel_class').on('change', function() {
		var class_val = $('#sel_class').val();
		load_model(class_val);
	});
	
	$('.button2').on('click', function() {
		
		
		var car_no = $(this).closest("tr").find(".car_PK").val();
		var car_img2 = $(this).closest("tr").find(".car_IMG2").val();
		var car_class = $(this).closest("tr").find(".car_CLA").val();
		var car_model = $(this).closest("tr").find(".car_MOD").val();
		
		$(opener.document).find('#car_choice').show();
		$(opener.document).find('#car_no_original').remove();
		$(opener.document).find("#car_no").val(car_no);
		$(opener.document).find("#car_image").attr("src", "resources/upload/car/"+car_img2);
		$(opener.document).find("#car_class").val(car_class);
		$(opener.document).find("#car_model").val(car_model);
		
		window.close();
	});
});
</script>
</head>
<body>
	<div id="content">
		<div id="header">
			<h4>차량 검색</h4>
		</div>
		<div id="search_wrap">
			<form action="car_find_result.bo">
				<div id="input_box">
					<select id="sel_class" name="car_class" class="input">
					</select>
					<select id="sel_model" name="car_model" class="input">
						<option value=''>model 선택</option>
					</select>
					<input type="text" id="car_no" name="car_no" placeholder="차량번호"  class="input">
					<input type="submit" value="검색" class="button">
				</div>
			</form>
		</div>
		<div id="result_keyword">
		<c:if test="${null ne search_class || null ne search_model || null ne search_no}">
			<검색조건><br>
			Class: <strong>${search_class}</strong><br>
			Model: <strong>${search_model}</strong><br>
			차량번호: <strong>${search_no}</strong>
		</c:if>
		</div>
		<div id="result_wrap">
			<table id="result_t">
				<thead>
					<tr>
						<th class="car_img">차량 사진</th>
						<th class="car_no">차량 가격</th>
						<th class="car_content">상세 정보</th>
						<th class="car_btn">선택</th>
					</tr>
				</thead>
				<tbody id="result">
					<c:if test="${empty carlist}">
						<tr>
							<td colspan="4">검색 결과가 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${!empty carlist}">
						<c:forEach var="car" items="${carlist}">
							<tr>
								<td class="car_img">
									<img src="resources/upload/car/${car.car_image}">
									<input type="hidden" value="${car.car_image}" class="car_IMG2">
									
									<input type="hidden" value="${car.car_class}" class="car_CLA">
									<input type="hidden" value="${car.car_model}" class="car_MOD">
								</td>
								<td class="car_no">
									￦${car.car_price}
									<input type="hidden" value="${car.car_no}" class="car_PK">
								</td>
								<td class="car_content">
									<ul>
										<li><div class="car_cont">엔진상태</div>${car.car_engine}</li>
										<li><div class="car_cont">사고유무</div>${car.car_accident}</li>
										<li><div class="car_cont">연식</div>${car.car_old}</li>
										<li><div class="car_cont">주행거리</div>${car.car_distance}</li>
										<li><div class="car_cont">주행조건</div>${car.car_condition}</li>
									</ul>
									<ul>
										<li><div class="car_cont">교체시기</div>${car.car_change}</li>
										<li><div class="car_cont">결함여부</div>${car.car_fault}</li>
										<li><div class="car_cont">연료</div>${car.car_fuel}</li>
										<li><div class="car_cont">색상</div>${car.car_color}</li>
										<li><div class="car_cont">옵션</div>${car.car_option}</li>
									</ul>
								</td>
								<td class="car_btn"><button class="button2">선택</button></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>