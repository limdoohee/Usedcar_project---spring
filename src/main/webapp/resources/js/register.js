/*function confirm1(){
	var a = $('#temp_class option:selected').val();
	$('#confirm_a').val(a);

}

function confirm2(){
	var b = $('#temp_model option:selected').val();
	$('#confirm_b').val(b);	
}

function confirm3(){
	var c = $('#temp_year option:selected').val();
	$('#confirm_c').val(c);	
}

function confirm4(){
	var d = $('#temp_distance').val();
	$('#confirm_d').val(d);	
}

function confirm5(){
	var ac = $('input[name="temp_accident"]:checked').val();
	$('#confirm_e').val(ac);	
}
			
function confirm6(){
	var f = $('#temp_color option:selected').val();
	$('#confirm_f').val(f);	
}

function confirm7(){
	var g = $('#temp_car_no').val();
	$('#confirm_g').val(g);	

}
*/

//유효성 검사
function check(){
	if($("#temp_class").val()==""){
		
		
		alert("클래스를 입력해주세요 ");
		return false;
	}
	
	if($("#temp_model").val()==""){
		alert("모델을 입력해주세요 ");
		return false;
	}
	if($("#temp_year").val()==""){
		alert("연식을 입력해주세요 ");
		return false;
	}

	var temp_year = $('#temp_year').val();
	
	if (!$.isNumeric(temp_year)) {
		
		alert('연식은 숫자만 입력해주세요.');

		$('#temp_year').val('');
		return false;
	}
	
	if(temp_year.toString().length!=4){
		alert('연식은 네자리만 입력해주세요.');
		$('#temp_year').val('');
		return false;
	}

	
	if($.trim($("#temp_distance").val())==""){
		alert("주행거리를 입력해주세요 ");
		return false;
	}
	var temp_distance = $('#temp_distance').val();
	if (!$.isNumeric(temp_distance) ) {

		alert('주행거리는 숫자만 입력해주세요.');

		$('#temp_distance').val('');
		return false;
		}
	

	if($('input[name="temp_accident"]:checked').val()==null){
		alert("사고이력 여부를 선택해주세요 ");
		return false;
	}

	
	if($.trim($("#temp_car_no").val())==""){
		alert("차량 번호를 입력해주세요 ");
		return false;
	}

	if($.trim($("#temp_name").val())==""){
		alert("차주 성함을 입력해주세요 ");
		return false;
	}
	
	
	if($.trim($("#temp_phone").val())==""){
		alert("연락처를 입력해주세요 ");
		return false;
	}
	
	if($("#temp_location").val()=="X"){
		alert("지역을 선택해주세요 ");
		return false;
	}
	if($("#temp_location2").val()==""){
		alert("상세주소를 입력해주세요 ");
		return false;
	}
	
	else 
	{
		if(confirm("차량등록을 하시겠습니까?")==true){
			location.reload();
		return true;
		}else {
			return false;
		}
		}

}
	