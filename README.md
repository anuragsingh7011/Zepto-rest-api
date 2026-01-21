# 🚀 Zepto – Spring & Hibernate REST API Project

This project is a **simple RESTful backend application** built using **Core Java, Spring Framework, and Hibernate ORM**.  
It demonstrates how to design a **layered architecture** (Controller → Service → DAO → Database) for a real-world use case similar to an e-commerce or delivery platform.

The application provides **User Management** and **Product Management** features with REST APIs that can be tested using **Postman**.

---

## 🔹 Features

### 👤 User Module
- Register new users with **auto-generated passwords**
- Login using email and password
- Hibernate-based database persistence

### 📦 Product Module
- Create new products
- Search products by name (**partial & case-insensitive search**)
- Fetch product lists using REST APIs

---

## 🔹 Technologies Used
- **Java 17+**
- **Spring Framework (Core + MVC)**
- **Hibernate ORM**
- **MySQL**
- **Apache Tomcat 10**
- **Postman** (API testing)
- **Eclipse IDE (Enterprise Edition)**

---

## 🔹 Architecture


---

## 🔹 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /user/register | Register a new user |
| POST | /user/login | Login user |
| POST | /product/add | Add new product |
| GET | /product/search?name= | Search product by name |

---

## 🔹 What This Project Demonstrates
- Clean layered architecture
- Hibernate `SessionFactory` usage
- HQL queries
- REST API design with Spring
- Auto password generation logic
- Proper HTTP responses using `ResponseEntity`

---

### 📌 How to Run
1. Import project into **Eclipse (Enterprise Edition)**
2. Configure `hibernate.cfg.xml` with MySQL credentials
3. Start **Tomcat 10**
4. Test APIs using **Postman**

---

### 📬 Author
**Anurag**
