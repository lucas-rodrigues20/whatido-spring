<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:mainTemplate titulo="Recuperar Senha">

<!-- CORPO -->
<div class="container">

	<div class="col-md-10 col-md-offset-1 conteudo">

		<div class="page-header">
			<h1>Recuperar Senha</h1>
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

		<form:form action="${s:mvcUrl('RSC#recuperarSenha').build()}" method="post" commandName="recuperarSenha"
			cssClass="form-horizontal">
		
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
				<label class="col-sm-2 control-label">Email Cadastrado</label>
				<div class="col-sm-10">
					<div class="input-group margin-bottom-sm">
						<span class="input-group-addon"><i class="fa fa-envelope fa-fw" aria-hidden="true"></i></span>
						<form:input path="email" cssClass="form-control" placeholder="email@exemplo.com" />
					</div>
					<div class="text-right">
						<form:errors path="email" cssClass="erro-embutido" />
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Recuperar Senha</button>
				</div>
			</div>

		</form:form>

	</div>

</div>

</template:mainTemplate>