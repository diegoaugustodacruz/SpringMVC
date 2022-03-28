<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Estacionamento</title>
</head>
<body>
	${msg }
	<c:url value="/estacionamento/cadastrar" var="action"></c:url>
	<form:form action="${ action }" method="post" commandName="estacionamento">
		<div>
			<form:label path="nome">Nome</form:label>
			<form:input path="nome"></form:input>
		</div>
		
		<div>
			<form:label path="endereco">Endereco</form:label>
			<form:input path="endereco"></form:input>
		</div>
		
		<div>
			<form:label path="vagas">Vagas</form:label>
			<form:input path="vagas"></form:input>
		</div>
		
		<div>
			<form:label path="preco">Preco</form:label>
			<form:input path="preco"></form:input>
		</div>
		
		<input type="submit" value="Cadastrar"> 
	</form:form>

</body>
</html>