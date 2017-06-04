<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca opere per autore</title>
</head>
<body> Trova opere di
	<select onchange="location = this.options[this.selectedIndex].value;">
		<c:forEach var="autore" items="${autori}">
			<option value="/searchResult.jsp">${autore.cognome} ${autore.nome}</option>
			<input type="hidden" id="id_autore"	value="${autori.id}" />
			<input type="hidden" id="tipo_search" value="<%=request.getParameter("perAutore")%>" />
		</c:forEach>

	</select>
</body>
</html>