package com.paulo.lab4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Representa um sistema de Controle de Alunos, contém alguns métodos auxiliares que realizam a leitura de
 * dados, tratamento de exceções, e assim os dados tratados são passados para os métodos das Classes 
 * auxiliares para concretizar a operação.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
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
		String op = scan.nextLine();
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
		
		Aluno aluno = new Aluno(matricula, nome, curso);
		if(alunos.contains(aluno))
			System.out.println("MATRÍCULA JÁ CADASTRADA!\n");
		else {
			alunos.add(aluno);
			System.out.println("CADASTRO REALIZADO!\n");
		}
	}
	
	/**
	 * Exibe um aluno que já foi cadastrado, tendo como entrada a sua matrícula.
	 * Caso uma matrícula não cadastrada seja inserida, uma mensagem de erro será exibida.
	 */
	public static void exibir() {
		System.out.print("Matrícula: ");
		String matricula = scan.nextLine();
		for(Aluno aluno : alunos) {
			if(aluno.getMatricula().equals(matricula)) {
				System.out.println("Aluno: " + aluno.toString());
				return;
			}
		}
		System.out.println("Aluno não cadastrado.\n");
	}
	
	/**
	 * Cria um novo Grupo a partir do seu tema(nome).
	 * Caso se tente cadastrar um novo grupo com o mesmo nome de um grupo já existente, uma mensagem de erro ocorrerá.
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
