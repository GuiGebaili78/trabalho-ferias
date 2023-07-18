<!-- listar-categorias.jsp -->
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.fintech.bean. * " %>
<%@ page import="br.com.fiap.fintech.dao. * " %>
<%@ page import="br.com.fiap.fintech.controller. * " %>
<%@ page import="br.com.fiap.fintech.dao.impl. * " %>
<%@ page import="br.com.fiap.fintech.factory. * " %>
<%@ page import="br.com.fiap.fintech.singleton. * " %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Categorias</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../includes/header.jsp" %>
    <div class="container">
        <h1>Lista de Categorias</h1>
        <a href="cadastro-categoria.jsp" class="btn btn-primary">Cadastrar Categoria</a>
        <br><br>
        <table class="table">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Despesa/Receita</th>
                    <th>Descrição</th>
                    <th>Subcategoria</th>
                    <th>Data</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <% List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
                for (Categoria categoria : categorias) { %>
                <tr>
                    <td><%= categoria.getCd_categ() %></td>
                    <td><%= categoria.getTp_categ() %></td>
                    <td><%= categoria.getDs_categ() %></td>
                    <td><%= categoria.getDs_subcateg() %></td>
                    <td><%= categoria.getData() %></td>
                    <td>
                        <a href="alteracao-cadastro.jsp?cd_categ=<%= categoria.getCd_categ() %>" class="btn btn-info">Alterar</a>
                        <a href="CategoriaServlet?action=remover&cd_categ=<%= categoria.getCd_categ() %>" class="btn btn-danger">Excluir</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <%@ include file="../includes/footer.jsp" %>
</body>
</html>
