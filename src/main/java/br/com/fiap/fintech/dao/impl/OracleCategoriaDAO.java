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

	
	@Override
	public void cadastrar(Categoria categoria) throws DBException {
		try (Connection conexao = ConnectionManager.getinstance().getConnection();
			 PreparedStatement stmt = conexao.prepareStatement("INSERT INTO tb_categoria(cd_categ,tp_categ,ds_categ,ds_subcateg, data) VALUES (SQ_TB_CATEGORIA.NEXTVAL, ?,?,?,?)")) {
			stmt.setString(1, categoria.getTp_categ());
			stmt.setString(2, categoria.getDs_categ());
			stmt.setString(3, categoria.getDs_subcateg());
			stmt.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Erro ao cadastrar.", e);
		}
	}

	@Override
	public void atualizar(Categoria categoria) throws DBException {
		try (Connection conexao = ConnectionManager.getinstance().getConnection();
			 PreparedStatement stmt = conexao.prepareStatement("UPDATE tb_categoria SET tp_categ = ?, ds_categ = ?, ds_subcateg = ?, data = ? WHERE cd_categ = ?")) {
			stmt.setString(1, categoria.getTp_categ());
			stmt.setString(2, categoria.getDs_categ());
			stmt.setString(3, categoria.getDs_subcateg());
			stmt.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setInt(5, categoria.getCd_categ());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Erro ao atualizar.", e);
		}
	}

	@Override
	public void remover(int cd_categ) throws DBException {
		try (Connection conexao = ConnectionManager.getinstance().getConnection();
			 PreparedStatement stmt = conexao.prepareStatement("DELETE FROM tb_categoria WHERE cd_categ = ?")) {
			stmt.setInt(1, cd_categ);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("Erro ao remover.", e);
		}
	}

	@Override
	public Categoria buscar(int cd_categ) {
		Categoria categoria = null;
		try (Connection conexao = ConnectionManager.getinstance().getConnection();
			 PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM tb_categoria WHERE cd_categ = ?")) {
			stmt.setInt(1, cd_categ);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					categoria = new Categoria();
					categoria.setCd_categ(rs.getInt("cd_categ"));
					categoria.setTp_categ(rs.getString("tp_categ"));
					categoria.setDs_categ(rs.getString("ds_categ"));
					categoria.setDs_subcateg(rs.getString("ds_subcateg"));
					Date dataSQL = rs.getDate("data");
					Calendar data = Calendar.getInstance();
					data.setTime(dataSQL);
					categoria.setData(data);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria;
	}

	@Override
	public List<Categoria> listar() {
		List<Categoria> lista = new ArrayList<>();
		try (Connection conexao = ConnectionManager.getinstance().getConnection();
			 PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM tb_categoria");
			 ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setCd_categ(rs.getInt("cd_categ"));
				categoria.setTp_categ(rs.getString("tp_categ"));
				categoria.setDs_categ(rs.getString("ds_categ"));
				categoria.setDs_subcateg(rs.getString("ds_subcateg"));
				Date dataSQL = rs.getDate("data");
				Calendar data = Calendar.getInstance();
				data.setTime(dataSQL);
				categoria.setData(data);
				lista.add(categoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
