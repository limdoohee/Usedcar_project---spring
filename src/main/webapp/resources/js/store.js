function search_location(){
	
	var searchType = $('input[name="searchType"]:checked').val();
	var searchCity = $('#searchCity').val();
	var search_text = $('#search_text').val();
	var url = "store_search.str?searchType="+searchType+"&searchCity="+searchCity+"&search_text="+search_text;
	
	$.ajax({
		
		data : {},
		url : url,
		dataType : "html",
		success : function(data){
			
			$(".add").empty().append(data);
			
			if (searchType == '2'){
				
				$('input:radio[name="searchType"][value="2"]').prop("checked", true);
				$('#search_select_wrap').hide();
				$('#search_text_wrap').show();
			}
			
		},
		error : function(jqXHR, textStatus, errorThrown){
			
			alert("status: " + jqXHR.status );
			alert("statusText: " + jqXHR.statusText );
			alert("responseText: " + jqXHR.responseText );
			alert("errorThrown: " + errorThrown);
		}
	})
	
	
}

$(function(){
	
	$('input[name=searchType]').change (function(){
			var st = $(this).val();
			if (st == '1'){
				$('#search_select_wrap').show();
				$('#search_text_wrap').hide();
			} 
			else if (st == '2'){
				$('#search_select_wrap').hide();
				$('#search_text_wrap').show();
			}
	});
	
		$('.page_on').click(function(){
			
			var page = $(this).text();
			$('#page_vlaue').val(page);
			var url  = "store_show.str?page="+page;
			
			$.ajax({
				
				type : "post",
				data : {"state" : "ajax"},
				url : url,
				success : function(data){
				
					$("#store").empty().prepend(data);
					
				},
				error : function(data){
					
					alert("에러 발생");
				}
			})
			
		});
		
		$('.page_before').click(function(){
			var page = $('#page_vlaue').val();
			var page_before = page - 1;
			$('#page_vlaue').val(page_before);
			
			var url1 = "store_show.str?page="+page_before;
			
			$.ajax({
				
				type : "post",
				data : {"state" : "ajax"},
				url : url1,
				success : function(data){
					
					$("#store").empty().prepend(data);
					
				},
				error : function(data){
					
					alert("에러 발생");
				}
			});
			
		})
		
		$('.page_after').click(function(){
			
			var page = parseInt($('#page_vlaue').val());
			
			var page_after = page + 1;
			
			$('#page_vlaue').val(page_after);
			
			var url2 = "store_show.str?page="+page_after;
			
			$.ajax({	
				
				type : "post",
				data : {"state" : "ajax"},
				url : url2,
				success : function(data){
					
					$("#store").empty().prepend(data);
					
				},
				error : function(data){
					
					alert("에러 발생");
				}
			});
			
		})
		
		$('.search_on').click(function(){
			
			var page = $(this).text();
			$('#page_vlaue').val(page);
			var searchType = $('input[name="searchType"]:checked').val();
			var searchCity = $('#searchCity').val();
			var search_text = $('#search_text').val();
			var url  = "store_search.str?page="+page+"&searchType="+searchType+"&searchCity="+searchCity+"&search_text="+search_text;
			
			$.ajax({
				
				data : {"state" : "ajax"},
				url : url,
				success : function(data){
				
					$(".add").empty().append(data);
					
				},
				error : function(jqXHR, textStatus, errorThrown){
					
					alert("status: " + jqXHR.status );
					alert("statusText: " + jqXHR.statusText );
					alert("responseText: " + jqXHR.responseText );
					alert("errorThrown: " + errorThrown);
				}
			})
		})
		
		$('.search_before').click(function(){
			
			var page = $('#page_vlaue').val();
			var page_before = page - 1;
			$('#page_vlaue').val(page_before);
			var searchType = $('input[name="searchType"]:checked').val();
			var searchCity = $('#searchCity').val();
			var search_text = $('#search_text').val();
			var url  = "store_search.str?page="+page_before+"&searchType="+searchType+"&searchCity="+searchCity+"&search_text="+search_text;
			
			$.ajax({
							
				data : {"state" : "ajax"},
				url : url,
				success : function(data){
				
					$(".add").empty().append(data);
					
				},
				error : function(jqXHR, textStatus, errorThrown){
					
					alert("status: " + jqXHR.status );
					alert("statusText: " + jqXHR.statusText );
					alert("responseText: " + jqXHR.responseText );
					alert("errorThrown: " + errorThrown);
				}
			})
		});
		
		$('.search_after').click(function(){
			
			var page = parseInt($('#page_vlaue').val());
			var page_after = page + 1;
			$('#page_vlaue').val(page_after);
			var searchType = $('input[name="searchType"]:checked').val();
			var searchCity = $('#searchCity').val();
			var search_text = $('#search_text').val();
			var url  = "store_search.str?page="+page_after+"&searchType="+searchType+"&searchCity="+searchCity+"&search_text="+search_text;
			
			$.ajax({
				
				data : {"state" : "ajax"},
				url : url,
				success : function(data){
				
					$(".add").empty().append(data);
					
				},
				
				error : function(jqXHR, textStatus, errorThrown){
					
					alert("status: " + jqXHR.status );
					alert("statusText: " + jqXHR.statusText );
					alert("responseText: " + jqXHR.responseText );
					alert("errorThrown: " + errorThrown);
				}
				
			})
			
		});
		
		// 지도 클릭 이벤트
			$('.store_map').click(function(){
				var idx = $(".store_map").index(this);
				var map = $(".store_map").eq(idx).text();
				var location = $(".location").eq(idx).val();
				
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
					    center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					    level: 4 // 지도의 확대 레벨
					};
				
						//지도를 생성합니다    
					var map = new daum.maps.Map(mapContainer, mapOption); 
						//주소-좌표 변환 객체를 생성합니다
					var geocoder = new daum.maps.services.Geocoder();
						//주소로 좌표를 검색합니다
					geocoder.addressSearch(location, function(result, status) {
						// 정상적으로 검색이 완료됐으면 
					 if (status === daum.maps.services.Status.OK) {
						    var coords = new daum.maps.LatLng(result[0].y, result[0].x);
						    // 결과값으로 받은 위치를 마커로 표시합니다
					    var marker = new daum.maps.Marker({
					        map: map,
					        position: coords,
					    });
						    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					    map.setCenter(coords);
					} 
				});
	
			})	// click end
			
	});
