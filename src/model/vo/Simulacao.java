package model.vo;

public class Simulacao {
	
	private int ids_simulacao; //auto-incremento
	private String cpf;
	private String emprestimo;
	private double dataInicio;
	private int dataFinal;
	private int txjuros;
	private int qntParcelas;
	private int valorJuros;
	private int valorTotalEmprestimo;
	
	public Simulacao(int ids_simulacao, String cpf, String emprestimo, double dataInicio, int dataFinal, int txjuros,
			int qntParcelas, int valorJuros, int valorTotalEmprestimo) {
		super();
		this.ids_simulacao = ids_simulacao;
		this.cpf = cpf;
		this.emprestimo = emprestimo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.txjuros = txjuros;
		this.qntParcelas = qntParcelas;
		this.valorJuros = valorJuros;
		this.valorTotalEmprestimo = valorTotalEmprestimo;
	}

	

	public int getIds_simulacao() {
		return ids_simulacao;
	}



	public void setIds_simulacao(int ids_simulacao) {
		this.ids_simulacao = ids_simulacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(String emprestimo) {
		this.emprestimo = emprestimo;
	}

	public double getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(double dataInicio) {
		this.dataInicio = dataInicio;
	}

	public int getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(int dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getTxjuros() {
		return txjuros;
	}

	public void setTxjuros(int txjuros) {
		this.txjuros = txjuros;
	}

	public int getQntParcelas() {
		return qntParcelas;
	}

	public void setQntParcelas(int qntParcelas) {
		this.qntParcelas = qntParcelas;
	}

	public int getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(int valorJuros) {
		this.valorJuros = valorJuros;
	}

	public int getValorTotalEmprestimo() {
		return valorTotalEmprestimo;
	}

	public void setValorTotalEmprestimo(int valorTotalEmprestimo) {
		this.valorTotalEmprestimo = valorTotalEmprestimo;
	}


	
		
	
}
