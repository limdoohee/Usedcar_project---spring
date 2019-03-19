<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<script src = "./resources/js/jquery-3.3.1.js"></script>
<link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
<link href="resources/css/dealer_page.css" rel="stylesheet" type="text/css">
<link href = "./resources/css/dealer.css" rel="stylesheet">
<script>
	
	function check(){
		
		if($.trim($('#store_name').val()) == ''){
			alert("이름을 입력하세요");
			$('#store_name').val("").focus();
			return false;
		}
		if($.trim($('#store_location').val()) == ''){
			alert("주소를 입력하세요");
			$('#store_location').val("").focus();
			return false;
		}
		if($.trim($('#store_tel').val()) == ''){
			alert("전화번호를 입력하세요");
			$('#store_tel').val("").focus();
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
						<h3>전시장 등록</h3>
						<form action = "admin_store_reg_ok.str" method = "post" onsubmit = "return check()">
							<table class = "tbn">
								<tr>
									<td>
										<label class="icon" for="name"><i class="icon-user"></i></label>
										<input type = "text" name = "store_name" id = "store_name" placeholder = "Name"> 
									</td>
								</tr>
								
								<tr>
									<td>
										<label class="icon" for="name"><i class="icon-plane"></i></label>
										<input type = "text" name = "store_location" id = "store_location" placeholder = "Location">
									</td>
								</tr>
								
								<tr>
									<td>
										<label class="icon" for="name"><i class="icon-phone"></i></label>
										<input type = "text" name = "store_tel" id = "store_tel" placeholder = "Tel">
									</td>
								</tr>
							</table>
							<div class = "form-group">
								<input type = "submit" value = "등록">
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
