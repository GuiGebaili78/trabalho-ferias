package br.com.fiap.fintech.factory;

import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.dao.impl.OracleCategoriaDAO;

public class DAOFactory {
	
	public static CategoriaDAO getCategoriaDAO() {
		return new OracleCategoriaDAO();
	}

}
