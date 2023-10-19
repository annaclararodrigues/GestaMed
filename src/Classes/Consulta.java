package Classes;

import java.util.ArrayList;
import java.util.Random;

public class Consulta {
	private static int contador = 100000;
	
	ArrayList<Doenca> diagnostico = new ArrayList<>();
	private String horario;
	private String data;
	private Medico medico;
	private Paciente paciente;
	private int batimentos;
	private int pressao;
	private float temperatura;
	private String observacoes;
	private int id;
	
	public Consulta(String data, String horario, Medico medico, Paciente paciente) {
		this.horario = horario;
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
		this.id = contador;
		contador++;
	}
	
	public String getData() {
		return data;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public Medico getMedico() {
		return medico;
	}
	
	public int getId() {
		return id;
	}
	
	public void setMedidas(int batimentos, int pressao, float temperatura) {
		this.batimentos = batimentos;
		this.pressao = pressao;
		this.temperatura = temperatura;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public void addDiagnostico(Doenca doenca) {
		this.diagnostico.add(doenca);
	}
	
	public String toString() {
		return "Nome: " + paciente.getNome() + consultasAgendadas() + "\nBatimento: " + batimentos + "\nPressao: " + pressao + "\nTemperatura: " + temperatura + "\nObservacoes: " + observacoes;
	}
	
	public String consultasAgendadas() {
		return "Id: " + id + "\nData: " + data + "\nHorario: " + horario + "\nMedico: " + medico.getNome() + "\nEspecialidade: " + medico.getEspecialidade();
	}
}
