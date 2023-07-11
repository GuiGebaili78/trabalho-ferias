package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CategoriaServlet")
// Se for preciso mapear outros caminhos para este mesmo arquivo podemos usar (url-pattern = {"/qualquernome", "/outronome", etc...})

public class CategoriaServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>Primeira página Servlet</h1>");
		writer.println("</body>");
		writer.println("</html>");

	}
}
