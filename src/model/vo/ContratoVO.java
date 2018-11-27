package model.vo;

public class ContratoVO {
	private int id;
	private String numContrato;
	private Double valorContrato;
	private double valotTotalContrato;
	private int numParcela;



	public double getValotTotalContrato() {
		return valotTotalContrato;
	}



	public void setValotTotalContrato(double valotTotalContrato) {
		this.valotTotalContrato = valotTotalContrato;
	}



	public ContratoVO(int id, String numContrato, Double valorContrato, double valotTotalContrato, int numParcela) {
		super();
		this.id = id;
		this.numContrato = numContrato;
		this.valorContrato = valorContrato;
		this.valotTotalContrato = valotTotalContrato;
		this.numParcela = numParcela;
	}



	public ContratoVO() {
		super();
		// TODO Auto-generated constructor stub
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
