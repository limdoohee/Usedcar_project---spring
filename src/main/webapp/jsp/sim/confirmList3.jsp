<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="./resources/js/jquery-3.3.1.js"></script>
	<title>등록확인 세부사항 페이지</title>
	<script>
	function del_check(){
		
			if(confirm("정말 삭제하시겠습니까?")==true){
			return true;
			}else {
				return false;
			}
			
		}
	
</script>
	<title>등록확인 페이지</title>
<style>
td, th{
border: 1px solid #444444;
}
</style>
</head>
<body>

 <div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">
				<h2> 최종등록 완료 상세보기 </h2>	
				<table border="1">
					<thead>
					<tr>
						<th>차량번호</th>
						<th>클래스</th>
						<th>모델</th>
						<th>배기량</th>
						<th>유종</th>
						<th>연식</th>
						<th>주행거리</th>
						<th>사고유무</th>
						<th>색상</th>
						<th>결함사항</th>
						<th>엔진상태</th>
						<th>주행조건</th>
						<th>옵션</th>
						<th>점검여부</th>
						<th>차량 사진</th>
						<th>종합 점수</th>
						<th>차량 가격</th>
						<th>수정하기</th>
						<th>삭제하기</th>

					
			

					</tr>
					</thead>
				<c:forEach var="confirm" items="${confirmList3}">
				
					<tr>
						<td>
						<input type="hidden" id="car_no" name="car_no" value="${confirm.car_no}">
						${confirm.car_no}
						</td>

						
						<td>
						${confirm.car_class}
						</td>
						
						<td>
						${confirm.car_model}
						</td>
						
						<td>
						${confirm.car_cc}
						</td>
						
						<td>
						${confirm.car_fuel}
						</td>
						
						<td>
						${confirm.car_old}
						</td>
						
						<td>
						${confirm.car_distance}
						
						</td>
				
						<td>
						${confirm.car_accident}
						</td>
					
						<td>
						${confirm.car_color}
						</td>
				
						<td>
						${confirm.car_fault}
						</td>
				
						<td>
						${confirm.car_engine}
						</td>
			
						<td>
						${confirm.car_condition}
						</td>
				
						<td>
						${confirm.car_option}
						</td>
						
						<td>
						${confirm.car_change}
						</td>
						
						<td>
						<c:choose>
							<c:when test="${!empty confirm.car_image}">
							<img src="./resources/upload${confirm.car_image}" height="200" width="200">
							</c:when>
							<c:otherwise>
							사진없음.
							</c:otherwise>
						</c:choose>
						</td>
						
						<td>
						${confirm.car_score}
						</td>
						
						<td>
						${confirm.car_price}
						</td>
						
						<td>
							
							<a href="confirm_cont.car?car_no=${confirm.car_no}&state=edit">
						수정</a>
						</td>
						
<%-- 						<form action="confirm_edit.car" method="post">
						
						<input type="submit" value="수정">
						<input type="hidden" id="car_no" name="car_no" value="${confirm.car_no}">
						
						</form> --%>
						
						
						<td>
							<a href="delete.car?car_no=${confirm.car_no}" onclick="return del_check()">
						삭제</a>
						</td>
					</tr>
				</c:forEach>

				</table>
		
			<!-- <a href="car_temp_list">신청온 리스트 보기</a> -->
	
			</div>
		</div>
	</div>
 </div>
</body>
</html>