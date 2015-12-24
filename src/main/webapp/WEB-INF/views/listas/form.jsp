<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>

<template:mainTemplate titulo="Nova Lista">

<!-- CORPO -->
<div class="container">
	
	<div class="col-md-8 col-md-offset-2">

		<div class="page-header">
			<h1>Nova Lista de Tarefas</h1>
		</div>
	
		<form:form action="${s:mvcUrl('LC#gravar').build()}" method="post" commandName="listaTarefas">
			
			<div class="form-group">
				<label>Descrição da Lista</label>
				<form:input path="descricao" cssClass="form-control" placeholder="Descrição da Lista" />
			</div>
			
			<div class="text-right">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
			
		</form:form>
		
	</div>
	
</div>

</template:mainTemplate>