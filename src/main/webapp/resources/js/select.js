
function searchload(){
	var $select = $("#research_wrap").find("select");
	$select.each(function(){
		
	    var $this = $(this), numberOfOptions = $(this).children('option').length;
	  	
	    $this.addClass('select-hidden'); 
	    $this.wrap('<div class="select"></div>');
	    $this.after('<div class="select-styled"></div>');
		
	    var $styledSelect = $this.next('div.select-styled');
	    $styledSelect.text($this.children('option').eq(0).text());
	  
//		    var name_value = $this.next('div.select-styled').html();
//	 	    var $optionName = $this.before('<div class="option-name">'+name_value+'</div>');
	    
	    var $list = $('<ul />', {
	        'class': 'select-options'
	    }).insertAfter($styledSelect);
	  
	    for (var i = 0; i < numberOfOptions; i++) {
	        $('<li />', {
	            text: $this.children('option').eq(i).text(),
	            rel: $this.children('option').eq(i).val()
	        }).appendTo($list);
	    }
	  
	    var $listItems = $list.children('li');
	  
	    $styledSelect.click(function(e) {
	        e.stopPropagation();
//		        $('div.select-styled.active').not(this).each(function(){
//		            $(this).removeClass('active').next('ul.select-options').hide();
//		        });
	        $(this).toggleClass('active').next('ul.select-options').toggle();
	    });
	    
	    $listItems.click(function(e) {
	        e.stopPropagation();
	        //$styledSelect.text($(this).text()).removeClass('active');
	        $this.prev(".option-name").css("visibility","visible")
	        $this.val($(this).attr('rel'));
	        $(this).addClass('selected_li');
	        $listItems.not(this).removeClass('selected_li');
	        //$list.hide();
	    });
	});

	

	  var car_model = '';
	   var $car_class_list = $("#car_class .select-options li")
		$car_class_list.click(function(){
			var carclass = $(this).text();
			// 모델 뽑아오는 ajax
			$.ajax({
			    url : './selectCarmodel.drv',
			    type : 'POST', 
			    cashe : false, 
			    data : {"carclass" : carclass},
			    success : function(rdata) {
			    		var select = '<option value="hide">전체선택</option>' ;
			    		var output='<li rel="hide">전체선택</li>';
			          $(rdata).each(function (index, item) {
			        	  select += "<option value='" + item.car_model + "'>"+item.car_model+"</option>";
			        	  output += "<li rel='"+item.car_model+"'>"+item.car_model+"</li>";
			          });
			          $('#select_car_model').html(select);
			          $('#car_model .select-options').html(output);
			          
			          var $car_model_list = $("#car_model .select-options li");
			  		$car_model_list.on("click",function(){
			  			 $(this).addClass('selected_li');
			  			$car_model_list.not(this).removeClass('selected_li');
//			  			var $carmodel = $("#car_model > .yellow");
//			  			alert($carmodel.text())
			  			car_model = $(this).text();
			  			$("#select_car_model").val( car_model ).prop('selected', true);
			  		})
			    },
			    error : function() {
			       alert('carmodel error');
			    }
			})
		})
		
		// 유효성
	$(".search_list").click(function(){
		var $find = $("#car_class > div.select > ul > li")
		if($find.hasClass("selected_li") === false){
			alert("클래스를 선택해주세요");
			return false;
		}
	})

}