<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link href="./resources/css/common.css" rel="stylesheet" type="text/css">
<script src = "./resources/js/jquery-3.3.1.js"></script>
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
<link href="./resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<link href = "./resources/css/dealer.css" rel="stylesheet">
<script>
	
	function check(){
		
		if($.trim($('#dealer_id').val()) == ''){
			alert("딜러 아이디를 입력하세요");
			$('#dealer_id').val("").focus();
			return false;
		}
		if($.trim($('#dealer_pass').val()) == ''){
			alert("비밀번호를 입력하세요");
			$('#dealer_pass').val("").focus();
			return false;
		}
		if($.trim($('#dealer_name').val()) == ''){
			alert("딜러 이름을 입력하세요");
			$('#dealer_name').val("").focus();
			return false;
		}
		if($.trim($('#dealer_phone').val()) == ''){
			alert("전화번호를 입력하세요");
			$('#dealer_phone').val("").focus();
			return false;
		}
		if($.trim($('#dealer_email').val()) == ''){
			alert("이메일을 입력하세요");
			$('#dealer_email').val("").focus();
			return false;
		}
		if($.trim($('#store_no').val()) == ''){
			alert("고유 번호를 입력하세요");
			$('#store_no').val("").focus();
			return false;
		}
		else{
			
			var result = confirm("등록하시겠습니까?");
			if (result == true){
				alert('등록되었습니다.');
			}
			else{
				alert('등록이 취소되었습니다.');
				return false;
			}
		}
		
	}
	
$(function(){
		
		$('.list').val();
		
		$('.list').change(function(){
			
			var num = $(this).val();
			
			$('#store_no').val(num);
			
		});
	})
</script>
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
						<h3>딜러 등록</h3>
						<form action = "admin_dealer_reg_ok.dlr" method = "post" onsubmit = "return check()">
							<table class = "tbn">
								<tr>
									<td>
										<label class="icon" for="name"><i class="icon-key"></i></label>
										<input type = "text" name = "dealer_id" id = "dealer_id" placeholder = "Id" required>
									</td>
								</tr>
								
								<tr>
									<td>
										<label class="icon" for="name"><i class="icon-shield"></i></label>
										<input type = "password" name = "dealer_pass" id = "dealer_pass" placeholder = "Password" required>
									</td>
								</tr>
								
								<tr>
									<td>
										<label class="icon" for="name"><i class="icon-user"></i></label>
										<input type = "text" name = "dealer_name" id = "dealer_name" placeholder = "Name" required>
									</td>
								</tr>
								
								<tr>
									<td>
										<label class="icon" for="name"><i class="icon-phone"></i></label>
										<input type = "text" name = "dealer_phone" id = "dealer_phone" placeholder = "Phone" required>
											</td>
								</tr>
								
								<tr>
									<td>
										<label class="icon" for="name"><i class="icon-envelope "></i></label>
										<input type = "email" name = "dealer_email" id = "dealer_email" placeholder = "Email" required>
									</td>
								</tr>
								
								<tr>
									<td>
											<label class="icon" for="name"><i class="icon-group"></i></label>
											<select class = "list">
												<c:forEach var = "i" items = "${store }">
													<c:if test = "${i.store_name != '관리자' }">
														<option value = "${i.store_no }">${i.store_name }</option>
													</c:if>
												</c:forEach>
										</select>
									</td>
								</tr>
							</table>
							<div class = "form-group">
								<input type = "hidden" name = "store_no" id = "store_no" placeholder = "Unique number">
								<input type = "submit" value = "등록하기">
							</div>
						</form>
					</div>
				</ul>
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>
