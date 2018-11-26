package model.vo;

public class VendedorVO {

	private int id; //mudar nome para idvendedor
	private String nome;
	private String Email;
	private String cpf;
	private String senha;
	

	public VendedorVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendedorVO(int id, String nome, String email, String cpf, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		Email = email;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
