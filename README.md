# RESTful API Assignment (Spring Boot)

**Student:** SADE GEORGE SADE
**StudentID:** 26915
**Institution:** Adventist University of Central Africa (AUCA)
**Group Domain:** `auca.ac.rw`
**Branch:** `restFull_api_26915`

---

##  Project Overview

This repository contains a **Spring Boot RESTful API assignment** composed of **five questions and one bonus question**. Each question is implemented as a separate Spring Boot application, following REST principles and HTTP standards.

The APIs were tested using **Postman**, and screenshots of the tests are provided as evidence of correct functionality.

---

##  Project Structure

```
restfullApiAssignment/
│── question1-library-api/
│── question2-student-api/
│── question3-menu-api/
│── question4-ecommerce-api/
│── question5-task-api/
│── bonus-user-profile/
│── .gitignore
│── README.md
```

Each folder represents an independent Spring Boot project.

---

##  Question 1: Library API

**Description:** Manage books using REST endpoints.

**Endpoints:**

* `GET /api/books` – Retrieve all books
* `GET /api/books/id/{id}` – Retrieve book by ID
* `GET /api/books/search?title=xxx` – Search books by title
* `POST /api/books` – Add a new book
* `DELETE /api/books/id/{id}` – Delete book by ID

📸 **Testing Screenshot:**

* GET all books
* <img width="670" height="403" alt="GET_all_books" src="https://github.com/user-attachments/assets/d86c75dc-d9ab-40f3-aec0-88d4ff6b08b9" />

* POST new book
* <img width="675" height="406" alt="POST_new_book" src="https://github.com/user-attachments/assets/a39431dc-1e38-4a11-8a5d-087fd0525eea" />

* DELETE book by ID
* <img width="673" height="404" alt="DELETE_book_byID" src="https://github.com/user-attachments/assets/f54a3d87-d404-4cf8-9898-019b22921357" />


---

##  Question 2: Student API

**Description:** Manage student information.

**Endpoints:**

* `GET /api/students`
* `GET /api/students/{id}`
* `POST /api/students`
* `PUT /api/students/{id}`
* `DELETE /api/students/{id}`

 **Testing Screenshot:**

* GET students
* <img width="670" height="407" alt="GET_all_students" src="https://github.com/user-attachments/assets/85ac90fe-b7b9-4810-8696-b760f19ace1f" />

* POST student
* <img width="670" height="404" alt="POST_student" src="https://github.com/user-attachments/assets/c794e00d-708d-42fe-b420-3b883ea7948a" />

* DELETE student
* <img width="670" height="405" alt="DELETE_student" src="https://github.com/user-attachments/assets/55d1c164-035c-44ea-9d7e-74e46a99b6e5" />



---

##  Question 3: Menu API

**Description:** Restaurant menu management system.

**Endpoints:**

* `GET /api/menu`
* `GET /api/menu/{id}`
* `POST /api/menu`
* `DELETE /api/menu/{id}`

 **Testing Screenshot:**

* GET menu items
* <img width="669" height="405" alt="GET_menu" src="https://github.com/user-attachments/assets/a0a75173-2b01-4a52-ac1f-abc42920d1d4" />

* GET menu item by Name
* <img width="674" height="407" alt="GET_menu_byname" src="https://github.com/user-attachments/assets/4148edfd-8123-47ae-b8cf-a8d8f81cdbcd" />
 


---

##  Question 4: E-Commerce API

**Description:** Product management for an e-commerce platform.

**Endpoints:**

* `GET /api/products`
* `GET /api/products/{id}`
* `POST /api/products`
* `PUT /api/products/{id}`
* `DELETE /api/products/{id}`

 **Testing Screenshot:**

* GET products
* <img width="669" height="407" alt="GET_products" src="https://github.com/user-attachments/assets/6d6e030a-2387-4297-8ea5-3be4147a0516" />

* POST product
* <img width="668" height="406" alt="POST_products" src="https://github.com/user-attachments/assets/26c399e1-bf3e-47a4-a008-20732d02b16a" />

* DELETE product
* <img width="669" height="406" alt="DELETE_product" src="https://github.com/user-attachments/assets/174971e8-5a4b-4c3c-b513-63eb3a94af3b" />



---

##  Question 5: Task Management API

**Description:** Manage tasks with CRUD operations.

**Endpoints:**

* `GET /api/tasks`
* `POST /api/tasks`
* `PUT /api/tasks/{id}`
* `DELETE /api/tasks/{id}`

 **Testing Screenshot:**

* GET tasks
* <img width="669" height="406" alt="GET_tasks" src="https://github.com/user-attachments/assets/e9613782-73e0-45c2-9f2e-4f10ba26c905" />

* POST task
* <img width="669" height="410" alt="POST_task" src="https://github.com/user-attachments/assets/415d2c96-c586-4d59-8b45-8bc9d27da2ac" />



---

##  Bonus Question: User Profile API

**Description:** Advanced user profile management API.

**Endpoints:**

* `GET /api/users`
* `GET /api/users/{id}`
* `POST /api/users`
* `PUT /api/users/{id}`
* `DELETE /api/users/{id}`

 **Testing Screenshot:**

* GET users
* <img width="670" height="406" alt="GET_users" src="https://github.com/user-attachments/assets/064e9a9c-21c7-4fa5-a597-dc7f62874215" />

* POST user
* <img width="669" height="406" alt="POST_user" src="https://github.com/user-attachments/assets/178b2c85-3862-4598-a29a-9f3d8dd84ad5" />



---

##  Tools & Technologies

* Java 17
* Spring Boot
* Maven
* RESTful APIs
* Postman
* Git & GitHub

---

##  How to Run a Project

```bash
mvn spring-boot:run
```

Then test endpoints using Postman.

---

##  Notes

* All APIs return proper HTTP status codes (`200`, `201`, `204`, `404`, `405`).
* Data is stored in memory using Java collections.
* Each project runs independently.

---

##  Conclusion

This assignment demonstrates understanding of:

* REST architecture
* HTTP methods
* Spring Boot controllers
* Git version control

 All requirements have been successfully implemented and tested.
