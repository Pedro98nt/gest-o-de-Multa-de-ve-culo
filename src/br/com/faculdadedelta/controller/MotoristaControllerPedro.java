package br.com.faculdadedelta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadedelta.dao.MotoristaDaoPedro;
import br.com.faculdadedelta.modelo.MotoristaPedro;

@ManagedBean
@SessionScoped
public class MotoristaControllerPedro {

	private MotoristaPedro motorista = new MotoristaPedro();
	private MotoristaDaoPedro dao = new MotoristaDaoPedro();

	public MotoristaPedro getMotorista() {
		return motorista;
	}

	public void setMotorista(MotoristaPedro motorista) {
		this.motorista = motorista;
	}

	public void limparCampos() {
		motorista = new MotoristaPedro();
	}

	public void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String salvar() {
		try {
			if (motorista.getId() == null) {
				dao.incluir(motorista);
				limparCampos();
				exibirMensagem("Inclusao realizada com sucesso.");
			} else {
				dao.alterar(motorista);
				limparCampos();
				exibirMensagem("Alteracao realizada com sucesso.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return "CadastroMotorista.xhtml";
	}

	public String editar() {
		return "CadastroMotorista.xhtml";
	}

	public String excluir() {
		try {
			dao.excluir(motorista);
			limparCampos();
			exibirMensagem("Exclusao realizada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return "ListaMotorista.xhtml";
	}

	public List<MotoristaPedro> getLista() {
		List<MotoristaPedro> listaRetorno = new ArrayList<MotoristaPedro>();
		try {
			listaRetorno = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}

		return listaRetorno;
	}
}