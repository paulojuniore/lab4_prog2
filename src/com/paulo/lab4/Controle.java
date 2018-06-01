package com.paulo.lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Representa um sistema de Controle de Alunos, todo controle de alunos possui um conjuntos de alunos, outro conjunto
 * de grupos e uma lista de registros.
 * 
 * @author Paulo Mendes da Silva J�nior - 117210922
 *
 */

public class Controle {
	
	/**
	 * Mapa que armazena todos os alunos cadastrados no sistema.
	 */
	private HashMap<String, Aluno> alunos = new HashMap<>();
	
	/**
	 * Mapa que armazena todos os grupos cadastrados no sistema.
	 */
	private HashMap<String, Grupo> grupos = new HashMap<>();
	
	/**
	 * Lista sequencial que armazena todos os registros de alunos que responderam quest�es.
	 */
	private ArrayList<Aluno> registro = new ArrayList<>();
	
	
	/**
	 * Cadastra um aluno no Mapa de alunos caso todos seus dados sejam v�lidos, caso contr�rio, exce��es s�o
	 * lan�adas e tratadas.
	 * 
	 * @param matricula : matr�cula do aluno.
	 * @param nome : nome do aluno.
	 * @param curso : curso ao qual pertence o aluno.
	 * 
	 * @return : indica��o de sucesso/fracasso na opera��o.
	 * 
	 * @throws NullPointerException : Ocorre caso valores (null) sejam passados como argumentos do construtor de um Aluno.
	 * @throws IllegalArgumentException : Ocorre caso valores inv�lidos sejam passados como argumentos. ex: String com espa�os vazios representando a matr�cula.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) throws NullPointerException, IllegalArgumentException  {
		if(alunos.containsKey(matricula))
			return "MATR�CULA J� CADASTRADA!" + System.lineSeparator();
		else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			alunos.put(matricula, aluno);
			return "CADASTRO REALIZADO!" + System.lineSeparator();
		}
	}
	
	/**
	 * Retorna um aluno contido no Mapa de alunos a partir de sua matr�cula.
	 * Caso n�o exista um aluno de tal matr�cula, uma mensagem de erro � exibida. 
	 * 
	 * @param matricula : matr�cula do aluno.
	 * 
	 * @return : uma representa��o String do aluno, contendo matr�cula, nome e curso.
	 */
	public String exibirAluno(String matricula) {
		if(alunos.containsKey(matricula)) {
			return alunos.get(matricula).toString();
		}
		else {
			return "Aluno n�o cadastrado." + System.lineSeparator();
		}
	}
	
	/**
	 * Cadastra um novo grupo. Caso um nome de grupo ja esteja cadastrado, � exibida uma notifica��o.
	 * 
	 * @param nomeDoGrupo : tema do grupo.
	 * 
	 * @return : uma String que representa se a opera��o foi bem/mal sucedida.
	 * 
	 * @throws NullPointerException : Ocorre caso valores (null) sejam passados como argumentos ao construtor de um Grupo.
	 * @throws IllegalArgumentException : Ocorre caso um valor inv�lido seja passado como argumento. ex: String com espa�os vazios representando o tema do grupo.  
	 */
	public String cadastrarGrupo(String nomeDoGrupo) throws NullPointerException, IllegalArgumentException{
		if(grupos.containsKey(nomeDoGrupo)) {
			return "GRUPO J� CADASTRADO!" + System.lineSeparator();
		}
		else {
			Grupo grupo = new Grupo(nomeDoGrupo);
			grupos.put(nomeDoGrupo, grupo);
			return "CADASTRO REALIZADO!" + System.lineSeparator();
		}		
	}
	
	/**
	 * Aloca um aluno j� existente em um grupo j� existente. Caso sejam passados matr�culas e/ou nomes de grupos
	 * que n�o existem, uma mensagem informando o erro � exibida.
	 * 
	 * @param matricula : matr�cula do aluno a ser alocado.
	 * @param grupo : nome do grupo em que o aluno de matr�cula passada ser� inserido.
	 * 
	 * @return : retorna uma mensagem indicando o sucesso/fracasso na opera��o.
	 */
	public String alocarAlunoEmGrupo(String matricula, String grupo) {
		if(!alunos.containsKey(matricula))
			return "Aluno n�o cadastrado!" + System.lineSeparator();
		else if(!grupos.containsKey(grupo))
			return "Grupo n�o cadastrado!" + System.lineSeparator();
		else {
			Grupo g = grupos.get(grupo);
			Aluno a = alunos.get(matricula);
			g.adicionaAluno(a);
			return "ALUNO ALOCADO!" + System.lineSeparator();
		}
	}
	
	/**
	 * Imprime uma lista de alunos cadastrados em um determinado grupo a partir do nome do grupo. 
	 * Caso o grupo n�o tenha sido cadastrado, uma mensagem de erro � exibida. 
	 * 
	 * @param nomeDoGrupo : nome do grupo.
	 * 
	 * @return : retorna a lista de alunos que est�o cadastrados em um grupo caso o nome do grupo j� esteja cadastrado.
	 */
	public String imprimirAlunosDeGrupo(String nomeDoGrupo) {
		if(grupos.containsKey(nomeDoGrupo)) {
			Grupo g = grupos.get(nomeDoGrupo);
			if(g.getAlunos().isEmpty()) {
				return "O grupo est� vazio!" + System.lineSeparator();
			}
			else {
				Iterator<Aluno> it = g.getAlunos().iterator();
				String saida = "";
				saida += "\nAlunos do grupo " + nomeDoGrupo + ":\n";
				while(it.hasNext()) {
					saida += "* " + it.next();
				}
				return saida;
			}	
		}
		else {
			return "Grupo n�o cadastrado." + System.lineSeparator();
		}
	}
	
	/**
	 * Registra um aluno que respondeu quest�es no quadro. 
	 * Caso seja passada uma matr�cula que n�o exista no controle ou o aluno j� esteja registrado, mensagens de erro s�o exibidas.
	 * 
	 * @param matricula : matr�cula do aluno.
	 * 
	 * @return : retorna uma String indicando o sucesso/fracasso na opera��o.
	 */
	public String registrarAlunoQueRespondeu(String matricula) {
		if(alunos.containsKey(matricula)) {
			if(registro.contains(alunos.get(matricula))) {
				return "Aluno j� registrado." + System.lineSeparator();
			}
			else {
				registro.add(alunos.get(matricula));
				return "ALUNO REGISTRADO!" + System.lineSeparator();
			}
		}
		else {
			return "Aluno n�o cadastrado." + System.lineSeparator();
		}
	}
	
	/**
	 * Imprime o registro de alunos que responderam a quest�es no quadro.
	 * 
	 * @return : String que representa o registro de alunos que responderam quest�es no quadro.
	 */
	public String imprimirRegistroDeAlunos() {
		if(registro.isEmpty()) {
			return "O registro est� vazio!" + System.lineSeparator();
		}
		else {
			String saida = "";
			saida += "\nAlunos:\n";
			for(int i = 0; i < registro.size(); i++) {
				saida += i+1 + ". " + registro.get(i);
			}
			return saida;
		}
		
	}

}
