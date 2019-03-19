function check(){
	if($("#car_class").val()==""){
		alert("클래스를 입력해주세요 ");
		return false;
		
	}
	if($("#car_model").val()==""){
		alert("모델을 입력해주세요 ");
		return false;
		
	}
	


if($("#car_old").val()==""){
	alert("연식을 입력해주세요 ");
	return false;
}

	var car_old = $('#car_old').val();
	
	if (!$.isNumeric(car_old)) {
		
		alert('연식은 숫자만 입력해주세요.');

		$('#car_old').val('');
		return false;
	}
	
	if(car_old.toString().length!=4){
		alert('연식은 네자리만 입력해주세요.');
		$('#car_old').val('');
		return false;
	}
	
	var car_distance = $('#car_distance').val();
	if (!$.isNumeric(car_distance)) {
		
		alert('주행거리는 숫자만 입력해주세요.');

		$('#car_distance').val('');
		return false;
	}
	
	if($("#car_accident").val()==""){
		alert("사고이력을 입력해주세요 ");
		return false;
		
	}
	if($("#car_color").val()==""){
		alert("색상을 입력해주세요 ");
		return false;
		
	}
	
	if($("#car_price").val()==""){
		alert("가격을 입력해주세요 ");
		return false;
		
	}
	var car_price = $('#car_price').val();
	if (!$.isNumeric(car_price) ) {

		alert('가격은 숫자만 입력해주세요.');

		$('#car_price').val('');
		return false;
		}
	
	if($("#car_engine").val()=="X"){
		alert("엔진 상태를 선택해주세요 ");
		return false;
	}
	
	if($("#car_condition").val()=="X"){
		alert("주행조건을 선택해주세요 ");
		return false;
	}
	
	if($("#car_change").val()=="X"){
		alert("소모품 교체시기를 선택해주세요 ");
		return false;
	}
	
	if($("#car_fault").val()=="X"){
		alert("결함 사항을 선택해주세요 ");
		return false;
	}
	
	if($("#car_fuel").val()=="X"){
		alert("유종을 선택해주세요 ");
		return false;
	}
	
	
	if($("#car_cc").val()=="X"){
		alert("배기량을 선택해주세요 ");
		return false;
	}



	
	else 
		{
		if(confirm("차량등록을 하시겠습니까?")==true){
		return true;
		}else {
			return false;
		}
		}
		
		

}