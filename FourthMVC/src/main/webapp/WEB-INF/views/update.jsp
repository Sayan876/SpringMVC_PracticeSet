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
     <form:form action="update" modelAttribute="pers" method="post">
     <form:input path="id" placeholder="Enter the id" type="number"/>
     <form:input path="name" placeholder="Enter name" type="text"/>
     <form:input path="age" placeholder="Enter age" type="text" />
     <form:input path="email" placeholder="Enter email" type="text" />
     <form:input path="password" placeholder="Enter the password" type="text" />
     <form:input path="salary" placeholder="Enter the salary" type="text "/>
     <form:button>Update</form:button>
  </form:form>
</body>
</html>