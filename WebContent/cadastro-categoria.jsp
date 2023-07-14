<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Categoria</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2>Cadastro de Categoria</h2>
        <div class="row">
            <div class="col">
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#inserirModal">Inserir</button>
            </div>
            <div class="col">
                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#atualizarModal">Atualizar</button>
            </div>
            <div class="col">
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#excluirModal">Remover</button>
            </div>
        </div>
        
        <hr>
        
        <form method="post" action="CategoriaServlet">
            <div class="form-group">
                <label for="despesaReceita">Despesa / Receita:</label>
                <div class="input-group">
                    <select class="custom-select" id="despesaReceita" name="despesaReceita">
                        <option selected>Escolha uma opção</option>
                        <option value="despesa">Despesa</option>
                        <option value="receita">Receita</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="ds_categ">Descrição:</label>
                <input type="text" class="form-control" id="ds_categ" name="ds_categ">
            </div>
            <div class="form-group">
                <label for="ds_subcateg">Subcategoria:</label>
                <input type="text" class="form-control" id="ds_subcateg" name="ds_subcateg">
            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
    </div>
    
    <!-- Modal Inserir -->
    <div class="modal fade" id="inserirModal" tabindex="-1" role="dialog" aria-labelledby="inserirModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="inserirModalLabel">Inserir Tipo</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Conteúdo do formulário para inserir o tipo -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <button type="button" class="btn btn-primary">Salvar</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Modal Atualizar -->
    <div class="modal fade" id="atualizarModal" tabindex="-1" role="dialog" aria-labelledby="atualizarModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="atualizarModalLabel">Atualizar Tipo</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Conteúdo do formulário para atualizar o tipo -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <button type="button" class="btn btn-primary">Atualizar</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Modal Remover -->
    <div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="excluirModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="excluirModalLabel">Remover Tipo</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Conteúdo do formulário para remover o tipo -->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    <button type="button" class="btn btn-danger">Remover</button>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
