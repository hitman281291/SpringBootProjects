# 📌 Department Management REST API (Spring Boot)

A fully functional **Spring Boot REST API** designed to manage Department data using an **in-memory repository**.  
This project demonstrates clean architecture, CRUD operations, custom annotations, global exception handling, and validation techniques.

---

## 🚀 Features

### ✓ **Complete CRUD Operations**
- Create Department  
- Retrieve a Department by ID  
- Retrieve all Departments  
- Update Department  
- Delete Department  

### ✓ **In-Memory Repository (Thread-Safe)**
Uses `ConcurrentHashMap` + `AtomicLong` to simulate a persistent data layer.

### ✓ **Custom Annotation**
✔ **@CheckPrime** → ensures a number is prime before processing

### ✓ **Global Exception Handling**
Implemented using:
- `@ControllerAdvice`
- Custom exception: **DepartmentNotFoundException**
- Standardized JSON error responses  

### ✓ **Clean Multi-Layer Architecture**
```
Controller → Service → Repository → Model
```

---

## 🛠️ Tech Stack

| Technology | Purpose |
|-----------|---------|
| **Java 17+** | Primary language |
| **Spring Boot 4** | Framework |
| **Spring Web** | REST API support |
| **Jakarta Validation** | Input validation |
| **ConcurrentHashMap** | In-memory data store |
| **Postman** | API Testing |

---

## 📂 Project Structure

```
src/main/java/com/hitesh/module2_employee/
│
├── controller/
│   └── DepartmentController.java
│
├── service/
│   ├── DepartmentService.java
│   └── DepartmentServiceImpl.java
│
├── repository/
│   ├── DepartmentRepository.java
│   └── InMemoryDepartmentRepository.java
│
├── model/
│   └── Department.java
│
├── exception/
│   ├── DepartmentNotFoundException.java
│   └── GlobalExceptionHandler.java
│
└── validation/
    ├── CheckPrime.java
    └── CheckPrimeValidator.java
```

---

## 📘 API Documentation

### **GET — Retrieve All Departments**
```
GET /departments
```

### **GET — Retrieve a Department by ID**
```
GET /departments/{id}
```

### **POST — Create Department**
```
POST /departments
Body:
{
  "title": "HR",
  "isActive": true
}
```

### **PUT — Update Department**
```
PUT /departments/{id}
Body:
{
  "title": "Finance",
  "isActive": true
}
```

### **DELETE — Delete Department**
```
DELETE /departments/{id}
```

---

## 🧪 Custom Annotation Example

### Annotation Usage
```
@GetMapping("/check/{value}")
public String checkPrime(@CheckPrime @PathVariable Integer value) {
    return "OK";
}
```

### Validation Failure Response:
```json
{
  "timestamp": "2025-12-11T18:18:51.6399Z",
  "status": 500,
  "error": "Internal Server Error",
  "message": "checkPrime.value: must be a prime number",
  "path": "/departments/check/9"
}
```

---

## ⚠️ Error Handling Response Format

Handled via **GlobalExceptionHandler**:

```json
{
  "timestamp": "2025-12-11T17:44:36.231Z",
  "status": 404,
  "error": "Not Found",
  "message": "Department with id 999 not found",
  "path": "/departments/999"
}
```

---

## 🎯 What This Project Demonstrates

- Building REST APIs using Spring Boot  
- Clean separation of layers (Controller → Service → Repository)  
- Use of in-memory thread-safe storage  
- Custom annotation & validation handling  
- Global exception management  
- Best practices in backend development  

---

## 🧑‍💻 How to Run the Project

### 1️⃣ Clone the Repository
```
git clone https://github.com/<your-username>/<repo-name>.git
```

### 2️⃣ Navigate into the Project
```
cd <repo-name>
```

### 3️⃣ Run the Application
```
./mvnw spring-boot:run
```

Server starts at:
```
http://localhost:8080
```

---

## 🥇 Author

**Hitesh Purohit**  
Backend Developer 
