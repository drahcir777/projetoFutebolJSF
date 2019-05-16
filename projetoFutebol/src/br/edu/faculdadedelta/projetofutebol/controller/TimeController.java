package br.edu.faculdadedelta.projetofutebol.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.faculdadedelta.projetofutebol.dao.TimeDao;
import br.edu.faculdadedelta.projetofutebol.modelo.Time;
import br.edu.faculdadedelta.projetofutebol.util.FacesUtil;

@ManagedBean
@SessionScoped
public class TimeController {

	private Time time = new Time();
	private TimeDao dao = new TimeDao();
	
	private static final String PAGINA_CADASTRO_TIME = "cadastroTime.xhtml";
	private static final String PAGINA_LISTA_TIME = "listaTime.xhtml";
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	public void limparCampos() {
		time = new Time();
	}
	
	public String salvar() {
		try {

			if (time.getIdTime() == null) {
				dao.incluir(time);
				FacesUtil.exibirMensagem("Inclusão realizada com sucesso!");
				
				limparCampos();
			} else {
			//ALTERAR
				dao.alterar(time);
				FacesUtil.exibirMensagem("Alteração realizada com sucesso!");
				limparCampos();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getStackTrace();
			FacesUtil.exibirMensagem("Erro ao realizar a operação!" + e.getMessage());
		}
		return PAGINA_CADASTRO_TIME;
	}
	
	public String excluir() {
		try {
			dao.excluir(time);
			FacesUtil.exibirMensagem("Exclusão realizada com sucesso!");
			limparCampos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagem("Erro ao realizar a operação!" + e.getMessage());
		}
		return PAGINA_LISTA_TIME;
	}
	
	public String editar() {
		return PAGINA_CADASTRO_TIME;
	}
	
	public List<Time> getLista() {
		List<Time> listaRetorno = new ArrayList<>();
		try {
			listaRetorno = dao.listar();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagem("Erro ao realizar a operação. " + e.getMessage());
			
		}
		return listaRetorno;
		
	}
}
