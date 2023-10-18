package Classes;

import java.util.ArrayList;

public class Consulta {
	ArrayList<Doenca> diagnostico = new ArrayList<>();
	private String horario;
	private String data;
	private Medico medico;
	private Paciente paciente;
	private int batimentos;
	private int pressao;
	private float temperatura;
	private String observacoes;
	
	public Consulta(String horario, String data, Medico medico, Paciente paciente) {
		this.horario = horario;
		this.data = data;
		this.medico = medico;
		this.paciente = paciente;
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
	
}
