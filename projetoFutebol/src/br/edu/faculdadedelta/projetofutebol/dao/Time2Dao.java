package br.edu.faculdadedelta.projetofutebol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.projetofutebol.modelo.Time2;
import br.edu.faculdadedelta.projetofutebol.util.Conexao;

public class Time2Dao {
	
		public void incluir (Time2 time2) throws ClassNotFoundException, SQLException {
			
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "INSERT INTO time2 (nome_time2) VALUES (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, time2.getNomeTime2().trim());
			
			ps.executeUpdate();
			Conexao.fecharConexao(ps, conn, null);
		}
		
		public void alterar (Time2 time2) throws ClassNotFoundException, SQLException {
			
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "UPDATE time2 "
					+ "SET nome_time2 = ? "
					+ "WHERE id_time2 = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, time2.getNomeTime2().trim());
			ps.setLong(2, time2.getIdTime2());
			
			ps.executeUpdate();
			
			Conexao.fecharConexao(ps, conn, null);
		}
		
		public void excluir(Time2 time2) throws ClassNotFoundException, SQLException {
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "DELETE FROM time2 WHERE id_time2 = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, time2.getIdTime2());
			
			ps.executeUpdate();
			
			Conexao.fecharConexao(ps, conn, null);
		}
		
		public Time2 pesquisarPorId(Long id) throws ClassNotFoundException, SQLException {
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "SELECT id_time2, nome_time2 "
					+ "FROM time2 "
					+ "WHERE id_time2 = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			Time2 retorno = new Time2();
			if (rs.next()) {
				retorno = popularTime2(rs);
			}
			Conexao.fecharConexao(ps, conn, rs);
			
			return retorno;
		}
		
		public List<Time2> listar() throws ClassNotFoundException, SQLException {
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "SELECT id_time2, nome_time2 "
					+ "FROM time2";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			List<Time2> listaRetorno = new ArrayList<>();
			
			while(rs.next()) {
				Time2 time2 = new Time2();
				time2.setIdTime2(rs.getLong("id_time2"));
				time2.setNomeTime2(rs.getString("nome_time2").trim());
				
				listaRetorno.add(time2);
			}
			
			Conexao.fecharConexao(ps, conn, rs);
			
			return listaRetorno;
		}
		
		private Time2 popularTime2(ResultSet rs) throws SQLException {
			
			Time2 time2 = new Time2();
			time2.setIdTime2(rs.getLong("id_time2"));
			time2.setNomeTime2(rs.getString("nome_time2").trim());
			
			return time2;
		}
	}
