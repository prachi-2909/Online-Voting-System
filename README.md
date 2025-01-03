
# **Voting System Portal**

A dynamic web application built using Java Servlets, JSP, and Maven for managing voting systems. This project includes features such as user-friendly voting forms, real-time results, and configurable poll settings.

---

## **Table of Contents**
1. [Project Overview]
2. [Features]
3. [Technologies Used]
4. [Installation and Setup]


---

## **Project Overview**
This Voting System Portal provides a secure and straightforward platform for users to cast votes. The application integrates features like dynamic user interfaces, robust error handling, and efficient backend processing.

---

## **Features**
- **Vote Submission**: Users can select and submit their votes.
- **Poll Results**: Real-time display of voting results.
- **Admin Settings**: Manage poll configurations and candidate details.
- **Responsive Design**: Works seamlessly on desktops, tablets, and mobile devices.
- **Input Validation**: Robust client-side and server-side validation.

---

## **Technologies Used**
- **Frontend**: HTML, CSS, JavaScript, Bootstrap
- **Backend**: Java Servlets, JSP
- **Build Tool**: Maven
- **Database**: MySQL
- **Version Control**: Git and GitHub

---

## **Installation and Setup**

### **Prerequisites**
1. Java Development Kit (JDK 8 or higher)
2. Apache Maven
3. MySQL Server
4. Apache Tomcat Server
5. Git

### **Steps to Setup**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/voting-system.git
   cd voting-system
   ```
2. Configure the database:
   - Create a MySQL database named `voting_system`.
   - Execute the SQL script located in `/src/main/resources/db/setup.sql`.

3. Update database credentials:
   - Modify the `application.properties` file in the `src/main/resources/` directory:
     ```properties
     db.url=jdbc:mysql://localhost:3306/voting_system
     db.username=root
     db.password=password
     ```

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Deploy the application:
   - Copy the generated WAR file from the `target/` directory to the `webapps/` folder of your Tomcat server.

6. Start the Tomcat server and access the application:
   - Open a browser and navigate to `http://localhost:8080/voting-system`.

## **Usage**
1. Navigate to the homepage.
2. Cast your vote by selecting a candidate.
3. View real-time poll results on the "Poll Results" page.
4. Admins can configure polls using the "Settings" page.


