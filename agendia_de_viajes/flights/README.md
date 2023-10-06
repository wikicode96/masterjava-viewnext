# Flight microservice

Default port = 8081

- GET http://localhost:8081/flights/{seats}
Retrieves a list of available flights with a minimum required number of seats.

- PUT http://localhost:8081/flight/{id}/{seats}
Updates the quantity of available seats on a specific flight.