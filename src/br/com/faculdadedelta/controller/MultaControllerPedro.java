package br.com.faculdadedelta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.faculdadedelta.dao.MultaDaoPedro;
import br.com.faculdadedelta.modelo.InfracaoPedro;
import br.com.faculdadedelta.modelo.MotoristaPedro;
import br.com.faculdadedelta.modelo.MultaPedro;
import br.com.faculdadedelta.modelo.VeiculoPedro;

@ManagedBean
@SessionScoped
public class MultaControllerPedro {

	private MultaPedro multa = new MultaPedro();
	private MultaDaoPedro dao = new MultaDaoPedro();
	private InfracaoPedro infracaoSelecionada = new InfracaoPedro();
	private VeiculoPedro veiculoSelecionado = new VeiculoPedro();
	private MotoristaPedro motoristaSelecionado = new MotoristaPedro();

	public MultaPedro getMulta() {
		return multa;
	}

	public void setMulta(MultaPedro multa) {
		this.multa = multa;
	}

	public InfracaoPedro getInfracaoSelecionada() {
		return infracaoSelecionada;
	}

	public void setInfracaoSelecionada(InfracaoPedro infracaoSelecionada) {
		this.infracaoSelecionada = infracaoSelecionada;
	}

	public VeiculoPedro getVeiculoSelecionado() {
		return veiculoSelecionado;
	}

	public void setVeiculoSelecionado(VeiculoPedro veiculoSelecionado) {
		this.veiculoSelecionado = veiculoSelecionado;
	}

	public MotoristaPedro getMotoristaSelecionado() {
		return motoristaSelecionado;
	}

	public void setMotoristaSelecionado(MotoristaPedro motoristaSelecionado) {
		this.motoristaSelecionado = motoristaSelecionado;
	}

	public void limparCampos() {
		multa = new MultaPedro();
	}

	public void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String salvar() {
		try {
			if (multa.getId() == null) {
				multa.setInfracao(infracaoSelecionada);
				multa.setMotorista(motoristaSelecionado);
				multa.setVeiculo(veiculoSelecionado);
				dao.incluir(multa);
				limparCampos();
				exibirMensagem("Inclusao realizada com sucesso.");
			} else {
				multa.setInfracao(infracaoSelecionada);
				multa.setMotorista(motoristaSelecionado);
				multa.setVeiculo(veiculoSelecionado);
				dao.alterar(multa);
				limparCampos();
				exibirMensagem("Alteracao realizada com sucesso.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return "CadastroMulta.xhmtl";
	}

	public String editar() {
		multa.setInfracao(infracaoSelecionada);
		multa.setMotorista(motoristaSelecionado);
		multa.setVeiculo(veiculoSelecionado);
		return "CadastroMulta.xhtml";
	}

	public String excluir() {
		try {
			multa.setInfracao(infracaoSelecionada);
			multa.setMotorista(motoristaSelecionado);
			multa.setVeiculo(veiculoSelecionado);
			dao.excluir(multa);
			limparCampos();
			exibirMensagem("Exclusao realizada com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return "ListaMulta.xhtml";
	}

	public List<MultaPedro> getLista() {
		List<MultaPedro> listaRetorno = new ArrayList<>();
		try {
			listaRetorno = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return listaRetorno;
	}
}