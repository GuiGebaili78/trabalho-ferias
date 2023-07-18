<!-- alteracao-cadastro.jsp -->

<%@ page import="br.com.fiap.fintech.bean. * " %>
<%@ page import="br.com.fiap.fintech.dao. * " %>
<%@ page import="br.com.fiap.fintech.controller. * " %>
<%@ page import="br.com.fiap.fintech.dao.impl. * " %>
<%@ page import="br.com.fiap.fintech.factory. * " %>
<%@ page import="br.com.fiap.fintech.singleton. * " %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alteração de Cadastro</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../includes/header.jsp" %>
    <div class="container">
        <h1>Alteração de Cadastro</h1>
        <% Categoria categoria = (Categoria) request.getAttribute("categoria"); %>
        <form action="CategoriaServlet" method="post">
            <input type="hidden" name="action" value="atualizar">
            <input type="hidden" name="cd_categ" value="<%= categoria.getCd_categ() %>">
            <div class="form-group">
                <label for="despesaReceita">Despesa/Receita:</label>
                <input type="text" class="form-control" id="despesaReceita" name="despesaReceita" value="<%= categoria.getTp_categ() %>" required>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <input type="text" class="form-control" id="descricao" name="descricao" value="<%= categoria.getDs_categ() %>" required>
            </div>
            <div class="form-group">
                <label for="subcategoria">Subcategoria:</label>
                <input type="text" class="form-control" id="subcategoria" name="subcategoria" value="<%= categoria.getDs_subcateg() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Atualizar</button>
            <a href="CategoriaServlet?action=remover&cd_categ=<%= categoria.getCd_categ() %>" class="btn btn-danger">Excluir</a>
        </form>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
