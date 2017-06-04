<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autore</title>
</head>
<body>
<h1>${quadro.titolo}</h1>
	<div>Nome: ${autore.nome}</div>
	<div>Cognome: ${autore.cognome}</div>
	<div>Nazionalità: ${autore.nazionalità}</div>
	<div>Data di nascita: ${autore.dataDiNascita}</div>
	<div>Data di morte: ${autore.dataDiMorte}</div>
</body>
</html>