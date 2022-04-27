<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="kysymys" items="${requestScope.kysymysentlist}">
	<li>${kysymys} <a href='../deletekysymys?id=${kysymys.kysymys_id}'>Delete</a> <a href='../readtoupdatekysymys?id=${kysymys.kysymys_id}'>Update</a>
</c:forEach>


</body>
</html>