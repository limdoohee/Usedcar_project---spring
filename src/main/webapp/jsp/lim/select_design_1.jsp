<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<script src="../../resources/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="../../resources/js/vendor/jquery-ui.min.js"></script>
	<script src="../../resources/js/jquery-3.3.1.js"></script>
	<script>
	$(function(){
	$('select').each(function(){
		
	    var $this = $(this), numberOfOptions = $(this).children('option').length;
	  	
	    $this.addClass('select-hidden'); 
	    $this.wrap('<div class="select"></div>');
	    $this.after('<div class="select-styled"></div>');
		
	    var $styledSelect = $this.next('div.select-styled');
	    $styledSelect.text($this.children('option').eq(0).text());
	  
	    var name_value = $this.next('div.select-styled').html();
 	    var $optionName = $this.before('<div class="option-name">'+name_value+'</div>');
	    
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
// 	        $('div.select-styled.active').not(this).each(function(){
// 	            $(this).removeClass('active').next('ul.select-options').hide();
// 	        });
	        $(this).toggleClass('active').next('ul.select-options').toggle();
	    });
	    
	    $listItems.click(function(e) {
	        e.stopPropagation();
	        $styledSelect.text($(this).text()).removeClass('active');
	        $this.prev(".option-name").css("visibility","visible")
	        $this.val($(this).attr('rel'));
	        $(this).addClass('yellow');
	        $listItems.not(this).removeClass('yellow');
	        //$list.hide();
	    });
	})
	})
	</script>
<style>
body{
background:#000;
}
.option-name{
visibility:hidden;
transition:1s;
}
/* width */
::-webkit-scrollbar {
  width: 10px;
}

/* Track */
::-webkit-scrollbar-track {
  background: #f1f1f1; 
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: #888; 
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #555; 
}
.yellow{
color:yellow;
}
.select-hidden {
  display: none;
  visibility: hidden;
  padding-right: 10px;
}
.select {
    cursor: pointer;
    position: relative;
    font-size: 16px;
    color: #fff;
    width: 220px;
    height: 40px;
    display: table;
        margin-bottom: 3%;
}

.select-styled {
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-color: #c0392b;
  padding: 8px 15px;
  -moz-transition: all 0.2s ease-in;
  -o-transition: all 0.2s ease-in;
  -webkit-transition: all 0.2s ease-in;
  transition: all 0.2s ease-in;
}
.select-styled:after {
  content: "";
  width: 0;
  height: 0;
  border: 7px solid transparent;
  border-color: #fff transparent transparent transparent;
  position: absolute;
  top: 31px;
  right: 10px;
}
.select-styled:hover {
  background-color: #b83729;
}
.select-styled:active, .select-styled.active {
  background-color: #ab3326;
}
.select-styled:active:after, .select-styled.active:after {
  top: 24px;
  border-color: transparent transparent #fff transparent;
}

.select-options {
    display: none;
    margin: 0;
    padding: 0;
    list-style: none;
    background-color: #ab3326;
    overflow-y: scroll;
    height: 200px;	/* 스크롤 창 높이 */
}
.select-options li {
  margin: 0;
  padding: 12px 0;
  text-indent: 15px;
  border-top: 1px solid #962d22;
  -moz-transition: all 0.15s ease-in;
  -o-transition: all 0.15s ease-in;
  -webkit-transition: all 0.15s ease-in;
  transition: all 0.15s ease-in;
}
.select-options li:hover {
  color: #c0392b;
  background: rgba(255,255,255,0.4);
}
.select-options li[rel="hide"] {
  display: none;
}

</style>
</head>
<body>
<form method="post" action="search.test">
<select id="month" name="month">
    <option value="hide">-- Month --</option>
    <option>January</option>
    <option >February</option>
    <option >March</option>
    <option>April</option>
    <option>May</option>
    <option>June</option>
    <option>July</option>
    <option>August</option>
    <option>September</option>
    <option>October</option>
    <option>November</option>
    <option>December</option>
</select> 

<select id="year" name="year">
    <option value="hide">-- Year --</option>
    <option value="2010">2010</option>
    <option value="2011">2011</option>
    <option value="2012">2012</option>
    <option value="2013">2013</option>
    <option value="2014">2014</option>
    <option value="2015">2015</option>
</select>
<input type="submit" value="검색">
</form>
</body>
</html>