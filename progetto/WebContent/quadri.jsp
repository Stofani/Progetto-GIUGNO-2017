<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogo Opere</title>
</head>
<body>
<ul>
		<c:forEach var="quadro" items="${quadri}">
			<li><a href="quadro?id=${quadro.id}"> ${quadro.titolo} </a>
			<form action="quadro" method="post">
			 	<input type="hidden" value="${quadro.id}" name="id"/>
			</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>