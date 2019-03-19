<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="./resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<link href="resources/css/dealer_drive.css" rel="stylesheet" type="text/css">
<script src = "./resources/js/jquery-3.3.1.js"></script>
<script src="./resources/js/dealer_drive.js"></script>
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
						<h3>시승신청 관리</h3>
						<ul id="select_wrap">
							<li>
								<label>클래스</label>
								<select name='carclass' id='carclass'>
									<option value=''>선택</option>
								</select>
							</li>
							<li>
								<label>모델</label>
								<select name='carmodel' id='carmodel' class='selectopt'>
									<option value=''>선택</option>
								</select>
							</li>
							<li>
								<label>차량번호</label>
								<input type='text' name='car_no' id='car_no'>
							</li>
							<li>
								<input type='button' id='searchbtn' value='검 색'>
							</li>
						</ul>
						<ul id='driveformul'>
						<div id="table_wrap">
							<table id='driveform'>
								<c:if test='${listcount > 0}'>
								<thead>
									<tr>
										<th>번호</th>
										<th>차량번호</th>
										<th>클래스</th>
										<th>모델</th>
										<th>딜러명</th>
										<th>시승날짜</th>
										<th>이름</th>
										<th>전화번호</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:set var="num" value="${listcount-(page-1)*7}"/>
									<c:forEach var='d' items='${drivelist}'>
									<tr>
										<td><c:out value="${num}"/><c:set var="num" value="${num-1}"/></td>
										<td>${d.drive_car_no}</td>
										<td>${d.drive_car_class}</td>
										<td>${d.drive_car_model}</td>
										<td>${d.dealer_name}
										<td>${d.drive_date} ${d.drive_ampm}</td>
										<td>${d.drive_name}</td>
										<td>${d.drive_phone}</td>
										<td>
											<c:if test='${d.drive_complete == 0}'>
												<button class='submit' onclick='submitClick(${d.drive_no})'>신청</button>
											</c:if>
											<c:if test='${d.drive_complete == 1}'>
												<div id='drivecomplete'>시승완료</div>
											</c:if>
										</td>
									</tr>
									</c:forEach>
								</tbody>
								</c:if>
							</table>
						</div>
						<div id='paging_area'>
							<c:forEach var='a' begin='${startpage }' end='${endpage }'>
								<c:if test = '${a == page }'>
									<div class="paging_active">${a}</div>
								</c:if>
								<c:if test='${a != page }'>
<%-- 									<div class="paging_number"><a href='dealer_drive_manage.drv?page=${a}'>${a }</a></div> --%>
									<div class="paging_number"><a href='javascript:void(0)' onclick='pageonClick(${a})'>${a }</a></div>
								</c:if>
							</c:forEach>
						</div>
						</ul>
					</ul>
				</div>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>