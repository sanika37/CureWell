# 🏥 Curewell Healthcare Management System  

## Overview  
Curewell is a **comprehensive healthcare management system** designed to streamline hospital operations for **Curewell Hospital in Sydney**. It enhances efficiency by managing **doctors, specializations, surgeries, and user authentication** while ensuring **scalability, maintainability, and security** with a modern tech stack.  

## 🚀 Tech Stack  

### **Frontend:**  
- **React.js** – Component-based UI development.  
- **React Bootstrap** – Pre-styled, responsive UI components.  
- **Axios** – API communication.  

### **Backend:**  
- **Java & Spring Boot** – Scalable backend services.  
- **Spring Security** – Role-based authentication & security.  
- **JPA & MySQL** – Data persistence & relational database.  

### **Testing & Deployment:**  
- **Postman** – API testing.  
- **Docker & Docker Compose** – Containerized deployment.  

## ⚡ Key Features  

### 🔐 **User Authentication & Security**  
✔ User **Registration & Login** (JWT-based authentication).  
✔ **Role-Based Access Control** (Admin, Doctor, Patient).  

### 🏥 **Doctor & Specialization Management**  
✔ **CRUD operations** for doctors & specializations.  
✔ **Specialization association** for organized categorization.  

### 🏨 **Surgery Management**  
✔ **Schedule surgeries** with doctor, specialization & date selection.  
✔ **View & filter** scheduled surgeries.  

## 🌐 API Endpoints  

| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | User login & JWT generation |
| `GET` | `/api/doctors` | Retrieve all doctors |
| `POST` | `/api/doctors` | Add a new doctor |
| `PUT` | `/api/doctors/{id}` | Update doctor details |
| `DELETE` | `/api/doctors/{id}` | Delete a doctor |
| `GET` | `/api/specializations` | Retrieve all specializations |
| `POST` | `/api/surgeries` | Schedule a surgery |
| `GET` | `/api/surgeries` | View scheduled surgeries |

## 🏗 System Architecture  

### **Frontend Architecture**  
- **Component-Based Structure** with reusable components.  
- **State Management** using React hooks (`useState`, `useEffect`).  
- **API Integration** via Axios for seamless backend communication.  

### **Backend Architecture** (Spring Boot – MVC Pattern)  
- **Controllers** – Handle API requests.  
- **Services** – Business logic layer.  
- **Repositories** – Database interactions via JPA.  
- **Security** – JWT-based authentication & role-based access control.  

## 🧪 Testing  

- **Postman** – API testing for validation, error handling & performance.  

## 📦 Deployment with Docker  

The project is **containerized using Docker** for easy deployment across environments.  

### **Docker Setup**  

#### **Backend (`Dockerfile`)**  
```dockerfile
FROM openjdk:11-jre-slim  
VOLUME /tmp  
COPY target/curewell-backend.jar app.jar  
ENTRYPOINT ["java","-jar","/app.jar"]
```  

#### **Frontend (`Dockerfile`)**  
```dockerfile
FROM node:14 AS build  
WORKDIR /app  
COPY package.json ./  
RUN npm install  
COPY . .  
RUN npm run build  

FROM nginx:alpine  
COPY --from=build /app/build /usr/share/nginx/html  
EXPOSE 80  
CMD ["nginx", "-g", "daemon off;"]
```  

### **Docker Compose (`docker-compose.yml`)**  
```yaml
version: '3.8'
services:
  backend:
    build:
      context: ./backend
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/curewell
      - SPRING_DATASOURCE_USERNAME=root
      - SPRING_DATASOURCE_PASSWORD=password
    depends_on:
      - db

  frontend:
    build:
      context: ./frontend
    ports:
      - "80:80"

  db:
    image: mysql:5.7
    environment:
      MYSQL_ROOT_PASSWORD: password
      MYSQL_DATABASE: curewell
    volumes:
      - db_data:/var/lib/mysql

volumes:
  db_data:
```

### **Running the Application**  
```bash
docker-compose up --build
```
- **Frontend** accessible at **http://localhost**  
- **Backend API** at **http://localhost:8080/api**  

## 🎯 Conclusion  

Curewell Healthcare Management System is a **scalable, secure, and efficient** solution for hospital operations, ensuring smooth doctor, specialization, and surgery management. With **Docker-based deployment**, **role-based security**, and **RESTful API architecture**, the system is well-optimized for future enhancements.  

---

### 💡 **Getting Started**  
Clone the repository and follow the setup guide in this README. For contributions, feel free to open a **GitHub issue** or submit a **pull request**. 🚀  

