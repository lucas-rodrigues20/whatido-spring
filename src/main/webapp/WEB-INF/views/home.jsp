<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Lucas Rodrigues">

    <title>What I Do?!</title>
    
    <c:url value="/resources" var="resourcesPath" />

    <!-- Bootstrap Core CSS -->
    <link href="${resourcesPath }/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${resourcesPath }/css/stylish-portfolio.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${resourcesPath }/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <%@ include file="/WEB-INF/views/cabecalho.jsp" %>
    <!-- Navigation -->

    <!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h1>What I Do?!</h1>
            <h3>Você tem várias coisas para fazer e não sabe por onde começar?</h3>
            <br>
            <security:authorize access="!isAuthenticated()">
            	<a href="${s:mvcUrl('CC#form').build() }" class="btn btn-dark btn-lg">Cadastre-se</a>
            </security:authorize>
            <security:authorize access="isAuthenticated()">
            	<a href="${s:mvcUrl('LC#form').build() }" class="btn btn-dark btn-lg">Suas Listas</a>
            </security:authorize>
            <a href="#about" class="btn btn-dark btn-lg">Saiba Mais</a>
        </div>
    </header>

    <!-- About -->
    <section id="about" class="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Deixe-nos te dar uma sugestão</h2>
                    <p class="lead">Crie listas com todas as tarefas que você precisa fazer e então, se você estiver um pouco confuso, deixe-nos sugerir por onde começar.</p>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

    <!-- Services -->
    <!-- The circle icons use Font Awesome's stacked icon classes. For more information, visit http://fontawesome.io/examples/ -->
    <section id="services" class="services bg-primary">
        <div class="container">
            <div class="row text-center">
                <div class="col-lg-10 col-lg-offset-1">
                    <h2>Como Funciona?</h2>
                    <hr class="small">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-list fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Crie Uma Lista</strong>
                                </h4>
                                <p>Crie uma lista para agrupar as coisas que você precisa fazer, sejam elas sua lista de compras, suas tarefas escolares, etc. Você pode ter quantas listas quiser.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-thumb-tack fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Adicione Tarefas</strong>
                                </h4>
                                <p>Adicione a lista que você criou as tarefas que fazem parte dela, assim você as manterá bem agrupadas.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-lightbulb-o fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Peça Uma Sugestão</strong>
                                </h4>
                                <p>Depois de adicionar suas tarefas a uma lista, se você se sentir indeciso por qual delas começar, clique no botão "Sortear uma tarefa", que nós daremos uma sugestão.</p>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="service-item">
                                <span class="fa-stack fa-4x">
                                <i class="fa fa-circle fa-stack-2x"></i>
                                <i class="fa fa-check-square-o fa-stack-1x text-primary"></i>
                            </span>
                                <h4>
                                    <strong>Finalize As Tarefas</strong>
                                </h4>
                                <p>As tarefas que você for completando podem ser marcadas como concluídas e então elas não serão mais sorteadas como uma sugestão.</p>
                            </div>
                        </div>
                    </div>
                    <!-- /.row (nested) -->
                </div>
                <!-- /.col-lg-10 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </section>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-lg-offset-1 text-center">
                    <h4><strong>What I Do?!</strong></h4>
                    <ul class="list-unstyled">
                        <li>
                            <a href="${s:mvcUrl('HC#index').build() }">Home</a>
                        </li>
                        <li>
                            <a href="${s:mvcUrl('MCC#form').build() }">Contato</a>
                        </li>
                        <li>
                            <a href="#">Sobre</a>
                        </li>
                    </ul>
                    <br>
                    <ul class="list-inline">
                        <li>
                            <a href="https://twitter.com/baiaku22" target="_blank"><i class="fa fa-twitter fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="https://br.linkedin.com/in/lucas-rodrigues-moura-823574a7" target="_blank"><i class="fa fa-linkedin fa-fw fa-3x"></i></a>
                        </li>
                        <li>
                            <a href="https://github.com/lucas-rodrigues20" target="_blank"><i class="fa fa-github-alt fa-fw fa-3x"></i></a>
                        </li>
                    </ul>
                    <hr class="small">
                    <p class="text-muted">Copyright &copy; What I Do?! 2015</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${resourcesPath }/js/bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script>
    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    </script>

</body>

</html>