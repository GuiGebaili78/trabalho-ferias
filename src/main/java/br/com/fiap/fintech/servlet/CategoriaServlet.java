package br.com.fiap.fintech.servlet;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.dao.impl.OracleCategoriaDAO;
import br.com.fiap.fintech.exception.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoriaServlet extends HttpServlet {

    private CategoriaDAO categoriaDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        categoriaDAO = new OracleCategoriaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "create":
                    cadastrarCategoria(request, response);
                    break;
                case "update":
                    atualizarCategoria(request, response);
                    break;
                case "delete":
                    removerCategoria(request, response);
                    break;
                default:
                    response.sendRedirect("categoria.jsp");
                    break;
            }
        } else {
            response.sendRedirect("categoria.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "edit":
                    exibirFormularioEdicao(request, response);
                    break;
                default:
                    response.sendRedirect("categoria.jsp");
                    break;
            }
        } else {
            listarCategorias(request, response);
        }
    }

    private void cadastrarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String despesaReceita = request.getParameter("despesaReceita");
        String descricao = request.getParameter("ds_categ");
        String subcategoria = request.getParameter("ds_subcateg");

        Categoria categoria = new Categoria();
        categoria.setTp_categ(despesaReceita);
        categoria.setDs_categ(descricao);
        categoria.setDs_subcateg(subcategoria);

        try {
            categoriaDAO.cadastrar(categoria);
            response.sendRedirect("CategoriaServlet"); // Redireciona para a página de categorias após o cadastro
        } catch (DBException e) {
            // Trate a exceção adequadamente de acordo com o seu fluxo de erro
            e.printStackTrace();
            response.sendRedirect("erro.jsp"); // Redireciona para a página de erro
        }
    }

    private void atualizarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("cd_categ"));
        String despesaReceita = request.getParameter("despesaReceita");
        String descricao = request.getParameter("ds_categ");
        String subcategoria = request.getParameter("ds_subcateg");

        Categoria categoria = new Categoria();
        categoria.setCd_categ(codigo);
        categoria.setTp_categ(despesaReceita);
        categoria.setDs_categ(descricao);
        categoria.setDs_subcateg(subcategoria);

        try {
            categoriaDAO.atualizar(categoria);
            response.sendRedirect("CategoriaServlet"); // Redireciona para a página de categorias após a atualização
        } catch (DBException e) {
            // Trate a exceção adequadamente de acordo com o seu fluxo de erro
            e.printStackTrace();
            response.sendRedirect("erro.jsp"); // Redireciona para a página de erro
        }
    }

    private void removerCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("cd_categ"));

        try {
            categoriaDAO.remover(codigo);
            response.sendRedirect("CategoriaServlet"); // Redireciona para a página de categorias após a remoção
        } catch (DBException e) {
            // Trate a exceção adequadamente de acordo com o seu fluxo de erro
            e.printStackTrace();
            response.sendRedirect("erro.jsp"); // Redireciona para a página de erro
        }
    }

    private void exibirFormularioEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("cd_categ"));
        Categoria categoria = categoriaDAO.buscar(codigo);
        request.setAttribute("categoria", categoria);
        request.getRequestDispatcher("editar_categoria.jsp").forward(request, response);
    }

    private void listarCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> categorias = categoriaDAO.listar();
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("categoria.jsp").forward(request, response);
    }
}
