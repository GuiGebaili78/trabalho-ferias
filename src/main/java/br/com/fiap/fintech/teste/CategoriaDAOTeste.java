package br.com.fiap.fintech.teste;

import java.sql.SQLException;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;



public class CategoriaDAOTeste {

	public static void main(String[] args) throws SQLException, DBException {
		CategoriaDAO dao = DAOFactory.getCategoriaDAO();
		
		
		// Cadastrar uma despesa

		

		Categoria despesa = new Categoria();

		
		despesa.setTp_categ("Despesa");
		despesa.setDs_categ("Moradia");
		despesa.setDs_subcateg("Aluguel");

		dao.cadastrar(despesa);

		Categoria despesa2 = new Categoria();

		
		despesa2.setTp_categ("Despesa");
		despesa2.setDs_categ("Moradia");
		despesa2.setDs_subcateg("Conta de gás");

		dao.cadastrar(despesa2);

		Categoria receita = new Categoria();

		
		receita.setTp_categ("Receita");
		receita.setDs_categ("13º Salário");
		receita.setDs_subcateg("Empresa X");

		dao.cadastrar(receita);

		Categoria receita2 = new Categoria();

		
		receita2.setTp_categ("Receita");
		receita2.setDs_categ("Locação");
		receita2.setDs_subcateg("Casa Praia");

		dao.cadastrar(receita2);

		System.out.println(dao.listar());

	}

}
