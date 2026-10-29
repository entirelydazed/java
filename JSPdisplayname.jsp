
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body style="font-family: Arial; margin: 40px;">

    <h2>Student Details</h2>

    <%
        String name = "Kumud Gosavi";
        String registerNumber = "101";
        String department = "AIDS";
    %>

    <p>Name: <%= name %></p>
    <p>Register Number: <%= registerNumber %></p>
    <p>Department: <%= department %></p>

</body>
</html>
