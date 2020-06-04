package br.com.faculdadedelta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadedelta.dao.VeiculoDaoPedro;
import br.com.faculdadedelta.modelo.VeiculoPedro;

@ManagedBean
@SessionScoped
public class VeiculoControllerPedro {

	private VeiculoPedro veiculo = new VeiculoPedro();
	private VeiculoDaoPedro dao = new VeiculoDaoPedro();

	public VeiculoPedro getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoPedro veiculo) {
		this.veiculo = veiculo;
	}

	public void limparCampos() {
		veiculo = new VeiculoPedro();
	}

	private void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String salvar() {
		try {
			if (veiculo.getId() == null) {
				dao.incluir(veiculo);
				limparCampos();
				exibirMensagem("Inclusao realizada com sucesso.");
			} else {
				dao.alterar(veiculo);
				limparCampos();
				exibirMensagem("Alteracao realizada com sucesso.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return "CadastroVeiculo.xhtml";
	}

	public String editar() {
		return "CadastroVeiculo.xhtml";
	}

	public String excluir() {
		try {
			dao.excluir(veiculo);
			limparCampos();
			exibirMensagem("Exclusao realizada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return "ListaVeiculo.xhtml";
	}

	public List<VeiculoPedro> getLista() {
		List<VeiculoPedro> listaRetorno = new ArrayList<VeiculoPedro>();
		try {
			listaRetorno = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return listaRetorno;
	}
}