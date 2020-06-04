package br.com.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.faculdadedelta.modelo.InfracaoPedro;
import br.edu.faculdadedelta.util.Conexao;

public class InfracaoDaoPedro {

	public void incluir(InfracaoPedro infracao) throws Exception {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "INSERT INTO infracoes (gravidade_infracao, descricao_infracao, valor_infracao) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		try {
			ps.setString(1, infracao.getGravidade().trim());
			ps.setString(2, infracao.getDesc().trim());
			ps.setDouble(3, infracao.getValorI());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, null);
		}
	}

	public void alterar(InfracaoPedro infracao) throws Exception {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "UPDATE infracaos SET gravidade_infracao=?, descricao_infracao=?, valor_infracao=?, WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		try {
			ps.setString(1, infracao.getGravidade().trim());
			ps.setString(2, infracao.getDesc().trim());
			ps.setDouble(3, infracao.getValorI());
			ps.setLong(4, infracao.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, null);
		}
	}

	public void excluir(InfracaoPedro infracao) throws Exception {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "DELETE FROM infracaos WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		try {
			ps.setLong(1, infracao.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, null);
		}
	}

	public List<InfracaoPedro> listar() throws Exception {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "SELECT * FROM infracoes";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<InfracaoPedro> listaRetorno = new ArrayList<>();
		try {
			while (rs.next()) {
				InfracaoPedro infracao = new InfracaoPedro();
				infracao.setId(rs.getLong("id"));
				infracao.setGravidade(rs.getString("gravidade_infracao").trim());
				infracao.setDesc(rs.getString("descricao_infracao").trim());
				infracao.setValorI(rs.getDouble("valor_infracao"));
				listaRetorno.add(infracao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, rs);
		}
		return listaRetorno;
	}

	public InfracaoPedro pesquisarPorId(Long id) throws Exception {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "SELECT * FROM infracoes WHERE id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		InfracaoPedro retorno = new InfracaoPedro();
		try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				retorno.setId(rs.getLong("id"));
				retorno.setGravidade(rs.getString("gravidade_infracao").trim());
				retorno.setDesc(rs.getString("descricao_infracao").trim());
				retorno.setValorI(rs.getDouble("valor_infracao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		} finally {
			Conexao.fecharConexao(conn, ps, rs);
		}
		return retorno;
	}
}