
var now = new Date();
var week = 0;
var endDay = 0;
var plusmonth = 0;
var carno = '';
var dealerid = '';
var lastflag = false;
	
function dateSetting(plus) {
//	now = new Date();
	week = new Date(now.getFullYear(), now.getMonth()+plus, 1).getDay(); // 시작요일저장 (일-토 : 0-6)
	endDay = new Date(now.getFullYear(), now.getMonth()+1+plus, 0).getDate(); //말일저장
}

function setCurrentMonth(plus) {
	dateSetting(plus);
	
	var firstDayOfWeek = week == 0 ? 7 : week;
    var weekSeq = parseInt((parseInt(endDay) + week - 1)/7) + 1;
    var endWeekDay = new Date(now.getFullYear(), now.getMonth()+1+plus, 0).getDay();	//마지막 날 요일

	var output = '';
	output += '<tr>';
	for(var i = 1; i <= week; i++) {
		output += '<td></td>';
	}
	var j = 1;
	for(var i = 1; i <= endDay; i++) {			
		if(i <= now.getDate() && !lastflag) {
			if(i < 10) i = '0'+ i;
			output += "<td class='datetd" + i + " disabled" + "'><span>" + i + "</span>";
		} else {
			if(i < 10) i = '0'+ i;
			output += "<td class='datetd" + i + "'><span>" + i + "</span>";
		}
		output += '<div><ul>';
		output += '<li><label class="label--radio"><input type="radio" name="scheduleradio" class="radio" id="dateam' + i + '"><span>오전</span></label></li>';
		output += '<li><label class="label--radio"><input type="radio" name="scheduleradio" class="radio" id="datepm' + i + '"><span>오후</span></label></li>';
		output += '</ul></div></td>';
		if(i % 7 == 7 - week) {
			output += '</tr><tr>';
			++j;
		}
	}
	if(j == weekSeq) {
		for(var k = 0; k < 7 - (endWeekDay + 1); k++) {
			output += '<td></td>';
		}
	}
	output += '</tr>';
    $('#calendar').append(output);
    if(plus == 0) {
    	$(".disabled > div").css("visibility","hidden");
    }
    
    var $disabled_label =$("input[type=radio]:disabled").parent(".label--radio");
	$disabled_label.css("text-decoration","line-through");
    
	
	
	
	$(".label--radio").click(function(){
		var flag = $(this).children()[0].checked;
		if(flag) {
			$("#select_privacy").hide();
			$("#privacy_wrap").show();
		} else {
			$("#select_privacy").show();
			$("#privacy_wrap").hide();
		}
	})
}

function CalendarDisabled(plus) {
	if(plus == 0) {
        var disabled = $('.disabled')
        var input = $('.disabled > div > ul > li > input') 
        for(i = 1; i <= now.getDate(); i++) {
			if(i <= now.getDate()){
				disabled.css('background','lightgray');
				input.prop('disabled', true);
			}
        }
	} else {
		var endDay = new Date(now.getFullYear(), now.getMonth()+1+plus, 0).getDate(); //말일저장
		for(var i = 0; i <= endDay; i++) {
			var $pmonth = $('td.datetd' + i + ' > div > ul > li > input');
			$pmonth.prop('disabled', false);
			$pmonth.prop('checked', false);
		}
	}
}

function getDrivedate(carno) {
	$.ajax({
		url : './getDrivedate.drv',
		data : {'car_no' : carno },
		type : 'POST', 
		cashe : false, 
		success : function(rdata) {
	        var endDay = new Date(now.getFullYear(), now.getMonth()+1+plusmonth, 0).getDate(); //말일저장
	        
	        for(var i = 0; i <= endDay; i++) {
	        	if(i < 10) i = '0'+ i;
	            var $select = $('td.datetd' + i + ' > div > input')
	        	if(i > now.getDate()) {
	        		$select.prop('disabled', false);
	        		$select.prop('checked', false);
	        		
	        		var $disabled_label =$(":disabled");
	        	} 
	        }
			$(rdata).each(function (index, item) {
				$('#date' + item.date_ampm + item.date_date).prop('disabled', true);
            });
		},
		complete : function(){
    		var $disabled_label =$("input[type=radio]:disabled").parent(".label--radio");
    		$disabled_label.css("text-decoration","line-through");
		},		
		error : function() {
			alert('getDate error');
		}
	});
}

