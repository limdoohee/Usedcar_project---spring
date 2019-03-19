$(document).ready(function(){
	
	//#output 내부의 내용물을 제거합니다
	$('#output').empty();
	
	//데이터를 보여주는 함수
	function selectData(url, senddata){
		
		//ajax수행
		$.ajax({
			url: url,
			data: senddata,
			dataType : "json",
			type : "POST",
			cache : false,
			success : function(responsedata){
				$(responsedata).each(function(index, item){
					var	output ='';
					output += '<tr>';
					output += '    <td>' + item.no + '</td>';
					output += '    <td>' + item.temp_class + '</td>';
					output += '    <td>' + item.temp_model + '</td>';
					output += '    <td>' + item.temp_year + '</td>';
					output += '    <td>' + item.temp_distance + '</td>';
					output += '    <td>' + item.temp_accident + '</td>';
					output += '    <td>' + item.temp_color + '</td>';
					output += '    <td>' + item.temp_car_no + '</td>';
					output += '    <td>' + item.temp_name + '</td>';
					output += '    <td>' + item.temp_location + '</td>';
					output += '    <td>' + item.temp_phone + '</td>';
					output += '    <td>' + item.dealer_id + '</td>';
					output += '</tr>';
					$('#output').append(output);
					
				})//each end
				
			},//success end
			error : function(data){ //에러 시
				alert("오류발생");
			}
		})//ajax end
		
	}//funnction selectdata end
	
	//초기화면에 데이터를 표시합니다
	selectData('jsontestAll',null)//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ입력시 db에 들어간 데이터보여주는것이니
	//아직까진 굳이 필요없다
})//ready end