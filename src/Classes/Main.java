package Classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
	static ArrayList<Pessoa> pessoas = new ArrayList<>(); 
	static ArrayList<Consulta> consultas = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	static Date data = new Date();

	public static String retornaDataAtual() {
		Date dataAtual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formato.format(dataAtual);
		return dataFormatada;
	}

	public static Consulta agendarConsulta(String tipoConsulta, Paciente paciente) {
		for(Pessoa pessoa : pessoas) {
			if(pessoa instanceof Medico) {
				if(((Medico) pessoa).atendeConvenio(tipoConsulta)) {
					System.out.println(((Medico)pessoa).toString());
				}
			}
		}
		System.out.println("Digite o id do medico: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Medico medico = null;
		for(Pessoa pessoa : pessoas) {
			if(pessoa instanceof Medico) {
				if(((Medico) pessoa).getId() == id) {
					medico = ((Medico)pessoa);
					System.out.println(((Medico) pessoa).mostraHorariosDisponiveis());
				}
			}
		}

		String dataEscolhida;
		String horarioEscolhido;
		do {
			System.out.println("Escolha uma data: (DD/MM/AAAA): ");
			dataEscolhida = scanner.nextLine();

			System.out.println("Escolha um horario: (HH:MM): ");
			horarioEscolhido = scanner.nextLine();

		}while(!medico.removerHorarioDisponivel(dataEscolhida, horarioEscolhido));

		Consulta consulta = new Consulta(dataEscolhida, horarioEscolhido, medico, paciente);
		return consulta;
	}

	public static boolean removerConsulta(Paciente paciente) {
		visualizarAgendamento(paciente);

		System.out.println("Id da consulta a ser removida: ");
		int removerId = scanner.nextInt();

		for(Consulta c : consultas) {
			if(c.getId() == removerId) {
				c.getMedico().adicionarHorarioDisponivel(c.getData(), c.getHorario());
				consultas.remove(c);
				return true;
			}
		}
		return false;
	}

	public static void visualizarHistorico(Paciente paciente) {
		for(Consulta c : consultas) {
			if(c.getData().compareTo(retornaDataAtual()) < 0 && c.getPaciente() == paciente) {
				System.out.println(c.toString());
			}
		}
	}

	public static void visualizarAgendamento(Paciente paciente) {
		for(Consulta c : consultas) {
			if(c.getData().compareTo(retornaDataAtual()) >= 0 && c.getPaciente() == paciente) {
				System.out.println(c.consultasAgendadas());
			}
		}
	}
	
	public static void alterarSenha(Paciente paciente) {
		  System.out.println("Informe a senha: ");
		  scanner.nextLine();
		  String senhaNova = scanner.nextLine();
		while(true) {
			try {
				paciente.setSenha(senhaNova);
				break;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Digite novamente a senha: ");
				 senhaNova = scanner.nextLine();
			}
		}
	}

	public static void menuPaciente(Paciente paciente) {
		System.out.println("========= MENU PACIENTE =========");
		System.out.println("1. Agendar consulta");
		System.out.println("2. Remover consulta");
		System.out.println("3. Visualizar historico de consultas");
		System.out.println("4. Visualizar agendamentos");
		System.out.println("5. Alterar senha");
		System.out.println("6. Alterar convenio");
		System.out.println("7. Sair");
		System.out.println("========= MENU PACIENTE =========");
		int op = scanner.nextInt();
		scanner.nextLine();

		do {
			switch(op) {
			case 1:
				System.out.println("Particular ou Convenio: ");
				String tipoConsulta = scanner.next();
				if(tipoConsulta == "Convenio") {
					System.out.println("Numero do convenio: ");
					tipoConsulta = scanner.nextLine();
				}
				consultas.add(agendarConsulta(tipoConsulta, paciente));
				break;
			case 2:
				if(removerConsulta(paciente)) {
					System.out.println("Consulta removida com sucesso!");
				}
				break;
			case 3:
				visualizarHistorico(paciente);
				break;
			case 4:
				visualizarAgendamento(paciente);
				break;
			case 5:
				alterarSenha(paciente);
				break;
			case 6:
				break;
			case 7:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opcao invalida!");
			}
		}while(op!=7);
	}

	public static Paciente criarContaPaciente() {
		System.out.println("Nome: ");
		String nome = scanner.next();

		System.out.println("Data de nascimento: ");
		String dataNascimento = scanner.next();

		System.out.println("Contato: ");
		String contato = scanner.next();

		scanner.nextLine();
		System.out.println("Cpf: ");
		String cpfCadastro = scanner.next();

		System.out.println("Sexo: ");
		String sexo = scanner.next();

		System.out.println("Nome do convenio ou Particular: ");
		String convenio = scanner.next();

		Paciente paciente = new Paciente(nome, dataNascimento, contato, cpfCadastro, sexo, convenio);

		alterarSenha(paciente);
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
							menuPaciente(((Paciente) pessoa));
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
