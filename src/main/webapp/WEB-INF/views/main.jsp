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

<script type="text/javascript">
	function loadJSON(path, success, error) {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState === XMLHttpRequest.DONE) {
				if (xhr.status === 200) {
					if (success)
						success(JSON.parse(xhr.responseText));
				} else {
					if (error)
						error(xhr);
				}
			}
		};
		xhr.open("GET", path, true);
		xhr.send();
	}
</script>
</head>

<body background="">
	<div id="header">
		<h1 align="center">Kickstarter</h1>
	</div>

	<div id="response">
		<p id="quoteText" align="center"></p>
	</div>
	<div id="categories" align="center">
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
		var allQuotes = [ "Do It" ];

		getAllQuotes();
		nextQuote();
		setInterval(nextQuote, 10000);

		function nextQuote() {
			var textField = document.getElementById("quoteText");
			textField.innerHTML = allQuotes[Math.floor(Math.random()
					* (allQuotes.length))];
		}
		function getAllQuotes() {
			loadJSON('v1/quote/getAll', function(data) {
				for (var index = 0; index < data.length; index++) {
					allQuotes[index] = data[index].text;
				}
			}, function(xhr) {
				console.error(xhr);
			});
		}
	</script>
	<script>
		loadJSON('v1/category/getAll', function(data) {
			addCategoryName(data);
		}, function(xhr) {
			console.error(xhr);
		});

		function addCategoryName(data) {
			for (var index = 0; index < data.length; index++) {
				var tableField = document
						.getElementById("0" + index.toString());
				tableField.innerHTML = data[index].name;
			}
		}
	</script>
</body>
</html>