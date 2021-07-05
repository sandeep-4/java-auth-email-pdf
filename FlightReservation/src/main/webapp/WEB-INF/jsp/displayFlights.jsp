<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All flights :</title>
</head>
<body>
<h2>::  Flights  ::  </h2>
<table>
<tr>
<th>Airlines</th>
<th>Departure city</th>
<th>Arrival city</th>
<th>Departure time</th>

</tr>
<c:forEach items="${flights}" var="flight">
<tr>
<td>${flight.operatingAirline}</td>
<td>${flight.departureCity}</td>
<td>${flight.arrivalCity}</td>
<td>${flight.dateOfDeparture}</td>
<td><a href="showCompleteResevation?id=${flight.id}">Select</a></td>
</tr>
</c:forEach>

</table>
</body>

</html>