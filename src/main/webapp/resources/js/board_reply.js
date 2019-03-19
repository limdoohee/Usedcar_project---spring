/**
 * 
 */

//저장버튼 클릭시 form 전송
function check() {
	if ($.trim($('#car_no').val()) == '') {
		alert('신고할 차량을 선택해주세요.');
		$('#findcar_btn').focus();
		return false;
	}
	else if ($.trim($('#subject').val()) == '') {
		alert('글 제목을 입력해주세요.');
		$('#subject').focus();
		return false;
	}/* else if ($.trim($('.se2_inputarea').html()) == '') {
		alert('글 내용을 입력해주세요.');
		$('#change_content').focus();
		return false;
	}*/
	
    oEditors.getById["change_content"].exec("UPDATE_CONTENTS_FIELD", []);
    $("#form1").submit();
};
var oEditors = []; 
$(function() {
	$('#car_choice').hide();
	
   nhn.husky.EZCreator.createInIFrame({ 
      oAppRef : oEditors, 
      elPlaceHolder : "change_content",          
      sSkinURI : "resources/editor/SmartEditor2Skin.html",   //SmartEditor2Skin.html 파일이 존재하는 경로   
      htParams : {                
         bUseToolbar : true,                  // 툴바 사용 여부 (true:사용/ false:사용하지 않음)    
         bUseVerticalResizer : true,            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
         bUseModeChanger : true,               // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
         fOnBeforeUnload : function() {
            
         } 
      }, 
      fOnAppLoad : function(){       //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용 
         oEditors.getById["change_content"].exec("PASTE_HTML", [""]); 
      },
      fCreator: "createSEditor2"
   });

});

function car_check() {
	window.open('car_find.bo','허위매물 차량 검색','width=950,height=650,scrollbars=yes');
}


//첨부파일 변경 시
$(function() {
	
	$('#close').click(function() {
		$('#filevalue').html('');
		$('#DBoriginal').remove();
		$("#close").hide();
	});
	
	$("#upfile").on("change", function(){
		var fileName =  $(this).val().split("\\");
		$('#DBoriginal').val(fileName[fileName.length-1]);
		$('#filevalue').html(fileName[fileName.length-1]);
		$("#close").show();
	});
	if($("#filevalue").text()==""){
		  $("#close").hide();
	  }
});