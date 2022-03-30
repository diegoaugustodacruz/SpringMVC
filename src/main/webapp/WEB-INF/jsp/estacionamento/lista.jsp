<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<tags:template title="Lista de Estacionamento">
	<h1>Lista</h1>
	${msg}
	<table class="table">
		<tr>
			<th>Nome</th>
			<th>Preco</th>
			<th></th>
		</tr>
		<c:forEach items="${lista }" var="e">

			<tr>
				<td>${e.nome }</td>

				<td>${e.preco }</td>
				
				<td>
				<c:url value="/estacionamento/editar/${e.id }" var="link"></c:url>
					<a href="${link }" class="btn btn-info">Editar</a>
				</td>
			</tr>

		</c:forEach>

	</table>
</tags:template>