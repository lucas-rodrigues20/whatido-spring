<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>

<template:mainTemplate titulo="Usuários Cadastrados">

<!-- CORPO -->
<div class="container">
	
	<div class="col-md-8 col-md-offset-2 conteudo">

		<div class="page-header">
			<h1>Usuários Cadastrados</h1>
		</div>
		
		<c:if test="${!empty mensagem}">
			<div class="alert alert-success alert-dismissible fade in" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${mensagem }
			</div>
		</c:if>
		
		<form:form action="${s:mvcUrl('UC#buscaUsuarios').build()}" method="post" commandName="filtroUsuario"
			htmlEscape="true" cssClass="form-inline text-center">
			
			<div class="form-group">
				<form:input path="filtro" cssClass="form-control" placeholder="Nome ou Email" size="60" />
			</div>
			
			<div class="form-group">
				<form:select path="permissao" cssClass="form-control">
					<form:option value="" label="Selecione..." />
					<form:options items="${permissoes }" />
				</form:select>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span> Buscar
				</button>
			</div>
			
		</form:form>
		
		<div class="espacamento-listagem table-responsive">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Email</th>
						<th>Permissão</th>
						<th>Qtd. Listas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios }" var="usuario">
						<tr>
							<td>
								<c:out value="${usuario[0] }"></c:out>
							</td>
							<td>
								<c:out value="${usuario[1] }"></c:out>
							</td>
							<td>
								<c:out value="${usuario[2] }"></c:out>
							</td>
							<td>
								<c:out value="${usuario[3] }"></c:out>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
	
</div>

</template:mainTemplate>