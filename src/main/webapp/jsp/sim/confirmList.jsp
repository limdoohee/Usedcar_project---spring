<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>등록확인 페이지</title>
</head>
<body>

 <div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">
				<h2> 등록 작성 확인페이지 </h2>	
				<table border=1>
					<thead>
					<tr>

						<th>클래스</th>
						<th>모델</th>
						<th>연식</th>
						<th>주행거리</th>
						<th>사고유무</th>
						<th>차량번호</th>
						<th>성명</th>
						<th>지역</th>
						<th>전화번호</th>
		
						<th>딜러이름</th>
						<!-- 딜러id가 아닌 딜러성함으로 뽑기 -->
					</tr>
					</thead>
				<c:forEach var="confirm" items="${confirmList}">
					<tr>
						
						<td>
						${confirm.temp_class}
						</td>
						
						<td>
						${confirm.temp_model}
						</td>
						
						<td>
						${confirm.temp_year}
						</td>
						
						<td>
						${confirm.temp_distance}
						km
						</td>
				
						<td>
						${confirm.temp_accident}
						</td>
				
						<td>
						${confirm.temp_car_no}
						</td>
				
						<td>
						${confirm.temp_name}
						</td>
			
						<td>
						${confirm.temp_location}
						</td>
				
						<td>
						${confirm.temp_phone}
						</td>
						
						<td>
						${confirm.dealer_name}
						</td>
						
						
					
					</tr>
				</c:forEach>

				</table>
		<a href="main">메인으로 돌아가기</a>

			</div>
		</div>
	</div>
 </div>
</body>
</html>