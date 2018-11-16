package model.vo;

import java.util.List;

public class ClienteVO {

	private int id;
	private String nome;
	private String email;
	private String cpf;
	private ClienteVO cliente;
	
		public ClienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteVO(int id, String nome, String email, String cpf, ClienteVO cliente) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.cpf = cpf;
			this.cliente = cliente;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}


	
	
	
	
	
}
