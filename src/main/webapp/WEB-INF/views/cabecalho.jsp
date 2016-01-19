<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-inverse">
	
    <div class="container">
    	
      	<div class="navbar-header">
        	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	          	<span class="sr-only">Toggle navigation</span>
	          	<span class="icon-bar"></span>
	          	<span class="icon-bar"></span>
	          	<span class="icon-bar"></span>
        	</button>
        	<a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">What I Do?!</a>
      	</div>
      	<div id="navbar" class="collapse navbar-collapse navbar-right">
        	<ul class="nav navbar-nav">
	          	<li>
	          		<a href="${s:mvcUrl('HC#index').build() }">
	          			Home
	          		</a>
	          	</li>
	          	<li>
	          		<a href="${s:mvcUrl('MCC#form').build() }">Contato</a>
	          	</li>
	          	<security:authorize access="!isAuthenticated()">
	    	      	<li>
		          		<a href="${s:mvcUrl('CC#form').build() }">Cadastrar</a>
		          	</li>
	          		<li>
	          			<a href="${s:mvcUrl('LC#loginForm').build() }">Login</a>
	          		</li>
	          	</security:authorize>
	          	<security:authorize access="isAuthenticated()">
		          	<li>
		          		<a href="${s:mvcUrl('LC#form').build() }">Suas Listas</a>
		          	</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
							<security:authentication property="principal" var="usuarioSpring"/>
							Olá, <c:out value="${usuarioSpring.usuario.nome }" /> <span class="caret"></span>
						</a>
		             	<ul class="dropdown-menu">
		               		<li>
		               			<a href="${s:mvcUrl('DC#form').build() }">Seus Dados</a>
		               			<a href="${s:mvcUrl('ASC#form').build() }">Alterar Senha</a>
		               		</li>
		               		<li role="separator" class="divider"></li>
		               		<li>
		               			<a href='<c:url value="/logout" />'>Logout</a>
		               		</li>
		             	</ul>
		           	</li>
				</security:authorize>
        	</ul>
		</div>
		
	</div>
	
</nav>