<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<div>
	<c:if test='${listcount == 0}'>
		<table id='nolist'>
			<tr>
				<td colspan="4">시승신청 리스트</td>
		</tr>
		<tr>
			<td>신청내역이 없습니다.</td>
		</tr>
		</table>
	</c:if>
</div>
<input type='hidden' name='carno' id='carno' value='${carno}'>
<input type='hidden' name='cmodel' id='cmodel' value='${cmodel}'>
<input type='hidden' name='cclass' id='cclass' value='${cclass}'>
		
<div id='paging_area'>
	<c:forEach var='a' begin='${startpage }' end='${endpage }'>
		<c:if test = '${a == page }'>
			<div class="paging_active">${a}</div>
		</c:if>
		<c:if test='${a != page }'>
			<div class="paging_number"><a href='javascript:void(0)' onclick='pageonClick(${a})'>${a }</a></div>
		</c:if>
	</c:forEach>
</div>