function cmodelClick(e) {
	var idx = $(".classmodel").index(e);
	var a = idx + 3;
	var $notthis = $("#drivelist > li:nth-child("+a+")").find(".dealerinfo");
	dealerid = $('.dealerid').eq(idx).val();
	carno = $('.carno').eq(idx).val();
	var month = now.getMonth() + 1;
	$("#select_calendar").hide();
	
	var $carlist = $('.dealerinfo').eq(idx);
	$notthis.addClass('choice');
	$('.choice').show();
    $(".dealerinfo").not($notthis).hide();
	$('.dealerinfo').not($notthis).removeClass('choice');
	//$('#drivelist_wrap #drivelist li').css("","");
	$('#calendar').empty();
	$('#calendar_wrap').show();
	$('#currentMonth').html(now.getFullYear() + "."+(month < 10 ? ' 0' + month : month));
	plusmonth = 0;
	setCurrentMonth(plusmonth);
    CalendarDisabled(plusmonth);
	getDrivedate(carno);	
}

function pageonClick(e) {
	var cclass = $('#carclass').val();
	var cmodel = $('#carmodel').val();
	var stloc1 = $('#storeloc1').val();
	var stloc2 = $('#storeloc2').val();
	
	var page = e;
	var url  = "driveCarlist.drv?page="+page;
	
	$.ajax({
		type : "post",
		data : {'cclass' : cclass, 'cmodel' : cmodel,
				'stloc1' : stloc1, 'stloc2' : stloc2,
				'state' : 'ajax' },
		url : url,
		success : function(rdata){
			$("#driveformli1").empty().prepend(rdata);
		},
		error : function(data){
			alert("에러 발생");
		}
	});
}

