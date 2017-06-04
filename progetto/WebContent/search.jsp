<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca opere</title>
</head>
<body>
	Ricerca quadro per
<select onchange="location = this.options[this.selectedIndex].value;">
    <option>(seleziona)</option>
    <option value="searchAutore.jsp">autore</option>
    <option value="searchAnno.jsp">anno</option>
    <option value="searchNazione.jsp">nazione</option>
</select>
</body>
</html>