package com.paulo.lab4;

import java.util.Scanner;

public class Main {
	
	private static final String CADASTRAR = "C";
	private static final String EXIBIR = "E";
	private static final String NOVOGRUPO = "N";
	private static final String ALOCARALUNO = "A";
	private static final String REGISTRARALUNO = "R";
	private static final String IMPRIMIRALUNOS = "I";
	private static final String SAIR = "O";
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean continua = true;
		
		while(continua) {
			String opcao = exibeMenu();
			
			switch(opcao) {
				case(SAIR):
					continua = false;
					break;
					
				default:
					System.out.println("OPÇÃO INVÁLIDA!\n");
					break;
			}
		}
		
	}
	
	public static String exibeMenu() {
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
		
		System.out.print("\nOpção> ");
		String op = scan.next();
		return op;
	}

}
