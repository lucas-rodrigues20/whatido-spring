<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<template:mainTemplate titulo="Login">

<!-- CORPO -->
<div class="container">
	
	<div class="col-md-6 col-md-offset-3">

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
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
			
		</form:form>
	</div>
	
</div>

</template:mainTemplate>