<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style type="text/css">
#content {
	width: 560px;
	text-align: center;
	margin-left: 15px;
}
#header {
	width: 100%;
	heigth:100px;
	text-align: left;
	border-bottom: 1px solid lightgray;
	margin-bottom: 20px;
}
#header h4 {
	padding:5px;
	padding-top: 30px;
	padding-left: 10px;
}
#header p {
	padding:5px;
	padding-bottom: 30px;
	padding-left: 20px;
	font-weight: 300;
	font-size: 11pt;
}
#cont {
	width: 70%;
	margin: 0 auto;
	text-align: center;
	margin-top:50px;
}
#cont * {
	float: left;
}
#box1 {
	padding-right: 30px;
}
#input-1, #btn-1 {
	background-color: white;
	border: 1px solid lightgray;
}
#btn-1 {
	width:50px;
}
</style>
<script type="text/javascript">
$(function() {
	$('#btn-1').click(function() {
		var pass = $.trim($('#input-1').val());
		var num = $('#num').val();
		var page = $('#page').val();
		var state = $('#state').val();
		window.location.href="board_delete_ok.bo?pwd="+pass+"&num="+num+"&page="+page+"&state="+state;
		//window.opener.location.href="http://www.naver.com";
		//window.close();
	});
});
</script>
</head>
<body>
	<div id="content">
		<div id="header">
			<h4>게시글 삭제</h4>
			<p> ─ 게시글 작성 시 입력한 비밀번호를 작성해주세요.</p>
		</div>
		<div id="cont">
			<div id="box1">비밀번호</div>
			<input type="text" name="board_pass" id="input-1">
			<input type="button" value="확인" id="btn-1">
			<input type="hidden" id="num" value="${board.board_num}">
			<input type="hidden" id="page" value="${page}">
			<input type="hidden" id="state" value="${state}">
		</div>
	</div>
</body>
</html>