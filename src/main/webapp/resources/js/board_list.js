$(function() {
	//$('#board_list').empty();
 	//selectData('./board_list.bo', null);
});

//게시판 리스트를 가져오는 ajax
function selectData(url,page){
	//Ajax를 수행합니다.
	$.ajax({
		url : url,  //실행 안되면 경로 확인
		data: page,
		dataType : 'json', //return형
		success : function(rdata){
			var output = '';
			$(rdata).each(function(index, item){
				output += '<tr>';
				output += '		<td>' + item.id + '</td>';
				output += '		<td>' + item.name + '</td>';
				output += '		<td>' + item.modelnumber + '</td>';
				output += '		<td>' + item.series + '</td>';
				output += '</tr>';
			});
			$('#board_list').append(output);
		}
	});//ajax end
};//function end
