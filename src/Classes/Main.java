package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Pessoa> pessoas = new ArrayList<>(); 
	static Scanner scanner = new Scanner(System.in);
	
	public static Consulta agendarConsulta(String tipoConsulta) {
		for(Pessoa pessoa : pessoas) {
			if(pessoa instanceof Medico) {
				
			}
		}
	}
	
	public static void menuPaciente() {
		System.out.println("========= MENU PACIENTE =========");
		System.out.println("1. Agendar consulta");
		System.out.println("2. Visualizar historico de consultas");
		System.out.println("3. Visualizar agendamentos");
		System.out.println("4. Alterar senha");
		System.out.println("5. Alterar convenio");
		System.out.println("6. Sair");
		System.out.println("========= MENU PACIENTE =========");
		int op = scanner.nextInt();
		scanner.nextLine();
		
		switch(op) {
			case 1:
				System.out.println("Particular ou Convenio: ");
				String tipoConsulta = scanner.next();
				agendarConsulta(tipoConsulta);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
			System.out.println("Opcao invalida!");
		}
	}
	
	public static Paciente criarContaPaciente() {
		System.out.println("Nome: ");
		String nome = scanner.next();
		
		System.out.println("Data de nascimento: ");
		String dataNascimento = scanner.next();
		
		System.out.println("Contato: ");
		String contato = scanner.next();
		
		System.out.println("Cpf: ");
		String cpfCadastro = scanner.next();
		
		System.out.println("Sexo: ");
		String sexo = scanner.next();
		
		System.out.println("Convenio: ");
		String convenio = scanner.next();
		
		System.out.println("Senha: ");
		String senhaCadastro = scanner.next();
		
		Paciente paciente = new Paciente(nome, dataNascimento, contato, cpfCadastro, sexo, convenio);
		
		while(true) {
			try {
				paciente.setSenha(senhaCadastro);
				break;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Digite novamente a senha: ");
				senhaCadastro = scanner.next();
			}
		}
		return paciente;
	}
	
	
	public static void main(String a[]) {
		int option1 = -1;
		int option2 = -1;
		
		do {
			System.out.println("======= MENU =======");
			System.out.println("1. Logar");
			System.out.println("2. Criar conta do paciente");
			System.out.println("3. Encerrar");
			System.out.println("======= MENU =======");
			option1 = scanner.nextInt();
			scanner.nextLine();
			
			switch(option1) {
			case 1:
				System.out.println("CPF: ");
				String cpf = scanner.next();
				
				System.out.println("Senha: ");
				String senha = scanner.next();
				
				for(Pessoa pessoa : pessoas) {
					if(pessoa.getCpf().equals(cpf) && pessoa.getSenha().equals(senha)) {
						if(pessoa instanceof Paciente) {
							menuPaciente();
						} else if(pessoa instanceof Secretaria){
							//
						} else if(pessoa instanceof Medico) {
							//
						}
						
					}
				}
				break;
			case 2:
				pessoas.add(criarContaPaciente());
				break;
			case 3:
				System.out.println("Encerrando...");
				break;
			default:
				System.out.println("Opcao invalida!");
			}
		}while(option1!=3);
	}
}
