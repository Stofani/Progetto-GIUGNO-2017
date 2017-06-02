<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Inserimento nuovo quadro</title>
</head>
<body>
<f:view>
<h:form>
    <div>Titolo: <h:inputText value="#{quadroController.titolo}"  
    required="true" requiredMessage="titolo obbligatorio" id="titolo"/> <strong><h:message for="titolo"/></strong>
   	</div>
   	<div>Anno Realizzazione: <h:inputText value="#{quadroController.annoRealizzazione}" 
   	/></div>
   	<div>
	<h:commandButton value="Salva"  action="#{quadroController.salvaQuadro}"/>
   	</div>
</h:form>
</f:view>
</body>
</html>