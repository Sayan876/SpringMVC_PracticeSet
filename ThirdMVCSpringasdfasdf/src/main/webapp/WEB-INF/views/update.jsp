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
    <form:form modelAttribute="emp" action="update" method="post">
    <form:input path="id" type="text" placeholder="Enter the id"/> 
      <form:input path="name" type="text" placeholder="Enter the name"/> 
      <form:input path="desg" type="text" placeholder="Enter the Designation"/>
      <form:button>Update</form:button>
  </form:form>
</body>
</html>