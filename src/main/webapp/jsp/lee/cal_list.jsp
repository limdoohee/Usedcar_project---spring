<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<title>실구매계산기</title>
<link href="resources/css/common.css" rel="stylesheet" type="text/css">
<link href="resources/css/car_list.css" rel="stylesheet" type="text/css">

<!-- <script src="http://code.jquery.com/jquery-latest.js"></script> -->
<!-- <link rel="stylesheet" href="resources/css/dist/jquery.digitScroller.css">
<script src="resources/js/dist/jquery.digitScroller.js"></script> -->
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js"></script> -->
<script src="resources/js/car_list.js"></script>
<script src="resources/js/car_list_ajax.js"></script>
<script src="resources/js/car_calculator.js"></script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

<script type="text/javascript">

//'필터링'클릭 시 , 검색 조건에 해당하는 검색결과
/*  function load_filter() {
	$.ajax({
		type	: 'POST',
		url		: 'car_find_filter.bo',
		cache	: false,
		data 	: { "car_class" : class_val},
		success	: function (data) {
			$('#type1_ul').empty();
			//$('#type1_ul').append("<li><a>"+data.car_class+"</a></li>");
			var output = "<li><a href='javascript:void(0)' onclick='click_class(this)'>All</a></li>";
			$(data).each(function(index, item){
				output += "<li><a href='javascript:void(0)' onclick='click_class(this)'>"+item.car_class+"</a></li>";
			});
			$('#type1_ul').append(output);
			car_list('All');
		}
	});
} */


 
 /* function result1() {
	var price = $('#price').val();
	alert(price);
	var result1 = price * 0.07;
	alert(result1);
	$('#result1').val(result1);
} */


/* 필터검색  */
function filter_search() {
	var filter1 = $('#filter-1').val();
	var filter2  = $('#filter-2').val();
	var filter3  = $('#filter-3').val();
	car_list_filter(filter1,filter2,filter3);
}

/* 콤마처리 */
var rgx1 = /\D/g;  // /[^0-9]/g 와 같은 표현
var rgx2 = /(\d+)(\d{3})/; 

function getNumber(obj){
	
     var num01;
     var num02;
     num01 = obj.value;
     num02 = num01.replace(rgx1,"");
     num01 = setComma(num02);
     obj.value =  num01;

}

function setComma(inNum){
     
     var outNum;
     outNum = inNum; 
     while (rgx2.test(outNum)) {
          outNum = outNum.replace(rgx2, '$1' + ',' + '$2');
      }
     return outNum;

}


function numberCounter(target_frame, target_number) {
    this.count = 0; this.diff = 0;
    this.target_count = parseInt(target_number);
    this.target_frame = document.getElementById(target_frame);
    this.timer = null;
    this.counter();
};
numberCounter.prototype.counter = function() {
    var self = this;
    this.diff = this.target_count - this.count;
     
    if(this.diff > 0) {
        self.count += Math.ceil(this.diff / 5);
    }
     
    this.target_frame.innerHTML = this.count.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    if(this.count < this.target_count) {
        this.timer = setTimeout(function() { self.counter(); }, 20);
    } else {
        clearTimeout(this.timer);
    }
};


