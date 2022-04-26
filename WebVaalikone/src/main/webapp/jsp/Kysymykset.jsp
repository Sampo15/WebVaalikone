<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Data.Kysymys"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/CSS/kysymykset.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<title></title>

</head>
<body class="kysymyksetbody">

	<h1>Arvokysymykset</h1>
	<br>
	<br>

	<form action="/ShowResults" method="get">


		<%
			int i = 0;
		%>

		<table class="table_center">
			<c:forEach var="kysymys" items="${requestScope.kysymyslist}">
				<tr>
					<td>



						<div class="Kysymykset">
							<br> <strong>${kysymys.kysymys}</strong>

							<div class="form_middle">



								<div class="vastauscont">
									<a><input type="radio" name="vastaus<%=i%>"
										id="inlineRadio1" value="1" required class="vastausradio"></a>
									<label class="form-check-label">Täysin eri mieltä</label>

								</div>

								<div class="vastauscont">
									<input type="radio" name="vastaus<%=i%>" id="inlineRadio2"
										value="2" class="vastausradio"> <label
										class="form-check-label">Jokseenkin eri mieltä</label>

								</div>
								<div class="vastauscont">
									<input type="radio" name="vastaus<%=i%>" id="inlineRadio3"
										value="3" class="vastausradio"> <label
										class="form-check-label">Ei mielipidettä</label>

								</div>

								<div class="vastauscont">

									<input type="radio" name="vastaus<%=i%>" id="inlineRadio4"
										value="4" class="vastausradio"> <label
										class="form-check-label">Jokseenkin samaa mieltä</label>
								</div>

								<div class="vastauscont">

									<input type="radio" name="vastaus<%=i%>" id="inlineRadio5"
										value="5" class="vastausradio"> <label
										class="form-check-label">Täysin samaa mieltä</label>
								</div>

							</div>
						</div>
					</td>

				</tr>

				<%
					i++;
				%>
			</c:forEach>
		</table>
		<input type="submit" class="button" value="Lähetä vastaus!">
	</form>






</body>
</html>