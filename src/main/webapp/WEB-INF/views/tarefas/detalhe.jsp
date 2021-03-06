<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template" %>

<template:mainTemplate titulo="${listaTarefas.descricao }">

<!-- CORPO -->
<div class="container">
	
	<div class="col-md-8 col-md-offset-2 conteudo">

		<div class="page-header">
			<h1>
				<c:out value="${listaTarefas.descricao }" />
			</h1>
		</div>
		
		<c:if test="${!empty mensagem}">
			<div class="alert alert-success alert-dismissible fade in" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${mensagem }
			</div>
		</c:if>
	
		<form:form action="${s:mvcUrl('TC#novaTarefa').build()}" method="post" commandName="tarefas"
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
				<label>Nova Tarefa</label>
				<div class="input-group margin-bottom-sm">
					<span class="input-group-addon"><i class="fa fa-thumb-tack fa-fw" aria-hidden="true"></i></span>
					<form:input path="descricao" cssClass="form-control" placeholder="Descrição da Tarefa" />
				</div>
				<div class="text-right">
					<form:errors path="descricao" cssClass="erro-embutido" />
				</div>
			</div>
			
			<div class="text-right">
				<button type="submit" class="btn btn-primary">Adicionar</button>
			</div>
			
		</form:form>
		
		<hr>
		
		<div>
			<div class="panel panel-primary">
				<div class="panel-heading">
			    	<h3 class="panel-title">Última Tarefa Sorteada</h3>
			  	</div>
			  	<div class="panel-body">
			  		<div class="text-center">
			  			<c:if test="${not empty listaTarefas.ultimaTarefaSorteada.descricao }">
			    			<p>Que tal fazer agora a tarefa: 
				    			<strong class="text-info">
				    				<c:out value="${listaTarefas.ultimaTarefaSorteada.descricao }"/>
				    			</strong>
				    		</p>
			    		</c:if>
			    		
			    		<form:form action="${s:mvcUrl('TC#sortear').build() }"
									method="post">
							<button type="submit" value="Remover" class="btn btn-primary btn-sm"
								<c:if test="${empty tarefasNaoFinalizadas }">disabled</c:if>>
								<i class="fa fa-refresh fa-spin fa-fw" aria-hidden="true"></i> Sortear Uma Tarefa
							</button>
						</form:form>
			    	</div>
			  	</div>
			</div>
		</div>
		
		<div class="tab-content">
			<!-- NAVEGACAO FINALIZADA/NAO FINALIZADA-->
			<ul class="nav nav-tabs nav-justified" role="tablist">
			    <li role="presentation" class="active">
			        <a href="#nao-finalizadas" id="exibir-nao-finalizadas" role="tab" data-toggle="tab">Tarefas Não Finalizadas</a>
			    </li>
			    <li role="presentation">
			        <a href="#finalizadas" id="exibir-finalizadas" role="tab" data-toggle="tab">Tarefas Finalizadas</a>
			    </li>
			</ul>
			<!-- NAVEGACAO FINALIZADA/NAO FINALIZADA-->
		
			<!-- NAO FINALIZADAS -->
			<div role="tabpanel" class="tab-pane fade in active" id="nao-finalizadas">
				<table class="table table-bordered table-striped">
					<colgroup>
						<col class="col-md-1">
						<col class="col-md-7">
						<col class="col-md-1">
					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>Descrição</th>
							<th>Remover</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty tarefasNaoFinalizadas }">
							<tr>
								<td colspan="3" class="text-center">Você não tem nenhuma tarefa ainda.</td>
							</tr>
						</c:if>
						<c:forEach items="${tarefasNaoFinalizadas}" var="tarefa">
							<tr>
								<td>
									<form:form action="${s:mvcUrl('TC#finalizar').arg(0, tarefa.id).build() }"
										method="post">
										<div class="text-center">
											<label>
												<input type="checkbox" value="" class="checkFinalizar"
													<c:if test="${tarefa.concluida }">checked</c:if>>
										    </label>
										 </div>
									</form:form>
								</td>
								<td>
									<c:out value="${tarefa.descricao}"/>
								</td>
								<td>
									<form:form action="${s:mvcUrl('TC#remover').arg(0, tarefa.id).build() }"
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
			<!-- NAO FINALIZADAS -->
			
			<!-- FINALIZADAS -->
			<div role="tabpanel" class="tab-pane fade" id="finalizadas">
				<table class="table table-bordered table-striped">
					<colgroup>
						<col class="col-md-1">
						<col class="col-md-7">
						<col class="col-md-1">
					</colgroup>
					<thead>
						<tr>
							<th></th>
							<th>Descrição</th>
							<th>Remover</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty tarefasFinalizadas }">
							<tr>
								<td colspan="3" class="text-center">Você não tem nenhuma tarefa ainda.</td>
							</tr>
						</c:if>
						<c:forEach items="${tarefasFinalizadas}" var="tarefa">
							<tr>
								<td>
									<form:form action="${s:mvcUrl('TC#finalizar').arg(0, tarefa.id).build() }"
										method="post">
										<div class="text-center">
											<label>
												<input type="checkbox" value="" class="checkFinalizar"
													<c:if test="${tarefa.concluida }">checked</c:if>>
										    </label>
										 </div>
									</form:form>
								</td>
								<td>
									<c:out value="${tarefa.descricao}"/>
								</td>
								<td>
									<form:form action="${s:mvcUrl('TC#remover').arg(0, tarefa.id).build() }"
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
			<!-- FINALIZADAS -->
			
		</div>
		
	</div>
	
</div>

</template:mainTemplate>