</script>
<style type="text/css">
#result5 {
	color: black;
	font-size: 15pt;
	border-bottom: 3px solid #FF3555;
}
#search_type1, #search_type2 {
	background-color: white;
	font-size: 9pt;
}
#search_type1 a:link {
	color: gray;
}
#search_type1 a:hover {
	color: black;
	border-bottom: 2px solid #FF3555;
}
.search1_select {
	color: black;
	border-bottom: 2px solid #FF3555;
}
</style>
</head>
<body>
<div id="wrap">
	<div id="container">
		<div id="main">
			<div id="content">

				<div id="car_cont">
					<div class="car_header">
						<h2>실구매 가격 계산기</h2> 
						<!-- <div class="digit_scroll_container" style="font-size: 72px;">
						</div> -->
						
						<div id="search_nav">
							<ul>
								<li id="search_class">클래스 선택</li>
								<li id="search_filter">필터링</li>
							</ul>
						</div>
					</div>
					<div id="search_box">
						<!-- <div id="search_nav">
							<ul>
								<li>클래스 선택</li>
								<li>필터링</li>
							</ul>
						</div> -->
						<!-- 클래스 선택 -->
						<div id="search_type1">
							<ul id="type1_ul">
								<li>테스트1</li>
							</ul>
						</div>
						<!-- 필터링 -->
						<div id="search_type2">
							<ul id="type2_ul">
								<li>
									<div>선납금<span id="filter-text1">30</span>%</div>
									<div class="range_wrap">
										<input onchange="$('#filter-text1').html($(this).val()); filter_search(); " class="slider1" id="filter-1"type="range" min="10" max="30" step="10" value="30">
										<div class="range_min_max"><span>10%</span><span>30%</span></div>
									</div>
								</li>
								<li>
									<div>계약기간<span id="filter-text2">24</span>개월</div>
									<div class="range_wrap">
										<input onchange="$('#filter-text2').html($(this).val()); filter_search();" class="slider1" id="filter-2" type="range" min="24" max="36" step="12" value="24">
										<div class="range_min_max"><span>24개월</span><span>36개월</span></div>
									</div>
								</li>
								<li>
									<div>월납입금<span id="filter-text3">5000000</span>원</div>
									<div class="range_wrap">
										<input onchange="$('#filter-text3').html($(this).val()); filter_search();" class="slider1" id="filter-3" type="range" min="300000" max="5000000" step="100000" value="5000000">
										<div class="range_min_max"><span>₩300,000</span><span>₩5,000,000</span></div>
									</div>
								</li>
							</ul>
						</div>
					</div>
<!-- 					<div style="padding:20px;">
						검색 결과 : <strong><span id="car_length">0</span></strong>개의 차량이 검색되었습니다.
					</div> -->
					<div>
						<div id="car_list" style="background-color: #F7F7F7;">
							<p style="margin-top: 50%;text-align: center;">검색 조건을 선택해주세요.</p>
						</div>
						<div id="selected_car" style="background-color: #F7F7F7;">
						
							<p style="margin-top: 50%;text-align: center;">차량을 선택해주세요.</p>
							
							<!-- <div id="car_detail">
								<div id="img1">
									<img src="resources/images/car/img_1.jpg">
								</div>
								<div>
									월납입금/차량가격
									<div class="result result2">
										<div class="c_text">월납입금</div>
										<div><input type="text" id="result5" value="'+Math.floor(data.car_price*0.07)+'" readonly></div>
									</div>
									<div class="result">
										<div class="c_text">취등록세</div>
										<div><input type="text" id="result1" value="'+Math.floor(data.car_price*0.07)+'" readonly></div>
									</div>
									<div class="result">
										<div class="c_text">자동차세</div>
										<div><input type="text" id="result2" value="'+result3(data.car_cc)+'" readonly></div>
									</div>
									<div class="result">
										<div class="c_text">선납금</div>
										<div>10%<input onchange="result2(this);" class="slider1" type="range" min="10" max="30" step="10" value="30">30%</div>
										<div><input type="text" id="result3" value="'+data.car_price*0.3+'" readonly></div>
									</div>
									<div class="result">
										<div class="c_text">계약기간</div>
										<div>24개월<input onchange="result2(this);" class="slider2" type="range" min="24" max="36" step="12" value="24">36개월</div>
									</div>
								</div>
							</div> --> <!-- car_detail -->
						</div> <!-- selected_car -->
					</div>
				</div> <!-- car_cont -->
			</div> <!-- content -->
		</div>	<!-- main -->
	</div>	<!-- container -->
</div>	<!-- wrap -->
</body>
</html>