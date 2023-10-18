package Classes;

import java.util.ArrayList;

public class Medico extends Pessoa {
	ArrayList<String> convenio = new ArrayList<>();
	private String especialidade; 
	private String horarioDisponivel;
	private String dataDisponivel;
	
	public Medico(String nome, String dataNascimento, String contato, String cpf, String sexo, String convenio, String especialidade, String horarioDisponivel, String dataDisponivel) {
		
		super(nome, dataNascimento, contato, cpf, sexo);
		this.especialidade = especialidade;
		this.horarioDisponivel = horarioDisponivel;
		this.dataDisponivel = dataDisponivel;
		this.convenio.add("Particular");
	}
	
	public void addConvenio(String convenio) {
		this.convenio.add(convenio);
	}
	
	public String mostra() {
		return "Nome: " + super.getNome() +
			   "\nEspecialidade: " + especialidade;
	}
}
