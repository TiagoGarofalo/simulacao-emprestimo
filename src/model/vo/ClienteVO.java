package model.vo;

public class ClienteVO {

	private String nome;
	private int CPf;
	private String email;
	
	public ClienteVO(String nome, int cPf, String email) {
		super();
		this.nome = nome;
		CPf = cPf;
		this.email = email;
	}
	public ClienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCPf() {
		return CPf;
	}
	public void setCPf(int cPf) {
		CPf = cPf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
