<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	
	<title>Pagina de Produtos</title>
	
	  <link href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">
	  <link href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.theme.min.css" />" rel="stylesheet">
	  <script src="<c:url value="/resources/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js" />"></script>
    
</head>
<body>
<h1>
	Adiciona Produto
</h1>

<c:url var="adicionaAction" value="/produto/adiciona" ></c:url>

<form:form action="${adicionaAction}" commandName="produto">
<table class="table table-hover table-inverse">
	<c:if test="${!empty produto.descricao}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="descricao">
				<spring:message text="Descrição"/>
			</form:label>
		</td>
		<td>
			<form:input path="descricao" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="valor">
				<spring:message text="Valor"/>
			</form:label>
		</td>
		<td>
			<form:input path="valor" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty produto.descricao}">
				<input type="submit" class="btn btn-primary"
					value="<spring:message text="Alterar produto"/>" />
			</c:if>
			<c:if test="${empty produto.descricao}">
				<input type="submit" class="btn btn-primary"
					value="<spring:message text="Adicionar produto"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de Produtos</h3>
<c:if test="${!empty listProdutos}">
	<table class="table table-hover table-inverse">
	<tr>
		<th width="80">Produto ID</th>
		<th width="120">Produto Descricao</th>
		<th width="120">Produto Valor</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listProdutos}" var="produto">
		<tr>
			<td>${produto.id}</td>
			<td>${produto.descricao}</td>
			<td>${produto.valor}</td>
			<td><a href="<c:url value='/alteraProduto/${produto.id}' />" >Alterar</a></td>
			<td><a href="<c:url value='/removeProduto/${produto.id}' />" >Remover</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>