🚖 PickMeNow – Cab Booking Backend API
📌 Overview

PickMeNow is a backend application built using Spring Boot that simulates a cab booking system. It manages customers, drivers, cabs, and ride bookings through RESTful APIs.

The project demonstrates a layered architecture (Controller → Service → Repository) with DTOs and exception handling.

⚙️ Features
👤 Customer management (add, view)
🚗 Cab management
🧑‍✈️ Driver management
📍 Book rides
🔄 Trip status handling
❌ Custom exception handling (Driver not found, Cab unavailable, etc.)
🔁 DTO transformation for clean API responses
🏗️ Project Structure
PickMeNow
│── controller        # REST APIs
│── services          # Business logic
│── repository        # Database interaction
│── model             # Entity classes
│── DTOs              # Request & Response objects
│── transformer       # Entity ↔ DTO conversion
│── exception         # Custom exceptions
│── Enum              # Enums (TripStatus, Gender)
🛠️ Technologies Used
Java
Spring Boot
Spring Web
Spring Data JPA
Maven
Hibernate
MySQL / H2 (depending on your config)
▶️ How to Run the Project
1. Clone the Repository
git clone https://github.com/your-username/PickMeNow.git
cd PickMeNow
2. Open in IDE

Open the project in:

IntelliJ IDEA (recommended)
Eclipse / VS Code
3. Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/pickmenow
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

You can also use H2 database if configured.

4. Build the Project
mvn clean install
5. Run the Application
mvn spring-boot:run

Or run:

PickMeNowApplication.java
6. Access API

Default server runs on:

http://localhost:8080
📡 Sample API Endpoints
👤 Customer
POST /customer/add
GET /customer/{id}
🚗 Cab
POST /cab/add
GET /cab/all
🧑‍✈️ Driver
POST /driver/add
📍 Booking
POST /booking/book
❗ Exception Handling

Custom exceptions included:

CabUnavailableException
CustomerNotFoundException
DriverNotFoundException
📈 Future Improvements
Authentication (JWT)
Payment integration
Real-time driver tracking
Ride history & analytics

👨‍💻 Author
Debraj Adhikari
