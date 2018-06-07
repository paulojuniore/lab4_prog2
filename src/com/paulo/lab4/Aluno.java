package com.paulo.lab4;

/**
 * Representa um aluno.
 * Todo aluno possui uma matricula, nome, curso e grupos de estudo associados.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
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
	 * Constrói um Aluno, que possui como parâmetros: matricula, nome e o curso do aluno.
	 * 
	 * @param matricula : matrícula do aluno.
	 * @param nome : nome do aluno.
	 * @param curso : curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {	
		if(matricula == null || nome == null || curso == null)
			throw new NullPointerException("Dados inválidos.");
		if(matricula.trim().isEmpty())
			throw new IllegalArgumentException("Matrícula inválida.");
		if(nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome inválido.");
		if(curso.trim().isEmpty())
			throw new IllegalArgumentException("Curso inválido.");
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Retorna matrícula do aluno selecionado.
	 * 
	 * @return : matrícula do aluno.
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
	 * Representação String de um Aluno. Formato: (MATRICULA - NOME - CURSO)
	 * 
	 * @return : representação String de um aluno.
	 */
	public String toString() {
		return matricula + " - " + nome + " - " + curso + System.lineSeparator();
	}
	
	/**
	 * Gera um identificar único para cada item inserido na coleção HashSet, através do Hashing.
	 * 
	 * @return : identificador único para cada elemento de uma Coleção..
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
	/**
	 * Compara se dois objetos do tipo Aluno são iguais. Dois objetos Aluno são iguais se, e somente se, suas matrículas forem iguais.
	 * 
	 * @return : boolean que representa se os dois objetos Aluno tem matrículas iguais.
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
