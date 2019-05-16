package br.edu.faculdadedelta.projetofutebol.converter;

import java.sql.SQLException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.faculdadedelta.projetofutebol.dao.Time2Dao;
import br.edu.faculdadedelta.projetofutebol.modelo.Time2;

@FacesConverter (value = "time2Converter")
public class Time2Converter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {
		
		if (valor != null) {
			Time2Dao dao = new Time2Dao();
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
			return String.valueOf(((Time2)valor).getIdTime2());
		}
		
		return null;
}
}
