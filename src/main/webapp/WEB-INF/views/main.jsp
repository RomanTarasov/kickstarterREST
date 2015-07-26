<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<c:url value="/resources/jquery-1.11.3.min.js" />"></script>

<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Main</title>
<style>
body {
	
}

div#header {
	width: auto;
	height: 40px;
	background-color: #0DFC95;
	font-size: medium;
}

div#response {
	width: auto;
	height: 60px;
	background-color: #78C0F4;
	font-size: x-large;
}

table#projects {
	
}

#category {
	font-style: italic;
	text-align: center;
	background-color: #10E8E1;
}

#projects td {
	background-color: #10E8E1;
	color: purple;
	font-size: large;
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
</style>
<script>
	var allQuotes = [ "Do It" ];
	window.onload = function() {
		initQuotes();
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

	<h2 id="category">category</h2>

	<div id="projects">
		<table id="projects_table">
		</table>
	</div>

	<script>
		var selectedCategory;
		var projects;
		var categories;

		$.getJSON('v1/category/getAll', function(data) {
			createCategoriesTable(data);
		});

		function createCategoriesTable(data) {
			categories = data;
			var onClickHandler = onclickCategoriesTdHandler;
			addTable("categories", data);
			selectRandomCategory(data);
			$('#categories').find('td').click(onClickHandler);
		}
		function selectRandomCategory(data) {
			var textField = document.getElementById("category");
			var index = Math.floor(Math.random() * (data.length));
			textField.innerHTML = data[index].name;
			selectedCategory = data[index];
			createProjectsTableByCategoryId(selectedCategory.id);

		}
		function onclickCategoriesTdHandler() {
			var index = $(this).index();
			createProjectsTableByCategoryId(categories[index].id);
			var textField = document.getElementById("category");
			textField.innerHTML = categories[index].name;
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

		function createProjectsTableByCategoryId(categoryId) {
			$.getJSON('v1/project/get/categoryId/' + categoryId,
					function(data) {
						responseHandler(data);
					});
		}

		function responseHandler(response) {
			var c = [];
			$.each(response, function(i, item) {
				c.push("<tr><td>" + item.name + "</td>");
				c.push("<td width='198px' height: 30px;>"
						+ item.shortDescription + "</td>");
				c.push("<td>" + "pledged: " + item.pledged + "</td>");
				c.push("<td>" + "goal: " + item.goal + "</td>");
				c
						.push("<td>" + "the end day: " + item.theEndDay
								+ "</td></tr>");
			});

			$('#projects_table').html(c.join(""));
		}
	</script>

	<script>
		function initQuotes() {
			getAllQuotes();
			setInterval(nextQuote, 10000);
		}

		function nextQuote() {
			var textField = document.getElementById("quoteText");
			textField.innerHTML = allQuotes[Math.floor(Math.random()
					* (allQuotes.length))];
		}
		function getAllQuotes() {
			$.getJSON('v1/quote/getAll', function(data) {
				for (var index = 0; index < data.length; index++) {
					allQuotes[index] = data[index].text;
				}
				nextQuote();
			});
		}
	</script>
</body>
</html>