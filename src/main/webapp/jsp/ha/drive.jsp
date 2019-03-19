<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="./resources/css/drive.css" rel="stylesheet" type="text/css">
<script src="./resources/js/drive.js"></script>
</head>
<body>
	<div id="wrap">
		<div id="container">
			<div id="main">
				<div id="content">
					<input type="hidden" value="1" id="page_value">
				<form method='post' name='driveform' id='driveform'>	
					<h2>시승 신청</h2>
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
							<label>지역</label>
							<select name='storeloc1' id='storeloc1' class='selectopt'>
								<option value=''>선택</option>
							</select>
							<select name='storeloc2' id='storeloc2' class='selectopt'>
								<option value=''>선택</option>
							</select>
						</li>
						<li>
							<input type='button' id='searchbtn' value='검 색'>
						</li>
					</ul>
						
					<ul id="list_wrap">
						<li id='driveformli1'>
							<div id="select_car"><h3>차량 선택</h3>1. 검색 조건을 선택하세요</div>
							<div id="drivelist_wrap">
								<ul id='drivelist'>
									<c:if test='${listcount > 0 }'>
											<c:forEach var='d' items='${drivelist }'>
											<li>
												<div><a href='javascript:void(0)' onclick='cmodelClick(this)' id='classmodel' class='classmodel'>
												 	<input type='hidden' class='dealerid' value='${d.dealer_id}'>
												 	<input type='hidden' class='carno' value='${d.car_no}'>
													<span>${d.car_class} ${d.car_model}</span></a>
												</div>
												<div>${d.store_location}</div>
												<div class='dealerinfo'>
													<div>딜러 정보</div>
													<div>${d.dealer_name}</div>
													<span></span>
													<div>${d.store_name}</div>
													<span></span>
													<div>${d.dealer_phone}</div>
												</div>
											</li>
										</c:forEach>
									</c:if>
								</ul>
							</div>
							
							<c:if test='${listcount > 0 }'>
							<div id='paging'>
								<c:forEach var='a' begin='${startpage }' end='${endpage }'>
									<c:if test = '${a == page }'>
										${a}
									</c:if>
									<c:if test='${a != page }'>
										<a href='javascript:void(0)' class='page_on' onclick='pageonClick(${a})'>${a }</a>
									</c:if>
								</c:forEach>
							</div>
							</c:if>
						</li>
						
						
						<li id='driveformli2'>
							<div id="select_calendar"><h3>시승 시간대 선택</h3>2. 차량을 선택하세요</div>
							<div id='calendar_wrap'>
								<div class='top-calendar'>
									<div class='move-month'>
<%-- 										<input type='button' id='preMonth' value='<'/> --%>
										<div id='preMonth' ng-click="moveBack()" ng-if="pickdate">
											<svg width="30" height="30">
												<path fill="none" stroke="#fff" stroke-width="3" d="M19,6 l-9,9 l9,9"></path>
											</svg>
										</div>
										<div id='currentMonth'></div>
										<div id='nextMonth' ng-click="moveForward()" ng-if="pickdate">
											<svg width="30" height="30">
												<path fill="none" stroke="#fff" stroke-width="3" d="M11,6 l9,9 l-9,9"></path>
											</svg>
										</div>
<!-- 										<input type='button' id='nextMonth' value='>' /> -->
									</div>
								</div>
								<div id="table_wrap">
									<table>
										<thead>
											<tr>
												<th>SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th>
											</tr>
										</thead>
										<tbody id='calendar'>
										
										</tbody>
									</table>
								</div>
							</div>
						</li>
						
						<li id='driveformli3'>
							<div id="select_privacy"><h3>개인 정보 입력</h3>3. 개인 정보를 선택하세요</div>
							<div id="privacy_wrap">
								<ul>
									<li>
										<label>성명</label>
						        		<input type='text' id='drive_name' class='drvname'>
						        	</li>
									<li>
									 <label>휴대전화</label>
						        	<input type='text' id='drive_phone1' value='010' readonly>
						        	- <input type='text' id='drive_phone2' class='drvphone' maxlength='4'>
						        	- <input type='text' id='drive_phone3' class='drvphone' maxlength='4'>
									</li>
									<li id="drivebtn_wrap">
										<input type='button' id='drivebtn' value='신청하기'>
									</li>
								</ul>
							</div>
						</li>
						
					</ul>
				</form>
				
					<div id='afterdrive'>
						<h2>시승 신청 내역을 확인하세요</h2>
						<ul id='driveinfo'></ul>
						<input type='button' id='godrive' value='메인화면으로 가기'>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>