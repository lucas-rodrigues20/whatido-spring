<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
	
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
	          		<a href="#">
	          			<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
	          				Link 01
					</a>
				</li>
        	</ul>
		</div>
		
	</div>
	
</nav>