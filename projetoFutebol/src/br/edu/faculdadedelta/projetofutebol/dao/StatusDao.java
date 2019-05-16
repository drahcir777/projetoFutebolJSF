package br.edu.faculdadedelta.projetofutebol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.projetofutebol.modelo.Status;
import br.edu.faculdadedelta.projetofutebol.util.Conexao;

public class StatusDao {
	
		public void incluir (Status status) throws ClassNotFoundException, SQLException {
			
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "INSERT INTO status (desc_status) VALUES (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, status.getDescStatus().trim());
			
			ps.executeUpdate();
			Conexao.fecharConexao(ps, conn, null);
		}
		
		public void alterar (Status status) throws ClassNotFoundException, SQLException {
			
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "UPDATE status "
					+ "SET desc_status = ? "
					+ "WHERE id_status = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, status.getDescStatus().trim());
			ps.setLong(2, status.getIdStatus());
			
			ps.executeUpdate();
			
			Conexao.fecharConexao(ps, conn, null);
		}
		
		public void excluir(Status status) throws ClassNotFoundException, SQLException {
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "DELETE FROM status WHERE id_status = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, status.getIdStatus());
			
			ps.executeUpdate();
			
			Conexao.fecharConexao(ps, conn, null);
		}
		
		public Status pesquisarPorId(Long id) throws ClassNotFoundException, SQLException {
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "SELECT id_status, desc_status "
					+ "FROM status "
					+ "WHERE id_status = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			Status retorno = new Status();
			if (rs.next()) {
				retorno = popularStatus(rs);
			}
			Conexao.fecharConexao(ps, conn, rs);
			
			return retorno;
		}
		
		public List<Status> listar() throws ClassNotFoundException, SQLException {
			Connection conn = Conexao.conectarNoBancoDeDados();
			String sql = "SELECT id_status, desc_status "
					+ "FROM status";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			List<Status> listaRetorno = new ArrayList<>();
			
			while(rs.next()) {
				Status status = new Status();
				status.setIdStatus(rs.getLong("id_status"));
				status.setDescStatus(rs.getString("desc_status").trim());
				
				listaRetorno.add(status);
			}
			
			Conexao.fecharConexao(ps, conn, rs);
			
			return listaRetorno;
		}
		
		private Status popularStatus(ResultSet rs) throws SQLException {
			
			Status status = new Status();
			status.setIdStatus(rs.getLong("id_status"));
			status.setDescStatus(rs.getString("desc_status").trim());
			
			return status;
		}
	}
