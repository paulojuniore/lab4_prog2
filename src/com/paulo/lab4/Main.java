package com.paulo.lab4;

import java.util.Scanner;

/**
 * Representa um sistema de Controle de Alunos, contém alguns métodos auxiliares que realizam a leitura de dados, 
 * tratamento de exceções, e assim os dados tratados são passados para os métodos das Classes auxiliares para 
 * concretizar a/as operação/operações.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 * 
 */

public class Main {
	
	/**
	 * Constantes que são responsáveis pela singularidade do método main e funcionam como chaves de seleção 
	 * para as operações do sistema.
	 */
	private static final String CADASTRAR = "C";
	private static final String EXIBIR = "E";
	private static final String NOVOGRUPO = "N";
	private static final String ALOCARALUNO = "A";
	private static final String REGISTRARALUNO = "R";
	private static final String IMPRIMIRALUNOS = "I";
	private static final String SAIR = "O";
	
	/**
	 * Objeto Scanner que realiza as operações de leitura de dados do teclado.
	 */
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Sistema de controle que é responsável por armazenar todos os alunos, grupos e registro do sistema.
	 */
	private static Controle sistema = new Controle();
	
	public static void main(String[] args) {	
		boolean continua = true;
		
		while(continua) {
			String opcao = exibeMenu();
			
			switch(opcao) {
			
				case(CADASTRAR):
					menuCadastrar();
					break;
					
				case(EXIBIR):
					exibir();
					break;
					
				case(NOVOGRUPO):
					cadastrarGrupo();
					break;
					
				case(ALOCARALUNO):
					alocarAluno();
					break;
					
				case(REGISTRARALUNO):
					registrarAlunoQueRespondeu();
					break;
					
				case(IMPRIMIRALUNOS):
					imprimirAlunos();
					break;
			
				case(SAIR):
					continua = false;
					break;
					
				default:
					System.out.println("OPÇÃO INVÁLIDA!\n");
					break;
					
			}
		}	
	}
	
	
	/**
	 * Exibe o menu com as opções do controle de Alunos.
	 * 
	 * @return : String que representa a opção escolhida lida a partir do teclado.
	 */
	public static String exibeMenu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		
		System.out.print("\nOpção> ");
		String op = scan.nextLine().toUpperCase();
		return op;
	}
	
	/**
	 * Exibe o menu com a requisição dos dados para cadastrar um novo aluno.
	 * Caso a mesma matrícula seja inserida novamente uma mensagem de erro é exibida.
	 */
	public static void menuCadastrar() {
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("Curso: ");
		String curso = scan.nextLine();
		try {
			System.out.println(sistema.cadastraAluno(matricula, nome, curso));
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage() + System.lineSeparator());
		}	
	}
	
	/**
	 * Exibe um aluno que já foi cadastrado, tendo como entrada a sua matrícula.
	 * Caso uma matrícula não cadastrada seja inserida, uma mensagem de erro será exibida.
	 */
	public static void exibir() {
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();
		System.out.println(sistema.exibirAluno(matricula));
	}
	
	/**
	 * Cria um novo Grupo a partir do seu tema(nome).
	 * Caso se tente cadastrar um novo grupo com o mesmo nome de um grupo já existente, uma mensagem de erro 
	 * ocorrerá.
	 */
	public static void cadastrarGrupo() {
		System.out.print("Grupo: ");
		String nomeGrupo = scan.nextLine().toLowerCase();
		try {
			System.out.println(sistema.cadastrarGrupo(nomeGrupo));
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage() + System.lineSeparator());
		}	
	}
	
	/**
	 * Aloca um aluno já existente em um grupo já existente. Também pode imprimir os alunos que compõem um grupo.
	 * Caso tente adicionar um aluno não cadastrado a um grupo, mensagens de erro são exibidas.
	 */
	public static void alocarAluno() {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		String op = scan.nextLine().toUpperCase();	
		if(op.equals("A")) {
			System.out.print("Matricula: ");
			String matricula = scan.nextLine();
			System.out.print("Grupo: ");
			String grupo = scan.nextLine().toLowerCase();
			System.out.println(sistema.alocarAlunoEmGrupo(matricula, grupo));
		}
		else if(op.equals("I")) {
			System.out.print("Grupo: ");
			String grupo = scan.nextLine().toLowerCase();
			System.out.println(sistema.imprimirAlunosDeGrupo(grupo));
		}	
		else {
			System.out.println("OPÇÃO INVÁLIDA!\n");
		}
	}
	
	/**
	 * Método responsável por registrar um aluno que já respondeu questões no quadro.
	 * Caso o aluno já tenha sido registrado ou o matrícula passada não esteja cadastrada no sistema, o 
	 * usuário é notificado.
	 */
	public static void registrarAlunoQueRespondeu() {
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();
		System.out.println(sistema.registrarAlunoQueRespondeu(matricula));
	}
	
	/**
	 * Imprime o registro de alunos que já responderam a questões no quadro.
	 */
	public static void imprimirAlunos() {
		System.out.println(sistema.imprimirRegistroDeAlunos());
	}
	
}
