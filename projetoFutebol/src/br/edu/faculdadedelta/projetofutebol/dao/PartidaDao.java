package br.edu.faculdadedelta.projetofutebol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.projetofutebol.modelo.Partida;
import br.edu.faculdadedelta.projetofutebol.modelo.Status;
import br.edu.faculdadedelta.projetofutebol.modelo.Time;
import br.edu.faculdadedelta.projetofutebol.modelo.Time2;
import br.edu.faculdadedelta.projetofutebol.util.Conexao;

public class PartidaDao {

	public void incluir (Partida partida) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "INSERT INTO partida (id_status, id_time, id_time2, qtd_gol_time1, qtd_gol_time2, local_partida, "
				+ "horario) "
				+ "	VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, partida.getStatus().getIdStatus());
		ps.setLong(2, partida.getTime().getIdTime());
		ps.setLong(3, partida.getTime2().getIdTime2());
		ps.setInt(4, partida.getQtdGolTime());
		ps.setInt(5, partida.getQtdGolTime2());
		ps.setString(6, partida.getLocalPartida());
		ps.setString(7, partida.getHorario());
		
		ps.executeUpdate();
		
		Conexao.fecharConexao(ps, conn, null);
	}
	
	public void alterar (Partida partida) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "UPDATE partida "
				+ "SET id_status = ?, "
				+ "id_time = ?, "
				+ "id_time2 = ?, "
				+ "qtd_gol_time1 = ?, "
				+ "qtd_gol_time2 = ?, "
				+ "local_partida = ?, "
				+ "horario = ? "
				+ "WHERE id_partida = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, partida.getStatus().getIdStatus());
		ps.setLong(2, partida.getTime().getIdTime());
		ps.setLong(3, partida.getTime2().getIdTime2());
		ps.setInt(4, partida.getQtdGolTime());
		ps.setInt(5, partida.getQtdGolTime2());
		ps.setString(6, partida.getLocalPartida());
		ps.setString(7, partida.getHorario());
		ps.setLong(8, partida.getIdPartida());
		
		ps.executeUpdate();
		
		Conexao.fecharConexao(ps, conn, null);
	}
	
	public void excluir(Partida partida) throws ClassNotFoundException, SQLException {
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "DELETE FROM partida WHERE id_partida = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setLong(1, partida.getIdPartida());

		ps.executeUpdate();

		Conexao.fecharConexao(ps, conn, null);

	}
	
	public List<Partida> listar() throws ClassNotFoundException, SQLException {
		
		Connection conn = Conexao.conectarNoBancoDeDados();
		String sql = "SELECT p.id_partida AS idPartida, "
				+ "	p.qtd_gol_time1 AS qtdTime1, "
				+ "	p.qtd_gol_time1 AS qtdTime2, "
				+ "	p.local_partida AS localPartida, "
				+ "	p.horario AS horarioPartida, "
				
				+ "t1.id_time AS idTime, "
				+ "t1.nome_time1 AS nomeTime,"
				
				+ "	t2.id_time2 AS idTime2, "
				+ "	t2.nome_time2 AS nomeTime2, "
				
				+ "	s.id_status AS idStatus, "
				+ "	s.desc_status AS descStatus "
				
				+ "	FROM partida p "
				+ "	INNER JOIN time1 t1 ON p.id_time = t1.id_time "
				+ "	INNER JOIN time2 t2 ON p.id_time2 = t2.id_time2 "
				+ "	INNER JOIN status s ON p.id_status = s.id_status";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Partida> listaRetorno = new ArrayList<>();
		while (rs.next()) {
			
			Partida partida = new Partida();
			partida.setIdPartida(rs.getLong("idPartida"));
			partida.setLocalPartida(rs.getString("localPartida").trim());
			partida.setHorario(rs.getString("horarioPartida").trim());
			partida.setQtdGolTime(rs.getInt("qtdTime1"));
			partida.setQtdGolTime2(rs.getInt("qtdTime2"));
			
			Time time = new Time();
			time.setIdTime(rs.getLong("idTime"));
			time.setNomeTime(rs.getString("nomeTime").trim());
			
			Time2 time2 = new Time2();
			time2.setIdTime2(rs.getLong("idTime2"));
			time2.setNomeTime2(rs.getString("nomeTime2").trim());
			
			Status status = new Status();
			status.setIdStatus(rs.getLong("idStatus"));
			status.setDescStatus(rs.getString("descStatus"));
			
			partida.setTime(time);
			partida.setTime2(time2);
			partida.setStatus(status);
			
			listaRetorno.add(partida);
		}
		
		Conexao.fecharConexao(ps, conn, rs);
		
		return listaRetorno;
	}
}
