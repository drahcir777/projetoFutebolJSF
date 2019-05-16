package br.edu.faculdadedelta.projetofutebol.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.faculdadedelta.projetofutebol.dao.PartidaDao;
import br.edu.faculdadedelta.projetofutebol.modelo.Partida;
import br.edu.faculdadedelta.projetofutebol.modelo.Status;
import br.edu.faculdadedelta.projetofutebol.modelo.Time;
import br.edu.faculdadedelta.projetofutebol.modelo.Time2;
import br.edu.faculdadedelta.projetofutebol.util.FacesUtil;

@ManagedBean
@SessionScoped
public class PartidaController {

	private Partida partida = new Partida();
	private PartidaDao dao = new PartidaDao();
	private Time timeSelecionado = new Time();
	private Time2 time2Selecionado = new Time2();
	private Status statusSelecionado = new Status();
	
	private static final String PAGINA_CADASTRO_PARTIDA = "cadastroPartida.xhtml";
	private static final String PAGINA_LISTA_PARTIDA = "listaPartida.xhtml";
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public Time getTimeSelecionado() {
		return timeSelecionado;
	}
	public void setTimeSelecionado(Time timeSelecionado) {
		this.timeSelecionado = timeSelecionado;
	}
	public Time2 getTime2Selecionado() {
		return time2Selecionado;
	}
	public void setTime2Selecionado(Time2 time2Selecionado) {
		this.time2Selecionado = time2Selecionado;
	}
	public Status getStatusSelecionado() {
		return statusSelecionado;
	}
	public void setStatusSelecionado(Status statusSelecionado) {
		this.statusSelecionado = statusSelecionado;
	}
	
	public void limparCampos() {
		partida = new Partida();
		timeSelecionado = new Time();
		time2Selecionado = new Time2();
		statusSelecionado = new Status();
	}
	
	public String salvar() {
		try {
			if (partida.getIdPartida() == null) {
				partida.setTime(timeSelecionado);
				partida.setTime2(time2Selecionado);
				partida.setStatus(statusSelecionado);
				dao.incluir(partida);
				FacesUtil.exibirMensagem("Inclusão realizada com sucesso!");
				limparCampos();
			} else {
				partida.setTime(timeSelecionado);
				partida.setTime2(time2Selecionado);
				partida.setStatus(statusSelecionado);
				dao.alterar(partida);
				FacesUtil.exibirMensagem("Alteração realizada com sucesso!");
				limparCampos();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagem("Erro ao realizar a operação: " + e.getMessage());
		}
		return PAGINA_CADASTRO_PARTIDA;
	}
	
	public String excluir() {
		try { 
			dao.excluir(partida);
			FacesUtil.exibirMensagem("Exclusão realizada com sucesso!");
			limparCampos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagem("Erro ao realizar a operação: " + e.getMessage());
		}
		return PAGINA_LISTA_PARTIDA;
	}
	
	public String editar() {
		timeSelecionado = partida.getTime();
		time2Selecionado = partida.getTime2();
		statusSelecionado = partida.getStatus();
		return PAGINA_CADASTRO_PARTIDA;
	}
	
	public List<Partida> getLista() {
		List<Partida> listaRetorno = new ArrayList<>();
		try {
			listaRetorno = dao.listar();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagem("Erro ao realizar a operação: " + e.getMessage());
		}
		return listaRetorno;
	}
}
