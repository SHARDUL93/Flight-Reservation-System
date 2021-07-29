<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>

	<h4 style="color: blue;">Complete Reservation</h4>
	<br> Airline: ${flight.operatingAirlines}
	<br> Departure City: ${flight.departureCity}
	<br> Arrival City: ${flight.arrivalCity}
	<br><br>

<form action="completeResevation" method="post">
	<pre>
		<h3>Passenger Details:</h3>
		First Name: <input type="text" name="passengerFirstName" /><br>
		Last Name: <input type="text" name="passengerLastName" /><br>
		Email: <input type="text" name="passengerEmail" /><br>
		Phone: <input type="text" name="passengerPhone" /><br><br>

		<h3>Card Details:</h3>
		Name on the card: <input type="text" name="nameOnTheCard" /><br>
		Card no: <input type="text" name="cardNumber" /><br>
		Expiry Date: <input type="text" name="expirationDate" /><br>
		Three Digit Sec Code: <input type="text" name="securityCode" /><br><br>


	<input type="hidden" name="flightId" value="${flight.id}" />
	<input type="submit" value="confirm" />
	</pre>
</form>
</body>
</html>