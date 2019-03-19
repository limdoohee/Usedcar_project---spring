/**
 * 
 */


$(function() {	
	//처음에 기본 검색조건 안보이게 세팅
	$('#search_type1').hide();
	$('#search_type2').hide();
	
	//'클래스선택' 조건으로 선택되게 세팅
	//click_btn1();
	$('#search_class').click(function() {
		click_btn1();
	});
	$('#search_filter').click(function() {
		click_btn2();
	});
	
	
	
});

//클래스 종류 선택 시, 해당 클래스 값 넘겨주기
function click_class(data) {
	var class_val = $(data).text();
	car_list(class_val);
	$('.car_class').removeClass('search1_select');
	$(data).addClass('search1_select');
}

// 누르는 버튼에 따라 검색 조건 세팅
function click_btn1() {
	// '클래스선택'으로 선택되게 세팅
	$('#search_class').addClass('selected_option');
	$('#search_filter').removeClass('selected_option');
	$('#search_type1').show(200);
	$('#search_type2').hide();
	load_class();
}

function click_btn2() {
	//'필터링'으로 선택되게 세팅
	$('#search_filter').addClass('selected_option');
	$('#search_class').removeClass('selected_option');
	$('#search_type2').show(200);
	$('#search_type1').hide();
	filter_search();
}

function select(data) {
	var carPK = $(data).find(".carPK").val();
	$('.car').removeClass('selectbox');
	$(data).addClass('selectbox');
	load_cal(carPK);
}