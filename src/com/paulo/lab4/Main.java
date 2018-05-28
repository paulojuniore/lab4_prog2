package com.paulo.lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Representa um sistema de Controle de Alunos, cont�m alguns m�todos auxiliares que realizam a leitura de dados, 
 * tratamento de exce��es, e assim os dados tratados s�o passados para os m�todos das Classes auxiliares para 
 * concretizar a/as opera��o/opera��es.
 * 
 * @author Paulo Mendes da Silva J�nior - 117210922
 * 
 */

public class Main {
	
	private static final String CADASTRAR = "C";
	private static final String EXIBIR = "E";
	private static final String NOVOGRUPO = "N";
	private static final String ALOCARALUNO = "A";
	private static final String REGISTRARALUNO = "R";
	private static final String IMPRIMIRALUNOS = "I";
	private static final String SAIR = "O";
	
	private static Scanner scan = new Scanner(System.in);
	
	private static HashMap<String, Aluno> alunos = new HashMap<>();
	private static HashMap<String, Grupo> grupos = new HashMap<>();
	private static ArrayList<Aluno> registro = new ArrayList<>();
	
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
					System.out.println("OP��O INV�LIDA!\n");
					break;
			}
		}	
	}
	
	/**
	 * Exibe o menu com as op��es do controle de Alunos.
	 * 
	 * @return : String que representa a op��o escolhida lida a partir do teclado.
	 */
	public static String exibeMenu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		
		System.out.print("\nOp��o> ");
		String op = scan.nextLine().toUpperCase();
		return op;
	}
	
	/**
	 * Exibe o menu com a requisi��o dos dados para cadastrar um novo aluno.
	 * Caso a mesma matr�cula seja inserida novamente uma mensagem de erro � exibida.
	 */
	public static void menuCadastrar() {
		System.out.print("Matr�cula: ");
		String matricula = scan.nextLine();
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("Curso: ");
		String curso = scan.nextLine();
		try {
			if(alunos.containsKey(matricula))
				System.out.println("MATR�CULA J� CADASTRADA!\n");
			else {
				Aluno aluno = new Aluno(matricula, nome, curso);
				alunos.put(matricula, aluno);
				System.out.println("CADASTRO REALIZADO!\n");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage() + System.lineSeparator());
		}	
	}
	
	/**
	 * Exibe um aluno que j� foi cadastrado, tendo como entrada a sua matr�cula.
	 * Caso uma matr�cula n�o cadastrada seja inserida, uma mensagem de erro ser� exibida.
	 */
	public static void exibir() {
		System.out.print("Matr�cula: ");
		String matricula = scan.nextLine();
		if(alunos.containsKey(matricula)) {
			System.out.println(alunos.get(matricula).toString());
		}
		else {
			System.out.println("Aluno n�o cadastrado.\n");
		}
	}
	
	/**
	 * Cria um novo Grupo a partir do seu tema(nome).
	 * Caso se tente cadastrar um novo grupo com o mesmo nome de um grupo j� existente, uma mensagem de erro ocorrer�.
	 */
	public static void cadastrarGrupo() {
		System.out.print("Grupo: ");
		String nomeGrupo = scan.nextLine();
		try {
			if(grupos.containsKey(nomeGrupo)) {
				System.out.println("GRUPO J� CADASTRADO!\n");
			}
			else {
				Grupo aux = new Grupo(nomeGrupo);
				grupos.put(nomeGrupo, aux);
				System.out.println("CADASTRO REALIZADO!\n");
			}		
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage() + System.lineSeparator());
		}	
	}
	
	/**
	 * Aloca um aluno j� existente em um grupo j� existente. Tamb�m pode imprimir os alunos que comp�em um grupo.
	 * Caso tente adicionar um aluno n�o cadastrado a um grupo, mensagens de erro s�o exibidas.
	 */
	public static void alocarAluno() {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		String op = scan.nextLine().toUpperCase();
		
		if(op.equals("A")) {
			System.out.print("Matricula: ");
			String matricula = scan.nextLine();
			System.out.print("Grupo: ");
			String grupo = scan.nextLine();
			
			if(!alunos.containsKey(matricula))
				System.out.println("Aluno n�o cadastrado!\n");
			else if(!grupos.containsKey(grupo))
				System.out.println("Grupo n�o cadastrado!\n");
			else {
				Grupo g = grupos.get(grupo);
				Aluno a = alunos.get(matricula);
				g.adicionaAluno(a);
				System.out.println("ALUNO ALOCADO!\n");
			}
		}
		
		else if(op.equals("I")) {
			System.out.print("Grupo: ");
			String grupo = scan.nextLine();
			
			if(grupos.containsKey(grupo)) {
				Grupo g = grupos.get(grupo);
				Iterator<Aluno> it = g.getAlunos().iterator();
				System.out.println("\nAlunos do grupo " + grupo + ":");
				while(it.hasNext()) {
					System.out.print("* " + it.next());
				}
				System.out.println();
			}
			else {
				System.out.println("Grupo n�o cadastrado.\n");
			}
		}	
		
		else {
			System.out.println("OP��O INV�LIDA!\n");
		}
	}
	
	/**
	 * M�todo respons�vel por registrar um aluno que j� respondeu quest�es no quadro.
	 * Caso o aluno j� tenha sido registrado ou o matr�cula passada n�o esteja cadastrada no sistema, o usu�rio � notificado.
	 */
	public static void registrarAlunoQueRespondeu() {
		System.out.print("Matr�cula: ");
		String matricula = scan.nextLine();
		if(alunos.containsKey(matricula)) {
			if(registro.contains(alunos.get(matricula))) {
				System.out.println("Aluno j� registrado.\n");
			}
			else {
				registro.add(alunos.get(matricula));
				System.out.println("ALUNO REGISTRADO!\n");
			}
		}
		else {
			System.out.println("Aluno n�o cadastrado.\n");
		}
	}
	
	/**
	 * Imprime o registro de alunos que j� responderam a quest�es no quadro.
	 */
	public static void imprimirAlunos() {
		System.out.println("Alunos:");
		for(int i = 0; i < registro.size(); i++) {
			System.out.print(i+1 + ". " + registro.get(i));
		}
		System.out.println();
	}
	
}
