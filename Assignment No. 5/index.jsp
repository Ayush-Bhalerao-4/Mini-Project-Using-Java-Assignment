<%@ page language="java" %>
<html>
<head>
    <title>Employee Registration</title>
</head>
<body>

<h2>Employee Registration Form</h2>

<form action="EmployeeServlet" method="post">
    ID: <input type="text" name="id"><br><br>
    Name: <input type="text" name="name"><br><br>
    Salary: <input type="text" name="salary"><br><br>
    <input type="submit" value="Register">
</form>

</body>
</html>