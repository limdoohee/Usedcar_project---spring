<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="drivelist_wrap">
	<ul id='drivelist'>
		<h5>전체(${listcount })</h5>
		<hr>
		<c:if test='${listcount > 0 }'>
		<c:forEach var='d' items='${drivelist }'>
		<li>
			<a href='javascript:void(0)' onclick='cmodelClick(this)' id='classmodel' class='classmodel'>
			<div>
			 	<input type='hidden' class='dealerid' value='${d.dealer_id}'>
			 	<input type='hidden' class='carno' value='${d.car_no}'>
				<span>${d.car_class} ${d.car_model}</span>
			</div>
			<div>${d.store_location}</div>
			</a>
				<div class='dealerinfo'>
					<div id="info_box">딜러 정보</div>
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