<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
									<th>Action</th>
									<!-- <th>Category</th> -->
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="item" items="${players}">
									<!-- Update Link for Each Individual Player -->
									<c:url var="updatePlayer" value="/footballer/showRegistrationForm">
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
										<td>
											<a href="${updatePlayer}">Update</a>
										</td>
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
						
			<a href="home" class="link-text">Home Page</a>
			
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