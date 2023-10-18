package Classes;

import java.util.ArrayList;

public class Doenca {
	ArrayList<Medicamento> medicamentos = new ArrayList<>();
	private String nome;
	
	public Doenca(String nome, Medicamento medicamento) {
		this.nome = nome;
		this.medicamentos.add(medicamento);
	}
	
	public String getNome(){
		return nome;
	}
	
	public String listarMedicamento() {
		String lista = "";
		for(Medicamento medicamento : medicamentos) {
			lista += medicamento.toString();
			lista += "\n";
		}
		return lista;
	}

	public void novoMedicamento(Medicamento medicamento) {
		this.medicamentos.add(medicamento);
	}
}
