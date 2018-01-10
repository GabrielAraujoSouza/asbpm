<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Adicionar Cliente</title>
</head>
<body>
	<form action="adicionar" method="post">
		<input type="hidden" name="id" value="${cliente.id}" />

		<table class="table table-striped">
			<tbody>
				<tr>
					<th class="text-center"><label for="nome">Nome:</label></th>
					<td><input type="text" name="nome" value="${cliente.nome}"></td>
				</tr>
				<tr>
					<th class="text-center"><label for="tipo">Tipo:</label></th>
					<td>
						<select name="tipo">
							<option value="" selected>Selecione o tipo</option>
							<c:forEach var="tipoC" items="${tipoCliente}">
								<option value="${tipoC}"
									${cliente.tipoCliente == tipoC ? 'selected': ''}>${tipoC}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th class="text-center"><label for="status">Status:</label></th>
					<td>
						<select name="status">
						<option value="">Selecione o status</option>
							<c:forEach var="statusC" items="${statusCliente}">
								<option value="${statusC}" 
									${cliente.status == statusC ? 'selected': ''}>${statusC}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-center">
						<input type="submit" value="Submit" class="btn btn-success"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<div class="row">
		<div class="col-sm-6 text-left">
			<a href="listar">Voltar para lista de Clientes.</a>
		</div>
	</div>
	
	<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("input").prop('required', true);
			$("select").prop('required', true);
		});
	</script>
</body>
</html>
