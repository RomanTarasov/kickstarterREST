<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Main</title>
<style>
body {
	
}

div#header {
	width: auto;
	height: 86px;
	background-color: menu;
	font-size: medium;
}

div#response {
	width: auto;
	height: 86px;
	background-color: menu;
	font-size: x-large;
}

td {
	width: 94px;
	height: 30px;
	background-color: menu;
	color: purple;
	font-size: large;
}
</style>

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.min.js"></script>

</head>

<body background="">
	<div id="header">
		<h1>Kickstarter</h1>
	</div>

	<div id="response">
		<p id="quoteText"></p>
	</div>
	<div id="categories">
		<table>
			<tr>
				<td id="00"></td>
				<td id="01"></td>
				<td id="02"></td>
				<td id="03"></td>
			</tr>
		</table>
	</div>
	<script>
		$.getJSON('v1/quote/getRandom', function(data) {
		
			addQuoteText(data);
		});
		function addQuoteText(data) {
			$('#quoteText').append("<p>" + data.text + "</p>");
		}
	</script>
	<script>
		$.getJSON('v1/category/getAll', function(data) {
			addCategoryName(data);
		});
		function addCategoryName(data) {
			for (var index = 0; index < data.length; index++) {
				$('#0' + index).append("<p>" + data[index].name + "</p>");
			}
		}
	</script>
</body>
</html>