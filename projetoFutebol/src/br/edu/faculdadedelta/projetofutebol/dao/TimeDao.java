package br.edu.faculdadedelta.projetofutebol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.projetofutebol.modelo.Time;
import br.edu.faculdadedelta.projetofutebol.util.Conexao;

public class TimeDao {

	public void incluir (Time time) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "INSERT INTO time1 (nome_time1) "
				+ "	VALUES (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, time.getNomeTime().trim());
		
		ps.executeUpdate();
		
		Conexao.fecharConexao(ps, conn, null);
	}
	
	public void alterar (Time time) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "UPDATE time1 "
				+ "SET nome_time1 = ? "
				+ "WHERE id_time = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, time.getNomeTime().trim());
		ps.setLong(2, time.getIdTime());
		
		ps.executeUpdate();
		
		Conexao.fecharConexao(ps, conn, null);
	}
	
	public void excluir(Time time) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "DELETE FROM time1 WHERE nome_time1 = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setLong(1, time.getIdTime());

		ps.executeUpdate();

		Conexao.fecharConexao(ps, conn, null);

	}
	
	public Time pesquisarPorId(Long id) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "SELECT id_time, nome_time1 "
				+ "FROM time1 "
				+ "WHERE id_time = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setLong(1, id);
		
		ResultSet rs = ps.executeQuery();
		Time retorno = new Time();
		if (rs.next()) {
			retorno = popularTime(rs);
		}
		Conexao.fecharConexao(ps, conn, rs);
		
		return retorno;
		
	}
	
	public List<Time> listar() throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "SELECT id_time, nome_time1 "
				+ "FROM time1";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		List<Time> listaRetorno = new ArrayList<>();
		
		while(rs.next()) {
			Time time = new Time();
			time.setIdTime(rs.getLong("id_time"));
			time.setNomeTime(rs.getString("nome_time1"));
			
			listaRetorno.add(time);
		}
		
		Conexao.fecharConexao(ps, conn, rs);
		
		return listaRetorno;
	}
	
	private Time popularTime(ResultSet rs) throws SQLException {
		
		Time time = new Time();
		time.setIdTime(rs.getLong("id_time"));
		time.setNomeTime(rs.getString("nome_time1"));
		
		return time;
	}
}
