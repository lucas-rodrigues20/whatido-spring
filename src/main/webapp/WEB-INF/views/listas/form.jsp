<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>

<template:mainTemplate titulo="Suas Listas">

<!-- CORPO -->
<div class="container">
	
	<div class="col-md-8 col-md-offset-2">

		<div class="page-header">
			<h1>Suas Listas</h1>
		</div>
		
		<c:if test="${!empty mensagem}">
			<div class="alert alert-success alert-dismissible fade in" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${mensagem }
			</div>
		</c:if>
	
		<form:form action="${s:mvcUrl('LC#gravar').build()}" method="post" commandName="listaTarefas"
			htmlEscape="true">
		
			<c:set var="errosForm">
				<form:errors path="*" />
			</c:set>
			<c:if test="${!empty errosForm }">
				<div class="alert alert-danger alert-dismissible fade in hidden-sm hidden-xs" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					${errosForm }
				</div>
			</c:if>
			
			<div class="form-group">
				<label>Nova Lista</label>
				<form:input path="descricao" cssClass="form-control" placeholder="Descrição da Lista" />
				<div class="text-right">
					<form:errors path="descricao" cssClass="erro-embutido" />
				</div>
			</div>
			
			<div class="text-right">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
			
		</form:form>
		
		<div class="espacamento-listagem">
			<table class="table table-bordered table-striped">
				<colgroup>
					<col class="col-md-7">
					<col class="col-md-1">
				</colgroup>
				<thead>
					<tr>
						<th>Descrição</th>
						<th>Remover</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty listas }">
						<tr>
							<td colspan="2" class="text-center">Você não tem nenhuma lista ainda.</td>
						</tr>
					</c:if>
					<c:forEach items="${listas}" var="lista">
						<tr>
							<td>
								<a href="${s:mvcUrl('TC#tarefas').arg(0, lista.id).build() }">
									<c:out value="${lista.descricao}" />
								</a>
							</td>
							<td>
								<form:form action="${s:mvcUrl('LC#remover').arg(0, lista.id).build() }"
								method="post" >
									<div class="text-center">
										<button type="submit" value="Remover" class="btn btn-warning btn-sm">
											<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
										</button>
									</div>
								</form:form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
	
</div>

</template:mainTemplate>