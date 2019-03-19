<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<script src="./resources/js/jquery-3.3.1.js"></script>
<script src="./resources/js/edit.js"></script>
<link href="./resources/css/common.css" rel="stylesheet" type="text/css">
<link href="./resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>딜러 수정페이지</title>
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
						<h3>수정페이지</h3>
						<form action="edit.car" method="post" onsubmit ="return check()" enctype="multipart/form-data">
							<div id="left">
				
						 		<table>
								 <c:forEach var="confirm" items="${confirmList3}">
									 	<tr>				
											
												<input type="hidden" name="dealer_id" id="dealer_id" value="${confirm.dealer_id}">
												<input type="hidden" name="car_score" id="car_score" value=100>
											
										</tr>
										<tr>
											<td>클래스</td>
											<td><input type="text" name="car_class" id="car_class" value="${confirm.car_class}"></td>
											<td>모델</td>
											<td><input type="text" name="car_model" id="car_model" value="${confirm.car_model}" ></td>
											<td>연식</td>
											<td><input type="text" name="car_old" id="car_old" value="${confirm.car_old}"></td>
										</tr>
										<tr>
											<td>주행거리</td>
											<td><input type="text" name="car_distance" id="car_distance" value="${confirm.car_distance}" >km</td>
											<td>사고이력</td>
											<td><input type="text" name="car_accident" id="car_accident" value="${confirm.car_accident}" ></td>
											<td>차량번호</td>
											<td><input type="text" name="car_no" id="car_no" value="${confirm.car_no}" readonly></td>
										</tr>
									 </c:forEach>
								 </table>
						 </div>
						 
						 <div id="dealer_add_carinfo">
						 <legend>딜러 추가 작성 사항</legend>
						 	<table>
						 	 <c:forEach var="confirm" items="${confirmList3}">
						 		 <tr>
									 <td>엔진 상태</td>		
									 <td><select id="car_engine" name="car_engine">
									 		<option value="X" selected style="display:none;"></option>
									 		<option>이상없음</option>
									 		<option>점검필요</option>
									 	</select>
									 </td>
									 <td>주행 조건</td>		
									 <td><select id="car_condition" name="car_condition">
									 		<option value="X" selected style="display:none;"></option>
									 		<option>도로</option>
									 		<option>시내</option>
									 		<option>산악</option>
									 	</select>
									 </td>
									 <td>소모품 현황</td>		
									 <td colspan=3><select id="car_change" name="car_change" >
									 		<option value="X" selected style="display:none;"></option>
									 		<option>필터 교체요망</option>
									 		<option>타이어 교체요망</option>
									 		<option>교환 불필요</option>
									 	</select>
									 </td>
						 		</tr>
						 		<tr>
									 <td>결함 사항</td>		
									 <td><select id="car_fault" name="car_fault" >
									 		<option value="X" selected style="display:none;"></option>
									 		<option>결함 없음</option>
									 		<option>제동계 결함</option>
									 		<option>미션 결함</option>
									 		<option>냉각계통 결함</option>
									 		<option>베터리 결함</option>
									 	</select>
									 </td>
									 <td>유종</td>		
									 <td><select id="car_fuel" name="car_fuel" >
									 		<option value="X" selected style="display:none;"></option>
									 		<option>휘발유</option>
									 		<option>경유</option>
									 		<option>하이브리드</option>
									 	</select>
									 </td>
									 <td>배기량</td>		
									 <td><select id="car_cc" name="car_cc">
									 		<option value="X" selected style="display:none;"></option>
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
							 		<td>색상</td>
							 		<td><input type="text" id="car_color" name="car_color"></td>
						 		 </tr>
						 		<tr>
									 <td>장착 옵션</td>		
									 <td colspan=3>
										 <input type="checkbox" id="car_option" name="car_option" value="네비게이션">네비게이션
										 <input type="checkbox" id="car_option" name="car_option" value="후방카메라">후방카메라
										 <input type="checkbox" id="car_option" name="car_option" value="하이패스">하이패스
										 <input type="checkbox" id="car_option" name="car_option" checked style="display:none" value="">
									 </td>	
									<td>사진 첨부</td>
									<td><input type="file" name=image id="image"></td>
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