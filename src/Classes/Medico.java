package Classes;

import java.util.ArrayList;
import java.util.Random;

public class Medico extends Pessoa {
	private static int contador = 1000;
	
	ArrayList<String> convenio = new ArrayList<>();
	ArrayList<HorarioDisponivel> horariosDisponiveis = new ArrayList<>();
	private String especialidade; 
	private int id;
	
	public Medico(String nome, String dataNascimento, String contato, String cpf, String sexo, String convenio, String especialidade) {
		
		super(nome, dataNascimento, contato, cpf, sexo);
		this.especialidade = especialidade;
		this.convenio.add("Particular");
		this.id = contador;
		contador++;
	}
	
	public int getId() {
		return id;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void addConvenio(String convenio) {
		this.convenio.add(convenio);
	}
	
	public boolean atendeConvenio(String c) {
		for(String conv : convenio) {
			if(conv == c) {
				return true;
			}
		}
		return false;
	}
	
	public void adicionarHorarioDisponivel(String data, String horario) {
		HorarioDisponivel horarioDisponivel = new HorarioDisponivel(data, horario);
		horariosDisponiveis.add(horarioDisponivel);
	}
	
	public boolean removerHorarioDisponivel(String data, String horario) {
		for(HorarioDisponivel h : horariosDisponiveis) {
			if(h.getData().equals(data) && h.getHorario().equals(horario)) {
				horariosDisponiveis.remove(h);
				return true;
			}
		}
		return false;
	}
	
	public String mostraHorariosDisponiveis() {
		String horarios = "";
		for(HorarioDisponivel h : horariosDisponiveis) {
			horarios += h.getData() + " " + h.getHorario() + "\n";
		}
		return horarios;
	}
	
	public String mostra() {
		return "Id: " + getId() +  "\nNome: " + super.getNome() +
			   "\nEspecialidade: " + getEspecialidade(); // COMO VERIFICAR DATAS E HORARIOS DISPONÍVEIS
	}
}
