package Classes;

public class Secretaria extends Pessoa {
	private Medico medico;
	
	public Secretaria(String nome, String dataNascimento, String contato, String cpf, String sexo, Medico medico) {
		super(nome, dataNascimento, contato, cpf, sexo);
		this.medico = medico;
	}
}
