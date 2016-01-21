<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>

<template:mainTemplate titulo="Cadastro">

<!-- CORPO -->
<div class="container">
	
	<div class="col-md-8 col-md-offset-2 conteudo">

		<div class="page-header">
			<h1>Cadastro</h1>
		</div>
		
		<c:if test="${!empty mensagem}">
			<div class="alert alert-success alert-dismissible fade in" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${mensagem }
			</div>
		</c:if>
	
		<form:form action="${s:mvcUrl('CC#gravar').build()}" method="post" commandName="usuario"
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
				<label>Nome</label>
				<form:input path="nome" cssClass="form-control" placeholder="Seu nome" />
				<div class="text-right">
					<form:errors path="nome" cssClass="erro-embutido" />
				</div>
			</div>
			
			<div class="form-group">
				<label>Email</label>
				<form:input path="email" cssClass="form-control" placeholder="email@exemplo.com" />
				<div class="text-right">
					<form:errors path="email" cssClass="erro-embutido" />
				</div>
			</div>
			
			<div class="form-group">
				<label>Senha</label>
				<form:password path="senha" cssClass="form-control" placeholder="Insira uma senha" />
				<div class="text-right">
					<form:errors path="senha" cssClass="erro-embutido" />
				</div>
			</div>
			
			<div class="text-right">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
			
		</form:form>
		
	</div>
	
</div>

</template:mainTemplate>