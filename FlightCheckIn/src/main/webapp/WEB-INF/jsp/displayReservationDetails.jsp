<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Flight Details :</h2>
<br>
Airlines :${reservation.flight.operatingAirline}<br>
Departure City :${reservation.flight.departureCity}<br>
Arrival City :${reservation.flight.arrivalCity}<br>
Date of departure :${reservation.flight.dateOfDeparture}<br>

<hr>
<h2>Passanger Details:</h2>

	 First Name:${reservation.passanger.firstname}<br>
	 Last Name:${reservation.passanger.lastname}<br>
	 Email:${reservation.passanger.email}<br>
	 Phone:${reservation.passanger.phone}<br>
	 <br>
	 <hr>
	 <form action="completeCheckedIn" method="post">
	 
	 Enter the number of bags:<input type="text" name="noofbags" />
	 <input type="hidden" value="${reservation.id}" name="id"/>
	 <input type="submit" value="Checked" />
	 
	  </form>
	 



	
	
	
	

</body>
</html>