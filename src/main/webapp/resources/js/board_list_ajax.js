
function page_Ajax(url) {
	$.ajax({
		
		type : "post",
		data : {"state" : "ajax"},
		url : url,
		success : function(data){
		
			$("#board_cont").empty().prepend(data);
			
		},
		error : function(data){
			
			alert("에러 발생");
		}
	});
};


$(function(){
	
	$('.board_page_on').click(function(){
		
		var page = $(this).text();
		$('#board_page_vlaue').val(page);
		var url  = "board_list.bo?page="+page;
		
		page_Ajax(url);
		
	});
	
	$('.board_page_before').click(function(){
			
		var page =  parseInt($('#board_page_vlaue').val());
		var page_before = page - 1;
		$('#board_page_vlaue').val(page_before);
		var url  = "board_list.bo?page="+page_before;
		
		page_Ajax(url);
			
	});
	
	//
	$('.board_page_after').click(function(){
		
		var page =  parseInt($('#board_page_vlaue').val());
		var page_after = page + 1;
		$('#board_page_vlaue').val(page_after);
		var url  = "board_list.bo?page="+page_after;
		
		page_Ajax(url);
		
	});
	
	$('.board_page_on_search').click(function(){
		var page = $(this).text();
		$('#board_page_vlaue').val(page);
		var search_option = $('#search_option option:selected').val();
		var search_keyword = $('#search_keyword').val();
		
		var url  = "board_search.bo?page="+page+"&search_option="+search_option+"&search_keyword="+search_keyword;
		
		
		page_Ajax(url);
		
	});
	
	$('.board_page_after_search').click(function(){
		var page =  parseInt($('#board_page_vlaue').val());
		var page_after = page + 1;
		$('#board_page_vlaue').val(page_after);
		var search_option = $('#search_option option:selected').val();
		var search_keyword = $('#search_keyword').val();
		
		var url  = "board_search.bo?page="+page_after+"&search_option="+search_option+"&search_keyword="+search_keyword;
		
		
		page_Ajax(url);
		
	});
	
	$('.board_page_before_search').click(function(){
		var page =  parseInt($('#board_page_vlaue').val());
		var page_before = page - 1;
		$('#board_page_vlaue').val(page_before);
		var search_option = $('#search_option option:selected').val();
		var search_keyword = $('#search_keyword').val();
		
		var url  = "board_search.bo?page="+page_before+"&search_option="+search_option+"&search_keyword="+search_keyword;
		
		page_Ajax(url);
		
	});
	
	// 게시글 검색
	$('#search_btn').click(function(){
		var search_option = $('#search_option').val();
		var search_keyword = $('#search_keyword').val();
		$.ajax({
			
			type : "post",
			data : {"search_option" : search_option,
				"search_keyword" : search_keyword},
			url : 'board_search.bo',
			success : function(data){
				$("#board_cont").empty().prepend(data);
			},
			error : function(data){
				
				alert("에러 발생");
			}
		})
	});
	
});