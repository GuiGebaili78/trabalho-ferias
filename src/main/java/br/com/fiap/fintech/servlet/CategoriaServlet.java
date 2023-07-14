package br.com.fiap.fintech.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.dao.impl.OracleCategoriaDAO;
import br.com.fiap.fintech.exception.DBException;

public class CategoriaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoriaDAO categoriaDAO;

    public void init() {
        categoriaDAO = new OracleCategoriaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "list":
                    listarCategorias(request, response);
                    break;
                case "search":
                    buscarCategoria(request, response);
                    break;
                case "delete":
                    excluirCategoria(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "create":
                    cadastrarCategoria(request, response);
                    break;
                case "update":
                    atualizarCategoria(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    private void listarCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categoria> categorias = categoriaDAO.listar();
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("listagem.jsp").forward(request, response);
    }

    private void buscarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        Categoria categoria = categoriaDAO.buscar(codigo);

        if (categoria != null) {
            request.setAttribute("categoria", categoria);
            request.getRequestDispatcher("visualizar.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    private void cadastrarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipoCategoria = request.getParameter("despesaReceita");
        String descricao = request.getParameter("descricao");
        String subcategoria = request.getParameter("subcategoria");

        Categoria categoria = new Categoria();
        categoria.setTp_categ(tipoCategoria);
        categoria.setDs_categ(descricao);
        categoria.setDs_subcateg(subcategoria);

        try {
            categoriaDAO.cadastrar(categoria);
            response.sendRedirect("CategoriaServlet?action=list");
        } catch (DBException e) {
            request.setAttribute("mensagem", "Erro ao cadastrar categoria.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void atualizarCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String tipoCategoria = request.getParameter("despesaReceita");
        String descricao = request.getParameter("descricao");
        String subcategoria = request.getParameter("subcategoria");

        Categoria categoria = new Categoria();
        categoria.setCd_categ(codigo);
        categoria.setTp_categ(tipoCategoria);
        categoria.setDs_categ(descricao);
        categoria.setDs_subcateg(subcategoria);

        try {
            categoriaDAO.atualizar(categoria);
            response.sendRedirect("CategoriaServlet?action=list");
        } catch (DBException e) {
            request.setAttribute("mensagem", "Erro ao atualizar categoria.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private void excluirCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));

        try {
            categoriaDAO.remover(codigo);
            response.sendRedirect("CategoriaServlet?action=list");
        } catch (DBException e) {
            request.setAttribute("mensagem", "Erro ao excluir categoria.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
