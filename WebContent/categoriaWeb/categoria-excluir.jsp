<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Excluir Categoria</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h3>Excluir Categoria</h3>
        <form action="excluirCategoriaServlet" method="post">
            <!-- Adicione os campos do formulário conforme necessário -->
            <div class="form-group">
                <label for="cd_categ">Código da Categoria:</label>
                <input type="text" class="form-control" id="cd_categ" name="cd_categ" required>
            </div>
            
            <!-- Adicione outros campos do formulário conforme necessário -->
            
            <button type="submit" class="btn btn-danger">Excluir Categoria</button>
        </form>
    </div>
    
    <!-- Bootstrap e scripts JavaScript -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
