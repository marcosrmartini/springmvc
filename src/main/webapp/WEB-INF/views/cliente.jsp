<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	
	<title>Pagina de Clientes</title>
	
	  <link href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet">
	  <link href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.theme.min.css" />" rel="stylesheet">
	  <script src="<c:url value="/resources/bootstrap-3.3.7-dist/js/jquery-3.1.1.min.js" />"></script>
    
</head>
<body>
<h1>
	Adiciona Cliente
</h1>

<c:url var="adicionaAction" value="/produto/adiciona" ></c:url>

<form:form action="${adicionaAction}" commandName="cliente">
<table class="table table-hover table-inverse">
	<c:if test="${!empty cliente.nome}">
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
			<form:label path="nome">
				<spring:message text="Nome"/>
			</form:label>
		</td>
		<td>
			<form:input path="nome" />
		</td> 
	</tr>
	
	
	
	<tr>
		<td>
			<form:label path="cpf">
				<spring:message text="CPF"/>
			</form:label>
		</td>
		<td>
			<form:input path="cpf" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty cliente.nome}">
				<input type="submit" class="btn btn-primary"
					value="<spring:message text="Alterar cliente"/>" />
			</c:if>
			<c:if test="${empty cliente.nome}">
				<input type="submit" class="btn btn-primary"
					value="<spring:message text="Adicionar cliente"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de Produtos</h3>
<c:if test="${!empty listClientes}">
	<table class="table table-hover table-inverse">
	<tr>
		<th width="80">Cliente ID</th>
		<th width="120">Cliente Nome</th>
		<th width="120">Cliente CPF</th>
		<th width="60">Editar</th>
		<th width="60">Deletar</th>
	</tr>
	<c:forEach items="${listClientes}" var="cliente">
		<tr>
			<td>${cliente.id}</td>
			<td>${cliente.nome}</td>
			<td>${cliente.cpf}</td>
			<td><a href="<c:url value='/alteraCliente/${cliente.id}' />" >Alterar</a></td>
			<td><a href="<c:url value='/removeCliente/${cliente.id}' />" >Remover</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>