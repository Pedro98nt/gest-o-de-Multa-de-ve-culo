package br.com.faculdadedelta.conveter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.faculdadedelta.dao.MotoristaDaoPedro;
import br.com.faculdadedelta.modelo.MotoristaPedro;

@FacesConverter(value = "motoristaConverter")
public class motoristaConverterPedro implements Converter {

	private MotoristaDaoPedro dao= new MotoristaDaoPedro();
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valos) {
		if(valos!=null) {
			try {
				return dao.pesquisarPorId(Long.valueOf(valos));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valos) {
		if(valos!=null) {
			return String.valueOf(((MotoristaPedro)valos).getId());
		}
		return null;
	}

}
