<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#d329e6">
<h1>All teachers are :</h1>
<sql:setDataSource driver="com.mysql.cj.jdbc.Driver" var ="ds"
           url ="jdbc:mysql://localhost:3306/first_db" user="root" password = "password"/>
  <sql:query dataSource = "${ds}" var = "rs">select * from studentNew;</sql:query>
  <div class = "container ">
   <table class= "table" >
   <tr>
   <td>Id</td>
   <td>Name</td>
   <td>Email</td>
   </tr>
   <c:forEach items = "${rs.rows}" var="row" >
   <tr>
   <td> <c:out value="${row.id }"> </c:out> </td>
   <td><c:out value="${row.name }"></c:out></td>
   <td><c:out value="${row.email }"></c:out></td>
   </tr>
   </c:forEach>
   </table>
  
  </div>
  
</body>
</html>