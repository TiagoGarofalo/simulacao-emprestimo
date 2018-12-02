package model.vo;

import java.util.Date;

public class SimulacaoVO {

	private String nome_Cliente;
	private String cpf_cliente;
	//private String nome_Vendedor;
	private String numero_Contrato;
	private String dt_inicio;
	private String dt_final;
	private double valor_parcela;
	private double num_parcelas;
	private double valor_contrato;
	private double taxa_juros;
	private double valor_Total_Contrato;
	private String contratado;
	
	public SimulacaoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SimulacaoVO(String nome_Cliente, String cpf_cliente, String numero_Contrato, double valor_parcela,
			double num_parcelas, double valor_contrato, double taxa_juros, double valor_Total_Contrato,
			String contratado) {
		super();
		this.nome_Cliente = nome_Cliente;
		this.cpf_cliente = cpf_cliente;
		this.numero_Contrato = numero_Contrato;
		this.valor_parcela = valor_parcela;
		this.num_parcelas = num_parcelas;
		this.valor_contrato = valor_contrato;
		this.taxa_juros = taxa_juros;
		this.valor_Total_Contrato = valor_Total_Contrato;
		this.contratado = contratado;
	}

	public String getNome_Cliente() {
		return nome_Cliente;
	}

	public void setNome_Cliente(String nome_Cliente) {
		this.nome_Cliente = nome_Cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getNumero_Contrato() {
		return numero_Contrato;
	}

	public void setNumero_Contrato(String numero_Contrato) {
		this.numero_Contrato = numero_Contrato;
	}

	public double getValor_parcela() {
		return valor_parcela;
	}

	public void setValor_parcela(double valor_parcela) {
		this.valor_parcela = valor_parcela;
	}

	public double getNum_parcelas() {
		return num_parcelas;
	}

	public void setNum_parcelas(double num_parcelas) {
		this.num_parcelas = num_parcelas;
	}

	public double getValor_contrato() {
		return valor_contrato;
	}

	public void setValor_contrato(double valor_contrato) {
		this.valor_contrato = valor_contrato;
	}

	public double getTaxa_juros() {
		return taxa_juros;
	}

	public void setTaxa_juros(double taxa_juros) {
		this.taxa_juros = taxa_juros;
	}

	public double getValor_Total_Contrato() {
		return valor_Total_Contrato;
	}

	public void setValor_Total_Contrato(double valor_Total_Contrato) {
		this.valor_Total_Contrato = valor_Total_Contrato;
	}

	public String getContratado() {
		return contratado;
	}

	public void setContratado(String contratado) {
		this.contratado = contratado;
	}

	public String getDt_final() {
		return dt_final;
	}

	public void setDt_final(String dt_final) {
		this.dt_final = dt_final;
	}

	public String getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(String dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	
}
