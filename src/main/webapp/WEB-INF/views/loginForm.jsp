<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<template:mainTemplate titulo="Login">

<!-- CORPO -->
<div class="container">
	
	<div class="col-md-4 col-md-offset-4 conteudo">

		<div class="page-header">
			<h1>Login</h1>
		</div>
	
		<form:form servletRelativeAction="/login" method="post">
			
			<div class="form-group">
				<label>Email</label>
				<input type="text" name="username" class="form-control" placeholder="Email" />
			</div>
			
			<div class="form-group">
				<label>Senha</label>
				<input type="password" name="password" class="form-control" placeholder="Senha" />
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