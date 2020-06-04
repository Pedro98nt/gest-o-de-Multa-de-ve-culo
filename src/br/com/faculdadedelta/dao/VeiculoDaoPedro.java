package br.com.faculdadedelta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.faculdadedelta.modelo.InfracaoPedro;
import br.com.faculdadedelta.modelo.VeiculoPedro;
import br.edu.faculdadedelta.util.Conexao;

public class VeiculoDaoPedro {

	public void incluir(VeiculoPedro veiculo) throws Exception {
		Connection conn  = Conexao.conectarNoBancoDeDados();
		String sql = "INSERT INTO veiculos (gravidade_veiculo, descricao_veiculo) VALUES (?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		try {
			ps.setString(1,  veiculo.getGravidade().trim());
			ps.setString(2, veiculo.getDesc().trim());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			Conexao.fecharConexao(conn, ps, null);
		}}
	
	public void alterar(VeiculoPedro veiculo) throws Exception{
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "UPDATE veiculos SET gravidade_veiculo=?, descricao_veiculo=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
	    try {
			ps.setString(1, veiculo.getGravidade().trim());
			ps.setString(2, veiculo.getDesc().trim());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}finally {
			Conexao.fecharConexao(conn, ps, null);
		}}
	
	public void excluir(VeiculoPedro veiculo) throws Exception{
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "DELETE FROM veiculos WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		try {
			ps.setLong(1, veiculo.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}finally {
			Conexao.fecharConexao(conn, ps, null);
		}}
	
	public List<VeiculoPedro> listar() throws Exception{
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "SELECT * FROM veiculos";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<VeiculoPedro> listaRetorno = new ArrayList<>();
		try {
			while (rs.next()) {
				VeiculoPedro veiculo = new VeiculoPedro();
				veiculo.setId(rs.getLong("id"));
				veiculo.setGravidade(rs.getString("gravidade_veiculo"));
				veiculo.setDesc(rs.getString("descricao_veiculo"));
				listaRetorno.add(veiculo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e);
		}finally {
			Conexao.fecharConexao(conn, ps, rs);
		}
		return listaRetorno;
		}
	
    public  InfracaoPedro pesquisarPorId(Long id) throws Exception {
    	Connection conn = Conexao.conectarNoBancoDeDados();
    	String sql = "SELECT * FROM veiculos WHERE id=?";
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	InfracaoPedro retorno = new InfracaoPedro();
    	try {
			ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				retorno.setId(rs.getLong("id"));
				retorno.setGravidade(rs.getString("gravidade_veiculo").trim());
				retorno.setDesc(rs.getString("descricao_veiculo").trim());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		} finally {
			Conexao.fecharConexao(conn, ps, rs);
		}
    	return retorno;
        }}