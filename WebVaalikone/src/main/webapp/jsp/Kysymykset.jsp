<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Data.Kysymys"%>

<!DOCTYPE html>
<html>
<head>

<script>
function topFunction() {
	  document.body.scrollTop = 0;
	  document.documentElement.scrollTop = 0; 
}
function Nayta() {
	  var x = document.getElementById("nappi");
	  var x2 = document.getElementById("nappi2");
	  var x3 = document.getElementById("nappi3");
	  var page1 = document.getElementById("Page1");
	  var page2 = document.getElementById("Page2");
	  x.style.display = "block";
	  x2.style.display = "none";
	  x3.style.display = "block";
	  page2.style.display = "block";
	  page1.style.display = "none";
}
function Nayta2() {
	  var x = document.getElementById("nappi");
	  var x2 = document.getElementById("nappi2");
	  var x3 = document.getElementById("nappi3");
	  var page1 = document.getElementById("Page1");
	  var page2 = document.getElementById("Page2");
	  x2.style.display = "block";
	  x.style.display = "none";
	  x3.style.display = "none";
	  page1.style.display = "block";
	  page2.style.display = "none";
}
</script>

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
<a name="top"></a>
	<h1>Arvokysymykset</h1>
	<br>
	<br>

	<form action="/ShowResults" method="get">
	
 
		

		<table class="table_center" id="Page1">
		
			<c:forEach var="kysymys" items="${requestScope.kysymyslist}">
				<tr>
					<td>



						<div class="Kysymykset">
							<br> <strong>${kysymys.kysymys}</strong>
								
							<div class="form_middle">



								<div class="vastauscont">
									<a><input type="radio" name="vastaus${kysymys.id}"
										id="inlineRadio1" value="1" required class="vastausradio"></a>
									<label class="form-check-label">Täysin eri mieltä</label>

								</div>

								<div class="vastauscont">
									<input type="radio" name="vastaus${kysymys.id}" id="inlineRadio2"
										value="2" class="vastausradio"> <label
										class="form-check-label">Jokseenkin eri mieltä</label>

								</div>
								<div class="vastauscont">
									<input type="radio" name="vastaus${kysymys.id}" id="inlineRadio3"
										value="3" class="vastausradio"> <label
										class="form-check-label">Ei mielipidettä</label>

								</div>

								<div class="vastauscont">

									<input type="radio" name="vastaus${kysymys.id}" id="inlineRadio4"
										value="4" class="vastausradio"> <label
										class="form-check-label">Jokseenkin samaa mieltä</label>
								</div>

								<div class="vastauscont">

									<input type="radio" name="vastaus${kysymys.id}" id="inlineRadio5"
										value="5" class="vastausradio"> <label
										class="form-check-label">Täysin samaa mieltä</label>
								</div>

							</div>
						</div>
					</td>

				</tr>

				
			</c:forEach>
			
			
			</table>
			<table class="table_center" id="Page2" style="display:none">
			<c:forEach var="kysymys" items="${requestScope.kysymyslist2}">
				<tr>
					<td>



						<div class="Kysymykset">
							<br> <strong>${kysymys.kysymys}</strong>

							<div class="form_middle">



								<div class="vastauscont">
									<a><input type="radio" name="vastaus${kysymys.id}"
										id="inlineRadio1" value="1" required class="vastausradio"></a>
									<label class="form-check-label">Täysin eri mieltä</label>

								</div>

								<div class="vastauscont">
									<input type="radio" name="vastaus${kysymys.id}" id="inlineRadio2"
										value="2" class="vastausradio"> <label
										class="form-check-label">Jokseenkin eri mieltä</label>

								</div>
								<div class="vastauscont">
									<input type="radio" name="vastaus${kysymys.id}" id="inlineRadio3"
										value="3" class="vastausradio"> <label
										class="form-check-label">Ei mielipidettä</label>

								</div>

								<div class="vastauscont">

									<input type="radio" name="vastaus${kysymys.id}" id="inlineRadio4"
										value="4" class="vastausradio"> <label
										class="form-check-label">Jokseenkin samaa mieltä</label>
								</div>

								<div class="vastauscont">

									<input type="radio" name="vastaus${kysymys.id}" id="inlineRadio5"
										value="5" class="vastausradio"> <label
										class="form-check-label">Täysin samaa mieltä</label>
								</div>

							</div>
						</div>
					</td>

				</tr>

				
			</c:forEach>
		</table>
		
				<div id="nappi" style="display:none">
					<input type="submit" class="button" value="Lähetä vastaus!" >
				</div>
				<div id="nappi2">
				    <input type="submit" onclick="Nayta(); topFunction();" class="button2" value="Eteenpäin">
				</div>
				<div id="nappi3" style="display:none">
				   <input type="submit" onclick="Nayta2(); topFunction();" class="button2" value="Takaisin">
				</div>
				
	</form>






</body>
</html>