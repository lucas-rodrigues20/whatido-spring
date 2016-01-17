<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<template:mainTemplate titulo="Contato">

<!-- CORPO -->
<div class="container">
	
	<div class="col-md-6 col-md-offset-3">

		<div class="page-header">
			<h1>Contato</h1>
			<p class="lead">Dúvidas, sugestões, problemas? Entre em contato:</p>
		</div>
	
		<c:if test="${!empty mensagem}">
			<div class="alert alert-success alert-dismissible fade in" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${mensagem }
			</div>
		</c:if>

		<form:form action="${s:mvcUrl('MCC#enviar').build()}" method="post" commandName="contato">
		
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
				<form:input path="email" cssClass="form-control" placeholder="seuemail@exemplo.com" />
				<div class="text-right">
					<form:errors path="email" cssClass="erro-embutido" />
				</div>
			</div>
			
			<div class="form-group">
				<label>Assunto</label>
				<form:input path="assunto" cssClass="form-control" placeholder="Motivo do contato" />
				<div class="text-right">
					<form:errors path="assunto" cssClass="erro-embutido" />
				</div>
			</div>
			
			<div class="form-group">
				<label>Email</label>
				<form:textarea path="mensagem" cssClass="form-control" placeholder="Sua mensagem" />
				<div class="text-right">
					<form:errors path="mensagem" cssClass="erro-embutido" />
				</div>
			</div>
			
			<div class="text-right">
				<button type="submit" class="btn btn-primary">Enviar</button>
			</div>

		</form:form>
	</div>
	
</div>

</template:mainTemplate>