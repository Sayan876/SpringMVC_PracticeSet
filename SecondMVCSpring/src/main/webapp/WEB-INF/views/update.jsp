<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>Update Section</h1>
  
  <form:form action="update" modelAttribute="emp" method="post">
        <form:label path="id">Id</form:label>
		<form:input path="id" />
		<br>
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<form:label path="phone">Phone Number</form:label>
		<form:input path="phone" />
		<br>
		<form:label path="email">Email Id</form:label>
		<form:input path="email" />
		<br>
		<form:label path="desg">Designation</form:label>
		<form:input path="desg" />
		<br>
		<form:label path="salary">Salary</form:label>
		<form:input path="salary" />
		<br>
		<form:label path="gender">Gender</form:label>
		Male<form:radiobutton path="gender" value="Male" />
		Female<form:radiobutton path="gender" value="Female" />
		<br>
		<form:label path="password">Password</form:label>
		<form:password path="password" />
		<br>
		<form:button>Register</form:button>
	</form:form>
</body>
</html>