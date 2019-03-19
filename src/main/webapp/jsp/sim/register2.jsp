<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<script src="./resources/js/register2.js"></script>
<link href="./resources/css/common.css" rel="stylesheet" type="text/css">
<link href="./resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<script src="./resources/js/jquery-3.3.1.js"></script>
<title>딜러 추가사항 입력페이지</title>
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
						<h3>추가사항 입력</h3>
						<form action="car_complete.car" method="post" onsubmit ="return check()" enctype="multipart/form-data">
							<div id="left">
						 	<legend>신청자 입력사항</legend>
						 		<table>
								 <c:forEach var="confirm" items="${car_temp_one}">
									<input type="hidden" name="dealer_id" id="dealer_id" value="${confirm.dealer_id}">
									<tr>
										<td>클래스</td>
										<td><input type="text" name="temp_class" id="temp_class" value="${confirm.temp_class}"></td>
										<td>모델</td>
										<td><input type="text" name="temp_model" id="temp_model" value="${confirm.temp_model}" ></td>
										<td>연식</td>
										<td><input type="text" name="temp_year" id="temp_year" value="${confirm.temp_year}" ></td>
									</tr>
									<tr>
										<td>주행거리(km)</td>
										<td><input type="text" name="temp_distance" id="temp_distance" value="${confirm.temp_distance}" ></td>
										<td>사고이력</td>
										<td><input type="text" name="temp_accident" id="temp_accident" value="${confirm.temp_accident}" ></td>
										<td>차량번호</td>
										<td><input type="text" name="temp_car_no" id="temp_car_no" value="${confirm.temp_car_no}" readonly></td>
									</tr>
									<tr>
										<td>신청자 성함</td>
										<td><input type="text" name="temp_name" id="temp_name" value="${confirm.temp_name}" readonly></td>
										<td>신청자 주소지</td>
										<td><input type="text" name="temp_location" id="temp_location" value="${confirm.temp_location}" readonly></td>
										<td>신청자 연락처</td>
										<td><input type="text" name="temp_phone" id="temp_phone" value="${confirm.temp_phone}" readonly></td>
									</tr>
								 </c:forEach>
								 </table>
						 </div>
						 
						  <div id="dealer_add_carinfo">
						 <legend>딜러 추가 작성 사항</legend>
						 	<table>
						 	 <c:forEach var="confirm" items="${car_temp_one}">
						 		 <tr>
									 <td>엔진 상태</td>		
									 <td><select id="car_engine" name="car_engine">
									 		<option value="X" selected style="display:none;">선택</option>
									 		<option>이상없음</option>
									 		<option>점검필요</option>
									 	</select>
									 </td>
									 <td>주행 조건</td>		
									 <td><select id="car_condition" name="car_condition">
									 		<option value="X" selected style="display:none;">선택</option>
									 		<option>도로</option>
									 		<option>시내</option>
									 		<option>산악</option>
									 	</select>
									 </td>
									 <td>소모품 현황</td>		
									 <td><select id="car_change" name="car_change" >
									 		<option value="X" selected style="display:none;">선택</option>
									 		<option>필터 교체요망</option>
									 		<option>타이어 교체요망</option>
									 		<option>교환 불필요</option>
									 	</select>
									 </td>
									  <td>결함 사항</td>		
									 <td><select id="car_fault" name="car_fault" >
									 		<option value="X" selected style="display:none;">선택</option>
									 		<option>결함 없음</option>
									 		<option>제동계 결함</option>
									 		<option>미션 결함</option>
									 		<option>냉각계통 결함</option>
									 		<option>베터리 결함</option>
									 	</select>
									 </td>
						 		</tr>
						 		<tr>
									 <td>유종</td>		
									 <td><select id="car_fuel" name="car_fuel" >
									 		<option value="X" selected style="display:none;">선택</option>
									 		<option>휘발유</option>
									 		<option>경유</option>
									 		<option>하이브리드</option>
									 	</select>
									 </td>
									 <td>배기량</td>		
									 <td><select id="car_cc" name="car_cc">
									 		<option value="X" selected style="display:none;">선택</option>
									 		<option>1800</option>
									 		<option>2000</option>
									 		<option>2200</option>
									 		<option>2500</option>
									 		<option>3000</option>
									 		<option>3500</option>
									 		<option>4000</option>
									 		<option>4700</option>
									 		<option>5500</option>
									 		<option>6000</option>
											<option>6200</option>
									 	</select>
									 	cc
									 </td>
							 		<td>장착 옵션</td>		
									 <td colspan=3>
										 <label><input type="checkbox" id="car_option" name="car_option" value="네비게이션">네비게이션</label>
										  <label><input type="checkbox" id="car_option" name="car_option" value="후방카메라">후방카메라</label>
										  <label><input type="checkbox" id="car_option" name="car_option" value="하이패스">하이패스</label>
										 <input type="checkbox" id="car_option" name="car_option" checked style="display:none" value="">
									 </td>	
						 		 </tr>
						 		<tr>
						 			<td>사진 첨부</td>
									<td colspan=3><input type="file" name=image id="image"></td>
						 			<td>색상</td>
							 		<td><input type="text" id="car_color" name="car_color"></td>
						 			<td>차량가격</td>		
						 			<td><input type="text" id="car_price" name="car_price">원</td>
						 		</tr>
						 </c:forEach>
						 	</table>
						 	<input type="submit" name="submit1" value="등록하기">
						</div>
						</form>
					</ul>
				</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>