$(function() {
	searchCarClass();
	initCalendar();
	
	endDay = new Date(now.getFullYear(), now.getMonth()+1+plusmonth, 0).getDate(); //말일저장
	if(now.getDate() == endDay) {
		now.setDate(now.getDate() + 1);
		lastflag = true;
	}
	
	function initCalendar() {
		$('#drivelist_wrap').hide();
		$('#calendar_wrap').hide();
		$("#privacy_wrap").hide();
	}
	
	$('#preMonth').click(function() {
		var month = now.getMonth() + 1;
		if(carno == '') {
			alert('시승을 원하는 차종을 검색하세요.');
			return;
		}
		if(plusmonth == 0) {
			alert('이 전 조회가 불가능합니다.');
			return;
		} else {
			plusmonth = 0;
			$('#calendar').empty();
			$('#currentMonth').html(now.getFullYear() + "."+ (month < 10 ? ' 0' + month : month));
			setCurrentMonth(plusmonth);
	        CalendarDisabled(plusmonth);
	        getDrivedate(carno);
		}
	});

	$('#nextMonth').click(function() {
		var month = now.getMonth() + 2;
		if(carno == '') {
			alert('시승을 원하는 차종을 검색하세요.');
			return;
		}
		if(plusmonth == 1) {
			alert('이 후 조회가 불가능합니다.');
			return;
		} else {
			plusmonth = 1;
		}
        $('#calendar').empty();
        $('#currentMonth').html(now.getFullYear() +  "."+(month < 10 ? ' 0' + month : month));
		setCurrentMonth(plusmonth);
        CalendarDisabled(plusmonth);
        getDrivedate(carno);
        
        $("#calendar > tr> td").removeClass(".disabled");
	});
	
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
//	
	$('#carclass').change(function() {
		$('.selectopt').empty().append("<option value=''>선택</option>");
		$('.dealer_info').val('');
		searchCarmodel();
		searchStoreLoc1();
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
	
	$('#carmodel').change(function() {
		$('#storeloc1').empty().append("<option value=''>선택</option>");
		$('#storeloc2').empty().append("<option value=''>선택</option>");
		$('.dealer_info').val('');
		searchStoreLoc1();
	});
	
	function searchStoreLoc1() {
		$.ajax({
			url : './selectStoreLoc1.drv',
			data : {'cclass' : $('#carclass').val(), 'cmodel' : $('#carmodel').val() },
			type : 'POST', 
			cashe : false, 
			success : function(rdata) {
				var output = '';
	            $(rdata).each(function (index, item) {
	            	output += "<option value='" + item.store_location + "'>";
	            	output += item.store_location;
	            	output += '</option>';
	            });
	            $('#storeloc1').append(output);
			},
			error : function() {
				alert('storeloc1 error');
			}
		});
	}
	
	$('#storeloc1').change(function() {
		$('#storeloc2').empty().append("<option value=''>선택</option>");
		$('.dealer_info').val('');
		if($(this).val() != '') {
			searchStoreLoc2();
		}
	});
	
	function searchStoreLoc2() {
		$.ajax({
			url : './selectStoreLoc2.drv',
			data : {'cclass' : $('#carclass').val(), 'cmodel' : $('#carmodel').val(),
					'stloc1' : $('#storeloc1').val() },
			type : 'POST', 
			cashe : false, 
			success : function(rdata) {
				var output = '';
	            $(rdata).each(function (index, item) {
	            	output += "<option value='" + item.store_location + "'>";
	            	output += item.store_location;
	            	output += '</option>';
	            });
	            $('#storeloc2').append(output);
			},
			error : function() {
				alert('storeloc2 error');
			}
		});
	}
	
	$('#searchbtn').click(function() {
		var cclass = $('#carclass').val();
		var cmodel = $('#carmodel').val();
		var stloc1 = $('#storeloc1').val();
		var stloc2 = $('#storeloc2').val();
		var month = now.getMonth() + 1;
		
		if(cclass == '') {
			alert('클래스를 선택하세요');
			return false;
		}
		$.ajax({
			url : './driveCarlist.drv',
			data : {'cclass' : cclass, 'cmodel' : cmodel,
					'stloc1' : stloc1, 'stloc2' : stloc2,
					'state' : 'ajax' },
			type : 'POST', 
			cashe : false, 
			success : function(rdata) {
				$("#select_car").hide();
				$('#driveformli1').show();
				$('#drivelist_wrap').show();
//				$('#drivelist').empty().prepend(rdata);
				$('#driveformli1').empty().prepend(rdata);

				$('#calendar_wrap').hide();
				$('#select_calendar').show();
				$('#privacy_wrap').hide();
				$('#select_privacy').show();
//				$('#calendar').empty();
				carno = '';
			},
			error : function() {
				alert('drive error');
			}
		});		
	})
	
	$('.drvname').keyup(function() {
		$(this).val( $(this).val().replace(/[^a-zA-Z가-힣]/g, ''));
	});
	
	$('.drvphone').keyup(function() {
		$(this).val( $(this).val().replace(/[^0-9]/g,'') );
	});

	$('#drivebtn').click(function() {
		
		var scheduleCheck = $('input:radio[name=scheduleradio]:checked');
		var drivename = $('#drive_name').val();
		var drivephone = $('#drive_phone1').val() + '-' + $('#drive_phone2').val() + '-' + $('#drive_phone3').val();
		
		if(carno == '') {
			alert('시승을 원하는 차종을 선택하세요.');
			return;
		} else if(scheduleCheck.length == 0) {
			alert('시승을 원하는 날짜를 선택하세요');
			return;
		} else if(drivename == '' || drivephone == '') {
			alert('개인정보를 입력하세요');
			return;
		}
		
		var dateid = scheduleCheck[0].id;
		var month = '' + (now.getMonth() + 1);
		
		if(plusmonth != 0) {
			month = '' + (now.getMonth() + 1 + plusmonth);
		}
		var	day = '' + dateid.substr(6,2), 
			year = now.getFullYear();
		
		if (month.length < 2) month = '0' + month; 
		if (day.length < 2)	day = '0' + day;
		
		var drivedate = [year, month, day].join('-');
		console.log(dealerid)
		/*
		location.href='./insertDriveInfo.drv?car_no='+carno+'&dealer_id='+dealerid
		+'&drive_date='+drivedate+'&drive_ampm='+dateid.substr(4,2)
		+'&drive_name='+drivename+'&drive_phone='+drivephone;
*/
console.log(carno);
		$.ajax({
			url : './insertDriveInfo.drv',
			data : {'car_no' : carno, 'dealer_id' : dealerid,
					'drive_date' : drivedate, 'drive_ampm' : dateid.substr(4,2),
					'drive_name' : drivename, 'drive_phone' : drivephone },
			type : 'POST', 
			cashe : false, 
			success : function(rdata) {
				console.log(rdata)
				$('#select_wrap').empty();
				$('#driveformli1').empty();
				$('#driveformli2').empty();
				$('#driveformli3').empty();
				$('#driveform').hide();
				$('#afterdrive').show();
				
				var output = '';
            	output += '<div><span>차 정보</span>';
            	output += '		<ul class="driveinfo_innerul">';
            	output += '				<li>' + rdata.car_class + '</li>';
            	output += '				<li>' + rdata.car_model + '</li>';
            	output += '				<li>' + rdata.dealer_name + '</li>';
            	output += '				<li>' + rdata.dealer_phone + '</li>';
            	output += '		</ul>';
            	output += '</div>';
            	output += '<div><span>전시장 정보</span>';
            	output += '		<ul class="driveinfo_innerul">';
            	output += '				<li>' + rdata.store_name + '</li>';
            	output += '				<li>' + rdata.store_location + '</li>';
            	output += '		</ul>';
            	output += '</div>';
            	output += '<div><span>신청자 정보</span>';
            	output += '		<ul class="driveinfo_innerul">';
            	output += '				<li>' + rdata.drive_name + '</li>';
            	output += '				<li>' + rdata.drive_phone + '</li>';
            	output += '				<li>' + rdata.drive_date + '  ' + rdata.drive_ampm + '</li>';
            	output += '		</ul>';
            	output += '</div>';
	            $('#driveinfo').append(output);
			},
			error : function() {
				alert('driveinsert error');
			}
		});
	});
	
	$('#godrive').click(function() {
		location.reload();
	});

});