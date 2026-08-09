# Booking Tickets REST API

A Spring Boot RESTful application for managing ticket bookings with full CRUD operations.

## Tech Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA** - Data persistence
- **H2 Database** - In-memory database (runtime scope)
- **Project Lombok** - Boilerplate reduction (optional)
- **Maven** - Build tool

## Project Structure

```
bookingTickets/
├── src/main/java/com/example/bookingTickets/
│   ├── BookingTicketsApplication.java    # Main application entry point
│   ├── controller/
│   │   └── TicketController.java         # REST API controller
│   ├── model/
│   │   └── Ticket.java               # Ticket JPA entity
│   ├── repository/
│   │   └── TicketRepository.java    # JPA repository interface
│   └── service/
│       └── TicketService.java      # Business logic service
├── src/main/resources/
│   └── application.properties   # Application configuration
└── pom.xml                     # Maven dependencies
```

## Data Model

### Ticket Entity

| Field           | Type    | Description              |
|-----------------|---------|--------------------------|
| id              | Long    | Primary key (auto-generated) |
| passengerName   | String  | Name of the passenger   |
| destination     | String  | Travel destination      |
| price           | Double  | Ticket price            |

## API Endpoints

All endpoints are prefixed with `/api/tickets`.

| Method | Endpoint       | Description           | Request Body              |
|--------|----------------|-----------------------|-------------------------|
| POST   | `/api/tickets`   | Create a new ticket   | Ticket JSON object      |
| GET    | `/api/tickets`   | Get all tickets       | None                    |
| GET    | `/api/tickets/{id}` | Get ticket by ID   | None                    |
| PUT    | `/api/tickets/{id}` | Update ticket by ID | Ticket JSON object      |
| DELETE | `/api/tickets/{id}` | Delete ticket by ID | None                  |

### Example Request/Response

**Create Ticket (POST /api/tickets)**

Request:
```json
{
  "passengerName": "John Doe",
  "destination": "Paris",
  "price": 299.99
}
```

Response (200 OK):
```json
{
  "id": 1,
  "passengerName": "John Doe",
  "destination": "Paris",
  "price": 299.99
}
```

**Get All Tickets (GET /api/tickets)**

Response (200 OK):
```json
[
  {
    "id": 1,
    "passengerName": "John Doe",
    "destination": "Paris",
    "price": 299.99
  }
]
```

**Update Ticket (PUT /api/tickets/1)**

Request:
```json
{
  "passengerName": "Jane Smith",
  "destination": "London",
  "price": 349.50
}
```

Response (200 OK):
```json
{
  "id": 1,
  "passengerName": "Jane Smith",
  "destination": "London",
  "price": 349.50
}
```

## Prerequisites

- JDK 17 or higher
- Maven 3.6+ (or use Maven Wrapper)

## Getting Started

### Build the application (Maven Wrapper)

```bash
cd bookingTickets
```

**On Windows:
```bash
mvnw.cmd clean install
```

**On Unix/Mac:
```bash
./mvnw clean install
```

### Run the application

```bash
mvnw.cmd spring-boot:run
```

The application will start at `http://localhost:8080`

### Run tests
```bash
mvnw.cmd test
```

## Database

The application uses an H2 in-memory database. Data is reset on application restart.

## Notes

- Fetching a non-existent ticket by ID returns `null` (GET); updating one throws a `RuntimeException` (PUT).
- Delete operation is idempotent — deleting an absent ticket does not throw an error.
