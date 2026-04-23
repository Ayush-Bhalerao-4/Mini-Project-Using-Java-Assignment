============================================================
  Employee Registration App - Setup Guide
============================================================

PREREQUISITES:
  - JDK 8 or above
  - Apache Tomcat 9 or 10
  - MySQL Server
  - MySQL JDBC Driver (mysql-connector-java.jar)

------------------------------------------------------------
STEP 1 — MySQL Setup
------------------------------------------------------------
Run these SQL commands in MySQL:

  CREATE DATABASE test;
  USE test;
  CREATE TABLE employee (
      id INT PRIMARY KEY,
      name VARCHAR(100),
      salary DOUBLE
  );

------------------------------------------------------------
STEP 2 — Add MySQL JDBC Driver
------------------------------------------------------------
Download mysql-connector-java.jar from:
  https://mvnrepository.com/artifact/mysql/mysql-connector-java

Place it inside:
  EmployeeApp/WEB-INF/lib/

------------------------------------------------------------
STEP 3 — Compile the Servlet
------------------------------------------------------------
From the WEB-INF/classes/ folder, run:

  Linux/Mac:
    javac -cp ".:/path/to/tomcat/lib/servlet-api.jar" EmployeeServlet.java

  Windows:
    javac -cp ".;C:\tomcat\lib\servlet-api.jar" EmployeeServlet.java

This creates EmployeeServlet.class in the same folder.

------------------------------------------------------------
STEP 4 — Deploy to Tomcat
------------------------------------------------------------
Copy the entire "EmployeeApp" folder into:
  /path/to/tomcat/webapps/

------------------------------------------------------------
STEP 5 — Start Tomcat
------------------------------------------------------------
  Linux/Mac:  ./bin/startup.sh
  Windows:    bin\startup.bat

------------------------------------------------------------
STEP 6 — Open in Browser
------------------------------------------------------------
  http://localhost:8080/EmployeeApp/index.jsp

============================================================
