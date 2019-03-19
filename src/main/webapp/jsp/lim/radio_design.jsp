<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
/**
 * Basic stuff - not really radio style related
 */
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);
html {
  box-sizing: border-box;
  font-size: 95%;
  line-height: 1.5;
  font-family: 'Open Sans',sans-serif;
  background: #e0758e;
  color: #333;
  text-align: center;
}

*, *:before, *:after {
  box-sizing: inherit;
}

.box {
  width: 100%;
  max-width: 400px;
  margin: 2rem auto;
  background: white;
  border: 1px solid white;
  border-radius: 3px;
  text-align: left;
}

/*****
 *
 * Radio checked style related
 * the fun part starts here
 *
 */
input[type=radio] {
  display: none;
}

/**
 * How it should look when hovered
 */
.active-label, label:focus, label:hover, label:active, input:checked + label {
  color: #e0758e;
}
.active-label:before, label:focus:before, label:hover:before, label:active:before, input:checked + label:before {
  background: white;
  border-color: #e0758e;
}

/**
 * Make those labels sexy
 */
label {
  font-size: 1rem;
  font-weight: bold;
  line-height: 1;
  cursor: pointer;
  display: block;
  padding: 1rem 1rem 1rem 3rem;
  position: relative;
  border-top: 1px solid rgba(0, 0, 0, 0.1);
  background: white;
  whitespace: no-wrap;
  overflow: hidden;
  text-overflow: ellipsis;
  transition: all .15s ease;
  /**
   * This is the radio fake dot basically
   */
}
label:first-of-type {
  border: 0;
}
label:before {
  content: "";
  position: absolute;
  left: 1rem;
  top: 1rem;
  width: 16px;
  height: 16px;
  border-radius: 50%;
  border: .2rem solid #ccc;
}

/**
 * How it should look when checked
 */
input:checked + label:before {
  border-color: white;
  border: none;
  background: #e0758e;
}

/**
 * How it should look when disabled
 */
input:disabled + label {
  background: #efefef;
  color: rgba(0, 0, 0, 0.5);
  cursor: not-allowed;
}
input:disabled + label:hover {
  border-color: rgba(0, 0, 0, 0.1);
}
input:disabled + label:before {
  border-color: white;
  background: white;
}

</style>
</head>
<body>
<div class="box">
  <input type="radio" id="radio1" name="radio1"/>
  <label for="radio1">Crazy Option</label>

  <input type="radio" id="radio2" name="radio1"/>
  <label for="radio2">Freaky Option</label>

  <input type="radio" id="radio3" name="radio1"/>
  <label for="radio3">Cat Option</label>

  <input type="radio" id="radio4" name="radio1"/>
  <label for="radio4">Not an option</label>
</div>
</body>
</html>