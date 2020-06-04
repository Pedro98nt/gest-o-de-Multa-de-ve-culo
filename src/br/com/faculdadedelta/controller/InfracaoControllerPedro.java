package br.com.faculdadedelta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadedelta.dao.InfracaoDaoPedro;
import br.com.faculdadedelta.modelo.InfracaoPedro;

@ManagedBean
@SessionScoped
public class InfracaoControllerPedro {

	private InfracaoPedro infracao = new InfracaoPedro();
	private InfracaoDaoPedro dao = new InfracaoDaoPedro();

	public InfracaoPedro getInfracao() {
		return infracao;
	}

	public void setInfracao(InfracaoPedro infracao) {
		this.infracao = infracao;
	}

	public void limparCampos() {
		infracao = new InfracaoPedro();
	}

	public void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String salvar() {
		try {
			if (infracao.getId() == null) {
				dao.incluir(infracao);
				limparCampos();
				exibirMensagem("Inclusao realizada com sucesso.");
			} else {
				dao.alterar(infracao);
				limparCampos();
				exibirMensagem("Alteracao realizada com sucesso.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return "CadastroInfracao.xhtml";
	}

	public String editar() {
		return "CadastroIngracao.xhtml";
	}

	public String excluir() {
		try {
			dao.excluir(infracao);
			limparCampos();
			exibirMensagem("Exclusao realizada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return "ListaInfracao.xhtml";
	}

	public List<InfracaoPedro> getLista() {
		List<InfracaoPedro> listaRetorno = new ArrayList<InfracaoPedro>();
		try {
			listaRetorno = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return listaRetorno;
	}
}