package br.com.fiap.fintech.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
			conexao = ConnectionManager.getinstance().getConnection();
			String sql = "insert into tb_categoria(cd_categ,tp_categ,ds_categ,ds_subcateg, data) values (SQ_TB_CATEGORIA.NEXTVAL, ?,?,?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoria.getTp_categ());
			stmt.setString(2, categoria.getDs_categ());
			stmt.setString(3, categoria.getDs_subcateg());
			java.util.Date currentDate = new java.util.Date();
            stmt.setDate(4, new Date(currentDate.getTime()));
			stmt.executeUpdate();
			
			
		}  catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastradar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(Categoria categoria) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getinstance().getConnection();
			String sql = "update tb_categoria set tp_categ = ?, ds_categ = ?,ds_subcateg = ?, data = ?, where cd_categ = ? ";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, categoria.getTp_categ());
			stmt.setString(2, categoria.getDs_categ());
			stmt.setString(3, categoria.getDs_subcateg());
			java.util.Date currentDate = new java.util.Date();
            stmt.setDate(4, new Date(currentDate.getTime()));
			stmt.setInt(5, categoria.getCd_categ());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}

	@Override
	public void remover(int cd_categ) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getinstance().getConnection();
			String sql = "delete from tb_categoria where cd_categ = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cd_categ);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}

	@Override
	public Categoria buscar(int cd_categ) {
		Categoria categoria = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getinstance().getConnection();
			stmt = conexao.prepareStatement("select * from tb_categoria = tb_categoria.cd_categ = ?");
			stmt.setInt(1, cd_categ);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("cd_categ");
				String tipo = rs.getString("tp_categ");
				String descricao = rs.getString("ds_categ");
				String subcateg = rs.getString("ds_subcateg");
				java.sql.Date dataSQL = rs.getDate("data");
                Calendar data = Calendar.getInstance();
                data.setTimeInMillis(dataSQL.getTime());

				String tp_categ;
				String ds_categ;
				String ds_subcateg;
				categoria = new Categoria();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return categoria;
	}

	@Override
	public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

	try {
		conexao = ConnectionManager.getinstance().getConnection();

		stmt = conexao.prepareStatement("select * from tb_categoria");
		rs = stmt.executeQuery();

		// Precorre os registros encontrados
		while (rs.next()) {
			int codigo = rs.getInt("cd_categ");
			String tipo = rs.getString("tp_categ");
			String descricao = rs.getString("ds_categ");
			String subcateg = rs.getString("ds_subcateg");
			java.sql.Date dataSQL = rs.getDate("data");
            Calendar data = Calendar.getInstance();
            data.setTimeInMillis(dataSQL.getTime());


            String tp_categ;
			String ds_categ;
			String ds_subcateg;
			Categoria categoria = new Categoria();
            lista.add(categoria);
		}

		} catch(SQLException e)
	{
		e.printStackTrace();
	}finally
	{
		try {
			stmt.close();
			rs.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}return lista;

	}
}
