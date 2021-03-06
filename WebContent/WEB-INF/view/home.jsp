<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>Football Home Page</title>
		<!-- CSS References -->
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/vendor/bootstrap.min.css" />" rel="stylesheet">
	</head>
	
	<body>
		<div class="container page_container">
			<h4>Home Page</h4>
			
			<div class="form-group row">
				<div class="col-sm-7 font_italic">
					${day} ${month} ${year}, ${dayOfWeek}
				</div>
				
				<div class="col-sm-5">
					<security:authorize access="isAuthenticated()">
						<form:form action="${pageContext.request.contextPath}/logout" method="POST">
							<input type="submit" id="footballer-registration-button" class="btn btn-warning btn-sm" value="Logout" />
						</form:form>
					</security:authorize>
					
					<security:authorize access="!isAuthenticated()">
						<form:form action="${pageContext.request.contextPath}/showLoginPage" method="GET">
							<input type="submit" id="footballer-registration-button" class="btn btn-warning btn-sm" value="Login" />
						</form:form>
					</security:authorize>
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-7">
					<div>
						<security:authorize access="isAuthenticated()">
							Hello <security:authentication property="name" />
						</security:authorize>
					</div>
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-7 font_italic">
					<div>
						<security:authorize access="isAuthenticated()">
							<security:authentication property="authorities"/>
						</security:authorize>
					</div>
				</div>
			</div>

			<security:authorize access="hasRole('ADMIN')">
				<div>
					<a href="${pageContext.request.contextPath}/register/showAppUserRegistrationForm" class="link-text">App User Registration Form</a>
				</div>
			</security:authorize>

			<!-- Display the Link only for Roles: Managers and Admin -->
			<security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
				<div>
					<a href="showRegistrationForm" class="link-text">Footballer Registration Form</a>
				</div>
			</security:authorize>
			
			<div>
				<a href="showAllPlayers" class="link-text">Show All Footballers</a>
			</div>
			
			<div id="footer" class="text-center">
				Artur Sukiennik | &copy; Copyright | Wipro Limited | ${year}
			</div>
		</div>
	</body>
	
	<!-- Java Script References -->
	<script src="<c:url value="/resources/js/vendor/jquery-3.4.1.js" />"></script>
	<script src="<c:url value="/resources/js/vendor/popper.min.js" />"></script>
   	<script src="<c:url value="/resources/js/vendor/bootstrap.min.js" />"></script>
   	<script src="<c:url value="/resources/js/main.js" />"></script>
</html>