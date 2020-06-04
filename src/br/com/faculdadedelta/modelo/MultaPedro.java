package br.com.faculdadedelta.modelo;

import java.util.Date;

public class MultaPedro {

	private Long id;
	private InfracaoPedro infracao;
	private VeiculoPedro veiculo;
	private MotoristaPedro motorista;
	private Date data;
	
	public MultaPedro() {
		super();
	}

	public MultaPedro(Long id, InfracaoPedro infracao, VeiculoPedro veiculo, MotoristaPedro motorista,
			Date data) {
		super();
		this.id = id;
		this.infracao = infracao;
		this.veiculo = veiculo;
		this.motorista = motorista;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public InfracaoPedro getInfracao() {
		return infracao;
	}

	public void setInfracao(InfracaoPedro infracao) {
		this.infracao = infracao;
	}

	public VeiculoPedro getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoPedro veiculo) {
		this.veiculo = veiculo;
	}

	public MotoristaPedro getMotorista() {
		return motorista;
	}

	public void setMotorista(MotoristaPedro motorista) {
		this.motorista = motorista;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultaPedro other = (MultaPedro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	


}