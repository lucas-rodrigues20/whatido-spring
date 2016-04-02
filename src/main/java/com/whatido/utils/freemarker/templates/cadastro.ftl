<!DOCTYPE html>
<html>
	<head>

		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

        <style type="text/css">
            body {
                font-family: "Source Sans Pro","Helvetica Neue",Helvetica,Arial,sans-serif;
            }
            table{
                margin: auto;
            }
            table thead tr td{
                background-color: #DEDEDE;
            }
            .text-center{
                text-align: center;
            }
            .tabela-externa{
                border: 1px solid #AAA;
            }
            .text-primary {
              color: #337ab7;
            }
            a {
              color: #02457e;
              text-decoration: none;
            }
            a:hover{
                color: #000;
            }
        </style>

	</head>
    <body style="font-family: 'Source Sans Pro', 'Helvetica Neue', Helvetica, Arial, sans-serif;">

        <table class="tabela-externa" cellspacing="10" style="margin: auto; border: 1px solid #AAA; text-align: center;">
        	<thead>
        		<tr class="text-center">
        			<td style="background-color: #DEDEDE;">
        				<h1>What I Do?!</h1>
        			</td>
        		</tr>
        	</thead>
        	<tbody class="text-center">
        		<tr>
        			<td>
        				<strong>Seu Cadastro Foi Realizado!</strong>
        			</td>
        		</tr>
        		<tr>
        			<td>
        				Seja bem vindo <span class="text-primary" style="color: #337ab7;">${parametro.nome}</span>, agora você já pode começar a criar suas listas.
        			</td>
        		</tr>
        		<tr>
        			<td class="text-center">
        				<table style="margin: auto;">
        					<thead>
        						<tr>
        							<td colspan="2" style="background-color: #DEDEDE;">
        								<strong>Seus Dados de Acesso</strong>
        							</td>
        						</tr>
        					</thead>
        					<tbody>
        						<tr>
				        			<td>Login:</td>
				        			<td class="text-primary" style="color: #337ab7;">${parametro.email}</td>
				        		</tr>
				        		<tr>
				        			<td>Senha:</td>
				        			<td class="text-primary" style="color: #337ab7;">${parametro.senha}</td>
				        		</tr>
        					</tbody>
        				</table>
        			</td>
        		</tr>
        		<tr>
        			<td>
        				Acesse: <a href="http://app.whatido.tk" style="color: #02457e; text-decoration: none;">WhatIDo?!</a>
        			</td>
        		</tr>
        	</tbody>
        </table>

    </body>
</html>