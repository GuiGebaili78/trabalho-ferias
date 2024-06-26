package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.dao.impl.OracleCategoriaDAO;
import br.com.fiap.fintech.exception.DBException;

@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAO categoriaDAO;

	public void init() {
		categoriaDAO = new OracleCategoriaDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "list":
				listarCategorias(request, response);
				break;
			default:
				response.sendRedirect("categoria-cadastrar.jsp");
				break;
			}
		} else {
			response.sendRedirect("categoria-cadastrar.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("cadastrar")) {
			cadastrarCategoria(request, response);
		} else if (action != null && action.equals("alterar")) {
			atualizarCategoria(request, response);
		} else if (action != null && action.equals("excluir")) {
			excluirCategoria(request, response);
		} else {
			response.sendRedirect("categoria-cadastrar.jsp");
		}
	}

	private void cadastrarCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Categoria categoria = new Categoria();
		categoria.setTp_categ(request.getParameter("despesaReceita"));
		categoria.setDs_categ(request.getParameter("descricao"));
		categoria.setDs_subcateg(request.getParameter("subcategoria"));

		try {
			categoriaDAO.cadastrar(categoria);
			request.setAttribute("msg", "Categoria cadastrada!");
			request.getRequestDispatcher("categoria-cadastrar.jsp").forward(request, response);
		} catch (DBException e) {
			request.setAttribute("erro", "Erro ao cadastrar categoria!");
			request.getRequestDispatcher("categoria-cadastrar.jsp").forward(request, response);
		}
	}

	private void atualizarCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cd_categ = Integer.parseInt(request.getParameter("cd_categ"));
		Categoria categoria = categoriaDAO.buscar(cd_categ);
		if (categoria != null) {
			categoria.setTp_categ(request.getParameter("despesaReceita"));
			categoria.setDs_categ(request.getParameter("descricao"));
			categoria.setDs_subcateg(request.getParameter("subcategoria"));

			try {
				categoriaDAO.atualizar(categoria);
				response.sendRedirect("CategoriaServlet?action=list");
			} catch (DBException e) {
				response.sendRedirect("categoria-alterar.jsp?erro=" + e.getMessage());
			}
		} else {
			response.sendRedirect("categoria-listar.jsp?erro=Categoria não encontrada");
		}
	}

	private void excluirCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cd_categ = Integer.parseInt(request.getParameter("cd_categ"));
		try {
			categoriaDAO.remover(cd_categ);
			response.sendRedirect("CategoriaServlet?action=list");
		} catch (DBException e) {
			response.sendRedirect("categoria-excluir.jsp?erro=" + e.getMessage());
		}
	}

	private void listarCategorias(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categoria> categorias = categoriaDAO.listar();
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("categoria-listar.jsp").forward(request, response);
	}
}
