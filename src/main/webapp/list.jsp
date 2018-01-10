<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Cliente</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="row">
		<div class="col-sm-6 text-left">
			<a href="editar" class="btn btn-success">Adicionar novo Cliente</a>
		</div>
		<div class="col-sm-6 text-right">
			<form action="listar" method="get">
				<input type="text" name="pesquisar" /> <input type="submit"
					value="Pesquisar" />
			</form>
		</div>
	</div>
	<div class="row"><div class="col-sm-12"></div></div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th class="text-center">Nome</th>
				<th class="text-center">TipoCliente</th>
				<th class="text-center">Status</th>
				<th colspan="2"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td class="text-center">${cliente.nome }</td>
					<td class="text-center">${cliente.tipoCliente.toString() }</td>
					<td class="text-center">${cliente.status.toString() }</td>
					<td class="text-center"><a href="editar?id=${cliente.id}"
						class="btn btn-primary">Editar</a></td>
					<td class="text-center"><a href="deletar?id=${cliente.id}"
						onclick="return confirm('Excluir o cliente: ${cliente.nome}');"
						class="btn btn-danger"> Excluir </a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function deletarCliente(nome) {
			confirm("Deletar o cliente: " + nome + "?");
		}
	</script>
</body>
</html>