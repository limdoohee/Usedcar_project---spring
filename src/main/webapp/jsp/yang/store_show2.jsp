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
				</div>	<!-- store -->
			</div>
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