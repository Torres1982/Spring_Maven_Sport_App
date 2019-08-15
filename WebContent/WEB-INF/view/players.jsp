<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>Football Home Page</title>
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
			<h4>Registered Players</h4>
			
			<c:forEach var="item" items="${players}">
				<div class="row">
					<p>${item.id}</p>
					<p>${item.firstName}</p>
					<p>${item.lastName}</p>
					<p>${item.club}</p>
					<p>${item.country}</p>
					<p>${item.dob}</p>
					<p>${item.strength}</p>
					<p>${item.position}</p>
					<p>${item.rating}</p>
					<p>${item.category}</p>
				</div>
			</c:forEach>
			
			<a href="home" class="link-text">Home Page</a>
			
			<div class="text-center footer">
				Artur Sukiennik | &copy;opyright | Wipro Limited | 2019
			</div>
		</div>
	</body>
</html>