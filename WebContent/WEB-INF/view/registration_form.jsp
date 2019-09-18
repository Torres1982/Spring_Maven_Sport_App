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
	</head>

	<body>
		<div class="container page_container">
			<h4>Player Registration</h4>

			<form:form action="processRegistrationForm" method="POST" modelAttribute="footballer" class="form-horizontal">
			
				<!-- This ID is used not to loose track for the Footballer ID (Update and Submit) -->
				<form:hidden path="id" />
				
				<div class="form-group row">
					<div class="col-sm-7">
						<form:input path="firstName" class="registration-input form-control" placeholder="First Name" />
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<form:input path="lastName" class="registration-input form-control" placeholder="Last Name" />
					</div>
					<div class="col-sm-5">
						<form:errors path="lastName" cssClass="registration-form-error" />
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<form:input path="club" class="registration-input form-control" placeholder="Football Club" />
					</div>
					<div class="col-sm-5">
						<form:errors path="club" cssClass="registration-form-error" />
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<form:input path="country" class="registration-input form-control" placeholder="Nationality" />
					</div>
					<div class="col-sm-5">
						<form:errors path="country" cssClass="registration-form-error" />
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<form:input type="date" path="dob" class="registration-input form-control" />	
					</div>
					<div class="col-sm-5">
						<form:errors path="dob" cssClass="registration-form-error" />
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<form:select path="strength" id="strength-height-fix" class="registration-input form-control">
							<form:options items="${strengthSelection}" />
						</form:select>
					</div>
					<div class="col-sm-5">
						<form:errors path="strength" cssClass="registration-form-error" />
					</div>
				</div>
				
				<div class="from-group row">
					<div class="col-sm-7 registration-input-radiobuttons">
						<form:radiobuttons path="position" items="${positionSelection}" />
					</div>
					<div class="col-sm-5">
						<form:errors path="position" cssClass="registration-form-error" />
					</div>
				</div>
				<br>
				
				<div id="rating-bottom-margin-fix" class="from-group row">
					<div class="col-sm-7">
						<form:input path="rating" class="registration-input form-control" placeholder="Rating [0 - 100]" />
					</div>
					<div class="col-sm-5">
						<form:errors path="rating" cssClass="registration-form-error" />
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-7">
						<form:input path="category" class="registration-input form-control" placeholder="Category" />
					</div>
					<div class="col-sm-5">
						<form:errors path="category" cssClass="registration-form-error" />
					</div>
				</div>
			
				<input type="submit" id="footballer-registration-button" class="btn btn-warning btn-sm" value="Save Footballer" />
			</form:form>
			
			<a href="${pageContext.request.contextPath}/main/home" class="link-text">Home Page</a>
			
			<div class="text-center footer">
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