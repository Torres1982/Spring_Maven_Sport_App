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
			
			<form:form action="${pageContext.request.contextPath}/register/processAppUserRegistrationForm" method="POST" modelAttribute="appUser" class="form-horizontal">
				<!-- Display an Error Message if wrong details are provided -->
				<c:if test="${userRegistrationError != null}">
					<div class="registration-form-error">
						${userRegistrationError}
					</div>
				</c:if>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						<form:input path="userName" class="registration-input form-control" placeholder="User Name" />
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
						<form:password path="password" class="registration-input form-control" placeholder="Password" />
					</div>
				</div>
				
				<button type="submit" id="footballer-registration-button" class="btn btn-warning btn-sm">Register User</button>
			</form:form>
		
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