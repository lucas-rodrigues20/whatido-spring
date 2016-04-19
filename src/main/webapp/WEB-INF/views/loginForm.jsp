<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<template:mainTemplate titulo="Login">

<!-- CORPO -->
<div class="container">
	
	<div class="col-md-4 col-md-offset-4 conteudo">

		<div class="page-header">
			<h1>Login</h1>
		</div>
	
		<form:form servletRelativeAction="/login" method="post">
		
			<c:if test="${param.error == 'true'}">
				<div class="alert alert-danger alert-dismissible fade in" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<span class="fa fa-exclamation-triangle" aria-hidden="true"></span>
					<span class="sr-only">Error:</span>
					Email ou Senha Inválido
				</div>
			</c:if>
			
			<div class="form-group">
				<label>Email</label>
				<div class="input-group margin-bottom-sm">
					<span class="input-group-addon"><i class="fa fa-envelope fa-fw" aria-hidden="true"></i></span>
					<input type="email" name="username" class="form-control" placeholder="Email" required />
				</div>
			</div>
			
			<div class="form-group">
				<label>Senha</label>
				<div class="input-group margin-bottom-sm">
					<span class="input-group-addon"><i class="fa fa-key fa-fw" aria-hidden="true"></i></span>
					<input type="password" name="password" class="form-control" placeholder="Senha" required />
				</div>
			</div>
			
			<div class="text-right">
				<button type="submit" class="btn btn-primary btn-block">Login</button>
			</div>
			
		</form:form>
		
		<a href="${s:mvcUrl('CC#form').build() }" class="pull-left">Cadastrar-se</a>
		<a href="${s:mvcUrl('RSC#form').build() }" class="pull-right">Esqueci Minha Senha</a>
		
	</div>
	
</div>

</template:mainTemplate>