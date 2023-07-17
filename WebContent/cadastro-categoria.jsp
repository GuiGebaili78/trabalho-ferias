<!-- cadastro-categoria.jsp -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastro de Categoria</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h1>Cadastro de Categoria</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<form action="CategoriaServlet" method="post">
			<input type="hidden" name="action" value="cadastrar">
			<div class="form-group">
				<label for="despesaReceita">Despesa/Receita:</label> <input
					type="text" class="form-control" id="despesaReceita"
					name="despesaReceita" required>
			</div>
			<div class="form-group">
				<label for="descricao">Descrição:</label> <input type="text"
					class="form-control" id="descricao" name="descricao" required>
			</div>
			<div class="form-group">
				<label for="subcategoria">Subcategoria:</label> <input type="text"
					class="form-control" id="subcategoria" name="subcategoria" required>
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>
