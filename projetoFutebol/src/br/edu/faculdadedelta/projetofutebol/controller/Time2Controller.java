package br.edu.faculdadedelta.projetofutebol.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.faculdadedelta.projetofutebol.dao.Time2Dao;
import br.edu.faculdadedelta.projetofutebol.modelo.Time2;
import br.edu.faculdadedelta.projetofutebol.util.FacesUtil;

@ManagedBean
@SessionScoped
public class Time2Controller {

	private Time2 time2 = new Time2();
	private Time2Dao dao = new Time2Dao();
	
	private static final String PAGINA_CADASTRO_TIME2 = "cadastraTime2.xhtml";
	private static final String PAGINA_LISTA_TIME2 = "listaTime2.xhtml";
	public Time2 getTime2() {
		return time2;
	}
	public void setTime2(Time2 time2) {
		this.time2 = time2;
	}
	
	public void limparCampos() {
		time2 = new Time2();
	}
	
	public String salvar() {
		try {
			//INCLUIR
			if (time2.getIdTime2() == null) {
				dao.incluir(time2);
				FacesUtil.exibirMensagem("Inclusão realizada com sucesso!");
				
				limparCampos();
			} else {
			//ALTERAR
				dao.alterar(time2);
				FacesUtil.exibirMensagem("Alteração realizada com sucesso!");
				limparCampos();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getStackTrace();
			FacesUtil.exibirMensagem("Erro ao realizar a operação!" + e.getMessage());
		}
		return PAGINA_CADASTRO_TIME2;
	}
	
	public String excluir() {
		try {
			dao.excluir(time2);
			FacesUtil.exibirMensagem("Exclusão realizada com sucesso!");
			limparCampos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagem("Erro ao realizar a operação!" + e.getMessage());
		}
		return PAGINA_LISTA_TIME2;
	}
	
	public String editar() {
		return PAGINA_CADASTRO_TIME2;
	}
	
	public List<Time2> getLista() {
		List<Time2> listaRetorno = new ArrayList<>();
		try {
			listaRetorno = dao.listar();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesUtil.exibirMensagem("Erro ao realizar a operação. " + e.getMessage());
			
		}
		return listaRetorno;
		
	}
}
