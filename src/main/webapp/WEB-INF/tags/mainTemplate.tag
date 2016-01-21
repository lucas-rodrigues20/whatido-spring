<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="titulo" required="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>${titulo } - What I Do?!</title>
	
	<c:url value="/resources" var="resourcesPath" />
	<link rel="stylesheet" href="${resourcesPath }/css/bootstrap.min.css">
	<link rel="stylesheet" href="${resourcesPath }/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="${resourcesPath }/css/site.css">
	
	<!-- Custom Fonts -->
    <link href="${resourcesPath }/css/stylish-portfolio.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${resourcesPath }/js/bootstrap.min.js"></script>
	<script src="${resourcesPath }/js/site.js"></script>
</head>

<body>

	<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
	
	<jsp:doBody />
	
	<%@ include file="/WEB-INF/views/rodape.jsp" %>
	
</body>
</html>