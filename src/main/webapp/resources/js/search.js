	
	function AddComma(data_value){
		return Number(data_value).toLocaleString('en');
	}
	
$(document).ready(function(){
	
	// 클래스 뽑아오는 ajax
	$.ajax({
	    url : './selectCarclass.drv',
	    type : 'POST', 
	    cashe : false, 
	    success : function(rdata) {
	    		var output = ' ' ;
	          $(rdata).each(function (index, item) {
	             output += "<option value='" + item.car_class + "'>"+item.car_class+"</option>";
	          });
	          $('#select_car_class').append(output);
	    },
	    error : function() {
	       alert('carclass error');
	    }
	 });
	
	
	/*search_list > price*/
	$(".price").each(function(index,item){
		var comma = AddComma($(this).html())
		$(this).html("₩"+comma)
	})
	
	/*search_detail > price*/
	var comma = AddComma($(".detail_price").html())
	$(".detail_price").html("₩"+comma)
	
	/* 더보기 */
	var list_count = $(".search_list").length;
	if(list_count < 9){
		$("#view_more").css("display","none");
		$(".search_list:hidden").show();
	} else {
		$(".search_list").slice(0,9).show();
		$("#load").click(function(){
			$(".search_list:hidden").slice(0,9).show();
			if($(".search_list:hidden").length == 0){
				$("#load").hide();
			}
		})
	}
	
})


 