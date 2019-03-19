<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="./resources/js/jquery-3.3.1.js"></script>
	<title>등록확인 페이지</title>
	<script>
	function del_check(){
		
			if(confirm("정말 삭제하시겠습니까?")==true){
			return true;
			}else {
				return false;
			}
			
		}
	
</script>
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
				<h2> 최종등록 완료리스트 </h2>	
				<table border="1">
					<thead>
					<tr>
						<th>차량번호</th>
						<th>클래스</th>
						<th>모델</th>
						<th>연식</th>
						<th>주행거리</th>
						<th>상세보기</th>
						<th>수정</th>
						<th>삭제</th>


					</tr>
					</thead>
				<c:forEach var="confirm" items="${confirmList2}">
					<tr>
						<td >
						${confirm.car_no}
						</td>

						
						<td>
						${confirm.car_class}
						</td>
						
						<td>
						${confirm.car_model}
						</td>
						
						<td>
						${confirm.car_old}
						</td>
						
						<td>
						${confirm.car_distance}
						</td>
						
						<td>
						<a href="confirm_cont.car?car_no=${confirm.car_no}&state=cont">
						상세보기</a>
						</td>
						
						<td>
						<a href="confirm_cont.car?car_no=${confirm.car_no}&state=edit">
						수정</a>
						</td>
						
						<td>
						<a href="delete.car?car_no=${confirm.car_no}" onclick="return del_check()">
						삭제</a>
						</td>
				
						
						
					
					</tr>
				</c:forEach>

				</table>

						<!--  <a href="car_temp_list?dealer_id=${confirm.dealer_id}">신청온 리스트 보기</a>-->
			</div>
		</div>
	</div>
 </div>
</body>
</html>