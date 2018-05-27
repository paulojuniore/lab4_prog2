package com.paulo.lab4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Representa um sistema de Controle de Alunos, cont�m alguns m�todos auxiliares que realizam a leitura de
 * dados, tratamento de exce��es, e assim os dados tratados s�o passados para os m�todos das Classes 
 * auxiliares para concretizar a opera��o.
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
	
	private static HashSet<Aluno> alunos = new HashSet<Aluno>();
	private static HashSet<Grupo> grupos = new HashSet<Grupo>();
	
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
		String op = scan.nextLine();
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
		
		Aluno aluno = new Aluno(matricula, nome, curso);
		if(alunos.contains(aluno))
			System.out.println("MATR�CULA J� CADASTRADA!\n");
		else {
			alunos.add(aluno);
			System.out.println("CADASTRO REALIZADO!\n");
		}
	}
	
	/**
	 * Exibe um aluno que j� foi cadastrado, tendo como entrada a sua matr�cula.
	 * Caso uma matr�cula n�o cadastrada seja inserida, uma mensagem de erro ser� exibida.
	 */
	public static void exibir() {
		System.out.print("Matr�cula: ");
		String matricula = scan.nextLine();
		for(Aluno aluno : alunos) {
			if(aluno.getMatricula().equals(matricula)) {
				System.out.println("Aluno: " + aluno.toString());
				return;
			}
		}
		System.out.println("Aluno n�o cadastrado.\n");
	}
	
	/**
	 * Cria um novo Grupo a partir do seu tema(nome).
	 * Caso se tente cadastrar um novo grupo com o mesmo nome de um grupo j� existente, uma mensagem de erro ocorrer�.
	 */
	public static void cadastrarGrupo() {
		System.out.println("Grupo: ");
		String nomeGrupo = scan.nextLine();
	}
	
//	public static void exibir() {
//		Iterator it = alunos.iterator();
//		while(it.hasNext()) {
//			System.out.print(it.next());
//		}
//	}

}
