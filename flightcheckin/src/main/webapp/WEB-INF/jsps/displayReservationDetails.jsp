<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
	<h4 style="color: blue;">Reservation Details</h4>
	<h4>Flight Details :</h4>
		 Airlines: ${reservation.flight.operatingAirlines}
	<br> Flight number: ${reservation.flight.flightNumber}
	<br> Departure City: ${reservation.flight.departureCity}
	<br> Arrival City: ${reservation.flight.arrivalCity}
	<br> Date of Departure: ${reservation.flight.dateOfDeparture}
	<br> Estimated Departure Time:
	${reservation.flight.estimatedDepartureTime}
	<br>

	<h4>Passenger Details :</h4>
		 First Name: ${reservation.passenger.firstName}
	<br> Last Name: ${reservation.passenger.lastName}
	<br> Email: ${reservation.passenger.email}
	<br> Phone: ${reservation.passenger.phone}
	<br>

	<form action="completeCheckIn" method="post">
		Enter the Number of Bags, you want to check in: <input type="text" name="numberOfBags" /> 
			<input type="hidden" value="${reservation.id}" name="reservationId"/>
			<input type="submit" value="Check In" />
	</form>





</body>
</html>