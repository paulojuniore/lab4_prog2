package com.paulo.lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Representa um sistema de Controle de Alunos, todo controle de alunos possui um conjuntos de alunos, outro conjunto
 * de grupos e uma lista de registros.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
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
	 * Lista sequencial que armazena todos os registros de alunos que responderam questões.
	 */
	private ArrayList<Aluno> registro = new ArrayList<>();
	
	
	/**
	 * Cadastra um aluno no Mapa de alunos caso todos seus dados sejam válidos, caso contrário, exceções são
	 * lançadas e tratadas.
	 * 
	 * @param matricula : matrícula do aluno.
	 * @param nome : nome do aluno.
	 * @param curso : curso ao qual pertence o aluno.
	 * 
	 * @return : indicação de sucesso/fracasso na operação.
	 * 
	 * @throws NullPointerException : Ocorre caso valores (null) sejam passados como argumentos do construtor de um Aluno.
	 * @throws IllegalArgumentException : Ocorre caso valores inválidos sejam passados como argumentos. ex: String com espaços vazios representando a matrícula.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) throws NullPointerException, IllegalArgumentException  {
		if(alunos.containsKey(matricula)) {
			return "MATRÍCULA JÁ CADASTRADA!" + System.lineSeparator();
		}
		else {
			Aluno aluno = new Aluno(matricula, nome, curso);
			alunos.put(matricula, aluno);
			return "CADASTRO REALIZADO!" + System.lineSeparator();
		}
	}
	
	/**
	 * Retorna um aluno contido no Mapa de alunos a partir de sua matrícula.
	 * Caso não exista um aluno de tal matrícula, uma mensagem de erro é exibida. 
	 * 
	 * @param matricula : matrícula do aluno.
	 * 
	 * @return : uma representação String do aluno, contendo matrícula, nome e curso.
	 */
	public String exibirAluno(String matricula) {
		if(alunos.containsKey(matricula)) {
			return alunos.get(matricula).toString();
		}
		else {
			return "Aluno não cadastrado." + System.lineSeparator();
		}
	}
	
	/**
	 * Cadastra um novo grupo. Caso um nome de grupo ja esteja cadastrado, é exibida uma notificação do erro.
	 * 
	 * @param nomeDoGrupo : tema do grupo.
	 * 
	 * @return : uma String que representa se a operação foi bem/mal sucedida.
	 * 
	 * @throws NullPointerException : Ocorre caso valores (null) sejam passados como argumentos ao construtor de um Grupo.
	 * @throws IllegalArgumentException : Ocorre caso um valor inválido seja passado como argumento. ex: String com espaços vazios representando o tema do grupo.  
	 */
	public String cadastrarGrupo(String nomeDoGrupo) throws NullPointerException, IllegalArgumentException {
		if(grupos.containsKey(nomeDoGrupo.toLowerCase())) {
			return "GRUPO JÁ CADASTRADO!" + System.lineSeparator();
		}
		else {
			Grupo grupo = new Grupo(nomeDoGrupo);
			grupos.put(nomeDoGrupo.toLowerCase(), grupo);
			return "CADASTRO REALIZADO!" + System.lineSeparator();
		}		
	}
	
	/**
	 * Aloca um aluno já existente em um grupo já existente. Caso sejam passados matrículas e/ou nomes de grupos
	 * que não existem, uma mensagem informando o erro é exibida.
	 * 
	 * @param matricula : matrícula do aluno a ser alocado.
	 * @param grupo : nome do grupo em que o aluno de matrícula passada será inserido.
	 * 
	 * @return : retorna uma mensagem indicando o sucesso/fracasso na operação.
	 */
	public String alocarAlunoEmGrupo(String matricula, String grupo) {
		if(!alunos.containsKey(matricula)) {
			return "Aluno não cadastrado!" + System.lineSeparator();
		}
		else if(!grupos.containsKey(grupo.toLowerCase())) {
			return "Grupo não cadastrado!" + System.lineSeparator();
		}
		else {
			Grupo g = grupos.get(grupo);
			Aluno a = alunos.get(matricula);
			g.adicionaAluno(a);
			return "ALUNO ALOCADO!" + System.lineSeparator();
		}
	}
	
	/**
	 * Imprime uma lista de alunos cadastrados em um determinado grupo a partir do nome do grupo. 
	 * Caso o grupo não tenha sido cadastrado, uma mensagem de erro é exibida. 
	 * 
	 * @param nomeDoGrupo : nome do grupo.
	 * 
	 * @return : retorna a lista de alunos que est�o cadastrados em um grupo caso o nome do grupo já esteja cadastrado.
	 */
	public String imprimirAlunosDeGrupo(String nomeDoGrupo) {
		if(grupos.containsKey(nomeDoGrupo.toLowerCase())) {
			Grupo g = grupos.get(nomeDoGrupo.toLowerCase());		
			if(g.getAlunos().isEmpty()) {
				return "O grupo está vazio!" + System.lineSeparator();
			}
			else 
			{
				Iterator<Aluno> it = g.getAlunos().iterator();
				String saida = "";
				saida += "\nAlunos do grupo " + g.getTema() + ":\n";
				while(it.hasNext()) {
					saida += "* " + it.next();
				}
				return saida;
			}	
		}
		else {
			return "Grupo não cadastrado." + System.lineSeparator();
		}
	}
	
	/**
	 * Registra um aluno que respondeu questões no quadro. 
	 * Caso seja passada uma matrícula que não exista no controle ou o aluno já esteja registrado, mensagens de erro são exibidas.
	 * 
	 * @param matricula : matrícula do aluno.
	 * 
	 * @return : retorna uma String indicando o sucesso/fracasso na operação.
	 */
	public String registrarAlunoQueRespondeu(String matricula) {
		if(alunos.containsKey(matricula)) {
			if(registro.contains(alunos.get(matricula))) {
				return "Aluno já registrado." + System.lineSeparator();
			}
			else {
				registro.add(alunos.get(matricula));
				return "ALUNO REGISTRADO!" + System.lineSeparator();
			}
		}
		else {
			return "Aluno não cadastrado." + System.lineSeparator();
		}
	}
	
	/**
	 * Imprime o registro de Alunos que responderam a questões no quadro.
	 * 
	 * @return : String que representa o registro de alunos que responderam questões no quadro.
	 */
	public String imprimirRegistroDeAlunos() {
		if(registro.isEmpty()) {
			return "O registro está vazio!" + System.lineSeparator();
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
