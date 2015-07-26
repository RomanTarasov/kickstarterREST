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

table#categories {
	background-color: navy;
}

#categories td {
	width: 94px;
	height: 30px;
	background-color: #E3CEF6;
	color: purple;
	font-size: large;
}

#categories td:hover {
	cursor: pointer;
	background-color: #DA81F5;
}

td:ACTIVE {
	width: 94px;
	height: 30px;
	background-color: green;
	color: purple;
	font-size: large;
}
</style>
<script src="<c:url value="/resources/jquery-1.11.3.min.js" />"></script>

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

	<div id="categories" align="center"></div>

	<div id="exp">

		<table>
			<tr>
				<td>aa</td>
			</tr>
		</table>
	</div>

	<script>
		loadJSON('v1/category/getAll', function(data) {
			createCategoriesTable(data);
		}, function(xhr) {
			console.error(xhr);
		});

		function createCategoriesTable(data) {
			addTable("categories", data)

		}
		function onclickTdHandler() {

		}

		function addTable(elementId, data) {
			var myTableDiv = document.getElementById(elementId);
			var table = document.createElement('TABLE');
			var tableBody = document.createElement('TBODY');
			table.appendChild(tableBody);
			var tr = document.createElement('TR');
			tableBody.appendChild(tr);
			for (var j = 0; j < data.length; j++) {
				var td = document.createElement('TD');
				td.appendChild(document.createTextNode(data[j].name));
				tr.appendChild(td);
			}
			myTableDiv.appendChild(table);
		}
	</script>
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

</body>
</html>