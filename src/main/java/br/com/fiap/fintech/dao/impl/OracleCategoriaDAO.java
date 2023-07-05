package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.fintech.bean.Categoria;
import br.com.fiap.fintech.dao.CategoriaDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.singleton.ConnectionManager;

public class OracleCategoriaDAO implements CategoriaDAO {

	private Connection conexao;

	// Cadastrar categoria no banco de dados
	@Override

	public void cadastrar(Categoria categoria) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			ConnectionManager.getinstance().getConnection();
		String sql = "insert into tb_categoria(cd_categ,tp_categ,ds_categ,ds_subcateg, data) values (SQ_TB_CATEGORIA.NEXTVAL, ?,?,?,?)";
		stmt = conexao.prepareStatement(sql);
		stmt = setString(1, categoria.getTp_categ());
		stmt = setString (2, categoria.getDs_categ());
		stmt = setString(3, categoria.getDs_subcateg());
		stmt = setDate (4, categoria.getData());
		
		stmt.executeUpdate();
		} catch (SQLExeption e) {
			e.printStackTrace();
			throw new DBExeption ("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
			} catch (SQLExeption e) {
				e.printStackTrace();
			}
		}
	}
	
			}
		
		

	
		}
	}
}
