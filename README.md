# TaskManager API

This is a simple Task Management System that allows users to create, assign, update, and track tasks.
The system supports task priorities, statuses, comments, and user assignment.



---

## 🚀 Getting Started

### 1. Generate Project with Spring Initializr
1. Go to [Spring Initializr](https://start.spring.io/).
2. Fill in the details:
   - Project: Maven
   - Language: Java
   - Spring Boot Version: (latest stable, e.g., 3.x.x)
   - Group: taskmanagementsystem
   - Artifact: 
   - Name: taskmanagementsystem
   - Packaging: Jar
   - Java: 17 (or your installed version)
3. Add dependencies:
   - Spring Web
   - - Lombok
4. Click Generate, and extract the downloaded project.

---

### 2. Open in IntelliJ IDEA
1. Open IntelliJ IDEA.
2. Import the project by selecting the extracted folder.
3. Wait until Maven builds the project and dependencies are downloaded.

---

### 3. Run the Application
1. Locate the main class:  
   src/main/java/taskmanagementsystem.java
2. Right-click and select Run 'TaskManagementSystemApplication'.
3. The application will start on http://localhost:8080 by default.

---

## 🛠️ Tech Stack
- Java 17+
- Spring Boot
- Maven
- REST API


---

# 📌 Task Management System APIs

Perfect 👍 You want the **API Endpoints list** (only requests, no responses). Here’s the clean **Markdown** version for your controller methods:

---

# 📌 Task Management System APIs

This project provides APIs for managing **Users, Task Lists, Tasks, Subtasks, Assignments, and Status Updates**.

---

## 🚀 Base URL

```
http://localhost:8080/tasksystem
```

---

## 📝 API Endpoints

### 1️⃣ Create User

**POST** `/users`
Query Params: `name`, `email`
<img width="1366" height="768" alt="Screenshot (360)" src="https://github.com/user-attachments/assets/b8b2125d-5cb9-4bd0-9625-575f889c0218" />

---

### 2️⃣ Create Task List

**POST** `/lists`
Query Params: `name`
<img width="1366" height="768" alt="Screenshot (361)" src="https://github.com/user-attachments/assets/24d464b0-02ab-4372-91a6-e4594ed8027f" />

---

### 3️⃣ Create Task

**POST** `/tasks`
Query Params: `title`, `description`, `dueDate (yyyy-MM-dd)`, `priority`, `createdByUserId`
<img width="1366" height="768" alt="Screenshot (362)" src="https://github.com/user-attachments/assets/b247c85e-81f1-4644-92e6-196a147f02db" />

---

### 4️⃣ Add Subtask

**POST** `/tasks/{parentId}/subtask`
Path Variable: `parentId`
Query Params: `title`, `description`, `dueDate (yyyy-MM-dd)`, `priority`, `createdByUserId`

---

### 5️⃣ Assign Task to User

**POST** `/tasks/{taskId}/assign`
Path Variable: `taskId`
Query Params: `userId`

---

### 6️⃣ Update Task Status

**POST** `/tasks/{taskId}/status`
Path Variable: `taskId`
Query Params: `status (IN_PROGRESS, DONE, etc.)`

---

### 7️⃣ Search Tasks

**GET** `/tasks/search`
Query Params: `keyword`
<img width="1366" height="768" alt="Screenshot (363)" src="https://github.com/user-attachments/assets/8889d0b6-e775-47a9-8783-b62498057cee" />

---

### 8️⃣ Filter Tasks by Status

**GET** `/tasks/filter`
Query Params: `status (TODO, IN_PROGRESS, DONE, etc.)`
<img width="1366" height="768" alt="Screenshot (364)" src="https://github.com/user-attachments/assets/07afbc59-1ca6-4933-a580-004aab173f55" />

---

### 9️⃣ Get Tasks Assigned to a User

**GET** `/users/{userId}/tasks`
Path Variable: `userId`

---

### 🔟 Delete Task

**DELETE** `/tasks/{taskId}`
Path Variable: `taskId`
<img width="1366" height="768" alt="Screenshot (365)" src="https://github.com/user-attachments/assets/15b0b50d-97ad-4aa6-8202-681dfae3d256" />

---



