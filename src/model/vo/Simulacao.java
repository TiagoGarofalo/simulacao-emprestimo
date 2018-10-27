package model.vo;

import java.util.Date;

public class Simulacao {

	private String nome;
	private String email;
	private String cpf;
	private double valorCont;
	private double numParcela;
	private Long numCont;
	private double valorParcela;
	private Date dtsimulacao;
	private Date dtValidade;

	public Simulacao(String nome, String email, String cpf, double valorCont, double numParcela, Long numCont,
			double valorParcela, Date dtsimulacao, Date dtValidade) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.valorCont = valorCont;
		this.numParcela = numParcela;
		this.numCont = numCont;
		this.valorParcela = valorParcela;
		this.dtsimulacao = dtsimulacao;
		this.dtValidade = dtValidade;
	}

	public Simulacao() {
		super();
		// TODO Auto-generated constructor stub
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

	public double getValorCont() {
		return valorCont;
	}

	public void setValorCont(double valorCont) {
		this.valorCont = valorCont;
	}

	public double getNumParcela() {
		return numParcela;
	}

	public void setNumParcela(double numParcela) {
		this.numParcela = numParcela;
	}

	public Long getNumCont() {
		return numCont;
	}

	public void setNumCont(Long numCont) {
		this.numCont = numCont;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Date getDtsimulacao() {
		return dtsimulacao;
	}

	public void setDtsimulacao(Date dtsimulacao) {
		this.dtsimulacao = dtsimulacao;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

}
