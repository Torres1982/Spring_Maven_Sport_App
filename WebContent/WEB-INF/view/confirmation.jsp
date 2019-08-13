<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>Confirmation Page</title>
		<!-- CSS References -->
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<!-- Java Script References -->
		<script src="<c:url value="/resources/js/main.js" />"></script>
    	<script src="<c:url value="/resources/js/jquery-3.4.1.js" />"></script>
    	<script src="<c:url value="/resources/js/popper.min.js" />"></script>
    	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	</head>

	<body>
		<div class="container page_container">
			<h4>New Footballer Registered:</h4>
			
			<p>${footballer.firstName} ${footballer.lastName} - ${footballer.club} (${footballer.country})</p>
			<p>Date of Birth: ${footballer.dob}</p>
			<p>Main Strength: ${footballer.strength}</p>
			<p>Main Position: ${footballer.position}</p>			
			<p>Category: ${footballer.category}</p>
			<p>Overall Rating: ${footballer.rating}</p>
			
			<a href="home">Home Page</a>
			
			<div id="footer" class="text-center">
				Artur Sukiennik | &copy;opyright | Wipro Limited | 2019
			</div>
		</div>
	</body>
</html>