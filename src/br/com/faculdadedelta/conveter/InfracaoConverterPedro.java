package br.com.faculdadedelta.conveter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.faculdadedelta.dao.InfracaoDaoPedro;
import br.com.faculdadedelta.modelo.InfracaoPedro;

@FacesConverter(value = "infracoesConverter")
public class InfracaoConverterPedro implements Converter {

	private InfracaoDaoPedro dao= new InfracaoDaoPedro();
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
			return String.valueOf(((InfracaoPedro)valos).getId());
		}
		return null;
	}

}
