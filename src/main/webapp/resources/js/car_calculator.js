/**
 * 
 */


/* 자동차세 계산 */
function result2(data) {
	if(data>=1600)
		return data*200 + data*200*0.3;
	else if(data < 1000)
		return data*80 + data*80*0.3;
	else
		return data*140 + data*140*0.3;
};

/*  선납금 '%' 변경 시 */
function result3(data) {
	var price = $('#price').val(); // 차량 가격
	var per = ($(data).val()*0.01); // 퍼센트 계산
	//선납금 계산
	var result3 = price * per;
	$('#result3').val(result3);
	//월납입금 계산
	var result5 = Math.floor((price-result3)/$('#result4').val());
	$('#result5').val(result5);
	new numberCounter("result5",result5);
};

/*  계약기간 '개월' 변경 시 */
function result4(data) {
	var price = $('#price').val(); // 차량 가격
	var month = $(data).val(); // 계약기간
	var result3 = $('#result3').val(); // 선납금
	//월납입금 계산
	var result5 = Math.floor((price-result3)/month);
	$('#result5').val(result5);
	new numberCounter("result5",result5);
};
