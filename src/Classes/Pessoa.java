package Classes;

public abstract class Pessoa {
	private String nome;
	private String dataNascimento;
	private String contato;
	private String cpf;
	private String sexo;
	private String senha;
	
	public Pessoa(String nome, String dataNascimento, String contato, String cpf, String sexo) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.contato = contato;
		this.cpf = cpf;
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) throws Exception {
		if(senha.length() < 8) {
			throw new Exception("A senha deve ser maior ou igual a 8 digitos!");
		} else {
			this.senha = senha;
		}
	}
	
	public String toString() {
		return "Nome: " + nome + " - Data de Nascimento: " + dataNascimento + " - Contato: " + contato 
				+ " - CPF: " + cpf + " - Sexo: " + sexo;
	}
}
