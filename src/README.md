# ReM!xx Recycling Project

## Overview

ReM!xx Recycling is a Java-based web application designed to help users manage their recycling inventory. Users can register, log in, add materials to their inventory, update existing entries, and delete items. The application uses **Spring Boot**, **Thymeleaf**, **MySQL**, and incorporates **Spring Security** for user authentication.

---

## Features

- **User Authentication**:
    - Registration and login functionality.
    - Secure password handling with Spring Security.

- **CRUD Operations**:
    - Add, update, view, and delete recycling inventory items.

- **User Dashboard**:
    - Displays the logged-in user's inventory.

- **REST API Endpoints**:
    - Endpoints for adding, updating, and deleting inventory items.

- **Responsive Design**:
    - User-friendly interface built with Thymeleaf and CSS.

---

## Tech Stack

- **Backend**: Java, Spring Boot (v3.4)
- **Frontend**: Thymeleaf, HTML, CSS
- **Database**: MySQL
- **Authentication**: Spring Security (BCrypt password encoding)
- **Build Tool**: Maven

---

## Prerequisites

1. **Java 17** or higher.
2. **Maven** for building the project.
3. **MySQL Database** installed and running.
4. A suitable IDE like IntelliJ IDEA or Eclipse.

---

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/SteveAlexBowman/Remixx_Capstone.git
   
2. Create and Configure a MySQL database THEN:
3. Build the project: mvn clean install
4. Run the application: mvn spring-boot:run
5. Access the application at: http://localhost:8080


