<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="./resources/js/register.js"></script>
<link href="./resources/css/register.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">
			<h2 id="register_title">견적 신청</h2>
<!-- 			<h3 id="register_title_expl">나의 차량을 등록한 후, 딜러가 직접 연락 뒤에 견적을 파악할 예정입니다.</h3> -->
			<form action="car_temp_register.car" method="post" onsubmit ="return check()" id="register_form">
			<%-- 차량 정보 입력 --%>
			<h4>차량 정보입력</h4>
			<div class="register_table_wrap">
				 <table id="car_info_register">
				 		<tr>
				 			<th>클래스</th>
				 			<td><input type="text" id="temp_class" name="temp_class"></td>
				 			<th>모델</th>
				 			<td><input type="text" id="temp_model" name="temp_model"></td>
				 		</tr>
				 		<tr>
				 			<th>연식</th>
				 			<td><input type="text" id="temp_year" name="temp_year" placeholder="숫자만 입력해주세요"></td>
				 			<th>주행거리</th>
				 			<td><input type="text" name="temp_distance" id="temp_distance" placeholder="숫자만 입력해주세요" >km</td>
				 		</tr>
				 		<tr>
				 			<th>사고유무</th>
				 			<td>
				 				<label><input type = "radio" name = "temp_accident" id="temp_accident" value = "무사고" >무사고</label> 
							 	<label><input type = "radio" name = "temp_accident" id="temp_accident" value = "유사고">유사고</label>
				 			</td>
				 			<th>차량번호</th>
				 			<td><input type="text" name="temp_car_no" id="temp_car_no" placeholder="차량번호를 모두 입력해주세요" onkeyup="confirm7()"></td>
				 		</tr>
				 </table>
			</div>
			<h4>신청자 정보입력</h4>
			<div class="register_table_wrap">
				<table id="registrant_info">
						<tr>
							<th>성함</th>
							<td><input type="text" name="temp_name" id="temp_name" ></td>
						  	<th>연락처</th>
						  	<td><input type="text" name="temp_phone" id="temp_phone"  ></td>
						</tr>
						<tr>
							<th>주소</th>
							<td colspan=3>
								<select id="temp_location" name="temp_location">
									<option value="X" selected>선택</option>
									<option value="서울" >서울</option>
									<option value="경기" >경기</option>
									<option value="인천" >인천</option>
									<option value="강원" >강원</option>
									<option value="충청" >충청</option>
									<option value="대전" >대전</option>
									<option value="전라" >전라</option>
									<option value="광주" >광주</option>
									<option value="경상" >경상</option>
									<option value="대구" >대구</option>
									<option value="부산" >부산</option>
									<option value="울산" >울산</option>
									<option value="제주" >제주</option>
								</select>
								<input type="text" id=temp_location2 name="temp_location2" placeholder="상세주소를 입력해주세요"></td>
						</tr>
				</table>
			</div>
			<div>
				<input type="submit" name="submit1" value="등록하기" id="register_submit"> 	
			</div>
			</form>
							
				<!--
				값 선택ㅡ>  선택값 표시 ㅡ> 유효성 검사ㅡ> 등록 여부 확인 ㅡ>db삽입
				(딜러id 히든처리하고  딜러아이디는 지역 입력시 와일드카드로 팔도 나누고 해당하는 딜러번호를 랜덤으로 돌려서 넣어줌/  
				
				 ㅡ> 리스트 뽑기(딜러id 와 문서번호 표시) 
				  -->
				  
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>