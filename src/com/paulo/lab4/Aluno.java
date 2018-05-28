package com.paulo.lab4;

import java.util.HashSet;

/**
 * Representa um aluno.
 * Todo aluno possui uma matricula, nome, curso e grupos de estudo associados.
 * 
 * @author Paulo Mendes da Silva J�nior - 117210922
 *
 */

public class Aluno {
	
	/**
	 * Representa a matricula de um aluno no formato String.
	 */
	private String matricula;
	
	/**
	 * Representa o nome de um aluno no formato String.
	 */
	private String nome;
	
	/**
	 * Representa o curso de um aluno no formato String.
	 */
	private String curso;
	
	/**
	 * Representa um conjunto de grupos que um aluno pode ter, no formato de uma cole��o Set.
	 */
	private HashSet<Grupo> grupos = new HashSet<>();
	
	
	/**
	 * Constr�i um Aluno, que possui como par�metos, a matricula, o nome e o curso do aluno.
	 * 
	 * @param matricula : matr�cula do aluno.
	 * @param nome : nome do aluno.
	 * @param curso : curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {		
		if(matricula.trim().isEmpty())
			throw new IllegalArgumentException("Matr�cula inv�lida.");
		if(nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome inv�lido.");
		if(curso.trim().isEmpty())
			throw new IllegalArgumentException("Curso inv�lido.");
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Retorna matr�cula do aluno selecionado.
	 * 
	 * @return : matr�cula do aluno.
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Retorna o nome do aluno selecionado.
	 * 
	 * @return : nome do aluno.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna o curso do aluno selecionado.
	 * 
	 * @return : curso do aluno.
	 */
	public String getCurso() {
		return curso;
	}
	
	/**
	 * Representa��o String de um Aluno. Formato: (MATRICULA - NOME - CURSO)
	 * 
	 * @return : representa��o String de um aluno.
	 */
	public String toString() {
		return matricula + " - " + nome + " - " + curso + System.lineSeparator();
	}
	
	/**
	 * Gera um identificar �nico para cada item inserido na cole��o HashSet, atrav�s do Hashing.
	 * 
	 * @return : identificador �nico para cada elemento de uma cole��o.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
	/**
	 * Compara se dois objetos do tipo Aluno s�o iguais.
	 * 
	 * @return : boolean que representa se os dois objetos tem valores iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
