<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Reservation :</title>
</head>
<body>
<h2>Complete Reservation :</h2><br>
<h2>Flight Information</h2><br>
Airline :${flight.operatingAirline}<br>
From :${flight.departureCity}<br>
To: ${flight.arrivalCity}<br>
Time : ${flight.dateOfDeparture}<br>

<br>
<form action="completeReservations" method="post">
<h2>Passenger Details :</h2><hr>
<pre>
firstname:<input type="text" name="firstname" />

lastname:<input type="text" name="lastname" />

email:<input type="text" name="email" />

phone:<input type="text" name="phone" />

<h2>Card details</h2>
name on card:<input type="text" name="nameoncard" />
cardno :<input type="text" name="cardno" />
expiry date:<input type="text" name="expdate" />
three digit security code:<input type="pass" name="securitycode" />

<input type="hidden" name="id" value="${flight.id}"/>
<input type="submit" name="save" value="reserve" />
</pre>
</form>
</body>
</html>