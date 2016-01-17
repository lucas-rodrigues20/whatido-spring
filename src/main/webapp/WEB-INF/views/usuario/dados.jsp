<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:mainTemplate titulo="Seus Dados">

<!-- CORPO -->
<div class="container">

	<div class="col-md-8 col-md-offset-2">

		<div class="page-header">
			<h1>Seus Dados</h1>
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

		<form:form action="${s:mvcUrl('DC#gravar').build()}" method="post" commandName="usuario"
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

			<form:hidden path="email" />
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<p class="form-control-static">${usuario.email }</p>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Nome</label>
				<div class="col-sm-10">
					<form:input path="nome" cssClass="form-control" placeholder="Seu nome" />
					<div class="text-right">
						<form:errors path="nome" cssClass="erro-embutido" />
					</div>
				</div>
			</div>
			
			<form:hidden path="senha"/>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Salvar Alterações</button>
				</div>
			</div>

		</form:form>

	</div>

</div>

</template:mainTemplate>