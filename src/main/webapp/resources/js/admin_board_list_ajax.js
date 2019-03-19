$(function() {
	
	//subject_ajax('admin_board.bo');
	
	$('#subject').change(function(){
		var val = $(this).val();
		if(val == 'all') {
			subject_ajax('admin_board.bo?type=all');
		} else if (val == 'q') {
			subject_ajax('admin_board.bo?type=q');
		} else if (val == 'a') {
			subject_ajax('admin_board.bo?type=a');
		} else {
			alert('문제 발생');
		}
	});
});

function subject_ajax(url) {
	$.ajax({
		type : "post",
		data : {"state" : "ajax"},
		url : url,
		success : function(data){
			$(".list_category").empty().prepend(data);
		},
		error : function(data){
			alert("에러 발생");
		}
	});
}