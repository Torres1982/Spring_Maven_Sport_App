<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>Football Home Page</title>
		<!-- CSS References -->
		<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">	
		<link href="<c:url value="/resources/css/vendor/bootstrap.min.css" />" rel="stylesheet">	
		<link href="<c:url value="/resources/css/vendor/data-tables.bootstrap.min.css" />" rel="stylesheet">	
		<link href="<c:url value="/resources/css/vendor/responsive.bootstrap.min.css" />" rel="stylesheet">
	</head>
	
	<body>
		<div class="container page_container">
			<h4>Registered Players</h4>
			
			<c:choose>
				<c:when test="${fn:length(players) > 0}">
					<div class="table-responsive">
						<table id="players-table" class="table table-striped table-bordered table-hover table-sm">
							<thead>
								<tr>
									<th>Name</th>
									<th>Surname</th>
									<th>Club</th>
									<th>Country</th>
									<th>DOB</th>
									<th>Strength</th>
									<th>Position</th>
									<th>Rating</th>
									<security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
										<th>Action</th>
									</security:authorize>
									<!-- <th>Category</th> -->
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="item" items="${players}">
									<!-- Update Link for Each Individual Player -->
									<c:url var="updatePlayer" value="/main/showRegistrationFormToUpdate">
										<c:param  name="footballerId" value="${item.id}" />
									</c:url>
									
									<!-- Delete Link for Each Individual Player -->
									<c:url var="deletePlayer" value="/main/deletePlayer">
										<c:param  name="footballerId" value="${item.id}" />
									</c:url>
									
									<tr>
										<td>${item.firstName}</td>
										<td>${item.lastName}</td>
										<td>${item.club}</td>
										<td>${item.country}</td>
										<td>${item.dob}</td>
										<td>${item.strength}</td>
										<td>${item.position}</td>
										<td>${item.rating}</td>
										
										<security:authorize access="hasRole('ADMIN') or hasRole('MANAGER')">
											<td>						
												<a href="${updatePlayer}" class="btn btn-warning btn-sm">Update</a>
												
												<security:authorize access="hasRole('ADMIN')">	
													<a href="${deletePlayer}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete ${item.firstName} ${item.lastName}?');">Remove</a>
												</security:authorize>
											</td>
										</security:authorize>										
										<!-- <td>${item.category}</td> -->
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:when>
				
				<c:otherwise>
					<p>Players List is Empty!</p>
				</c:otherwise>
			</c:choose>
						
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
   	<script src="<c:url value="/resources/js/vendor/dataTables.bootstrap.min.js" />"></script> 
   	<script src="<c:url value="/resources/js/vendor/jquery.dataTables.min.js" />"></script>
   	<script src="<c:url value="/resources/js/main.js" />"></script>
</html>