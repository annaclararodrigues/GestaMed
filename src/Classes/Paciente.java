package Classes;

import java.util.ArrayList;

public class Paciente extends Pessoa {
	private String convenio;
	
	public Paciente(String nome, String dataNascimento, String contato, String cpf, String sexo, String convenio) {
		super(nome, dataNascimento, contato, cpf, sexo);
		this.convenio = convenio;
	}
	
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	
	public String getConvenio() {
		return convenio;
	}
}
