<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>Access Denied Page</title>
		<!-- CSS References -->
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/vendor/bootstrap.min.css" />" rel="stylesheet">
	</head>
	
	<body>
		<div class="container page_container">
			<h4>Access Denied</h4>
			
			<div class="registration-form-error">
				You are not Authorised to access this site!
			</div>
			
			<a href="home" class="link-text">Home Page</a>
		</div>
	</body>
</html>