<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>Registration Form</title>
		<!-- CSS References -->
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/vendor/bootstrap.min.css" />" rel="stylesheet">
		<!-- 
		<link href="/resources/css/main.css" rel="stylesheet">
		<link href="/resources/css/vendor/bootstrap.min.css" rel="stylesheet">
		-->
	</head>
	
	<body>
		<div class="container page_container">
			<h4>Login Page</h4>
			
			<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST" class="form-horizontal">
				<!-- Display an Error Message if credentials are wrong -->
				<c:if test="${param.error != null}">
					<div class="registration-form-error">
						Your Credentials are wrong!
					</div>
				</c:if>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<p>
							<input type="text" name="username" class="registration-input form-control" placeholder="Username" />
						</p>
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<p>
							<input type="password" name="password" class="registration-input form-control" placeholder="Password" />
						</p>
					</div>
				</div>
				
				<input type="submit" id="footballer-registration-button" class="btn btn-warning btn-sm" value="Log In" />
			</form:form>
		</div>
	</body>
</html>