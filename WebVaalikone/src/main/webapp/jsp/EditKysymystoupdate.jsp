<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Data.Kysymykset"%>
<!DOCTYPE html>
<html>
<head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action='/rest/kysymysservice/updatekysymys' method='post'>
<input type='hidden' name='kysymys_id' value='${requestScope.kysymys.kysymys_id }' >
<input type='text' name='kysymys' value='${requestScope.kysymys.kysymys}'>

<input type='submit' name='ok' value='OK'>
</form>

	<a href='/rest/kysymysservice/readkysymys'>
		<button class="button button2">Poistu</button>
	</a>
</body>
</html>