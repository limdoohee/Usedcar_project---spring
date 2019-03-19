/**
 * 
 */

// '클래스선택'클릭 시 , 존재하는 클래스 목록
function load_class() {
	$.ajax({
		type	: 'POST',
		url		: 'car_find_class.bo',
		cache	: false,
		data 	: null,
		success	: function (data) {
			$('#type1_ul').empty();
			//$('#type1_ul').append("<li><a>"+data.car_class+"</a></li>");
			var output = "<li><a href='javascript:void(0)' class='car_class search1_select' onclick='click_class(this)'>All</a></li>";
			$(data).each(function(index, item){
				output += "<li><a href='javascript:void(0)' class='car_class' onclick='click_class(this)'>"+item.car_class+"</a></li>";
			});
			$(output).hide().appendTo('#type1_ul').fadeIn(400);
			/*$('#type1_ul').append(output);*/
			car_list('All');
		}
	});
};

//'클래스'검색에 해당하는 차량 리스트
function car_list(data) {
	$.ajax({
		type	: 'POST',
		url		: 'car_list.cal',
		//cache	: false,
		data 	: {"car_class" : data},
		dataType : 'json', //return형
		success	: function (data) {
			$('#car_list').empty();
			$(data).each(function(index, item){
				fill_carlist(item);
			});
			$('#car_length').text(data.length);
		},
		error	: function () {
			alert("실패");
		}
	});
};

//'필터링'검색에 해당하는 차량 리스트
function car_list_filter(data1,data2,data3) {
	$.ajax({
		type	: 'POST',
		url		: 'car_list_filter.cal',
		//cache	: false,
		data 	: {"filter1" : data1,
				   "filter2" : data2,
				   "filter3" : data3},
		dataType : 'json', //return형
		success	: function (data) {
			$('#car_list').empty();
			$(data).each(function(index, item){
				fill_carlist(item);
			});
			$('#car_length').text(data.length);
		},
		error	: function () {
			alert("실패");
		}
	});
};

function fill_carlist(item) {
	var output = '';
	output += '<div class="car" onclick="select(this)">';
	output += '		<input type="hidden" class="carPK" value="'+item.car_no+'">';
	output += '		<div class="c_img"><img src="resources/upload/car/'+item.car_image+'"></div>';
	output += '		<div class="c_cont">';
	output += '			<div class="c_model"><strong>'+item.car_model+'</strong> │ '+item.car_class+'</div>';
	output += '			<div class="c_price">￦'+item.car_price+'</div>';
	output += '			<div class="hr"><hr></div>';
	output += '			<div class="c_fuel">'+item.car_fuel+'</div>';
	output += '			<div class="c_year">'+item.car_old+'</div>';
	output += '			<div class="c_dist">'+item.car_distance+' km</div>';
	output += '			<div class="c_falut">'+item.car_fault+'</div>';
	output += '		</div>';
	output += '</div>';
	$(output).hide().appendTo('#car_list').fadeIn(400);
	//$('#car_list').append(output);
}


//'차량' 선택 시, 계산기 로딩
function load_cal(carPK) {
	$.ajax({
		type	: 'POST',
		url		: 'car_detail.cal',
		cache	: false,
		data 	: {"car_no": carPK},
		success	: function (data) {
			$('#selected_car').empty();
			var output = '';
			
			var price = data.car_price;
			//취등록세
			var re1 = Math.floor((price*0.7)*0.07);
			//자동차세
			var re2 = result2(data.car_cc);
			//선납금
			var re3 = price*0.3;
			//월납입금
			var re5 = Math.floor((price*0.7)/24);
			var re5_1 = re5.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
			
			output += '<div id="car_detail">';
/*			output += '<div id="img1">';
			output += '		<img src="resources/images/car/'+data.car_image+'">';
			output += '	</div>';*/
			output += '	<input type="hidden" id="price" value="'+data.car_price+'">';
			output += '	<div>';
			output += '		<div class="result result2">';
			output += '			<div class="c_text">월납입금</div>';
			output += '			<div><span id="result5">'+re5_1+'</span></div>';
			output += '		</div>';
/*			output += '		<script>';
			output += '			new numberCounter("result5",'+re5_1+');';
			output += '		</script>';*/
			output += '		<ul id="calculator_wrap">';
			output += '		<li class="result">';
			output += '			<div class="c_text">선납금</div>';
			output += '			<div>';
			output += '				<input onchange="result3(this);" class="slider1" type="range" min="10" max="30" step="10" value="30">';
			output += '				<div class="range_min_max"><span>10%</span><span>30%</span></div>';
			output += '				<div><input type="text" id="result3" value="'+re3+'" readonly></div>';
			output += '			</div>';
			output += '		</li>';
			output += '		<li class="result">';
			output += '			<div class="c_text">계약기간</div>';
			output += '			<div>';
			output += '				<input onchange="result4(this);" id="result4" class="slider2" type="range" min="24" max="36" step="12" value="24">';
			output += '				<div class="range_min_max"><span>24개월</span><span>36개월</span></div>';
			output += '			</div>';
			output += '		</li>';
			output += '		</ul>';
			output += '		<ul id="tax_wrap">';
			output += '			<li class="result">';
			output += '				<div class="c_text">취등록세</div>';
			output += '				<div><input type="text" id="result1" value="'+re1+'" readonly></div>';
			output += '			</li>';
			output += '			<li class="result">';
			output += '				<div class="c_text">자동차세</div>';
			output += '				<div><input type="text" id="result2" value="'+re2+'" readonly></div>';
			output += '			</li>';
			output += '		</ul>';
			output += '	</div>';
			output += '</div>';
			$(output).hide().appendTo('#selected_car').fadeIn(400);
			//$('#selected_car').append(output);
		},
		error	: function () {
			alert("실패");
		}
		
	});
}
