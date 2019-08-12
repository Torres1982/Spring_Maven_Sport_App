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
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
		<!-- Java Script References -->
		<script src="<c:url value="/resources/js/main.js" />"></script>
    	<script src="<c:url value="/resources/js/jquery-3.4.1.js" />"></script>
    	<script src="<c:url value="/resources/js/popper.min.js" />"></script>
    	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	</head>

	<body>
		<div class="container page_container">
			<h4>Footballer Registration</h4>

			<form:form action="processRegistrationForm" method="POST" modelAttribute="footballer" class="form-horizontal">
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
						<form:select path="strength" class="registration-input form-control">
							<form:options items="${footballer.strengthOptions}" />
						</form:select>
					</div>
					<div class="col-sm-5">
						<form:errors path="strength" cssClass="registration-form-error" />
					</div>
				</div>
				
				<div class="from-group row">
					<div class="col-sm-7">
						GK <form:checkbox path="positions" value="GK" />
						CB <form:checkbox path="positions" value="CB" />
						LB <form:checkbox path="positions" value="LB" />
						RB <form:checkbox path="positions" value="RB" />
						DM <form:checkbox path="positions" value="DM" />
						CM <form:checkbox path="positions" value="CM" />
						LM <form:checkbox path="positions" value="LM" />
						RM <form:checkbox path="positions" value="RM" />
						SS <form:checkbox path="positions" value="SS" />
						LW <form:checkbox path="positions" value="LW" />
						RW <form:checkbox path="positions" value="RW" />
						CF <form:checkbox path="positions" value="CF" />
					</div>
					<div class="col-sm-5">
						<form:errors path="positions" cssClass="registration-form-error" />
					</div>
				</div>
				<br>
				
				<div class="from-group row">
					<div class="col-sm-7">
						<form:input path="rating" class="registration-input form-control" placeholder="Rating [0 - 100]" />
					</div>
					<div class="col-sm-5">
						<form:errors path="rating" cssClass="registration-form-error" />
					</div>
				</div>
			
				<input type="submit" id="footballer-registration-button" class="btn btn-warning btn-sm" value="Register Footballer" />
			</form:form>
			
			<a href="home">Home Page</a>
			
			<div id="footer" class="text-center">
				Artur Sukiennik | &copy;opyright | Wipro Limited | 2019
			</div>
		</div>
	</body>
</html>