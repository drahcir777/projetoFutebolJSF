package br.edu.faculdadedelta.projetofutebol.converter;

import java.sql.SQLException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.faculdadedelta.projetofutebol.dao.TimeDao;
import br.edu.faculdadedelta.projetofutebol.modelo.Time;

@FacesConverter (value = "timeConverter")
public class TimeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		
		if (valor != null) {
			TimeDao dao = new TimeDao();
			try {
				return dao.pesquisarPorId(Long.valueOf(valor));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {
		
		if (valor != null) {
			return String.valueOf(((Time)valor).getIdTime());
		}
		
		return null;
}
}

