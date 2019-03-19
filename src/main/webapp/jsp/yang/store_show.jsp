<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/store.css" >
<script src = "./resources/js/store.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5dee4259aa976411e8a4e8c7e16a2c6e&libraries=services,clusterer"></script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">
			<input type="hidden" value="1" id="page_vlaue">
			 <div class="add">
				<h2>전시장 안내</h2>
				<div id = "search">
				<!-- <form method = "get" action = "store_search.str" onsubmit = "return check()"> -->
					<div id = "search_Type">
						<label><input type="radio" name="searchType"  value = "1" checked = "checked">희망지역</label>
						<label><input type="radio" name="searchType"  value = "2">전시장명</label>
						
					</div>
					<div id="search_select_wrap">
						<select name = "searchCity" id = "searchCity">
							<option value = "" selected>전체</option>
							<option value = "서울">서울</option>
							<option value = "경기">경기</option>
							<option value = "인천">인천</option>
							<option value = "강원">강원</option>
							<option value = "충청">충청</option>
							<option value = "대전">대전</option>
							<option value = "전라">전라</option>
							<option value = "광주">광주</option>
							<option value = "경상">경상</option>
							<option value = "대구">대구</option>
							<option value = "부산">부산</option>
							<option value = "울산">울산</option>
							<option value = "제주">제주</option>
						</select>
						<input type = "hidden" id = "search_select" name = "search_select" >
					</div>
					<div id="search_text_wrap">
						<input type = "text" id = "search_text" name = "search_text" placeholder="전시장명을 입력하세요. 예)동대문">
					</div>
					<div id="submit_btn">
						<input type = "button" value = "검색" onclick = "search_location()">
					</div>
				<!-- </form> -->
				</div>
				<div id = "store">
					<div class = "store_list">
						<h5>전체(${listcount })</h5>
						<hr>
						<ul id = "list">
						 <c:forEach var = "s" items = "${storelist }">
						  <li>
							 <dl>
						  		<dt>
						  			<a href = "javascript:void(0)" id = "store_map" class="store_map">${s.store_name }</a>
									<input type = "hidden" class="location" value = "${s.store_location }">	
								</dt>
						  		<dd>주소 : ${s.store_location }</dd>
							  	<dd>전화번호 : ${s.store_tel }</dd>
						  	</dl>			  	
						  </li>
						 </c:forEach>
						</ul>
					<div id="paging">
						<c:if test = "${page <= 1 }">
							◀
						</c:if>
						
						<c:if test = "${page > 1 }">
							<a href = "javascript:void(0)" class = "page_before">◀</a>
						</c:if>
						
						<c:forEach var = "a" begin = "${startpage }" end = "${endpage }">
							<c:if test = "${a == page }">
								${a}
							</c:if>
							<c:if test = "${a != page }">
								<a href = "javascript:void(0)" class = "page_on">${a }</a>
							</c:if>
						</c:forEach>
						
						<c:if test = "${page >= maxpage }">
							▶
						</c:if>
						
						<c:if test = "${page < maxpage }">
							<a href = "javascript:void(0)" class = "page_after">▶</a>
						</c:if>
					</div>
					</div> <!-- store_list -->
					<div id = "map">
						<!-- 지도 -->
					</div>
				</div>
			</div>
		</div><!--main  -->
	</div>
	</div>
</div>
</body>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new daum.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표
    level: 13 // 지도의 확대 레벨
};

var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//마커가 표시될 위치입니다 
var markerPosition  = new daum.maps.LatLng(33.450701, 126.570667); 

//마커를 생성합니다
var marker = new daum.maps.Marker({
position: markerPosition
});

//마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

marker.setMap(null);    
</script>
</html>