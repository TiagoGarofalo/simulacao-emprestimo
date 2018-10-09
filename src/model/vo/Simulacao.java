package model.vo;

public class Simulacao {
	
	private int id; //auto-incremento
	private String nome;
	private String email;
	private String cpf;
	private double valorContrato;
	private int numParcela;
			
	public Simulacao(String nome, String email, String cpf, double valorContrato, int numParcela) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.valorContrato = valorContrato;
		this.numParcela = numParcela;
	}
		
	public Simulacao() {
		super();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getValorContrato() {
		return valorContrato;
	}
	public void setValorContrato(double valorContrato) {
		this.valorContrato = valorContrato;
	}
	public int getNumParcela() {
		return numParcela;
	}
	public void setNumParcela(int numParcela) {
		this.numParcela = numParcela;
	}
		
	
}
