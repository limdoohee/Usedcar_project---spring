
	function pageonClick(e) {
		var cclass = $('#cclass').val();
		var cmodel = $('#cmodel').val();
		var carno = $('#carno').val();
		var page = e;
		
		$.ajax({
			url : './dealer_drive_manage.drv?page='+page,
			data : {'cclass' : cclass, 'cmodel' : cmodel,
					'carno' : carno, 'state' : 'ajax' },
			type : 'POST', 
			cashe : false, 
			success : function(rdata) {
				console.log(rdata)
//				$('#table_wrap').empty();
//				$('#paging_area').empty();
//				$('#table_wrap').append(rdata);

				$('#driveformul').empty().prepend(rdata);
			},
			error : function() {
				alert('drive error');
			}
		});
	}
	
	function submitClick(e) {
		var drvno = e;
		var result = confirm('시승 완료처리하시겠습니까?');
		
//		var $this = $(this).parent().parent();
//		var drvno = $this.find('#drvno').text();
		
		if(result) {
			$.ajax({
				url : './updateDriveComplete.drv',
				data : { 'drive_no' : drvno },
				type : 'POST', 
				cashe : false, 
				success : function(rdata) {
					location.reload();
				},
				error : function(jqXHR, textStatus, errorThrown){
					alert("status: " + jqXHR.status );
					alert("statusText: " + jqXHR.statusText );
					alert("responseText: " + jqXHR.responseText );
					alert("errorThrown: " + errorThrown);
				}
			});
		}
	}
	

$(function() {
	
	searchCarClass();

	function searchCarClass() {
		$.ajax({
			url : './selectCarclass.drv',
			type : 'POST', 
			cashe : false, 
			success : function(rdata) {
				var output = '';
	            $(rdata).each(function (index, item) {
	            	output += "<option value='" + item.car_class + "'>";
	            	output += item.car_class;
	            	output += '</option>';
	            });
	            $('#carclass').append(output);
			},
			error : function() {
				alert('carclass error');
			}
		});
	}

	$('#carclass').change(function() {
		$('.selectopt').empty().append("<option value=''>선택</option>");
		searchCarmodel();
	});
	
	function searchCarmodel() {
		$.ajax({
			url : './selectCarmodel.drv',
			data : {'carclass' : $('#carclass').val() },
			type : 'POST', 
			cashe : false, 
			success : function(rdata) {
				var output = '';
	            $(rdata).each(function (index, item) {
	            	output += "<option value='" + item.car_model + "'>";
	            	output += item.car_model;
	            	output += '</option>';
	            });
	            $('#carmodel').append(output);
			},
			error : function() {
				alert('carmodel error');
			}
		});
	}
	
	$('#searchbtn').click(function() {
		var cclass = $('#carclass').val();
		var cmodel = $('#carmodel').val();
		var carno = $('#car_no').val();
		$.ajax({
			url : './dealer_drive_manage.drv',
			data : {'cclass' : cclass, 'cmodel' : cmodel,
					'carno' : carno, 'state' : 'ajax' },
			type : 'POST', 
			cashe : false, 
			success : function(rdata) {
//				$('#table_wrap').show();
//				$('#table_wrap').empty();
//				$('#paging_area').empty();
//				$('#table_wrap').append(rdata);
				$('#driveformul').empty().prepend(rdata);
			},
			error : function() {
				alert('drive error');
			}
		});
	});
	
	/*
	$('.submit').click(function(e) {
		var result = confirm('시승 완료처리하시겠습니까?');
		var $this = $(this).parent().parent();
		var drvno = $this.find('#drvno').text();
		
		if(result) {
			$.ajax({
				url : './updateDriveComplete.drv',
				data : { 'drive_no' : drvno },
				type : 'POST', 
				cashe : false, 
				success : function(rdata) {
					location.reload();
				},
				error : function(jqXHR, textStatus, errorThrown){
					alert("status: " + jqXHR.status );
					alert("statusText: " + jqXHR.statusText );
					alert("responseText: " + jqXHR.responseText );
					alert("errorThrown: " + errorThrown);
				}
			});
		}
	});
	*/
});