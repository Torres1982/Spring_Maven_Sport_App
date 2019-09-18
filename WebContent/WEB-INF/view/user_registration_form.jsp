<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>App User Registration Form</title>
		<!-- CSS References -->
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/vendor/bootstrap.min.css" />" rel="stylesheet">
	</head>
	
	<body>
		<div class="container page_container">
			<h4>App User Registration Form</h4>
		
			<a href="${pageContext.request.contextPath}/main/home" class="link-text">Home Page</a>
			
			<div id="footer" class="text-center footer">
				Artur Sukiennik | &copy;opyright | Wipro Limited | 2019
			</div>
		</div>
	</body>
	
	<!-- Java Script References -->
   	<script src="<c:url value="/resources/js/vendor/jquery-3.4.1.js" />"></script>
   	<script src="<c:url value="/resources/js/vendor/popper.min.js" />"></script>
   	<script src="<c:url value="/resources/js/vendor/bootstrap.min.js" />"></script>
   	<script src="<c:url value="/resources/js/main.js" />"></script>
</html>