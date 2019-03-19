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
			    		var select = ' ' ;
			    		var output=' ';
			    		select += "<option value='allselect'>전체선택</option>";
			          $(rdata).each(function (index, item) {
			        	  select += "<option value='" + item.car_model + "'>"+item.car_model+"</option>";
			        	  output += "<li rel='"+item.car_model+"'>"+item.car_model+"</li>";
			          });
			          $('#select_car_model').html(select);
			          $('#car_model .select-options').html(output);
			          console.log("model 완료");
			    },
			    error : function() {
			       alert('carmodel error');
			    }
			})
		})