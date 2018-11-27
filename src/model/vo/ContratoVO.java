package model.vo;

public class ContratoVO {
	private int id;
	private String numContrato;
	private Double valorContrato;
	private int numParcela;


	public ContratoVO() {
		super();

	}
	
	
	
	public ContratoVO(int id, String numContrato, Double valorContrato, int numParcela) {
		super();
		this.id = id;
		this.numContrato = numContrato;
		this.valorContrato = valorContrato;
		this.numParcela = numParcela;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	public String getNumContrato() {
		return numContrato;
	}



	public Double getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(Double valorContrato) {
		this.valorContrato = valorContrato;
	}

	public int getNumParcela() {
		return numParcela;
	}

	public void setNumParcela(int numParcela) {
		this.numParcela = numParcela;
	}

}
