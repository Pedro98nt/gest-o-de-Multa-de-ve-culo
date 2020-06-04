package br.com.faculdadedelta.modelo;

public class InfracaoPedro {

	private Long id;
	private String gravidade;
	private String desc;
	private double valorI;

	public InfracaoPedro() {
		super();
	}

	public InfracaoPedro(Long id, String gravidade, String desc, Double valorI) {
		super();
		this.id = id;
		this.gravidade = gravidade;
		this.desc = desc;
		this.valorI = valorI;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGravidade() {
		return gravidade;
	}

	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getValorI() {
		return valorI;
	}

	public void setValorI(Double valorI) {
		this.valorI = valorI;
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
		InfracaoPedro other = (InfracaoPedro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	

}