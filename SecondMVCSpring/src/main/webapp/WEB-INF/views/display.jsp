<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>display section</h1>
  
  <h2>Employee id: ${employee.getId()}</h2>
  <h2>Employee name: ${employee.getName()}</h2>
  <h2>Employee designation: ${employee.getDesg()}</h2>
  <h2>Employee Salary: ${employee.getSalary()}</h2>
  <h2>Employee Gender: ${employee.getGender()}</h2>
</body>
</html>