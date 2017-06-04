<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca opere per anno</title>
</head>
<body>
	<select onchange="location = this.options[this.selectedIndex].value;">
		<c:forEach var="quadro" items="${quadri}">
			<option value="/searchResult.jsp">${quadro.annoRealizzazione}</option>
		</c:forEach>
		</select>
</body>
</html>